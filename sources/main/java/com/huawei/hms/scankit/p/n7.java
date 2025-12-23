package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class n7 {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f34598a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f34599b = new StringBuilder();

    s6 a(int i6, r rVar, int[] iArr) throws a {
        StringBuilder sb = this.f34599b;
        sb.setLength(0);
        float f6 = i6;
        return new s6(sb.toString(), null, new u6[]{new u6((iArr[0] + iArr[1]) / 2.0f, f6), new u6(a(rVar, iArr, sb), f6)}, BarcodeFormat.UPC_EAN_EXTENSION);
    }

    n7() {
    }

    private int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        int[] iArr2 = this.f34598a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e6 = rVar.e();
        int i6 = iArr[1];
        int i7 = 0;
        for (int i8 = 0; i8 < 2 && i6 < e6; i8++) {
            int a6 = q7.a(rVar, iArr2, i6, q7.f34721g);
            sb.append((char) ((a6 % 10) + 48));
            for (int i9 : iArr2) {
                i6 += i9;
            }
            if (a6 >= 10) {
                i7 |= 1 << (1 - i8);
            }
            if (i8 != 1) {
                i6 = rVar.d(rVar.c(i6));
            }
        }
        if (sb.length() == 2) {
            try {
                if (Integer.parseInt(sb.toString()) % 4 == i7) {
                    return i6;
                }
                throw a.a();
            } catch (NumberFormatException unused) {
                throw a.a();
            }
        }
        throw a.a();
    }
}
