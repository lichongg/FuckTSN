package com.amap.api.col.p0003l;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class f implements IProjectionDelegate {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f6162a;

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final float calculateMapZoomer(LatLng latLng, int i6) {
        IAMapDelegate iAMapDelegate = this.f6162a;
        if (iAMapDelegate == null || latLng == null) {
            return 3.0f;
        }
        GLMapState mapProjection = iAMapDelegate.getMapProjection();
        MapConfig mapConfig = this.f6162a.getMapConfig();
        if (mapProjection == null || mapConfig == null) {
            return 3.0f;
        }
        return b3.e(mapProjection, (int) mapConfig.getSX(), (int) mapConfig.getSY(), latLng.latitude, latLng.longitude, i6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i6, int i7) throws RemoteException {
        if (latLngBounds == null || i6 < 0 || i6 > 20 || i7 <= 0) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        IAMapDelegate iAMapDelegate = this.f6162a;
        LatLng latLng = latLngBounds.southwest;
        iAMapDelegate.latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        IAMapDelegate iAMapDelegate2 = this.f6162a;
        LatLng latLng2 = latLngBounds.northeast;
        iAMapDelegate2.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain2);
        int i8 = ((Point) obtain).x;
        int i9 = 20 - i6;
        int i10 = (i8 >> i9) / i7;
        int i11 = (((Point) obtain).y >> i9) / i7;
        int i12 = (((Point) obtain2).x >> i9) / i7;
        int i13 = ((Point) obtain2).y;
        int i14 = (i13 >> i9) / i7;
        obtain.recycle();
        obtain2.recycle();
        return new TileProjection((i8 - ((i10 << i9) * i7)) >> i9, (i13 - ((i14 << i9) * i7)) >> i9, i10, i12, i14, i11);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final LatLng fromScreenLocation(Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.f6162a.getPixel2LatLng(point.x, point.y, obtain);
        LatLng latLng = new LatLng(obtain.f9904y, obtain.f9903x);
        obtain.recycle();
        return latLng;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final AMapCameraInfo getCameraInfo() {
        return this.f6162a.getCamerInfo();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final LatLngBounds getMapBounds(LatLng latLng, float f6) throws RemoteException {
        IAMapDelegate iAMapDelegate = this.f6162a;
        if (iAMapDelegate == null || latLng == null) {
            return null;
        }
        return iAMapDelegate.getMapBounds(latLng, f6, 0.0f, 0.0f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final VisibleRegion getVisibleRegion() throws RemoteException {
        int mapWidth = this.f6162a.getMapWidth();
        int mapHeight = this.f6162a.getMapHeight();
        LatLng fromScreenLocation = fromScreenLocation(new Point(0, 0));
        LatLng fromScreenLocation2 = fromScreenLocation(new Point(mapWidth, 0));
        LatLng fromScreenLocation3 = fromScreenLocation(new Point(0, mapHeight));
        LatLng fromScreenLocation4 = fromScreenLocation(new Point(mapWidth, mapHeight));
        return new VisibleRegion(fromScreenLocation3, fromScreenLocation4, fromScreenLocation, fromScreenLocation2, LatLngBounds.builder().include(fromScreenLocation3).include(fromScreenLocation4).include(fromScreenLocation).include(fromScreenLocation2).build());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final float toMapLenWithWin(int i6) {
        if (i6 <= 0) {
            return 0.0f;
        }
        return this.f6162a.toMapLenWithWin(i6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final PointF toMapLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint obtain = FPoint.obtain();
        this.f6162a.getLatLng2Map(latLng.latitude, latLng.longitude, obtain);
        PointF pointF = new PointF(((PointF) obtain).x, ((PointF) obtain).y);
        obtain.recycle();
        return pointF;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        this.f6162a.getLatLng2Pixel(latLng.latitude, latLng.longitude, obtain);
        Point point = new Point(((Point) obtain).x, ((Point) obtain).y);
        obtain.recycle();
        return point;
    }

    public f(IAMapDelegate iAMapDelegate) {
        this.f6162a = iAMapDelegate;
    }
}
