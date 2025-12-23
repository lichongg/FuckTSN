package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.DataOutput;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public interface ByteArrayDataOutput extends DataOutput {
    byte[] toByteArray();

    @Override // java.io.DataOutput
    void write(int i6);

    @Override // java.io.DataOutput
    void write(byte[] bArr);

    @Override // java.io.DataOutput
    void write(byte[] bArr, int i6, int i7);

    @Override // java.io.DataOutput
    void writeBoolean(boolean z5);

    @Override // java.io.DataOutput
    void writeByte(int i6);

    @Override // java.io.DataOutput
    @Deprecated
    void writeBytes(String str);

    @Override // java.io.DataOutput
    void writeChar(int i6);

    @Override // java.io.DataOutput
    void writeChars(String str);

    @Override // java.io.DataOutput
    void writeDouble(double d6);

    @Override // java.io.DataOutput
    void writeFloat(float f6);

    @Override // java.io.DataOutput
    void writeInt(int i6);

    @Override // java.io.DataOutput
    void writeLong(long j6);

    @Override // java.io.DataOutput
    void writeShort(int i6);

    @Override // java.io.DataOutput
    void writeUTF(String str);
}
