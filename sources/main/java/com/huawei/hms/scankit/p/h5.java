package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class h5 implements l8 {
    public int a() {
        return 10;
    }

    public abstract boolean[] a(String str);

    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i6 < 0 || i7 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i6 + 'x' + i7);
        }
        int a6 = a();
        if (map != null) {
            u2 u2Var = u2.MARGIN;
            if (map.containsKey(u2Var)) {
                try {
                    a6 = Integer.parseInt(map.get(u2Var).toString());
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("EncodeHintType MARGIN can not format integer");
                }
            }
        }
        return a(a(str), i6, i7, a6);
    }

    private static s a(boolean[] zArr, int i6, int i7, int i8) {
        int length = zArr.length;
        int i9 = i8 + length;
        int max = Math.max(i6, i9);
        int max2 = Math.max(1, i7);
        int i10 = max / i9;
        int i11 = (max - (length * i10)) / 2;
        s sVar = new s(max, max2);
        int i12 = 0;
        while (i12 < length) {
            if (zArr[i12]) {
                sVar.a(i11, 0, i10, max2);
            }
            i12++;
            i11 += i10;
        }
        return sVar;
    }

    protected static int a(boolean[] zArr, int i6, int[] iArr, boolean z5) {
        int i7 = 0;
        for (int i8 : iArr) {
            int i9 = 0;
            while (i9 < i8) {
                zArr[i6] = z5;
                i9++;
                i6++;
            }
            i7 += i8;
            z5 = !z5;
        }
        return i7;
    }
}
