package com.autonavi.amap.mapcore.animation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLRotateAnimation extends GLAnimation {
    private float mFromDegrees;
    private float mToDegrees;

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f6, GLTransformation gLTransformation) {
        float f7 = this.mFromDegrees;
        gLTransformation.rotate = f7 + ((this.mToDegrees - f7) * f6);
    }

    public GLRotateAnimation(float f6, float f7, float f8, float f9, float f10) {
        this.mFromDegrees = f6;
        this.mToDegrees = f7;
    }
}
