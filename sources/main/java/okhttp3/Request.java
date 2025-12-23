package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.EmptyTags;
import okhttp3.internal.IsProbablyUtf8Kt;
import okhttp3.internal.Tags;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http.GzipRequestBody;
import okhttp3.internal.http.HttpMethod;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Request.kt\nokhttp3/Request\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,495:1\n92#1:497\n1#2:496\n1878#3,3:498\n*S KotlinDebug\n*F\n+ 1 Request.kt\nokhttp3/Request\n*L\n107#1:497\n180#1:498,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Request {

    @Nullable
    private final RequestBody body;

    @Nullable
    private final HttpUrl cacheUrlOverride;

    @NotNull
    private final Headers headers;

    @Nullable
    private CacheControl lazyCacheControl;

    @NotNull
    private final String method;

    @NotNull
    private final Tags tags;

    @NotNull
    private final HttpUrl url;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        @Nullable
        private RequestBody body;

        @Nullable
        private HttpUrl cacheUrlOverride;

        @NotNull
        private Headers.Builder headers;

        @NotNull
        private String method;

        @NotNull
        private Tags tags;

        @Nullable
        private HttpUrl url;

        public Builder() {
            this.tags = EmptyTags.INSTANCE;
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        @JvmOverloads
        @NotNull
        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        @JvmName(name = "reifiedTag")
        public final /* synthetic */ <T> Builder reifiedTag(T t5) {
            g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
            return tag((kotlin.reflect.d<kotlin.reflect.d<T>>) o0.d(Object.class), (kotlin.reflect.d<T>) t5);
        }

        @NotNull
        public final <T> Builder tag(@NotNull kotlin.reflect.d<T> type, @Nullable T t5) {
            g0.p(type, "type");
            this.tags = this.tags.plus(type, t5);
            return this;
        }

        @NotNull
        public Builder url(@NotNull HttpUrl url) {
            g0.p(url, "url");
            this.url = url;
            return this;
        }

        private final String canonicalUrl(String str) {
            if (u.F2(str, "ws:", true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("http:");
                String substring = str.substring(3);
                g0.o(substring, "substring(...)");
                sb.append(substring);
                return sb.toString();
            }
            if (!u.F2(str, "wss:", true)) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https:");
            String substring2 = str.substring(4);
            g0.o(substring2, "substring(...)");
            sb2.append(substring2);
            return sb2.toString();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i6 & 1) != 0) {
                requestBody = RequestBody.EMPTY;
            }
            return builder.delete(requestBody);
        }

        @NotNull
        public Builder addHeader(@NotNull String name, @NotNull String value) {
            g0.p(name, "name");
            g0.p(value, "value");
            this.headers.add(name, value);
            return this;
        }

        @NotNull
        public Request build() {
            return new Request(this);
        }

        @NotNull
        public Builder cacheControl(@NotNull CacheControl cacheControl) {
            g0.p(cacheControl, "cacheControl");
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        @NotNull
        public final Builder cacheUrlOverride(@Nullable HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
            return this;
        }

        @JvmOverloads
        @NotNull
        public Builder delete(@Nullable RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        @NotNull
        public Builder get() {
            return method("GET", null);
        }

        @Nullable
        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        @Nullable
        public final HttpUrl getCacheUrlOverride$okhttp() {
            return this.cacheUrlOverride;
        }

        @NotNull
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @NotNull
        public final String getMethod$okhttp() {
            return this.method;
        }

        @NotNull
        public final Tags getTags$okhttp() {
            return this.tags;
        }

        @Nullable
        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        @NotNull
        public final Builder gzip() {
            RequestBody requestBody = this.body;
            if (requestBody == null) {
                throw new IllegalStateException("cannot gzip a request that has no body");
            }
            String str = this.headers.get("Content-Encoding");
            if (str == null) {
                this.headers.add("Content-Encoding", "gzip");
                this.body = new GzipRequestBody(requestBody);
                return this;
            }
            throw new IllegalStateException(("Content-Encoding already set: " + str).toString());
        }

        @NotNull
        public Builder head() {
            return method("HEAD", null);
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

        @NotNull
        public Builder method(@NotNull String method, @Nullable RequestBody requestBody) {
            g0.p(method, "method");
            if (method.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (requestBody == null) {
                if (HttpMethod.requiresRequestBody(method)) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            this.method = method;
            this.body = requestBody;
            return this;
        }

        @NotNull
        public Builder patch(@NotNull RequestBody body) {
            g0.p(body, "body");
            return method("PATCH", body);
        }

        @NotNull
        public Builder post(@NotNull RequestBody body) {
            g0.p(body, "body");
            return method("POST", body);
        }

        @NotNull
        public Builder put(@NotNull RequestBody body) {
            g0.p(body, "body");
            return method("PUT", body);
        }

        @NotNull
        public Builder query(@NotNull RequestBody body) {
            g0.p(body, "body");
            return method("QUERY", body);
        }

        @NotNull
        public Builder removeHeader(@NotNull String name) {
            g0.p(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        public final void setBody$okhttp(@Nullable RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setCacheUrlOverride$okhttp(@Nullable HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
        }

        public final void setHeaders$okhttp(@NotNull Headers.Builder builder) {
            g0.p(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(@NotNull String str) {
            g0.p(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(@NotNull Tags tags) {
            g0.p(tags, "<set-?>");
            this.tags = tags;
        }

        public final void setUrl$okhttp(@Nullable HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        @NotNull
        public Builder tag(@Nullable Object obj) {
            return tag((kotlin.reflect.d<kotlin.reflect.d>) o0.d(Object.class), (kotlin.reflect.d) obj);
        }

        @NotNull
        public Builder url(@NotNull String url) {
            g0.p(url, "url");
            return url(HttpUrl.Companion.get(canonicalUrl(url)));
        }

        @NotNull
        public <T> Builder tag(@NotNull Class<? super T> type, @Nullable T t5) {
            g0.p(type, "type");
            return tag((kotlin.reflect.d<kotlin.reflect.d<T>>) l3.a.i(type), (kotlin.reflect.d<T>) t5);
        }

        @NotNull
        public Builder url(@NotNull URL url) {
            g0.p(url, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String url2 = url.toString();
            g0.o(url2, "toString(...)");
            return url(companion.get(url2));
        }

        public Builder(@NotNull Request request) {
            g0.p(request, "request");
            this.tags = EmptyTags.INSTANCE;
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            this.tags = request.getTags$okhttp();
            this.headers = request.headers().newBuilder();
            this.cacheUrlOverride = request.cacheUrlOverride();
        }
    }

    public Request(@NotNull Builder builder) {
        g0.p(builder, "builder");
        HttpUrl url$okhttp = builder.getUrl$okhttp();
        if (url$okhttp == null) {
            throw new IllegalStateException("url == null");
        }
        this.url = url$okhttp;
        this.method = builder.getMethod$okhttp();
        this.headers = builder.getHeaders$okhttp().build();
        this.body = builder.getBody$okhttp();
        this.cacheUrlOverride = builder.getCacheUrlOverride$okhttp();
        this.tags = builder.getTags$okhttp();
    }

    public static /* synthetic */ String toCurl$default(Request request, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        return request.toCurl(z5);
    }

    @JvmName(name = "headers")
    @NotNull
    public final Headers headers() {
        return this.headers;
    }

    @JvmName(name = "reifiedTag")
    public final /* synthetic */ <T> T reifiedTag() {
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) tag(o0.d(Object.class));
    }

    @Nullable
    public final <T> T tag(@NotNull kotlin.reflect.d<T> type) {
        g0.p(type, "type");
        return (T) l3.a.e(type).cast(this.tags.get(type));
    }

    @JvmOverloads
    @NotNull
    public final String toCurl() {
        return toCurl$default(this, false, 1, null);
    }

    private final String shellEscape(String str) {
        return '\'' + u.x2(str, "'", "'\\''", false, 4, null) + '\'';
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    @JvmName(name = "-deprecated_body")
    @Nullable
    /* renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m266deprecated_body() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    @JvmName(name = "-deprecated_headers")
    @NotNull
    /* renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m268deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "method", imports = {}))
    @JvmName(name = "-deprecated_method")
    @NotNull
    /* renamed from: -deprecated_method, reason: not valid java name */
    public final String m269deprecated_method() {
        return this.method;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    @JvmName(name = "-deprecated_url")
    @NotNull
    /* renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m270deprecated_url() {
        return this.url;
    }

    @JvmName(name = "body")
    @Nullable
    public final RequestBody body() {
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

    @JvmName(name = "cacheUrlOverride")
    @Nullable
    public final HttpUrl cacheUrlOverride() {
        return this.cacheUrlOverride;
    }

    @NotNull
    public final Tags getTags$okhttp() {
        return this.tags;
    }

    @Nullable
    public final String header(@NotNull String name) {
        g0.p(name, "name");
        return this.headers.get(name);
    }

    @NotNull
    public final List<String> headers(@NotNull String name) {
        g0.p(name, "name");
        return this.headers.values(name);
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    @JvmName(name = "method")
    @NotNull
    public final String method() {
        return this.method;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public final <T> T tag(@NotNull Class<? extends T> type) {
        g0.p(type, "type");
        return (T) tag(l3.a.i(type));
    }

    @JvmOverloads
    @NotNull
    public final String toCurl(boolean z5) {
        MediaType contentType;
        StringBuilder sb = new StringBuilder();
        sb.append("curl " + shellEscape(this.url.toString()));
        RequestBody requestBody = this.body;
        String mediaType = (requestBody == null || (contentType = requestBody.contentType()) == null) ? null : contentType.toString();
        if (!g0.g(this.method, (!z5 || this.body == null) ? "GET" : "POST")) {
            sb.append(" \\\n  -X " + shellEscape(this.method));
        }
        Iterator<Pair<? extends String, ? extends String>> it = this.headers.iterator();
        while (it.hasNext()) {
            Pair<? extends String, ? extends String> next = it.next();
            String component1 = next.component1();
            String component2 = next.component2();
            if (mediaType == null || !u.a2(component1, "Content-Type", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" \\\n  -H ");
                sb2.append(shellEscape(component1 + ": " + component2));
                sb.append(sb2.toString());
            }
        }
        if (mediaType != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" \\\n  -H ");
            sb3.append(shellEscape("Content-Type: " + mediaType));
            sb.append(sb3.toString());
        }
        if (z5 && this.body != null) {
            Buffer buffer = new Buffer();
            this.body.writeTo(buffer);
            if (IsProbablyUtf8Kt.isProbablyUtf8$default(buffer, 0L, 1, null)) {
                sb.append(" \\\n  --data " + shellEscape(buffer.readUtf8()));
            } else {
                sb.append(" \\\n  --data-binary " + shellEscape(buffer.readByteString().hex()));
            }
        }
        return sb.toString();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i6 = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    f0.b0();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String component1 = pair2.component1();
                String component2 = pair2.component2();
                if (i6 > 0) {
                    sb.append(", ");
                }
                sb.append(component1);
                sb.append(':');
                if (_UtilCommonKt.isSensitiveHeader(component1)) {
                    component2 = "██";
                }
                sb.append(component2);
                i6 = i7;
            }
            sb.append(']');
        }
        if (!g0.g(this.tags, EmptyTags.INSTANCE)) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        return sb.toString();
    }

    @JvmName(name = "url")
    @NotNull
    public final HttpUrl url() {
        return this.url;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))
    @JvmName(name = "-deprecated_cacheControl")
    @NotNull
    /* renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m267deprecated_cacheControl() {
        return cacheControl();
    }

    @Nullable
    public final Object tag() {
        return tag(o0.d(Object.class));
    }

    public /* synthetic */ Request(HttpUrl httpUrl, Headers headers, String str, RequestBody requestBody, int i6, v vVar) {
        this(httpUrl, (i6 & 2) != 0 ? Headers.Companion.of(new String[0]) : headers, (i6 & 4) != 0 ? "\u0000" : str, (i6 & 8) != 0 ? null : requestBody);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Request(@org.jetbrains.annotations.NotNull okhttp3.HttpUrl r2, @org.jetbrains.annotations.NotNull okhttp3.Headers r3, @org.jetbrains.annotations.NotNull java.lang.String r4, @org.jetbrains.annotations.Nullable okhttp3.RequestBody r5) {
        /*
            r1 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.g0.p(r2, r0)
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.g0.p(r3, r0)
            java.lang.String r0 = "method"
            kotlin.jvm.internal.g0.p(r4, r0)
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
            r0.<init>()
            okhttp3.Request$Builder r2 = r0.url(r2)
            okhttp3.Request$Builder r2 = r2.headers(r3)
            java.lang.String r3 = "\u0000"
            boolean r3 = kotlin.jvm.internal.g0.g(r4, r3)
            if (r3 != 0) goto L25
            goto L2c
        L25:
            if (r5 == 0) goto L2a
            java.lang.String r4 = "POST"
            goto L2c
        L2a:
            java.lang.String r4 = "GET"
        L2c:
            okhttp3.Request$Builder r2 = r2.method(r4, r5)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Request.<init>(okhttp3.HttpUrl, okhttp3.Headers, java.lang.String, okhttp3.RequestBody):void");
    }
}
