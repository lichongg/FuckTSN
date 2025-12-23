package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class u0 extends h5 {
    @Override // com.huawei.hms.scankit.p.h5, com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i6 = length + 25;
            for (int i7 = 0; i7 < length; i7++) {
                int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i7));
                if (indexOf >= 0) {
                    a(t0.f34818e[indexOf], iArr);
                    for (int i8 = 0; i8 < 9; i8++) {
                        i6 += iArr[i8];
                    }
                } else {
                    throw new IllegalArgumentException("Bad contents: error contents");
                }
            }
            boolean[] zArr = new boolean[i6];
            a(148, iArr);
            int a6 = h5.a(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int a7 = a6 + h5.a(zArr, a6, iArr2, false);
            for (int i9 = 0; i9 < length; i9++) {
                a(t0.f34818e["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i9))], iArr);
                int a8 = a7 + h5.a(zArr, a7, iArr, true);
                a7 = a8 + h5.a(zArr, a8, iArr2, false);
            }
            a(148, iArr);
            h5.a(zArr, a7, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    private static void a(int i6, int[] iArr) {
        for (int i7 = 0; i7 < 9; i7++) {
            int i8 = 1;
            if (((1 << (8 - i7)) & i6) != 0) {
                i8 = 2;
            }
            iArr[i7] = i8;
        }
    }
}
