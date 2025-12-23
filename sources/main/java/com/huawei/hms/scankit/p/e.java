package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final s f34180a;

    /* renamed from: c, reason: collision with root package name */
    private final int f34182c;

    /* renamed from: d, reason: collision with root package name */
    private final int f34183d;

    /* renamed from: e, reason: collision with root package name */
    private final int f34184e;

    /* renamed from: f, reason: collision with root package name */
    private final int f34185f;

    /* renamed from: g, reason: collision with root package name */
    private final float f34186g;

    /* renamed from: i, reason: collision with root package name */
    private final v6 f34188i;

    /* renamed from: b, reason: collision with root package name */
    private final List<d> f34181b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    private final int[] f34187h = new int[3];

    d a() throws a {
        d a6;
        int i6 = this.f34182c;
        int i7 = this.f34185f;
        int i8 = this.f34184e + i6;
        int i9 = this.f34183d + (i7 / 2);
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = ((i10 & 1) == 0 ? (i10 + 1) / 2 : -((i10 + 1) / 2)) + i9;
            int[] iArr = {0, 0, 0};
            int i12 = i6;
            while (i12 < i8 && !this.f34180a.b(i12, i11)) {
                i12++;
            }
            d a7 = a(i11, i12, i8, iArr);
            if (a7 != null) {
                return a7;
            }
            if (a(iArr) && (a6 = a(iArr, i11, i8)) != null) {
                return a6;
            }
        }
        if (this.f34181b.isEmpty()) {
            throw a.a();
        }
        return this.f34181b.get(0);
    }

    e(s sVar, int i6, int i7, int i8, int i9, float f6, v6 v6Var) {
        this.f34180a = sVar;
        this.f34182c = i6;
        this.f34183d = i7;
        this.f34184e = i8;
        this.f34185f = i9;
        this.f34186g = f6;
        this.f34188i = v6Var;
    }

    private d a(int i6, int i7, int i8, int[] iArr) {
        d a6;
        int i9 = 0;
        while (i7 < i8) {
            if (!this.f34180a.b(i7, i6)) {
                if (i9 == 1) {
                    i9++;
                }
                iArr[i9] = iArr[i9] + 1;
            } else if (i9 == 1) {
                iArr[1] = iArr[1] + 1;
            } else if (i9 == 2) {
                if (a(iArr) && (a6 = a(iArr, i6, i7)) != null) {
                    return a6;
                }
                iArr[0] = iArr[2];
                iArr[1] = 1;
                iArr[2] = 0;
                i9 = 1;
            } else {
                i9++;
                iArr[i9] = iArr[i9] + 1;
            }
            i7++;
        }
        return null;
    }

    private static float a(int[] iArr, int i6) {
        return (i6 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private boolean a(int[] iArr) {
        float f6 = this.f34186g;
        float f7 = (3.0f * f6) / 4.0f;
        for (int i6 = 0; i6 < 3; i6++) {
            if (Math.abs(f6 - iArr[i6]) >= f7) {
                return false;
            }
        }
        return true;
    }

    private float a(int i6, int i7, int i8, int i9) {
        int i10;
        s sVar = this.f34180a;
        int c6 = sVar.c();
        int[] iArr = this.f34187h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i11 = i6;
        while (i11 >= 0 && sVar.b(i7, i11)) {
            int i12 = iArr[1];
            if (i12 > i8) {
                break;
            }
            iArr[1] = i12 + 1;
            i11--;
        }
        if (i11 >= 0 && iArr[1] <= i8) {
            while (i11 >= 0 && !sVar.b(i7, i11)) {
                int i13 = iArr[0];
                if (i13 > i8) {
                    break;
                }
                iArr[0] = i13 + 1;
                i11--;
            }
            if (iArr[0] > i8) {
                return Float.NaN;
            }
            int i14 = i6 + 1;
            while (i14 < c6 && sVar.b(i7, i14)) {
                int i15 = iArr[1];
                if (i15 > i8) {
                    break;
                }
                iArr[1] = i15 + 1;
                i14++;
            }
            if (i14 != c6 && iArr[1] <= i8) {
                while (i14 < c6 && !sVar.b(i7, i14)) {
                    int i16 = iArr[2];
                    if (i16 > i8) {
                        break;
                    }
                    iArr[2] = i16 + 1;
                    i14++;
                }
                int i17 = iArr[2];
                if (i17 <= i8 && (i10 = iArr[0] + iArr[1] + i17) < i9 * 3 && i10 * 3 > i9 && a(iArr)) {
                    return a(iArr, i14);
                }
            }
        }
        return Float.NaN;
    }

    private d a(int[] iArr, int i6, int i7) {
        int i8 = iArr[0] + iArr[1] + iArr[2];
        float a6 = a(iArr, i7);
        float a7 = a(i6, (int) a6, iArr[1] * 3, i8);
        if (Float.isNaN(a7)) {
            return null;
        }
        float f6 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (d dVar : this.f34181b) {
            if (dVar.b(f6, a7, a6)) {
                return dVar.c(a7, a6, f6);
            }
        }
        d dVar2 = new d(a6, a7, f6);
        this.f34181b.add(dVar2);
        v6 v6Var = this.f34188i;
        if (v6Var == null) {
            return null;
        }
        v6Var.a(dVar2);
        return null;
    }
}
