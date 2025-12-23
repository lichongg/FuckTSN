package xyz.adscope.common.v2.conn.http.pool;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class CommonHostVerifier implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }

    CommonHostVerifier() {
    }
}
