package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r2 extends r7 {
    @Override // com.huawei.hms.scankit.p.h5, com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + q7.b(str);
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
        boolean[] zArr = new boolean[67];
        int a6 = h5.a(zArr, 0, q7.f34717c, true);
        for (int i6 = 0; i6 <= 3; i6++) {
            a6 += h5.a(zArr, a6, q7.f34720f[Character.digit(str.charAt(i6), 10)], false);
        }
        int a7 = a6 + h5.a(zArr, a6, q7.f34718d, false);
        for (int i7 = 4; i7 <= 7; i7++) {
            a7 += h5.a(zArr, a7, q7.f34720f[Character.digit(str.charAt(i7), 10)], true);
        }
        h5.a(zArr, a7, q7.f34717c, true);
        return zArr;
    }
}
