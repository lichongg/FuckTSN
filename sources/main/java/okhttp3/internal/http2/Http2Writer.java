package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHttp2Writer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Writer.kt\nokhttp3/internal/http2/Http2Writer\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,384:1\n63#2:385\n63#2:386\n63#2:387\n63#2:388\n63#2:389\n63#2:390\n63#2:391\n63#2:392\n63#2:393\n63#2:395\n63#2:396\n63#2:397\n1#3:394\n*S KotlinDebug\n*F\n+ 1 Http2Writer.kt\nokhttp3/internal/http2/Http2Writer\n*L\n60#1:385\n74#1:386\n108#1:387\n129#1:388\n140#1:389\n172#1:390\n201#1:391\n228#1:392\n256#1:393\n283#1:395\n329#1:396\n360#1:397\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Http2Writer implements Closeable, Lockable {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;

    @NotNull
    private final Buffer hpackBuffer;

    @NotNull
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;

    @NotNull
    private final BufferedSink sink;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.closed = true;
            this.sink.close();
            n1 n1Var = n1.f44123a;
        }
    }

    public final void connectionPreface() throws IOException {
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (this.client) {
                    Logger logger2 = logger;
                    if (logger2.isLoggable(Level.FINE)) {
                        logger2.fine(_UtilJvmKt.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                    }
                    this.sink.write(Http2.CONNECTION_PREFACE);
                    this.sink.flush();
                    n1 n1Var = n1.f44123a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void data(boolean z5, int i6, @Nullable Buffer buffer, int i7) throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            dataFrame(i6, z5 ? 1 : 0, buffer, i7);
            n1 n1Var = n1.f44123a;
        }
    }

    public final void dataFrame(int i6, int i7, @Nullable Buffer buffer, int i8) throws IOException {
        frameHeader(i6, i8, 0, i7);
        if (i8 > 0) {
            BufferedSink bufferedSink = this.sink;
            g0.m(buffer);
            bufferedSink.write(buffer, i8);
        }
    }

    public final void flush() throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.sink.flush();
            n1 n1Var = n1.f44123a;
        }
    }

    public final void ping(boolean z5, int i6, int i7) throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            frameHeader(0, 8, 6, z5 ? 1 : 0);
            this.sink.writeInt(i6);
            this.sink.writeInt(i7);
            this.sink.flush();
            n1 n1Var = n1.f44123a;
        }
    }

    public final void windowUpdate(int i6, long j6) throws IOException {
        int i7;
        long j7;
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (j6 == 0 || j6 > 2147483647L) {
                    throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j6).toString());
                }
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    i7 = i6;
                    j7 = j6;
                    logger2.fine(Http2.INSTANCE.frameLogWindowUpdate(false, i7, 4, j7));
                } else {
                    i7 = i6;
                    j7 = j6;
                }
                frameHeader(i7, 4, 8, 0);
                this.sink.writeInt((int) j7);
                this.sink.flush();
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Http2Writer(@NotNull BufferedSink sink, boolean z5) {
        g0.p(sink, "sink");
        this.sink = sink;
        this.client = z5;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    private final void writeContinuationFrames(int i6, long j6) throws IOException {
        while (j6 > 0) {
            long min = Math.min(this.maxFrameSize, j6);
            j6 -= min;
            frameHeader(i6, (int) min, 9, j6 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final void applyAndAckSettings(@NotNull Settings peerSettings) throws IOException {
        g0.p(peerSettings, "peerSettings");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
                if (peerSettings.getHeaderTableSize() != -1) {
                    this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
                }
                frameHeader(0, 0, 4, 1);
                this.sink.flush();
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void frameHeader(int r9, int r10, int r11, int r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 8
            if (r11 == r0) goto L1d
            java.util.logging.Logger r0 = okhttp3.internal.http2.Http2Writer.logger
            java.util.logging.Level r1 = java.util.logging.Level.FINE
            boolean r1 = r0.isLoggable(r1)
            if (r1 == 0) goto L1d
            okhttp3.internal.http2.Http2 r2 = okhttp3.internal.http2.Http2.INSTANCE
            r3 = 0
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            java.lang.String r9 = r2.frameLog(r3, r4, r5, r6, r7)
            r0.fine(r9)
            goto L21
        L1d:
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
        L21:
            int r9 = r8.maxFrameSize
            if (r5 > r9) goto L62
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r9 & r4
            if (r9 != 0) goto L47
            okio.BufferedSink r9 = r8.sink
            okhttp3.internal._UtilCommonKt.writeMedium(r9, r5)
            okio.BufferedSink r9 = r8.sink
            r10 = r6 & 255(0xff, float:3.57E-43)
            r9.writeByte(r10)
            okio.BufferedSink r9 = r8.sink
            r10 = r7 & 255(0xff, float:3.57E-43)
            r9.writeByte(r10)
            okio.BufferedSink r9 = r8.sink
            r10 = 2147483647(0x7fffffff, float:NaN)
            r10 = r10 & r4
            r9.writeInt(r10)
            return
        L47:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "reserved bit set: "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L62:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "FRAME_SIZE_ERROR length > "
            r9.append(r10)
            int r10 = r8.maxFrameSize
            r9.append(r10)
            java.lang.String r10 = ": "
            r9.append(r10)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Writer.frameHeader(int, int, int, int):void");
    }

    @NotNull
    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final void goAway(int i6, @NotNull ErrorCode errorCode, @NotNull byte[] debugData) throws IOException {
        g0.p(errorCode, "errorCode");
        g0.p(debugData, "debugData");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (errorCode.getHttpCode() == -1) {
                    throw new IllegalArgumentException("errorCode.httpCode == -1");
                }
                frameHeader(0, debugData.length + 8, 7, 0);
                this.sink.writeInt(i6);
                this.sink.writeInt(errorCode.getHttpCode());
                if (!(debugData.length == 0)) {
                    this.sink.write(debugData);
                }
                this.sink.flush();
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void headers(boolean z5, int i6, @NotNull List<Header> headerBlock) throws IOException {
        g0.p(headerBlock, "headerBlock");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                this.hpackWriter.writeHeaders(headerBlock);
                long size = this.hpackBuffer.size();
                long min = Math.min(this.maxFrameSize, size);
                int i7 = size == min ? 4 : 0;
                if (z5) {
                    i7 |= 1;
                }
                frameHeader(i6, (int) min, 1, i7);
                this.sink.write(this.hpackBuffer, min);
                if (size > min) {
                    writeContinuationFrames(i6, size - min);
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final void pushPromise(int i6, int i7, @NotNull List<Header> requestHeaders) throws IOException {
        g0.p(requestHeaders, "requestHeaders");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                this.hpackWriter.writeHeaders(requestHeaders);
                long size = this.hpackBuffer.size();
                int min = (int) Math.min(this.maxFrameSize - 4, size);
                long j6 = min;
                frameHeader(i6, min + 4, 5, size == j6 ? 4 : 0);
                this.sink.writeInt(i7 & Integer.MAX_VALUE);
                this.sink.write(this.hpackBuffer, j6);
                if (size > j6) {
                    writeContinuationFrames(i6, size - j6);
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void rstStream(int i6, @NotNull ErrorCode errorCode) throws IOException {
        g0.p(errorCode, "errorCode");
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            frameHeader(i6, 4, 3, 0);
            this.sink.writeInt(errorCode.getHttpCode());
            this.sink.flush();
            n1 n1Var = n1.f44123a;
        }
    }

    public final void settings(@NotNull Settings settings) throws IOException {
        g0.p(settings, "settings");
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                frameHeader(0, settings.size() * 6, 4, 0);
                for (int i6 = 0; i6 < 10; i6++) {
                    if (settings.isSet(i6)) {
                        this.sink.writeShort(i6);
                        this.sink.writeInt(settings.get(i6));
                    }
                }
                this.sink.flush();
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
