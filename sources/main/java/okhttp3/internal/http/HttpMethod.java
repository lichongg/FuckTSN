package okhttp3.internal.http;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class HttpMethod {

    @NotNull
    public static final HttpMethod INSTANCE = new HttpMethod();

    @JvmStatic
    public static final boolean invalidatesCache(@NotNull String method) {
        g0.p(method, "method");
        return g0.g(method, "POST") || g0.g(method, "PATCH") || g0.g(method, "PUT") || g0.g(method, "DELETE") || g0.g(method, "MOVE");
    }

    @JvmStatic
    public static final boolean permitsRequestBody(@NotNull String method) {
        g0.p(method, "method");
        return (g0.g(method, "GET") || g0.g(method, "HEAD")) ? false : true;
    }

    @JvmStatic
    public static final boolean requiresRequestBody(@NotNull String method) {
        g0.p(method, "method");
        return g0.g(method, "POST") || g0.g(method, "PUT") || g0.g(method, "PATCH") || g0.g(method, "PROPPATCH") || g0.g(method, "QUERY") || g0.g(method, "REPORT");
    }

    public final boolean isCacheable(@NotNull String requestMethod) {
        g0.p(requestMethod, "requestMethod");
        return g0.g(requestMethod, "GET") || g0.g(requestMethod, "QUERY");
    }

    public final boolean redirectsToGet(@NotNull String method) {
        g0.p(method, "method");
        return !g0.g(method, "PROPFIND");
    }

    public final boolean redirectsWithBody(@NotNull String method) {
        g0.p(method, "method");
        return g0.g(method, "PROPFIND");
    }

    private HttpMethod() {
    }
}
