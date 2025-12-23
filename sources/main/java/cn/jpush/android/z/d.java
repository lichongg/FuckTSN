package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import java.math.BigInteger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static final BigInteger f4020d = BigInteger.ONE.shiftLeft(64);

    /* renamed from: a, reason: collision with root package name */
    private byte[] f4021a;

    /* renamed from: b, reason: collision with root package name */
    private int f4022b;

    /* renamed from: c, reason: collision with root package name */
    private int f4023c;

    public d() {
        this(32);
    }

    public void a(int i6) {
        a(i6, 8);
        c(1);
        byte[] bArr = this.f4021a;
        int i7 = this.f4022b;
        this.f4022b = i7 + 1;
        bArr[i7] = (byte) (i6 & 255);
    }

    public void b(int i6) {
        a(i6, 16);
        c(2);
        byte[] bArr = this.f4021a;
        int i7 = this.f4022b;
        int i8 = i7 + 1;
        this.f4022b = i8;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        this.f4022b = i7 + 2;
        bArr[i8] = (byte) (i6 & 255);
    }

    public d(int i6) {
        this.f4021a = new byte[i6];
        this.f4022b = 0;
        this.f4023c = -1;
    }

    private void c(int i6) {
        byte[] bArr = this.f4021a;
        int length = bArr.length;
        int i7 = this.f4022b;
        if (length - i7 >= i6) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i7 + i6) {
            length2 = i7 + i6;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i7);
        this.f4021a = bArr2;
    }

    public void a(long j6) {
        c(8);
        byte[] bArr = this.f4021a;
        int i6 = this.f4022b;
        int i7 = i6 + 1;
        this.f4022b = i7;
        bArr[i6] = (byte) ((j6 >>> 56) & 255);
        int i8 = i6 + 2;
        this.f4022b = i8;
        bArr[i7] = (byte) ((j6 >>> 48) & 255);
        int i9 = i6 + 3;
        this.f4022b = i9;
        bArr[i8] = (byte) ((j6 >>> 40) & 255);
        int i10 = i6 + 4;
        this.f4022b = i10;
        bArr[i9] = (byte) ((j6 >>> 32) & 255);
        int i11 = i6 + 5;
        this.f4022b = i11;
        bArr[i10] = (byte) ((j6 >>> 24) & 255);
        int i12 = i6 + 6;
        this.f4022b = i12;
        bArr[i11] = (byte) ((j6 >>> 16) & 255);
        int i13 = i6 + 7;
        this.f4022b = i13;
        bArr[i12] = (byte) ((j6 >>> 8) & 255);
        this.f4022b = i6 + 8;
        bArr[i13] = (byte) (j6 & 255);
    }

    private void a(long j6, int i6) {
        long j7 = 1 << i6;
        if (j6 < 0 || j6 > j7) {
            Logger.w("OutputDataUtil", j6 + " out of range for " + i6 + " bit value max:" + j7);
        }
    }

    public void a(String str) {
        byte[] b6 = b.b(str);
        b(b6.length);
        a(b6, 0, b6.length);
    }

    public void a(byte[] bArr) {
        b(bArr.length);
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i6, int i7) {
        c(i7);
        System.arraycopy(bArr, i6, this.f4021a, this.f4022b, i7);
        this.f4022b += i7;
    }

    public byte[] a() {
        int i6 = this.f4022b;
        byte[] bArr = new byte[i6];
        System.arraycopy(this.f4021a, 0, bArr, 0, i6);
        return bArr;
    }
}
