package com.amap.api.col.p0003l;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class p {
    public static AbstractCameraUpdateMessage m(float f6) {
        return d(f6, null);
    }

    public static AbstractCameraUpdateMessage a() {
        m mVar = new m();
        mVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        mVar.amount = 1.0f;
        return mVar;
    }

    public static AbstractCameraUpdateMessage b(float f6) {
        k kVar = new k();
        kVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        kVar.zoom = f6;
        return kVar;
    }

    public static AbstractCameraUpdateMessage c(float f6, float f7) {
        l lVar = new l();
        lVar.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        lVar.xPixel = f6;
        lVar.yPixel = f7;
        return lVar;
    }

    public static AbstractCameraUpdateMessage d(float f6, Point point) {
        m mVar = new m();
        mVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        mVar.amount = f6;
        mVar.focus = point;
        return mVar;
    }

    public static AbstractCameraUpdateMessage e(Point point) {
        k kVar = new k();
        kVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        kVar.geoPoint = new DPoint(point.x, point.y);
        return kVar;
    }

    public static AbstractCameraUpdateMessage f(CameraPosition cameraPosition) {
        LatLng latLng;
        k kVar = new k();
        kVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null && (latLng = cameraPosition.target) != null) {
            DPoint latLongToPixelsDouble = VirtualEarthProjection.latLongToPixelsDouble(latLng.latitude, latLng.longitude, 20);
            kVar.geoPoint = new DPoint(latLongToPixelsDouble.f9903x, latLongToPixelsDouble.f9904y);
            kVar.zoom = cameraPosition.zoom;
            kVar.bearing = cameraPosition.bearing;
            kVar.tilt = cameraPosition.tilt;
            kVar.cameraPosition = cameraPosition;
        }
        return kVar;
    }

    public static AbstractCameraUpdateMessage i(LatLngBounds latLngBounds, int i6) {
        j jVar = new j();
        jVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        jVar.bounds = latLngBounds;
        jVar.paddingLeft = i6;
        jVar.paddingRight = i6;
        jVar.paddingTop = i6;
        jVar.paddingBottom = i6;
        return jVar;
    }

    public static AbstractCameraUpdateMessage j(LatLngBounds latLngBounds, int i6, int i7, int i8) {
        j jVar = new j();
        jVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        jVar.bounds = latLngBounds;
        jVar.paddingLeft = i8;
        jVar.paddingRight = i8;
        jVar.paddingTop = i8;
        jVar.paddingBottom = i8;
        jVar.width = i6;
        jVar.height = i7;
        return jVar;
    }

    public static AbstractCameraUpdateMessage k(LatLngBounds latLngBounds, int i6, int i7, int i8, int i9) {
        j jVar = new j();
        jVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        jVar.bounds = latLngBounds;
        jVar.paddingLeft = i6;
        jVar.paddingRight = i7;
        jVar.paddingTop = i8;
        jVar.paddingBottom = i9;
        return jVar;
    }

    public static AbstractCameraUpdateMessage l() {
        m mVar = new m();
        mVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        mVar.amount = -1.0f;
        return mVar;
    }

    public static AbstractCameraUpdateMessage n(float f6, Point point) {
        k kVar = new k();
        kVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        kVar.geoPoint = new DPoint(point.x, point.y);
        kVar.bearing = f6;
        return kVar;
    }

    public static AbstractCameraUpdateMessage o() {
        return new k();
    }

    public static AbstractCameraUpdateMessage p(float f6) {
        k kVar = new k();
        kVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        kVar.tilt = f6;
        return kVar;
    }

    public static AbstractCameraUpdateMessage q(float f6) {
        k kVar = new k();
        kVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        kVar.bearing = f6;
        return kVar;
    }

    public static AbstractCameraUpdateMessage g(LatLng latLng) {
        return f(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage h(LatLng latLng, float f6) {
        return f(CameraPosition.builder().target(latLng).zoom(f6).bearing(Float.NaN).tilt(Float.NaN).build());
    }
}
