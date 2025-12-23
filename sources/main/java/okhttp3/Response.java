package okhttp3;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.Socket;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Response implements Closeable {

    @NotNull
    private final ResponseBody body;

    @Nullable
    private final Response cacheResponse;
    private final int code;

    @Nullable
    private final Exchange exchange;

    @Nullable
    private final Handshake handshake;

    @NotNull
    private final Headers headers;
    private final boolean isRedirect;
    private final boolean isSuccessful;

    @Nullable
    private CacheControl lazyCacheControl;

    @NotNull
    private final String message;

    @Nullable
    private final Response networkResponse;

    @Nullable
    private final Response priorResponse;

    @NotNull
    private final Protocol protocol;
    private final long receivedResponseAtMillis;

    @NotNull
    private final Request request;
    private final long sentRequestAtMillis;

    @Nullable
    private final Socket socket;

    @NotNull
    private TrailersSource trailersSource;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Response.kt\nokhttp3/Response$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,530:1\n1#2:531\n*E\n"})
    public static class Builder {

        @NotNull
        private ResponseBody body;

        @Nullable
        private Response cacheResponse;
        private int code;

        @Nullable
        private Exchange exchange;

        @Nullable
        private Handshake handshake;

        @NotNull
        private Headers.Builder headers;

        @Nullable
        private String message;

        @Nullable
        private Response networkResponse;

        @Nullable
        private Response priorResponse;

        @Nullable
        private Protocol protocol;
        private long receivedResponseAtMillis;

        @Nullable
        private Request request;
        private long sentRequestAtMillis;

        @Nullable
        private Socket socket;

        @NotNull
        private TrailersSource trailersSource;

        public Builder() {
            this.code = -1;
            this.body = ResponseBody.EMPTY;
            this.trailersSource = TrailersSource.EMPTY;
            this.headers = new Headers.Builder();
        }

        private final void checkSupportResponse(String str, Response response) {
            if (response != null) {
                if (response.networkResponse() != null) {
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                if (response.cacheResponse() != null) {
                    throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                }
                if (response.priorResponse() == null) {
                    return;
                }
                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
            }
        }

        @NotNull
        public Builder addHeader(@NotNull String name, @NotNull String value) {
            g0.p(name, "name");
            g0.p(value, "value");
            this.headers.add(name, value);
            return this;
        }

        @NotNull
        public Builder body(@NotNull ResponseBody body) {
            g0.p(body, "body");
            this.body = body;
            return this;
        }

        @NotNull
        public Response build() {
            int i6 = this.code;
            if (i6 < 0) {
                throw new IllegalStateException(("code < 0: " + this.code).toString());
            }
            Request request = this.request;
            if (request == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.message;
            if (str != null) {
                return new Response(request, protocol, str, i6, this.handshake, this.headers.build(), this.body, this.socket, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange, this.trailersSource);
            }
            throw new IllegalStateException("message == null");
        }

        @NotNull
        public Builder cacheResponse(@Nullable Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        @NotNull
        public Builder code(int i6) {
            this.code = i6;
            return this;
        }

        @NotNull
        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        @Nullable
        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        @Nullable
        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        @Nullable
        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        @NotNull
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @Nullable
        public final String getMessage$okhttp() {
            return this.message;
        }

        @Nullable
        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        @Nullable
        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        @Nullable
        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        @Nullable
        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        @Nullable
        public final Socket getSocket$okhttp() {
            return this.socket;
        }

        @NotNull
        public final TrailersSource getTrailersSource$okhttp() {
            return this.trailersSource;
        }

        @NotNull
        public Builder handshake(@Nullable Handshake handshake) {
            this.handshake = handshake;
            return this;
        }

        @NotNull
        public Builder header(@NotNull String name, @NotNull String value) {
            g0.p(name, "name");
            g0.p(value, "value");
            this.headers.set(name, value);
            return this;
        }

        @NotNull
        public Builder headers(@NotNull Headers headers) {
            g0.p(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        public final void initExchange$okhttp(@NotNull Exchange exchange) {
            g0.p(exchange, "exchange");
            this.exchange = exchange;
        }

        @NotNull
        public Builder message(@NotNull String message) {
            g0.p(message, "message");
            this.message = message;
            return this;
        }

        @NotNull
        public Builder networkResponse(@Nullable Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        @NotNull
        public Builder priorResponse(@Nullable Response response) {
            this.priorResponse = response;
            return this;
        }

        @NotNull
        public Builder protocol(@NotNull Protocol protocol) {
            g0.p(protocol, "protocol");
            this.protocol = protocol;
            return this;
        }

        @NotNull
        public Builder receivedResponseAtMillis(long j6) {
            this.receivedResponseAtMillis = j6;
            return this;
        }

        @NotNull
        public Builder removeHeader(@NotNull String name) {
            g0.p(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        @NotNull
        public Builder request(@NotNull Request request) {
            g0.p(request, "request");
            this.request = request;
            return this;
        }

        @NotNull
        public Builder sentRequestAtMillis(long j6) {
            this.sentRequestAtMillis = j6;
            return this;
        }

        public final void setBody$okhttp(@NotNull ResponseBody responseBody) {
            g0.p(responseBody, "<set-?>");
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(@Nullable Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i6) {
            this.code = i6;
        }

        public final void setExchange$okhttp(@Nullable Exchange exchange) {
            this.exchange = exchange;
        }

        public final void setHandshake$okhttp(@Nullable Handshake handshake) {
            this.handshake = handshake;
        }

        public final void setHeaders$okhttp(@NotNull Headers.Builder builder) {
            g0.p(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(@Nullable String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(@Nullable Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(@Nullable Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(@Nullable Protocol protocol) {
            this.protocol = protocol;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j6) {
            this.receivedResponseAtMillis = j6;
        }

        public final void setRequest$okhttp(@Nullable Request request) {
            this.request = request;
        }

        public final void setSentRequestAtMillis$okhttp(long j6) {
            this.sentRequestAtMillis = j6;
        }

        public final void setSocket$okhttp(@Nullable Socket socket) {
            this.socket = socket;
        }

        public final void setTrailersSource$okhttp(@NotNull TrailersSource trailersSource) {
            g0.p(trailersSource, "<set-?>");
            this.trailersSource = trailersSource;
        }

        @NotNull
        public Builder socket(@NotNull Socket socket) {
            g0.p(socket, "socket");
            this.socket = socket;
            return this;
        }

        @NotNull
        public Builder trailers(@NotNull TrailersSource trailersSource) {
            g0.p(trailersSource, "trailersSource");
            this.trailersSource = trailersSource;
            return this;
        }

        public Builder(@NotNull Response response) {
            g0.p(response, "response");
            this.code = -1;
            this.body = ResponseBody.EMPTY;
            this.trailersSource = TrailersSource.EMPTY;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.socket = response.socket();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
            this.trailersSource = response.trailersSource;
        }
    }

    @JvmOverloads
    @Nullable
    public final String header(@NotNull String name) {
        g0.p(name, "name");
        return header$default(this, name, null, 2, null);
    }

    @JvmName(name = "headers")
    @NotNull
    public final Headers headers() {
        return this.headers;
    }

    public Response(@NotNull Request request, @NotNull Protocol protocol, @NotNull String message, int i6, @Nullable Handshake handshake, @NotNull Headers headers, @NotNull ResponseBody body, @Nullable Socket socket, @Nullable Response response, @Nullable Response response2, @Nullable Response response3, long j6, long j7, @Nullable Exchange exchange, @NotNull TrailersSource trailersSource) {
        g0.p(request, "request");
        g0.p(protocol, "protocol");
        g0.p(message, "message");
        g0.p(headers, "headers");
        g0.p(body, "body");
        g0.p(trailersSource, "trailersSource");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i6;
        this.handshake = handshake;
        this.headers = headers;
        this.body = body;
        this.socket = socket;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j6;
        this.receivedResponseAtMillis = j7;
        this.exchange = exchange;
        this.trailersSource = trailersSource;
        boolean z5 = true;
        this.isSuccessful = 200 <= i6 && i6 < 300;
        if (i6 != 307 && i6 != 308) {
            switch (i6) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    z5 = false;
                    break;
            }
        }
        this.isRedirect = z5;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    @JvmName(name = "-deprecated_body")
    @NotNull
    /* renamed from: -deprecated_body, reason: not valid java name */
    public final ResponseBody m271deprecated_body() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheResponse", imports = {}))
    @JvmName(name = "-deprecated_cacheResponse")
    @Nullable
    /* renamed from: -deprecated_cacheResponse, reason: not valid java name */
    public final Response m273deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "code", imports = {}))
    @JvmName(name = "-deprecated_code")
    /* renamed from: -deprecated_code, reason: not valid java name */
    public final int m274deprecated_code() {
        return this.code;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "handshake", imports = {}))
    @JvmName(name = "-deprecated_handshake")
    @Nullable
    /* renamed from: -deprecated_handshake, reason: not valid java name */
    public final Handshake m275deprecated_handshake() {
        return this.handshake;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    @JvmName(name = "-deprecated_headers")
    @NotNull
    /* renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m276deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = CrashHianalyticsData.MESSAGE, imports = {}))
    @JvmName(name = "-deprecated_message")
    @NotNull
    /* renamed from: -deprecated_message, reason: not valid java name */
    public final String m277deprecated_message() {
        return this.message;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "networkResponse", imports = {}))
    @JvmName(name = "-deprecated_networkResponse")
    @Nullable
    /* renamed from: -deprecated_networkResponse, reason: not valid java name */
    public final Response m278deprecated_networkResponse() {
        return this.networkResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "priorResponse", imports = {}))
    @JvmName(name = "-deprecated_priorResponse")
    @Nullable
    /* renamed from: -deprecated_priorResponse, reason: not valid java name */
    public final Response m279deprecated_priorResponse() {
        return this.priorResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocol", imports = {}))
    @JvmName(name = "-deprecated_protocol")
    @NotNull
    /* renamed from: -deprecated_protocol, reason: not valid java name */
    public final Protocol m280deprecated_protocol() {
        return this.protocol;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "receivedResponseAtMillis", imports = {}))
    @JvmName(name = "-deprecated_receivedResponseAtMillis")
    /* renamed from: -deprecated_receivedResponseAtMillis, reason: not valid java name */
    public final long m281deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "request", imports = {}))
    @JvmName(name = "-deprecated_request")
    @NotNull
    /* renamed from: -deprecated_request, reason: not valid java name */
    public final Request m282deprecated_request() {
        return this.request;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sentRequestAtMillis", imports = {}))
    @JvmName(name = "-deprecated_sentRequestAtMillis")
    /* renamed from: -deprecated_sentRequestAtMillis, reason: not valid java name */
    public final long m283deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @JvmName(name = "body")
    @NotNull
    public final ResponseBody body() {
        return this.body;
    }

    @JvmName(name = "cacheControl")
    @NotNull
    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    @JvmName(name = "cacheResponse")
    @Nullable
    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    @NotNull
    public final List<Challenge> challenges() {
        String str;
        Headers headers = this.headers;
        int i6 = this.code;
        if (i6 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i6 != 407) {
                return f0.J();
            }
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.body.close();
    }

    @JvmName(name = "code")
    public final int code() {
        return this.code;
    }

    @JvmName(name = "exchange")
    @Nullable
    public final Exchange exchange() {
        return this.exchange;
    }

    @Nullable
    public final CacheControl getLazyCacheControl$okhttp() {
        return this.lazyCacheControl;
    }

    @JvmName(name = "handshake")
    @Nullable
    public final Handshake handshake() {
        return this.handshake;
    }

    @JvmOverloads
    @Nullable
    public final String header(@NotNull String name, @Nullable String str) {
        g0.p(name, "name");
        String str2 = this.headers.get(name);
        return str2 == null ? str : str2;
    }

    @NotNull
    public final List<String> headers(@NotNull String name) {
        g0.p(name, "name");
        return this.headers.values(name);
    }

    public final boolean isRedirect() {
        return this.isRedirect;
    }

    public final boolean isSuccessful() {
        return this.isSuccessful;
    }

    @JvmName(name = CrashHianalyticsData.MESSAGE)
    @NotNull
    public final String message() {
        return this.message;
    }

    @JvmName(name = "networkResponse")
    @Nullable
    public final Response networkResponse() {
        return this.networkResponse;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @NotNull
    public final ResponseBody peekBody(long j6) throws IOException {
        BufferedSource peek = this.body.source().peek();
        Buffer buffer = new Buffer();
        peek.request(j6);
        buffer.write((Source) peek, Math.min(j6, peek.getBuffer().size()));
        return ResponseBody.Companion.create(buffer, this.body.contentType(), buffer.size());
    }

    @Nullable
    public final Headers peekTrailers() throws IOException {
        return this.trailersSource.peek();
    }

    @JvmName(name = "priorResponse")
    @Nullable
    public final Response priorResponse() {
        return this.priorResponse;
    }

    @JvmName(name = "protocol")
    @NotNull
    public final Protocol protocol() {
        return this.protocol;
    }

    @JvmName(name = "receivedResponseAtMillis")
    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @JvmName(name = "request")
    @NotNull
    public final Request request() {
        return this.request;
    }

    @JvmName(name = "sentRequestAtMillis")
    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final void setLazyCacheControl$okhttp(@Nullable CacheControl cacheControl) {
        this.lazyCacheControl = cacheControl;
    }

    @JvmName(name = "socket")
    @Nullable
    public final Socket socket() {
        return this.socket;
    }

    @NotNull
    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    @NotNull
    public final Headers trailers() throws IOException {
        return this.trailersSource.get();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))
    @JvmName(name = "-deprecated_cacheControl")
    @NotNull
    /* renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m272deprecated_cacheControl() {
        return cacheControl();
    }
}
