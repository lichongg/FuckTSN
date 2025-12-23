package xyz.adscope.amps.ad.interstitial;

import android.content.Context;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSInterstitialOpenApiManager extends AMPSBaseOpenApiManager implements AMPSInterstitialAdAdapterListener {
    private AMPSInterstitialLoadEventListener ampsIntersititialLoadEventListener;

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener
    public void onSkippedAd() {
        AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener = this.ampsIntersititialLoadEventListener;
        if (aMPSInterstitialLoadEventListener != null) {
            aMPSInterstitialLoadEventListener.onAmpsSkippedAd();
        }
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener
    public void onVideoPlayEnd() {
        AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener = this.ampsIntersititialLoadEventListener;
        if (aMPSInterstitialLoadEventListener != null) {
            aMPSInterstitialLoadEventListener.onAmpsVideoPlayEnd();
        }
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener
    public void onVideoPlayStart() {
        AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener = this.ampsIntersititialLoadEventListener;
        if (aMPSInterstitialLoadEventListener != null) {
            aMPSInterstitialLoadEventListener.onAmpsVideoPlayStart();
        }
    }

    public void refreshLoadEventListener(AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener) {
        this.ampsIntersititialLoadEventListener = aMPSInterstitialLoadEventListener;
        refreshListener(aMPSInterstitialLoadEventListener);
    }

    public AMPSInterstitialOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSInterstitialLoadEventListener);
        this.ampsIntersititialLoadEventListener = aMPSInterstitialLoadEventListener;
    }
}
