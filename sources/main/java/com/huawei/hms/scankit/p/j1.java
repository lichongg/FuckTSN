package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j1 implements l8 {
    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) {
        l2 l2Var;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        }
        if (i6 < 0 || i7 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i6 + 'x' + i7);
        }
        e7 e7Var = e7.FORCE_SQUARE;
        if (map != null) {
            e7 e7Var2 = (e7) map.get(u2.DATA_MATRIX_SHAPE);
            if (e7Var2 != null) {
                e7Var = e7Var2;
            }
            l2 l2Var2 = (l2) map.get(u2.MIN_SIZE);
            if (l2Var2 == null) {
                l2Var2 = null;
            }
            l2 l2Var3 = (l2) map.get(u2.MAX_SIZE);
            r0 = l2Var3 != null ? l2Var3 : null;
            u2 u2Var = u2.MARGIN;
            r1 = map.containsKey(u2Var) ? Integer.parseInt(map.get(u2Var).toString()) : 4;
            l2Var = r0;
            r0 = l2Var2;
        } else {
            l2Var = null;
        }
        String a6 = d4.a(str, e7Var, r0, l2Var);
        d7 a7 = d7.a(a6.length(), e7Var, r0, l2Var, true);
        y1 y1Var = new y1(z2.a(a6, a7), a7.f(), a7.e());
        y1Var.a();
        return a(y1Var, a7, i6, i7, r1);
    }

    private static s a(y1 y1Var, d7 d7Var, int i6, int i7, int i8) {
        int f6 = d7Var.f();
        int e6 = d7Var.e();
        c0 c0Var = new c0(d7Var.h(), d7Var.g());
        int i9 = 0;
        for (int i10 = 0; i10 < e6; i10++) {
            if (i10 % d7Var.f34155e == 0) {
                int i11 = 0;
                for (int i12 = 0; i12 < d7Var.h(); i12++) {
                    c0Var.a(i11, i9, i12 % 2 == 0);
                    i11++;
                }
                i9++;
            }
            int i13 = 0;
            for (int i14 = 0; i14 < f6; i14++) {
                if (i14 % d7Var.f34154d == 0) {
                    c0Var.a(i13, i9, true);
                    i13++;
                }
                c0Var.a(i13, i9, y1Var.a(i14, i10));
                int i15 = i13 + 1;
                int i16 = d7Var.f34154d;
                if (i14 % i16 == i16 - 1) {
                    c0Var.a(i15, i9, i10 % 2 == 0);
                    i13 += 2;
                } else {
                    i13 = i15;
                }
            }
            int i17 = i9 + 1;
            int i18 = d7Var.f34155e;
            if (i10 % i18 == i18 - 1) {
                int i19 = 0;
                for (int i20 = 0; i20 < d7Var.h(); i20++) {
                    c0Var.a(i19, i17, true);
                    i19++;
                }
                i9 += 2;
            } else {
                i9 = i17;
            }
        }
        return a(c0Var, i6, i7, i8);
    }

    private static s a(c0 c0Var, int i6, int i7, int i8) {
        s sVar;
        int c6 = c0Var.c();
        int b6 = c0Var.b();
        int i9 = i8 * 2;
        int i10 = c6 + i9;
        int i11 = i9 + b6;
        int max = Math.max(i6, i10);
        int max2 = Math.max(i7, i11);
        int min = Math.min(max / i10, max2 / i11);
        int i12 = (max - (c6 * min)) / 2;
        int i13 = (max2 - (b6 * min)) / 2;
        if (i7 >= b6 && i6 >= c6) {
            sVar = new s(i6, i7);
        } else {
            sVar = new s(c6, b6);
            i12 = 0;
            i13 = 0;
        }
        sVar.a();
        int i14 = 0;
        while (i14 < b6) {
            int i15 = i12;
            int i16 = 0;
            while (i16 < c6) {
                if (c0Var.a(i16, i14) == 1) {
                    sVar.a(i15, i13, min, min);
                }
                i16++;
                i15 += min;
            }
            i14++;
            i13 += min;
        }
        return sVar;
    }
}
