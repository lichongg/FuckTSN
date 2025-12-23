package xyz.adscope.amps.ad.interstitial.adapter;

import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSInterstitialAdAdapterListener<T> extends AMPSBaseAdAdapterListener {
    void onSkippedAd();

    void onVideoPlayEnd();

    void onVideoPlayStart();
}
