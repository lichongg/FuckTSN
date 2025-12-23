package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s4 {
    public static int a(float f6) {
        return (int) (f6 + (f6 < 0.0f ? -0.5f : 0.5f));
    }

    public static float a(float f6, float f7, float f8, float f9) {
        float f10 = f6 - f8;
        float f11 = f7 - f9;
        return (float) Math.sqrt((f10 * f10) + (f11 * f11));
    }

    public static float a(int i6, int i7, int i8, int i9) {
        int i10 = i6 - i8;
        int i11 = i7 - i9;
        return (float) Math.sqrt((i10 * i10) + (i11 * i11));
    }

    public static int a(int[] iArr) {
        int i6 = 0;
        for (int i7 : iArr) {
            i6 += i7;
        }
        return i6;
    }
}
