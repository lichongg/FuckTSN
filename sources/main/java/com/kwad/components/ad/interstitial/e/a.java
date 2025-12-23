package com.kwad.components.ad.interstitial.e;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.components.ad.fullscreen.g;
import com.kwad.components.ad.interstitial.c;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private final boolean ma;
    private g mb;
    private com.kwad.components.ad.interstitial.b mc;

    @NonNull
    private final c md;

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.md.a(adInteractionListener);
        if (this.ma) {
            this.mb.setFullScreenVideoAdInteractionListener(this.md);
        } else {
            this.mc.setAdInteractionListener(this.md);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (this.ma) {
            this.mb.showFullScreenVideoAd(activity, ksVideoPlayConfig);
        } else {
            this.mc.showInterstitialAd(activity, ksVideoPlayConfig);
        }
    }

    public a(boolean z5, @NonNull AdResultData adResultData) {
        super(adResultData);
        this.ma = z5;
        if (z5) {
            this.mb = new g(adResultData);
        } else {
            this.mc = new com.kwad.components.ad.interstitial.b(adResultData);
        }
        this.md = new c();
    }
}
