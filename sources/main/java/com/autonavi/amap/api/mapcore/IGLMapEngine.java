package com.autonavi.amap.api.mapcore;

import com.amap.api.maps.AMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IGLMapEngine {
    void addGroupAnimation(int i6, int i7, float f6, int i8, int i9, int i10, int i11, AMap.CancelableCallback cancelableCallback);

    IGLMapState getNewMapState(int i6);
}
