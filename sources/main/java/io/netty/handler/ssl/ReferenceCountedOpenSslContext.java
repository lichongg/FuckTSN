package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.internal.tcnative.CertificateVerifier;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SSLPrivateKeyMethod;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.SignatureException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class ReferenceCountedOpenSslContext extends SslContext implements ReferenceCounted {
    private static final Integer DH_KEY_LENGTH;
    protected static final int VERIFY_DEPTH = 10;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile int bioNonApplicationBufferSize;
    final ClientAuth clientAuth;
    protected long ctx;
    final ReadWriteLock ctxLock;
    final boolean enableOcsp;
    final OpenSslEngineMap engineMap;
    final Certificate[] keyCertChain;
    private final ResourceLeakTracker<ReferenceCountedOpenSslContext> leak;
    private final int mode;
    final String[] protocols;
    private final AbstractReferenceCounted refCnt;
    private final long sessionCacheSize;
    private final long sessionTimeout;
    private final List<String> unmodifiableCiphers;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslContext.class);
    private static final int DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE = ((Integer) AccessController.doPrivileged(new PrivilegedAction<Integer>() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.security.PrivilegedAction
        public Integer run() {
            return Integer.valueOf(Math.max(1, SystemPropertyUtil.getInt("io.netty.handler.ssl.openssl.bioNonApplicationBufferSize", 2048)));
        }
    })).intValue();
    static final boolean USE_TASKS = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useTasks", false);
    private static final ResourceLeakDetector<ReferenceCountedOpenSslContext> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslContext.class);
    static final OpenSslApplicationProtocolNegotiator NONE_PROTOCOL_NEGOTIATOR = new OpenSslApplicationProtocolNegotiator() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.3
        @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.Protocol protocol() {
            return ApplicationProtocolConfig.Protocol.NONE;
        }

        @Override // io.netty.handler.ssl.ApplicationProtocolNegotiator
        public List<String> protocols() {
            return Collections.EMPTY_LIST;
        }

        @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
            return ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
        }

        @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior() {
            return ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DefaultOpenSslEngineMap implements OpenSslEngineMap {
        private final Map<Long, ReferenceCountedOpenSslEngine> engines;

        private DefaultOpenSslEngineMap() {
            this.engines = PlatformDependent.newConcurrentHashMap();
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public void add(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) {
            this.engines.put(Long.valueOf(referenceCountedOpenSslEngine.sslPointer()), referenceCountedOpenSslEngine);
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine get(long j6) {
            return this.engines.get(Long.valueOf(j6));
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine remove(long j6) {
            return this.engines.remove(Long.valueOf(j6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class PrivateKeyMethod implements SSLPrivateKeyMethod {
        private final OpenSslEngineMap engineMap;
        private final OpenSslPrivateKeyMethod keyMethod;

        private ReferenceCountedOpenSslEngine retrieveEngine(long j6) throws SSLException {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j6);
            if (referenceCountedOpenSslEngine != null) {
                return referenceCountedOpenSslEngine;
            }
            throw new SSLException("Could not find a " + StringUtil.simpleClassName((Class<?>) ReferenceCountedOpenSslEngine.class) + " for sslPointer " + j6);
        }

        private static byte[] verifyResult(byte[] bArr) throws SignatureException {
            if (bArr != null) {
                return bArr;
            }
            throw new SignatureException();
        }

        PrivateKeyMethod(OpenSslEngineMap openSslEngineMap, OpenSslPrivateKeyMethod openSslPrivateKeyMethod) {
            this.engineMap = openSslEngineMap;
            this.keyMethod = openSslPrivateKeyMethod;
        }

        public byte[] decrypt(long j6, byte[] bArr) throws Exception {
            ReferenceCountedOpenSslEngine retrieveEngine = retrieveEngine(j6);
            try {
                return verifyResult(this.keyMethod.decrypt(retrieveEngine, bArr));
            } catch (Exception e6) {
                retrieveEngine.initHandshakeException(e6);
                throw e6;
            }
        }

        public byte[] sign(long j6, int i6, byte[] bArr) throws Exception {
            ReferenceCountedOpenSslEngine retrieveEngine = retrieveEngine(j6);
            try {
                return verifyResult(this.keyMethod.sign(retrieveEngine, i6, bArr));
            } catch (Exception e6) {
                retrieveEngine.initHandshakeException(e6);
                throw e6;
            }
        }
    }

    ReferenceCountedOpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7, int i6, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z5, boolean z6, boolean z7) throws SSLException {
        this(iterable, cipherSuiteFilter, toNegotiator(applicationProtocolConfig), j6, j7, i6, certificateArr, clientAuth, strArr, z5, z6, z7);
    }

    protected static X509Certificate[] certificates(byte[][] bArr) {
        int length = bArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i6 = 0; i6 < length; i6++) {
            x509CertificateArr[i6] = new OpenSslX509Certificate(bArr[i6]);
        }
        return x509CertificateArr;
    }

    protected static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return PlatformDependent.javaVersion() >= 7 ? OpenSslX509TrustManagerWrapper.wrapIfNeeded((X509TrustManager) trustManager) : (X509TrustManager) trustManager;
            }
        }
        throw new IllegalStateException("no X509TrustManager found");
    }

    protected static X509KeyManager chooseX509KeyManager(KeyManager[] keyManagerArr) {
        for (KeyManager keyManager : keyManagerArr) {
            if (keyManager instanceof X509KeyManager) {
                return (X509KeyManager) keyManager;
            }
        }
        throw new IllegalStateException("no X509KeyManager found");
    }

    static long toBIO(ByteBufAllocator byteBufAllocator, PrivateKey privateKey) throws Exception {
        if (privateKey == null) {
            return 0L;
        }
        PemEncoded pem = PemPrivateKey.toPEM(byteBufAllocator, true, privateKey);
        try {
            return toBIO(byteBufAllocator, pem.retain());
        } finally {
            pem.release();
        }
    }

    @Deprecated
    public boolean getRejectRemoteInitiatedRenegotiation() {
        return true;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i6) {
        return newEngine0(byteBufAllocator, str, i6, true);
    }

    @Override // io.netty.handler.ssl.SslContext
    protected final SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z5) {
        return new SslHandler(newEngine0(byteBufAllocator, null, -1, false), z5);
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release() {
        return this.refCnt.release();
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain() {
        this.refCnt.retain();
        return this;
    }

    @Override // io.netty.handler.ssl.SslContext
    public abstract OpenSslSessionContext sessionContext();

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.SelectedListenerFailureBehavior.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior = iArr;
            try {
                iArr[ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ApplicationProtocolConfig.SelectorFailureBehavior.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior = iArr2;
            try {
                iArr2[ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[ApplicationProtocolConfig.Protocol.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol = iArr3;
            try {
                iArr3[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class AbstractCertificateVerifier extends CertificateVerifier {
        private final OpenSslEngineMap engineMap;

        public final int verify(long j6, byte[][] bArr, String str) {
            CertPathValidatorException.Reason reason;
            CertPathValidatorException.BasicReason basicReason;
            CertPathValidatorException.BasicReason basicReason2;
            CertPathValidatorException.BasicReason basicReason3;
            X509Certificate[] certificates = ReferenceCountedOpenSslContext.certificates(bArr);
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j6);
            try {
                verify(referenceCountedOpenSslEngine, certificates, str);
                return CertificateVerifier.X509_V_OK;
            } catch (Throwable th) {
                ReferenceCountedOpenSslContext.logger.debug("verification of certificate failed", (Throwable) th);
                referenceCountedOpenSslEngine.initHandshakeException(th);
                if (th instanceof OpenSslCertificateException) {
                    return th.errorCode();
                }
                if (th instanceof CertificateExpiredException) {
                    return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                }
                if (th instanceof CertificateNotYetValidException) {
                    return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
                }
                if (PlatformDependent.javaVersion() >= 7) {
                    if (a0.a(th)) {
                        return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
                    }
                    for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                        if (cause instanceof CertPathValidatorException) {
                            reason = ((CertPathValidatorException) cause).getReason();
                            basicReason = CertPathValidatorException.BasicReason.EXPIRED;
                            if (reason == basicReason) {
                                return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                            }
                            basicReason2 = CertPathValidatorException.BasicReason.NOT_YET_VALID;
                            if (reason == basicReason2) {
                                return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
                            }
                            basicReason3 = CertPathValidatorException.BasicReason.REVOKED;
                            if (reason == basicReason3) {
                                return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
                            }
                        }
                    }
                }
                return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
        }

        abstract void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception;

        AbstractCertificateVerifier(OpenSslEngineMap openSslEngineMap) {
            this.engineMap = openSslEngineMap;
        }
    }

    static {
        Integer num = null;
        try {
            String str = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.4
                @Override // java.security.PrivilegedAction
                public String run() {
                    return SystemPropertyUtil.get("jdk.tls.ephemeralDHKeySize");
                }
            });
            if (str != null) {
                try {
                    num = Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    logger.debug("ReferenceCountedOpenSslContext supports -Djdk.tls.ephemeralDHKeySize={int}, but got: " + str);
                }
            }
        } catch (Throwable unused2) {
        }
        DH_KEY_LENGTH = num;
    }

    ReferenceCountedOpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j6, long j7, int i6, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z5, boolean z6, boolean z7) throws SSLException {
        super(z5);
        this.refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.2
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.AbstractReferenceCounted
            protected void deallocate() {
                ReferenceCountedOpenSslContext.this.destroy();
                if (ReferenceCountedOpenSslContext.this.leak != null) {
                    ReferenceCountedOpenSslContext.this.leak.close(ReferenceCountedOpenSslContext.this);
                }
            }

            @Override // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object obj) {
                if (ReferenceCountedOpenSslContext.this.leak != null) {
                    ReferenceCountedOpenSslContext.this.leak.record(obj);
                }
                return ReferenceCountedOpenSslContext.this;
            }
        };
        this.engineMap = new DefaultOpenSslEngineMap();
        this.ctxLock = new ReentrantReadWriteLock();
        this.bioNonApplicationBufferSize = DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE;
        OpenSsl.ensureAvailability();
        if (z6 && !OpenSsl.isOcspSupported()) {
            throw new IllegalStateException("OCSP is not supported.");
        }
        if (i6 != 1 && i6 != 0) {
            throw new IllegalArgumentException("mode most be either SSL.SSL_MODE_SERVER or SSL.SSL_MODE_CLIENT");
        }
        this.leak = z7 ? leakDetector.track(this) : null;
        this.mode = i6;
        this.clientAuth = isServer() ? (ClientAuth) ObjectUtil.checkNotNull(clientAuth, "clientAuth") : ClientAuth.NONE;
        this.protocols = strArr;
        this.enableOcsp = z6;
        this.keyCertChain = certificateArr != null ? (Certificate[]) certificateArr.clone() : null;
        List<String> asList = Arrays.asList(((CipherSuiteFilter) ObjectUtil.checkNotNull(cipherSuiteFilter, "cipherFilter")).filterCipherSuites(iterable, OpenSsl.DEFAULT_CIPHERS, OpenSsl.availableJavaCipherSuites()));
        this.unmodifiableCiphers = asList;
        this.apn = (OpenSslApplicationProtocolNegotiator) ObjectUtil.checkNotNull(openSslApplicationProtocolNegotiator, "apn");
        try {
            try {
                this.ctx = SSLContext.make(OpenSsl.isTlsv13Supported() ? 62 : 30, i6);
                boolean isTlsv13Supported = OpenSsl.isTlsv13Supported();
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                try {
                    try {
                        if (asList.isEmpty()) {
                            SSLContext.setCipherSuite(this.ctx, "", false);
                            if (isTlsv13Supported) {
                                SSLContext.setCipherSuite(this.ctx, "", true);
                            }
                        } else {
                            CipherSuiteConverter.convertToCipherStrings(asList, sb, sb2, OpenSsl.isBoringSSL());
                            SSLContext.setCipherSuite(this.ctx, sb.toString(), false);
                            if (isTlsv13Supported) {
                                SSLContext.setCipherSuite(this.ctx, sb2.toString(), true);
                            }
                        }
                        int options = SSLContext.getOptions(this.ctx) | SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1_3 | SSL.SSL_OP_CIPHER_SERVER_PREFERENCE | SSL.SSL_OP_NO_COMPRESSION | SSL.SSL_OP_NO_TICKET;
                        SSLContext.setOptions(this.ctx, sb.length() == 0 ? options | SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 : options);
                        long j8 = this.ctx;
                        SSLContext.setMode(j8, SSLContext.getMode(j8) | SSL.SSL_MODE_ACCEPT_MOVING_WRITE_BUFFER);
                        Integer num = DH_KEY_LENGTH;
                        if (num != null) {
                            SSLContext.setTmpDHLength(this.ctx, num.intValue());
                        }
                        List<String> protocols = openSslApplicationProtocolNegotiator.protocols();
                        if (!protocols.isEmpty()) {
                            String[] strArr2 = (String[]) protocols.toArray(new String[0]);
                            int opensslSelectorFailureBehavior = opensslSelectorFailureBehavior(openSslApplicationProtocolNegotiator.selectorFailureBehavior());
                            int i7 = AnonymousClass5.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[openSslApplicationProtocolNegotiator.protocol().ordinal()];
                            if (i7 == 1) {
                                SSLContext.setNpnProtos(this.ctx, strArr2, opensslSelectorFailureBehavior);
                            } else if (i7 == 2) {
                                SSLContext.setAlpnProtos(this.ctx, strArr2, opensslSelectorFailureBehavior);
                            } else {
                                if (i7 != 3) {
                                    throw new Error();
                                }
                                SSLContext.setNpnProtos(this.ctx, strArr2, opensslSelectorFailureBehavior);
                                SSLContext.setAlpnProtos(this.ctx, strArr2, opensslSelectorFailureBehavior);
                            }
                        }
                        long sessionCacheSize = j6 <= 0 ? SSLContext.setSessionCacheSize(this.ctx, 20480L) : j6;
                        this.sessionCacheSize = sessionCacheSize;
                        SSLContext.setSessionCacheSize(this.ctx, sessionCacheSize);
                        long sessionCacheTimeout = j7 <= 0 ? SSLContext.setSessionCacheTimeout(this.ctx, 300L) : j7;
                        this.sessionTimeout = sessionCacheTimeout;
                        SSLContext.setSessionCacheTimeout(this.ctx, sessionCacheTimeout);
                        if (z6) {
                            SSLContext.enableOcsp(this.ctx, isClient());
                        }
                        SSLContext.setUseTasks(this.ctx, USE_TASKS);
                    } catch (Exception e6) {
                        throw new SSLException("failed to set cipher suite: " + this.unmodifiableCiphers, e6);
                    }
                } catch (SSLException e7) {
                    throw e7;
                }
            } catch (Exception e8) {
                throw new SSLException("failed to create an SSL_CTX", e8);
            }
        } catch (Throwable th) {
            release();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() {
        Lock writeLock = this.ctxLock.writeLock();
        writeLock.lock();
        try {
            long j6 = this.ctx;
            if (j6 != 0) {
                if (this.enableOcsp) {
                    SSLContext.disableOcsp(j6);
                }
                SSLContext.free(this.ctx);
                this.ctx = 0L;
                OpenSslSessionContext sessionContext = sessionContext();
                if (sessionContext != null) {
                    sessionContext.destroy();
                }
            }
            writeLock.unlock();
        } catch (Throwable th) {
            writeLock.unlock();
            throw th;
        }
    }

    static void freeBio(long j6) {
        if (j6 != 0) {
            SSL.freeBIO(j6);
        }
    }

    private static int opensslSelectorFailureBehavior(ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior) {
        int i6 = AnonymousClass5.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[selectorFailureBehavior.ordinal()];
        if (i6 == 1) {
            return 0;
        }
        if (i6 == 2) {
            return 1;
        }
        throw new Error();
    }

    static OpenSslKeyMaterialProvider providerFor(KeyManagerFactory keyManagerFactory, String str) {
        if (keyManagerFactory instanceof OpenSslX509KeyManagerFactory) {
            return ((OpenSslX509KeyManagerFactory) keyManagerFactory).newProvider();
        }
        X509KeyManager chooseX509KeyManager = chooseX509KeyManager(keyManagerFactory.getKeyManagers());
        return keyManagerFactory instanceof OpenSslCachingX509KeyManagerFactory ? new OpenSslCachingKeyMaterialProvider(chooseX509KeyManager, str) : new OpenSslKeyMaterialProvider(chooseX509KeyManager, str);
    }

    static void setKeyMaterial(long j6, X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str) throws SSLException {
        long j7;
        long j8;
        long j9;
        long j10 = 0;
        PemEncoded pemEncoded = null;
        try {
            try {
                ByteBufAllocator byteBufAllocator = ByteBufAllocator.DEFAULT;
                pemEncoded = PemX509Certificate.toPEM(byteBufAllocator, true, x509CertificateArr);
                j7 = toBIO(byteBufAllocator, pemEncoded.retain());
                try {
                    j8 = toBIO(byteBufAllocator, pemEncoded.retain());
                    if (privateKey != null) {
                        try {
                            j10 = toBIO(byteBufAllocator, privateKey);
                        } catch (SSLException e6) {
                            throw e6;
                        } catch (Exception e7) {
                            e = e7;
                            throw new SSLException("failed to set certificate and key", e);
                        }
                    }
                    j9 = j10;
                } catch (SSLException e8) {
                    throw e8;
                } catch (Exception e9) {
                    e = e9;
                } catch (Throwable th) {
                    th = th;
                    j8 = 0;
                }
            } catch (SSLException e10) {
                throw e10;
            } catch (Exception e11) {
                e = e11;
            } catch (Throwable th2) {
                th = th2;
                j7 = 0;
                j8 = 0;
            }
            try {
                SSLContext.setCertificateBio(j6, j7, j9, str == null ? "" : str);
                SSLContext.setCertificateChainBio(j6, j8, true);
                freeBio(j9);
                freeBio(j7);
                freeBio(j8);
                pemEncoded.release();
            } catch (SSLException e12) {
                throw e12;
            } catch (Exception e13) {
                e = e13;
                throw new SSLException("failed to set certificate and key", e);
            } catch (Throwable th3) {
                th = th3;
                j10 = j9;
                freeBio(j10);
                freeBio(j7);
                freeBio(j8);
                if (pemEncoded != null) {
                    pemEncoded.release();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    static OpenSslApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig applicationProtocolConfig) {
        if (applicationProtocolConfig == null) {
            return NONE_PROTOCOL_NEGOTIATOR;
        }
        int i6 = AnonymousClass5.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[applicationProtocolConfig.protocol().ordinal()];
        if (i6 != 1 && i6 != 2 && i6 != 3) {
            if (i6 == 4) {
                return NONE_PROTOCOL_NEGOTIATOR;
            }
            throw new Error();
        }
        int i7 = AnonymousClass5.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
        if (i7 != 1 && i7 != 2) {
            throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " behavior");
        }
        int i8 = AnonymousClass5.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
        if (i8 == 1 || i8 == 2) {
            return new OpenSslDefaultApplicationProtocolNegotiator(applicationProtocolConfig);
        }
        throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " behavior");
    }

    @Override // io.netty.handler.ssl.SslContext
    public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final List<String> cipherSuites() {
        return this.unmodifiableCiphers;
    }

    public int getBioNonApplicationBufferSize() {
        return this.bioNonApplicationBufferSize;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.mode == 0;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        return newEngine(byteBufAllocator, null, -1);
    }

    SSLEngine newEngine0(ByteBufAllocator byteBufAllocator, String str, int i6, boolean z5) {
        return new ReferenceCountedOpenSslEngine(this, byteBufAllocator, str, i6, z5, true);
    }

    @Override // io.netty.handler.ssl.SslContext
    protected final SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i6, boolean z5) {
        return new SslHandler(newEngine0(byteBufAllocator, str, i6, false), z5);
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.refCnt.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i6) {
        return this.refCnt.release(i6);
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain(int i6) {
        this.refCnt.retain(i6);
        return this;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final long sessionCacheSize() {
        return this.sessionCacheSize;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final long sessionTimeout() {
        return this.sessionTimeout;
    }

    public void setBioNonApplicationBufferSize(int i6) {
        this.bioNonApplicationBufferSize = ObjectUtil.checkPositiveOrZero(i6, "bioNonApplicationBufferSize");
    }

    public final void setPrivateKeyMethod(OpenSslPrivateKeyMethod openSslPrivateKeyMethod) {
        ObjectUtil.checkNotNull(openSslPrivateKeyMethod, "method");
        Lock writeLock = this.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.setPrivateKeyMethod(this.ctx, new PrivateKeyMethod(this.engineMap, openSslPrivateKeyMethod));
        } finally {
            writeLock.unlock();
        }
    }

    @Deprecated
    public void setRejectRemoteInitiatedRenegotiation(boolean z5) {
        if (!z5) {
            throw new UnsupportedOperationException("Renegotiation is not supported");
        }
    }

    @Deprecated
    public final long sslCtxPointer() {
        Lock readLock = this.ctxLock.readLock();
        readLock.lock();
        try {
            return SSLContext.getSslCtx(this.ctx);
        } finally {
            readLock.unlock();
        }
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch(Object obj) {
        this.refCnt.touch(obj);
        return this;
    }

    private static long newBIO(ByteBuf byteBuf) throws Exception {
        try {
            long newMemBIO = SSL.newMemBIO();
            int readableBytes = byteBuf.readableBytes();
            if (SSL.bioWrite(newMemBIO, OpenSsl.memoryAddress(byteBuf) + byteBuf.readerIndex(), readableBytes) == readableBytes) {
                return newMemBIO;
            }
            SSL.freeBIO(newMemBIO);
            throw new IllegalStateException("Could not write data to memory BIO");
        } finally {
            byteBuf.release();
        }
    }

    static boolean useExtendedTrustManager(X509TrustManager x509TrustManager) {
        if (PlatformDependent.javaVersion() >= 7 && y.a(x509TrustManager)) {
            return true;
        }
        return false;
    }

    @Deprecated
    public final long context() {
        return sslCtxPointer();
    }

    @Override // io.netty.handler.ssl.SslContext
    protected SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z5, Executor executor) {
        return new SslHandler(newEngine0(byteBufAllocator, null, -1, false), z5, executor);
    }

    @Deprecated
    public final void setTicketKeys(byte[] bArr) {
        sessionContext().setTicketKeys(bArr);
    }

    @Deprecated
    public final OpenSslSessionStats stats() {
        return sessionContext().stats();
    }

    @Override // io.netty.handler.ssl.SslContext
    protected SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i6, boolean z5, Executor executor) {
        return new SslHandler(newEngine0(byteBufAllocator, str, i6, false), executor);
    }

    static long toBIO(ByteBufAllocator byteBufAllocator, X509Certificate... x509CertificateArr) throws Exception {
        if (x509CertificateArr == null) {
            return 0L;
        }
        if (x509CertificateArr.length != 0) {
            PemEncoded pem = PemX509Certificate.toPEM(byteBufAllocator, true, x509CertificateArr);
            try {
                return toBIO(byteBufAllocator, pem.retain());
            } finally {
                pem.release();
            }
        }
        throw new IllegalArgumentException("certChain can't be empty");
    }

    static long toBIO(ByteBufAllocator byteBufAllocator, PemEncoded pemEncoded) throws Exception {
        try {
            ByteBuf content = pemEncoded.content();
            if (content.isDirect()) {
                return newBIO(content.retainedSlice());
            }
            ByteBuf directBuffer = byteBufAllocator.directBuffer(content.readableBytes());
            try {
                directBuffer.writeBytes(content, content.readerIndex(), content.readableBytes());
                long newBIO = newBIO(directBuffer.retainedSlice());
                try {
                    if (pemEncoded.isSensitive()) {
                        SslUtils.zeroout(directBuffer);
                    }
                    return newBIO;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (pemEncoded.isSensitive()) {
                        SslUtils.zeroout(directBuffer);
                    }
                    throw th;
                } finally {
                }
            }
        } finally {
            pemEncoded.release();
        }
    }
}
