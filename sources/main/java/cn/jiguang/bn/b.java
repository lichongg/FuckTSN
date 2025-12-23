package cn.jiguang.bn;

import cn.jiguang.bb.f;
import cn.jiguang.bz.w;
import java.math.BigInteger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final BigInteger f2388d = BigInteger.ONE.shiftLeft(64);

    /* renamed from: a, reason: collision with root package name */
    private byte[] f2389a;

    /* renamed from: b, reason: collision with root package name */
    private int f2390b;

    /* renamed from: c, reason: collision with root package name */
    private int f2391c;

    public b() {
        this(32);
    }

    public int a() {
        return this.f2390b;
    }

    public void b(int i6) {
        a(i6, 16);
        c(2);
        byte[] bArr = this.f2389a;
        int i7 = this.f2390b;
        int i8 = i7 + 1;
        this.f2390b = i8;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        this.f2390b = i7 + 2;
        bArr[i8] = (byte) (i6 & 255);
    }

    public b(int i6) {
        this.f2389a = new byte[i6];
        this.f2390b = 0;
        this.f2391c = -1;
    }

    private void c(int i6) {
        byte[] bArr = this.f2389a;
        int length = bArr.length;
        int i7 = this.f2390b;
        if (length - i7 >= i6) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i7 + i6) {
            length2 = i7 + i6;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i7);
        this.f2389a = bArr2;
    }

    public void a(int i6) {
        a(i6, 8);
        c(1);
        byte[] bArr = this.f2389a;
        int i7 = this.f2390b;
        this.f2390b = i7 + 1;
        bArr[i7] = (byte) (i6 & 255);
    }

    public void b(int i6, int i7) {
        a(i6, 16);
        if (i7 > this.f2390b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f2389a;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        bArr[i7 + 1] = (byte) (i6 & 255);
    }

    public void a(int i6, int i7) {
        a(i6, 8);
        if (i7 > this.f2390b - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.f2389a[i7] = (byte) (i6 & 255);
    }

    public void b(long j6) {
        c(8);
        byte[] bArr = this.f2389a;
        int i6 = this.f2390b;
        int i7 = i6 + 1;
        this.f2390b = i7;
        bArr[i6] = (byte) ((j6 >>> 56) & 255);
        int i8 = i6 + 2;
        this.f2390b = i8;
        bArr[i7] = (byte) ((j6 >>> 48) & 255);
        int i9 = i6 + 3;
        this.f2390b = i9;
        bArr[i8] = (byte) ((j6 >>> 40) & 255);
        int i10 = i6 + 4;
        this.f2390b = i10;
        bArr[i9] = (byte) ((j6 >>> 32) & 255);
        int i11 = i6 + 5;
        this.f2390b = i11;
        bArr[i10] = (byte) ((j6 >>> 24) & 255);
        int i12 = i6 + 6;
        this.f2390b = i12;
        bArr[i11] = (byte) ((j6 >>> 16) & 255);
        int i13 = i6 + 7;
        this.f2390b = i13;
        bArr[i12] = (byte) ((j6 >>> 8) & 255);
        this.f2390b = i6 + 8;
        bArr[i13] = (byte) (j6 & 255);
    }

    public void a(long j6) {
        a(j6, 32);
        c(4);
        byte[] bArr = this.f2389a;
        int i6 = this.f2390b;
        int i7 = i6 + 1;
        this.f2390b = i7;
        bArr[i6] = (byte) ((j6 >>> 24) & 255);
        int i8 = i6 + 2;
        this.f2390b = i8;
        bArr[i7] = (byte) ((j6 >>> 16) & 255);
        int i9 = i6 + 3;
        this.f2390b = i9;
        bArr[i8] = (byte) ((j6 >>> 8) & 255);
        this.f2390b = i6 + 4;
        bArr[i9] = (byte) (j6 & 255);
    }

    public byte[] b() {
        int i6 = this.f2390b;
        byte[] bArr = new byte[i6];
        System.arraycopy(this.f2389a, 0, bArr, 0, i6);
        return bArr;
    }

    private void a(long j6, int i6) {
        long j7 = 1 << i6;
        if (j6 < 0 || j6 > j7) {
            f.i("Outputer", j6 + " out of range for " + i6 + " bit value max:" + j7);
        }
    }

    public void a(String str) {
        byte[] j6 = w.j(str);
        b(j6.length);
        a(j6, 0, j6.length);
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i6, int i7) {
        c(i7);
        System.arraycopy(bArr, i6, this.f2389a, this.f2390b, i7);
        this.f2390b += i7;
    }
}
