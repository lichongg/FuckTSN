package com.facebook.rebound;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class OrigamiValueConverter {
    public static double a(double d6) {
        if (d6 == 0.0d) {
            return 0.0d;
        }
        return ((d6 - 8.0d) * 3.0d) + 25.0d;
    }

    public static double b(double d6) {
        if (d6 == 0.0d) {
            return 0.0d;
        }
        return ((d6 - 25.0d) / 3.0d) + 8.0d;
    }

    public static double c(double d6) {
        if (d6 == 0.0d) {
            return 0.0d;
        }
        return ((d6 - 194.0d) / 3.62d) + 30.0d;
    }

    public static double d(double d6) {
        if (d6 == 0.0d) {
            return 0.0d;
        }
        return ((d6 - 30.0d) * 3.62d) + 194.0d;
    }
}
