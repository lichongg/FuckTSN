package okhttp3.internal.http1;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.BufferedSocket;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.apache.commons.net.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,562:1\n1#2:563\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;

    @NotNull
    private final ExchangeCodec.Carrier carrier;

    @Nullable
    private final OkHttpClient client;

    @NotNull
    private final HeadersReader headersReader;

    @NotNull
    private final BufferedSocket socket;
    private int state;

    @Nullable
    private Headers trailers;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Headers TRAILERS_RESPONSE_BODY_TRUNCATED = Headers.Companion.of("OkHttp-Response-Body", "Truncated");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class AbstractSource implements Source {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;

        @NotNull
        private final ForwardingTimeout timeout;

        @NotNull
        private final HttpUrl url;

        public AbstractSource(@NotNull Http1ExchangeCodec http1ExchangeCodec, HttpUrl url) {
            g0.p(url, "url");
            this.this$0 = http1ExchangeCodec;
            this.url = url;
            this.timeout = new ForwardingTimeout(http1ExchangeCodec.getSocket().getSource().timeout());
        }

        protected final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        protected final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        @NotNull
        public final HttpUrl getUrl() {
            return this.url;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long j6) {
            g0.p(sink, "sink");
            try {
                return this.this$0.getSocket().getSource().read(sink, j6);
            } catch (IOException e6) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw e6;
            }
        }

        public final void responseBodyComplete(@NotNull Headers trailers) {
            OkHttpClient okHttpClient;
            CookieJar cookieJar;
            g0.p(trailers, "trailers");
            if (this.this$0.state == 6) {
                return;
            }
            if (this.this$0.state != 5) {
                throw new IllegalStateException("state: " + this.this$0.state);
            }
            this.this$0.detachTimeout(this.timeout);
            this.this$0.trailers = trailers;
            this.this$0.state = 6;
            if (trailers.size() <= 0 || (okHttpClient = this.this$0.client) == null || (cookieJar = okHttpClient.cookieJar()) == null) {
                return;
            }
            HttpHeaders.receiveHeaders(cookieJar, this.url, trailers);
        }

        protected final void setClosed(boolean z5) {
            this.closed = z5;
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,562:1\n1#2:563\n*E\n"})
    private final class ChunkedSink implements Sink {
        private boolean closed;

        @NotNull
        private final ForwardingTimeout timeout;

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.getSocket().getSink().writeUtf8("0\r\n\r\n");
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.getSocket().getSink().flush();
        }

        public ChunkedSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.getSocket().getSink().timeout());
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long j6) {
            g0.p(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j6 == 0) {
                return;
            }
            BufferedSink sink = Http1ExchangeCodec.this.getSocket().getSink();
            sink.writeHexadecimalUnsignedLong(j6);
            sink.writeUtf8(g.f50795q);
            sink.write(source, j6);
            sink.writeUtf8(g.f50795q);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,562:1\n1#2:563\n*E\n"})
    private final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(@NotNull Http1ExchangeCodec http1ExchangeCodec, HttpUrl url) {
            super(http1ExchangeCodec, url);
            g0.p(url, "url");
            this.this$0 = http1ExchangeCodec;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk != -1) {
                this.this$0.getSocket().getSource().readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = this.this$0.getSocket().getSource().readHexadecimalUnsignedLong();
                String obj = u.Z5(this.this$0.getSocket().getSource().readUtf8LineStrict()).toString();
                if (this.bytesRemainingInChunk >= 0 && (obj.length() <= 0 || u.H2(obj, ";", false, 2, null))) {
                    if (this.bytesRemainingInChunk == 0) {
                        this.hasMoreChunks = false;
                        responseBodyComplete(this.this$0.headersReader.readHeaders());
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + obj + '\"');
            } catch (NumberFormatException e6) {
                throw new ProtocolException(e6.getMessage());
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(@NotNull Buffer sink, long j6) {
            g0.p(sink, "sink");
            if (j6 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j7 = this.bytesRemainingInChunk;
            if (j7 == 0 || j7 == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long read = super.read(sink, Math.min(j6, this.bytesRemainingInChunk));
            if (read != -1) {
                this.bytesRemainingInChunk -= read;
                return read;
            }
            this.this$0.getCarrier().noNewExchanges();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            throw protocolException;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,562:1\n1#2:563\n*E\n"})
    private final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FixedLengthSource(@NotNull Http1ExchangeCodec http1ExchangeCodec, HttpUrl url, long j6) {
            super(http1ExchangeCodec, url);
            g0.p(url, "url");
            this.this$0 = http1ExchangeCodec;
            this.bytesRemaining = j6;
            if (j6 == 0) {
                responseBodyComplete(Headers.EMPTY);
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(@NotNull Buffer sink, long j6) {
            g0.p(sink, "sink");
            if (j6 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            long j7 = this.bytesRemaining;
            if (j7 == 0) {
                return -1L;
            }
            long read = super.read(sink, Math.min(j7, j6));
            if (read == -1) {
                this.this$0.getCarrier().noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw protocolException;
            }
            long j8 = this.bytesRemaining - read;
            this.bytesRemaining = j8;
            if (j8 == 0) {
                responseBodyComplete(Headers.EMPTY);
            }
            return read;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,562:1\n1#2:563\n*E\n"})
    private final class KnownLengthSink implements Sink {
        private boolean closed;

        @NotNull
        private final ForwardingTimeout timeout;

        public KnownLengthSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.getSocket().getSink().timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.getSocket().getSink().flush();
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long j6) {
            g0.p(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            _UtilCommonKt.checkOffsetAndCount(source.size(), 0L, j6);
            Http1ExchangeCodec.this.getSocket().getSink().write(source, j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,562:1\n1#2:563\n*E\n"})
    private final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownLengthSource(@NotNull Http1ExchangeCodec http1ExchangeCodec, HttpUrl url) {
            super(http1ExchangeCodec, url);
            g0.p(url, "url");
            this.this$0 = http1ExchangeCodec;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(@NotNull Buffer sink, long j6) {
            g0.p(sink, "sink");
            if (j6 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long read = super.read(sink, j6);
            if (read != -1) {
                return read;
            }
            this.inputExhausted = true;
            responseBodyComplete(Headers.EMPTY);
            return -1L;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }
    }

    private final boolean isChunked(Response response) {
        return u.a2(HttpHeaders.Values.CHUNKED, Response.header$default(response, "Transfer-Encoding", null, 2, null), true);
    }

    public Http1ExchangeCodec(@Nullable OkHttpClient okHttpClient, @NotNull ExchangeCodec.Carrier carrier, @NotNull BufferedSocket socket) {
        g0.p(carrier, "carrier");
        g0.p(socket, "socket");
        this.client = okHttpClient;
        this.carrier = carrier;
        this.socket = socket;
        this.headersReader = new HeadersReader(getSocket().getSource());
    }

    private final boolean isChunked(Request request) {
        return u.a2(HttpHeaders.Values.CHUNKED, request.header("Transfer-Encoding"), true);
    }

    private final Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newChunkedSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(this, httpUrl);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newFixedLengthSource(HttpUrl httpUrl, long j6) {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(this, httpUrl, j6);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Sink newKnownLengthSink() {
        if (this.state == 1) {
            this.state = 2;
            return new KnownLengthSink();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newUnknownLengthSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            getCarrier().noNewExchanges();
            return new UnknownLengthSource(this, httpUrl);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Sink createRequestBody(@NotNull Request request, long j6) {
        g0.p(request, "request");
        RequestBody body = request.body();
        if (body != null && body.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (isChunked(request)) {
            return newChunkedSink();
        }
        if (j6 != -1) {
            return newKnownLengthSink();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public BufferedSocket getSocket() {
        return this.socket;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public boolean isResponseComplete() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Source openResponseBodySource(@NotNull Response response) {
        g0.p(response, "response");
        if (!okhttp3.internal.http.HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(response.request().url(), 0L);
        }
        if (isChunked(response)) {
            return newChunkedSource(response.request().url());
        }
        long headersContentLength = _UtilJvmKt.headersContentLength(response);
        return headersContentLength != -1 ? newFixedLengthSource(response.request().url(), headersContentLength) : newUnknownLengthSource(response.request().url());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public Headers peekTrailers() {
        Headers headers = this.trailers;
        if (headers == TRAILERS_RESPONSE_BODY_TRUNCATED) {
            throw new IOException("Trailers cannot be read because the response body was truncated");
        }
        int i6 = this.state;
        if (i6 == 5 || i6 == 6) {
            return headers;
        }
        throw new IllegalStateException(("Trailers cannot be read because the state is " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public Response.Builder readResponseHeaders(boolean z5) {
        int i6 = this.state;
        if (i6 != 0 && i6 != 1 && i6 != 2 && i6 != 3) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        try {
            StatusLine parse = StatusLine.Companion.parse(this.headersReader.readLine());
            Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(this.headersReader.readHeaders());
            if (z5 && parse.code == 100) {
                return null;
            }
            int i7 = parse.code;
            if (i7 == 100) {
                this.state = 3;
                return headers;
            }
            if (102 > i7 || i7 >= 200) {
                this.state = 4;
                return headers;
            }
            this.state = 3;
            return headers;
        } catch (EOFException e6) {
            throw new IOException("unexpected end of stream on " + getCarrier().getRoute().address().url().redact(), e6);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(@NotNull Response response) {
        g0.p(response, "response");
        if (!okhttp3.internal.http.HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if (isChunked(response)) {
            return -1L;
        }
        return _UtilJvmKt.headersContentLength(response);
    }

    public final void skipConnectBody(@NotNull Response response) {
        g0.p(response, "response");
        long headersContentLength = _UtilJvmKt.headersContentLength(response);
        if (headersContentLength == -1) {
            return;
        }
        Source newFixedLengthSource = newFixedLengthSource(response.request().url(), headersContentLength);
        _UtilJvmKt.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        newFixedLengthSource.close();
    }

    public final void writeRequest(@NotNull Headers headers, @NotNull String requestLine) {
        g0.p(headers, "headers");
        g0.p(requestLine, "requestLine");
        if (this.state != 0) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        getSocket().getSink().writeUtf8(requestLine).writeUtf8(g.f50795q);
        int size = headers.size();
        for (int i6 = 0; i6 < size; i6++) {
            getSocket().getSink().writeUtf8(headers.name(i6)).writeUtf8(": ").writeUtf8(headers.value(i6)).writeUtf8(g.f50795q);
        }
        getSocket().getSink().writeUtf8(g.f50795q);
        this.state = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(@NotNull Request request) {
        g0.p(request, "request");
        RequestLine requestLine = RequestLine.INSTANCE;
        Proxy.Type type = getCarrier().getRoute().proxy().type();
        g0.o(type, "type(...)");
        writeRequest(request.headers(), requestLine.get(request, type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getCarrier().mo289cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        getSocket().getSink().flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        getSocket().getSink().flush();
    }
}
