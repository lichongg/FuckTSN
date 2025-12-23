package xyz.adscope.common.network.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SSLUtils {
    public static final HostnameVerifier HOSTNAME_VERIFIER = new HostnameVerifier() { // from class: xyz.adscope.common.network.ssl.SSLUtils.1
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };
    public static final SSLSocketFactory SSL_SOCKET_FACTORY = new TLSSocketFactory();
}
