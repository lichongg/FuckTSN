package io.netty.buffer;

import io.netty.util.CharsetUtil;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ByteBufOutputStream extends OutputStream implements DataOutput {
    private final ByteBuf buffer;
    private final int startIndex;
    private final DataOutputStream utf8out = new DataOutputStream(this);

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        if (i7 == 0) {
            return;
        }
        this.buffer.writeBytes(bArr, i6, i7);
    }

    public ByteBuf buffer() {
        return this.buffer;
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        this.buffer.writeBytes(bArr);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z5) throws IOException {
        this.buffer.writeBoolean(z5);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i6) throws IOException {
        this.buffer.writeByte(i6);
    }

    @Override // java.io.DataOutput
    public void writeBytes(String str) throws IOException {
        this.buffer.writeCharSequence(str, CharsetUtil.US_ASCII);
    }

    @Override // java.io.DataOutput
    public void writeChar(int i6) throws IOException {
        this.buffer.writeChar(i6);
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d6) throws IOException {
        this.buffer.writeDouble(d6);
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f6) throws IOException {
        this.buffer.writeFloat(f6);
    }

    @Override // java.io.DataOutput
    public void writeInt(int i6) throws IOException {
        this.buffer.writeInt(i6);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j6) throws IOException {
        this.buffer.writeLong(j6);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i6) throws IOException {
        this.buffer.writeShort((short) i6);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        this.utf8out.writeUTF(str);
    }

    public int writtenBytes() {
        return this.buffer.writerIndex() - this.startIndex;
    }

    public ByteBufOutputStream(ByteBuf byteBuf) {
        if (byteBuf != null) {
            this.buffer = byteBuf;
            this.startIndex = byteBuf.writerIndex();
            return;
        }
        throw new NullPointerException("buffer");
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(int i6) throws IOException {
        this.buffer.writeByte(i6);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException {
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            this.buffer.writeChar(str.charAt(i6));
        }
    }
}
