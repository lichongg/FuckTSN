package com.autonavi.base.amap.mapcore.message;

import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.AbstractMapMessage;
import com.autonavi.base.ae.gmap.GLMapState;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class AbstractGestureMapMessage extends AbstractMapMessage {
    public int anchorX;
    public int anchorY;
    private int state;
    public int width = 0;
    public int height = 0;
    public boolean isGestureScaleByMapCenter = false;
    public boolean isUseAnchor = false;

    @Override // com.autonavi.base.ae.gmap.AbstractMapMessage
    public abstract int getType();

    public void reset() {
        this.width = 0;
        this.height = 0;
        this.state = 0;
        this.isGestureScaleByMapCenter = false;
        this.isUseAnchor = false;
        this.anchorX = 0;
        this.anchorY = 0;
    }

    public abstract void runCameraUpdate(GLMapState gLMapState);

    public int getMapGestureState() {
        return this.state;
    }

    public void setState(int i6) {
        this.state = i6;
    }

    public AbstractGestureMapMessage(int i6) {
        this.state = i6;
    }

    protected IPoint getAnchorGeoPoint(GLMapState gLMapState, int i6, int i7) {
        IPoint obtain = IPoint.obtain();
        gLMapState.screenToP20Point(i6, i7, obtain);
        return obtain;
    }

    protected void win2geo(GLMapState gLMapState, int i6, int i7, IPoint iPoint) {
        gLMapState.screenToP20Point(i6, i7, iPoint);
    }
}
