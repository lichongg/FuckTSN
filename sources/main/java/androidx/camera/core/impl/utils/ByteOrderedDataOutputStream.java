package androidx.camera.core.impl.utils;

import androidx.annotation.RequiresApi;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
class ByteOrderedDataOutputStream extends FilterOutputStream {
    private ByteOrder mByteOrder;
    final OutputStream mOutputStream;

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.mOutputStream.write(bArr);
    }

    public void writeUnsignedInt(long j6) throws IOException {
        writeInt((int) j6);
    }

    public void writeUnsignedShort(int i6) throws IOException {
        writeShort((short) i6);
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        this.mOutputStream.write(bArr, i6, i7);
    }

    public void writeByte(int i6) throws IOException {
        this.mOutputStream.write(i6);
    }

    public void writeInt(int i6) throws IOException {
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write(i6 & 255);
            this.mOutputStream.write((i6 >>> 8) & 255);
            this.mOutputStream.write((i6 >>> 16) & 255);
            this.mOutputStream.write((i6 >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.mOutputStream.write((i6 >>> 24) & 255);
            this.mOutputStream.write((i6 >>> 16) & 255);
            this.mOutputStream.write((i6 >>> 8) & 255);
            this.mOutputStream.write(i6 & 255);
        }
    }

    public void writeShort(short s5) throws IOException {
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write(s5 & 255);
            this.mOutputStream.write((s5 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.mOutputStream.write((s5 >>> 8) & 255);
            this.mOutputStream.write(s5 & 255);
        }
    }

    ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.mOutputStream = outputStream;
        this.mByteOrder = byteOrder;
    }
}
