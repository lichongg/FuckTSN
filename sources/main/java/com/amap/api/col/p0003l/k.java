package com.amap.api.col.p0003l;

import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        DPoint dPoint = this.geoPoint;
        if (dPoint == null) {
            dPoint = abstractCameraUpdateMessage.geoPoint;
        }
        abstractCameraUpdateMessage.geoPoint = dPoint;
        abstractCameraUpdateMessage.zoom = Float.isNaN(this.zoom) ? abstractCameraUpdateMessage.zoom : this.zoom;
        abstractCameraUpdateMessage.bearing = Float.isNaN(this.bearing) ? abstractCameraUpdateMessage.bearing : this.bearing;
        abstractCameraUpdateMessage.tilt = Float.isNaN(this.tilt) ? abstractCameraUpdateMessage.tilt : this.tilt;
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        normalChange(iGLMapState);
    }
}
