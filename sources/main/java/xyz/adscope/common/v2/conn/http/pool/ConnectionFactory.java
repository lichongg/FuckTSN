package xyz.adscope.common.v2.conn.http.pool;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import xyz.adscope.common.v2.conn.http.CommonHeader;
import xyz.adscope.common.v2.conn.http.IRequest;
import xyz.adscope.common.v2.conn.http.RequestMethod;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ConnectionFactory {
    private static final int REQ_CONNECTED_TIMEOUT = 10000;
    private static final int REQ_READ_TIMEOUT = 10000;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SSLHolder {
        static final SSLSocketFactory SSL_SOCKET_FACTORY = new CommonTLSFactory();
        static final HostnameVerifier HOSTNAME_VERIFIER = new CommonHostVerifier();

        private SSLHolder() {
        }
    }

    public static HttpURLConnection createNewConnection(IRequest iRequest) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(iRequest.getRequestURL()).openConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(SSLHolder.SSL_SOCKET_FACTORY);
            httpsURLConnection.setHostnameVerifier(SSLHolder.HOSTNAME_VERIFIER);
        }
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        String methodName = iRequest.getRequestMethod().getMethodName();
        if (methodName.equalsIgnoreCase(RequestMethod.DOWNLOAD.getMethodName()) || methodName.equalsIgnoreCase(RequestMethod.CACHE_IMAGE.getMethodName())) {
            methodName = RequestMethod.GET.getMethodName();
        }
        if (methodName.equalsIgnoreCase(RequestMethod.STREAM.getMethodName())) {
            methodName = RequestMethod.POST.getMethodName();
        }
        httpURLConnection.setRequestMethod(methodName);
        httpURLConnection.setInstanceFollowRedirects(false);
        CommonHeader header = iRequest.getHeader();
        if (!header.isEmpty()) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return httpURLConnection;
    }

    private ConnectionFactory() {
    }
}
