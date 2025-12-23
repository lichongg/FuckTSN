package com.autonavi.amap.api.mapcore;

import android.graphics.Point;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IGLMapState {
    float calculateMapZoomer(int i6, int i7, int i8, int i9, int i10);

    float getCameraDegree();

    float getMapAngle();

    DPoint getMapGeoCenter();

    void getMapGeoCenter(IPoint iPoint);

    float getMapZoomer();

    void recalculate();

    void recycle();

    void screenToP20Point(int i6, int i7, Point point);

    void setCameraDegree(float f6);

    void setMapAngle(float f6);

    void setMapGeoCenter(double d6, double d7);

    void setMapZoomer(float f6);
}
