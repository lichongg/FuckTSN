package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i implements l8 {
    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) {
        String str2;
        BarcodeFormat barcodeFormat2;
        int i8;
        int i9;
        Charset charset;
        int i10;
        int i11;
        int i12;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (map != null) {
            u2 u2Var = u2.CHARACTER_SET;
            if (map.containsKey(u2Var)) {
                charset2 = Charset.forName(map.get(u2Var).toString());
            }
            u2 u2Var2 = u2.ERROR_CORRECTION;
            int parseInt = map.containsKey(u2Var2) ? Integer.parseInt(map.get(u2Var2).toString()) : 33;
            u2 u2Var3 = u2.AZTEC_LAYERS;
            int parseInt2 = map.containsKey(u2Var3) ? Integer.parseInt(map.get(u2Var3).toString()) : 0;
            u2 u2Var4 = u2.MARGIN;
            if (map.containsKey(u2Var4)) {
                int parseInt3 = Integer.parseInt(map.get(u2Var4).toString());
                str2 = str;
                barcodeFormat2 = barcodeFormat;
                i8 = i6;
                i9 = i7;
                charset = charset2;
                i10 = parseInt;
                i11 = parseInt2;
                i12 = parseInt3;
                return a(str2, barcodeFormat2, i8, i9, charset, i10, i11, i12);
            }
            str2 = str;
            barcodeFormat2 = barcodeFormat;
            i8 = i6;
            i9 = i7;
            charset = charset2;
            i10 = parseInt;
            i11 = parseInt2;
        } else {
            str2 = str;
            barcodeFormat2 = barcodeFormat;
            i8 = i6;
            i9 = i7;
            charset = charset2;
            i10 = 33;
            i11 = 0;
        }
        i12 = 4;
        return a(str2, barcodeFormat2, i8, i9, charset, i10, i11, i12);
    }

    private static s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Charset charset, int i8, int i9, int i10) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return a(x2.a(str.getBytes(charset), i8, i9), i6, i7, i10);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    private static s a(f fVar, int i6, int i7, int i8) {
        s a6 = fVar.a();
        if (a6 != null) {
            int e6 = a6.e();
            int c6 = a6.c();
            int i9 = i8 * 2;
            int i10 = e6 + i9;
            int i11 = i9 + c6;
            int max = Math.max(i6, i10);
            int max2 = Math.max(i7, i11);
            int min = Math.min(max / i10, max2 / i11);
            int i12 = (max - (e6 * min)) / 2;
            int i13 = (max2 - (c6 * min)) / 2;
            s sVar = new s(max, max2);
            int i14 = 0;
            while (i14 < c6) {
                int i15 = i12;
                int i16 = 0;
                while (i16 < e6) {
                    if (a6.b(i16, i14)) {
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
        throw new IllegalStateException();
    }
}
