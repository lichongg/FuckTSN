package okio;

import java.io.OutputStream;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmOkio.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmOkio.kt\nokio/OutputStreamSink\n+ 2 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,234:1\n85#2:235\n*S KotlinDebug\n*F\n+ 1 JvmOkio.kt\nokio/OutputStreamSink\n*L\n56#1:235\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
final class OutputStreamSink implements Sink {

    @NotNull
    private final OutputStream out;

    @NotNull
    private final Timeout timeout;

    public OutputStreamSink(@NotNull OutputStream out, @NotNull Timeout timeout) {
        g0.p(out, "out");
        g0.p(timeout, "timeout");
        this.out = out;
        this.timeout = timeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }

    @NotNull
    public String toString() {
        return "sink(" + this.out + ')';
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
            this.out.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j7 = min;
            j6 -= j7;
            source.setSize$okio(source.size() - j7);
            if (segment.pos == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }
}
