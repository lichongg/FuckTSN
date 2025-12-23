package com.huawei.hms.scankit.p;

import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j7 {

    /* renamed from: a, reason: collision with root package name */
    private static float f34460a = 2.51f;

    /* renamed from: b, reason: collision with root package name */
    private static float f34461b = 0.03f;

    /* renamed from: c, reason: collision with root package name */
    private static float f34462c = 2.43f;

    /* renamed from: d, reason: collision with root package name */
    private static float f34463d = 0.59f;

    /* renamed from: e, reason: collision with root package name */
    private static float f34464e = 0.14f;

    /* renamed from: f, reason: collision with root package name */
    private static HashMap<Integer, Integer> f34465f = new HashMap<>(255);

    private static int a(int i6, float f6) {
        if (f34465f.containsKey(Integer.valueOf(i6))) {
            return f34465f.get(Integer.valueOf(i6)).intValue();
        }
        float f7 = i6 / f6;
        int i7 = (int) ((f6 * (((f34460a * f7) + f34461b) * f7)) / ((f7 * ((f34462c * f7) + f34463d)) + f34464e));
        f34465f.put(Integer.valueOf(i6), Integer.valueOf(i7));
        return i7;
    }

    public static p4 b(p4 p4Var) {
        int a6 = a(p4Var);
        int c6 = p4Var.c();
        int a7 = p4Var.a();
        byte[] b6 = p4Var.b();
        byte[] bArr = new byte[a7 * c6];
        for (int i6 = 0; i6 < a7; i6++) {
            for (int i7 = 0; i7 < c6; i7++) {
                int i8 = (i6 * c6) + i7;
                bArr[i8] = (byte) (a(b6[i8] & 255, a6) & 255);
            }
        }
        f34465f = new HashMap<>(255);
        return new e6(bArr, c6, a7, 0, 0, c6, a7, false);
    }

    private static int a(p4 p4Var) {
        if (p4Var.b() == null) {
            return 1;
        }
        int c6 = p4Var.c();
        int a6 = p4Var.a();
        long j6 = 0;
        for (int i6 = a6 / 4; i6 < (a6 * 3) / 4; i6++) {
            for (int i7 = c6 / 4; i7 < (c6 * 3) / 4; i7++) {
                j6 += r0[(i6 * c6) + i7] & 255;
            }
        }
        return (int) ((j6 / r0.length) * 4);
    }
}
