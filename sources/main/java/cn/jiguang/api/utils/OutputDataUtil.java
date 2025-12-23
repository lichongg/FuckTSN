package cn.jiguang.api.utils;

import cn.jiguang.bx.d;
import java.math.BigInteger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class OutputDataUtil {
    private static final String TAG = "OutputDataUtil";
    private static final BigInteger TWO_64 = BigInteger.ONE.shiftLeft(64);
    private byte[] array;
    private int pos;
    private int saved_pos;

    public OutputDataUtil() {
        this(32);
    }

    public static long encodeZigZag64(long j6) {
        return (j6 >> 63) ^ (j6 << 1);
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeByteArrayincludeLength(byte[] bArr) {
        writeU16(bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeCountedString(byte[] bArr) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("Invalid counted string");
        }
        need(bArr.length + 1);
        byte[] bArr2 = this.array;
        int i6 = this.pos;
        this.pos = i6 + 1;
        bArr2[i6] = (byte) (255 & bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeU16(int i6) {
        check(i6, 16);
        need(2);
        byte[] bArr = this.array;
        int i7 = this.pos;
        int i8 = i7 + 1;
        this.pos = i8;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        this.pos = i7 + 2;
        bArr[i8] = (byte) (i6 & 255);
    }

    public void writeU16At(int i6, int i7) {
        check(i6, 16);
        if (i7 > this.pos - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.array;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        bArr[i7 + 1] = (byte) (i6 & 255);
    }

    public void writeU8(int i6) {
        check(i6, 8);
        need(1);
        byte[] bArr = this.array;
        int i7 = this.pos;
        this.pos = i7 + 1;
        bArr[i7] = (byte) (i6 & 255);
    }

    public void writeU8At(int i6, int i7) {
        check(i6, 8);
        if (i7 > this.pos - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.array[i7] = (byte) (i6 & 255);
    }

    public OutputDataUtil(int i6) {
        this.array = new byte[i6];
        this.pos = 0;
        this.saved_pos = -1;
    }

    private void check(long j6, int i6) {
        long j7 = 1 << i6;
        if (j6 < 0 || j6 > j7) {
            d.c(TAG, j6 + " out of range for " + i6 + " bit value max:" + j7);
        }
    }

    public static int encodeZigZag32(int i6) {
        return (i6 >> 31) ^ (i6 << 1);
    }

    private void need(int i6) {
        byte[] bArr = this.array;
        int length = bArr.length;
        int i7 = this.pos;
        if (length - i7 >= i6) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i7 + i6) {
            length2 = i7 + i6;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i7);
        this.array = bArr2;
    }

    public int current() {
        return this.pos;
    }

    public void jump(int i6) {
        if (i6 > this.pos) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.pos = i6;
    }

    public void restore() {
        int i6 = this.saved_pos;
        if (i6 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.pos = i6;
        this.saved_pos = -1;
    }

    public void save() {
        this.saved_pos = this.pos;
    }

    public byte[] toByteArray() {
        int i6 = this.pos;
        byte[] bArr = new byte[i6];
        System.arraycopy(this.array, 0, bArr, 0, i6);
        return bArr;
    }

    public void writeByteArray(byte[] bArr, int i6, int i7) {
        need(i7);
        System.arraycopy(bArr, i6, this.array, this.pos, i7);
        this.pos += i7;
    }

    public void writeRawLittleEndian16(int i6) {
        byte[] bArr = this.array;
        int i7 = this.pos;
        int i8 = i7 + 1;
        this.pos = i8;
        bArr[i7] = (byte) (i6 & 255);
        this.pos = i7 + 2;
        bArr[i8] = (byte) ((i6 >> 8) & 255);
    }

    public void writeRawLittleEndian32(int i6) {
        byte[] bArr = this.array;
        int i7 = this.pos;
        int i8 = i7 + 1;
        this.pos = i8;
        bArr[i7] = (byte) (i6 & 255);
        int i9 = i7 + 2;
        this.pos = i9;
        bArr[i8] = (byte) ((i6 >> 8) & 255);
        int i10 = i7 + 3;
        this.pos = i10;
        bArr[i9] = (byte) ((i6 >> 16) & 255);
        this.pos = i7 + 4;
        bArr[i10] = (byte) ((i6 >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j6) {
        byte[] bArr = this.array;
        int i6 = this.pos;
        int i7 = i6 + 1;
        this.pos = i7;
        bArr[i6] = (byte) (((int) j6) & 255);
        int i8 = i6 + 2;
        this.pos = i8;
        bArr[i7] = (byte) (((int) (j6 >> 8)) & 255);
        int i9 = i6 + 3;
        this.pos = i9;
        bArr[i8] = (byte) (((int) (j6 >> 16)) & 255);
        int i10 = i6 + 4;
        this.pos = i10;
        bArr[i9] = (byte) (((int) (j6 >> 24)) & 255);
        int i11 = i6 + 5;
        this.pos = i11;
        bArr[i10] = (byte) (((int) (j6 >> 32)) & 255);
        int i12 = i6 + 6;
        this.pos = i12;
        bArr[i11] = (byte) (((int) (j6 >> 40)) & 255);
        int i13 = i6 + 7;
        this.pos = i13;
        bArr[i12] = (byte) (((int) (j6 >> 48)) & 255);
        this.pos = i6 + 8;
        bArr[i13] = (byte) (((int) (j6 >> 56)) & 255);
    }

    public void writeU32(long j6) {
        check(j6, 32);
        need(4);
        byte[] bArr = this.array;
        int i6 = this.pos;
        int i7 = i6 + 1;
        this.pos = i7;
        bArr[i6] = (byte) ((j6 >>> 24) & 255);
        int i8 = i6 + 2;
        this.pos = i8;
        bArr[i7] = (byte) ((j6 >>> 16) & 255);
        int i9 = i6 + 3;
        this.pos = i9;
        bArr[i8] = (byte) ((j6 >>> 8) & 255);
        this.pos = i6 + 4;
        bArr[i9] = (byte) (j6 & 255);
    }

    public void writeU32At(long j6, int i6) {
        check(j6, 32);
        if (i6 > this.pos - 4) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.array;
        bArr[i6] = (byte) ((j6 >>> 24) & 255);
        bArr[i6 + 1] = (byte) ((j6 >>> 16) & 255);
        bArr[i6 + 2] = (byte) ((j6 >>> 8) & 255);
        bArr[i6 + 3] = (byte) (j6 & 255);
    }

    public void writeU64(long j6) {
        need(8);
        byte[] bArr = this.array;
        int i6 = this.pos;
        int i7 = i6 + 1;
        this.pos = i7;
        bArr[i6] = (byte) ((j6 >>> 56) & 255);
        int i8 = i6 + 2;
        this.pos = i8;
        bArr[i7] = (byte) ((j6 >>> 48) & 255);
        int i9 = i6 + 3;
        this.pos = i9;
        bArr[i8] = (byte) ((j6 >>> 40) & 255);
        int i10 = i6 + 4;
        this.pos = i10;
        bArr[i9] = (byte) ((j6 >>> 32) & 255);
        int i11 = i6 + 5;
        this.pos = i11;
        bArr[i10] = (byte) ((j6 >>> 24) & 255);
        int i12 = i6 + 6;
        this.pos = i12;
        bArr[i11] = (byte) ((j6 >>> 16) & 255);
        int i13 = i6 + 7;
        this.pos = i13;
        bArr[i12] = (byte) ((j6 >>> 8) & 255);
        this.pos = i6 + 8;
        bArr[i13] = (byte) (j6 & 255);
    }

    public void writeU64At(long j6, int i6) {
        byte[] bArr = this.array;
        bArr[i6] = (byte) ((j6 >>> 56) & 255);
        bArr[i6 + 1] = (byte) ((j6 >>> 48) & 255);
        bArr[i6 + 2] = (byte) ((j6 >>> 40) & 255);
        bArr[i6 + 3] = (byte) ((j6 >>> 32) & 255);
        bArr[i6 + 4] = (byte) ((j6 >>> 24) & 255);
        bArr[i6 + 5] = (byte) ((j6 >>> 16) & 255);
        bArr[i6 + 6] = (byte) ((j6 >>> 8) & 255);
        bArr[i6 + 7] = (byte) (j6 & 255);
    }
}
