package com.kwad.sdk.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t {
    public static int a(long j6, long j7, boolean z5, int i6) {
        com.kwad.sdk.core.d.c.d("DownloadProgressTransformUtil", "soFarBytes:" + j6 + " totalBytes:" + j7 + " isShowOptimizedProgress: " + z5 + " optimizeMethod: " + i6);
        double d6 = j7 > 0 ? (j6 * 100.0d) / j7 : 0.0d;
        if (!z5) {
            return (int) d6;
        }
        if (i6 == 1) {
            d6 = p(d6);
        } else if (i6 == 2) {
            d6 = q(d6);
        }
        return (int) d6;
    }

    private static double p(double d6) {
        if (d6 <= 6.0d) {
            return d6 * 5.0d;
        }
        if (d6 <= 15.0d) {
            return ((d6 - 6.0d) * 2.0d) + 30.0d;
        }
        if (d6 <= 30.0d) {
            return d6 + 33.0d;
        }
        if (d6 < 100.0d) {
            return Math.min((((d6 - 30.0d) * 0.37d) / 0.7d) + 63.0d, 99.0d);
        }
        return 100.0d;
    }

    private static double q(double d6) {
        return Math.sqrt(d6) * 10.0d;
    }
}
