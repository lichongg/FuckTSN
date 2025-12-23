package xyz.adscope.amps.ad.interstitial;

import xyz.adscope.amps.base.AMPSBaseListener;
import xyz.adscope.amps.common.AMPSError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSInterstitialAdListener implements AMPSBaseListener {
    public abstract void onInterstitialAdClicked();

    public abstract void onInterstitialAdClose();

    public abstract void onInterstitialAdLoadFail(AMPSError aMPSError);

    public abstract void onInterstitialAdLoaded();

    public abstract void onInterstitialAdShow();

    public abstract void onInterstitialAdVideoEnd();

    public abstract void onInterstitialAdVideoError(AMPSError aMPSError);

    public abstract void onInterstitialAdVideoStart();
}
