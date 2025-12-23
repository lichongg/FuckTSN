package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class OpenSslX509TrustManagerWrapper {
    private static final InternalLogger LOGGER;
    private static final TrustManagerWrapper WRAPPER;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface TrustManagerWrapper {
        X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class UnsafeTrustManagerWrapper implements TrustManagerWrapper {
        private final long spiOffset;
        private final long tmOffset;

        UnsafeTrustManagerWrapper(long j6, long j7) {
            this.spiOffset = j6;
            this.tmOffset = j7;
        }

        @Override // io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.TrustManagerWrapper
        public X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager) {
            if (!y.a(x509TrustManager)) {
                try {
                    SSLContext newSSLContext = OpenSslX509TrustManagerWrapper.newSSLContext();
                    newSSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
                    Object object = PlatformDependent.getObject(newSSLContext, this.spiOffset);
                    if (object != null) {
                        Object object2 = PlatformDependent.getObject(object, this.tmOffset);
                        if (y.a(object2)) {
                            return (X509TrustManager) object2;
                        }
                    }
                } catch (KeyManagementException e6) {
                    PlatformDependent.throwException(e6);
                } catch (NoSuchAlgorithmException e7) {
                    PlatformDependent.throwException(e7);
                }
            }
            return x509TrustManager;
        }
    }

    static {
        final SSLContext sSLContext;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) OpenSslX509TrustManagerWrapper.class);
        LOGGER = internalLoggerFactory;
        TrustManagerWrapper trustManagerWrapper = new TrustManagerWrapper() { // from class: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.1
            @Override // io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.TrustManagerWrapper
            public X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager) {
                return x509TrustManager;
            }
        };
        Throwable th = null;
        if (PlatformDependent.getUnsafeUnavailabilityCause() == null) {
            try {
                sSLContext = newSSLContext();
                sSLContext.init(null, new TrustManager[]{new X509TrustManager() { // from class: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.2
                    @Override // javax.net.ssl.X509TrustManager
                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                        throw new CertificateException();
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                        throw new CertificateException();
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public X509Certificate[] getAcceptedIssuers() {
                        return EmptyArrays.EMPTY_X509_CERTIFICATES;
                    }
                }}, null);
            } catch (Throwable th2) {
                th = th2;
                sSLContext = null;
            }
            if (th != null) {
                LOGGER.debug("Unable to access wrapped TrustManager", th);
            } else {
                Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.3
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            try {
                                long objectFieldOffset = PlatformDependent.objectFieldOffset(SSLContext.class.getDeclaredField("contextSpi"));
                                Object object = PlatformDependent.getObject(sSLContext, objectFieldOffset);
                                if (object != null) {
                                    Class<?> cls = object.getClass();
                                    do {
                                        try {
                                            long objectFieldOffset2 = PlatformDependent.objectFieldOffset(cls.getDeclaredField("trustManager"));
                                            if (y.a(PlatformDependent.getObject(object, objectFieldOffset2))) {
                                                return new UnsafeTrustManagerWrapper(objectFieldOffset, objectFieldOffset2);
                                            }
                                        } catch (NoSuchFieldException unused) {
                                        }
                                        cls = cls.getSuperclass();
                                    } while (cls != null);
                                }
                                throw new NoSuchFieldException();
                            } catch (NoSuchFieldException e6) {
                                return e6;
                            }
                        } catch (SecurityException e7) {
                            return e7;
                        }
                    }
                });
                if (doPrivileged instanceof Throwable) {
                    LOGGER.debug("Unable to access wrapped TrustManager", (Throwable) doPrivileged);
                } else {
                    trustManagerWrapper = (TrustManagerWrapper) doPrivileged;
                }
            }
        } else {
            internalLoggerFactory.debug("Unable to access wrapped TrustManager", (Throwable) null);
        }
        WRAPPER = trustManagerWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SSLContext newSSLContext() throws NoSuchAlgorithmException {
        return SSLContext.getInstance(org.apache.commons.net.imap.b.Q);
    }

    static X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager) {
        return WRAPPER.wrapIfNeeded(x509TrustManager);
    }

    private OpenSslX509TrustManagerWrapper() {
    }
}
