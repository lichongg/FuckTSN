package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class x4 {

    /* renamed from: a, reason: collision with root package name */
    private final w4 f35003a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f35004b;

    int a() {
        return this.f35004b.length - 1;
    }

    boolean b() {
        return this.f35004b[0] == 0;
    }

    x4 c(x4 x4Var) {
        if (this.f35003a.equals(x4Var.f35003a)) {
            return x4Var.b() ? this : a(x4Var.c());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    int a(int i6) {
        if (i6 == 0) {
            return b(0);
        }
        if (i6 == 1) {
            int i7 = 0;
            for (int i8 : this.f35004b) {
                i7 = this.f35003a.a(i7, i8);
            }
            return i7;
        }
        int[] iArr = this.f35004b;
        int i9 = iArr[0];
        int length = iArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            w4 w4Var = this.f35003a;
            i9 = w4Var.a(w4Var.c(i6, i9), this.f35004b[i10]);
        }
        return i9;
    }

    int b(int i6) {
        return this.f35004b[(r0.length - 1) - i6];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int a6 = a(); a6 >= 0; a6--) {
            int b6 = b(a6);
            if (b6 != 0) {
                if (b6 < 0) {
                    sb.append(" - ");
                    b6 = -b6;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (a6 == 0 || b6 != 1) {
                    sb.append(b6);
                }
                if (a6 != 0) {
                    if (a6 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(a6);
                    }
                }
            }
        }
        return sb.toString();
    }

    x4(w4 w4Var, int[] iArr) {
        if (iArr.length != 0) {
            this.f35003a = w4Var;
            int length = iArr.length;
            int i6 = 1;
            if (length > 1 && iArr[0] == 0) {
                while (i6 < length && iArr[i6] == 0) {
                    i6++;
                }
                if (i6 == length) {
                    this.f35004b = new int[]{0};
                    return;
                }
                int i7 = length - i6;
                int[] iArr2 = new int[i7];
                this.f35004b = iArr2;
                System.arraycopy(iArr, i6, iArr2, 0, i7);
                return;
            }
            this.f35004b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    x4 b(x4 x4Var) {
        if (this.f35003a.equals(x4Var.f35003a)) {
            if (!b() && !x4Var.b()) {
                int[] iArr = this.f35004b;
                int length = iArr.length;
                int[] iArr2 = x4Var.f35004b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i6 = 0; i6 < length; i6++) {
                    int i7 = iArr[i6];
                    for (int i8 = 0; i8 < length2; i8++) {
                        int i9 = i6 + i8;
                        w4 w4Var = this.f35003a;
                        iArr3[i9] = w4Var.a(iArr3[i9], w4Var.c(i7, iArr2[i8]));
                    }
                }
                return new x4(this.f35003a, iArr3);
            }
            return this.f35003a.c();
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    x4 c() {
        int length = this.f35004b.length;
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = this.f35003a.d(0, this.f35004b[i6]);
        }
        return new x4(this.f35003a, iArr);
    }

    x4 a(x4 x4Var) {
        if (this.f35003a.equals(x4Var.f35003a)) {
            if (b()) {
                return x4Var;
            }
            if (x4Var.b()) {
                return this;
            }
            int[] iArr = this.f35004b;
            int[] iArr2 = x4Var.f35004b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i6 = length; i6 < iArr.length; i6++) {
                iArr3[i6] = this.f35003a.a(iArr2[i6 - length], iArr[i6]);
            }
            return new x4(this.f35003a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    x4 c(int i6) {
        if (i6 == 0) {
            return this.f35003a.c();
        }
        if (i6 == 1) {
            return this;
        }
        int length = this.f35004b.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = this.f35003a.c(this.f35004b[i7], i6);
        }
        return new x4(this.f35003a, iArr);
    }

    x4 a(int i6, int i7) {
        if (i6 < 0) {
            throw new IllegalArgumentException();
        }
        if (i7 == 0) {
            return this.f35003a.c();
        }
        int length = this.f35004b.length;
        int[] iArr = new int[i6 + length];
        for (int i8 = 0; i8 < length; i8++) {
            iArr[i8] = this.f35003a.c(this.f35004b[i8], i7);
        }
        return new x4(this.f35003a, iArr);
    }
}
