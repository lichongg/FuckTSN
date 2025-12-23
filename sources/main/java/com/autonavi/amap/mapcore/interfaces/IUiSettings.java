package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IUiSettings {
    float getLogoMarginRate(int i6) throws RemoteException;

    int getLogoPosition() throws RemoteException;

    int getZoomPosition() throws RemoteException;

    boolean isCompassEnabled() throws RemoteException;

    boolean isGestureScaleByMapCenter() throws RemoteException;

    boolean isIndoorSwitchEnabled() throws RemoteException;

    boolean isLogoEnable();

    boolean isMyLocationButtonEnabled() throws RemoteException;

    boolean isRotateGesturesEnabled() throws RemoteException;

    boolean isScaleControlsEnabled() throws RemoteException;

    boolean isScrollGesturesEnabled() throws RemoteException;

    boolean isTiltGesturesEnabled() throws RemoteException;

    boolean isZoomControlsEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    boolean isZoomInByScreenCenter() throws RemoteException;

    void requestRefreshLogo();

    void setAllGesturesEnabled(boolean z5) throws RemoteException;

    void setCompassEnabled(boolean z5) throws RemoteException;

    void setGestureScaleByMapCenter(boolean z5) throws RemoteException;

    void setIndoorSwitchEnabled(boolean z5) throws RemoteException;

    void setLogoBottomMargin(int i6) throws RemoteException;

    void setLogoEnable(boolean z5);

    void setLogoLeftMargin(int i6) throws RemoteException;

    void setLogoMarginRate(int i6, float f6) throws RemoteException;

    void setLogoPosition(int i6) throws RemoteException;

    void setMyLocationButtonEnabled(boolean z5) throws RemoteException;

    void setRotateGesturesEnabled(boolean z5) throws RemoteException;

    void setScaleControlsEnabled(boolean z5) throws RemoteException;

    void setScrollGesturesEnabled(boolean z5) throws RemoteException;

    void setTiltGesturesEnabled(boolean z5) throws RemoteException;

    void setZoomControlsEnabled(boolean z5) throws RemoteException;

    void setZoomGesturesEnabled(boolean z5) throws RemoteException;

    void setZoomInByScreenCenter(boolean z5) throws RemoteException;

    void setZoomPosition(int i6) throws RemoteException;
}
