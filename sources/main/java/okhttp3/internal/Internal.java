package okhttp3.internal;

import java.nio.charset.Charset;
import javax.net.ssl.SSLSocket;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import kotlin.text.e;
import okhttp3.Cache;
import okhttp3.CipherSuite;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionListener;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "Internal")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Internal {
    @NotNull
    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder builder, @NotNull String line) {
        g0.p(builder, "builder");
        g0.p(line, "line");
        return builder.addLenient$okhttp(line);
    }

    @NotNull
    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        g0.p(builder, "builder");
        g0.p(name, "name");
        g0.p(value, "value");
        return builder.addLenient$okhttp(name, value);
    }

    public static final void applyConnectionSpec(@NotNull ConnectionSpec connectionSpec, @NotNull SSLSocket sslSocket, boolean z5) {
        g0.p(connectionSpec, "connectionSpec");
        g0.p(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z5);
    }

    @NotNull
    public static final ConnectionPool buildConnectionPool(@NotNull ConnectionListener connectionListener, @NotNull TaskRunner taskRunner) {
        g0.p(connectionListener, "connectionListener");
        g0.p(taskRunner, "taskRunner");
        return new ConnectionPool(0, 0L, null, taskRunner, connectionListener, 7, null);
    }

    @Nullable
    public static final Response cacheGet(@NotNull Cache cache, @NotNull Request request) {
        g0.p(cache, "cache");
        g0.p(request, "request");
        return cache.get$okhttp(request);
    }

    @NotNull
    public static final Charset charsetOrUtf8(@Nullable MediaType mediaType) {
        Charset charset$default;
        return (mediaType == null || (charset$default = MediaType.charset$default(mediaType, null, 1, null)) == null) ? e.f47851b : charset$default;
    }

    @NotNull
    public static final Pair<Charset, MediaType> chooseCharset(@Nullable MediaType mediaType) {
        Charset charset = e.f47851b;
        if (mediaType != null) {
            Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
            if (charset$default == null) {
                mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset$default;
            }
        }
        return o0.a(charset, mediaType);
    }

    @NotNull
    public static final String cookieToString(@NotNull Cookie cookie, boolean z5) {
        g0.p(cookie, "cookie");
        return cookie.toString$okhttp(z5);
    }

    @NotNull
    public static final String[] effectiveCipherSuites(@NotNull ConnectionSpec connectionSpec, @NotNull String[] socketEnabledCipherSuites) {
        g0.p(connectionSpec, "<this>");
        g0.p(socketEnabledCipherSuites, "socketEnabledCipherSuites");
        return connectionSpec.getCipherSuitesAsString$okhttp() != null ? _UtilCommonKt.intersect(connectionSpec.getCipherSuitesAsString$okhttp(), socketEnabledCipherSuites, CipherSuite.Companion.getORDER_BY_NAME$okhttp()) : socketEnabledCipherSuites;
    }

    @NotNull
    public static final RealConnection getConnection(@NotNull Response response) {
        g0.p(response, "<this>");
        Exchange exchange = response.exchange();
        g0.m(exchange);
        return exchange.getConnection$okhttp();
    }

    @Nullable
    public static final Cookie parseCookie(long j6, @NotNull HttpUrl url, @NotNull String setCookie) {
        g0.p(url, "url");
        g0.p(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j6, url, setCookie);
    }

    @NotNull
    public static final OkHttpClient.Builder taskRunnerInternal(@NotNull OkHttpClient.Builder builder, @NotNull TaskRunner taskRunner) {
        g0.p(builder, "<this>");
        g0.p(taskRunner, "taskRunner");
        return builder.taskRunner$okhttp(taskRunner);
    }
}
