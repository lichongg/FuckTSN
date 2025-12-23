package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t7 extends r7 {
    @Override // com.huawei.hms.scankit.p.h5, com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.a(str, barcodeFormat, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + q7.b(s7.b(str));
            } catch (a e6) {
                throw new IllegalArgumentException(e6);
            }
        } else if (length == 8) {
            try {
                if (!q7.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (a unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + length);
        }
        int digit = Character.digit(str.charAt(0), 10);
        if (digit != 0 && digit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i6 = s7.f34812j[digit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int a6 = h5.a(zArr, 0, q7.f34717c, true);
        for (int i7 = 1; i7 <= 6; i7++) {
            int digit2 = Character.digit(str.charAt(i7), 10);
            if (((i6 >> (6 - i7)) & 1) == 1) {
                digit2 += 10;
            }
            a6 += h5.a(zArr, a6, q7.f34721g[digit2], false);
        }
        h5.a(zArr, a6, q7.f34719e, false);
        return zArr;
    }
}
