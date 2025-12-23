package okio;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFileHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileHandle.kt\nokio/FileHandle\n+ 2 -JvmPlatform.kt\nokio/_JvmPlatformKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 5 RealBufferedSink.kt\nokio/RealBufferedSink\n+ 6 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,444:1\n40#2:445\n40#2:447\n40#2:448\n40#2:449\n40#2:450\n40#2:451\n40#2:452\n40#2:453\n40#2:457\n40#2:459\n1#3:446\n63#4:454\n63#4:455\n63#4:456\n51#5:458\n85#6:460\n85#6:461\n*S KotlinDebug\n*F\n+ 1 FileHandle.kt\nokio/FileHandle\n*L\n69#1:445\n81#1:447\n92#1:448\n105#1:449\n119#1:450\n129#1:451\n139#1:452\n151#1:453\n221#1:457\n287#1:459\n169#1:454\n195#1:455\n202#1:456\n248#1:458\n345#1:460\n374#1:461\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class FileHandle implements Closeable {
    private boolean closed;

    @NotNull
    private final ReentrantLock lock = _JvmPlatformKt.newLock();
    private int openStreamCount;
    private final boolean readWrite;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nFileHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileHandle.kt\nokio/FileHandle$FileHandleSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 -JvmPlatform.kt\nokio/_JvmPlatformKt\n*L\n1#1,444:1\n1#2:445\n40#3:446\n*S KotlinDebug\n*F\n+ 1 FileHandle.kt\nokio/FileHandle$FileHandleSink\n*L\n410#1:446\n*E\n"})
    private static final class FileHandleSink implements Sink {
        private boolean closed;

        @NotNull
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(@NotNull FileHandle fileHandle, long j6) {
            g0.p(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j6;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock lock = this.fileHandle.getLock();
            lock.lock();
            try {
                FileHandle fileHandle = this.fileHandle;
                fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    n1 n1Var = n1.f44123a;
                    lock.unlock();
                    this.fileHandle.protectedClose();
                }
            } finally {
                lock.unlock();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.fileHandle.protectedFlush();
        }

        public final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setClosed(boolean z5) {
            this.closed = z5;
        }

        public final void setPosition(long j6) {
            this.position = j6;
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long j6) {
            g0.p(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.fileHandle.writeNoCloseCheck(this.position, source, j6);
            this.position += j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nFileHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileHandle.kt\nokio/FileHandle$FileHandleSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 -JvmPlatform.kt\nokio/_JvmPlatformKt\n*L\n1#1,444:1\n1#2:445\n40#3:446\n*S KotlinDebug\n*F\n+ 1 FileHandle.kt\nokio/FileHandle$FileHandleSource\n*L\n436#1:446\n*E\n"})
    private static final class FileHandleSource implements Source {
        private boolean closed;

        @NotNull
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(@NotNull FileHandle fileHandle, long j6) {
            g0.p(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j6;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock lock = this.fileHandle.getLock();
            lock.lock();
            try {
                FileHandle fileHandle = this.fileHandle;
                fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    n1 n1Var = n1.f44123a;
                    lock.unlock();
                    this.fileHandle.protectedClose();
                }
            } finally {
                lock.unlock();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long j6) {
            g0.p(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long readNoCloseCheck = this.fileHandle.readNoCloseCheck(this.position, sink, j6);
            if (readNoCloseCheck != -1) {
                this.position += readNoCloseCheck;
            }
            return readNoCloseCheck;
        }

        public final void setClosed(boolean z5) {
            this.closed = z5;
        }

        public final void setPosition(long j6) {
            this.position = j6;
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    public final long position(@NotNull Source source) throws IOException {
        long j6;
        g0.p(source, "source");
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            j6 = realBufferedSource.bufferField.size();
            source = realBufferedSource.source;
        } else {
            j6 = 0;
        }
        if (!(source instanceof FileHandleSource) || ((FileHandleSource) source).getFileHandle() != this) {
            throw new IllegalArgumentException("source was not created by this FileHandle");
        }
        FileHandleSource fileHandleSource = (FileHandleSource) source;
        if (fileHandleSource.getClosed()) {
            throw new IllegalStateException("closed");
        }
        return fileHandleSource.getPosition() - j6;
    }

    protected abstract void protectedClose() throws IOException;

    protected abstract void protectedFlush() throws IOException;

    protected abstract int protectedRead(long j6, @NotNull byte[] bArr, int i6, int i7) throws IOException;

    protected abstract void protectedResize(long j6) throws IOException;

    protected abstract long protectedSize() throws IOException;

    protected abstract void protectedWrite(long j6, @NotNull byte[] bArr, int i6, int i7) throws IOException;

    public final int read(long j6, @NotNull byte[] array, int i6, int i7) throws IOException {
        g0.p(array, "array");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
            return protectedRead(j6, array, i6, i7);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void reposition(@NotNull Source source, long j6) throws IOException {
        g0.p(source, "source");
        if (!(source instanceof RealBufferedSource)) {
            if (!(source instanceof FileHandleSource) || ((FileHandleSource) source).getFileHandle() != this) {
                throw new IllegalArgumentException("source was not created by this FileHandle");
            }
            FileHandleSource fileHandleSource = (FileHandleSource) source;
            if (fileHandleSource.getClosed()) {
                throw new IllegalStateException("closed");
            }
            fileHandleSource.setPosition(j6);
            return;
        }
        RealBufferedSource realBufferedSource = (RealBufferedSource) source;
        Source source2 = realBufferedSource.source;
        if (!(source2 instanceof FileHandleSource) || ((FileHandleSource) source2).getFileHandle() != this) {
            throw new IllegalArgumentException("source was not created by this FileHandle");
        }
        FileHandleSource fileHandleSource2 = (FileHandleSource) source2;
        if (fileHandleSource2.getClosed()) {
            throw new IllegalStateException("closed");
        }
        long size = realBufferedSource.bufferField.size();
        long position = j6 - (fileHandleSource2.getPosition() - size);
        if (0 <= position && position < size) {
            realBufferedSource.skip(position);
        } else {
            realBufferedSource.bufferField.clear();
            fileHandleSource2.setPosition(j6);
        }
    }

    public final void write(long j6, @NotNull byte[] array, int i6, int i7) {
        g0.p(array, "array");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
            protectedWrite(j6, array, i6, i7);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long readNoCloseCheck(long j6, Buffer buffer, long j7) {
        if (j7 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        long j8 = j7 + j6;
        long j9 = j6;
        while (true) {
            if (j9 >= j8) {
                break;
            }
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int protectedRead = protectedRead(j9, writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j8 - j9, 8192 - r7));
            if (protectedRead == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (j6 == j9) {
                    return -1L;
                }
            } else {
                writableSegment$okio.limit += protectedRead;
                long j10 = protectedRead;
                j9 += j10;
                buffer.setSize$okio(buffer.size() + j10);
            }
        }
        return j9 - j6;
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j6, int i6, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i6 & 1) != 0) {
            j6 = 0;
        }
        return fileHandle.sink(j6);
    }

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long j6, int i6, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
        }
        if ((i6 & 1) != 0) {
            j6 = 0;
        }
        return fileHandle.source(j6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.openStreamCount != 0) {
                return;
            }
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
            protectedClose();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void flush() throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
            protectedFlush();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final void resize(long j6) throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
            protectedResize(j6);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @NotNull
    public final Sink sink(long j6) throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new FileHandleSink(this, j6);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
            return protectedSize();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @NotNull
    public final Source source(long j6) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new FileHandleSource(this, j6);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public FileHandle(boolean z5) {
        this.readWrite = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeNoCloseCheck(long j6, Buffer buffer, long j7) {
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, j7);
        long j8 = j6 + j7;
        long j9 = j6;
        while (j9 < j8) {
            Segment segment = buffer.head;
            g0.m(segment);
            int min = (int) Math.min(j8 - j9, segment.limit - segment.pos);
            protectedWrite(j9, segment.data, segment.pos, min);
            segment.pos += min;
            long j10 = min;
            j9 += j10;
            buffer.setSize$okio(buffer.size() - j10);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @NotNull
    public final Sink appendingSink() throws IOException {
        return sink(size());
    }

    public final long read(long j6, @NotNull Buffer sink, long j7) throws IOException {
        g0.p(sink, "sink");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.closed) {
                n1 n1Var = n1.f44123a;
                reentrantLock.unlock();
                return readNoCloseCheck(j6, sink, j7);
            }
            throw new IllegalStateException("closed");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long position(@NotNull Sink sink) throws IOException {
        long j6;
        g0.p(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            j6 = realBufferedSink.bufferField.size();
            sink = realBufferedSink.sink;
        } else {
            j6 = 0;
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            FileHandleSink fileHandleSink = (FileHandleSink) sink;
            if (!fileHandleSink.getClosed()) {
                return fileHandleSink.getPosition() + j6;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle");
    }

    public final void write(long j6, @NotNull Buffer source, long j7) throws IOException {
        g0.p(source, "source");
        if (this.readWrite) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.closed) {
                    n1 n1Var = n1.f44123a;
                    reentrantLock.unlock();
                    writeNoCloseCheck(j6, source, j7);
                    return;
                }
                throw new IllegalStateException("closed");
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        throw new IllegalStateException("file handle is read-only");
    }

    public final void reposition(@NotNull Sink sink, long j6) throws IOException {
        g0.p(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            Sink sink2 = realBufferedSink.sink;
            if ((sink2 instanceof FileHandleSink) && ((FileHandleSink) sink2).getFileHandle() == this) {
                FileHandleSink fileHandleSink = (FileHandleSink) sink2;
                if (!fileHandleSink.getClosed()) {
                    realBufferedSink.emit();
                    fileHandleSink.setPosition(j6);
                    return;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("sink was not created by this FileHandle");
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            FileHandleSink fileHandleSink2 = (FileHandleSink) sink;
            if (!fileHandleSink2.getClosed()) {
                fileHandleSink2.setPosition(j6);
                return;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle");
    }
}
