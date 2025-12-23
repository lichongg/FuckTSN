package io.netty.channel.unix;

import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import master.flame.danmaku.danmaku.parser.b;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FileDescriptor {
    private static final int STATE_ALL_MASK = 7;
    private static final int STATE_CLOSED_MASK = 1;
    private static final int STATE_INPUT_SHUTDOWN_MASK = 2;
    private static final int STATE_OUTPUT_SHUTDOWN_MASK = 4;
    private static final AtomicIntegerFieldUpdater<FileDescriptor> stateUpdater = AtomicIntegerFieldUpdater.newUpdater(FileDescriptor.class, "state");
    final int fd;
    volatile int state;

    private static native int close(int i6);

    public static FileDescriptor from(String str) throws IOException {
        ObjectUtil.checkNotNull(str, "path");
        int open = open(str);
        if (open >= 0) {
            return new FileDescriptor(open);
        }
        throw Errors.newIOException("open", open);
    }

    static boolean isClosed(int i6) {
        return (i6 & 1) != 0;
    }

    private static native long newPipe();

    private static native int open(String str);

    private static native int read(int i6, ByteBuffer byteBuffer, int i7, int i8);

    private static native int readAddress(int i6, long j6, int i7, int i8);

    private static native int write(int i6, ByteBuffer byteBuffer, int i7, int i8);

    private static native int writeAddress(int i6, long j6, int i7, int i8);

    private static native long writev(int i6, ByteBuffer[] byteBufferArr, int i7, int i8, long j6);

    private static native long writevAddresses(int i6, long j6, int i7);

    public void close() throws IOException {
        int i6;
        do {
            i6 = this.state;
            if (isClosed(i6)) {
                return;
            }
        } while (!casState(i6, i6 | 7));
        int close = close(this.fd);
        if (close < 0) {
            throw Errors.newIOException("close", close);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FileDescriptor) && this.fd == ((FileDescriptor) obj).fd;
    }

    public final int read(ByteBuffer byteBuffer, int i6, int i7) throws IOException {
        int read = read(this.fd, byteBuffer, i6, i7);
        if (read > 0) {
            return read;
        }
        if (read == 0) {
            return -1;
        }
        return Errors.ioResult("read", read);
    }

    public final int readAddress(long j6, int i6, int i7) throws IOException {
        int readAddress = readAddress(this.fd, j6, i6, i7);
        if (readAddress > 0) {
            return readAddress;
        }
        if (readAddress == 0) {
            return -1;
        }
        return Errors.ioResult("readAddress", readAddress);
    }

    public final int write(ByteBuffer byteBuffer, int i6, int i7) throws IOException {
        int write = write(this.fd, byteBuffer, i6, i7);
        return write >= 0 ? write : Errors.ioResult("write", write);
    }

    public final int writeAddress(long j6, int i6, int i7) throws IOException {
        int writeAddress = writeAddress(this.fd, j6, i6, i7);
        return writeAddress >= 0 ? writeAddress : Errors.ioResult("writeAddress", writeAddress);
    }

    public final long writev(ByteBuffer[] byteBufferArr, int i6, int i7, long j6) throws IOException {
        long writev = writev(this.fd, byteBufferArr, i6, Math.min(Limits.IOV_MAX, i7), j6);
        return writev >= 0 ? writev : Errors.ioResult("writev", (int) writev);
    }

    public final long writevAddresses(long j6, int i6) throws IOException {
        long writevAddresses = writevAddresses(this.fd, j6, i6);
        return writevAddresses >= 0 ? writevAddresses : Errors.ioResult("writevAddresses", (int) writevAddresses);
    }

    static int inputShutdown(int i6) {
        return i6 | 2;
    }

    static boolean isInputShutdown(int i6) {
        return (i6 & 2) != 0;
    }

    static boolean isOutputShutdown(int i6) {
        return (i6 & 4) != 0;
    }

    static int outputShutdown(int i6) {
        return i6 | 4;
    }

    final boolean casState(int i6, int i7) {
        return stateUpdater.compareAndSet(this, i6, i7);
    }

    public int hashCode() {
        return this.fd;
    }

    public final int intValue() {
        return this.fd;
    }

    public boolean isOpen() {
        return !isClosed(this.state);
    }

    public String toString() {
        return "FileDescriptor{fd=" + this.fd + '}';
    }

    public FileDescriptor(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
        this.fd = i6;
    }

    public static FileDescriptor[] pipe() throws IOException {
        long newPipe = newPipe();
        if (newPipe >= 0) {
            return new FileDescriptor[]{new FileDescriptor((int) (newPipe >>> 32)), new FileDescriptor((int) newPipe)};
        }
        throw Errors.newIOException("newPipe", (int) newPipe);
    }

    public static FileDescriptor from(File file) throws IOException {
        return from(((File) ObjectUtil.checkNotNull(file, b.f50156c)).getPath());
    }
}
