package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class AlphaAnimation extends Animation {

    @JBindingInclude
    private float mFromAlpha;

    @JBindingInclude
    private float mToAlpha;

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "AlphaAnimation";
    }

    public AlphaAnimation(float f6, float f7) {
        this.mFromAlpha = 0.0f;
        this.mToAlpha = 1.0f;
        this.glAnimation = new GLAlphaAnimation(f6, f7);
        this.mFromAlpha = f6;
        this.mToAlpha = f7;
    }
}
