package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractDiskHttpData extends AbstractHttpData {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractDiskHttpData.class);
    private File file;
    private FileChannel fileChannel;
    private boolean isRenamed;

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z5) throws IOException {
        if (byteBuf != null) {
            try {
                int readableBytes = byteBuf.readableBytes();
                long j6 = readableBytes;
                checkSize(this.size + j6);
                long j7 = this.definedSize;
                if (j7 > 0 && j7 < this.size + j6) {
                    throw new IOException("Out of size: " + (this.size + j6) + " > " + this.definedSize);
                }
                ByteBuffer nioBuffer = byteBuf.nioBufferCount() == 1 ? byteBuf.nioBuffer() : byteBuf.copy().nioBuffer();
                if (this.file == null) {
                    this.file = tempFile();
                }
                if (this.fileChannel == null) {
                    this.fileChannel = new FileOutputStream(this.file).getChannel();
                }
                int i6 = 0;
                while (i6 < readableBytes) {
                    i6 += this.fileChannel.write(nioBuffer);
                }
                this.size += j6;
                byteBuf.readerIndex(byteBuf.readerIndex() + i6);
                byteBuf.release();
            } catch (Throwable th) {
                byteBuf.release();
                throw th;
            }
        }
        if (!z5) {
            if (byteBuf == null) {
                throw new NullPointerException("buffer");
            }
            return;
        }
        if (this.file == null) {
            this.file = tempFile();
        }
        if (this.fileChannel == null) {
            this.fileChannel = new FileOutputStream(this.file).getChannel();
        }
        this.fileChannel.force(false);
        this.fileChannel.close();
        this.fileChannel = null;
        setCompleted();
    }

    protected abstract boolean deleteOnExit();

    protected abstract String getBaseDirectory();

    protected abstract String getDiskFilename();

    protected abstract String getPostfix();

    protected abstract String getPrefix();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() throws IOException {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        if (byteBuf == null) {
            throw new NullPointerException("buffer");
        }
        try {
            long readableBytes = byteBuf.readableBytes();
            this.size = readableBytes;
            checkSize(readableBytes);
            long j6 = this.definedSize;
            if (j6 > 0 && j6 < this.size) {
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            if (this.file == null) {
                this.file = tempFile();
            }
            if (byteBuf.readableBytes() == 0) {
                if (!this.file.createNewFile()) {
                    if (this.file.length() == 0) {
                        byteBuf.release();
                        return;
                    } else if (!this.file.delete() || !this.file.createNewFile()) {
                        throw new IOException("file exists already: " + this.file);
                    }
                }
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                ByteBuffer nioBuffer = byteBuf.nioBuffer();
                int i6 = 0;
                while (i6 < this.size) {
                    i6 += channel.write(nioBuffer);
                }
                byteBuf.readerIndex(byteBuf.readerIndex() + i6);
                channel.force(false);
                fileOutputStream.close();
                setCompleted();
                byteBuf.release();
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            byteBuf.release();
        }
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        FileChannel fileChannel = this.fileChannel;
        if (fileChannel != null) {
            try {
                fileChannel.force(false);
                this.fileChannel.close();
            } catch (IOException e6) {
                logger.warn("Failed to close a file.", (Throwable) e6);
            }
            this.fileChannel = null;
        }
        if (this.isRenamed) {
            return;
        }
        File file = this.file;
        if (file != null && file.exists() && !this.file.delete()) {
            logger.warn("Failed to delete: {}", this.file);
        }
        this.file = null;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() throws IOException {
        File file = this.file;
        return file == null ? EmptyArrays.EMPTY_BYTES : readFrom(file);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() throws IOException {
        File file = this.file;
        return file == null ? Unpooled.EMPTY_BUFFER : Unpooled.wrappedBuffer(readFrom(file));
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i6) throws IOException {
        if (this.file == null || i6 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        if (this.fileChannel == null) {
            this.fileChannel = new FileInputStream(this.file).getChannel();
        }
        ByteBuffer allocate = ByteBuffer.allocate(i6);
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                break;
            }
            int read = this.fileChannel.read(allocate);
            if (read == -1) {
                this.fileChannel.close();
                this.fileChannel = null;
                break;
            }
            i7 += read;
        }
        if (i7 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        allocate.flip();
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(allocate);
        wrappedBuffer.readerIndex(0);
        wrappedBuffer.writerIndex(i7);
        return wrappedBuffer;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        return this.file;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) throws IOException {
        File file = this.file;
        return file == null ? "" : charset == null ? new String(readFrom(file), HttpConstants.DEFAULT_CHARSET.name()) : new String(readFrom(file), charset.name());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.netty.handler.codec.http.multipart.HttpData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean renameTo(java.io.File r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.AbstractDiskHttpData.renameTo(java.io.File):boolean");
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        return this;
    }

    protected AbstractDiskHttpData(String str, Charset charset, long j6) {
        super(str, charset, j6);
    }

    private static byte[] readFrom(File file) throws IOException {
        long length = file.length();
        if (length <= 2147483647L) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[(int) length];
            try {
                FileChannel channel = fileInputStream.getChannel();
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                for (int i6 = 0; i6 < length; i6 += channel.read(wrap)) {
                }
                return bArr;
            } finally {
                fileInputStream.close();
            }
        }
        throw new IllegalArgumentException("File too big to be loaded in memory");
    }

    private File tempFile() throws IOException {
        String postfix;
        File createTempFile;
        String diskFilename = getDiskFilename();
        if (diskFilename != null) {
            postfix = '_' + diskFilename;
        } else {
            postfix = getPostfix();
        }
        if (getBaseDirectory() == null) {
            createTempFile = File.createTempFile(getPrefix(), postfix);
        } else {
            createTempFile = File.createTempFile(getPrefix(), postfix, new File(getBaseDirectory()));
        }
        if (deleteOnExit()) {
            createTempFile.deleteOnExit();
        }
        return createTempFile;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        if (this.file != null) {
            delete();
        }
        this.file = file;
        long length = file.length();
        this.size = length;
        checkSize(length);
        this.isRenamed = true;
        setCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            if (this.file != null) {
                delete();
            }
            this.file = tempFile();
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                byte[] bArr = new byte[16384];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                int read = inputStream.read(bArr);
                int i6 = 0;
                while (read > 0) {
                    wrap.position(read).flip();
                    i6 += channel.write(wrap);
                    checkSize(i6);
                    read = inputStream.read(bArr);
                }
                channel.force(false);
                fileOutputStream.close();
                long j6 = i6;
                this.size = j6;
                long j7 = this.definedSize;
                if (j7 > 0 && j7 < j6) {
                    if (!this.file.delete()) {
                        logger.warn("Failed to delete: {}", this.file);
                    }
                    this.file = null;
                    throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
                }
                this.isRenamed = true;
                setCompleted();
                return;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        }
        throw new NullPointerException("inputStream");
    }
}
