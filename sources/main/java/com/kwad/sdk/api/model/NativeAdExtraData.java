package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class NativeAdExtraData {
    private boolean enableRotate = true;
    private boolean enableShake;
    private int showLiveStatus;
    private int showLiveStyle;

    public int getShowLiveStatus() {
        return this.showLiveStatus;
    }

    public int getShowLiveStyle() {
        return this.showLiveStyle;
    }

    public boolean isEnableRotate() {
        return this.enableRotate;
    }

    public boolean isEnableShake() {
        return this.enableShake;
    }

    public NativeAdExtraData setEnableRotate(boolean z5) {
        this.enableRotate = z5;
        return this;
    }

    public NativeAdExtraData setEnableShake(boolean z5) {
        this.enableShake = z5;
        return this;
    }

    public NativeAdExtraData setShowLiveStatus(int i6) {
        this.showLiveStatus = i6;
        return this;
    }

    public NativeAdExtraData setShowLiveStyle(int i6) {
        this.showLiveStyle = i6;
        return this;
    }
}
