package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLTranslateAnimation extends GLAnimation {
    public double mToXDelta;
    public double mToYDelta;
    public double mFromXDelta = 0.0d;
    public double mFromYDelta = 0.0d;
    public double mCurXDelta = 0.0d;
    public double mCurYDelta = 0.0d;

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f6, GLTransformation gLTransformation) {
        double d6 = this.mFromXDelta;
        this.mCurXDelta = d6;
        double d7 = this.mFromYDelta;
        this.mCurYDelta = d7;
        double d8 = this.mToXDelta;
        if (d6 != d8) {
            this.mCurXDelta = d6 + ((d8 - d6) * f6);
        }
        double d9 = this.mToYDelta;
        if (d7 != d9) {
            this.mCurYDelta = d7 + ((d9 - d7) * f6);
        }
        gLTransformation.f9905x = this.mCurXDelta;
        gLTransformation.f9906y = this.mCurYDelta;
    }

    public void setFromPoint(LatLng latLng) {
        this.mFromXDelta = latLng.longitude;
        this.mFromYDelta = latLng.latitude;
    }

    public GLTranslateAnimation(LatLng latLng) {
        this.mToXDelta = 0.0d;
        this.mToYDelta = 0.0d;
        this.mToXDelta = latLng.longitude;
        this.mToYDelta = latLng.latitude;
    }
}
