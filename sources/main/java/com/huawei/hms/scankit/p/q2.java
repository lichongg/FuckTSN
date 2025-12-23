package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q2 extends q7 {

    /* renamed from: h, reason: collision with root package name */
    private final int[] f34704h = new int[4];

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(int i6, int i7, r rVar) {
        return rVar.a(i7, ((int) ((i7 - i6) * 1.5d)) + i7, false, true);
    }

    @Override // com.huawei.hms.scankit.p.q7
    protected int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        int[] iArr2 = this.f34704h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e6 = rVar.e();
        int i6 = iArr[1];
        for (int i7 = 0; i7 < 4 && i6 < e6; i7++) {
            sb.append((char) (b(rVar, iArr2, i6, q7.f34720f) + 48));
            for (int i8 : iArr2) {
                i6 += i8;
            }
        }
        int i9 = q7.a(rVar, i6, true, q7.f34718d)[1];
        for (int i10 = 0; i10 < 4 && i9 < e6; i10++) {
            sb.append((char) (b(rVar, iArr2, i9, q7.f34720f) + 48));
            for (int i11 : iArr2) {
                i9 += i11;
            }
        }
        return i9;
    }

    private int b(r rVar, int[] iArr, int i6, int[][] iArr2) throws a {
        g5.a(rVar, i6, iArr);
        int length = iArr2.length;
        float f6 = 0.43f;
        int i7 = -1;
        for (int i8 = 0; i8 < length; i8++) {
            float a6 = g5.a(iArr, iArr2[i8], 0.7f);
            if (a6 < f6) {
                i7 = i8;
                f6 = a6;
            }
        }
        if (i7 >= 0) {
            return i7;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.q7
    BarcodeFormat a() {
        return BarcodeFormat.EAN_8;
    }

    @Override // com.huawei.hms.scankit.p.q7
    boolean a(int[] iArr, int[] iArr2) throws a {
        int i6 = iArr[1];
        int i7 = iArr[0];
        double d6 = (i6 - i7) / 3.0d;
        int i8 = iArr2[1];
        int i9 = iArr2[0];
        return ((double) Math.abs(((int) Math.round(((double) (i8 - i7)) / (((double) ((i8 - i9) + (i6 - i7))) / 6.0d))) + (-67))) <= 6.7d && Math.abs(1.0d - (d6 / (((double) (i8 - i9)) / 3.0d))) < 0.2d;
    }
}
