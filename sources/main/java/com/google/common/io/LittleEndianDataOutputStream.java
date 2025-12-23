package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException {
        for (int i6 = 0; i6 < str.length(); i6++) {
            writeChar(str.charAt(i6));
        }
    }

    public LittleEndianDataOutputStream(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream) Preconditions.checkNotNull(outputStream)));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i6, i7);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z5) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBoolean(z5);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i6) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeByte(i6);
    }

    @Override // java.io.DataOutput
    @Deprecated
    public void writeBytes(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBytes(str);
    }

    @Override // java.io.DataOutput
    public void writeInt(int i6) throws IOException {
        ((FilterOutputStream) this).out.write(i6 & 255);
        ((FilterOutputStream) this).out.write((i6 >> 8) & 255);
        ((FilterOutputStream) this).out.write((i6 >> 16) & 255);
        ((FilterOutputStream) this).out.write((i6 >> 24) & 255);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i6) throws IOException {
        ((FilterOutputStream) this).out.write(i6 & 255);
        ((FilterOutputStream) this).out.write((i6 >> 8) & 255);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeUTF(str);
    }

    @Override // java.io.DataOutput
    public void writeChar(int i6) throws IOException {
        writeShort(i6);
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d6) throws IOException {
        writeLong(Double.doubleToLongBits(d6));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f6) throws IOException {
        writeInt(Float.floatToIntBits(f6));
    }

    @Override // java.io.DataOutput
    public void writeLong(long j6) throws IOException {
        byte[] byteArray = Longs.toByteArray(Long.reverseBytes(j6));
        write(byteArray, 0, byteArray.length);
    }
}
