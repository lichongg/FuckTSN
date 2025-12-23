package com.autonavi.amap.mapcore.animation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLAlphaAnimation extends GLAnimation {
    public float mCurAlpha = 0.0f;
    public float mFromAlpha;
    public float mToAlpha;

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f6, GLTransformation gLTransformation) {
        float f7 = this.mFromAlpha;
        float f8 = f7 + ((this.mToAlpha - f7) * f6);
        this.mCurAlpha = f8;
        gLTransformation.alpha = f8;
    }

    public GLAlphaAnimation(float f6, float f7) {
        this.mFromAlpha = f6;
        this.mToAlpha = f7;
    }
}
