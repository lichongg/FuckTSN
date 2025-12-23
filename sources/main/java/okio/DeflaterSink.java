package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okio.internal._ZlibJvmKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDeflaterSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeflaterSink.kt\nokio/DeflaterSink\n+ 2 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,140:1\n85#2:141\n*S KotlinDebug\n*F\n+ 1 DeflaterSink.kt\nokio/DeflaterSink\n*L\n39#1:141\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class DeflaterSink implements Sink {
    private boolean closed;

    @NotNull
    private final Deflater deflater;

    @NotNull
    private final BufferedSink sink;

    public DeflaterSink(@NotNull BufferedSink sink, @NotNull Deflater deflater) {
        g0.p(sink, "sink");
        g0.p(deflater, "deflater");
        this.sink = sink;
        this.deflater = deflater;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    private final void deflate(boolean z5) {
        Segment writableSegment$okio;
        int deflate;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            writableSegment$okio = buffer.writableSegment$okio(1);
            if (z5) {
                try {
                    Deflater deflater = this.deflater;
                    byte[] bArr = writableSegment$okio.data;
                    int i6 = writableSegment$okio.limit;
                    deflate = deflater.deflate(bArr, i6, 8192 - i6, 2);
                } catch (NullPointerException e6) {
                    throw new IOException("Deflater already closed", e6);
                }
            } else {
                Deflater deflater2 = this.deflater;
                byte[] bArr2 = writableSegment$okio.data;
                int i7 = writableSegment$okio.limit;
                deflate = deflater2.deflate(bArr2, i7, 8192 - i7);
            }
            if (deflate > 0) {
                writableSegment$okio.limit += deflate;
                buffer.setSize$okio(buffer.size() + deflate);
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        try {
            finishDeflate$okio();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long j6) throws IOException {
        g0.p(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j6);
        while (j6 > 0) {
            Segment segment = source.head;
            g0.m(segment);
            int min = (int) Math.min(j6, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, min);
            deflate(false);
            long j7 = min;
            source.setSize$okio(source.size() - j7);
            int i6 = segment.pos + min;
            segment.pos = i6;
            if (i6 == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j6 -= j7;
        }
        this.deflater.setInput(_ZlibJvmKt.getEMPTY_BYTE_ARRAY(), 0, 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(@NotNull Sink sink, @NotNull Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        g0.p(sink, "sink");
        g0.p(deflater, "deflater");
    }
}
