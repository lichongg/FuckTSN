package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractMemoryHttpData extends AbstractHttpData {
    private ByteBuf byteBuf;
    private int chunkPosition;

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return true;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        if (byteBuf == null) {
            throw new NullPointerException("buffer");
        }
        long readableBytes = byteBuf.readableBytes();
        checkSize(readableBytes);
        long j6 = this.definedSize;
        if (j6 > 0 && j6 < readableBytes) {
            throw new IOException("Out of size: " + readableBytes + " > " + this.definedSize);
        }
        ByteBuf byteBuf2 = this.byteBuf;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
        this.byteBuf = byteBuf;
        this.size = readableBytes;
        setCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z5) throws IOException {
        if (byteBuf != null) {
            long readableBytes = byteBuf.readableBytes();
            checkSize(this.size + readableBytes);
            long j6 = this.definedSize;
            if (j6 > 0 && j6 < this.size + readableBytes) {
                throw new IOException("Out of size: " + (this.size + readableBytes) + " > " + this.definedSize);
            }
            this.size += readableBytes;
            ByteBuf byteBuf2 = this.byteBuf;
            if (byteBuf2 == null) {
                this.byteBuf = byteBuf;
            } else if (byteBuf2 instanceof CompositeByteBuf) {
                ((CompositeByteBuf) byteBuf2).addComponent(true, byteBuf);
            } else {
                CompositeByteBuf compositeBuffer = Unpooled.compositeBuffer(Integer.MAX_VALUE);
                compositeBuffer.addComponents(true, this.byteBuf, byteBuf);
                this.byteBuf = compositeBuffer;
            }
        }
        if (z5) {
            setCompleted();
        } else if (byteBuf == null) {
            throw new NullPointerException("buffer");
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.release();
            this.byteBuf = null;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            return Unpooled.EMPTY_BUFFER.array();
        }
        byte[] bArr = new byte[byteBuf.readableBytes()];
        ByteBuf byteBuf2 = this.byteBuf;
        byteBuf2.getBytes(byteBuf2.readerIndex(), bArr);
        return bArr;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() {
        return this.byteBuf;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i6) throws IOException {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null || i6 == 0 || byteBuf.readableBytes() == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        int readableBytes = this.byteBuf.readableBytes();
        int i7 = this.chunkPosition;
        int i8 = readableBytes - i7;
        if (i8 == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        if (i8 < i6) {
            i6 = i8;
        }
        ByteBuf retainedSlice = this.byteBuf.retainedSlice(i7, i6);
        this.chunkPosition += i6;
        return retainedSlice;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        throw new IOException("Not represented by a file");
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            return "";
        }
        if (charset == null) {
            charset = HttpConstants.DEFAULT_CHARSET;
        }
        return byteBuf.toString(charset);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean renameTo(File file) throws IOException {
        int i6;
        if (file == null) {
            throw new NullPointerException("dest");
        }
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            if (file.createNewFile()) {
                return true;
            }
            throw new IOException("file exists already: " + file);
        }
        int readableBytes = byteBuf.readableBytes();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileChannel channel = fileOutputStream.getChannel();
        if (this.byteBuf.nioBufferCount() == 1) {
            ByteBuffer nioBuffer = this.byteBuf.nioBuffer();
            i6 = 0;
            while (i6 < readableBytes) {
                i6 += channel.write(nioBuffer);
            }
        } else {
            ByteBuffer[] nioBuffers = this.byteBuf.nioBuffers();
            i6 = 0;
            while (i6 < readableBytes) {
                i6 = (int) (i6 + channel.write(nioBuffers));
            }
        }
        channel.force(false);
        channel.close();
        fileOutputStream.close();
        return i6 == readableBytes;
    }

    protected AbstractMemoryHttpData(String str, Charset charset, long j6) {
        super(str, charset, j6);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return touch((Object) null);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.touch(obj);
        }
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            ByteBuf buffer = Unpooled.buffer();
            byte[] bArr = new byte[16384];
            int read = inputStream.read(bArr);
            int i6 = 0;
            while (read > 0) {
                buffer.writeBytes(bArr, 0, read);
                i6 += read;
                checkSize(i6);
                read = inputStream.read(bArr);
            }
            long j6 = i6;
            this.size = j6;
            long j7 = this.definedSize;
            if (j7 > 0 && j7 < j6) {
                throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
            }
            ByteBuf byteBuf = this.byteBuf;
            if (byteBuf != null) {
                byteBuf.release();
            }
            this.byteBuf = buffer;
            setCompleted();
            return;
        }
        throw new NullPointerException("inputStream");
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        if (file != null) {
            long length = file.length();
            if (length <= 2147483647L) {
                checkSize(length);
                FileInputStream fileInputStream = new FileInputStream(file);
                FileChannel channel = fileInputStream.getChannel();
                ByteBuffer wrap = ByteBuffer.wrap(new byte[(int) length]);
                for (int i6 = 0; i6 < length; i6 += channel.read(wrap)) {
                }
                channel.close();
                fileInputStream.close();
                wrap.flip();
                ByteBuf byteBuf = this.byteBuf;
                if (byteBuf != null) {
                    byteBuf.release();
                }
                this.byteBuf = Unpooled.wrappedBuffer(Integer.MAX_VALUE, wrap);
                this.size = length;
                setCompleted();
                return;
            }
            throw new IllegalArgumentException("File too big to be loaded in memory");
        }
        throw new NullPointerException(b.f50156c);
    }
}
