package com.bytedance.pangle.res.j;

import java.io.DataInput;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class m implements DataInput {

    /* renamed from: j, reason: collision with root package name */
    public final g f25483j;

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i6, int i7) throws IOException {
        this.f25483j.readFully(bArr, i6, i7);
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.f25483j.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.f25483j.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.f25483j.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.f25483j.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.f25483j.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.f25483j.readFully(bArr);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.f25483j.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        return this.f25483j.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.f25483j.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.f25483j.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.f25483j.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.f25483j.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.f25483j.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i6) throws IOException {
        return this.f25483j.skipBytes(i6);
    }

    public m(g gVar) {
        this.f25483j = gVar;
    }
}
