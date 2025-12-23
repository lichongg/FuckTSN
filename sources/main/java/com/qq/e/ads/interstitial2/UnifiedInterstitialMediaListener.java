package com.qq.e.ads.interstitial2;

import com.qq.e.comm.util.AdError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface UnifiedInterstitialMediaListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoading();

    void onVideoPageClose();

    void onVideoPageOpen();

    void onVideoPause();

    void onVideoReady(long j6);

    void onVideoStart();
}
