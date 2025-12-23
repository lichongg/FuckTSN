package com.autonavi.base.ae.gmap.gloverlay;

import android.util.Pair;
import com.amap.api.col.p0003l.eq;
import com.amap.api.col.p0003l.er;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.RouteOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BaseRouteOverlay extends GLOverlay implements IRouteOverlayInner {
    private static native void nativeAddRouteItem(long j6, int i6, er[] erVarArr, int i7, eq eqVar, int[] iArr);

    private static native void nativeAddRouteName(long j6);

    private static native void nativeRemoveRouteName(long j6, long j7);

    private static native void nativeSetArrow3DTexture(long j6, int i6);

    private static native void nativeSetArrowFlow(long j6, boolean z5);

    private static native void nativeSetCar2DPosition(long j6, int i6, float f6);

    private static native void nativeSetCar3DPosition(long j6, int i6, float f6);

    private static native void nativeSetHighlightParam(long j6, int[] iArr);

    private static native void nativeSetHighlightType(long j6, int i6);

    private static native void nativeSetLine2DWidth(long j6, int i6, int i7);

    private static native void nativeSetLineWidthScale(long j6, float f6);

    private static native void nativeSetRouteItemParam(long j6, er erVar);

    private static native void nativeSetSelectStatus(long j6, boolean z5);

    private static native void nativeSetShowArrow(long j6, boolean z5);

    private static native void nativeSetShowNaviRouteNameCountMap(long j6, int[] iArr, int[] iArr2);

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public Pair<Float, Float> getDisplayRange() {
        return null;
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public int getOverlayProperty() {
        return 0;
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void addRouteItem(int i6, er[] erVarArr, int i7, eq eqVar, int[] iArr) {
        int createOverlayTexture;
        int createOverlayTexture2;
        int createOverlayTexture3;
        if (this.mNativeInstance == 0) {
            return;
        }
        for (er erVar : erVarArr) {
            if (erVar == null) {
                return;
            }
            BitmapDescriptor bitmapDescriptor = erVar.f6156a;
            if (bitmapDescriptor != null && (createOverlayTexture3 = this.mGLMapView.createOverlayTexture(this.mEngineID, bitmapDescriptor.getBitmap())) >= 0) {
                erVar.f6157b = createOverlayTexture3;
            }
            BitmapDescriptor bitmapDescriptor2 = erVar.f6158c;
            if (bitmapDescriptor2 != null && (createOverlayTexture2 = this.mGLMapView.createOverlayTexture(this.mEngineID, bitmapDescriptor2.getBitmap())) >= 0) {
                erVar.f6159d = createOverlayTexture2;
            }
            BitmapDescriptor bitmapDescriptor3 = erVar.f6160e;
            if (bitmapDescriptor3 != null && (createOverlayTexture = this.mGLMapView.createOverlayTexture(this.mEngineID, bitmapDescriptor3.getBitmap())) >= 0) {
                erVar.f6161f = createOverlayTexture;
            }
        }
        nativeAddRouteItem(this.mNativeInstance, i6, erVarArr, i7, eqVar, iArr);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void addRouteName() {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeAddRouteName(j6);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.GLOverlay
    void releaseInstance() {
        long j6 = this.mNativeInstance;
        this.mNativeInstance = 0L;
        this.mGLMapView.getGLMapEngine().destroyOverlay(this.mEngineID, j6);
        super.releaseInstance();
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void removeRouteName() {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeRemoveRouteName(j6, this.mGLMapView.getGLMapEngine().getNativeInstance());
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setArrow3DTexture(BitmapDescriptor bitmapDescriptor) {
        int createOverlayTexture;
        if (this.mNativeInstance == 0 || bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || (createOverlayTexture = this.mGLMapView.createOverlayTexture(this.mEngineID, bitmapDescriptor.getBitmap())) < 0) {
            return;
        }
        nativeSetArrow3DTexture(this.mNativeInstance, createOverlayTexture);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setArrowFlow(boolean z5) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetArrowFlow(j6, z5);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setCar2DPosition(int i6, float f6) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetCar2DPosition(j6, i6, f6);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setCar3DPosition(int i6, float f6) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetCar3DPosition(j6, i6, f6);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setHighlightParam(RouteOverlay.RouteOverlayHighLightParam routeOverlayHighLightParam) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetHighlightParam(j6, new int[]{routeOverlayHighLightParam.fillColorHightLight, routeOverlayHighLightParam.borderColorHightLight, routeOverlayHighLightParam.fillColorNormal, routeOverlayHighLightParam.borderColorNormal, routeOverlayHighLightParam.arrowColorNormal});
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setHighlightType(int i6) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetHighlightType(j6, i6);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setLine2DWidth(int i6, int i7) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetLine2DWidth(j6, i6, i7);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setLineWidthScale(float f6) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetLineWidthScale(j6, f6);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setRouteItemParam(er erVar) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetRouteItemParam(j6, erVar);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setSelectStatus(boolean z5) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetSelectStatus(j6, z5);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setShowArrow(boolean z5) {
        long j6 = this.mNativeInstance;
        if (j6 == 0) {
            return;
        }
        nativeSetShowArrow(j6, z5);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setShowNaviRouteNameCountMap(Map<Integer, Integer> map) {
        if (this.mNativeInstance == 0) {
            return;
        }
        int[] iArr = new int[map.size()];
        int[] iArr2 = new int[map.size()];
        int i6 = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            iArr[i6] = entry.getKey().intValue();
            iArr2[i6] = entry.getValue().intValue();
            i6++;
        }
        nativeSetShowNaviRouteNameCountMap(this.mNativeInstance, iArr, iArr2);
    }

    public BaseRouteOverlay(final int i6, IAMapDelegate iAMapDelegate, int i7) {
        super(i6, iAMapDelegate, i7);
        IAMapDelegate iAMapDelegate2 = this.mGLMapView;
        if (iAMapDelegate2 != null && iAMapDelegate2.getGLMapEngine() != null) {
            this.mGLMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.BaseRouteOverlay.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseRouteOverlay baseRouteOverlay = BaseRouteOverlay.this;
                    baseRouteOverlay.mNativeInstance = baseRouteOverlay.mGLMapView.getGLMapEngine().createOverlay(i6, GLOverlay.EAMapOverlayTpye.AMAPROUTE_OVERLAY.getId());
                }
            });
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void remove() {
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setOverlayProperty(int i6) {
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setDisplayRange(float f6, float f7) {
    }
}
