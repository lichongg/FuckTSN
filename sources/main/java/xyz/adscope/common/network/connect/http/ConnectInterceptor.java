package xyz.adscope.common.network.connect.http;

import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.RequestBody;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.ConnectFactory;
import xyz.adscope.common.network.connect.Connection;
import xyz.adscope.common.network.connect.Interceptor;
import xyz.adscope.common.network.connect.Network;
import xyz.adscope.common.network.connect.StreamBody;
import xyz.adscope.common.network.cookie.CookieManager;
import xyz.adscope.common.network.exception.ConnectException;
import xyz.adscope.common.network.exception.ConnectTimeoutError;
import xyz.adscope.common.network.exception.HostError;
import xyz.adscope.common.network.exception.ReadException;
import xyz.adscope.common.network.exception.ReadTimeoutError;
import xyz.adscope.common.network.exception.URLError;
import xyz.adscope.common.network.exception.WriteException;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class ConnectInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private final CookieManager f56579a = new CookieManager(Kalle.getConfig().getCookieStore());

    /* renamed from: b, reason: collision with root package name */
    private final ConnectFactory f56580b = Kalle.getConfig().getConnectFactory();

    /* renamed from: c, reason: collision with root package name */
    private final Network f56581c = Kalle.getConfig().getNetwork();

    /* renamed from: d, reason: collision with root package name */
    private Connection f56582d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f56583e;

    private Connection a(Request request) {
        try {
            Headers headers = request.headers();
            URI uri = new URI(request.url().toString());
            List<String> list = this.f56579a.get(uri);
            if (list != null && !list.isEmpty()) {
                headers.add("Cookie", list);
            }
            headers.set("Host", uri.getHost());
            return this.f56580b.connect(request);
        } catch (MalformedURLException e6) {
            throw new URLError(String.format("The url is malformed: %1$s.", request.url()), e6);
        } catch (SocketTimeoutException e7) {
            throw new ConnectTimeoutError(String.format("Connect time out: %1$s.", request.url()), e7);
        } catch (URISyntaxException e8) {
            throw new URLError(String.format("The url syntax error: %1$s.", request.url()), e8);
        } catch (UnknownHostException e9) {
            throw new HostError(String.format("Hostname can not be resolved: %1$s.", request.url()), e9);
        } catch (Exception e10) {
            throw new ConnectException(String.format("An unknown exception: %1$s.", request.url()), e10);
        }
    }

    public void cancel() {
        this.f56583e = true;
        Connection connection = this.f56582d;
        if (connection != null) {
            connection.disconnect();
        }
    }

    private Response b(Request request) {
        try {
            int code = this.f56582d.getCode();
            Headers a6 = a(this.f56582d.getHeaders());
            List<String> list = a6.get("Set-Cookie");
            if (list != null && !list.isEmpty()) {
                this.f56579a.add(URI.create(request.url().toString()), list);
            }
            return Response.newBuilder().code(code).headers(a6).body(new StreamBody(a6.getContentType(), this.f56582d.getInputStream())).locationUrl(code == 302 ? this.f56582d.getLocationUrl() : "").build();
        } catch (SocketTimeoutException e6) {
            throw new ReadTimeoutError(String.format("Read data time out: %1$s.", request.url()), e6);
        } catch (Exception e7) {
            throw new ReadException(e7);
        }
    }

    @Override // xyz.adscope.common.network.connect.Interceptor
    public Response intercept(Chain chain) {
        if (this.f56583e) {
            throw new CancellationException("The request has been cancelled.");
        }
        Request request = chain.request();
        if (request.method().allowBody()) {
            Headers headers = request.headers();
            RequestBody body = request.body();
            headers.set("Content-Length", Long.toString(body.contentLength()));
            headers.set("Content-Type", body.contentType());
            this.f56582d = a(request);
            a(body);
        } else {
            this.f56582d = a(request);
        }
        return b(request);
    }

    ConnectInterceptor() {
    }

    private void a(RequestBody requestBody) {
        try {
            OutputStream outputStream = this.f56582d.getOutputStream();
            requestBody.writeTo(IOUtils.toBufferedOutputStream(outputStream));
            IOUtils.closeQuietly(outputStream);
        } catch (Exception e6) {
            throw new WriteException(e6);
        }
    }

    private Headers a(Map<String, List<String>> map) {
        Headers headers = new Headers();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            headers.add(entry.getKey(), entry.getValue());
        }
        return headers;
    }
}
