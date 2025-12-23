package okio.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import okio.Buffer;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Socket;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class DefaultSocket implements Socket {

    @NotNull
    private AtomicInteger closeBits;

    @NotNull
    private final Sink sink;

    @NotNull
    private final java.net.Socket socket;

    @NotNull
    private final Source source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDefaultSocket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSocket.kt\nokio/internal/DefaultSocket$SocketSink\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 AsyncTimeout.kt\nokio/AsyncTimeout\n*L\n1#1,176:1\n85#2:177\n175#3,11:178\n175#3,11:189\n175#3,11:200\n*S KotlinDebug\n*F\n+ 1 DefaultSocket.kt\nokio/internal/DefaultSocket$SocketSink\n*L\n60#1:177\n61#1:178,11\n77#1:189,11\n83#1:200,11\n*E\n"})
    public final class SocketSink implements Sink {
        private final OutputStream outputStream;

        @NotNull
        private final SocketAsyncTimeout timeout;

        public SocketSink() {
            this.outputStream = DefaultSocket.this.getSocket().getOutputStream();
            this.timeout = new SocketAsyncTimeout(DefaultSocket.this.getSocket());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            SocketAsyncTimeout socketAsyncTimeout = this.timeout;
            DefaultSocket defaultSocket = DefaultSocket.this;
            socketAsyncTimeout.enter();
            try {
                int bitsOrZero = _AtomicKt.setBitsOrZero(defaultSocket.closeBits, 1);
                if (bitsOrZero != 0) {
                    if (bitsOrZero != 3) {
                        if (!defaultSocket.getSocket().isClosed() && !defaultSocket.getSocket().isOutputShutdown()) {
                            this.outputStream.flush();
                            try {
                                defaultSocket.getSocket().shutdownOutput();
                            } catch (UnsupportedOperationException unused) {
                                this.outputStream.close();
                            }
                        }
                        return;
                    }
                    defaultSocket.getSocket().close();
                    n1 n1Var = n1.f44123a;
                    if (socketAsyncTimeout.exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(null);
                    }
                }
            } catch (IOException e6) {
                if (!socketAsyncTimeout.exit()) {
                    throw e6;
                }
                throw socketAsyncTimeout.access$newTimeoutException(e6);
            } finally {
                socketAsyncTimeout.exit();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            SocketAsyncTimeout socketAsyncTimeout = this.timeout;
            socketAsyncTimeout.enter();
            try {
                this.outputStream.flush();
                n1 n1Var = n1.f44123a;
                if (socketAsyncTimeout.exit()) {
                    throw socketAsyncTimeout.access$newTimeoutException(null);
                }
            } catch (IOException e6) {
                if (!socketAsyncTimeout.exit()) {
                    throw e6;
                }
                throw socketAsyncTimeout.access$newTimeoutException(e6);
            } finally {
                socketAsyncTimeout.exit();
            }
        }

        @Override // okio.Sink
        @NotNull
        public SocketAsyncTimeout timeout() {
            return this.timeout;
        }

        @NotNull
        public String toString() {
            return "sink(" + DefaultSocket.this.getSocket() + ')';
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long j6) {
            g0.p(source, "source");
            SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j6);
            while (j6 > 0) {
                this.timeout.throwIfReached();
                Segment segment = source.head;
                g0.m(segment);
                int min = (int) Math.min(j6, segment.limit - segment.pos);
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        this.outputStream.write(segment.data, segment.pos, min);
                        n1 n1Var = n1.f44123a;
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.access$newTimeoutException(null);
                        }
                        segment.pos += min;
                        long j7 = min;
                        j6 -= j7;
                        source.setSize$okio(source.size() - j7);
                        if (segment.pos == segment.limit) {
                            source.head = segment.pop();
                            SegmentPool.recycle(segment);
                        }
                    } catch (IOException e6) {
                        if (!socketAsyncTimeout.exit()) {
                            throw e6;
                        }
                        throw socketAsyncTimeout.access$newTimeoutException(e6);
                    }
                } catch (Throwable th) {
                    socketAsyncTimeout.exit();
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDefaultSocket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSocket.kt\nokio/internal/DefaultSocket$SocketSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n+ 4 AsyncTimeout.kt\nokio/AsyncTimeout\n*L\n1#1,176:1\n1#2:177\n85#3:178\n175#4,11:179\n175#4,11:190\n*S KotlinDebug\n*F\n+ 1 DefaultSocket.kt\nokio/internal/DefaultSocket$SocketSource\n*L\n121#1:178\n123#1:179,11\n144#1:190,11\n*E\n"})
    public final class SocketSource implements Source {
        private final InputStream inputStream;

        @NotNull
        private final SocketAsyncTimeout timeout;

        public SocketSource() {
            this.inputStream = DefaultSocket.this.getSocket().getInputStream();
            this.timeout = new SocketAsyncTimeout(DefaultSocket.this.getSocket());
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            SocketAsyncTimeout socketAsyncTimeout = this.timeout;
            DefaultSocket defaultSocket = DefaultSocket.this;
            socketAsyncTimeout.enter();
            try {
                int bitsOrZero = _AtomicKt.setBitsOrZero(defaultSocket.closeBits, 2);
                if (bitsOrZero != 0) {
                    if (bitsOrZero == 3) {
                        defaultSocket.getSocket().close();
                    } else {
                        if (defaultSocket.getSocket().isClosed() || defaultSocket.getSocket().isInputShutdown()) {
                            return;
                        }
                        try {
                            defaultSocket.getSocket().shutdownInput();
                        } catch (UnsupportedOperationException unused) {
                            this.inputStream.close();
                        }
                    }
                    n1 n1Var = n1.f44123a;
                    if (socketAsyncTimeout.exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(null);
                    }
                }
            } catch (IOException e6) {
                if (!socketAsyncTimeout.exit()) {
                    throw e6;
                }
                throw socketAsyncTimeout.access$newTimeoutException(e6);
            } finally {
                socketAsyncTimeout.exit();
            }
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long j6) {
            g0.p(sink, "sink");
            if (j6 == 0) {
                return 0L;
            }
            if (j6 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
            }
            this.timeout.throwIfReached();
            Segment writableSegment$okio = sink.writableSegment$okio(1);
            int min = (int) Math.min(j6, 8192 - writableSegment$okio.limit);
            try {
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    int read = this.inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, min);
                    if (socketAsyncTimeout.exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(null);
                    }
                    if (read != -1) {
                        writableSegment$okio.limit += read;
                        long j7 = read;
                        sink.setSize$okio(sink.size() + j7);
                        return j7;
                    }
                    if (writableSegment$okio.pos != writableSegment$okio.limit) {
                        return -1L;
                    }
                    sink.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                    return -1L;
                } catch (IOException e6) {
                    if (socketAsyncTimeout.exit()) {
                        throw socketAsyncTimeout.access$newTimeoutException(e6);
                    }
                    throw e6;
                } finally {
                    socketAsyncTimeout.exit();
                }
            } catch (AssertionError e7) {
                if (_JavaIoKt.isAndroidGetsocknameError(e7)) {
                    throw new IOException(e7);
                }
                throw e7;
            }
        }

        @Override // okio.Source
        @NotNull
        public SocketAsyncTimeout timeout() {
            return this.timeout;
        }

        @NotNull
        public String toString() {
            return "source(" + DefaultSocket.this.getSocket() + ')';
        }
    }

    public DefaultSocket(@NotNull java.net.Socket socket) {
        g0.p(socket, "socket");
        this.socket = socket;
        this.closeBits = new AtomicInteger();
        this.source = new SocketSource();
        this.sink = new SocketSink();
    }

    @Override // okio.Socket
    public void cancel() {
        this.socket.close();
    }

    @Override // okio.Socket
    @NotNull
    public Sink getSink() {
        return this.sink;
    }

    @NotNull
    public final java.net.Socket getSocket() {
        return this.socket;
    }

    @Override // okio.Socket
    @NotNull
    public Source getSource() {
        return this.source;
    }

    @NotNull
    public String toString() {
        String socket = this.socket.toString();
        g0.o(socket, "toString(...)");
        return socket;
    }
}
