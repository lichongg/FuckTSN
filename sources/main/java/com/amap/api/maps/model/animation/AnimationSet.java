package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class AnimationSet extends Animation {

    @JBindingInclude
    private List<Animation> mAnimations = new ArrayList();

    @JBindingInclude
    private boolean shareInterpolator;

    public void addAnimation(Animation animation) {
        ((GLAnimationSet) this.glAnimation).addAnimation(animation);
        this.mAnimations.add(animation);
    }

    public void cleanAnimation() {
        ((GLAnimationSet) this.glAnimation).cleanAnimation();
        this.mAnimations.clear();
    }

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "AnimationSet";
    }

    public AnimationSet(boolean z5) {
        this.shareInterpolator = false;
        this.glAnimation = new GLAnimationSet(z5);
        this.shareInterpolator = z5;
    }
}
