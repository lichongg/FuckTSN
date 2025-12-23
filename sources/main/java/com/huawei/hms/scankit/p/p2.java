package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p2 extends r7 {
    @Override // com.huawei.hms.scankit.p.h5, com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + q7.b(str);
            } catch (a e6) {
                throw new IllegalArgumentException(e6);
            }
        } else if (length == 13) {
            try {
                if (!q7.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (a unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
        }
        int i6 = o2.f34642j[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int a6 = h5.a(zArr, 0, q7.f34717c, true);
        for (int i7 = 1; i7 <= 6; i7++) {
            int digit = Character.digit(str.charAt(i7), 10);
            if (((i6 >> (6 - i7)) & 1) == 1) {
                digit += 10;
            }
            a6 += h5.a(zArr, a6, q7.f34721g[digit], false);
        }
        int a7 = a6 + h5.a(zArr, a6, q7.f34718d, false);
        for (int i8 = 7; i8 <= 12; i8++) {
            a7 += h5.a(zArr, a7, q7.f34720f[Character.digit(str.charAt(i8), 10)], true);
        }
        h5.a(zArr, a7, q7.f34717c, true);
        return zArr;
    }
}
