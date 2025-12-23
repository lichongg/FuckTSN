package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IAMapListener {
    void afterAnimation();

    void afterDrawFrame(int i6, GLMapState gLMapState);

    void afterDrawLabel(int i6, GLMapState gLMapState);

    void afterRendererOver(int i6, GLMapState gLMapState);

    void beforeDrawLabel(int i6, GLMapState gLMapState);

    void onMapBlankClick(double d6, double d7);

    void onMapPOIClick(MapPoi mapPoi);
}
