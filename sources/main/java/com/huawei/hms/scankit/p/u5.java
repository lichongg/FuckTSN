package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class u5 implements l8 {
    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        int i8;
        int i9;
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        l5 l5Var = new l5();
        if (map != null) {
            u2 u2Var = u2.PDF417_COMPACT;
            if (map.containsKey(u2Var)) {
                l5Var.a(Boolean.valueOf(map.get(u2Var).toString()).booleanValue());
            }
            u2 u2Var2 = u2.PDF417_COMPACTION;
            if (map.containsKey(u2Var2)) {
                l5Var.a(y0.valueOf(map.get(u2Var2).toString()));
            }
            u2 u2Var3 = u2.PDF417_DIMENSIONS;
            if (map.containsKey(u2Var3)) {
                m2 m2Var = (m2) map.get(u2Var3);
                l5Var.b(m2Var.a(), m2Var.c(), m2Var.b(), m2Var.d());
            }
            u2 u2Var4 = u2.MARGIN;
            int parseInt = map.containsKey(u2Var4) ? Integer.parseInt(map.get(u2Var4).toString()) : 30;
            u2 u2Var5 = u2.ERROR_CORRECTION;
            int parseInt2 = map.containsKey(u2Var5) ? Integer.parseInt(map.get(u2Var5).toString()) : 2;
            u2 u2Var6 = u2.CHARACTER_SET;
            if (map.containsKey(u2Var6)) {
                l5Var.a(Charset.forName(map.get(u2Var6).toString()));
            }
            i9 = parseInt;
            i8 = parseInt2;
        } else {
            i8 = 2;
            i9 = 30;
        }
        return a(l5Var, str, i8, i6, i7, i9);
    }

    private static s a(l5 l5Var, String str, int i6, int i7, int i8, int i9) throws WriterException {
        l5Var.a(str, i6);
        byte[][] a6 = l5Var.a().a(1, 4);
        int length = i7 / a6[0].length;
        int length2 = i8 / a6.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            return a(l5Var.a().a(length, length * 4), i9);
        }
        return a(a6, i9);
    }

    private static s a(byte[][] bArr, int i6) {
        int i7 = i6 * 2;
        s sVar = new s(bArr[0].length + i7, bArr.length + i7);
        sVar.a();
        int c6 = (sVar.c() - i6) - 1;
        int i8 = 0;
        while (i8 < bArr.length) {
            byte[] bArr2 = bArr[i8];
            for (int i9 = 0; i9 < bArr[0].length; i9++) {
                if (bArr2[i9] == 1) {
                    sVar.c(i9 + i6, c6);
                }
            }
            i8++;
            c6--;
        }
        return sVar;
    }
}
