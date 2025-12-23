package xyz.adscope.common.network.urlconnect;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.connect.ConnectFactory;
import xyz.adscope.common.network.connect.Connection;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class URLConnectionFactory implements ConnectFactory {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.urlconnect.URLConnectionFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
        }

        public URLConnectionFactory build() {
            return new URLConnectionFactory(this, null);
        }
    }

    /* synthetic */ URLConnectionFactory(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private URLConnectionFactory(Builder builder) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    @Override // xyz.adscope.common.network.connect.ConnectFactory
    public Connection connect(Request request) {
        URL url = new URL(request.url().toString(true));
        LogUtil.i(CommonConstants.TAG, "URLConnectionFactory connect url : " + url);
        Proxy proxy = request.proxy();
        HttpURLConnection httpURLConnection = proxy == null ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(proxy);
        httpURLConnection.setConnectTimeout(request.connectTimeout());
        httpURLConnection.setReadTimeout(request.readTimeout());
        httpURLConnection.setInstanceFollowRedirects(false);
        if (httpURLConnection instanceof HttpsURLConnection) {
            SSLSocketFactory sslSocketFactory = request.sslSocketFactory();
            if (sslSocketFactory != null) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sslSocketFactory);
            }
            HostnameVerifier hostnameVerifier = request.hostnameVerifier();
            if (hostnameVerifier != null) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
            }
        }
        RequestMethod method = request.method();
        httpURLConnection.setRequestMethod(method.toString());
        httpURLConnection.setDoInput(true);
        boolean a6 = a(method);
        httpURLConnection.setDoOutput(a6);
        Headers headers = request.headers();
        if (a6) {
            long contentLength = headers.getContentLength();
            if (contentLength <= 2147483647L) {
                httpURLConnection.setFixedLengthStreamingMode((int) contentLength);
            } else {
                httpURLConnection.setFixedLengthStreamingMode(contentLength);
            }
        }
        headers.set("Connection", headers.get("Connection").get(0));
        for (Map.Entry<String, String> entry : Headers.getRequestHeaders(headers).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnection.connect();
        return new URLConnection(httpURLConnection);
    }

    private boolean a(RequestMethod requestMethod) {
        return requestMethod.allowBody();
    }
}
