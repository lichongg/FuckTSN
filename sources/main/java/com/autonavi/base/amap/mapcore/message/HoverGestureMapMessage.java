package com.autonavi.base.amap.mapcore.message;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class HoverGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<HoverGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta;

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 3;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static HoverGestureMapMessage obtain(int i6, float f6) {
        HoverGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            acquire = new HoverGestureMapMessage(i6, f6);
        } else {
            acquire.reset();
        }
        acquire.setParams(i6, f6);
        return acquire;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public HoverGestureMapMessage(int i6, float f6) {
        super(i6);
        this.angleDelta = f6;
    }

    private void setParams(int i6, float f6) {
        setState(i6);
        this.angleDelta = f6;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        float cameraDegree = gLMapState.getCameraDegree() + this.angleDelta;
        if (cameraDegree < 0.0f) {
            cameraDegree = 0.0f;
        } else if (cameraDegree > 80.0f) {
            cameraDegree = 80.0f;
        } else if (gLMapState.getCameraDegree() > 40.0f && cameraDegree > 40.0f && gLMapState.getCameraDegree() > cameraDegree) {
            cameraDegree = 40.0f;
        }
        gLMapState.setCameraDegree(cameraDegree);
        gLMapState.recalculate();
    }
}
