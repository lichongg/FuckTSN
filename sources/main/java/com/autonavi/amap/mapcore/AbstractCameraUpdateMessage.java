package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.amap.api.col.p0003l.b3;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.ae.gmap.GLMapEngine;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class AbstractCameraUpdateMessage {
    public float amount;
    public int anchorX;
    public int anchorY;
    public LatLngBounds bounds;
    public CameraPosition cameraPosition;
    public DPoint geoPoint;
    public int height;
    public boolean isChangeFinished;
    public AMap.CancelableCallback mCallback;
    public IMapConfig mapConfig;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public int width;
    public float xPixel;
    public float yPixel;
    public Type nowType = Type.none;
    public Point focus = null;
    public float zoom = Float.NaN;
    public float tilt = Float.NaN;
    public float bearing = Float.NaN;
    public boolean isUseAnchor = false;
    public long mDuration = 250;
    public float maxZoomLevel = 0.0f;
    public float minZoomLevel = 0.0f;
    public float curZoolScale = 0.0f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Type {
        none,
        zoomIn,
        changeCenter,
        changeTilt,
        changeBearing,
        changeBearingGeoCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }

    protected void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint) {
        changeCenterByAnchor(iGLMapState, dPoint, this.anchorX, this.anchorY);
    }

    public void generateMapAnimation(IGLMapEngine iGLMapEngine) {
        int engineIDWithType = ((GLMapEngine) iGLMapEngine).getEngineIDWithType(1);
        IGLMapState newMapState = iGLMapEngine.getNewMapState(engineIDWithType);
        runCameraUpdate(newMapState);
        DPoint mapGeoCenter = newMapState.getMapGeoCenter();
        iGLMapEngine.addGroupAnimation(engineIDWithType, (int) this.mDuration, newMapState.getMapZoomer(), (int) newMapState.getMapAngle(), (int) newMapState.getCameraDegree(), (int) mapGeoCenter.f9903x, (int) mapGeoCenter.f9904y, this.mCallback);
        newMapState.recycle();
    }

    public abstract void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage);

    public abstract void runCameraUpdate(IGLMapState iGLMapState);

    protected void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint, int i6, int i7) {
        iGLMapState.recalculate();
        Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, i6, i7);
        DPoint mapGeoCenter = iGLMapState.getMapGeoCenter();
        iGLMapState.setMapGeoCenter((mapGeoCenter.f9903x + dPoint.f9903x) - anchorGeoPoint.x, (mapGeoCenter.f9904y + dPoint.f9904y) - anchorGeoPoint.y);
    }

    protected Point getAnchorGeoPoint(IGLMapState iGLMapState, int i6, int i7) {
        Point point = new Point();
        iGLMapState.screenToP20Point(i6, i7, point);
        return point;
    }

    protected void normalChange(IGLMapState iGLMapState) {
        this.zoom = Float.isNaN(this.zoom) ? iGLMapState.getMapZoomer() : this.zoom;
        this.bearing = Float.isNaN(this.bearing) ? iGLMapState.getMapAngle() : this.bearing;
        this.tilt = Float.isNaN(this.tilt) ? iGLMapState.getCameraDegree() : this.tilt;
        float h6 = b3.h(this.mapConfig, this.zoom);
        this.zoom = h6;
        this.tilt = b3.i(this.mapConfig, this.tilt, h6);
        this.bearing = (float) (((this.bearing % 360.0d) + 360.0d) % 360.0d);
        Point point = this.focus;
        if (point != null && this.geoPoint == null) {
            Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, point.x, point.y);
            this.geoPoint = new DPoint(anchorGeoPoint.x, anchorGeoPoint.y);
        }
        if (!Float.isNaN(this.zoom)) {
            iGLMapState.setMapZoomer(this.zoom);
        }
        if (!Float.isNaN(this.bearing)) {
            iGLMapState.setMapAngle(this.bearing);
        }
        if (!Float.isNaN(this.tilt)) {
            iGLMapState.setCameraDegree(this.tilt);
        }
        Point point2 = this.focus;
        if (point2 != null) {
            changeCenterByAnchor(iGLMapState, this.geoPoint, point2.x, point2.y);
            return;
        }
        DPoint dPoint = this.geoPoint;
        if (dPoint != null) {
            double d6 = dPoint.f9903x;
            if (d6 == 0.0d && dPoint.f9904y == 0.0d) {
                return;
            }
            iGLMapState.setMapGeoCenter(d6, dPoint.f9904y);
        }
    }
}
