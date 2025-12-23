package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class VirtualEarthProjection {
    public static final double EARTH_CIRCUMFERENCE_IN_METERS = 4.007501668557849E7d;
    public static final int EARTH_RADIUS_IN_METERS = 6378137;
    private static final int KMA_MAX_MAP_SIZE = 268435456;
    private static final double K_EARTH_CIRCLE = 4.0075016E7d;
    private static final double K_EARTH_CIRCLE_2 = 2.0037508E7d;
    public static final int MAXZOOMLEVEL = 20;
    public static final double MAX_LATITUDE = 85.0511287798d;
    public static final double MAX_LONGITUDE = 360.0d;
    public static final double MIN_LATITUDE = -85.0511287798d;
    public static final double MIN_LONGITUDE = -360.0d;
    public static final int PIXELS_PER_TILE = 256;
    public static final int TILE_SPLIT_LEVEL = 0;

    public static Point latLongToPixels(int i6, int i7, int i8) {
        return latLongToPixels(i7 / 3600000.0d, i6 / 3600000.0d, i8);
    }

    public static DPoint pixelsToLatLong(long j6, long j7, int i6) {
        DPoint obtain = DPoint.obtain();
        double d6 = (j6 * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double d7 = K_EARTH_CIRCLE_2 - (j7 * 0.14929106831550598d);
        obtain.f9903x = radToDeg(d6 / 6378137.0d);
        double exp = Math.exp((d7 / 6378137.0d) * 2.0d);
        obtain.f9904y = radToDeg(Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    public static void latLongToPixels(double d6, double d7, int i6, Point point) {
        double clip = clip(d6, -85.0511287798d, 85.0511287798d);
        double degToRad = degToRad(clip(d7, -360.0d, 360.0d)) * 6378137.0d;
        double sin = Math.sin(degToRad(clip));
        double log = (Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d;
        double d8 = (degToRad + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        double d9 = (K_EARTH_CIRCLE_2 - log) / 0.14929106831550598d;
        point.x = (int) d8;
        point.y = (int) d9;
    }

    public static DPoint latLongToPixelsDouble(double d6, double d7, int i6) {
        DPoint dPoint = new DPoint();
        double clip = clip(d6, -85.0511287798d, 85.0511287798d);
        double degToRad = degToRad(clip(d7, -360.0d, 360.0d)) * 6378137.0d;
        double sin = Math.sin(degToRad(clip));
        double log = (Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d;
        double d8 = (degToRad + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        double d9 = (K_EARTH_CIRCLE_2 - log) / 0.14929106831550598d;
        dPoint.f9903x = d8;
        dPoint.f9904y = d9;
        return dPoint;
    }

    public static double clip(double d6, double d7, double d8) {
        return Math.min(Math.max(d6, d7), d8);
    }

    private static double degToRad(double d6) {
        return d6 * 0.017453292519943295d;
    }

    public static DPoint pixelsToLatLong(double d6, double d7, int i6) {
        DPoint obtain = DPoint.obtain();
        double d8 = (d6 * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double d9 = K_EARTH_CIRCLE_2 - (d7 * 0.14929106831550598d);
        obtain.f9903x = radToDeg(d8 / 6378137.0d);
        double exp = Math.exp((d9 / 6378137.0d) * 2.0d);
        obtain.f9904y = radToDeg(Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    private static double radToDeg(double d6) {
        return d6 * 57.29577951308232d;
    }

    public static Point latLongToPixels(double d6, double d7, int i6) {
        Point point = new Point();
        latLongToPixels(d6, d7, i6, point);
        return point;
    }
}
