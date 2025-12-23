package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class m5 {

    /* renamed from: a, reason: collision with root package name */
    private static final float[][] f34570a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, n5.f34595b.length, 8);

    static {
        int i6;
        int i7 = 0;
        while (true) {
            int[] iArr = n5.f34595b;
            if (i7 >= iArr.length) {
                return;
            }
            int i8 = iArr[i7];
            int i9 = i8 & 1;
            int i10 = 0;
            while (i10 < 8) {
                float f6 = 0.0f;
                while (true) {
                    i6 = i8 & 1;
                    if (i6 == i9) {
                        f6 += 1.0f;
                        i8 >>= 1;
                    }
                }
                f34570a[i7][7 - i10] = f6 / 17.0f;
                i10++;
                i9 = i6;
            }
            i7++;
        }
    }

    private static int a(int[] iArr) {
        long j6 = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            for (int i7 = 0; i7 < iArr[i6]; i7++) {
                int i8 = 1;
                long j7 = j6 << 1;
                if (i6 % 2 != 0) {
                    i8 = 0;
                }
                j6 = j7 | i8;
            }
        }
        return (int) j6;
    }

    private static int b(int[] iArr) {
        int a6 = s4.a(iArr);
        float[] fArr = new float[8];
        if (a6 > 1) {
            for (int i6 = 0; i6 < 8; i6++) {
                fArr[i6] = iArr[i6] / a6;
            }
        }
        float f6 = Float.MAX_VALUE;
        int i7 = -1;
        int i8 = 0;
        while (true) {
            float[][] fArr2 = f34570a;
            if (i8 < fArr2.length) {
                float[] fArr3 = fArr2[i8];
                float f7 = 0.0f;
                for (int i9 = 0; i9 < 8; i9++) {
                    float f8 = fArr3[i9] - fArr[i9];
                    f7 += f8 * f8;
                    if (f7 >= f6) {
                        break;
                    }
                }
                if (f7 < f6) {
                    i7 = n5.f34595b[i8];
                    f6 = f7;
                }
                i8++;
            } else {
                return i7;
            }
        }
    }

    private static int c(int[] iArr) {
        int a6 = a(iArr);
        if (n5.a(a6) == -1) {
            return -1;
        }
        return a6;
    }

    static int d(int[] iArr) {
        int c6 = c(e(iArr));
        if (c6 != -1) {
            return c6;
        }
        return b(iArr);
    }

    private static int[] e(int[] iArr) {
        float a6 = s4.a(iArr);
        int[] iArr2 = new int[8];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < 17; i8++) {
            float f6 = (a6 / 34.0f) + ((i8 * a6) / 17.0f);
            int i9 = iArr[i7];
            if (i6 + i9 <= f6) {
                i6 += i9;
                i7++;
            }
            iArr2[i7] = iArr2[i7] + 1;
        }
        return iArr2;
    }
}
