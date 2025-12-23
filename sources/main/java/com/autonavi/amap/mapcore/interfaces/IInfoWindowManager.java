package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IInfoWindowManager {
    void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener);

    void setInfoWindowAppearAnimation(Animation animation);

    void setInfoWindowBackColor(int i6);

    void setInfoWindowBackEnable(boolean z5);

    void setInfoWindowBackScale(float f6, float f7);

    void setInfoWindowDisappearAnimation(Animation animation);

    void setInfoWindowMovingAnimation(Animation animation);

    void startAnimation();
}
