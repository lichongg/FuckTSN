package io.netty.buffer;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ByteBufInputStream extends InputStream implements DataInput {
    private final ByteBuf buffer;
    private boolean closed;
    private final int endIndex;
    private StringBuilder lineBuf;
    private final boolean releaseOnClose;
    private final int startIndex;

    public ByteBufInputStream(ByteBuf byteBuf) {
        this(byteBuf, byteBuf.readableBytes());
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            if (this.releaseOnClose && !this.closed) {
                this.closed = true;
                this.buffer.release();
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (available() == 0) {
            return -1;
        }
        return this.buffer.readByte() & 255;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        checkAvailable(1);
        return read() != 0;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        checkAvailable(4);
        return this.buffer.readInt();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        checkAvailable(2);
        return this.buffer.readShort();
    }

    public ByteBufInputStream(ByteBuf byteBuf, int i6) {
        this(byteBuf, i6, false);
    }

    private void checkAvailable(int i6) throws IOException {
        if (i6 < 0) {
            throw new IndexOutOfBoundsException("fieldSize cannot be a negative number");
        }
        if (i6 <= available()) {
            return;
        }
        throw new EOFException("fieldSize is too long! Length is " + i6 + ", but maximum is " + available());
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.endIndex - this.buffer.readerIndex();
    }

    @Override // java.io.InputStream
    public void mark(int i6) {
        this.buffer.markReaderIndex();
    }

    public int readBytes() {
        return this.buffer.readerIndex() - this.startIndex;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i6, int i7) throws IOException {
        checkAvailable(i7);
        this.buffer.readBytes(bArr, i6, i7);
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        checkAvailable(8);
        return this.buffer.readLong();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.buffer.resetReaderIndex();
    }

    public ByteBufInputStream(ByteBuf byteBuf, boolean z5) {
        this(byteBuf, byteBuf.readableBytes(), z5);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }
        int min = Math.min(available, i7);
        this.buffer.readBytes(bArr, i6, min);
        return min;
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        if (available() != 0) {
            return this.buffer.readByte();
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        int available = available();
        if (available == 0) {
            return null;
        }
        StringBuilder sb = this.lineBuf;
        if (sb != null) {
            sb.setLength(0);
        }
        while (true) {
            short readUnsignedByte = this.buffer.readUnsignedByte();
            available--;
            if (readUnsignedByte == 10) {
                break;
            }
            if (readUnsignedByte != 13) {
                if (this.lineBuf == null) {
                    this.lineBuf = new StringBuilder();
                }
                this.lineBuf.append((char) readUnsignedByte);
                if (available <= 0) {
                    break;
                }
            } else if (available > 0) {
                ByteBuf byteBuf = this.buffer;
                if (((char) byteBuf.getUnsignedByte(byteBuf.readerIndex())) == '\n') {
                    this.buffer.skipBytes(1);
                }
            }
        }
        StringBuilder sb2 = this.lineBuf;
        if (sb2 != null && sb2.length() > 0) {
            return this.lineBuf.toString();
        }
        return "";
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return readByte() & 255;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return readShort() & j1.f43986d;
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        int skipBytes;
        if (j6 > 2147483647L) {
            skipBytes = skipBytes(Integer.MAX_VALUE);
        } else {
            skipBytes = skipBytes((int) j6);
        }
        return skipBytes;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i6) throws IOException {
        int min = Math.min(available(), i6);
        this.buffer.skipBytes(min);
        return min;
    }

    public ByteBufInputStream(ByteBuf byteBuf, int i6, boolean z5) {
        if (byteBuf == null) {
            throw new NullPointerException("buffer");
        }
        if (i6 < 0) {
            if (z5) {
                byteBuf.release();
            }
            throw new IllegalArgumentException("length: " + i6);
        }
        if (i6 > byteBuf.readableBytes()) {
            if (z5) {
                byteBuf.release();
            }
            throw new IndexOutOfBoundsException("Too many bytes to be read - Needs " + i6 + ", maximum is " + byteBuf.readableBytes());
        }
        this.releaseOnClose = z5;
        this.buffer = byteBuf;
        int readerIndex = byteBuf.readerIndex();
        this.startIndex = readerIndex;
        this.endIndex = readerIndex + i6;
        byteBuf.markReaderIndex();
    }
}
