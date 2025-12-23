package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class w0 extends h5 {
    @Override // com.huawei.hms.scankit.p.h5, com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.a(str, barcodeFormat, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int length2 = ((str.length() + 4) * 9) + 1;
            a(v0.f34886d[47], iArr);
            boolean[] zArr = new boolean[length2];
            int a6 = a(zArr, 0, iArr);
            for (int i6 = 0; i6 < length; i6++) {
                int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i6));
                if (indexOf >= 0) {
                    a(v0.f34886d[indexOf], iArr);
                    a6 += a(zArr, a6, iArr);
                } else {
                    throw new IllegalArgumentException("Bad contents: please check contents");
                }
            }
            int a7 = a(str, 20);
            int[] iArr2 = v0.f34886d;
            a(iArr2[a7], iArr);
            int a8 = a6 + a(zArr, a6, iArr);
            a(iArr2[a(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(a7), 15)], iArr);
            int a9 = a8 + a(zArr, a8, iArr);
            a(iArr2[47], iArr);
            zArr[a9 + a(zArr, a9, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    private static void a(int i6, int[] iArr) {
        for (int i7 = 0; i7 < 9; i7++) {
            int i8 = 1;
            if (((1 << (8 - i7)) & i6) == 0) {
                i8 = 0;
            }
            iArr[i7] = i8;
        }
    }

    private static int a(boolean[] zArr, int i6, int[] iArr) {
        int length = iArr.length;
        int i7 = 0;
        while (i7 < length) {
            int i8 = i6 + 1;
            zArr[i6] = iArr[i7] != 0;
            i7++;
            i6 = i8;
        }
        return 9;
    }

    private static int a(String str, int i6) {
        int i7 = 0;
        int i8 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i7 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i8;
            i8++;
            if (i8 > i6) {
                i8 = 1;
            }
        }
        return i7 % 47;
    }
}
