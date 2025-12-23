package com.beizi.fusion.tool;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class af {
    public static boolean a(int i6) {
        return ((int) ((Math.random() * 100.0d) + 1.0d)) <= i6;
    }

    public static int b(int i6) {
        return (int) ((Math.random() * i6) + 1.0d);
    }

    public static int[] a(int i6, int i7) {
        int[] iArr = new int[2];
        boolean z5 = false;
        while (!z5) {
            double rint = Math.rint(b(0, (int) (i6 * 2 * 0.95d)));
            double rint2 = Math.rint(b(0, (int) (i7 * 2 * 0.95d)));
            double d6 = i6;
            double d7 = i7;
            if (a(d6, d7, rint, rint2, d6 * 0.9d, d7 * 0.9d) <= 1.0d) {
                iArr[0] = (int) rint;
                iArr[1] = (int) rint2;
                z5 = true;
            }
        }
        return iArr;
    }

    private static int b(int i6, int i7) {
        return (int) ((Math.random() * (i7 - i6)) + i6);
    }

    private static double a(double d6, double d7, double d8, double d9, double d10, double d11) {
        return (Math.pow(d8 - d6, 2.0d) / Math.pow(d10, 2.0d)) + (Math.pow(d9 - d7, 2.0d) / Math.pow(d11, 2.0d));
    }
}
