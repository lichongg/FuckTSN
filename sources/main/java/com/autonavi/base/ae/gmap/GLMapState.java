package com.autonavi.base.ae.gmap;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.FPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLMapState implements IGLMapState {
    private int engineID;
    private boolean isNewInstance;
    private long nativeEngineInstance;
    private long nativeStateInstance;

    public GLMapState(int i6, long j6) {
        this.nativeStateInstance = 0L;
        this.nativeEngineInstance = 0L;
        this.isNewInstance = false;
        if (j6 != 0) {
            this.engineID = i6;
            this.nativeEngineInstance = j6;
            this.nativeStateInstance = nativeNewInstance(i6, j6);
            this.isNewInstance = true;
        }
    }

    public static native float nativeCalMapZoomScalefactor(long j6, int i6, int i7, float f6);

    public static native float nativeCalculateMapZoomer(long j6, int i6, int i7, int i8, int i9, int i10);

    public static native float nativeGetCameraDegree(long j6);

    public static native float nativeGetGLUnitWithWin(long j6, int i6);

    public static native float nativeGetMapAngle(long j6);

    public static native void nativeGetMapCenter(long j6, Point point);

    public static native double nativeGetMapCenterXDouble(long j6);

    public static native double nativeGetMapCenterYDouble(long j6);

    public static native float nativeGetMapZoomer(long j6);

    public static native void nativeGetPixel20Bound(long j6, Rect rect, int i6, int i7);

    public static native void nativeGetProjectionMatrix(long j6, float[] fArr);

    public static native float nativeGetSkyHeight(long j6);

    public static native void nativeGetViewMatrix(long j6, float[] fArr);

    public static native long nativeNewInstance(int i6, long j6);

    public static native void nativeP20ToScreenPoint(long j6, int i6, int i7, int i8, PointF pointF);

    public static native void nativeRecalculate(long j6);

    public static native void nativeScreenToP20Point(long j6, float f6, float f7, Point point);

    public static native void nativeSetCameraDegree(long j6, float f6);

    public static native void nativeSetMapAngle(long j6, float f6);

    public static native void nativeSetMapCenter(long j6, double d6, double d7);

    private static native void nativeSetMapState(int i6, long j6, long j7);

    public static native void nativeSetMapZoomer(long j6, float f6);

    public static native void nativeStateDestroy(long j6, long j7);

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void getMapGeoCenter(IPoint iPoint) {
        nativeGetMapCenter(this.nativeStateInstance, iPoint);
    }

    public static void geo2LonLat(long j6, long j7, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(j6, j7, 20);
        dPoint.f9903x = pixelsToLatLong.f9903x;
        dPoint.f9904y = pixelsToLatLong.f9904y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d6, double d7, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d7, d6, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }

    public float calMapZoomScalefactor(int i6, int i7, int i8) {
        return nativeCalMapZoomScalefactor(this.nativeStateInstance, i6, i7, i8);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float calculateMapZoomer(int i6, int i7, int i8, int i9, int i10) {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            return nativeCalculateMapZoomer(j6, i6, i7, i8, i9, i10);
        }
        return 3.0f;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getCameraDegree() {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            return nativeGetCameraDegree(j6);
        }
        return 0.0f;
    }

    public float getGLUnitWithWin(int i6) {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            return nativeGetGLUnitWithWin(j6, i6);
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getMapAngle() {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            return nativeGetMapAngle(j6);
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public DPoint getMapGeoCenter() {
        DPoint dPoint = new DPoint();
        dPoint.f9903x = nativeGetMapCenterXDouble(this.nativeStateInstance);
        dPoint.f9904y = nativeGetMapCenterYDouble(this.nativeStateInstance);
        return dPoint;
    }

    public double getMapGeoCenterX() {
        return nativeGetMapCenterXDouble(this.nativeStateInstance);
    }

    public double getMapGeoCenterY() {
        return nativeGetMapCenterXDouble(this.nativeStateInstance);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getMapZoomer() {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            return nativeGetMapZoomer(j6);
        }
        return 0.0f;
    }

    public long getNativeInstance() {
        return this.nativeStateInstance;
    }

    public void getPixel20Bound(Rect rect, int i6, int i7) {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            nativeGetPixel20Bound(j6, rect, i6, i7);
        }
    }

    public void getProjectionMatrix(float[] fArr) {
        if (fArr == null || fArr.length != 16) {
            return;
        }
        nativeGetProjectionMatrix(this.nativeStateInstance, fArr);
    }

    public float getSkyHeight() {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            return nativeGetSkyHeight(j6);
        }
        return 0.0f;
    }

    public void getViewMatrix(float[] fArr) {
        if (fArr == null || fArr.length != 16) {
            return;
        }
        nativeGetViewMatrix(this.nativeStateInstance, fArr);
    }

    public void p20ToScreenPoint(int i6, int i7, FPoint fPoint) {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            nativeP20ToScreenPoint(j6, i6, i7, 0, fPoint);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void recalculate() {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            nativeRecalculate(j6);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void recycle() {
        long j6 = this.nativeStateInstance;
        if (j6 != 0 && this.isNewInstance) {
            nativeStateDestroy(j6, this.nativeEngineInstance);
        }
        this.nativeStateInstance = 0L;
    }

    public void reset() {
        if (this.nativeStateInstance != 0) {
            recycle();
        }
        long j6 = this.nativeEngineInstance;
        if (j6 != 0) {
            this.nativeStateInstance = nativeNewInstance(this.engineID, j6);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void screenToP20Point(int i6, int i7, Point point) {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            nativeScreenToP20Point(j6, i6, i7, point);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setCameraDegree(float f6) {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            nativeSetCameraDegree(j6, f6);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapAngle(float f6) {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            nativeSetMapAngle(j6, f6);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapGeoCenter(double d6, double d7) {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            nativeSetMapCenter(j6, d6, d7);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapZoomer(float f6) {
        long j6 = this.nativeStateInstance;
        if (j6 != 0) {
            nativeSetMapZoomer(j6, f6);
        }
    }

    public void setNativeMapengineState(int i6, long j6) {
        if (j6 != 0) {
            long j7 = this.nativeStateInstance;
            if (j7 == 0) {
                return;
            }
            this.nativeEngineInstance = j6;
            nativeSetMapState(i6, j6, j7);
        }
    }

    public String toString() {
        return "instance: " + this.nativeStateInstance + " center: " + getMapGeoCenter().f9903x + " , " + getMapGeoCenter().f9904y + " bearing:" + getCameraDegree() + "  tilt:" + getMapAngle() + "  zoom:" + getMapZoomer() + "  ";
    }

    public float getMapLenWithWin(int i6) {
        return getGLUnitWithWin(i6);
    }

    public GLMapState(int i6, long j6, long j7) {
        this.nativeStateInstance = 0L;
        this.nativeEngineInstance = 0L;
        this.isNewInstance = false;
        if (j6 != 0) {
            this.engineID = i6;
            this.nativeEngineInstance = j6;
            this.nativeStateInstance = j7;
            this.isNewInstance = true;
        }
    }
}
