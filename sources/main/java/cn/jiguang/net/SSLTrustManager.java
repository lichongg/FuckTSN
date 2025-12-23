package cn.jiguang.net;

import cn.jiguang.bb.f;
import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\Downloads\app\classes2.dex */
public class SSLTrustManager implements X509TrustManager {

    /* renamed from: a, reason: collision with root package name */
    private X509TrustManager f3150a;

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        f.c("SSLTrustManager", "checkClientTrusted");
        this.f3150a.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        X509Certificate x509Certificate;
        f.c("SSLTrustManager", "checkServerTrusted");
        this.f3150a.checkServerTrusted(x509CertificateArr, str);
        if (x509CertificateArr == null || x509CertificateArr.length == 0 || (x509Certificate = x509CertificateArr[0]) == null) {
            throw new CertificateException("Check Server x509Certificates is empty");
        }
        try {
            x509Certificate.checkValidity();
        } catch (CertificateExpiredException e6) {
            f.i("SSLTrustManager", "checkServerTrusted: CertificateExpiredException:" + e6.getLocalizedMessage());
            throw e6;
        } catch (CertificateNotYetValidException e7) {
            f.i("SSLTrustManager", "checkServerTrusted: CertificateNotYetValidException:" + e7.getLocalizedMessage());
            throw e7;
        } catch (Throwable th) {
            f.i("SSLTrustManager", "checkServerTrusted failed, error" + th.getLocalizedMessage());
            throw new CertificateException("Check Server x509Certificates exception: " + th);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        f.c("SSLTrustManager", "getAcceptedIssuers");
        return this.f3150a.getAcceptedIssuers();
    }

    public SSLTrustManager(String str) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(e.f33254b);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            KeyStore.TrustedCertificateEntry trustedCertificateEntry = new KeyStore.TrustedCertificateEntry(x509Certificate);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setEntry("ca_root", trustedCertificateEntry, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.f3150a = (X509TrustManager) trustManager;
                    return;
                }
            }
            throw new NoSuchAlgorithmException("No X509TrustManager found");
        } catch (Throwable th) {
            f.i("SSLTrustManager", "init trustManager failed, error:" + th);
            throw th;
        }
    }
}
