package com.amap.api.maps;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class InfoWindowAnimationManager {

    /* renamed from: a, reason: collision with root package name */
    IInfoWindowManager f8951a;

    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
        this.f8951a.setInfoWindowAnimation(animation, animationListener);
    }

    public void setInfoWindowAppearAnimation(Animation animation) {
        this.f8951a.setInfoWindowAppearAnimation(animation);
    }

    public void setInfoWindowBackColor(int i6) {
        this.f8951a.setInfoWindowBackColor(i6);
    }

    public void setInfoWindowBackEnable(boolean z5) {
        this.f8951a.setInfoWindowBackEnable(z5);
    }

    public void setInfoWindowBackScale(float f6, float f7) {
        this.f8951a.setInfoWindowBackScale(f6, f7);
    }

    public void setInfoWindowDisappearAnimation(Animation animation) {
        this.f8951a.setInfoWindowDisappearAnimation(animation);
    }

    public void setInfoWindowMovingAnimation(Animation animation) {
        this.f8951a.setInfoWindowMovingAnimation(animation);
    }

    public void startAnimation() {
        this.f8951a.startAnimation();
    }

    public InfoWindowAnimationManager(IInfoWindowManager iInfoWindowManager) {
        this.f8951a = iInfoWindowManager;
    }
}
