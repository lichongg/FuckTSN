package com.bytedance.pangle.res.j;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class g extends FilterInputStream implements DataInput {
    public static int j(byte b6, byte b7, byte b8, byte b9) {
        return (b6 << 24) | ((b7 & 255) << 16) | ((b8 & 255) << 8) | (b9 & 255);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        r.j(this, bArr);
    }

    public static long j(byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, byte b12, byte b13) {
        return ((b7 & 255) << 48) | ((b6 & 255) << 56) | ((b8 & 255) << 40) | ((b9 & 255) << 32) | ((b10 & 255) << 24) | ((b11 & 255) << 16) | ((b12 & 255) << 8) | (b13 & 255);
    }

    private byte xt() throws IOException, EOFException {
        int read = ((FilterInputStream) this).in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i6, int i7) throws IOException {
        r.j(this, bArr, i6, i7);
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i6) throws IOException {
        return (int) ((FilterInputStream) this).in.skip(i6);
    }

    public g(up upVar) {
        super(upVar);
    }

    public up j() {
        return (up) ((FilterInputStream) this).in;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        if (readUnsignedByte() != 0) {
            return true;
        }
        return false;
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
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
    public int readInt() throws IOException {
        byte xt = xt();
        byte xt2 = xt();
        return j(xt(), xt(), xt2, xt);
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        byte xt = xt();
        byte xt2 = xt();
        byte xt3 = xt();
        byte xt4 = xt();
        byte xt5 = xt();
        byte xt6 = xt();
        return j(xt(), xt(), xt6, xt5, xt4, xt3, xt2, xt);
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return j((byte) 0, (byte) 0, xt(), xt());
    }
}
