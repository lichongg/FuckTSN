package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class l4 {
    public static int a(int i6, int i7, int i8) {
        return i6 >= i7 ? i7 : i6 <= i8 ? i8 : i6;
    }

    public static p a(p pVar) {
        int e6 = pVar.e();
        int c6 = pVar.c();
        byte[] d6 = pVar.d();
        byte[] bArr = new byte[e6 * c6];
        for (int i6 = 0; i6 < c6; i6++) {
            for (int i7 = 0; i7 < e6; i7++) {
                bArr[(((i7 * c6) + c6) - i6) - 1] = d6[(i6 * e6) + i7];
            }
        }
        return new p(new e4(new e6(bArr, c6, e6, 0, 0, c6, e6, false)));
    }

    public static p a(p pVar, float f6) {
        if (f6 == 1.0f) {
            return pVar;
        }
        int c6 = pVar.c();
        int e6 = pVar.e();
        int i6 = (int) (e6 / f6);
        int i7 = (int) (c6 / f6);
        byte[] d6 = pVar.d();
        int i8 = i6 * i7;
        byte[] bArr = new byte[i8];
        int i9 = 0;
        int i10 = 0;
        while (i10 < i8) {
            double a6 = a(i10 % i6, i6 - 1, i9) * f6;
            double a7 = a(i10 / i6, i7 - 1, i9) * f6;
            double floor = Math.floor(a6);
            int i11 = i10;
            double floor2 = Math.floor(a7);
            double d7 = a6 - floor;
            double d8 = a7 - floor2;
            int i12 = c6;
            int a8 = a((int) floor, e6 - 1, 0);
            int a9 = a((int) floor2, i12 - 1, 0);
            int i13 = a9 * e6;
            double d9 = 1.0d - d7;
            double d10 = 1.0d - d8;
            double d11 = (d6[i13 + a8] & 255) * d9 * d10;
            int i14 = a8 + 1;
            int i15 = a9 + 1;
            bArr[i11] = (byte) (((int) (d11 + ((d6[i13 + a(i14, r14, 0)] & 255) * d7 * d10) + ((r18[(a(i15, r8, 0) * r17) + a8] & 255) * d9 * d8) + ((r18[(a(i15, r8, 0) * r17) + a(i14, r14, 0)] & 255) * d7 * d8))) & 255);
            i10 = i11 + 1;
            c6 = i12;
            e6 = e6;
            d6 = d6;
            i9 = 0;
        }
        return new p(new e4(new e6(bArr, i6, i7, 0, 0, i6, i7, false)));
    }

    public static p a(boolean z5, p pVar, float f6) {
        if (f6 == 1.0f) {
            return pVar;
        }
        int c6 = pVar.c();
        int e6 = pVar.e();
        int i6 = (int) (e6 / f6);
        int i7 = (int) (c6 / f6);
        return new p(new e4(new e6(LoadOpencvJNIUtil.imageResize(pVar.d(), c6, e6, i7, i6), i6, i7, 0, 0, i6, i7, false)));
    }
}
