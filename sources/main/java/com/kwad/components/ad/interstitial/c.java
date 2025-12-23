package com.kwad.components.ad.interstitial;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInterstitialAd;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c implements com.kwad.components.ad.interstitial.e.b {

    @Nullable
    private KsInterstitialAd.AdInteractionListener kL;

    public final void a(@Nullable KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.kL = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClicked() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kL;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.components.ad.fullscreen.h
    public void onAdClosed() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kL;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.components.ad.fullscreen.h
    public void onAdShow() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kL;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onPageDismiss() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kL;
        if (adInteractionListener != null) {
            adInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onSkippedAd() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kL;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayEnd() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kL;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoPlayEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayError(int i6, int i7) {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kL;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoPlayError(i6, i7);
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoPlayStart() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kL;
        if (adInteractionListener != null) {
            adInteractionListener.onVideoPlayStart();
        }
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        onSkippedAd();
    }
}
