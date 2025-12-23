package com.autonavi.base.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.col.p0003l.a0;
import com.amap.api.col.p0003l.u8;
import com.amap.api.maps.AMap;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.extra.b;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IAMapDelegate extends IAMap {
    void addGestureMapMessage(int i6, AbstractGestureMapMessage abstractGestureMapMessage);

    void addOverlayTexture(int i6, GLTextureProperty gLTextureProperty);

    void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j6, AMap.CancelableCallback cancelableCallback);

    boolean canShowIndoorSwitch();

    void changeGLOverlayIndex();

    void changeLogoIconStyle(String str, boolean z5, int i6);

    void changeMapLogo(int i6, boolean z5);

    void changeSize(int i6, int i7);

    void changeSurface(int i6, GL10 gl10, int i7, int i8);

    float checkZoomLevel(float f6) throws RemoteException;

    void clearTileCache();

    String createId(String str);

    int createOverlayTexture(int i6, Bitmap bitmap);

    void createSurface(int i6, GL10 gl10, EGLConfig eGLConfig);

    void geo2Latlng(int i6, int i7, DPoint dPoint);

    void geo2Map(int i6, int i7, FPoint fPoint);

    b getAMapExtraInterfaceManager();

    float getCameraDegree(int i6);

    CameraPosition getCameraPositionPrj(boolean z5);

    Context getContext();

    u8 getCustomStyleManager();

    int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo);

    float[] getFinalMatrix();

    GLMapEngine getGLMapEngine();

    View getGLMapView();

    void getGeoCenter(int i6, IPoint iPoint);

    IGlOverlayLayer getGlOverlayLayer();

    a0 getInfoWindowDelegate();

    void getLatLng2Map(double d6, double d7, FPoint fPoint);

    void getLatLng2Pixel(double d6, double d7, IPoint iPoint);

    float getLogoMarginRate(int i6);

    int getLogoPosition();

    float getMapAngle(int i6);

    LatLngBounds getMapBounds(LatLng latLng, float f6, float f7, float f8);

    MapConfig getMapConfig();

    GLMapState getMapProjection();

    float getMapZoomScale();

    int getMaskLayerType();

    AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException;

    void getPixel2Geo(int i6, int i7, IPoint iPoint);

    void getPixel2LatLng(int i6, int i7, DPoint dPoint);

    float getPreciseLevel(int i6);

    IProjectionDelegate getProjection() throws RemoteException;

    Rect getRect();

    IUiSettingsDelegate getUiSettings();

    float getUnitLengthByZoom(int i6);

    Point getWaterMarkerPositon();

    float getZoomLevel();

    void hideInfoWindow();

    boolean isLockMapAngle(int i6);

    boolean isLockMapCameraDegree(int i6);

    boolean isUseAnchor();

    void latlon2Geo(double d6, double d7, IPoint iPoint);

    void map2Geo(float f6, float f7, IPoint iPoint);

    void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam);

    boolean onDoubleTap(int i6, MotionEvent motionEvent);

    void onLongPress(int i6, MotionEvent motionEvent);

    void onPause();

    void onResume();

    boolean onSingleTapConfirmed(int i6, MotionEvent motionEvent);

    void pixel2Map(int i6, int i7, PointF pointF);

    void post(Runnable runnable);

    void redrawInfoWindow();

    void refreshLogo();

    void reloadMapCustomStyle();

    void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay);

    boolean removeGLModel(String str);

    boolean removeGLOverlay(String str) throws RemoteException;

    void resetRenderTimeLongLong();

    void setCustomMapStyle(boolean z5, byte[] bArr);

    void setGestureStatus(int i6, int i7);

    void setHideLogoEnble(boolean z5);

    void setLogoBottomMargin(int i6);

    void setLogoLeftMargin(int i6);

    void setLogoMarginRate(int i6, float f6);

    void setLogoPosition(int i6);

    void setMapCustomEnable(boolean z5, boolean z6);

    void setMapEnable(boolean z5);

    void setMapWidgetListener(AMapWidgetListener aMapWidgetListener);

    void setTerrainAuth(boolean z5);

    void setZoomPosition(int i6);

    void showCompassEnabled(boolean z5);

    void showIndoorSwitchControlsEnabled(boolean z5);

    void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException;

    void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException;

    void showLogoEnabled(boolean z5);

    void showMyLocationButtonEnabled(boolean z5);

    void showMyLocationOverlay(Location location) throws RemoteException;

    void showScaleEnabled(boolean z5);

    void showZoomControlsEnabled(boolean z5);

    float toMapLenWithWin(int i6);

    void zoomOut(int i6);
}
