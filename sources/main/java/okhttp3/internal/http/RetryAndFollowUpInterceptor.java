package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.UnreadableResponseBodyKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ConnectionShutdownException;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int MAX_FOLLOW_UPS = 20;

    @NotNull
    private final OkHttpClient client;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    private final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        RealConnection connection$okhttp;
        Route route = (exchange == null || (connection$okhttp = exchange.getConnection$okhttp()) == null) ? null : connection$okhttp.route();
        int code = response.code();
        String method = response.request().method();
        if (code != 307 && code != 308) {
            if (code == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (code == 421) {
                RequestBody body = response.request().body();
                if ((body != null && body.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return response.request();
            }
            if (code == 503) {
                Response priorResponse = response.priorResponse();
                if ((priorResponse == null || priorResponse.code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (code == 407) {
                g0.m(route);
                if (route.proxy().type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (code == 408) {
                if (!this.client.retryOnConnectionFailure()) {
                    return null;
                }
                RequestBody body2 = response.request().body();
                if (body2 != null && body2.isOneShot()) {
                    return null;
                }
                Response priorResponse2 = response.priorResponse();
                if ((priorResponse2 == null || priorResponse2.code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (code) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return buildRedirectRequest(response, method);
    }

    private final int retryAfter(Response response, int i6) {
        String header$default = Response.header$default(response, "Retry-After", null, 2, null);
        if (header$default == null) {
            return i6;
        }
        if (!new Regex("\\d+").matches(header$default)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(header$default);
        g0.o(valueOf, "valueOf(...)");
        return valueOf.intValue();
    }

    public RetryAndFollowUpInterceptor(@NotNull OkHttpClient client) {
        g0.p(client, "client");
        this.client = client;
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String header$default;
        HttpUrl resolve;
        if (!this.client.followRedirects() || (header$default = Response.header$default(response, "Location", null, 2, null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (!g0.g(resolve.scheme(), response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(str)) {
            int code = response.code();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            boolean z5 = httpMethod.redirectsWithBody(str) || code == 308 || code == 307;
            if (!httpMethod.redirectsToGet(str) || code == 308 || code == 307) {
                newBuilder.method(str, z5 ? response.request().body() : null);
            } else {
                newBuilder.method("GET", null);
            }
            if (!z5) {
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!_UtilJvmKt.canReuseConnectionFor(response.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private final boolean isRecoverable(IOException iOException, boolean z5) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z5 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request) {
        boolean z5 = iOException instanceof ConnectionShutdownException;
        boolean z6 = !z5;
        if (this.client.retryOnConnectionFailure()) {
            return (z5 || !requestIsOneShot(iOException, request)) && isRecoverable(iOException, z6) && realCall.retryAfterFailure();
        }
        return false;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Exchange interceptorScopedExchange$okhttp;
        Request followUpRequest;
        g0.p(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RealCall call$okhttp = realInterceptorChain.getCall$okhttp();
        List J = f0.J();
        boolean z5 = false;
        Response response = null;
        boolean z6 = true;
        int i6 = 0;
        while (true) {
            call$okhttp.enterNetworkInterceptorExchange(request$okhttp, z6, realInterceptorChain);
            try {
                if (call$okhttp.isCanceled()) {
                    throw new IOException("Canceled");
                }
                try {
                    response = realInterceptorChain.proceed(request$okhttp).newBuilder().request(request$okhttp).priorResponse(response != null ? UnreadableResponseBodyKt.stripBody(response) : null).build();
                    interceptorScopedExchange$okhttp = call$okhttp.getInterceptorScopedExchange$okhttp();
                    followUpRequest = followUpRequest(response, interceptorScopedExchange$okhttp);
                } catch (IOException e6) {
                    boolean recover = recover(e6, call$okhttp, request$okhttp);
                    call$okhttp.getEventListener$okhttp().retryDecision(call$okhttp, e6, recover);
                    if (!recover) {
                        throw _UtilCommonKt.withSuppressed(e6, J);
                    }
                    J = f0.J4(J, e6);
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                    z6 = false;
                }
                try {
                    if (followUpRequest == null) {
                        if (interceptorScopedExchange$okhttp != null && interceptorScopedExchange$okhttp.isDuplex$okhttp()) {
                            call$okhttp.timeoutEarlyExit();
                        }
                        call$okhttp.getEventListener$okhttp().followUpDecision(call$okhttp, response, null);
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    RequestBody body = followUpRequest.body();
                    if (body != null && body.isOneShot()) {
                        call$okhttp.getEventListener$okhttp().followUpDecision(call$okhttp, response, null);
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    _UtilCommonKt.closeQuietly(response.body());
                    i6++;
                    if (i6 > 20) {
                        call$okhttp.getEventListener$okhttp().followUpDecision(call$okhttp, response, null);
                        throw new ProtocolException("Too many follow-up requests: " + i6);
                    }
                    call$okhttp.getEventListener$okhttp().followUpDecision(call$okhttp, response, followUpRequest);
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                    request$okhttp = followUpRequest;
                    z6 = true;
                } catch (Throwable th) {
                    th = th;
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(z5);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z5 = true;
            }
        }
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        if ((body != null && body.isOneShot()) || (iOException instanceof FileNotFoundException)) {
            return true;
        }
        return false;
    }
}
