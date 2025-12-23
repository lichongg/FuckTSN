package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.UnreadableResponseBodyKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CacheInterceptor implements Interceptor {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final Cache cache;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i6 = 0; i6 < size; i6++) {
                String name = headers.name(i6);
                String value = headers.value(i6);
                if ((!u.a2("Warning", name, true) || !u.H2(value, "1", false, 2, null)) && (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                String name2 = headers2.name(i7);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i7));
                }
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            return u.a2("Content-Length", str, true) || u.a2("Content-Encoding", str, true) || u.a2("Content-Type", str, true);
        }

        private final boolean isEndToEnd(String str) {
            return (u.a2("Connection", str, true) || u.a2("Keep-Alive", str, true) || u.a2("Proxy-Authenticate", str, true) || u.a2("Proxy-Authorization", str, true) || u.a2("TE", str, true) || u.a2("Trailers", str, true) || u.a2("Transfer-Encoding", str, true) || u.a2("Upgrade", str, true)) ? false : true;
        }
    }

    private final Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        final BufferedSource source = response.body().source();
        final BufferedSink buffer = Okio.buffer(body);
        Source source2 = new Source() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
            private boolean cacheRequestClosed;

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                BufferedSource.this.close();
            }

            @Override // okio.Source
            public long read(Buffer sink, long j6) throws IOException {
                g0.p(sink, "sink");
                try {
                    long read = BufferedSource.this.read(sink, j6);
                    if (read != -1) {
                        sink.copyTo(buffer.getBuffer(), sink.size() - read, read);
                        buffer.emitCompleteSegments();
                        return read;
                    }
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        buffer.close();
                    }
                    return -1L;
                } catch (IOException e6) {
                    if (this.cacheRequestClosed) {
                        throw e6;
                    }
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                    throw e6;
                }
            }

            @Override // okio.Source
            public Timeout timeout() {
                return BufferedSource.this.timeout();
            }
        };
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null), response.body().contentLength(), Okio.buffer(source2))).build();
    }

    @Nullable
    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Response response;
        EventListener eventListener;
        Request requestForCache;
        Request requestForCache2;
        g0.p(chain, "chain");
        Call call = chain.call();
        Cache cache = this.cache;
        if (cache != null) {
            requestForCache2 = CacheInterceptorKt.requestForCache(chain.request());
            response = cache.get$okhttp(requestForCache2);
        } else {
            response = null;
        }
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(compute);
        }
        RealCall realCall = call instanceof RealCall ? (RealCall) call : null;
        if (realCall == null || (eventListener = realCall.getEventListener$okhttp()) == null) {
            eventListener = EventListener.NONE;
        }
        if (response != null && cacheResponse == null) {
            _UtilCommonKt.closeQuietly(response.body());
        }
        if (networkRequest == null && cacheResponse == null) {
            Response build = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener.satisfactionFailure(call, build);
            return build;
        }
        if (networkRequest == null) {
            g0.m(cacheResponse);
            Response build2 = cacheResponse.newBuilder().cacheResponse(UnreadableResponseBodyKt.stripBody(cacheResponse)).build();
            eventListener.cacheHit(call, build2);
            return build2;
        }
        if (cacheResponse != null) {
            eventListener.cacheConditionalHit(call, cacheResponse);
        } else if (this.cache != null) {
            eventListener.cacheMiss(call);
        }
        try {
            Response proceed = chain.proceed(networkRequest);
            if (proceed == null && response != null) {
            }
            if (cacheResponse != null) {
                if (proceed != null && proceed.code() == 304) {
                    Response build3 = cacheResponse.newBuilder().headers(Companion.combine(cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(UnreadableResponseBodyKt.stripBody(cacheResponse)).networkResponse(UnreadableResponseBodyKt.stripBody(proceed)).build();
                    proceed.body().close();
                    Cache cache3 = this.cache;
                    g0.m(cache3);
                    cache3.trackConditionalCacheHit$okhttp();
                    this.cache.update$okhttp(cacheResponse, build3);
                    eventListener.cacheHit(call, build3);
                    return build3;
                }
                _UtilCommonKt.closeQuietly(cacheResponse.body());
            }
            g0.m(proceed);
            Response build4 = proceed.newBuilder().cacheResponse(cacheResponse != null ? UnreadableResponseBodyKt.stripBody(cacheResponse) : null).networkResponse(UnreadableResponseBodyKt.stripBody(proceed)).build();
            if (this.cache != null) {
                requestForCache = CacheInterceptorKt.requestForCache(networkRequest);
                if (HttpHeaders.promisesBody(build4) && CacheStrategy.Companion.isCacheable(build4, requestForCache)) {
                    Response cacheWritingResponse = cacheWritingResponse(this.cache.put$okhttp(build4.newBuilder().request(requestForCache).build()), build4);
                    if (cacheResponse != null) {
                        eventListener.cacheMiss(call);
                    }
                    return cacheWritingResponse;
                }
                if (HttpMethod.invalidatesCache(networkRequest.method())) {
                    try {
                        this.cache.remove$okhttp(networkRequest);
                    } catch (IOException unused) {
                    }
                }
            }
            return build4;
        } finally {
            if (response != null) {
                _UtilCommonKt.closeQuietly(response.body());
            }
        }
    }

    public CacheInterceptor(@Nullable Cache cache) {
        this.cache = cache;
    }
}
