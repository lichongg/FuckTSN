package f2;

import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.h;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            h.e("", "verify: certificate is : " + x509Certificate.getSubjectDN().getName());
            d.a(str, x509Certificate, true);
            f.b();
            return true;
        } catch (SSLException e6) {
            h.d("", "SSLException : " + e6.getMessage());
            return false;
        }
    }
}
