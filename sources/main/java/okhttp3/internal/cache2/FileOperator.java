package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.g0;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FileOperator {

    @NotNull
    private final FileChannel fileChannel;

    public FileOperator(@NotNull FileChannel fileChannel) {
        g0.p(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j6, @NotNull Buffer sink, long j7) {
        g0.p(sink, "sink");
        if (j7 < 0) {
            throw new IndexOutOfBoundsException();
        }
        long j8 = j6;
        long j9 = j7;
        while (j9 > 0) {
            long transferTo = this.fileChannel.transferTo(j8, j9, sink);
            j8 += transferTo;
            j9 -= transferTo;
        }
    }

    public final void write(long j6, @NotNull Buffer source, long j7) throws IOException {
        g0.p(source, "source");
        if (j7 < 0 || j7 > source.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j8 = j6;
        long j9 = j7;
        while (j9 > 0) {
            long transferFrom = this.fileChannel.transferFrom(source, j8, j9);
            j8 += transferFrom;
            j9 -= transferFrom;
        }
    }
}
