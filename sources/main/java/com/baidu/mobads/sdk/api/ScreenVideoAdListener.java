package com.baidu.mobads.sdk.api;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface ScreenVideoAdListener {
    void onAdClick();

    void onAdClose(float f6);

    void onAdFailed(String str);

    void onAdLoaded();

    void onAdShow();

    void onAdSkip(float f6);

    void onVideoDownloadFailed();

    void onVideoDownloadSuccess();

    void playCompletion();
}
