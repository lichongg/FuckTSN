package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdglMapAnimPivotZoom extends AbstractAdglAnimation {
    private int beginCenterGeoX;
    private int beginCenterGeoY;
    private boolean hasCheckParams;
    private float mapLevelTo;
    private int pivotGeoX;
    private int pivotGeoY;
    private float winPivotX;
    private float winPivotY;
    private boolean zoomCenter;
    AbstractAdglAnimationParam1V zoomParam = null;

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        float mapZoomer = gLMapState.getMapZoomer();
        if (Math.abs(this.mapLevelTo - mapZoomer) < 1.0E-6d) {
            this.isOver = true;
            this.hasCheckParams = true;
            return;
        }
        this.zoomParam.setFromValue(mapZoomer);
        this.zoomParam.setToValue(this.mapLevelTo);
        if (!this.zoomCenter) {
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            this.beginCenterGeoX = ((Point) obtain).x;
            this.beginCenterGeoY = ((Point) obtain).y;
            IPoint obtain2 = IPoint.obtain();
            gLMapState.screenToP20Point((int) this.winPivotX, (int) this.winPivotY, obtain2);
            this.pivotGeoX = ((Point) obtain2).x;
            this.pivotGeoY = ((Point) obtain2).y;
            obtain.recycle();
            obtain2.recycle();
        }
        this.hasCheckParams = true;
        this.isOver = false;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (!this.hasCheckParams) {
            commitAnimation(obj);
        }
        if (this.isOver) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f6 = uptimeMillis / this.duration;
        if (f6 > 1.0f) {
            this.isOver = true;
            f6 = 1.0f;
        }
        if (f6 < 0.0f || f6 > 1.0f) {
            return;
        }
        this.zoomParam.setNormalizedTime(f6);
        float curValue = this.zoomParam.getCurValue();
        if (curValue > 20.0f) {
            this.isOver = true;
            curValue = 20.0f;
        }
        if (curValue < 3.0f) {
            this.isOver = true;
            curValue = 3.0f;
        }
        if (!this.zoomCenter) {
            float pow = (float) Math.pow(2.0d, curValue - this.zoomParam.getFromValue());
            int i6 = this.pivotGeoX;
            int i7 = this.beginCenterGeoX;
            int i8 = (int) ((i6 - i7) * (1.0f - (1.0f / pow)));
            int i9 = this.pivotGeoY;
            int i10 = this.beginCenterGeoY;
            gLMapState.setMapGeoCenter(i7 + i8, i10 + ((int) ((i9 - i10) * r2)));
        }
        gLMapState.setMapZoomer(curValue);
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.zoomCenter = true;
        this.mapLevelTo = 0.0f;
        this.beginCenterGeoX = 0;
        this.beginCenterGeoY = 0;
        this.pivotGeoX = 0;
        this.pivotGeoY = 0;
        this.winPivotX = 0.0f;
        this.winPivotY = 0.0f;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
    }

    public void setToMapZoomAndPivot(float f6, int i6, Point point) {
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = new AbstractAdglAnimationParam1V();
        this.zoomParam = abstractAdglAnimationParam1V;
        abstractAdglAnimationParam1V.setInterpolatorType(i6, 1.0f);
        if (f6 > 20.0f) {
            f6 = 20.0f;
        }
        if (f6 < 3.0f) {
            f6 = 3.0f;
        }
        this.mapLevelTo = f6;
        if (point != null) {
            this.winPivotX = point.x;
            this.winPivotY = point.y;
            this.zoomCenter = false;
        }
    }

    public AdglMapAnimPivotZoom(int i6) {
        reset();
        this.duration = i6;
    }
}
