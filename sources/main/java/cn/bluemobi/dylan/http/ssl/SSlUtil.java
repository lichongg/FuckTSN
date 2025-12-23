package cn.bluemobi.dylan.http.ssl;

import com.huawei.hms.feature.dynamic.f.e;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.net.imap.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SSlUtil {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class MyTrustManager implements X509TrustManager {
        private X509TrustManager defaultTrustManager;
        private X509TrustManager localTrustManager;

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.defaultTrustManager.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.localTrustManager.checkServerTrusted(x509CertificateArr, str);
            }
        }

        public MyTrustManager(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            this.defaultTrustManager = SSlUtil.chooseTrustManager(trustManagerFactory.getTrustManagers());
            this.localTrustManager = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SSLParams {
        public SSLSocketFactory sSLSocketFactory;
        public X509TrustManager trustManager;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class UnSafeHostnameVerifier implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        private UnSafeHostnameVerifier() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    private static KeyManager[] prepareKeyManager(InputStream inputStream, String str) {
        if (inputStream != null && str != null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("BKS");
                keyStore.load(inputStream, str.toCharArray());
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, str.toCharArray());
                return keyManagerFactory.getKeyManagers();
            } catch (IOException e6) {
                e6.printStackTrace();
            } catch (KeyStoreException e7) {
                e7.printStackTrace();
            } catch (NoSuchAlgorithmException e8) {
                e8.printStackTrace();
            } catch (UnrecoverableKeyException e9) {
                e9.printStackTrace();
            } catch (CertificateException e10) {
                e10.printStackTrace();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    private static TrustManager[] prepareTrustManager(InputStream... inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(e.f33254b);
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null);
                int length = inputStreamArr.length;
                int i6 = 0;
                int i7 = 0;
                while (i6 < length) {
                    InputStream inputStream = inputStreamArr[i6];
                    int i8 = i7 + 1;
                    keyStore.setCertificateEntry(Integer.toString(i7), certificateFactory.generateCertificate(inputStream));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    i6++;
                    i7 = i8;
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                return trustManagerFactory.getTrustManagers();
            } catch (KeyStoreException e6) {
                e6.printStackTrace();
            } catch (NoSuchAlgorithmException e7) {
                e7.printStackTrace();
            } catch (CertificateException e8) {
                e8.printStackTrace();
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        return null;
    }

    public static SSLParams getSslSocketFactory(InputStream[] inputStreamArr, InputStream inputStream, String str) {
        SSLParams sSLParams = new SSLParams();
        try {
            TrustManager[] prepareTrustManager = prepareTrustManager(inputStreamArr);
            KeyManager[] prepareKeyManager = prepareKeyManager(inputStream, str);
            SSLContext sSLContext = SSLContext.getInstance(b.Q);
            X509TrustManager myTrustManager = prepareTrustManager != null ? new MyTrustManager(chooseTrustManager(prepareTrustManager)) : new UnSafeTrustManager();
            sSLContext.init(prepareKeyManager, new TrustManager[]{myTrustManager}, null);
            sSLParams.sSLSocketFactory = sSLContext.getSocketFactory();
            sSLParams.trustManager = myTrustManager;
            return sSLParams;
        } catch (KeyManagementException e6) {
            throw new AssertionError(e6);
        } catch (KeyStoreException e7) {
            throw new AssertionError(e7);
        } catch (NoSuchAlgorithmException e8) {
            throw new AssertionError(e8);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class UnSafeTrustManager implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }
    }
}
