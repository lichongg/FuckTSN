package io.netty.handler.ssl;

import java.io.File;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class JdkSslClientContext extends JdkSslContext {
    @Deprecated
    public JdkSslClientContext() throws SSLException {
        this(null, null);
    }

    @Deprecated
    public JdkSslClientContext(File file) throws SSLException {
        this(file, null);
    }

    private static SSLContext newSSLContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, long j6, long j7, String str2) throws SSLException {
        if (x509CertificateArr != null) {
            try {
                trustManagerFactory = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
            } catch (Exception e6) {
                if (e6 instanceof SSLException) {
                    throw ((SSLException) e6);
                }
                throw new SSLException("failed to initialize the client-side SSL context", e6);
            }
        }
        if (x509CertificateArr2 != null) {
            keyManagerFactory = SslContext.buildKeyManagerFactory(x509CertificateArr2, privateKey, str, keyManagerFactory, (String) null);
        }
        SSLContext sSLContext = provider == null ? SSLContext.getInstance(org.apache.commons.net.imap.b.Q) : SSLContext.getInstance(org.apache.commons.net.imap.b.Q, provider);
        sSLContext.init(keyManagerFactory == null ? null : keyManagerFactory.getKeyManagers(), trustManagerFactory == null ? null : trustManagerFactory.getTrustManagers(), null);
        SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
        if (j6 > 0) {
            clientSessionContext.setSessionCacheSize((int) Math.min(j6, 2147483647L));
        }
        if (j7 > 0) {
            clientSessionContext.setSessionTimeout((int) Math.min(j7, 2147483647L));
        }
        return sSLContext;
    }

    @Deprecated
    public JdkSslClientContext(TrustManagerFactory trustManagerFactory) throws SSLException {
        this(null, trustManagerFactory);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory) throws SSLException {
        this(file, trustManagerFactory, (Iterable<String>) null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, Iterable<String> iterable2, long j6, long j7) throws SSLException {
        this(file, trustManagerFactory, iterable, IdentityCipherSuiteFilter.INSTANCE, JdkSslContext.toNegotiator(SslContext.toApplicationProtocolConfig(iterable2), false), j6, j7);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7) throws SSLException {
        this(file, trustManagerFactory, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, false), j6, j7);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j6, long j7) throws SSLException {
        this(null, file, trustManagerFactory, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, j6, j7);
    }

    JdkSslClientContext(Provider provider, File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j6, long j7) throws SSLException {
        super(newSSLContext(provider, SslContext.toX509CertificatesInternal(file), trustManagerFactory, null, null, null, null, j6, j7, KeyStore.getDefaultType()), true, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, ClientAuth.NONE, (String[]) null, false);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7) throws SSLException {
        this(file, trustManagerFactory, file2, file3, str, keyManagerFactory, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, false), j6, j7);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j6, long j7) throws SSLException {
        super(newSSLContext(null, SslContext.toX509CertificatesInternal(file), trustManagerFactory, SslContext.toX509CertificatesInternal(file2), SslContext.toPrivateKeyInternal(file3, str), str, keyManagerFactory, j6, j7, KeyStore.getDefaultType()), true, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, ClientAuth.NONE, (String[]) null, false);
    }

    JdkSslClientContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j6, long j7, String str2) throws SSLException {
        super(newSSLContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, j6, j7, str2), true, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, false), ClientAuth.NONE, strArr, false);
    }
}
