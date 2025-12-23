package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MapProjection {
    public static void geo2LonLat(int i6, int i7, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i6, i7, 20);
        dPoint.f9903x = pixelsToLatLong.f9903x;
        dPoint.f9904y = pixelsToLatLong.f9904y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d6, double d7, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d7, d6, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }
}
