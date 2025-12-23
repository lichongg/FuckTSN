package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MoveGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<MoveGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(1024);
    static int newCount;
    public float touchDeltaX;
    public float touchDeltaY;
    public int touchX;
    public int touchY;

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 0;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static synchronized MoveGestureMapMessage obtain(int i6, float f6, float f7, float f8, float f9) {
        MoveGestureMapMessage acquire;
        synchronized (MoveGestureMapMessage.class) {
            try {
                acquire = M_POOL.acquire();
                if (acquire == null) {
                    acquire = new MoveGestureMapMessage(i6, f6, f7);
                } else {
                    acquire.reset();
                    acquire.setParams(i6, f6, f7);
                }
                acquire.touchX = (int) f8;
                acquire.touchY = (int) f9;
            } catch (Throwable th) {
                throw th;
            }
        }
        return acquire;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        int i6 = (int) this.touchDeltaX;
        int i7 = (int) this.touchDeltaY;
        int i8 = this.touchX - i6;
        int i9 = this.touchY - i7;
        IPoint obtain = IPoint.obtain();
        win2geo(gLMapState, this.touchX, this.touchY, obtain);
        IPoint obtain2 = IPoint.obtain();
        win2geo(gLMapState, i8, i9, obtain2);
        IPoint obtain3 = IPoint.obtain();
        gLMapState.getMapGeoCenter(obtain3);
        gLMapState.setMapGeoCenter(((Point) obtain3).x + (((Point) obtain2).x - ((Point) obtain).x), ((Point) obtain3).y + (((Point) obtain2).y - ((Point) obtain).y));
        gLMapState.recalculate();
        obtain3.recycle();
        obtain.recycle();
        obtain2.recycle();
    }

    public MoveGestureMapMessage(int i6, float f6, float f7) {
        super(i6);
        this.touchX = 0;
        this.touchY = 0;
        this.touchDeltaX = f6;
        this.touchDeltaY = f7;
        newCount++;
    }

    private void setParams(int i6, float f6, float f7) {
        setState(i6);
        this.touchDeltaX = f6;
        this.touchDeltaY = f7;
    }
}
