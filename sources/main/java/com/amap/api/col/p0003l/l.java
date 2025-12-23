package com.amap.api.col.p0003l;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class l extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        float f6 = this.xPixel;
        float f7 = (this.width / 2.0f) + f6;
        float f8 = (this.height / 2.0f) + this.yPixel;
        a(iGLMapState, (int) f7, (int) f8, new Point());
        iGLMapState.setMapGeoCenter(r1.x, r1.y);
    }

    private static void a(IGLMapState iGLMapState, int i6, int i7, Point point) {
        iGLMapState.screenToP20Point(i6, i7, point);
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }
}
