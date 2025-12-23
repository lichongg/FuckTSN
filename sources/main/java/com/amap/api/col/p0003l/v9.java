package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class v9 {
    public static double a(double d6, double d7, double d8, double d9) {
        double d10 = (((90.0d - d7) * 21412.0d) / 90.0d) + 6356725.0d;
        double cos = ((d8 * 0.01745329238474369d) - (d6 * 0.01745329238474369d)) * Math.cos((3.1415927410125732d * d7) / 180.0d) * d10;
        double d11 = ((d9 * 0.01745329238474369d) - (d7 * 0.01745329238474369d)) * d10;
        return Math.pow((cos * cos) + (d11 * d11), 0.5d);
    }
}
