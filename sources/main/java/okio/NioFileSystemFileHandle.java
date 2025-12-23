package okio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class NioFileSystemFileHandle extends FileHandle {

    @NotNull
    private final FileChannel fileChannel;

    @Override // okio.FileHandle
    protected synchronized void protectedClose() {
        this.fileChannel.close();
    }

    @Override // okio.FileHandle
    protected synchronized void protectedFlush() {
        this.fileChannel.force(true);
    }

    @Override // okio.FileHandle
    protected synchronized int protectedRead(long j6, @NotNull byte[] array, int i6, int i7) {
        g0.p(array, "array");
        this.fileChannel.position(j6);
        ByteBuffer wrap = ByteBuffer.wrap(array, i6, i7);
        int i8 = 0;
        while (true) {
            if (i8 >= i7) {
                break;
            }
            int read = this.fileChannel.read(wrap);
            if (read != -1) {
                i8 += read;
            } else if (i8 == 0) {
                return -1;
            }
        }
        return i8;
    }

    @Override // okio.FileHandle
    protected synchronized void protectedResize(long j6) {
        try {
            try {
                long size = size();
                long j7 = j6 - size;
                if (j7 > 0) {
                    int i6 = (int) j7;
                    protectedWrite(size, new byte[i6], 0, i6);
                } else {
                    this.fileChannel.truncate(j6);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @Override // okio.FileHandle
    protected synchronized long protectedSize() {
        return this.fileChannel.size();
    }

    @Override // okio.FileHandle
    protected synchronized void protectedWrite(long j6, @NotNull byte[] array, int i6, int i7) {
        g0.p(array, "array");
        this.fileChannel.position(j6);
        this.fileChannel.write(ByteBuffer.wrap(array, i6, i7));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NioFileSystemFileHandle(boolean z5, @NotNull FileChannel fileChannel) {
        super(z5);
        g0.p(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }
}
