package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final o f34666a;

    /* renamed from: b, reason: collision with root package name */
    private s f34667b;

    public r a(int i6, int i7) throws a {
        int i8;
        int e6 = e();
        if (e6 < 45) {
            throw a.a();
        }
        r rVar = new r(e6);
        byte[] bArr = new byte[e6];
        a().c().a(i6, bArr);
        int[] iArr = new int[e6];
        int[] iArr2 = new int[e6];
        int i9 = bArr[0] & 255;
        iArr[0] = i9;
        iArr2[0] = i9 * i9;
        for (int i10 = 1; i10 < e6; i10++) {
            iArr[i10] = iArr[i10 - 1] + (bArr[i10] & 255);
        }
        if (i7 != 0) {
            return a(45, e6, iArr, iArr2, bArr, 22);
        }
        int i11 = 23;
        while (true) {
            i8 = e6 - 22;
            if (i11 >= i8) {
                break;
            }
            if ((bArr[i11] & 255) + 5 < (iArr[i11 + 22] - iArr[i11 - 23]) / 45) {
                rVar.g(i11);
            }
            i11++;
        }
        if (rVar.b(23)) {
            rVar.c(0, 23);
        }
        if (rVar.b(e6 - 23)) {
            rVar.c(i8, e6);
        }
        return rVar;
    }

    public s b() throws a {
        if (this.f34667b == null) {
            this.f34667b = this.f34666a.a();
        }
        return this.f34667b;
    }

    public int c() {
        return this.f34666a.b();
    }

    public byte[] d() {
        return this.f34666a.c().b();
    }

    public int e() {
        return this.f34666a.d();
    }

    public p(o oVar) {
        if (oVar != null) {
            this.f34666a = oVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    private r a(int i6, int i7, int[] iArr, int[] iArr2, byte[] bArr, int i8) {
        int i9;
        r rVar = new r(i7);
        for (int i10 = 1; i10 < i7; i10++) {
            int i11 = iArr2[i10 - 1];
            byte b6 = bArr[i10];
            iArr2[i10] = i11 + ((b6 & 255) * (b6 & 255));
        }
        int i12 = i8 + 1;
        int i13 = i12;
        while (true) {
            i9 = i7 - i8;
            if (i13 >= i9) {
                break;
            }
            double d6 = iArr[i13 + i8] - iArr[(i13 - i8) - 1];
            double d7 = i6;
            if ((bArr[i13] & 255) <= (d6 / d7) * ((0.5f * (Math.sqrt(((iArr2[r6] - iArr2[r8]) - ((d6 * d6) / d7)) / (i6 - 1)) / 127)) + 1.0d)) {
                rVar.g(i13);
            }
            i13++;
        }
        if (rVar.b(i12)) {
            rVar.c(0, i12);
        }
        if (rVar.b(i9 - 1)) {
            rVar.c(i9, i7);
        }
        return rVar;
    }

    public r a(int i6, r rVar) throws a {
        return this.f34666a.a(i6, rVar);
    }

    public void a(s sVar) {
        this.f34667b = sVar;
    }

    public p a(int i6, int i7, int i8, int i9) {
        return new p(this.f34666a.a(this.f34666a.c().a(i6, i7, i8, i9)));
    }

    public o a() {
        return this.f34666a;
    }
}
