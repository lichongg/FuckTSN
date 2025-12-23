package com.autonavi.amap.mapcore.interfaces;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IMapConfig {
    int getAbroadState();

    int getAnchorX();

    int getAnchorY();

    int getMapHeight();

    int getMapWidth();

    float getMapZoomScale();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    double getSX();

    double getSY();

    float getSZ();

    boolean isAbroadEnable();

    boolean isTerrainEnable();

    void setAbroadEnable(boolean z5);

    void setAbroadState(int i6);

    void setTerrainEnable(boolean z5);
}
