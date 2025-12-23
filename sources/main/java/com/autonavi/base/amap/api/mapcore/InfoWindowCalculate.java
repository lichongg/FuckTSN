package com.autonavi.base.amap.api.mapcore;

import android.graphics.Rect;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.mapcore.FPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface InfoWindowCalculate {
    boolean checkInBounds();

    IPoint getAnchor();

    BitmapDescriptor getBitmapDescriptor();

    FPoint getGeoPosition();

    int getHeight();

    int getInfoWindowOffsetX();

    int getInfoWindowOffsetY();

    int getRealInfoWindowOffsetX();

    int getRealInfoWindowOffsetY();

    LatLng getRealPosition();

    Rect getRect();

    IPoint getScreenPosition();

    int getWidth();

    boolean isContains();

    boolean isDestory();

    boolean isInfoWindowEnable();

    boolean isViewMode();

    void setInfoWindowOffset(int i6, int i7) throws RemoteException;

    void setInfoWindowShown(boolean z5);
}
