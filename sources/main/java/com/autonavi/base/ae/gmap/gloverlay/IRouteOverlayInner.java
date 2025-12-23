package com.autonavi.base.ae.gmap.gloverlay;

import android.util.Pair;
import com.amap.api.col.p0003l.eq;
import com.amap.api.col.p0003l.er;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.RouteOverlay;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IRouteOverlayInner {
    void addRouteItem(int i6, er[] erVarArr, int i7, eq eqVar, int[] iArr);

    void addRouteName();

    Pair<Float, Float> getDisplayRange();

    int getOverlayProperty();

    boolean isVisible();

    void remove();

    void removeRouteName();

    void setArrow3DTexture(BitmapDescriptor bitmapDescriptor);

    void setArrowFlow(boolean z5);

    void setCar2DPosition(int i6, float f6);

    void setCar3DPosition(int i6, float f6);

    void setDisplayRange(float f6, float f7);

    void setHighlightParam(RouteOverlay.RouteOverlayHighLightParam routeOverlayHighLightParam);

    void setHighlightType(int i6);

    void setLine2DWidth(int i6, int i7);

    void setLineWidthScale(float f6);

    void setOverlayProperty(int i6);

    void setRouteItemParam(er erVar);

    void setSelectStatus(boolean z5);

    void setShowArrow(boolean z5);

    void setShowNaviRouteNameCountMap(Map<Integer, Integer> map);

    void setVisible(boolean z5);
}
