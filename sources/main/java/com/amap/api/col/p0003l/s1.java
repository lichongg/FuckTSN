package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s1 implements IInfoWindowManager, IInfoWindowAction {

    /* renamed from: a, reason: collision with root package name */
    private final Context f7204a;

    /* renamed from: b, reason: collision with root package name */
    private final IGlOverlayLayer f7205b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7206c = "PopupOverlay";

    /* renamed from: d, reason: collision with root package name */
    a0 f7207d;

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void hideInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.f7205b;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "hideInfoWindow", null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void setInfoWindowAdapterManager(a0 a0Var) {
        synchronized (this) {
            this.f7207d = a0Var;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void showInfoWindow(BasePointOverlay basePointOverlay) throws RemoteException {
        IGlOverlayLayer iGlOverlayLayer = this.f7205b;
        if (iGlOverlayLayer != null && basePointOverlay != null) {
            iGlOverlayLayer.getNativeProperties(basePointOverlay.getId(), "showInfoWindow", new Object[]{basePointOverlay.getId()});
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        IGlOverlayLayer iGlOverlayLayer = this.f7205b;
        if (iGlOverlayLayer != null && motionEvent != null) {
            Object nativeProperties = iGlOverlayLayer.getNativeProperties("PopupOverlay", "onInfoWindowTap", new Object[]{Double.valueOf(motionEvent.getX()), Double.valueOf(motionEvent.getY())});
            if (nativeProperties instanceof Boolean) {
                return ((Boolean) nativeProperties).booleanValue();
            }
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void redrawInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.f7205b;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "redrawInfoWindow", null);
        }
    }

    public s1(IGlOverlayLayer iGlOverlayLayer, Context context) {
        this.f7204a = context;
        this.f7205b = iGlOverlayLayer;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowAppearAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackColor(int i6) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackEnable(boolean z5) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowDisappearAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowMovingAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void startAnimation() {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackScale(float f6, float f7) {
    }
}
