package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Socket;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Exchange {

    @NotNull
    private final RealCall call;

    @NotNull
    private final ExchangeCodec codec;

    @NotNull
    private final EventListener eventListener;

    @NotNull
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nExchange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exchange.kt\nokhttp3/internal/connection/Exchange$RequestBodySink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,404:1\n1#2:405\n*E\n"})
    final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        private final boolean isSocket;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(@NotNull Exchange exchange, Sink delegate, long j6, boolean z5) {
            super(delegate);
            g0.p(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j6;
            this.isSocket = z5;
            this.invokeStartEvent = z5;
        }

        private final IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.bodyComplete$default(this.this$0, this.bytesReceived, this.isSocket, false, true, iOException, 4, null);
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j6 = this.contentLength;
            if (j6 != -1 && this.bytesReceived != j6) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e6) {
                IOException complete = complete(e6);
                g0.m(complete);
                throw complete;
            }
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(@NotNull Buffer source, long j6) throws IOException {
            g0.p(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long j7 = this.contentLength;
            if (j7 != -1 && this.bytesReceived + j6 > j7) {
                throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j6));
            }
            try {
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().requestBodyStart(this.this$0.getCall$okhttp());
                }
                super.write(source, j6);
                this.bytesReceived += j6;
            } catch (IOException e6) {
                IOException complete = complete(e6);
                g0.m(complete);
                throw complete;
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e6) {
                IOException complete = complete(e6);
                g0.m(complete);
                throw complete;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nExchange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exchange.kt\nokhttp3/internal/connection/Exchange$ResponseBodySource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,404:1\n1#2:405\n*E\n"})
    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        private final boolean isSocket;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(@NotNull Exchange exchange, Source delegate, long j6, boolean z5) {
            super(delegate);
            g0.p(delegate, "delegate");
            this.this$0 = exchange;
            this.contentLength = j6;
            this.isSocket = z5;
            this.invokeStartEvent = true;
            if (j6 == 0) {
                complete(null);
            }
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e6) {
                IOException complete = complete(e6);
                g0.m(complete);
                throw complete;
            }
        }

        @Nullable
        public final IOException complete(@Nullable IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            if (iOException == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return Exchange.bodyComplete$default(this.this$0, this.bytesReceived, this.isSocket, true, false, iOException, 8, null);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(@NotNull Buffer sink, long j6) throws IOException {
            g0.p(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            try {
                long read = delegate().read(sink, j6);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                }
                if (read == -1) {
                    complete(null);
                    return -1L;
                }
                long j7 = this.bytesReceived + read;
                long j8 = this.contentLength;
                if (j8 != -1 && j7 > j8) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j7);
                }
                this.bytesReceived = j7;
                if (this.this$0.codec.isResponseComplete()) {
                    complete(null);
                }
                return read;
            } catch (IOException e6) {
                IOException complete = complete(e6);
                g0.m(complete);
                throw complete;
            }
        }
    }

    private final void trackFailure(IOException iOException) {
        this.hasFailure = true;
        this.codec.getCarrier().trackFailure(this.call, iOException);
    }

    public Exchange(@NotNull RealCall call, @NotNull EventListener eventListener, @NotNull ExchangeFinder finder, @NotNull ExchangeCodec codec) {
        g0.p(call, "call");
        g0.p(eventListener, "eventListener");
        g0.p(finder, "finder");
        g0.p(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
    }

    public static /* synthetic */ IOException bodyComplete$default(Exchange exchange, long j6, boolean z5, boolean z6, boolean z7, IOException iOException, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = -1;
        }
        return exchange.bodyComplete(j6, z5, (i6 & 4) != 0 ? false : z6, (i6 & 8) != 0 ? false : z7, iOException);
    }

    @Nullable
    public final IOException bodyComplete(long j6, boolean z5, boolean z6, boolean z7, @Nullable IOException iOException) {
        if (iOException != null) {
            trackFailure(iOException);
        }
        if (z7) {
            if (iOException != null) {
                this.eventListener.requestFailed(this.call, iOException);
            } else {
                this.eventListener.requestBodyEnd(this.call, j6);
            }
        }
        if (z6) {
            if (iOException != null) {
                this.eventListener.responseFailed(this.call, iOException);
            } else {
                this.eventListener.responseBodyEnd(this.call, j6);
            }
        }
        return this.call.messageDone$okhttp(this, z7 && !z5, z6 && !z5, z6 && z5, z7 && z5, iOException);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    @NotNull
    public final Sink createRequestBody(@NotNull Request request, boolean z5) throws IOException {
        g0.p(request, "request");
        this.isDuplex = z5;
        RequestBody body = request.body();
        g0.m(body);
        long contentLength = body.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, contentLength), contentLength, false);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e6) {
            this.eventListener.requestFailed(this.call, e6);
            trackFailure(e6);
            throw e6;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e6) {
            this.eventListener.requestFailed(this.call, e6);
            trackFailure(e6);
            throw e6;
        }
    }

    @NotNull
    public final RealCall getCall$okhttp() {
        return this.call;
    }

    @NotNull
    public final RealConnection getConnection$okhttp() {
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        RealConnection realConnection = carrier instanceof RealConnection ? (RealConnection) carrier : null;
        if (realConnection != null) {
            return realConnection;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels");
    }

    @NotNull
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    @NotNull
    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !g0.g(this.finder.getRoutePlanner().getAddress().url().host(), this.codec.getCarrier().getRoute().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getCarrier().noNewExchanges();
    }

    public final void noRequestBody() {
        RealCall.messageDone$okhttp$default(this.call, this, true, false, false, false, null, 28, null);
    }

    @NotNull
    public final ResponseBody openResponseBody(@NotNull Response response) throws IOException {
        Exchange exchange;
        String header$default;
        long reportedContentLength;
        g0.p(response, "response");
        try {
            header$default = Response.header$default(response, "Content-Type", null, 2, null);
            reportedContentLength = this.codec.reportedContentLength(response);
            exchange = this;
        } catch (IOException e6) {
            e = e6;
            exchange = this;
        }
        try {
            return new RealResponseBody(header$default, reportedContentLength, Okio.buffer(new ResponseBodySource(exchange, this.codec.openResponseBodySource(response), reportedContentLength, false)));
        } catch (IOException e7) {
            e = e7;
            IOException iOException = e;
            exchange.eventListener.responseFailed(exchange.call, iOException);
            trackFailure(iOException);
            throw iOException;
        }
    }

    @Nullable
    public final Headers peekTrailers() throws IOException {
        return this.codec.peekTrailers();
    }

    @Nullable
    public final Response.Builder readResponseHeaders(boolean z5) throws IOException {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z5);
            if (readResponseHeaders == null) {
                return readResponseHeaders;
            }
            readResponseHeaders.initExchange$okhttp(this);
            return readResponseHeaders;
        } catch (IOException e6) {
            this.eventListener.responseFailed(this.call, e6);
            trackFailure(e6);
            throw e6;
        }
    }

    public final void responseHeadersEnd(@NotNull Response response) {
        g0.p(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    @NotNull
    public final Socket upgradeToSocket() {
        this.call.upgradeToSocket();
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        g0.n(carrier, "null cannot be cast to non-null type okhttp3.internal.connection.RealConnection");
        ((RealConnection) carrier).useAsSocket$okhttp();
        return new Socket() { // from class: okhttp3.internal.connection.Exchange$upgradeToSocket$1
            private final Exchange.RequestBodySink sink;
            private final Exchange.ResponseBodySource source;

            {
                this.sink = new Exchange.RequestBodySink(Exchange.this, Exchange.this.codec.getSocket().getSink(), -1L, true);
                this.source = new Exchange.ResponseBodySource(Exchange.this, Exchange.this.codec.getSocket().getSource(), -1L, true);
            }

            @Override // okio.Socket
            public void cancel() {
                Exchange.this.cancel();
            }

            @Override // okio.Socket
            public Exchange.RequestBodySink getSink() {
                return this.sink;
            }

            @Override // okio.Socket
            public Exchange.ResponseBodySource getSource() {
                return this.source;
            }
        };
    }

    public final void writeRequestHeaders(@NotNull Request request) throws IOException {
        g0.p(request, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e6) {
            this.eventListener.requestFailed(this.call, e6);
            trackFailure(e6);
            throw e6;
        }
    }
}
