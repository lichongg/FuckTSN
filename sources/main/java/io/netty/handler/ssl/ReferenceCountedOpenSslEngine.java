package io.netty.handler.ssl;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.security.AlgorithmConstraints;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.Lock;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ReferenceCountedOpenSslEngine extends SSLEngine implements ReferenceCounted, ApplicationProtocolAccessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING;
    private static final SSLEngineResult NEED_UNWRAP_CLOSED;
    private static final SSLEngineResult NEED_UNWRAP_OK;
    private static final SSLEngineResult NEED_WRAP_CLOSED;
    private static final SSLEngineResult NEED_WRAP_OK;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV2 = 0;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV3 = 1;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1 = 2;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_1 = 3;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_2 = 4;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_3 = 5;
    private Object algorithmConstraints;
    final ByteBufAllocator alloc;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile String applicationProtocol;
    private volatile ClientAuth clientAuth;
    private final boolean clientMode;
    private volatile int destroyed;
    private final boolean enableOcsp;
    private String endPointIdentificationAlgorithm;
    private final OpenSslEngineMap engineMap;
    private Throwable handshakeException;
    private HandshakeState handshakeState;
    private boolean isInboundDone;
    final boolean jdkCompatibilityMode;
    private volatile long lastAccessed;
    private final ResourceLeakTracker<ReferenceCountedOpenSslEngine> leak;
    private volatile Certificate[] localCertificateChain;
    private volatile Collection<?> matchers;
    private int maxWrapBufferSize;
    private int maxWrapOverhead;
    private volatile boolean needTask;
    private long networkBIO;
    private boolean outboundClosed;
    private boolean receivedShutdown;
    private final AbstractReferenceCounted refCnt;
    private final OpenSslSession session;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private List<String> sniHostNames;
    private long ssl;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslEngine.class);
    private static final ResourceLeakDetector<ReferenceCountedOpenSslEngine> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslEngine.class);
    private static final int[] OPENSSL_OP_NO_PROTOCOLS = {SSL.SSL_OP_NO_SSLv2, SSL.SSL_OP_NO_SSLv3, SSL.SSL_OP_NO_TLSv1, SSL.SSL_OP_NO_TLSv1_1, SSL.SSL_OP_NO_TLSv1_2, SSL.SSL_OP_NO_TLSv1_3};
    static final int MAX_PLAINTEXT_LENGTH = SSL.SSL_MAX_PLAINTEXT_LENGTH;
    private static final int MAX_RECORD_SIZE = SSL.SSL_MAX_RECORD_LENGTH;
    private static final AtomicIntegerFieldUpdater<ReferenceCountedOpenSslEngine> DESTROYED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ReferenceCountedOpenSslEngine.class, "destroyed");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class DefaultOpenSslSession implements OpenSslSession {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile int applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;
        private String cipher;
        private long creationTime;
        private byte[] id;
        private Certificate[] peerCerts;
        private String protocol;
        private final OpenSslSessionContext sessionContext;
        private Map<String, Object> values;
        private X509Certificate[] x509PeerCerts;

        private void initCerts(byte[][] bArr, int i6) {
            for (int i7 = 0; i7 < bArr.length; i7++) {
                int i8 = i6 + i7;
                this.peerCerts[i8] = new OpenSslX509Certificate(bArr[i7]);
                this.x509PeerCerts[i8] = new OpenSslJavaxX509Certificate(bArr[i7]);
            }
        }

        private void selectApplicationProtocol() throws SSLException {
            ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior = ReferenceCountedOpenSslEngine.this.apn.selectedListenerFailureBehavior();
            List<String> protocols = ReferenceCountedOpenSslEngine.this.apn.protocols();
            int i6 = AnonymousClass4.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ReferenceCountedOpenSslEngine.this.apn.protocol().ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    String alpnSelected = SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.ssl);
                    if (alpnSelected != null) {
                        ReferenceCountedOpenSslEngine.this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected);
                        return;
                    }
                    return;
                }
                if (i6 == 3) {
                    String nextProtoNegotiated = SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.ssl);
                    if (nextProtoNegotiated != null) {
                        ReferenceCountedOpenSslEngine.this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, nextProtoNegotiated);
                        return;
                    }
                    return;
                }
                if (i6 != 4) {
                    throw new Error();
                }
                String alpnSelected2 = SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.ssl);
                if (alpnSelected2 == null) {
                    alpnSelected2 = SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.ssl);
                }
                if (alpnSelected2 != null) {
                    ReferenceCountedOpenSslEngine.this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected2);
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public String[] getValueNames() {
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map != null && !map.isEmpty()) {
                        return (String[]) map.keySet().toArray(new String[0]);
                    }
                    return EmptyArrays.EMPTY_STRINGS;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        DefaultOpenSslSession(OpenSslSessionContext openSslSessionContext) {
            this.sessionContext = openSslSessionContext;
        }

        private void initPeerCerts() {
            byte[][] peerCertChain = SSL.getPeerCertChain(ReferenceCountedOpenSslEngine.this.ssl);
            if (ReferenceCountedOpenSslEngine.this.clientMode) {
                if (ReferenceCountedOpenSslEngine.isEmpty(peerCertChain)) {
                    this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                    this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                    return;
                } else {
                    this.peerCerts = new Certificate[peerCertChain.length];
                    this.x509PeerCerts = new X509Certificate[peerCertChain.length];
                    initCerts(peerCertChain, 0);
                    return;
                }
            }
            byte[] peerCertificate = SSL.getPeerCertificate(ReferenceCountedOpenSslEngine.this.ssl);
            if (ReferenceCountedOpenSslEngine.isEmpty(peerCertificate)) {
                this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
            } else {
                if (ReferenceCountedOpenSslEngine.isEmpty(peerCertChain)) {
                    this.peerCerts = new Certificate[]{new OpenSslX509Certificate(peerCertificate)};
                    this.x509PeerCerts = new X509Certificate[]{new OpenSslJavaxX509Certificate(peerCertificate)};
                    return;
                }
                Certificate[] certificateArr = new Certificate[peerCertChain.length + 1];
                this.peerCerts = certificateArr;
                this.x509PeerCerts = new X509Certificate[peerCertChain.length + 1];
                certificateArr[0] = new OpenSslX509Certificate(peerCertificate);
                this.x509PeerCerts[0] = new OpenSslJavaxX509Certificate(peerCertificate);
                initCerts(peerCertChain, 1);
            }
        }

        private SSLSessionBindingEvent newSSLSessionBindingEvent(String str) {
            return new SSLSessionBindingEvent(ReferenceCountedOpenSslEngine.this.session, str);
        }

        private void notifyUnbound(Object obj, String str) {
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueUnbound(newSSLSessionBindingEvent(str));
            }
        }

        @Override // javax.net.ssl.SSLSession
        public int getApplicationBufferSize() {
            return this.applicationBufferSize;
        }

        @Override // javax.net.ssl.SSLSession
        public String getCipherSuite() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    String str = this.cipher;
                    return str == null ? "SSL_NULL_WITH_NULL_NULL" : str;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public long getCreationTime() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (this.creationTime == 0 && !ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                        this.creationTime = SSL.getTime(ReferenceCountedOpenSslEngine.this.ssl) * 1000;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return this.creationTime;
        }

        @Override // javax.net.ssl.SSLSession
        public byte[] getId() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    byte[] bArr = this.id;
                    if (bArr == null) {
                        return EmptyArrays.EMPTY_BYTES;
                    }
                    return (byte[]) bArr.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            long j6 = ReferenceCountedOpenSslEngine.this.lastAccessed;
            return j6 == -1 ? getCreationTime() : j6;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            Certificate[] certificateArr = ReferenceCountedOpenSslEngine.this.localCertificateChain;
            if (certificateArr == null) {
                return null;
            }
            return (Certificate[]) certificateArr.clone();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            Certificate[] certificateArr = ReferenceCountedOpenSslEngine.this.localCertificateChain;
            if (certificateArr == null || certificateArr.length == 0) {
                return null;
            }
            return ((java.security.cert.X509Certificate) certificateArr[0]).getIssuerX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPacketBufferSize() {
            return ReferenceCountedOpenSslEngine.this.maxEncryptedPacketLength();
        }

        @Override // javax.net.ssl.SSLSession
        public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
            X509Certificate[] x509CertificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (ReferenceCountedOpenSslEngine.isEmpty(this.x509PeerCerts)) {
                        throw new SSLPeerUnverifiedException("peer not verified");
                    }
                    x509CertificateArr = (X509Certificate[]) this.x509PeerCerts.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return x509CertificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
            Certificate[] certificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (ReferenceCountedOpenSslEngine.isEmpty(this.peerCerts)) {
                        throw new SSLPeerUnverifiedException("peer not verified");
                    }
                    certificateArr = (Certificate[]) this.peerCerts.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return certificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public String getPeerHost() {
            return ReferenceCountedOpenSslEngine.this.getPeerHost();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPeerPort() {
            return ReferenceCountedOpenSslEngine.this.getPeerPort();
        }

        @Override // javax.net.ssl.SSLSession
        public String getProtocol() {
            String version;
            String str = this.protocol;
            if (str != null) {
                return str;
            }
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    version = !ReferenceCountedOpenSslEngine.this.isDestroyed() ? SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl) : "";
                } catch (Throwable th) {
                    throw th;
                }
            }
            return version;
        }

        @Override // javax.net.ssl.SSLSession
        public SSLSessionContext getSessionContext() {
            return this.sessionContext;
        }

        @Override // javax.net.ssl.SSLSession
        public Object getValue(String str) {
            if (str == null) {
                throw new NullPointerException(CommonNetImpl.NAME);
            }
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map == null) {
                        return null;
                    }
                    return map.get(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void handshakeFinished() throws SSLException {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                        throw new SSLException("Already closed");
                    }
                    this.id = SSL.getSessionId(ReferenceCountedOpenSslEngine.this.ssl);
                    ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = ReferenceCountedOpenSslEngine.this;
                    this.cipher = referenceCountedOpenSslEngine.toJavaCipherSuite(SSL.getCipherForSSL(referenceCountedOpenSslEngine.ssl));
                    this.protocol = SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl);
                    initPeerCerts();
                    selectApplicationProtocol();
                    ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead();
                    ReferenceCountedOpenSslEngine.this.handshakeState = HandshakeState.FINISHED;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public void invalidate() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                        SSL.setTimeout(ReferenceCountedOpenSslEngine.this.ssl, 0L);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public boolean isValid() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                        return false;
                    }
                    return System.currentTimeMillis() - (SSL.getTimeout(ReferenceCountedOpenSslEngine.this.ssl) * 1000) < SSL.getTime(ReferenceCountedOpenSslEngine.this.ssl) * 1000;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public void putValue(String str, Object obj) {
            Object put;
            if (str == null) {
                throw new NullPointerException(CommonNetImpl.NAME);
            }
            if (obj == null) {
                throw new NullPointerException("value");
            }
            synchronized (this) {
                try {
                    Map map = this.values;
                    if (map == null) {
                        map = new HashMap(2);
                        this.values = map;
                    }
                    put = map.put(str, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueBound(newSSLSessionBindingEvent(str));
            }
            notifyUnbound(put, str);
        }

        @Override // javax.net.ssl.SSLSession
        public void removeValue(String str) {
            if (str == null) {
                throw new NullPointerException(CommonNetImpl.NAME);
            }
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map == null) {
                        return;
                    }
                    notifyUnbound(map.remove(str), str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void tryExpandApplicationBufferSize(int i6) {
            if (i6 <= ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH || this.applicationBufferSize == ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE) {
                return;
            }
            this.applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE;
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
            return ((java.security.cert.X509Certificate) getPeerCertificates()[0]).getSubjectX500Principal();
        }

        private String selectApplicationProtocol(List<String> list, ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior, String str) throws SSLException {
            if (selectedListenerFailureBehavior != ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT) {
                int size = list.size();
                if (!list.contains(str)) {
                    if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL) {
                        return list.get(size - 1);
                    }
                    throw new SSLException("unknown protocol " + str);
                }
            }
            return str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum HandshakeState {
        NOT_STARTED,
        STARTED_IMPLICITLY,
        STARTED_EXPLICITLY,
        FINISHED
    }

    private void closeAll() throws SSLException {
        this.receivedShutdown = true;
        closeOutbound();
        closeInbound();
    }

    private boolean isBytesAvailableEnoughForWrap(int i6, int i7, int i8) {
        return ((long) i6) - (((long) this.maxWrapOverhead) * ((long) i8)) >= ((long) i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    private static boolean isProtocolEnabled(int i6, int i7, String str) {
        return (i6 & i7) == 0 && OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str);
    }

    private SSLEngineResult newResult(SSLEngineResult.HandshakeStatus handshakeStatus, int i6, int i7) {
        return newResult(SSLEngineResult.Status.OK, handshakeStatus, i6, i7);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus, int i6, int i7) throws SSLException {
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
        if (handshakeStatus != handshakeStatus2) {
            handshakeStatus2 = getHandshakeStatus();
        }
        return newResult(mayFinishHandshake(handshakeStatus2), i6, i7);
    }

    private SSLException shutdownWithError(String str, int i6) {
        return shutdownWithError(str, i6, SSL.getLastErrorNumber());
    }

    private static String toJavaCipherSuitePrefix(String str) {
        char c6 = 0;
        if (str != null && !str.isEmpty()) {
            c6 = str.charAt(0);
        }
        return c6 != 'S' ? c6 != 'T' ? "UNKNOWN" : org.apache.commons.net.imap.b.Q : "SSL";
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void beginHandshake() throws SSLException {
        try {
            int i6 = AnonymousClass4.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
            if (i6 == 1) {
                this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                if (handshake() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                    this.needTask = true;
                }
                calculateMaxWrapOverhead();
            } else {
                if (i6 == 2) {
                    throw new SSLException("renegotiation unsupported");
                }
                if (i6 == 3) {
                    checkEngineClosed();
                    this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                    calculateMaxWrapOverhead();
                } else if (i6 != 4) {
                    throw new Error();
                }
            }
        } finally {
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeInbound() throws SSLException {
        try {
            if (this.isInboundDone) {
                return;
            }
            this.isInboundDone = true;
            if (isOutboundDone()) {
                shutdown();
            }
            if (this.handshakeState != HandshakeState.NOT_STARTED && !this.receivedShutdown) {
                throw new SSLException("Inbound closed before receiving peer's close_notify: possible truncation attack?");
            }
        } finally {
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeOutbound() {
        try {
            if (this.outboundClosed) {
                return;
            }
            this.outboundClosed = true;
            if (this.handshakeState == HandshakeState.NOT_STARTED || isDestroyed()) {
                shutdown();
            } else if ((SSL.getShutdown(this.ssl) & SSL.SSL_SENT_SHUTDOWN) != SSL.SSL_SENT_SHUTDOWN) {
                doSSLShutdown();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized Runnable getDelegatedTask() {
        if (isDestroyed()) {
            return null;
        }
        final Runnable task = SSL.getTask(this.ssl);
        if (task == null) {
            return null;
        }
        return new Runnable() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.3
            @Override // java.lang.Runnable
            public void run() {
                if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    return;
                }
                try {
                    task.run();
                } finally {
                    ReferenceCountedOpenSslEngine.this.needTask = false;
                }
            }
        };
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getEnableSessionCreation() {
        return false;
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledCipherSuites() {
        synchronized (this) {
            if (isDestroyed()) {
                return EmptyArrays.EMPTY_STRINGS;
            }
            String[] ciphers = SSL.getCiphers(this.ssl);
            if (ciphers == null) {
                return EmptyArrays.EMPTY_STRINGS;
            }
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                for (int i6 = 0; i6 < ciphers.length; i6++) {
                    try {
                        String javaCipherSuite = toJavaCipherSuite(ciphers[i6]);
                        if (javaCipherSuite == null) {
                            javaCipherSuite = ciphers[i6];
                        }
                        if (OpenSsl.isTlsv13Supported() || !SslUtils.isTLSv13Cipher(javaCipherSuite)) {
                            arrayList.add(javaCipherSuite);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLSession getHandshakeSession() {
        int i6 = AnonymousClass4.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
        if (i6 == 1 || i6 == 2) {
            return null;
        }
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        if (!needPendingStatus()) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLParameters getSSLParameters() {
        SSLParameters sSLParameters;
        try {
            sSLParameters = super.getSSLParameters();
            int javaVersion = PlatformDependent.javaVersion();
            if (javaVersion >= 7) {
                sSLParameters.setEndpointIdentificationAlgorithm(this.endPointIdentificationAlgorithm);
                Java7SslParametersUtils.setAlgorithmConstraints(sSLParameters, this.algorithmConstraints);
                if (javaVersion >= 8) {
                    List<String> list = this.sniHostNames;
                    if (list != null) {
                        Java8SslUtils.setSniHostNames(sSLParameters, list);
                    }
                    if (!isDestroyed()) {
                        Java8SslUtils.setUseCipherSuitesOrder(sSLParameters, (SSL.getOptions(this.ssl) & SSL.SSL_OP_CIPHER_SERVER_PREFERENCE) != 0);
                    }
                    Java8SslUtils.setSNIMatchers(sSLParameters, this.matchers);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized boolean isInboundDone() {
        return this.isInboundDone;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
    
        if (io.netty.internal.tcnative.SSL.bioLengthNonApplication(r0) == 0) goto L12;
     */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean isOutboundDone() {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.outboundClosed     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L18
            long r0 = r5.networkBIO     // Catch: java.lang.Throwable -> L14
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L16
            int r0 = io.netty.internal.tcnative.SSL.bioLengthNonApplication(r0)     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L18
            goto L16
        L14:
            r0 = move-exception
            goto L1b
        L16:
            r0 = 1
            goto L19
        L18:
            r0 = 0
        L19:
            monitor-exit(r5)
            return r0
        L1b:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L14
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.isOutboundDone():boolean");
    }

    final synchronized int maxEncryptedPacketLength() {
        return maxEncryptedPacketLength0();
    }

    final synchronized int maxWrapOverhead() {
        return this.maxWrapOverhead;
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

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void setSSLParameters(SSLParameters sSLParameters) {
        AlgorithmConstraints algorithmConstraints;
        String endpointIdentificationAlgorithm;
        AlgorithmConstraints algorithmConstraints2;
        Collection<?> sNIMatchers;
        try {
            int javaVersion = PlatformDependent.javaVersion();
            if (javaVersion >= 7) {
                algorithmConstraints = sSLParameters.getAlgorithmConstraints();
                if (algorithmConstraints != null) {
                    throw new IllegalArgumentException("AlgorithmConstraints are not supported.");
                }
                if (javaVersion >= 8) {
                    if (!isDestroyed()) {
                        if (this.clientMode) {
                            List<String> sniHostNames = Java8SslUtils.getSniHostNames(sSLParameters);
                            Iterator<String> it = sniHostNames.iterator();
                            while (it.hasNext()) {
                                SSL.setTlsExtHostName(this.ssl, it.next());
                            }
                            this.sniHostNames = sniHostNames;
                        }
                        if (Java8SslUtils.getUseCipherSuitesOrder(sSLParameters)) {
                            SSL.setOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                        } else {
                            SSL.clearOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                        }
                    }
                    sNIMatchers = sSLParameters.getSNIMatchers();
                    this.matchers = sNIMatchers;
                }
                endpointIdentificationAlgorithm = sSLParameters.getEndpointIdentificationAlgorithm();
                boolean isEndPointVerificationEnabled = isEndPointVerificationEnabled(endpointIdentificationAlgorithm);
                if (this.clientMode && isEndPointVerificationEnabled) {
                    SSL.setVerify(this.ssl, 2, -1);
                }
                this.endPointIdentificationAlgorithm = endpointIdentificationAlgorithm;
                algorithmConstraints2 = sSLParameters.getAlgorithmConstraints();
                this.algorithmConstraints = algorithmConstraints2;
            }
            super.setSSLParameters(sSLParameters);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void setVerify(int i6, int i7) {
        SSL.setVerify(this.ssl, i6, i7);
    }

    public final synchronized void shutdown() {
        try {
            if (DESTROYED_UPDATER.compareAndSet(this, 0, 1)) {
                this.engineMap.remove(this.ssl);
                SSL.freeSSL(this.ssl);
                this.networkBIO = 0L;
                this.ssl = 0L;
                this.outboundClosed = true;
                this.isInboundDone = true;
            }
            SSL.clearError();
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized int sslPending() {
        return sslPending0();
    }

    public final synchronized long sslPointer() {
        return this.ssl;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x0214, code lost:
    
        if (r13 == null) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0216, code lost:
    
        r13.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0219, code lost:
    
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0296, code lost:
    
        io.netty.internal.tcnative.SSL.bioClearByteBuffer(r18.networkBIO);
        rejectRemoteInitiatedRenegotiation();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02a0, code lost:
    
        if (r18.receivedShutdown != false) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02ad, code lost:
    
        if ((io.netty.internal.tcnative.SSL.getShutdown(r18.ssl) & io.netty.internal.tcnative.SSL.SSL_RECEIVED_SHUTDOWN) != io.netty.internal.tcnative.SSL.SSL_RECEIVED_SHUTDOWN) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02af, code lost:
    
        closeAll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02b6, code lost:
    
        if (isInboundDone() == false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02b8, code lost:
    
        r0 = javax.net.ssl.SSLEngineResult.Status.CLOSED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02bd, code lost:
    
        r0 = newResultMayFinishHandshake(r0, r6, r9, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02c2, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02bb, code lost:
    
        r0 = javax.net.ssl.SSLEngineResult.Status.OK;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final javax.net.ssl.SSLEngineResult unwrap(java.nio.ByteBuffer[] r19, int r20, int r21, java.nio.ByteBuffer[] r22, int r23, int r24) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 840
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.unwrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer[], int, int):javax.net.ssl.SSLEngineResult");
    }

    /* JADX WARN: Code restructure failed: missing block: B:170:0x031a, code lost:
    
        r12 = newResultMayFinishHandshake(r3, r14, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x031e, code lost:
    
        io.netty.internal.tcnative.SSL.bioClearByteBuffer(r11.networkBIO);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0323, code lost:
    
        if (r1 != null) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0325, code lost:
    
        r13 = r15.position();
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x032f, code lost:
    
        r15.put(r1.internalNioBuffer(r1.readerIndex(), r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0450 A[Catch: all -> 0x0029, TryCatch #2 {all -> 0x0029, blocks: (B:11:0x0013, B:13:0x0019, B:15:0x001f, B:18:0x0026, B:19:0x002f, B:22:0x002d, B:34:0x008b, B:36:0x0092, B:37:0x00a7, B:39:0x009a, B:40:0x0127, B:44:0x00b7, B:46:0x00be, B:47:0x00ef, B:48:0x0100, B:50:0x00c3, B:51:0x00ce, B:55:0x00e4, B:57:0x00eb, B:58:0x00f4, B:62:0x010f, B:64:0x0116, B:65:0x0329, B:66:0x011c, B:239:0x0449, B:241:0x0450, B:244:0x0467, B:243:0x045f, B:77:0x0151, B:79:0x0158, B:80:0x015c, B:81:0x0162, B:85:0x0187, B:87:0x018e, B:88:0x0193, B:96:0x01bc, B:98:0x01c3, B:99:0x01c8, B:105:0x01e4, B:107:0x01eb, B:108:0x01f1, B:114:0x020c, B:116:0x0213, B:117:0x0219, B:144:0x027f, B:146:0x0286, B:147:0x0290, B:171:0x031e, B:173:0x0325, B:174:0x032f, B:190:0x0375, B:192:0x037c, B:193:0x0382, B:195:0x0395, B:197:0x039c, B:198:0x02e4, B:199:0x03a2, B:203:0x03b9, B:205:0x03c0, B:206:0x03c6, B:210:0x03dd, B:212:0x03e4, B:213:0x03ea, B:224:0x0411, B:226:0x0418, B:227:0x041e, B:233:0x02d9, B:235:0x02e0, B:236:0x02ea, B:247:0x042f, B:249:0x0436, B:250:0x043c), top: B:10:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x045f A[Catch: all -> 0x0029, TryCatch #2 {all -> 0x0029, blocks: (B:11:0x0013, B:13:0x0019, B:15:0x001f, B:18:0x0026, B:19:0x002f, B:22:0x002d, B:34:0x008b, B:36:0x0092, B:37:0x00a7, B:39:0x009a, B:40:0x0127, B:44:0x00b7, B:46:0x00be, B:47:0x00ef, B:48:0x0100, B:50:0x00c3, B:51:0x00ce, B:55:0x00e4, B:57:0x00eb, B:58:0x00f4, B:62:0x010f, B:64:0x0116, B:65:0x0329, B:66:0x011c, B:239:0x0449, B:241:0x0450, B:244:0x0467, B:243:0x045f, B:77:0x0151, B:79:0x0158, B:80:0x015c, B:81:0x0162, B:85:0x0187, B:87:0x018e, B:88:0x0193, B:96:0x01bc, B:98:0x01c3, B:99:0x01c8, B:105:0x01e4, B:107:0x01eb, B:108:0x01f1, B:114:0x020c, B:116:0x0213, B:117:0x0219, B:144:0x027f, B:146:0x0286, B:147:0x0290, B:171:0x031e, B:173:0x0325, B:174:0x032f, B:190:0x0375, B:192:0x037c, B:193:0x0382, B:195:0x0395, B:197:0x039c, B:198:0x02e4, B:199:0x03a2, B:203:0x03b9, B:205:0x03c0, B:206:0x03c6, B:210:0x03dd, B:212:0x03e4, B:213:0x03ea, B:224:0x0411, B:226:0x0418, B:227:0x041e, B:233:0x02d9, B:235:0x02e0, B:236:0x02ea, B:247:0x042f, B:249:0x0436, B:250:0x043c), top: B:10:0x0013 }] */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final javax.net.ssl.SSLEngineResult wrap(java.nio.ByteBuffer[] r12, int r13, int r14, java.nio.ByteBuffer r15) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 1197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.wrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer):javax.net.ssl.SSLEngineResult");
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ClientAuth;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.Protocol.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol = iArr;
            try {
                iArr[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ClientAuth.values().length];
            $SwitchMap$io$netty$handler$ssl$ClientAuth = iArr2;
            try {
                iArr2[ClientAuth.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.REQUIRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.OPTIONAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[HandshakeState.values().length];
            $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState = iArr3;
            try {
                iArr3[HandshakeState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.STARTED_IMPLICITLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.STARTED_EXPLICITLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        SSLEngineResult.Status status = SSLEngineResult.Status.OK;
        SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        NEED_UNWRAP_OK = new SSLEngineResult(status, handshakeStatus, 0, 0);
        SSLEngineResult.Status status2 = SSLEngineResult.Status.CLOSED;
        NEED_UNWRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus, 0, 0);
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
        NEED_WRAP_OK = new SSLEngineResult(status, handshakeStatus2, 0, 0);
        NEED_WRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus2, 0, 0);
        CLOSED_NOT_HANDSHAKING = new SSLEngineResult(status2, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateMaxWrapOverhead() {
        this.maxWrapOverhead = SSL.getMaxWrapOverhead(this.ssl);
        this.maxWrapBufferSize = this.jdkCompatibilityMode ? maxEncryptedPacketLength0() : maxEncryptedPacketLength0() << 4;
    }

    private boolean doSSLShutdown() {
        if (SSL.isInInit(this.ssl) != 0) {
            return false;
        }
        int shutdownSSL = SSL.shutdownSSL(this.ssl);
        if (shutdownSSL >= 0) {
            return true;
        }
        int error = SSL.getError(this.ssl, shutdownSSL);
        if (error != SSL.SSL_ERROR_SYSCALL && error != SSL.SSL_ERROR_SSL) {
            SSL.clearError();
            return true;
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            int lastErrorNumber = SSL.getLastErrorNumber();
            internalLogger.debug("SSL_shutdown failed: OpenSSL error: {} {}", Integer.valueOf(lastErrorNumber), SSL.getErrorString(lastErrorNumber));
        }
        shutdown();
        return false;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        if (this.handshakeState == HandshakeState.FINISHED) {
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        checkEngineClosed();
        if (this.handshakeException != null) {
            return handshakeException();
        }
        this.engineMap.add(this);
        if (this.lastAccessed == -1) {
            this.lastAccessed = System.currentTimeMillis();
        }
        int doHandshake = SSL.doHandshake(this.ssl);
        if (doHandshake > 0) {
            if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
            this.session.handshakeFinished();
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        int error = SSL.getError(this.ssl, doHandshake);
        if (error == SSL.SSL_ERROR_WANT_READ || error == SSL.SSL_ERROR_WANT_WRITE) {
            return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
        }
        if (error == SSL.SSL_ERROR_WANT_X509_LOOKUP || error == SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY || error == SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        if (this.handshakeException != null) {
            return handshakeException();
        }
        throw shutdownWithError("SSL_do_handshake", error);
    }

    private SSLEngineResult.HandshakeStatus handshakeException() throws SSLException {
        if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        Throwable th = this.handshakeException;
        this.handshakeException = null;
        shutdown();
        if (th instanceof SSLHandshakeException) {
            throw ((SSLHandshakeException) th);
        }
        SSLHandshakeException sSLHandshakeException = new SSLHandshakeException("General OpenSslEngine problem");
        sSLHandshakeException.initCause(th);
        throw sSLHandshakeException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDestroyed() {
        return this.destroyed != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    private static boolean isEndPointVerificationEnabled(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        return (handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || this.handshakeState == HandshakeState.FINISHED) ? handshakeStatus : handshake();
    }

    private boolean needPendingStatus() {
        if (this.handshakeState == HandshakeState.NOT_STARTED || isDestroyed()) {
            return false;
        }
        return this.handshakeState != HandshakeState.FINISHED || isInboundDone() || isOutboundDone();
    }

    private SSLEngineResult newResult(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i6, int i7) {
        if (!isOutboundDone()) {
            if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                this.needTask = true;
            }
            return new SSLEngineResult(status, handshakeStatus, i6, i7);
        }
        if (isInboundDone()) {
            handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            shutdown();
        }
        return new SSLEngineResult(SSLEngineResult.Status.CLOSED, handshakeStatus, i6, i7);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i6, int i7) throws SSLException {
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
        if (handshakeStatus != handshakeStatus2) {
            handshakeStatus2 = getHandshakeStatus();
        }
        return newResult(status, mayFinishHandshake(handshakeStatus2), i6, i7);
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i6) {
        return i6 > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    private void setClientAuth(ClientAuth clientAuth) {
        if (this.clientMode) {
            return;
        }
        synchronized (this) {
            try {
                if (this.clientAuth == clientAuth) {
                    return;
                }
                int i6 = AnonymousClass4.$SwitchMap$io$netty$handler$ssl$ClientAuth[clientAuth.ordinal()];
                if (i6 == 1) {
                    SSL.setVerify(this.ssl, 0, 10);
                } else if (i6 == 2) {
                    SSL.setVerify(this.ssl, 2, 10);
                } else {
                    if (i6 != 3) {
                        throw new Error(clientAuth.toString());
                    }
                    SSL.setVerify(this.ssl, 1, 10);
                }
                this.clientAuth = clientAuth;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private SSLException shutdownWithError(String str, int i6, int i7) {
        String errorString = SSL.getErrorString(i7);
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} failed with {}: OpenSSL error: {} {}", str, Integer.valueOf(i6), Integer.valueOf(i7), errorString);
        }
        shutdown();
        if (this.handshakeState == HandshakeState.FINISHED) {
            return new SSLException(errorString);
        }
        SSLHandshakeException sSLHandshakeException = new SSLHandshakeException(errorString);
        Throwable th = this.handshakeException;
        if (th != null) {
            sSLHandshakeException.initCause(th);
            this.handshakeException = null;
        }
        return sSLHandshakeException;
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleDstBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleSrcBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private int sslPending0() {
        if (this.handshakeState != HandshakeState.FINISHED) {
            return 0;
        }
        return SSL.sslPending(this.ssl);
    }

    private SSLEngineResult sslReadErrorResult(int i6, int i7, int i8, int i9) throws SSLException {
        if (SSL.bioLengthNonApplication(this.networkBIO) <= 0) {
            throw shutdownWithError("SSL_read", i6, i7);
        }
        if (this.handshakeException == null && this.handshakeState != HandshakeState.FINISHED) {
            this.handshakeException = new SSLHandshakeException(SSL.getErrorString(i7));
        }
        SSL.clearError();
        return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toJavaCipherSuite(String str) {
        if (str == null) {
            return null;
        }
        return CipherSuiteConverter.toJava(str, toJavaCipherSuitePrefix(SSL.getVersion(this.ssl)));
    }

    final int calculateMaxLengthForWrap(int i6, int i7) {
        return (int) Math.min(this.maxWrapBufferSize, i6 + (this.maxWrapOverhead * i7));
    }

    final boolean checkSniHostnameMatch(byte[] bArr) {
        return Java8SslUtils.checkSniHostnameMatch(this.matchers, bArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledProtocols() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add("SSLv2Hello");
        synchronized (this) {
            if (isDestroyed()) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            int options = SSL.getOptions(this.ssl);
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1, "TLSv1")) {
                arrayList.add("TLSv1");
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_1, "TLSv1.1")) {
                arrayList.add("TLSv1.1");
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_2, "TLSv1.2")) {
                arrayList.add("TLSv1.2");
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_3, "TLSv1.3")) {
                arrayList.add("TLSv1.3");
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_SSLv2, "SSLv2")) {
                arrayList.add("SSLv2");
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_SSLv3, "SSLv3")) {
                arrayList.add("SSLv3");
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getNeedClientAuth() {
        return this.clientAuth == ClientAuth.REQUIRE;
    }

    @Override // io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    public byte[] getOcspResponse() {
        byte[] ocspResponse;
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        }
        if (!this.clientMode) {
            throw new IllegalStateException("Not a client SSLEngine");
        }
        synchronized (this) {
            ocspResponse = SSL.getOcspResponse(this.ssl);
        }
        return ocspResponse;
    }

    @Override // javax.net.ssl.SSLEngine
    public final SSLSession getSession() {
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedCipherSuites() {
        return (String[]) OpenSsl.AVAILABLE_CIPHER_SUITES.toArray(new String[0]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedProtocols() {
        return (String[]) OpenSsl.SUPPORTED_PROTOCOLS_SET.toArray(new String[0]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getUseClientMode() {
        return this.clientMode;
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getWantClientAuth() {
        return this.clientAuth == ClientAuth.OPTIONAL;
    }

    final void initHandshakeException(Throwable th) {
        this.handshakeException = th;
    }

    final int maxEncryptedPacketLength0() {
        return this.maxWrapOverhead + MAX_PLAINTEXT_LENGTH;
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

    @Override // javax.net.ssl.SSLEngine
    public final void setEnableSessionCreation(boolean z5) {
        if (z5) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledCipherSuites(String[] strArr) {
        ObjectUtil.checkNotNull(strArr, "cipherSuites");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        CipherSuiteConverter.convertToCipherStrings(Arrays.asList(strArr), sb, sb2, OpenSsl.isBoringSSL());
        String sb3 = sb.toString();
        String sb4 = sb2.toString();
        if (!OpenSsl.isTlsv13Supported() && !sb4.isEmpty()) {
            throw new IllegalArgumentException("TLSv1.3 is not supported by this java version.");
        }
        synchronized (this) {
            if (isDestroyed()) {
                throw new IllegalStateException("failed to enable cipher suites: " + sb3);
            }
            try {
                SSL.setCipherSuites(this.ssl, sb3, false);
                if (OpenSsl.isTlsv13Supported()) {
                    SSL.setCipherSuites(this.ssl, sb4, true);
                }
            } catch (Exception e6) {
                throw new IllegalStateException("failed to enable cipher suites: " + sb3, e6);
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledProtocols(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException();
        }
        int length = OPENSSL_OP_NO_PROTOCOLS.length;
        int i6 = 0;
        for (String str : strArr) {
            if (!OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str)) {
                throw new IllegalArgumentException("Protocol " + str + " is not supported.");
            }
            if (str.equals("SSLv2")) {
                if (length > 0) {
                    length = 0;
                }
                if (i6 < 0) {
                    i6 = 0;
                }
            } else if (str.equals("SSLv3")) {
                if (length > 1) {
                    length = 1;
                }
                if (i6 < 1) {
                    i6 = 1;
                }
            } else if (str.equals("TLSv1")) {
                if (length > 2) {
                    length = 2;
                }
                if (i6 < 2) {
                    i6 = 2;
                }
            } else if (str.equals("TLSv1.1")) {
                if (length > 3) {
                    length = 3;
                }
                if (i6 < 3) {
                    i6 = 3;
                }
            } else if (str.equals("TLSv1.2")) {
                if (length > 4) {
                    length = 4;
                }
                if (i6 < 4) {
                    i6 = 4;
                }
            } else if (str.equals("TLSv1.3")) {
                if (length > 5) {
                    length = 5;
                }
                if (i6 < 5) {
                    i6 = 5;
                }
            }
        }
        synchronized (this) {
            try {
                if (isDestroyed()) {
                    throw new IllegalStateException("failed to enable protocols: " + Arrays.asList(strArr));
                }
                SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 | SSL.SSL_OP_NO_TLSv1_3);
                int i7 = 0;
                for (int i8 = 0; i8 < length; i8++) {
                    i7 |= OPENSSL_OP_NO_PROTOCOLS[i8];
                }
                int i9 = i6 + 1;
                while (true) {
                    int[] iArr = OPENSSL_OP_NO_PROTOCOLS;
                    if (i9 < iArr.length) {
                        i7 |= iArr[i9];
                        i9++;
                    } else {
                        SSL.setOptions(this.ssl, i7);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void setKeyMaterial(OpenSslKeyMaterial openSslKeyMaterial) throws Exception {
        SSL.setKeyMaterial(this.ssl, openSslKeyMaterial.certificateChainAddress(), openSslKeyMaterial.privateKeyAddress());
        this.localCertificateChain = openSslKeyMaterial.certificateChain();
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setNeedClientAuth(boolean z5) {
        setClientAuth(z5 ? ClientAuth.REQUIRE : ClientAuth.NONE);
    }

    public void setOcspResponse(byte[] bArr) {
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        }
        if (this.clientMode) {
            throw new IllegalStateException("Not a server SSLEngine");
        }
        synchronized (this) {
            SSL.setOcspResponse(this.ssl, bArr);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setUseClientMode(boolean z5) {
        if (z5 != this.clientMode) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setWantClientAuth(boolean z5) {
        setClientAuth(z5 ? ClientAuth.OPTIONAL : ClientAuth.NONE);
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch(Object obj) {
        this.refCnt.touch(obj);
        return this;
    }

    ReferenceCountedOpenSslEngine(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, ByteBufAllocator byteBufAllocator, String str, int i6, boolean z5, boolean z6) {
        super(str, i6);
        ResourceLeakTracker<ReferenceCountedOpenSslEngine> resourceLeakTracker;
        this.handshakeState = HandshakeState.NOT_STARTED;
        this.refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.AbstractReferenceCounted
            protected void deallocate() {
                ReferenceCountedOpenSslEngine.this.shutdown();
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.close(ReferenceCountedOpenSslEngine.this);
                }
            }

            @Override // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object obj) {
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.record(obj);
                }
                return ReferenceCountedOpenSslEngine.this;
            }
        };
        ClientAuth clientAuth = ClientAuth.NONE;
        this.clientAuth = clientAuth;
        this.lastAccessed = -1L;
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        OpenSsl.ensureAvailability();
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        this.apn = (OpenSslApplicationProtocolNegotiator) referenceCountedOpenSslContext.applicationProtocolNegotiator();
        boolean isClient = referenceCountedOpenSslContext.isClient();
        this.clientMode = isClient;
        if (PlatformDependent.javaVersion() >= 7) {
            this.session = new ExtendedOpenSslSession(new DefaultOpenSslSession(referenceCountedOpenSslContext.sessionContext())) { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.2
                private String[] peerSupportedSignatureAlgorithms;
                private List requestedServerNames;

                @Override // javax.net.ssl.ExtendedSSLSession
                public String[] getPeerSupportedSignatureAlgorithms() {
                    String[] strArr;
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        try {
                            if (this.peerSupportedSignatureAlgorithms == null) {
                                if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                                    this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                                } else {
                                    String[] sigAlgs = SSL.getSigAlgs(ReferenceCountedOpenSslEngine.this.ssl);
                                    if (sigAlgs == null) {
                                        this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                                    } else {
                                        LinkedHashSet linkedHashSet = new LinkedHashSet(sigAlgs.length);
                                        for (String str2 : sigAlgs) {
                                            String javaName = SignatureAlgorithmConverter.toJavaName(str2);
                                            if (javaName != null) {
                                                linkedHashSet.add(javaName);
                                            }
                                        }
                                        this.peerSupportedSignatureAlgorithms = (String[]) linkedHashSet.toArray(new String[0]);
                                    }
                                }
                            }
                            strArr = (String[]) this.peerSupportedSignatureAlgorithms.clone();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return strArr;
                }

                @Override // io.netty.handler.ssl.ExtendedOpenSslSession, javax.net.ssl.ExtendedSSLSession
                public List getRequestedServerNames() {
                    List list;
                    if (ReferenceCountedOpenSslEngine.this.clientMode) {
                        return Java8SslUtils.getSniHostNames((List<String>) ReferenceCountedOpenSslEngine.this.sniHostNames);
                    }
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        try {
                            if (this.requestedServerNames == null) {
                                if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                                    this.requestedServerNames = Collections.EMPTY_LIST;
                                } else if (SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl) == null) {
                                    this.requestedServerNames = Collections.EMPTY_LIST;
                                } else {
                                    this.requestedServerNames = Java8SslUtils.getSniHostName(SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl).getBytes(CharsetUtil.UTF_8));
                                }
                            }
                            list = this.requestedServerNames;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return list;
                }

                @Override // io.netty.handler.ssl.ExtendedOpenSslSession
                public List<byte[]> getStatusResponses() {
                    if (ReferenceCountedOpenSslEngine.this.enableOcsp && ReferenceCountedOpenSslEngine.this.clientMode) {
                        synchronized (ReferenceCountedOpenSslEngine.this) {
                            try {
                                r1 = ReferenceCountedOpenSslEngine.this.isDestroyed() ? null : SSL.getOcspResponse(ReferenceCountedOpenSslEngine.this.ssl);
                            } finally {
                            }
                        }
                    }
                    return r1 == null ? Collections.EMPTY_LIST : Collections.singletonList(r1);
                }
            };
        } else {
            this.session = new DefaultOpenSslSession(referenceCountedOpenSslContext.sessionContext());
        }
        this.engineMap = referenceCountedOpenSslContext.engineMap;
        boolean z7 = referenceCountedOpenSslContext.enableOcsp;
        this.enableOcsp = z7;
        this.localCertificateChain = referenceCountedOpenSslContext.keyCertChain;
        this.jdkCompatibilityMode = z5;
        Lock readLock = referenceCountedOpenSslContext.ctxLock.readLock();
        readLock.lock();
        try {
            long newSSL = SSL.newSSL(referenceCountedOpenSslContext.ctx, true ^ referenceCountedOpenSslContext.isClient());
            synchronized (this) {
                this.ssl = newSSL;
                try {
                    this.networkBIO = SSL.bioNewByteBuffer(newSSL, referenceCountedOpenSslContext.getBioNonApplicationBufferSize());
                    if (!isClient) {
                        clientAuth = referenceCountedOpenSslContext.clientAuth;
                    }
                    setClientAuth(clientAuth);
                    String[] strArr = referenceCountedOpenSslContext.protocols;
                    if (strArr != null) {
                        setEnabledProtocols(strArr);
                    }
                    if (isClient && SslUtils.isValidHostNameForSNI(str)) {
                        SSL.setTlsExtHostName(this.ssl, str);
                        this.sniHostNames = Collections.singletonList(str);
                    }
                    if (z7) {
                        SSL.enableOcsp(this.ssl);
                    }
                    if (!z5) {
                        long j6 = this.ssl;
                        SSL.setMode(j6, SSL.getMode(j6) | SSL.SSL_MODE_ENABLE_PARTIAL_WRITE);
                    }
                    calculateMaxWrapOverhead();
                } catch (Throwable th) {
                    shutdown();
                    PlatformDependent.throwException(th);
                }
            }
            if (z6) {
                resourceLeakTracker = leakDetector.track(this);
            } else {
                resourceLeakTracker = null;
            }
            this.leak = resourceLeakTracker;
        } finally {
            readLock.unlock();
        }
    }

    private static long bufferAddress(ByteBuffer byteBuffer) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.directBufferAddress(byteBuffer);
        }
        return Buffer.address(byteBuffer);
    }

    private void checkEngineClosed() throws SSLException {
        if (!isDestroyed()) {
        } else {
            throw new SSLException("engine closed");
        }
    }

    private int readPlaintextData(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            int readFromSSL = SSL.readFromSSL(this.ssl, bufferAddress(byteBuffer) + position, byteBuffer.limit() - position);
            if (readFromSSL > 0) {
                byteBuffer.position(position + readFromSSL);
            }
            return readFromSSL;
        }
        int limit = byteBuffer.limit();
        int min = Math.min(maxEncryptedPacketLength0(), limit - position);
        ByteBuf directBuffer = this.alloc.directBuffer(min);
        try {
            int readFromSSL2 = SSL.readFromSSL(this.ssl, OpenSsl.memoryAddress(directBuffer), min);
            if (readFromSSL2 > 0) {
                byteBuffer.limit(position + readFromSSL2);
                directBuffer.getBytes(directBuffer.readerIndex(), byteBuffer);
                byteBuffer.limit(limit);
            }
            return readFromSSL2;
        } finally {
            directBuffer.release();
        }
    }

    private void rejectRemoteInitiatedRenegotiation() throws SSLHandshakeException {
        if (!isDestroyed() && SSL.getHandshakeCount(this.ssl) > 1 && !"TLSv1.3".equals(this.session.getProtocol()) && this.handshakeState == HandshakeState.FINISHED) {
            shutdown();
            throw new SSLHandshakeException("remote-initiated renegotiation not allowed");
        }
    }

    private ByteBuf writeEncryptedData(ByteBuffer byteBuffer, int i6) {
        int position = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(byteBuffer) + position, i6, false);
            return null;
        }
        ByteBuf directBuffer = this.alloc.directBuffer(i6);
        try {
            int limit = byteBuffer.limit();
            byteBuffer.limit(position + i6);
            directBuffer.writeBytes(byteBuffer);
            byteBuffer.position(position);
            byteBuffer.limit(limit);
            SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(directBuffer), i6, false);
            return directBuffer;
        } catch (Throwable th) {
            directBuffer.release();
            PlatformDependent.throwException(th);
            return null;
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i6) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            int writeToSSL = SSL.writeToSSL(this.ssl, bufferAddress(byteBuffer) + position, i6);
            if (writeToSSL > 0) {
                byteBuffer.position(position + writeToSSL);
            }
            return writeToSSL;
        }
        ByteBuf directBuffer = this.alloc.directBuffer(i6);
        try {
            byteBuffer.limit(position + i6);
            directBuffer.setBytes(0, byteBuffer);
            byteBuffer.limit(limit);
            int writeToSSL2 = SSL.writeToSSL(this.ssl, OpenSsl.memoryAddress(directBuffer), i6);
            if (writeToSSL2 > 0) {
                byteBuffer.position(position + writeToSSL2);
            } else {
                byteBuffer.position(position);
            }
            directBuffer.release();
            return writeToSSL2;
        } catch (Throwable th) {
            directBuffer.release();
            throw th;
        }
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i6) {
        if (needPendingStatus()) {
            if (this.needTask) {
                return SSLEngineResult.HandshakeStatus.NEED_TASK;
            }
            return pendingStatus(i6);
        }
        return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) throws SSLException {
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i6, int i7) throws SSLException {
        SSLEngineResult unwrap;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            unwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i6, i7);
            resetSingleSrcBuffer();
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            resetSingleSrcBuffer();
            throw th3;
        }
        return unwrap;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        try {
        } finally {
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
        }
        return unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        try {
        } finally {
            resetSingleSrcBuffer();
        }
        return unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        try {
        } finally {
            resetSingleSrcBuffer();
        }
        return wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
    }
}
