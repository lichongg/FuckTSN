package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f34918a;

    /* renamed from: b, reason: collision with root package name */
    private int f34919b;

    /* renamed from: c, reason: collision with root package name */
    private int f34920c;

    public int a(int i6) {
        if (i6 < 1 || i6 > 32 || i6 > a()) {
            throw new IllegalArgumentException(String.valueOf(i6));
        }
        int i7 = this.f34920c;
        int i8 = 0;
        if (i7 > 0) {
            int i9 = 8 - i7;
            int i10 = i6 < i9 ? i6 : i9;
            int i11 = i9 - i10;
            int i12 = w7.a(this.f34918a, this.f34919b) ? (((255 >> (8 - i10)) << i11) & this.f34918a[this.f34919b]) >> i11 : 0;
            i6 -= i10;
            int i13 = this.f34920c + i10;
            this.f34920c = i13;
            if (i13 == 8) {
                this.f34920c = 0;
                this.f34919b++;
            }
            i8 = i12;
        }
        if (i6 > 0) {
            while (i6 >= 8) {
                if (w7.a(this.f34918a, this.f34919b)) {
                    i8 = (i8 << 8) | (this.f34918a[this.f34919b] & 255);
                }
                this.f34919b++;
                i6 -= 8;
            }
            if (i6 > 0) {
                int i14 = 8 - i6;
                int i15 = (255 >> i14) << i14;
                if (w7.a(this.f34918a, this.f34919b)) {
                    i8 = (i8 << i6) | ((i15 & this.f34918a[this.f34919b]) >> i14);
                }
                this.f34920c += i6;
            }
        }
        return i8;
    }

    public int b() {
        return this.f34920c;
    }

    public int c() {
        return this.f34919b;
    }

    public w(byte[] bArr) {
        this.f34918a = bArr;
    }

    public int a() {
        return ((this.f34918a.length - this.f34919b) * 8) - this.f34920c;
    }
}
