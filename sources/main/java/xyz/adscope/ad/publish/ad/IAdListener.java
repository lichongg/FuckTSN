package xyz.adscope.ad.publish.ad;

import xyz.adscope.ad.d2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IAdListener extends d2 {
    void onAdClicked();

    void onAdClosed();

    void onAdExposure();

    @Override // xyz.adscope.ad.d2
    /* synthetic */ void onAdLoadFailed(int i6, String str);

    void onAdLoaded();

    void onAdShown();

    void onRenderSuccess();
}
