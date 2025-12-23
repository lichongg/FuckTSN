package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.util.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6929a = false;

    /* renamed from: b, reason: collision with root package name */
    static double f6930b = 3.141592653589793d;

    /* renamed from: c, reason: collision with root package name */
    private static final double[] f6931c = {25.575374d, 120.391111d};

    /* renamed from: d, reason: collision with root package name */
    private static final double[] f6932d = {21.405235d, 121.649046d};

    /* renamed from: e, reason: collision with root package name */
    private static final List<LatLng> f6933e = new ArrayList(Arrays.asList(new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)));

    /* renamed from: f, reason: collision with root package name */
    public static double f6934f = 6378245.0d;

    /* renamed from: g, reason: collision with root package name */
    public static double f6935g = 0.006693421622965943d;

    public static LatLng c(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (!u2.a(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        DPoint f6 = f(DPoint.obtain(latLng.longitude, latLng.latitude), f6929a);
        LatLng latLng2 = new LatLng(f6.f9904y, f6.f9903x, false);
        f6.recycle();
        return latLng2;
    }

    public static LatLng d(LatLng latLng) {
        if (latLng != null) {
            try {
                if (u2.a(latLng.latitude, latLng.longitude)) {
                    DPoint m6 = m(latLng.longitude, latLng.latitude);
                    LatLng latLng2 = new LatLng(m6.f9904y, m6.f9903x, false);
                    m6.recycle();
                    return latLng2;
                }
                if (!n(latLng.latitude, latLng.longitude)) {
                    return latLng;
                }
                DPoint m7 = m(latLng.longitude, latLng.latitude);
                return o(m7.f9904y, m7.f9903x);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    private static DPoint f(DPoint dPoint, boolean z5) {
        try {
            if (!u2.a(dPoint.f9904y, dPoint.f9903x)) {
                return dPoint;
            }
            double[] dArr = new double[2];
            if (!z5) {
                dArr = a.a(dPoint.f9903x, dPoint.f9904y);
            }
            dPoint.recycle();
            return DPoint.obtain(dArr[0], dArr[1]);
        } catch (Throwable unused) {
            return dPoint;
        }
    }

    public static LatLng i(Context context, LatLng latLng) {
        try {
            if (!u2.a(latLng.latitude, latLng.longitude)) {
                return latLng;
            }
            DPoint k6 = k(latLng.longitude, latLng.latitude);
            LatLng c6 = c(context, new LatLng(k6.f9904y, k6.f9903x, false));
            k6.recycle();
            return c6;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    private static double j(double d6) {
        return new BigDecimal(d6).setScale(8, 4).doubleValue();
    }

    private static boolean n(double d6, double d7) {
        return b3.M(new LatLng(d6, d7), f6933e);
    }

    private static double q(double d6, double d7) {
        double d8 = d6 * 2.0d;
        return (-100.0d) + d8 + (d7 * 3.0d) + (d7 * 0.2d * d7) + (0.1d * d6 * d7) + (Math.sqrt(Math.abs(d6)) * 0.2d) + ((((Math.sin((d6 * 6.0d) * f6930b) * 20.0d) + (Math.sin(d8 * f6930b) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f6930b * d7) * 20.0d) + (Math.sin((d7 / 3.0d) * f6930b) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d7 / 12.0d) * f6930b) * 160.0d) + (Math.sin((d7 * f6930b) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static DPoint e(double d6, double d7, double d8, double d9) {
        DPoint obtain = DPoint.obtain();
        double d10 = d6 - d8;
        double d11 = d7 - d9;
        DPoint l6 = l(d10, d11);
        obtain.f9903x = j((d6 + d10) - l6.f9903x);
        obtain.f9904y = j((d7 + d11) - l6.f9904y);
        return obtain;
    }

    private static DPoint l(double d6, double d7) {
        DPoint obtain = DPoint.obtain();
        double d8 = (d6 * d6) + (d7 * d7);
        double cos = (Math.cos(g(d6) + Math.atan2(d7, d6)) * (a(d7) + Math.sqrt(d8))) + 0.0065d;
        double sin = (Math.sin(g(d6) + Math.atan2(d7, d6)) * (a(d7) + Math.sqrt(d8))) + 0.006d;
        obtain.f9903x = j(cos);
        obtain.f9904y = j(sin);
        return obtain;
    }

    private static LatLng o(double d6, double d7) {
        LatLng p5 = p(d6, d7);
        return new LatLng((d6 * 2.0d) - p5.latitude, (d7 * 2.0d) - p5.longitude);
    }

    private static double a(double d6) {
        return Math.sin(d6 * 3000.0d * (f6930b / 180.0d)) * 2.0E-5d;
    }

    private static double b(double d6, double d7) {
        return (Math.cos(d7 / 100000.0d) * (d6 / 18000.0d)) + (Math.sin(d6 / 100000.0d) * (d7 / 9000.0d));
    }

    private static double g(double d6) {
        return Math.cos(d6 * 3000.0d * (f6930b / 180.0d)) * 3.0E-6d;
    }

    private static double h(double d6, double d7) {
        return (Math.sin(d7 / 100000.0d) * (d6 / 18000.0d)) + (Math.cos(d6 / 100000.0d) * (d7 / 9000.0d));
    }

    private static DPoint k(double d6, double d7) {
        int i6;
        double d8 = ((long) (d6 * 100000.0d)) % 36000000;
        double d9 = ((long) (d7 * 100000.0d)) % 36000000;
        double d10 = (int) ((-b(d8, d9)) + d8);
        double d11 = (int) ((-h(d8, d9)) + d9);
        double d12 = (-b(d10, d11)) + d8;
        int i7 = -1;
        if (d8 > 0.0d) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        double d13 = (int) (d12 + i6);
        double d14 = (-h(d13, d11)) + d9;
        if (d9 > 0.0d) {
            i7 = 1;
        }
        return DPoint.obtain(d13 / 100000.0d, ((int) (d14 + i7)) / 100000.0d);
    }

    private static DPoint m(double d6, double d7) {
        DPoint dPoint = null;
        double d8 = 0.006401062d;
        double d9 = 0.0060424805d;
        for (int i6 = 0; i6 < 2; i6++) {
            dPoint = e(d6, d7, d8, d9);
            d8 = d6 - dPoint.f9903x;
            d9 = d7 - dPoint.f9904y;
        }
        return dPoint;
    }

    private static LatLng p(double d6, double d7) {
        double d8 = d7 - 105.0d;
        double d9 = d6 - 35.0d;
        double q5 = q(d8, d9);
        double r5 = r(d8, d9);
        double d10 = (d6 / 180.0d) * f6930b;
        double sin = Math.sin(d10);
        double d11 = 1.0d - ((f6935g * sin) * sin);
        double sqrt = Math.sqrt(d11);
        double d12 = f6934f;
        return new LatLng(d6 + ((q5 * 180.0d) / ((((1.0d - f6935g) * d12) / (d11 * sqrt)) * f6930b)), d7 + ((r5 * 180.0d) / (((d12 / sqrt) * Math.cos(d10)) * f6930b)));
    }

    private static double r(double d6, double d7) {
        double d8 = d6 * 0.1d;
        return d6 + 300.0d + (d7 * 2.0d) + (d8 * d6) + (d8 * d7) + (Math.sqrt(Math.abs(d6)) * 0.1d) + ((((Math.sin((6.0d * d6) * f6930b) * 20.0d) + (Math.sin((d6 * 2.0d) * f6930b) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f6930b * d6) * 20.0d) + (Math.sin((d6 / 3.0d) * f6930b) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d6 / 12.0d) * f6930b) * 150.0d) + (Math.sin((d6 / 30.0d) * f6930b) * 300.0d)) * 2.0d) / 3.0d);
    }
}
