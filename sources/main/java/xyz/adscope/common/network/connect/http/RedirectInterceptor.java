package xyz.adscope.common.network.connect.http;

import xyz.adscope.common.network.BodyRequest;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.UrlRequest;
import xyz.adscope.common.network.connect.Interceptor;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class RedirectInterceptor implements Interceptor {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // xyz.adscope.common.network.connect.Interceptor
    public Response intercept(Chain chain) {
        Request build;
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        if (proceed.isRedirect()) {
            Url location = request.url().location(proceed.headers().getLocation());
            Headers headers = request.headers();
            headers.remove("Cookie");
            RequestMethod method = request.method();
            if (method.allowBody()) {
                build = ((BodyRequest.Builder) BodyRequest.newBuilder(location, method).setHeaders(headers)).setParams(request.copyParams()).body(request.body()).build();
            } else {
                build = ((UrlRequest.Builder) UrlRequest.newBuilder(location, method).setHeaders(headers)).build();
            }
            IOUtils.closeQuietly(proceed);
            return chain.proceed(build);
        }
        return proceed;
    }
}
