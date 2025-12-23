package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class SplashAdExtraData {
    private boolean isDisableRotate;
    private boolean isDisableShake;
    private boolean isDisableSlide;

    public boolean getDisableRotateStatus() {
        return this.isDisableRotate;
    }

    public boolean getDisableShakeStatus() {
        return this.isDisableShake;
    }

    public boolean getDisableSlideStatus() {
        return this.isDisableSlide;
    }

    public void setDisableRotateStatus(boolean z5) {
        this.isDisableRotate = z5;
    }

    public void setDisableShakeStatus(boolean z5) {
        this.isDisableShake = z5;
    }

    public void setDisableSlideStatus(boolean z5) {
        this.isDisableSlide = z5;
    }
}
