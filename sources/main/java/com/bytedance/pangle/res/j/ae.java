package com.bytedance.pangle.res.j;

import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends m {
    public int[] j(int i6) throws IOException {
        int[] iArr = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            iArr[i7] = readInt();
        }
        return iArr;
    }

    @Override // com.bytedance.pangle.res.j.m, java.io.DataInput
    public final int skipBytes(int i6) throws IOException {
        int i7 = 0;
        while (i7 < i6) {
            int skipBytes = super.skipBytes(i6 - i7);
            if (skipBytes <= 0) {
                break;
            }
            i7 += skipBytes;
        }
        return i7;
    }

    public ae(g gVar) {
        super(gVar);
    }

    public void j() throws IOException {
        skipBytes(4);
    }

    public void xt(int i6, int i7) throws IOException {
        int readInt = readInt();
        if (readInt != i7 && readInt >= i6) {
            if (readInt == i6) {
            } else {
                throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Integer.valueOf(i6), Integer.valueOf(readInt)));
            }
        } else {
            xt(i6, -1);
        }
    }

    public void j(int i6, int i7) throws IOException {
        int readInt = readInt();
        if (readInt != i6 && readInt != i7) {
            throw new IOException(String.format("Expected: 0x%08x or 0x%08x, got: 0x%08x", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(readInt)));
        }
    }

    public void j(short s5) throws IOException {
        short readShort = readShort();
        if (readShort != s5) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Short.valueOf(s5), Short.valueOf(readShort)));
        }
    }

    public void j(byte b6) throws IOException {
        byte readByte = readByte();
        if (readByte != b6) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Byte.valueOf(b6), Byte.valueOf(readByte)));
        }
    }
}
