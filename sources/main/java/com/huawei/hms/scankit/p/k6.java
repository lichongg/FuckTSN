package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k6 implements l8 {
    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i6 < 0 || i7 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i6 + 'x' + i7);
        }
        b3 b3Var = b3.L;
        Boolean bool = Boolean.FALSE;
        if (map != null) {
            u2 u2Var = u2.ERROR_CORRECTION;
            if (map.containsKey(u2Var)) {
                b3Var = b3.valueOf(map.get(u2Var).toString());
            }
            u2 u2Var2 = u2.MARGIN;
            r1 = map.containsKey(u2Var2) ? Integer.parseInt(map.get(u2Var2).toString()) : 4;
            u2 u2Var3 = u2.LOGO;
            if (map.containsKey(u2Var3)) {
                bool = (Boolean) map.get(u2Var3);
            }
        }
        return a(w2.a(str, b3Var, map), i6, i7, r1, bool.booleanValue());
    }

    private static s a(h6 h6Var, int i6, int i7, int i8, boolean z5) {
        int max;
        int max2;
        int min;
        c0 a6 = h6Var.a();
        if (a6 != null) {
            int c6 = a6.c();
            int b6 = a6.b();
            if (z5) {
                max = Math.max(i6, c6);
                max2 = Math.max(i7, b6);
                int i9 = i8 * 2;
                min = Math.min((max - i9) / c6, (max2 - i9) / b6);
            } else {
                int i10 = i8 * 2;
                int i11 = c6 + i10;
                int i12 = i10 + b6;
                max = Math.max(i6, i11);
                max2 = Math.max(i7, i12);
                min = Math.min(max / i11, max2 / i12);
            }
            int i13 = (max - (c6 * min)) / 2;
            int i14 = (max2 - (b6 * min)) / 2;
            s sVar = new s(max, max2);
            int i15 = 0;
            while (i15 < b6) {
                int i16 = i13;
                int i17 = 0;
                while (i17 < c6) {
                    if (a6.a(i17, i15) == 1) {
                        sVar.a(i16, i14, min, min);
                    }
                    i17++;
                    i16 += min;
                }
                i15++;
                i14 += min;
            }
            return sVar;
        }
        throw new IllegalStateException();
    }
}
