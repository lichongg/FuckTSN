package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ScaleGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<ScaleGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public int pivotX;
    public int pivotY;
    public float scaleDelta;

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 1;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static ScaleGestureMapMessage obtain(int i6, float f6, int i7, int i8) {
        ScaleGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new ScaleGestureMapMessage(i6, f6, i7, i8);
        }
        acquire.reset();
        acquire.setParams(i6, f6, i7, i8);
        return acquire;
    }

    private void setMapZoomer(GLMapState gLMapState) {
        gLMapState.setMapZoomer(gLMapState.getMapZoomer() + this.scaleDelta);
        gLMapState.recalculate();
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint obtain;
        IPoint obtain2;
        if (this.isUseAnchor) {
            setMapZoomer(gLMapState);
            return;
        }
        int i6 = this.pivotX;
        int i7 = this.pivotY;
        if (this.isGestureScaleByMapCenter) {
            i6 = this.width >> 1;
            i7 = this.height >> 1;
        }
        if (i6 > 0 || i7 > 0) {
            obtain = IPoint.obtain();
            obtain2 = IPoint.obtain();
            win2geo(gLMapState, i6, i7, obtain);
            gLMapState.setMapGeoCenter(((Point) obtain).x, ((Point) obtain).y);
        } else {
            obtain = null;
            obtain2 = null;
        }
        setMapZoomer(gLMapState);
        if (i6 > 0 || i7 > 0) {
            win2geo(gLMapState, i6, i7, obtain2);
            if (obtain != null) {
                gLMapState.setMapGeoCenter((((Point) obtain).x * 2) - ((Point) obtain2).x, (((Point) obtain).y * 2) - ((Point) obtain2).y);
            }
            gLMapState.recalculate();
        }
        if (obtain != null) {
            obtain.recycle();
        }
        if (obtain2 != null) {
            obtain2.recycle();
        }
    }

    public ScaleGestureMapMessage(int i6, float f6, int i7, int i8) {
        super(i6);
        this.scaleDelta = 0.0f;
        this.pivotX = 0;
        this.pivotY = 0;
        setParams(i6, f6, i7, i8);
    }

    private void setParams(int i6, float f6, int i7, int i8) {
        setState(i6);
        this.scaleDelta = f6;
        this.pivotX = i7;
        this.pivotY = i8;
    }
}
