package com.autonavi.amap.mapcore.animation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f6, GLTransformation gLTransformation) {
        float f7 = this.mFromX;
        float f8 = (f7 == 1.0f && this.mToX == 1.0f) ? 1.0f : f7 + ((this.mToX - f7) * f6);
        float f9 = this.mFromY;
        float f10 = (f9 == 1.0f && this.mToY == 1.0f) ? 1.0f : ((this.mToY - f9) * f6) + f9;
        gLTransformation.scaleX = f8;
        gLTransformation.scaleY = f10;
    }

    public GLScaleAnimation(float f6, float f7, float f8, float f9) {
        this.mFromX = f6;
        this.mToX = f7;
        this.mFromY = f8;
        this.mToY = f9;
    }
}
