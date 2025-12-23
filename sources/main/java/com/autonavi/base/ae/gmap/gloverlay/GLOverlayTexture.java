package com.autonavi.base.ae.gmap.gloverlay;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLOverlayTexture {
    public int mAnchor;
    public float mAnchorXRatio;
    public float mAnchorYRatio;
    public int mHeight;
    public int mResHeight;
    public int mResId;
    public int mResWidth;
    public int mWidth;

    public GLOverlayTexture(int i6, int i7, int i8, int i9) {
        this.mResId = i6;
        this.mWidth = i8;
        this.mHeight = i9;
        this.mResWidth = i8;
        this.mResHeight = i9;
        this.mAnchor = i7;
    }

    public GLOverlayTexture(int i6, int i7, float f6, float f7, int i8, int i9) {
        this.mResId = i6;
        this.mWidth = i8;
        this.mHeight = i9;
        this.mResWidth = i8;
        this.mResHeight = i9;
        this.mAnchor = i7;
        this.mAnchorXRatio = f6;
        this.mAnchorYRatio = f7;
    }
}
