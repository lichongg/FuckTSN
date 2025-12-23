package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    static double f10254a = 3.141592653589793d;

    /* renamed from: b, reason: collision with root package name */
    private static final List<DPoint> f10255b = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));

    public static DPoint a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        return b(dPoint);
    }

    private static DPoint b(DPoint dPoint) {
        try {
            if (!b.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double[] a6 = com.autonavi.util.a.a(dPoint.getLongitude(), dPoint.getLatitude());
            return new DPoint(a6[1], a6[0]);
        } catch (Throwable th) {
            b.a(th, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    private static DPoint c(double d6, double d7) {
        double d8 = ((long) (d6 * 100000.0d)) % 36000000;
        double d9 = ((long) (d7 * 100000.0d)) % 36000000;
        return new DPoint(((int) (((-b(r11, r2)) + d9) + (d9 > 0.0d ? 1 : -1))) / 100000.0d, ((int) (((-a((int) ((-a(d8, d9)) + d8), (int) ((-b(d8, d9)) + d9))) + d8) + (d8 > 0.0d ? 1 : -1))) / 100000.0d);
    }

    private static double a(double d6, double d7) {
        return (Math.cos(d7 / 100000.0d) * (d6 / 18000.0d)) + (Math.sin(d6 / 100000.0d) * (d7 / 9000.0d));
    }

    private static DPoint d(double d6, double d7) {
        DPoint dPoint = new DPoint();
        double d8 = (d6 * d6) + (d7 * d7);
        double cos = (Math.cos(b(d6) + Math.atan2(d7, d6)) * (a(d7) + Math.sqrt(d8))) + 0.0065d;
        double sin = (Math.sin(b(d6) + Math.atan2(d7, d6)) * (a(d7) + Math.sqrt(d8))) + 0.006d;
        dPoint.setLongitude(c(cos));
        dPoint.setLatitude(c(sin));
        return dPoint;
    }

    private static boolean e(double d6, double d7) {
        return b.a(new DPoint(d6, d7), f10255b);
    }

    private static double h(double d6, double d7) {
        double d8 = d6 * 2.0d;
        return (-100.0d) + d8 + (d7 * 3.0d) + (d7 * 0.2d * d7) + (0.1d * d6 * d7) + (Math.sqrt(Math.abs(d6)) * 0.2d) + ((((Math.sin((d6 * 6.0d) * f10254a) * 20.0d) + (Math.sin(d8 * f10254a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f10254a * d7) * 20.0d) + (Math.sin((d7 / 3.0d) * f10254a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d7 / 12.0d) * f10254a) * 160.0d) + (Math.sin((d7 * f10254a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    public static DPoint a(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (b.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return c(dPoint);
                }
                if (!e(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return dPoint;
                }
                DPoint c6 = c(dPoint);
                return f(c6.getLatitude(), c6.getLongitude());
            } catch (Throwable th) {
                b.a(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    private static DPoint f(double d6, double d7) {
        DPoint g6 = g(d6, d7);
        return new DPoint((d6 * 2.0d) - g6.getLatitude(), (d7 * 2.0d) - g6.getLongitude());
    }

    public static DPoint b(Context context, DPoint dPoint) {
        try {
            return !b.a(dPoint.getLatitude(), dPoint.getLongitude()) ? dPoint : a(context, c(dPoint.getLongitude(), dPoint.getLatitude()));
        } catch (Throwable th) {
            b.a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static DPoint g(double d6, double d7) {
        double d8 = d7 - 105.0d;
        double d9 = d6 - 35.0d;
        double h6 = h(d8, d9);
        double i6 = i(d8, d9);
        double d10 = (d6 / 180.0d) * f10254a;
        double sin = Math.sin(d10);
        double d11 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d11);
        return new DPoint(d6 + ((h6 * 180.0d) / ((6335552.717000426d / (d11 * sqrt)) * f10254a)), d7 + ((i6 * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d10)) * f10254a)));
    }

    private static double i(double d6, double d7) {
        double d8 = d6 * 0.1d;
        return d6 + 300.0d + (d7 * 2.0d) + (d8 * d6) + (d8 * d7) + (Math.sqrt(Math.abs(d6)) * 0.1d) + ((((Math.sin((6.0d * d6) * f10254a) * 20.0d) + (Math.sin((d6 * 2.0d) * f10254a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f10254a * d6) * 20.0d) + (Math.sin((d6 / 3.0d) * f10254a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d6 / 12.0d) * f10254a) * 150.0d) + (Math.sin((d6 / 30.0d) * f10254a) * 300.0d)) * 2.0d) / 3.0d);
    }

    private static double c(double d6) {
        return new BigDecimal(d6).setScale(8, 4).doubleValue();
    }

    private static double a(double d6) {
        return Math.sin(d6 * 3000.0d * (f10254a / 180.0d)) * 2.0E-5d;
    }

    private static double b(double d6, double d7) {
        return (Math.sin(d7 / 100000.0d) * (d6 / 18000.0d)) + (Math.cos(d6 / 100000.0d) * (d7 / 9000.0d));
    }

    private static DPoint a(double d6, double d7, double d8, double d9) {
        DPoint dPoint = new DPoint();
        double d10 = d6 - d8;
        double d11 = d7 - d9;
        DPoint d12 = d(d10, d11);
        dPoint.setLongitude(c((d6 + d10) - d12.getLongitude()));
        dPoint.setLatitude(c((d7 + d11) - d12.getLatitude()));
        return dPoint;
    }

    private static double b(double d6) {
        return Math.cos(d6 * 3000.0d * (f10254a / 180.0d)) * 3.0E-6d;
    }

    private static DPoint c(DPoint dPoint) {
        DPoint dPoint2 = null;
        double d6 = 0.006401062d;
        double d7 = 0.0060424805d;
        for (int i6 = 0; i6 < 2; i6++) {
            dPoint2 = a(dPoint.getLongitude(), dPoint.getLatitude(), d6, d7);
            d6 = dPoint.getLongitude() - dPoint2.getLongitude();
            d7 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }
}
