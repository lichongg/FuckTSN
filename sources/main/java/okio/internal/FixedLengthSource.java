package okio.internal;

import java.io.IOException;
import kotlin.jvm.internal.g0;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(@NotNull Source delegate, long j6, boolean z5) {
        super(delegate);
        g0.p(delegate, "delegate");
        this.size = j6;
        this.truncate = z5;
    }

    private final void truncateToSize(Buffer buffer, long j6) {
        Buffer buffer2 = new Buffer();
        buffer2.writeAll(buffer);
        buffer.write(buffer2, j6);
        buffer2.clear();
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(@NotNull Buffer sink, long j6) {
        g0.p(sink, "sink");
        long j7 = this.bytesReceived;
        long j8 = this.size;
        if (j7 > j8) {
            j6 = 0;
        } else if (this.truncate) {
            long j9 = j8 - j7;
            if (j9 == 0) {
                return -1L;
            }
            j6 = Math.min(j6, j9);
        }
        long read = super.read(sink, j6);
        if (read != -1) {
            this.bytesReceived += read;
        }
        long j10 = this.bytesReceived;
        long j11 = this.size;
        if ((j10 >= j11 || read != -1) && j10 <= j11) {
            return read;
        }
        if (read > 0 && j10 > j11) {
            truncateToSize(sink, sink.size() - (this.bytesReceived - this.size));
        }
        throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
    }
}
