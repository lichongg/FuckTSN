package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ReferenceCountedOpenSslContext;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SniHostNameMatcher;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ReferenceCountedOpenSslServerContext extends ReferenceCountedOpenSslContext {
    private final OpenSslServerSessionContext sessionContext;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslServerContext.class);
    private static final byte[] ID = {110, 101, 116, 116, 121};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkClientTrusted(x509CertificateArr, str, referenceCountedOpenSslEngine);
        }

        ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509ExtendedTrustManager x509ExtendedTrustManager) {
            super(openSslEngineMap);
            this.manager = OpenSslTlsv13X509ExtendedTrustManager.wrap(x509ExtendedTrustManager, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class OpenSslServerCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        public void handle(long j6, byte[] bArr, byte[][] bArr2) throws Exception {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j6);
            try {
                this.keyManagerHolder.setKeyMaterialServerSide(referenceCountedOpenSslEngine);
            } catch (Throwable th) {
                ReferenceCountedOpenSslServerContext.logger.debug("Failed to set the server-side key material", th);
                referenceCountedOpenSslEngine.initHandshakeException(th);
            }
        }

        OpenSslServerCertificateCallback(OpenSslEngineMap openSslEngineMap, OpenSslKeyMaterialManager openSslKeyMaterialManager) {
            this.engineMap = openSslEngineMap;
            this.keyManagerHolder = openSslKeyMaterialManager;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class OpenSslSniHostnameMatcher implements SniHostNameMatcher {
        private final OpenSslEngineMap engineMap;

        public boolean match(long j6, String str) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j6);
            if (referenceCountedOpenSslEngine != null) {
                return referenceCountedOpenSslEngine.checkSniHostnameMatch(str.getBytes(CharsetUtil.UTF_8));
            }
            ReferenceCountedOpenSslServerContext.logger.warn("No ReferenceCountedOpenSslEngine found for SSL pointer: {}", Long.valueOf(j6));
            return false;
        }

        OpenSslSniHostnameMatcher(OpenSslEngineMap openSslEngineMap) {
            this.engineMap = openSslEngineMap;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class TrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509TrustManager manager;

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkClientTrusted(x509CertificateArr, str);
        }

        TrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
            super(openSslEngineMap);
            this.manager = x509TrustManager;
        }
    }

    ReferenceCountedOpenSslServerContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7, ClientAuth clientAuth, String[] strArr, boolean z5, boolean z6, String str2) throws SSLException {
        this(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), j6, j7, clientAuth, strArr, z5, z6, str2);
    }

    static OpenSslServerSessionContext newSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, long j6, OpenSslEngineMap openSslEngineMap, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, String str2) throws SSLException {
        OpenSslKeyMaterialProvider providerFor;
        OpenSslKeyMaterialProvider openSslKeyMaterialProvider = null;
        try {
            try {
                SSLContext.setVerify(j6, 0, 10);
                if (OpenSsl.useKeyManagerFactory()) {
                    if (keyManagerFactory == null) {
                        char[] keyStorePassword = SslContext.keyStorePassword(str);
                        KeyStore buildKeyStore = SslContext.buildKeyStore(x509CertificateArr2, privateKey, keyStorePassword, str2);
                        KeyManagerFactory openSslX509KeyManagerFactory = buildKeyStore.aliases().hasMoreElements() ? new OpenSslX509KeyManagerFactory() : new OpenSslCachingX509KeyManagerFactory(KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()));
                        openSslX509KeyManagerFactory.init(buildKeyStore, keyStorePassword);
                        keyManagerFactory = openSslX509KeyManagerFactory;
                    }
                    providerFor = ReferenceCountedOpenSslContext.providerFor(keyManagerFactory, str);
                    try {
                        try {
                            SSLContext.setCertificateCallback(j6, new OpenSslServerCertificateCallback(openSslEngineMap, new OpenSslKeyMaterialManager(providerFor)));
                        } catch (Throwable th) {
                            th = th;
                            openSslKeyMaterialProvider = providerFor;
                            if (openSslKeyMaterialProvider != null) {
                                openSslKeyMaterialProvider.destroy();
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        throw new SSLException("failed to set certificate and key", e);
                    }
                } else {
                    if (keyManagerFactory != null) {
                        throw new IllegalArgumentException("KeyManagerFactory not supported");
                    }
                    ObjectUtil.checkNotNull(x509CertificateArr2, "keyCertChain");
                    ReferenceCountedOpenSslContext.setKeyMaterial(j6, x509CertificateArr2, privateKey, str);
                    providerFor = null;
                }
                try {
                    if (x509CertificateArr != null) {
                        trustManagerFactory = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
                    } else if (trustManagerFactory == null) {
                        trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init((KeyStore) null);
                    }
                    X509TrustManager chooseTrustManager = ReferenceCountedOpenSslContext.chooseTrustManager(trustManagerFactory.getTrustManagers());
                    if (ReferenceCountedOpenSslContext.useExtendedTrustManager(chooseTrustManager)) {
                        SSLContext.setCertVerifyCallback(j6, new ExtendedTrustManagerVerifyCallback(openSslEngineMap, z.a(chooseTrustManager)));
                    } else {
                        SSLContext.setCertVerifyCallback(j6, new TrustManagerVerifyCallback(openSslEngineMap, chooseTrustManager));
                    }
                    X509Certificate[] acceptedIssuers = chooseTrustManager.getAcceptedIssuers();
                    if (acceptedIssuers != null && acceptedIssuers.length > 0) {
                        long j7 = 0;
                        try {
                            j7 = ReferenceCountedOpenSslContext.toBIO(ByteBufAllocator.DEFAULT, acceptedIssuers);
                            if (!SSLContext.setCACertificateBio(j6, j7)) {
                                throw new SSLException("unable to setup accepted issuers for trustmanager " + chooseTrustManager);
                            }
                        } finally {
                            ReferenceCountedOpenSslContext.freeBio(j7);
                        }
                    }
                    if (PlatformDependent.javaVersion() >= 8) {
                        SSLContext.setSniHostnameMatcher(j6, new OpenSslSniHostnameMatcher(openSslEngineMap));
                    }
                    OpenSslServerSessionContext openSslServerSessionContext = new OpenSslServerSessionContext(referenceCountedOpenSslContext, providerFor);
                    openSslServerSessionContext.setSessionIdContext(ID);
                    return openSslServerSessionContext;
                } catch (SSLException e7) {
                    throw e7;
                } catch (Exception e8) {
                    throw new SSLException("unable to setup trustmanager", e8);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e9) {
            e = e9;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [io.netty.handler.ssl.ReferenceCountedOpenSslContext] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [io.netty.handler.ssl.ReferenceCountedOpenSslContext] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [io.netty.handler.ssl.ReferenceCountedOpenSslServerContext] */
    ReferenceCountedOpenSslServerContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j6, long j7, ClientAuth clientAuth, String[] strArr, boolean z5, boolean z6, String str2) throws SSLException {
        ?? referenceCountedOpenSslContext = new ReferenceCountedOpenSslContext(iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, j6, j7, 1, (Certificate[]) x509CertificateArr2, clientAuth, strArr, z5, z6, true);
        try {
            try {
                OpenSslServerSessionContext newSessionContext = newSessionContext(referenceCountedOpenSslContext, referenceCountedOpenSslContext.ctx, referenceCountedOpenSslContext.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, str2);
                referenceCountedOpenSslContext = referenceCountedOpenSslContext;
                referenceCountedOpenSslContext.sessionContext = newSessionContext;
            } catch (Throwable th) {
                th = th;
                referenceCountedOpenSslContext = referenceCountedOpenSslContext;
                referenceCountedOpenSslContext.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext, io.netty.handler.ssl.SslContext
    public OpenSslServerSessionContext sessionContext() {
        return this.sessionContext;
    }
}
