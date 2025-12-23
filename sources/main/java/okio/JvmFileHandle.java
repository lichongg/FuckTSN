package okio;

import java.io.RandomAccessFile;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class JvmFileHandle extends FileHandle {

    @NotNull
    private final RandomAccessFile randomAccessFile;

    @Override // okio.FileHandle
    protected synchronized void protectedClose() {
        this.randomAccessFile.close();
    }

    @Override // okio.FileHandle
    protected synchronized void protectedFlush() {
        this.randomAccessFile.getFD().sync();
    }

    @Override // okio.FileHandle
    protected synchronized int protectedRead(long j6, @NotNull byte[] array, int i6, int i7) {
        g0.p(array, "array");
        this.randomAccessFile.seek(j6);
        int i8 = 0;
        while (true) {
            if (i8 >= i7) {
                break;
            }
            int read = this.randomAccessFile.read(array, i6, i7 - i8);
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
                    this.randomAccessFile.setLength(j6);
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
        return this.randomAccessFile.length();
    }

    @Override // okio.FileHandle
    protected synchronized void protectedWrite(long j6, @NotNull byte[] array, int i6, int i7) {
        g0.p(array, "array");
        this.randomAccessFile.seek(j6);
        this.randomAccessFile.write(array, i6, i7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmFileHandle(boolean z5, @NotNull RandomAccessFile randomAccessFile) {
        super(z5);
        g0.p(randomAccessFile, "randomAccessFile");
        this.randomAccessFile = randomAccessFile;
    }
}
