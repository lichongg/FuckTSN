package io.netty.handler.ssl;

import io.netty.handler.ssl.ReferenceCountedOpenSslContext;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ReferenceCountedOpenSslClientContext extends ReferenceCountedOpenSslContext {
    private final OpenSslSessionContext sessionContext;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslClientContext.class);
    private static final Set<String> SUPPORTED_KEY_TYPES = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList("RSA", "DH_RSA", "EC", "EC_RSA", "EC_EC")));

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkServerTrusted(x509CertificateArr, str, referenceCountedOpenSslEngine);
        }

        ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509ExtendedTrustManager x509ExtendedTrustManager) {
            super(openSslEngineMap);
            this.manager = OpenSslTlsv13X509ExtendedTrustManager.wrap(x509ExtendedTrustManager, true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class OpenSslClientCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        private static String clientKeyType(byte b6) {
            if (b6 == 1) {
                return "RSA";
            }
            if (b6 == 3) {
                return "DH_RSA";
            }
            switch (b6) {
                case 64:
                    return "EC";
                case 65:
                    return "EC_RSA";
                case 66:
                    return "EC_EC";
                default:
                    return null;
            }
        }

        private static Set<String> supportedClientKeyTypes(byte[] bArr) {
            if (bArr == null) {
                return ReferenceCountedOpenSslClientContext.SUPPORTED_KEY_TYPES;
            }
            HashSet hashSet = new HashSet(bArr.length);
            for (byte b6 : bArr) {
                String clientKeyType = clientKeyType(b6);
                if (clientKeyType != null) {
                    hashSet.add(clientKeyType);
                }
            }
            return hashSet;
        }

        public void handle(long j6, byte[] bArr, byte[][] bArr2) throws Exception {
            X500Principal[] x500PrincipalArr;
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j6);
            try {
                Set<String> supportedClientKeyTypes = supportedClientKeyTypes(bArr);
                String[] strArr = (String[]) supportedClientKeyTypes.toArray(new String[0]);
                if (bArr2 == null) {
                    x500PrincipalArr = null;
                } else {
                    X500Principal[] x500PrincipalArr2 = new X500Principal[bArr2.length];
                    for (int i6 = 0; i6 < bArr2.length; i6++) {
                        x500PrincipalArr2[i6] = new X500Principal(bArr2[i6]);
                    }
                    x500PrincipalArr = x500PrincipalArr2;
                }
                this.keyManagerHolder.setKeyMaterialClientSide(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
            } catch (Throwable th) {
                ReferenceCountedOpenSslClientContext.logger.debug("request of key failed", th);
                referenceCountedOpenSslEngine.initHandshakeException(th);
            }
        }

        OpenSslClientCertificateCallback(OpenSslEngineMap openSslEngineMap, OpenSslKeyMaterialManager openSslKeyMaterialManager) {
            this.engineMap = openSslEngineMap;
            this.keyManagerHolder = openSslKeyMaterialManager;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class OpenSslClientSessionContext extends OpenSslSessionContext {
        @Override // javax.net.ssl.SSLSessionContext
        public int getSessionCacheSize() {
            return 0;
        }

        @Override // javax.net.ssl.SSLSessionContext
        public int getSessionTimeout() {
            return 0;
        }

        @Override // io.netty.handler.ssl.OpenSslSessionContext
        public boolean isSessionCacheEnabled() {
            return false;
        }

        @Override // javax.net.ssl.SSLSessionContext
        public void setSessionCacheSize(int i6) {
            if (i6 < 0) {
                throw new IllegalArgumentException();
            }
        }

        @Override // javax.net.ssl.SSLSessionContext
        public void setSessionTimeout(int i6) {
            if (i6 < 0) {
                throw new IllegalArgumentException();
            }
        }

        OpenSslClientSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
            super(referenceCountedOpenSslContext, openSslKeyMaterialProvider);
        }

        @Override // io.netty.handler.ssl.OpenSslSessionContext
        public void setSessionCacheEnabled(boolean z5) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class TrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509TrustManager manager;

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkServerTrusted(x509CertificateArr, str);
        }

        TrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
            super(openSslEngineMap);
            this.manager = x509TrustManager;
        }
    }

    ReferenceCountedOpenSslClientContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j6, long j7, boolean z5, String str2) throws SSLException {
        super(iterable, cipherSuiteFilter, applicationProtocolConfig, j6, j7, 0, (Certificate[]) x509CertificateArr2, ClientAuth.NONE, strArr, false, z5, true);
        try {
            this.sessionContext = newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, str2);
        } catch (Throwable th) {
            release();
            throw th;
        }
    }

    static OpenSslSessionContext newSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, long j6, OpenSslEngineMap openSslEngineMap, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, String str2) throws SSLException {
        OpenSslKeyMaterialProvider providerFor;
        if ((privateKey == null && x509CertificateArr2 != null) || (privateKey != null && x509CertificateArr2 == null)) {
            throw new IllegalArgumentException("Either both keyCertChain and key needs to be null or none of them");
        }
        OpenSslKeyMaterialProvider openSslKeyMaterialProvider = null;
        try {
            try {
                if (OpenSsl.useKeyManagerFactory()) {
                    if (keyManagerFactory != null || x509CertificateArr2 == null) {
                        providerFor = keyManagerFactory != null ? ReferenceCountedOpenSslContext.providerFor(keyManagerFactory, str) : null;
                    } else {
                        char[] keyStorePassword = SslContext.keyStorePassword(str);
                        KeyStore buildKeyStore = SslContext.buildKeyStore(x509CertificateArr2, privateKey, keyStorePassword, str2);
                        KeyManagerFactory openSslX509KeyManagerFactory = buildKeyStore.aliases().hasMoreElements() ? new OpenSslX509KeyManagerFactory() : new OpenSslCachingX509KeyManagerFactory(KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()));
                        openSslX509KeyManagerFactory.init(buildKeyStore, keyStorePassword);
                        providerFor = ReferenceCountedOpenSslContext.providerFor(openSslX509KeyManagerFactory, str);
                    }
                    if (providerFor != null) {
                        try {
                            try {
                                SSLContext.setCertificateCallback(j6, new OpenSslClientCertificateCallback(openSslEngineMap, new OpenSslKeyMaterialManager(providerFor)));
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
                    }
                } else {
                    if (keyManagerFactory != null) {
                        throw new IllegalArgumentException("KeyManagerFactory not supported");
                    }
                    if (x509CertificateArr2 != null) {
                        ReferenceCountedOpenSslContext.setKeyMaterial(j6, x509CertificateArr2, privateKey, str);
                    }
                    providerFor = null;
                }
                SSLContext.setVerify(j6, 1, 10);
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
                    return new OpenSslClientSessionContext(referenceCountedOpenSslContext, providerFor);
                } catch (Exception e7) {
                    if (providerFor != null) {
                        providerFor.destroy();
                    }
                    throw new SSLException("unable to setup trustmanager", e7);
                }
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext, io.netty.handler.ssl.SslContext
    public OpenSslSessionContext sessionContext() {
        return this.sessionContext;
    }
}
