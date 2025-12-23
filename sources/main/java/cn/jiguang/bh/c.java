package cn.jiguang.bh;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f2162a;

    /* renamed from: b, reason: collision with root package name */
    private int f2163b;

    /* renamed from: c, reason: collision with root package name */
    private int f2164c;

    public c() {
        this(32);
    }

    public int a() {
        return this.f2163b;
    }

    public void b(int i6) {
        a(i6, 8);
        d(1);
        byte[] bArr = this.f2162a;
        int i7 = this.f2163b;
        this.f2163b = i7 + 1;
        bArr[i7] = (byte) (i6 & 255);
    }

    public void c(int i6) {
        a(i6, 16);
        d(2);
        byte[] bArr = this.f2162a;
        int i7 = this.f2163b;
        int i8 = i7 + 1;
        this.f2163b = i8;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        this.f2163b = i7 + 2;
        bArr[i8] = (byte) (i6 & 255);
    }

    public c(int i6) {
        this.f2162a = new byte[i6];
        this.f2163b = 0;
        this.f2164c = -1;
    }

    private void d(int i6) {
        byte[] bArr = this.f2162a;
        int length = bArr.length;
        int i7 = this.f2163b;
        if (length - i7 >= i6) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i7 + i6) {
            length2 = i7 + i6;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i7);
        this.f2162a = bArr2;
    }

    public void a(int i6) {
        if (i6 > this.f2163b) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.f2163b = i6;
    }

    public byte[] b() {
        int i6 = this.f2163b;
        byte[] bArr = new byte[i6];
        System.arraycopy(this.f2162a, 0, bArr, 0, i6);
        return bArr;
    }

    public void a(int i6, int i7) {
        a(i6, 16);
        if (i7 > this.f2163b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f2162a;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        bArr[i7 + 1] = (byte) (i6 & 255);
    }

    public void a(long j6) {
        a(j6, 32);
        d(4);
        byte[] bArr = this.f2162a;
        int i6 = this.f2163b;
        int i7 = i6 + 1;
        this.f2163b = i7;
        bArr[i6] = (byte) ((j6 >>> 24) & 255);
        int i8 = i6 + 2;
        this.f2163b = i8;
        bArr[i7] = (byte) ((j6 >>> 16) & 255);
        int i9 = i6 + 3;
        this.f2163b = i9;
        bArr[i8] = (byte) ((j6 >>> 8) & 255);
        this.f2163b = i6 + 4;
        bArr[i9] = (byte) (j6 & 255);
    }

    private void a(long j6, int i6) {
        long j7 = 1 << i6;
        if (j6 < 0 || j6 > j7) {
            throw new IllegalArgumentException(j6 + " out of range for " + i6 + " bit value");
        }
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i6, int i7) {
        d(i7);
        System.arraycopy(bArr, i6, this.f2162a, this.f2163b, i7);
        this.f2163b += i7;
    }
}
