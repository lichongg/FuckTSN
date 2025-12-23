package org.apache.commons.net.util;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final X509Certificate[] f51271a = new X509Certificate[0];

    /* renamed from: b, reason: collision with root package name */
    private static final X509TrustManager f51272b = new a(false);

    /* renamed from: c, reason: collision with root package name */
    private static final X509TrustManager f51273c = new a(true);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements X509TrustManager {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f51274a;

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            if (this.f51274a) {
                for (X509Certificate x509Certificate : x509CertificateArr) {
                    x509Certificate.checkValidity();
                }
            }
        }

        a(boolean z5) {
            this.f51274a = z5;
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return g.f51271a;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }
    }

    public static X509TrustManager b() {
        return f51272b;
    }

    public static X509TrustManager d() {
        return f51273c;
    }

    public static X509TrustManager c(KeyStore keyStore) throws GeneralSecurityException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        return (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
    }
}
