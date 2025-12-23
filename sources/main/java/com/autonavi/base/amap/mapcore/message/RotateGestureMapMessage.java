package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RotateGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<RotateGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta;
    public int pivotX;
    public int pivotY;

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 2;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static RotateGestureMapMessage obtain(int i6, float f6, int i7, int i8) {
        RotateGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new RotateGestureMapMessage(i6, f6, i7, i8);
        }
        acquire.reset();
        acquire.setParams(i6, f6, i7, i8);
        return acquire;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint obtain;
        IPoint obtain2;
        float mapAngle = gLMapState.getMapAngle() + this.angleDelta;
        if (this.isGestureScaleByMapCenter) {
            gLMapState.setMapAngle(mapAngle);
            gLMapState.recalculate();
            return;
        }
        int i6 = this.pivotX;
        int i7 = this.pivotY;
        if (this.isUseAnchor) {
            i6 = this.anchorX;
            i7 = this.anchorY;
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
        gLMapState.setMapAngle(mapAngle);
        gLMapState.recalculate();
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

    public RotateGestureMapMessage(int i6, float f6, int i7, int i8) {
        super(i6);
        this.pivotX = 0;
        this.pivotY = 0;
        this.angleDelta = 0.0f;
        setParams(i6, f6, i7, i8);
        this.angleDelta = f6;
        this.pivotX = i7;
        this.pivotY = i8;
    }

    private void setParams(int i6, float f6, int i7, int i8) {
        setState(i6);
        this.angleDelta = f6;
        this.pivotX = i7;
        this.pivotY = i8;
    }
}
