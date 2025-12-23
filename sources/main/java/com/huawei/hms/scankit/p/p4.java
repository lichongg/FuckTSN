package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class p4 {

    /* renamed from: a, reason: collision with root package name */
    private final int f34680a;

    /* renamed from: b, reason: collision with root package name */
    private final int f34681b;

    public final int a() {
        return this.f34681b;
    }

    public abstract p4 a(int i6, int i7, int i8, int i9);

    public abstract byte[] a(int i6, byte[] bArr);

    public abstract byte[] b();

    public final int c() {
        return this.f34680a;
    }

    public final String toString() {
        int i6 = this.f34680a;
        byte[] bArr = new byte[i6];
        StringBuilder sb = new StringBuilder(this.f34681b * (i6 + 1));
        for (int i7 = 0; i7 < this.f34681b; i7++) {
            bArr = a(i7, bArr);
            for (int i8 = 0; i8 < this.f34680a; i8++) {
                int i9 = bArr[i8] & 255;
                sb.append(i9 < 64 ? '#' : i9 < 128 ? '+' : i9 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    protected p4(int i6, int i7) {
        this.f34680a = i6;
        this.f34681b = i7;
    }
}
