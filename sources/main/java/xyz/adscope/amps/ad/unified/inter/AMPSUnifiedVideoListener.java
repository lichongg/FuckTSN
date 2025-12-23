package xyz.adscope.amps.ad.unified.inter;

import xyz.adscope.amps.ad.unified.AMPSUnifiedNativeAdError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSUnifiedVideoListener {
    void onVideoClicked();

    void onVideoCompleted();

    void onVideoError(AMPSUnifiedNativeAdError aMPSUnifiedNativeAdError);

    void onVideoInit();

    void onVideoLoaded(int i6);

    void onVideoLoading();

    void onVideoPause();

    void onVideoReady();

    void onVideoResume();

    void onVideoStart();

    void onVideoStop();
}
