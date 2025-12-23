package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLRotateAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class RotateAnimation extends Animation {

    @JBindingInclude
    private float mFromDegrees;

    @JBindingInclude
    private float mToDegrees;

    public RotateAnimation(float f6, float f7, float f8, float f9, float f10) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(f6, f7, f8, f9, f10);
        this.mFromDegrees = f6;
        this.mToDegrees = f7;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "RotateAnimation";
    }

    public RotateAnimation(float f6, float f7) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(f6, f7, 0.0f, 0.0f, 0.0f);
        this.mFromDegrees = f6;
        this.mToDegrees = f7;
    }
}
