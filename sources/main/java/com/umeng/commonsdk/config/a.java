package com.umeng.commonsdk.config;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    public static boolean a(int i6, int i7) {
        return i7 >= 0 && i7 <= 31 && (i6 & (1 << i7)) != 0;
    }

    public static int b(int i6, int i7) {
        return i6 | (1 << i7);
    }

    public static int c(int i6, int i7) {
        return i6 & (~(1 << i7));
    }

    public static boolean a(long j6, int i6) {
        return i6 >= 0 && i6 <= 63 && (j6 & (1 << i6)) != 0;
    }

    public static long b(long j6, int i6) {
        return (i6 < 0 || i6 > 63) ? j6 : j6 | (1 << i6);
    }

    public static long c(long j6, int i6) {
        return (i6 < 0 || i6 > 63) ? j6 : j6 & (~(1 << i6));
    }
}
