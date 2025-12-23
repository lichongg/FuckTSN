package okhttp3;

import androidx.activity.k;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.collections.u1;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.text.u;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Cache implements Closeable, Flushable {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;

    @NotNull
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class CacheResponseBody extends ResponseBody {

        @NotNull
        private final BufferedSource bodySource;

        @Nullable
        private final String contentLength;

        @Nullable
        private final String contentType;

        @NotNull
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(@NotNull DiskLruCache.Snapshot snapshot, @Nullable String str, @Nullable String str2) {
            g0.p(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.buffer(new ForwardingSource(snapshot.getSource(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return _UtilCommonKt.toLongOrDefault(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        @Nullable
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        @NotNull
        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        @NotNull
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cache.kt\nokhttp3/Cache$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,838:1\n2746#2,3:839\n*S KotlinDebug\n*F\n+ 1 Cache.kt\nokhttp3/Cache$Companion\n*L\n777#1:839,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @NotNull
        public final Headers varyHeaders(@NotNull Response response) {
            g0.p(response, "<this>");
            Response networkResponse = response.networkResponse();
            g0.m(networkResponse);
            return varyHeaders(networkResponse.request().headers(), response.headers());
        }

        private Companion() {
        }

        public final boolean hasVaryAll(@NotNull Response response) {
            g0.p(response, "<this>");
            return varyFields(response.headers()).contains("*");
        }

        @JvmStatic
        @NotNull
        public final String key(@NotNull HttpUrl url) {
            g0.p(url, "url");
            return ByteString.Companion.encodeUtf8(url.toString()).md5().hex();
        }

        public final int readInt$okhttp(@NotNull BufferedSource source) throws IOException {
            g0.p(source, "source");
            try {
                long readDecimalLong = source.readDecimalLong();
                String readUtf8LineStrict = source.readUtf8LineStrict();
                if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.length() <= 0) {
                    return (int) readDecimalLong;
                }
                throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + '\"');
            } catch (NumberFormatException e6) {
                throw new IOException(e6.getMessage());
            }
        }

        public final boolean varyMatches(@NotNull Response cachedResponse, @NotNull Headers cachedRequest, @NotNull Request newRequest) {
            g0.p(cachedResponse, "cachedResponse");
            g0.p(cachedRequest, "cachedRequest");
            g0.p(newRequest, "newRequest");
            Set<String> varyFields = varyFields(cachedResponse.headers());
            if (k.a(varyFields) && varyFields.isEmpty()) {
                return true;
            }
            for (String str : varyFields) {
                if (!g0.g(cachedRequest.values(str), newRequest.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i6 = 0; i6 < size; i6++) {
                if (u.a2("Vary", headers.name(i6), true)) {
                    String value = headers.value(i6);
                    if (treeSet == null) {
                        treeSet = new TreeSet(u.g2(t0.f44062a));
                    }
                    Iterator it = u.l5(value, new char[]{StringUtil.COMMA}, false, 0, 6, null).iterator();
                    while (it.hasNext()) {
                        treeSet.add(u.Z5((String) it.next()).toString());
                    }
                }
            }
            if (treeSet == null) {
                return u1.k();
            }
            return treeSet;
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return Headers.EMPTY;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i6 = 0; i6 < size; i6++) {
                String name = headers.name(i6);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i6));
                }
            }
            return builder.build();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Entry {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static final String RECEIVED_MILLIS;

        @NotNull
        private static final String SENT_MILLIS;
        private final int code;

        @Nullable
        private final Handshake handshake;

        @NotNull
        private final String message;

        @NotNull
        private final Protocol protocol;
        private final long receivedResponseMillis;

        @NotNull
        private final String requestMethod;

        @NotNull
        private final Headers responseHeaders;
        private final long sentRequestMillis;

        @NotNull
        private final HttpUrl url;

        @NotNull
        private final Headers varyHeaders;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            private Companion() {
            }
        }

        public Entry(@NotNull Source rawSource) throws IOException {
            g0.p(rawSource, "rawSource");
            try {
                BufferedSource buffer = Okio.buffer(rawSource);
                String readUtf8LineStrict = buffer.readUtf8LineStrict();
                HttpUrl parse = HttpUrl.Companion.parse(readUtf8LineStrict);
                if (parse == null) {
                    IOException iOException = new IOException("Cache corruption for " + readUtf8LineStrict);
                    Platform.Companion.get().log("cache corruption", 5, iOException);
                    throw iOException;
                }
                this.url = parse;
                this.requestMethod = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int readInt$okhttp = Cache.Companion.readInt$okhttp(buffer);
                for (int i6 = 0; i6 < readInt$okhttp; i6++) {
                    builder.addLenient$okhttp(buffer.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                StatusLine parse2 = StatusLine.Companion.parse(buffer.readUtf8LineStrict());
                this.protocol = parse2.protocol;
                this.code = parse2.code;
                this.message = parse2.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt$okhttp2 = Cache.Companion.readInt$okhttp(buffer);
                for (int i7 = 0; i7 < readInt$okhttp2; i7++) {
                    builder2.addLenient$okhttp(buffer.readUtf8LineStrict());
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (this.url.isHttps()) {
                    String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict2.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict2 + '\"');
                    }
                    this.handshake = Handshake.Companion.get(!buffer.exhausted() ? TlsVersion.Companion.forJavaName(buffer.readUtf8LineStrict()) : TlsVersion.SSL_3_0, CipherSuite.Companion.forJavaName(buffer.readUtf8LineStrict()), readCertificateList(buffer), readCertificateList(buffer));
                } else {
                    this.handshake = null;
                }
                n1 n1Var = n1.f44123a;
                kotlin.io.b.a(rawSource, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.b.a(rawSource, th);
                    throw th2;
                }
            }
        }

        static {
            StringBuilder sb = new StringBuilder();
            Platform.Companion companion = Platform.Companion;
            sb.append(companion.get().getPrefix());
            sb.append("-Sent-Millis");
            SENT_MILLIS = sb.toString();
            RECEIVED_MILLIS = companion.get().getPrefix() + "-Received-Millis";
        }

        private final List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int readInt$okhttp = Cache.Companion.readInt$okhttp(bufferedSource);
            if (readInt$okhttp == -1) {
                return f0.J();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f33254b);
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                for (int i6 = 0; i6 < readInt$okhttp; i6++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    ByteString decodeBase64 = ByteString.Companion.decodeBase64(readUtf8LineStrict);
                    if (decodeBase64 == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    buffer.write(decodeBase64);
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e6) {
                throw new IOException(e6.getMessage());
            }
        }

        public final boolean matches(@NotNull Request request, @NotNull Response response) {
            g0.p(request, "request");
            g0.p(response, "response");
            return g0.g(this.url, request.url()) && g0.g(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        @NotNull
        public final Response response(@NotNull DiskLruCache.Snapshot snapshot) {
            g0.p(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request(this.url, this.varyHeaders, this.requestMethod, null, 8, null)).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(@NotNull DiskLruCache.Editor editor) throws IOException {
            g0.p(editor, "editor");
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            try {
                buffer.writeUtf8(this.url.toString()).writeByte(10);
                buffer.writeUtf8(this.requestMethod).writeByte(10);
                buffer.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
                int size = this.varyHeaders.size();
                for (int i6 = 0; i6 < size; i6++) {
                    buffer.writeUtf8(this.varyHeaders.name(i6)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i6)).writeByte(10);
                }
                buffer.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
                buffer.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
                int size2 = this.responseHeaders.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    buffer.writeUtf8(this.responseHeaders.name(i7)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i7)).writeByte(10);
                }
                buffer.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
                buffer.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
                if (this.url.isHttps()) {
                    buffer.writeByte(10);
                    Handshake handshake = this.handshake;
                    g0.m(handshake);
                    buffer.writeUtf8(handshake.cipherSuite().javaName()).writeByte(10);
                    writeCertList(buffer, this.handshake.peerCertificates());
                    writeCertList(buffer, this.handshake.localCertificates());
                    buffer.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
                }
                n1 n1Var = n1.f44123a;
                kotlin.io.b.a(buffer, null);
            } finally {
            }
        }

        private final void writeCertList(BufferedSink bufferedSink, List<? extends Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                Iterator<? extends Certificate> it = list.iterator();
                while (it.hasNext()) {
                    byte[] encoded = it.next().getEncoded();
                    ByteString.Companion companion = ByteString.Companion;
                    g0.m(encoded);
                    bufferedSink.writeUtf8(ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e6) {
                throw new IOException(e6.getMessage());
            }
        }

        public Entry(@NotNull Response response) {
            g0.p(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class RealCacheRequest implements CacheRequest {

        @NotNull
        private final Sink body;

        @NotNull
        private final Sink cacheOut;
        private boolean done;

        @NotNull
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(@NotNull final Cache cache, DiskLruCache.Editor editor) {
            g0.p(editor, "editor");
            this.this$0 = cache;
            this.editor = editor;
            Sink newSink = editor.newSink(1);
            this.cacheOut = newSink;
            this.body = new ForwardingSink(newSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Cache cache2 = Cache.this;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache2) {
                        if (realCacheRequest.getDone()) {
                            return;
                        }
                        realCacheRequest.setDone(true);
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        this.editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache cache = this.this$0;
            synchronized (cache) {
                if (this.done) {
                    return;
                }
                this.done = true;
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                _UtilCommonKt.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        @NotNull
        public Sink body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z5) {
            this.done = z5;
        }
    }

    public Cache(@NotNull Path directory, long j6, @NotNull FileSystem fileSystem, @NotNull TaskRunner taskRunner) {
        g0.p(directory, "directory");
        g0.p(fileSystem, "fileSystem");
        g0.p(taskRunner, "taskRunner");
        this.cache = new DiskLruCache(fileSystem, directory, VERSION, 2, j6, taskRunner);
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(@NotNull CacheStrategy cacheStrategy) {
        try {
            g0.p(cacheStrategy, "cacheStrategy");
            this.requestCount++;
            if (cacheStrategy.getNetworkRequest() != null) {
                this.networkCount++;
            } else if (cacheStrategy.getCacheResponse() != null) {
                this.hitCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final String key(@NotNull HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "directory", imports = {}))
    @JvmName(name = "-deprecated_directory")
    @NotNull
    /* renamed from: -deprecated_directory, reason: not valid java name */
    public final File m156deprecated_directory() {
        return this.cache.getDirectory().toFile();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    @JvmName(name = "directory")
    @NotNull
    public final File directory() {
        return this.cache.getDirectory().toFile();
    }

    @JvmName(name = "directoryPath")
    @NotNull
    public final Path directoryPath() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    @Nullable
    public final Response get$okhttp(@NotNull Request request) {
        g0.p(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                _UtilCommonKt.closeQuietly(response.body());
                return null;
            } catch (IOException unused) {
                _UtilCommonKt.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    @NotNull
    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    @Nullable
    public final CacheRequest put$okhttp(@NotNull Response response) {
        DiskLruCache.Editor editor;
        g0.p(response, "response");
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!g0.g(method, "GET")) {
            return null;
        }
        Companion companion = Companion;
        if (companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2, null);
            if (editor == null) {
                return null;
            }
            try {
                entry.writeTo(editor);
                return new RealCacheRequest(this, editor);
            } catch (IOException unused2) {
                abortQuietly(editor);
                return null;
            }
        } catch (IOException unused3) {
            editor = null;
        }
    }

    public final void remove$okhttp(@NotNull Request request) throws IOException {
        g0.p(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final void setWriteAbortCount$okhttp(int i6) {
        this.writeAbortCount = i6;
    }

    public final void setWriteSuccessCount$okhttp(int i6) {
        this.writeSuccessCount = i6;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final void update$okhttp(@NotNull Response cached, @NotNull Response network) {
        DiskLruCache.Editor editor;
        g0.p(cached, "cached");
        g0.p(network, "network");
        Entry entry = new Entry(network);
        ResponseBody body = cached.body();
        g0.n(body, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        try {
            editor = ((CacheResponseBody) body).getSnapshot().edit();
            if (editor == null) {
                return;
            }
            try {
                entry.writeTo(editor);
                editor.commit();
            } catch (IOException unused) {
                abortQuietly(editor);
            }
        } catch (IOException unused2) {
            editor = null;
        }
    }

    @NotNull
    public final Iterator<String> urls() throws IOException {
        return new Cache$urls$1(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(@NotNull FileSystem fileSystem, @NotNull Path directory, long j6) {
        this(directory, j6, fileSystem, TaskRunner.INSTANCE);
        g0.p(fileSystem, "fileSystem");
        g0.p(directory, "directory");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(@NotNull File directory, long j6) {
        this(FileSystem.SYSTEM, Path.Companion.get$default(Path.Companion, directory, false, 1, (Object) null), j6);
        g0.p(directory, "directory");
    }
}
