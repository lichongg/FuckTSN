package com.amap.api.maps;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.interfaces.IProjection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Projection {
    private final IProjection projectionDelegate;

    public float calZoomByTargetPos(LatLng latLng, int i6) {
        try {
            return this.projectionDelegate.calculateMapZoomer(latLng, i6);
        } catch (Throwable th) {
            th.printStackTrace();
            return 3.0f;
        }
    }

    public TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i6, int i7) {
        try {
            return this.projectionDelegate.fromBoundsToTile(latLngBounds, i6, i7);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.projectionDelegate.fromScreenLocation(point);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public AMapCameraInfo getCameraInfo() {
        try {
            return this.projectionDelegate.getCameraInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public LatLngBounds getMapBounds(LatLng latLng, float f6) {
        try {
            return this.projectionDelegate.getMapBounds(latLng, f6);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.projectionDelegate.getVisibleRegion();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public PointF toMapLocation(LatLng latLng) {
        try {
            return this.projectionDelegate.toMapLocation(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public PointF toOpenGLLocation(LatLng latLng) {
        try {
            return this.projectionDelegate.toMapLocation(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float toOpenGLWidth(int i6) {
        try {
            return this.projectionDelegate.toMapLenWithWin(i6);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return this.projectionDelegate.toScreenLocation(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Projection(IProjection iProjection) {
        this.projectionDelegate = iProjection;
    }
}
