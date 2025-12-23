package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.ranges.t;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Http2Reader implements Closeable {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Logger logger;
    private final boolean client;

    @NotNull
    private final ContinuationSource continuation;

    @NotNull
    private final Hpack.Reader hpackReader;

    @NotNull
    private final BufferedSource source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        public final int lengthWithoutPadding(int i6, int i7, int i8) throws IOException {
            if ((i7 & 8) != 0) {
                i6--;
            }
            if (i8 <= i6) {
                return i6 - i8;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i8 + " > remaining length " + i6);
        }

        @NotNull
        public final Logger getLogger() {
            return Http2Reader.logger;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;

        @NotNull
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(@NotNull BufferedSource source) {
            g0.p(source, "source");
            this.source = source;
        }

        private final void readContinuationHeader() throws IOException {
            int i6 = this.streamId;
            int readMedium = _UtilCommonKt.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            int and = _UtilCommonKt.and(this.source.readByte(), 255);
            this.flags = _UtilCommonKt.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, and, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (and == 9) {
                if (readInt != i6) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(and + " != TYPE_CONTINUATION");
            }
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long j6) throws IOException {
            g0.p(sink, "sink");
            while (true) {
                int i6 = this.left;
                if (i6 != 0) {
                    long read = this.source.read(sink, Math.min(j6, i6));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left -= (int) read;
                    return read;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        public final void setFlags(int i6) {
            this.flags = i6;
        }

        public final void setLeft(int i6) {
            this.left = i6;
        }

        public final void setLength(int i6) {
            this.length = i6;
        }

        public final void setPadding(int i6) {
            this.padding = i6;
        }

        public final void setStreamId(int i6) {
            this.streamId = i6;
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.source.timeout();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Handler {
        void ackSettings();

        void alternateService(int i6, @NotNull String str, @NotNull ByteString byteString, @NotNull String str2, int i7, long j6);

        void data(boolean z5, int i6, @NotNull BufferedSource bufferedSource, int i7) throws IOException;

        void goAway(int i6, @NotNull ErrorCode errorCode, @NotNull ByteString byteString);

        void headers(boolean z5, int i6, int i7, @NotNull List<Header> list);

        void ping(boolean z5, int i6, int i7);

        void priority(int i6, int i7, int i8, boolean z5);

        void pushPromise(int i6, int i7, @NotNull List<Header> list) throws IOException;

        void rstStream(int i6, @NotNull ErrorCode errorCode);

        void settings(boolean z5, @NotNull Settings settings);

        void windowUpdate(int i6, long j6);
    }

    private final void readPriority(Handler handler, int i6, int i7, int i8) throws IOException {
        if (i6 == 5) {
            if (i8 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            readPriority(handler, i8);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i6 + " != 5");
        }
    }

    private final void readRstStream(Handler handler, int i6, int i7, int i8) throws IOException {
        if (i6 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i6 + " != 4");
        }
        if (i8 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int readInt = this.source.readInt();
        ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt);
        if (fromHttp2 != null) {
            handler.rstStream(i8, fromHttp2);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + readInt);
    }

    private final void readWindowUpdate(Handler handler, int i6, int i7, int i8) throws IOException {
        int i9;
        try {
            if (i6 != 4) {
                throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i6);
            }
            try {
                long and = _UtilCommonKt.and(this.source.readInt(), 2147483647L);
                if (and == 0) {
                    throw new IOException("windowSizeIncrement was 0");
                }
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    i9 = i8;
                    logger2.fine(Http2.INSTANCE.frameLogWindowUpdate(true, i8, i6, and));
                } else {
                    i9 = i8;
                }
                handler.windowUpdate(i9, and);
            } catch (Exception e6) {
                e = e6;
                Exception exc = e;
                logger.fine(Http2.INSTANCE.frameLog(true, i8, i6, 8, i7));
                throw exc;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        g0.o(logger2, "getLogger(...)");
        logger = logger2;
    }

    public Http2Reader(@NotNull BufferedSource source, boolean z5) {
        g0.p(source, "source");
        this.source = source;
        this.client = z5;
        ContinuationSource continuationSource = new ContinuationSource(source);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int i6, int i7, int i8) throws IOException {
        if (i8 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z5 = (i7 & 1) != 0;
        if ((i7 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int and = (i7 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        handler.data(z5, i8, this.source, Companion.lengthWithoutPadding(i6, i7, and));
        this.source.skip(and);
    }

    private final void readGoAway(Handler handler, int i6, int i7, int i8) throws IOException {
        if (i6 < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i6);
        }
        if (i8 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int readInt = this.source.readInt();
        int readInt2 = this.source.readInt();
        int i9 = i6 - 8;
        ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt2);
        if (fromHttp2 == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + readInt2);
        }
        ByteString byteString = ByteString.EMPTY;
        if (i9 > 0) {
            byteString = this.source.readByteString(i9);
        }
        handler.goAway(readInt, fromHttp2, byteString);
    }

    private final List<Header> readHeaderBlock(int i6, int i7, int i8, int i9) throws IOException {
        this.continuation.setLeft(i6);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i7);
        this.continuation.setFlags(i8);
        this.continuation.setStreamId(i9);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i6, int i7, int i8) throws IOException {
        if (i8 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z5 = (i7 & 1) != 0;
        int and = (i7 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        if ((i7 & 32) != 0) {
            readPriority(handler, i8);
            i6 -= 5;
        }
        handler.headers(z5, i8, -1, readHeaderBlock(Companion.lengthWithoutPadding(i6, i7, and), and, i7, i8));
    }

    private final void readPing(Handler handler, int i6, int i7, int i8) throws IOException {
        if (i6 != 8) {
            throw new IOException("TYPE_PING length != 8: " + i6);
        }
        if (i8 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.ping((i7 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void readPushPromise(Handler handler, int i6, int i7, int i8) throws IOException {
        if (i8 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int and = (i7 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        handler.pushPromise(i8, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i6 - 4, i7, and), and, i7, i8));
    }

    private final void readSettings(Handler handler, int i6, int i7, int i8) throws IOException {
        int readInt;
        if (i8 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i7 & 1) != 0) {
            if (i6 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.ackSettings();
            return;
        }
        if (i6 % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i6);
        }
        Settings settings = new Settings();
        kotlin.ranges.k B1 = t.B1(t.W1(0, i6), 6);
        int e6 = B1.e();
        int f6 = B1.f();
        int g6 = B1.g();
        if ((g6 > 0 && e6 <= f6) || (g6 < 0 && f6 <= e6)) {
            while (true) {
                int and = _UtilCommonKt.and(this.source.readShort(), 65535);
                readInt = this.source.readInt();
                if (and != 2) {
                    if (and != 4) {
                        if (and == 5 && (readInt < 16384 || readInt > 16777215)) {
                            break;
                        }
                    } else if (readInt < 0) {
                        throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                    }
                } else if (readInt != 0 && readInt != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                settings.set(and, readInt);
                if (e6 == f6) {
                    break;
                } else {
                    e6 += g6;
                }
            }
            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + readInt);
        }
        handler.settings(false, settings);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z5, @NotNull Handler handler) throws IOException {
        g0.p(handler, "handler");
        try {
            this.source.require(9L);
            int readMedium = _UtilCommonKt.readMedium(this.source);
            if (readMedium > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + readMedium);
            }
            int and = _UtilCommonKt.and(this.source.readByte(), 255);
            int and2 = _UtilCommonKt.and(this.source.readByte(), 255);
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            if (and != 8) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.INSTANCE.frameLog(true, readInt, readMedium, and, and2));
                }
            }
            if (z5 && and != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(and));
            }
            switch (and) {
                case 0:
                    readData(handler, readMedium, and2, readInt);
                    return true;
                case 1:
                    readHeaders(handler, readMedium, and2, readInt);
                    return true;
                case 2:
                    readPriority(handler, readMedium, and2, readInt);
                    return true;
                case 3:
                    readRstStream(handler, readMedium, and2, readInt);
                    return true;
                case 4:
                    readSettings(handler, readMedium, and2, readInt);
                    return true;
                case 5:
                    readPushPromise(handler, readMedium, and2, readInt);
                    return true;
                case 6:
                    readPing(handler, readMedium, and2, readInt);
                    return true;
                case 7:
                    readGoAway(handler, readMedium, and2, readInt);
                    return true;
                case 8:
                    readWindowUpdate(handler, readMedium, and2, readInt);
                    return true;
                default:
                    this.source.skip(readMedium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(@NotNull Handler handler) throws IOException {
        g0.p(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        BufferedSource bufferedSource = this.source;
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString readByteString = bufferedSource.readByteString(byteString.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(_UtilJvmKt.format("<< CONNECTION " + readByteString.hex(), new Object[0]));
        }
        if (g0.g(byteString, readByteString)) {
            return;
        }
        throw new IOException("Expected a connection header but was " + readByteString.utf8());
    }

    private final void readPriority(Handler handler, int i6) throws IOException {
        int readInt = this.source.readInt();
        handler.priority(i6, readInt & Integer.MAX_VALUE, _UtilCommonKt.and(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }
}
