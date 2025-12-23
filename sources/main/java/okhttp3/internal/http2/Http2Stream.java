package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.http2.flowcontrol.WindowCounter;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Socket;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHttp2Stream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n*L\n1#1,743:1\n1#2:744\n63#3:745\n63#3:746\n63#3:747\n63#3:748\n63#3:749\n49#3,4:750\n63#3:754\n38#3:755\n63#3:756\n63#3:757\n49#3,4:758\n63#3:762\n38#3:763\n49#3,4:764\n49#3,4:768\n63#3:772\n38#3:773\n63#3:774\n38#3:775\n49#3,4:776\n63#3:780\n38#3:781\n34#3:782\n*S KotlinDebug\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream\n*L\n89#1:745\n114#1:746\n136#1:747\n149#1:748\n175#1:749\n200#1:750,4\n203#1:754\n207#1:755\n214#1:756\n227#1:757\n272#1:758,4\n274#1:762\n280#1:763\n294#1:764,4\n304#1:768,4\n307#1:772\n321#1:773\n329#1:774\n332#1:775\n543#1:776,4\n547#1:780\n693#1:781\n713#1:782\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Http2Stream implements Lockable, Socket {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;

    @NotNull
    private final Http2Connection connection;

    @Nullable
    private ErrorCode errorCode;

    @Nullable
    private IOException errorException;
    private boolean hasResponseHeaders;

    @NotNull
    private final ArrayDeque<Headers> headersQueue;
    private final int id;

    @NotNull
    private final WindowCounter readBytes;

    @NotNull
    private final StreamTimeout readTimeout;

    @NotNull
    private final FramingSink sink;

    @NotNull
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;

    @NotNull
    private final StreamTimeout writeTimeout;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHttp2Stream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSink\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n*L\n1#1,743:1\n49#2,4:744\n63#2:748\n49#2,4:749\n63#2:753\n49#2,4:754\n63#2:758\n63#2:759\n38#2:760\n*S KotlinDebug\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSink\n*L\n582#1:744,4\n598#1:748\n628#1:749,4\n630#1:753\n644#1:754,4\n647#1:758\n676#1:759\n678#1:760\n*E\n"})
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;

        @NotNull
        private final Buffer sendBuffer;

        @Nullable
        private Headers trailers;

        public FramingSink(boolean z5) {
            this.finished = z5;
            this.sendBuffer = new Buffer();
        }

        /* JADX WARN: Finally extract failed */
        private final void emitFrame(boolean z5) throws IOException {
            long min;
            boolean z6;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                try {
                    http2Stream.getWriteTimeout$okhttp().enter();
                    while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !this.finished && !this.closed && http2Stream.getErrorCode$okhttp() == null) {
                        try {
                            http2Stream.waitForIo$okhttp();
                        } catch (Throwable th) {
                            http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                            throw th;
                        }
                    }
                    http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                    http2Stream.checkOutNotClosed$okhttp();
                    min = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.size());
                    http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                    z6 = z5 && min == this.sendBuffer.size();
                    n1 n1Var = n1.f44123a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z6, this.sendBuffer, min);
            } finally {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                if (this.closed) {
                    return;
                }
                boolean z5 = http2Stream2.getErrorCode$okhttp() == null;
                n1 n1Var = n1.f44123a;
                if (!Http2Stream.this.getSink().finished) {
                    boolean z6 = this.sendBuffer.size() > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(false);
                        }
                        Http2Connection connection = Http2Stream.this.getConnection();
                        int id = Http2Stream.this.getId();
                        Headers headers = this.trailers;
                        g0.m(headers);
                        connection.writeHeaders$okhttp(id, z5, _UtilJvmKt.toHeaderList(headers));
                    } else if (z6) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(true);
                        }
                    } else if (z5) {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                Http2Stream http2Stream3 = Http2Stream.this;
                synchronized (http2Stream3) {
                    this.closed = true;
                    g0.n(http2Stream3, "null cannot be cast to non-null type java.lang.Object");
                    http2Stream3.notifyAll();
                    n1 n1Var2 = n1.f44123a;
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                http2Stream2.checkOutNotClosed$okhttp();
                n1 n1Var = n1.f44123a;
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z5) {
            this.closed = z5;
        }

        public final void setFinished(boolean z5) {
            this.finished = z5;
        }

        public final void setTrailers(@Nullable Headers headers) {
            this.trailers = headers;
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long j6) throws IOException {
            g0.p(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.sendBuffer.write(source, j6);
                while (this.sendBuffer.size() >= 16384) {
                    emitFrame(false);
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
        }

        public /* synthetic */ FramingSink(Http2Stream http2Stream, boolean z5, int i6, v vVar) {
            this((i6 & 1) != 0 ? false : z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHttp2Stream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n*L\n1#1,743:1\n1#2:744\n63#3:745\n49#3,4:746\n49#3,4:750\n63#3:754\n63#3:755\n38#3:756\n63#3:757\n38#3:758\n*S KotlinDebug\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSource\n*L\n390#1:745\n453#1:746,4\n467#1:750,4\n474#1:754\n500#1:755\n507#1:756\n528#1:757\n532#1:758\n*E\n"})
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;

        @Nullable
        private Headers trailers;

        @NotNull
        private final Buffer receiveBuffer = new Buffer();

        @NotNull
        private final Buffer readBuffer = new Buffer();

        public FramingSource(long j6, boolean z5) {
            this.maxByteCount = j6;
            this.finished = z5;
        }

        private final void updateConnectionFlowControl(long j6) {
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(j6);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                g0.n(http2Stream, "null cannot be cast to non-null type java.lang.Object");
                http2Stream.notifyAll();
                n1 n1Var = n1.f44123a;
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        @NotNull
        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        @NotNull
        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long j6) throws IOException {
            IOException iOException;
            boolean z5;
            long j7;
            g0.p(sink, "sink");
            if (j6 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
            }
            do {
                Http2Stream http2Stream = Http2Stream.this;
                synchronized (http2Stream) {
                    boolean doReadTimeout = http2Stream.doReadTimeout();
                    if (doReadTimeout) {
                        http2Stream.getReadTimeout$okhttp().enter();
                    }
                    try {
                        if (http2Stream.getErrorCode$okhttp() == null || this.finished) {
                            iOException = null;
                        } else {
                            iOException = http2Stream.getErrorException$okhttp();
                            if (iOException == null) {
                                ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                                g0.m(errorCode$okhttp);
                                iOException = new StreamResetException(errorCode$okhttp);
                            }
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        z5 = false;
                        if (this.readBuffer.size() > 0) {
                            Buffer buffer = this.readBuffer;
                            j7 = buffer.read(sink, Math.min(j6, buffer.size()));
                            WindowCounter.update$default(http2Stream.getReadBytes(), j7, 0L, 2, null);
                            long unacknowledged = http2Stream.getReadBytes().getUnacknowledged();
                            if (iOException == null && unacknowledged >= http2Stream.getConnection().getOkHttpSettings().getInitialWindowSize() / 2) {
                                http2Stream.getConnection().writeWindowUpdateLater$okhttp(http2Stream.getId(), unacknowledged);
                                WindowCounter.update$default(http2Stream.getReadBytes(), 0L, unacknowledged, 1, null);
                            }
                        } else {
                            if (!this.finished && iOException == null) {
                                http2Stream.waitForIo$okhttp();
                                z5 = true;
                            }
                            j7 = -1;
                        }
                        if (doReadTimeout) {
                            http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                        }
                        n1 n1Var = n1.f44123a;
                    } finally {
                    }
                }
                Http2Stream.this.getConnection().getFlowControlListener$okhttp().receivingStreamWindowChanged(Http2Stream.this.getId(), Http2Stream.this.getReadBytes(), this.readBuffer.size());
            } while (z5);
            if (j7 != -1) {
                return j7;
            }
            if (iOException == null) {
                return -1L;
            }
            throw iOException;
        }

        public final void receive$okhttp(@NotNull BufferedSource source, long j6) throws IOException {
            boolean z5;
            boolean z6;
            g0.p(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            long j7 = j6;
            while (j7 > 0) {
                synchronized (Http2Stream.this) {
                    z5 = this.finished;
                    z6 = this.readBuffer.size() + j7 > this.maxByteCount;
                    n1 n1Var = n1.f44123a;
                }
                if (z6) {
                    source.skip(j7);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z5) {
                    source.skip(j7);
                    return;
                }
                long read = source.read(this.receiveBuffer, j7);
                if (read == -1) {
                    throw new EOFException();
                }
                j7 -= read;
                Http2Stream http2Stream2 = Http2Stream.this;
                synchronized (http2Stream2) {
                    try {
                        if (this.closed) {
                            this.receiveBuffer.clear();
                        } else {
                            boolean z7 = this.readBuffer.size() == 0;
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (z7) {
                                g0.n(http2Stream2, "null cannot be cast to non-null type java.lang.Object");
                                http2Stream2.notifyAll();
                            }
                        }
                    } finally {
                    }
                }
            }
            updateConnectionFlowControl(j6);
            Http2Stream.this.getConnection().getFlowControlListener$okhttp().receivingStreamWindowChanged(Http2Stream.this.getId(), Http2Stream.this.getReadBytes(), this.readBuffer.size());
        }

        public final void setClosed$okhttp(boolean z5) {
            this.closed = z5;
        }

        public final void setFinished$okhttp(boolean z5) {
            this.finished = z5;
        }

        public final void setTrailers(@Nullable Headers headers) {
            this.trailers = headers;
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        @Override // okio.AsyncTimeout
        @NotNull
        protected IOException newTimeoutException(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.getConnection().sendDegradedPingLater$okhttp();
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (!exit()) {
            } else {
                throw newTimeoutException(null);
            }
        }
    }

    @Nullable
    public final ErrorCode getErrorCode$okhttp() {
        ErrorCode errorCode;
        synchronized (this) {
            errorCode = this.errorCode;
        }
        return errorCode;
    }

    public final boolean isOpen() {
        synchronized (this) {
            try {
                if (getErrorCode$okhttp() != null) {
                    return false;
                }
                if (!getSource().getFinished$okhttp()) {
                    if (getSource().getClosed$okhttp()) {
                    }
                    return true;
                }
                if (getSink().getFinished() || getSink().getClosed()) {
                    if (this.hasResponseHeaders) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isSourceComplete() {
        boolean z5;
        synchronized (this) {
            if (getSource().getFinished$okhttp()) {
                z5 = getSource().getReadBuffer().exhausted();
            }
        }
        return z5;
    }

    @Nullable
    public final Headers peekTrailers() throws IOException {
        synchronized (this) {
            if (getSource().getFinished$okhttp() && getSource().getReceiveBuffer().exhausted() && getSource().getReadBuffer().exhausted()) {
                Headers trailers = getSource().getTrailers();
                if (trailers == null) {
                    trailers = Headers.EMPTY;
                }
                return trailers;
            }
            if (getErrorCode$okhttp() == null) {
                return null;
            }
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode$okhttp = getErrorCode$okhttp();
            g0.m(errorCode$okhttp);
            throw new StreamResetException(errorCode$okhttp);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0011, B:13:0x001f, B:18:0x0029, B:25:0x0032, B:26:0x0037, B:30:0x0038, B:32:0x0040, B:35:0x004f, B:40:0x0060, B:39:0x0054, B:15:0x0024), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0001 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Headers takeHeaders(boolean r3) throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
        L1:
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch: java.lang.Throwable -> L1a
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L38
            okhttp3.internal.http2.ErrorCode r0 = r2.getErrorCode$okhttp()     // Catch: java.lang.Throwable -> L1a
            if (r0 != 0) goto L38
            if (r3 != 0) goto L1c
            boolean r0 = r2.doReadTimeout()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L18
            goto L1c
        L18:
            r0 = 0
            goto L1d
        L1a:
            r3 = move-exception
            goto L61
        L1c:
            r0 = 1
        L1d:
            if (r0 == 0) goto L24
            okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r2.readTimeout     // Catch: java.lang.Throwable -> L1a
            r1.enter()     // Catch: java.lang.Throwable -> L1a
        L24:
            r2.waitForIo$okhttp()     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L1
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch: java.lang.Throwable -> L1a
            r0.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> L1a
            goto L1
        L2f:
            r3 = move-exception
            if (r0 == 0) goto L37
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch: java.lang.Throwable -> L1a
            r0.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> L1a
        L37:
            throw r3     // Catch: java.lang.Throwable -> L1a
        L38:
            java.util.ArrayDeque<okhttp3.Headers> r3 = r2.headersQueue     // Catch: java.lang.Throwable -> L1a
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L4f
            java.util.ArrayDeque<okhttp3.Headers> r3 = r2.headersQueue     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r3 = r3.removeFirst()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = "removeFirst(...)"
            kotlin.jvm.internal.g0.o(r3, r0)     // Catch: java.lang.Throwable -> L1a
            okhttp3.Headers r3 = (okhttp3.Headers) r3     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r2)
            return r3
        L4f:
            java.io.IOException r3 = r2.errorException     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L54
            goto L60
        L54:
            okhttp3.internal.http2.StreamResetException r3 = new okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L1a
            okhttp3.internal.http2.ErrorCode r0 = r2.getErrorCode$okhttp()     // Catch: java.lang.Throwable -> L1a
            kotlin.jvm.internal.g0.m(r0)     // Catch: java.lang.Throwable -> L1a
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L1a
        L60:
            throw r3     // Catch: java.lang.Throwable -> L1a
        L61:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.takeHeaders(boolean):okhttp3.Headers");
    }

    public Http2Stream(int i6, @NotNull Http2Connection connection, boolean z5, boolean z6, @Nullable Headers headers) {
        g0.p(connection, "connection");
        this.id = i6;
        this.connection = connection;
        this.readBytes = new WindowCounter(i6);
        this.writeBytesMaximum = connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(connection.getOkHttpSettings().getInitialWindowSize(), z6);
        this.sink = new FramingSink(z5);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers == null) {
            if (!isLocallyInitiated()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (isLocallyInitiated()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(headers);
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (getErrorCode$okhttp() != null) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            g0.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            if (getSource().getFinished$okhttp() && getSink().getFinished()) {
                return false;
            }
            n1 n1Var = n1.f44123a;
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doReadTimeout() {
        return !this.connection.getClient$okhttp() || getSink().getClosed() || getSink().getFinished();
    }

    public static /* synthetic */ Headers takeHeaders$default(Http2Stream http2Stream, boolean z5, int i6, Object obj) throws IOException {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return http2Stream.takeHeaders(z5);
    }

    public final void addBytesToWriteWindow(long j6) {
        this.writeBytesMaximum += j6;
        if (j6 > 0) {
            g0.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    @Override // okio.Socket
    public void cancel() {
        closeLater(ErrorCode.CANCEL);
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z5;
        boolean isOpen;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (getSource().getFinished$okhttp() || !getSource().getClosed$okhttp() || (!getSink().getFinished() && !getSink().getClosed())) {
                    z5 = false;
                    isOpen = isOpen();
                    n1 n1Var = n1.f44123a;
                }
                z5 = true;
                isOpen = isOpen();
                n1 n1Var2 = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z5) {
            close(ErrorCode.CANCEL, null);
        } else {
            if (isOpen) {
                return;
            }
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void close(@NotNull ErrorCode rstStatusCode, @Nullable IOException iOException) throws IOException {
        g0.p(rstStatusCode, "rstStatusCode");
        if (closeInternal(rstStatusCode, iOException)) {
            this.connection.writeSynReset$okhttp(this.id, rstStatusCode);
        }
    }

    public final void closeLater(@NotNull ErrorCode errorCode) {
        g0.p(errorCode, "errorCode");
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater$okhttp(this.id, errorCode);
        }
    }

    public final void enqueueTrailers(@NotNull Headers trailers) {
        g0.p(trailers, "trailers");
        synchronized (this) {
            if (getSink().getFinished()) {
                throw new IllegalStateException("already finished");
            }
            if (trailers.size() == 0) {
                throw new IllegalArgumentException("trailers.size() == 0");
            }
            getSink().setTrailers(trailers);
            n1 n1Var = n1.f44123a;
        }
    }

    @NotNull
    public final Http2Connection getConnection() {
        return this.connection;
    }

    @Nullable
    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final WindowCounter getReadBytes() {
        return this.readBytes;
    }

    @NotNull
    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    @Override // okio.Socket
    @NotNull
    public FramingSink getSink() {
        return this.sink;
    }

    @Override // okio.Socket
    @NotNull
    public FramingSource getSource() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient$okhttp() == ((this.id & 1) == 1);
    }

    @NotNull
    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(@NotNull BufferedSource source, int i6) throws IOException {
        g0.p(source, "source");
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(this)) {
            getSource().receive$okhttp(source, i6);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0061 A[Catch: all -> 0x0056, TryCatch #0 {all -> 0x0056, blocks: (B:10:0x0038, B:12:0x003d, B:14:0x0045, B:17:0x004e, B:19:0x0061, B:20:0x0068, B:27:0x0058), top: B:9:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void receiveHeaders(@org.jetbrains.annotations.NotNull okhttp3.Headers r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.g0.p(r3, r0)
            boolean r0 = okhttp3.internal._UtilJvmKt.assertionsEnabled
            if (r0 == 0) goto L37
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L10
            goto L37
        L10:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Thread "
            r4.append(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L37:
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L56
            r1 = 1
            if (r0 == 0) goto L58
            java.lang.String r0 = ":status"
            java.lang.String r0 = r3.get(r0)     // Catch: java.lang.Throwable -> L56
            if (r0 != 0) goto L58
            java.lang.String r0 = ":method"
            java.lang.String r0 = r3.get(r0)     // Catch: java.lang.Throwable -> L56
            if (r0 == 0) goto L4e
            goto L58
        L4e:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.getSource()     // Catch: java.lang.Throwable -> L56
            r0.setTrailers(r3)     // Catch: java.lang.Throwable -> L56
            goto L5f
        L56:
            r3 = move-exception
            goto L81
        L58:
            r2.hasResponseHeaders = r1     // Catch: java.lang.Throwable -> L56
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch: java.lang.Throwable -> L56
            r0.add(r3)     // Catch: java.lang.Throwable -> L56
        L5f:
            if (r4 == 0) goto L68
            okhttp3.internal.http2.Http2Stream$FramingSource r3 = r2.getSource()     // Catch: java.lang.Throwable -> L56
            r3.setFinished$okhttp(r1)     // Catch: java.lang.Throwable -> L56
        L68:
            boolean r3 = r2.isOpen()     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.Object"
            kotlin.jvm.internal.g0.n(r2, r4)     // Catch: java.lang.Throwable -> L56
            r2.notifyAll()     // Catch: java.lang.Throwable -> L56
            kotlin.n1 r4 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L56
            monitor-exit(r2)
            if (r3 != 0) goto L80
            okhttp3.internal.http2.Http2Connection r3 = r2.connection
            int r4 = r2.id
            r3.removeStream$okhttp(r4)
        L80:
            return
        L81:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    public final void receiveRstStream(@NotNull ErrorCode errorCode) {
        g0.p(errorCode, "errorCode");
        synchronized (this) {
            try {
                if (getErrorCode$okhttp() == null) {
                    this.errorCode = errorCode;
                    g0.n(this, "null cannot be cast to non-null type java.lang.Object");
                    notifyAll();
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setErrorCode$okhttp(@Nullable ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(@Nullable IOException iOException) {
        this.errorException = iOException;
    }

    public final void setWriteBytesMaximum$okhttp(long j6) {
        this.writeBytesMaximum = j6;
    }

    public final void setWriteBytesTotal$okhttp(long j6) {
        this.writeBytesTotal = j6;
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            g0.n(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(@NotNull List<Header> responseHeaders, boolean z5, boolean z6) throws IOException {
        g0.p(responseHeaders, "responseHeaders");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                this.hasResponseHeaders = true;
                if (z5) {
                    getSink().setFinished(true);
                    g0.n(this, "null cannot be cast to non-null type java.lang.Object");
                    notifyAll();
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z6) {
            synchronized (this) {
                z6 = this.connection.getWriteBytesTotal() >= this.connection.getWriteBytesMaximum();
            }
        }
        this.connection.writeHeaders$okhttp(this.id, z5, responseHeaders);
        if (z6) {
            this.connection.flush();
        }
    }

    @NotNull
    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (!getSink().getClosed()) {
            if (!getSink().getFinished()) {
                if (getErrorCode$okhttp() != null) {
                    IOException iOException = this.errorException;
                    if (iOException == null) {
                        ErrorCode errorCode$okhttp = getErrorCode$okhttp();
                        g0.m(errorCode$okhttp);
                        throw new StreamResetException(errorCode$okhttp);
                    }
                    throw iOException;
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }
}
