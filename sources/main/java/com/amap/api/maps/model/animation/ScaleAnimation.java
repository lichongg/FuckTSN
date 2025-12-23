package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLScaleAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class ScaleAnimation extends Animation {

    @JBindingInclude
    private float mFromX;

    @JBindingInclude
    private float mFromY;

    @JBindingInclude
    private float mPivotX;

    @JBindingInclude
    private float mPivotY;

    @JBindingInclude
    private float mToX;

    @JBindingInclude
    private float mToY;

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "ScaleAnimation";
    }

    public ScaleAnimation(float f6, float f7, float f8, float f9) {
        this.glAnimation = new GLScaleAnimation(f6, f7, f8, f9);
        this.mFromX = f6;
        this.mToX = f7;
        this.mFromY = f8;
        this.mToY = f9;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        setFillMode(1);
    }
}
