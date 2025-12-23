package io.netty.handler.ssl;

import java.io.File;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class OpenSslServerContext extends OpenSslContext {
    private final OpenSslServerSessionContext sessionContext;

    @Deprecated
    public OpenSslServerContext(File file, File file2) throws SSLException {
        this(file, file2, null);
    }

    @Deprecated
    public OpenSslServerContext(File file, File file2, String str) throws SSLException {
        this(file, file2, str, (Iterable<String>) null, IdentityCipherSuiteFilter.INSTANCE, ApplicationProtocolConfig.DISABLED, 0L, 0L);
    }

    @Deprecated
    public OpenSslServerContext(File file, File file2, String str, Iterable<String> iterable, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7) throws SSLException {
        this(file, file2, str, iterable, IdentityCipherSuiteFilter.INSTANCE, applicationProtocolConfig, j6, j7);
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext, io.netty.handler.ssl.SslContext
    public OpenSslServerSessionContext sessionContext() {
        return this.sessionContext;
    }

    @Deprecated
    public OpenSslServerContext(File file, File file2, String str, Iterable<String> iterable, Iterable<String> iterable2, long j6, long j7) throws SSLException {
        this(file, file2, str, iterable, SslContext.toApplicationProtocolConfig(iterable2), j6, j7);
    }

    @Deprecated
    public OpenSslServerContext(File file, File file2, String str, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7) throws SSLException {
        this(file, file2, str, trustManagerFactory, iterable, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), j6, j7);
    }

    @Deprecated
    public OpenSslServerContext(File file, File file2, String str, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j6, long j7) throws SSLException {
        this((File) null, trustManagerFactory, file, file2, str, (KeyManagerFactory) null, iterable, (CipherSuiteFilter) null, openSslApplicationProtocolNegotiator, j6, j7);
    }

    @Deprecated
    public OpenSslServerContext(File file, File file2, String str, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7) throws SSLException {
        this((File) null, (TrustManagerFactory) null, file, file2, str, (KeyManagerFactory) null, iterable, cipherSuiteFilter, applicationProtocolConfig, j6, j7);
    }

    @Deprecated
    public OpenSslServerContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7) throws SSLException {
        this(file, trustManagerFactory, file2, file3, str, keyManagerFactory, iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), j6, j7);
    }

    @Deprecated
    public OpenSslServerContext(File file, File file2, String str, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7) throws SSLException {
        this((File) null, trustManagerFactory, file, file2, str, (KeyManagerFactory) null, iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), j6, j7);
    }

    @Deprecated
    public OpenSslServerContext(File file, File file2, String str, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j6, long j7) throws SSLException {
        this((File) null, trustManagerFactory, file, file2, str, (KeyManagerFactory) null, iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, j6, j7);
    }

    @Deprecated
    public OpenSslServerContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j6, long j7) throws SSLException {
        this(SslContext.toX509CertificatesInternal(file), trustManagerFactory, SslContext.toX509CertificatesInternal(file2), SslContext.toPrivateKeyInternal(file3, str), str, keyManagerFactory, iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, j6, j7, ClientAuth.NONE, (String[]) null, false, false, KeyStore.getDefaultType());
    }

    OpenSslServerContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7, ClientAuth clientAuth, String[] strArr, boolean z5, boolean z6, String str2) throws SSLException {
        this(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), j6, j7, clientAuth, strArr, z5, z6, str2);
    }

    private OpenSslServerContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j6, long j7, ClientAuth clientAuth, String[] strArr, boolean z5, boolean z6, String str2) throws SSLException {
        super(iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, j6, j7, 1, x509CertificateArr2, clientAuth, strArr, z5, z6);
        try {
            OpenSslKeyMaterialProvider.validateKeyMaterialSupported(x509CertificateArr2, privateKey, str);
            this.sessionContext = ReferenceCountedOpenSslServerContext.newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, str2);
        } catch (Throwable th) {
            release();
            throw th;
        }
    }
}
