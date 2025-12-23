package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class p3 {

    /* renamed from: a, reason: collision with root package name */
    private final o3 f34678a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f34679b;

    int[] a() {
        return this.f34679b;
    }

    int b() {
        return this.f34679b.length - 1;
    }

    boolean c() {
        return this.f34679b[0] == 0;
    }

    int a(int i6) {
        if (i6 == 0) {
            return b(0);
        }
        if (i6 == 1) {
            int i7 = 0;
            for (int i8 : this.f34679b) {
                i7 = o3.a(i7, i8);
            }
            return i7;
        }
        int[] iArr = this.f34679b;
        int i9 = iArr[0];
        int length = iArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            i9 = o3.a(this.f34678a.c(i6, i9), this.f34679b[i10]);
        }
        return i9;
    }

    int b(int i6) {
        return this.f34679b[(r0.length - 1) - i6];
    }

    p3 c(p3 p3Var) {
        if (!this.f34678a.equals(p3Var.f34678a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c() || p3Var.c()) {
            return this.f34678a.d();
        }
        int[] iArr = this.f34679b;
        int length = iArr.length;
        int[] iArr2 = p3Var.f34679b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = iArr[i6];
            for (int i8 = 0; i8 < length2; i8++) {
                int i9 = i6 + i8;
                iArr3[i9] = o3.a(iArr3[i9], this.f34678a.c(i7, iArr2[i8]));
            }
        }
        return new p3(this.f34678a, iArr3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int b6 = b(); b6 >= 0; b6--) {
            int b7 = b(b6);
            if (b7 != 0) {
                if (b7 < 0) {
                    sb.append(" - ");
                    b7 = -b7;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b6 == 0 || b7 != 1) {
                    int c6 = this.f34678a.c(b7);
                    if (c6 == 0) {
                        sb.append('1');
                    } else if (c6 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(c6);
                    }
                }
                if (b6 != 0) {
                    if (b6 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b6);
                    }
                }
            }
        }
        return sb.toString();
    }

    p3(o3 o3Var, int[] iArr) {
        if (iArr.length != 0) {
            this.f34678a = o3Var;
            int length = iArr.length;
            int i6 = 1;
            if (length > 1 && iArr[0] == 0) {
                while (i6 < length && iArr[i6] == 0) {
                    i6++;
                }
                if (i6 == length) {
                    this.f34679b = new int[]{0};
                    return;
                }
                int i7 = length - i6;
                int[] iArr2 = new int[i7];
                this.f34679b = iArr2;
                System.arraycopy(iArr, i6, iArr2, 0, i7);
                return;
            }
            this.f34679b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    p3[] b(p3 p3Var) {
        if (this.f34678a.equals(p3Var.f34678a)) {
            if (!p3Var.c()) {
                p3 d6 = this.f34678a.d();
                int b6 = this.f34678a.b(p3Var.b(p3Var.b()));
                p3 p3Var2 = this;
                while (p3Var2.b() >= p3Var.b() && !p3Var2.c()) {
                    int b7 = p3Var2.b() - p3Var.b();
                    int c6 = this.f34678a.c(p3Var2.b(p3Var2.b()), b6);
                    p3 a6 = p3Var.a(b7, c6);
                    d6 = d6.a(this.f34678a.b(b7, c6));
                    p3Var2 = p3Var2.a(a6);
                }
                return new p3[]{d6, p3Var2};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    p3 a(p3 p3Var) {
        if (this.f34678a.equals(p3Var.f34678a)) {
            if (c()) {
                return p3Var;
            }
            if (p3Var.c()) {
                return this;
            }
            int[] iArr = this.f34679b;
            int[] iArr2 = p3Var.f34679b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i6 = length; i6 < iArr.length; i6++) {
                iArr3[i6] = o3.a(iArr2[i6 - length], iArr[i6]);
            }
            return new p3(this.f34678a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    p3 c(int i6) {
        if (i6 == 0) {
            return this.f34678a.d();
        }
        if (i6 == 1) {
            return this;
        }
        int length = this.f34679b.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = this.f34678a.c(this.f34679b[i7], i6);
        }
        return new p3(this.f34678a, iArr);
    }

    p3 a(int i6, int i7) {
        if (i6 < 0) {
            throw new IllegalArgumentException();
        }
        if (i7 == 0) {
            return this.f34678a.d();
        }
        int length = this.f34679b.length;
        int[] iArr = new int[i6 + length];
        for (int i8 = 0; i8 < length; i8++) {
            iArr[i8] = this.f34678a.c(this.f34679b[i8], i7);
        }
        return new p3(this.f34678a, iArr);
    }
}
