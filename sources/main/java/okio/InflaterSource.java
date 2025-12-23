package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nInflaterSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InflaterSource.kt\nokio/InflaterSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,132:1\n1#2:133\n85#3:134\n*S KotlinDebug\n*F\n+ 1 InflaterSource.kt\nokio/InflaterSource\n*L\n66#1:134\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;

    @NotNull
    private final Inflater inflater;

    @NotNull
    private final BufferedSource source;

    public InflaterSource(@NotNull BufferedSource source, @NotNull Inflater inflater) {
        g0.p(source, "source");
        g0.p(inflater, "inflater");
        this.source = source;
        this.inflater = inflater;
    }

    private final void releaseBytesAfterInflate() {
        int i6 = this.bufferBytesHeldByInflater;
        if (i6 == 0) {
            return;
        }
        int remaining = i6 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long j6) throws IOException {
        g0.p(sink, "sink");
        do {
            long readOrInflate = readOrInflate(sink, j6);
            if (readOrInflate > 0) {
                return readOrInflate;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(@NotNull Buffer sink, long j6) throws IOException {
        g0.p(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j6 == 0) {
            return 0L;
        }
        try {
            Segment writableSegment$okio = sink.writableSegment$okio(1);
            int min = (int) Math.min(j6, 8192 - writableSegment$okio.limit);
            refill();
            int inflate = this.inflater.inflate(writableSegment$okio.data, writableSegment$okio.limit, min);
            releaseBytesAfterInflate();
            if (inflate > 0) {
                writableSegment$okio.limit += inflate;
                long j7 = inflate;
                sink.setSize$okio(sink.size() + j7);
                return j7;
            }
            if (writableSegment$okio.pos == writableSegment$okio.limit) {
                sink.head = writableSegment$okio.pop();
                SegmentPool.recycle(writableSegment$okio);
            }
            return 0L;
        } catch (DataFormatException e6) {
            throw new IOException(e6);
        }
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.getBuffer().head;
        g0.m(segment);
        int i6 = segment.limit;
        int i7 = segment.pos;
        int i8 = i6 - i7;
        this.bufferBytesHeldByInflater = i8;
        this.inflater.setInput(segment.data, i7, i8);
        return false;
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(@NotNull Source source, @NotNull Inflater inflater) {
        this(Okio.buffer(source), inflater);
        g0.p(source, "source");
        g0.p(inflater, "inflater");
    }
}
