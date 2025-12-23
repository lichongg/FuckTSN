package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okio.internal._JavaIoKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmOkio.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmOkio.kt\nokio/InputStreamSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,234:1\n1#2:235\n85#3:236\n*S KotlinDebug\n*F\n+ 1 JvmOkio.kt\nokio/InputStreamSource\n*L\n93#1:236\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
class InputStreamSource implements Source {

    @NotNull
    private final InputStream input;

    @NotNull
    private final Timeout timeout;

    public InputStreamSource(@NotNull InputStream input, @NotNull Timeout timeout) {
        g0.p(input, "input");
        g0.p(timeout, "timeout");
        this.input = input;
        this.timeout = timeout;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.input.close();
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
        try {
            this.timeout.throwIfReached();
            Segment writableSegment$okio = sink.writableSegment$okio(1);
            int read = this.input.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j6, 8192 - writableSegment$okio.limit));
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
        } catch (AssertionError e6) {
            if (_JavaIoKt.isAndroidGetsocknameError(e6)) {
                throw new IOException(e6);
            }
            throw e6;
        }
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }

    @NotNull
    public String toString() {
        return "source(" + this.input + ')';
    }
}
