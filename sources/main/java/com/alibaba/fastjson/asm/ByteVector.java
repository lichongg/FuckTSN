package com.alibaba.fastjson.asm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ByteVector {
    byte[] data;
    int length;

    public ByteVector() {
        this.data = new byte[64];
    }

    private void enlarge(int i6) {
        byte[] bArr = this.data;
        int length = bArr.length * 2;
        int i7 = this.length;
        int i8 = i6 + i7;
        if (length <= i8) {
            length = i8;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i7);
        this.data = bArr2;
    }

    ByteVector put11(int i6, int i7) {
        int i8 = this.length;
        if (i8 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] bArr = this.data;
        bArr[i8] = (byte) i6;
        bArr[i8 + 1] = (byte) i7;
        this.length = i8 + 2;
        return this;
    }

    ByteVector put12(int i6, int i7) {
        int i8 = this.length;
        if (i8 + 3 > this.data.length) {
            enlarge(3);
        }
        byte[] bArr = this.data;
        bArr[i8] = (byte) i6;
        bArr[i8 + 1] = (byte) (i7 >>> 8);
        bArr[i8 + 2] = (byte) i7;
        this.length = i8 + 3;
        return this;
    }

    public ByteVector putByte(int i6) {
        int i7 = this.length;
        int i8 = i7 + 1;
        if (i8 > this.data.length) {
            enlarge(1);
        }
        this.data[i7] = (byte) i6;
        this.length = i8;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i6, int i7) {
        if (this.length + i7 > this.data.length) {
            enlarge(i7);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i6, this.data, this.length, i7);
        }
        this.length += i7;
        return this;
    }

    public ByteVector putInt(int i6) {
        int i7 = this.length;
        if (i7 + 4 > this.data.length) {
            enlarge(4);
        }
        byte[] bArr = this.data;
        bArr[i7] = (byte) (i6 >>> 24);
        bArr[i7 + 1] = (byte) (i6 >>> 16);
        bArr[i7 + 2] = (byte) (i6 >>> 8);
        bArr[i7 + 3] = (byte) i6;
        this.length = i7 + 4;
        return this;
    }

    public ByteVector putShort(int i6) {
        int i7 = this.length;
        if (i7 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] bArr = this.data;
        bArr[i7] = (byte) (i6 >>> 8);
        bArr[i7 + 1] = (byte) i6;
        this.length = i7 + 2;
        return this;
    }

    public ByteVector(int i6) {
        this.data = new byte[i6];
    }

    public ByteVector putUTF8(String str) {
        int length = str.length();
        int i6 = this.length;
        if (i6 + 2 + length > this.data.length) {
            enlarge(length + 2);
        }
        byte[] bArr = this.data;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (length >>> 8);
        int i8 = i6 + 2;
        bArr[i7] = (byte) length;
        int i9 = 0;
        while (i9 < length) {
            char charAt = str.charAt(i9);
            if (charAt >= 1 && charAt <= 127) {
                bArr[i8] = (byte) charAt;
                i9++;
                i8++;
            } else {
                throw new UnsupportedOperationException();
            }
        }
        this.length = i8;
        return this;
    }
}
