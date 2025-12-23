package com.amap.api.maps;

import android.graphics.Point;
import com.amap.api.col.p0003l.p;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class CameraUpdateFactory {
    private static final String CLASSNAME = "CameraUpdateFactory";

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i6) {
        return latLngBounds == null ? new CameraUpdate(p.o()) : new CameraUpdate(p.i(latLngBounds, i6));
    }

    public static CameraUpdate zoomBy(float f6) {
        return new CameraUpdate(p.m(f6));
    }

    public static CameraUpdate changeBearing(float f6) {
        return new CameraUpdate(p.q(f6 % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f6, IPoint iPoint) {
        return iPoint == null ? new CameraUpdate(p.o()) : new CameraUpdate(p.n(f6 % 360.0f, new Point(((Point) iPoint).x, ((Point) iPoint).y)));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        return latLng == null ? new CameraUpdate(p.o()) : new CameraUpdate(p.e(VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20)));
    }

    public static CameraUpdate changeTilt(float f6) {
        return new CameraUpdate(p.p(f6));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        return cameraPosition == null ? new CameraUpdate(p.o()) : new CameraUpdate(p.f(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        return latLng == null ? new CameraUpdate(p.o()) : new CameraUpdate(p.g(latLng));
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i6, int i7, int i8, int i9) {
        return latLngBounds == null ? new CameraUpdate(p.o()) : new CameraUpdate(p.k(latLngBounds, i6, i7, i8, i9));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f6) {
        return latLng == null ? new CameraUpdate(p.o()) : new CameraUpdate(p.h(latLng, f6));
    }

    public static CameraUpdate scrollBy(float f6, float f7) {
        return new CameraUpdate(p.c(f6, f7));
    }

    public static CameraUpdate zoomBy(float f6, Point point) {
        return new CameraUpdate(p.d(f6, point));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(p.a());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(p.l());
    }

    public static CameraUpdate zoomTo(float f6) {
        return new CameraUpdate(p.b(f6));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i6, int i7, int i8) {
        if (latLngBounds == null) {
            return new CameraUpdate(p.o());
        }
        return new CameraUpdate(p.j(latLngBounds, i6, i7, i8));
    }
}
