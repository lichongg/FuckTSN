package io.netty.channel;

import com.kuaishou.weapon.p0.t;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultFileRegion extends AbstractReferenceCounted implements FileRegion {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultFileRegion.class);
    private final long count;

    /* renamed from: f, reason: collision with root package name */
    private final File f43057f;
    private FileChannel file;
    private final long position;
    private long transferred;

    public DefaultFileRegion(FileChannel fileChannel, long j6, long j7) {
        if (fileChannel == null) {
            throw new NullPointerException(b.f50156c);
        }
        ObjectUtil.checkPositiveOrZero(j6, "position");
        ObjectUtil.checkPositiveOrZero(j7, "count");
        this.file = fileChannel;
        this.position = j6;
        this.count = j7;
        this.f43057f = null;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion touch() {
        return this;
    }

    static void validate(DefaultFileRegion defaultFileRegion, long j6) throws IOException {
        long size = defaultFileRegion.file.size();
        if (defaultFileRegion.position + (defaultFileRegion.count - j6) + j6 <= size) {
            return;
        }
        throw new IOException("Underlying file size " + size + " smaller then requested count " + defaultFileRegion.count);
    }

    @Override // io.netty.channel.FileRegion
    public long count() {
        return this.count;
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        FileChannel fileChannel = this.file;
        if (fileChannel == null) {
            return;
        }
        this.file = null;
        try {
            fileChannel.close();
        } catch (IOException e6) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a file.", (Throwable) e6);
            }
        }
    }

    public boolean isOpen() {
        return this.file != null;
    }

    @Override // io.netty.channel.FileRegion
    public long position() {
        return this.position;
    }

    @Override // io.netty.util.ReferenceCounted
    public FileRegion touch(Object obj) {
        return this;
    }

    @Override // io.netty.channel.FileRegion
    public long transferTo(WritableByteChannel writableByteChannel, long j6) throws IOException {
        long j7 = this.count - j6;
        if (j7 < 0 || j6 < 0) {
            throw new IllegalArgumentException("position out of range: " + j6 + " (expected: 0 - " + (this.count - 1) + ')');
        }
        if (j7 == 0) {
            return 0L;
        }
        if (refCnt() == 0) {
            throw new IllegalReferenceCountException(0);
        }
        open();
        long transferTo = this.file.transferTo(this.position + j6, j7, writableByteChannel);
        if (transferTo > 0) {
            this.transferred += transferTo;
            return transferTo;
        }
        if (transferTo == 0) {
            validate(this, j6);
        }
        return transferTo;
    }

    @Override // io.netty.channel.FileRegion
    @Deprecated
    public long transfered() {
        return this.transferred;
    }

    @Override // io.netty.channel.FileRegion
    public long transferred() {
        return this.transferred;
    }

    public void open() throws IOException {
        if (!isOpen() && refCnt() > 0) {
            this.file = new RandomAccessFile(this.f43057f, t.f36150k).getChannel();
        }
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion retain(int i6) {
        super.retain(i6);
        return this;
    }

    public DefaultFileRegion(File file, long j6, long j7) {
        if (file != null) {
            ObjectUtil.checkPositiveOrZero(j6, "position");
            ObjectUtil.checkPositiveOrZero(j7, "count");
            this.position = j6;
            this.count = j7;
            this.f43057f = file;
            return;
        }
        throw new NullPointerException("f");
    }
}
