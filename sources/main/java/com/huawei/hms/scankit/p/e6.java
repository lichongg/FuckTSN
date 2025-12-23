package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e6 extends p4 {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f34222c;

    /* renamed from: d, reason: collision with root package name */
    private final int f34223d;

    /* renamed from: e, reason: collision with root package name */
    private final int f34224e;

    /* renamed from: f, reason: collision with root package name */
    private final int f34225f;

    /* renamed from: g, reason: collision with root package name */
    private final int f34226g;

    @Override // com.huawei.hms.scankit.p.p4
    public byte[] a(int i6, byte[] bArr) {
        if (i6 < 0 || i6 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i6);
        }
        int c6 = c();
        if (bArr == null || bArr.length < c6) {
            bArr = new byte[c6];
        }
        System.arraycopy(this.f34222c, ((i6 + this.f34226g) * this.f34223d) + this.f34225f, bArr, 0, c6);
        return bArr;
    }

    public e6(byte[] bArr, int i6, int i7, int i8, int i9, int i10, int i11, boolean z5) {
        super(i10, i11);
        if (i8 + i10 <= i6 && i9 + i11 <= i7) {
            this.f34222c = bArr;
            this.f34223d = i6;
            this.f34224e = i7;
            this.f34225f = i8;
            this.f34226g = i9;
            if (z5) {
                a(i10, i11);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    @Override // com.huawei.hms.scankit.p.p4
    public byte[] b() {
        int c6 = c();
        int a6 = a();
        int i6 = this.f34223d;
        if (c6 == i6 && a6 == this.f34224e) {
            return this.f34222c;
        }
        int i7 = c6 * a6;
        byte[] bArr = new byte[i7];
        int i8 = (this.f34226g * i6) + this.f34225f;
        if (c6 == i6) {
            try {
                System.arraycopy(this.f34222c, i8, bArr, 0, i7);
                return bArr;
            } catch (ArrayIndexOutOfBoundsException | Exception unused) {
                return null;
            }
        }
        for (int i9 = 0; i9 < a6; i9++) {
            try {
                System.arraycopy(this.f34222c, i8, bArr, i9 * c6, c6);
                i8 += this.f34223d;
            } catch (ArrayIndexOutOfBoundsException | Exception unused2) {
                return null;
            }
        }
        return bArr;
    }

    @Override // com.huawei.hms.scankit.p.p4
    public p4 a(int i6, int i7, int i8, int i9) {
        return new e6(this.f34222c, this.f34223d, this.f34224e, this.f34225f + i6, this.f34226g + i7, i8, i9, false);
    }

    private void a(int i6, int i7) {
        byte[] bArr = this.f34222c;
        int i8 = (this.f34226g * this.f34223d) + this.f34225f;
        int i9 = 0;
        while (i9 < i7) {
            int i10 = (i6 / 2) + i8;
            int i11 = (i8 + i6) - 1;
            int i12 = i8;
            while (i12 < i10) {
                if (w7.a(bArr, i12) && w7.a(bArr, i11)) {
                    byte b6 = bArr[i12];
                    bArr[i12] = bArr[i11];
                    bArr[i11] = b6;
                }
                i12++;
                i11--;
            }
            i9++;
            i8 += this.f34223d;
        }
    }
}
