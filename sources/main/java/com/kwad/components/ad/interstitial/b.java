package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private com.kwad.components.core.internal.api.c bz;
    private c kI;
    private d kJ;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(@NonNull KsInterstitialAd.AdInteractionListener adInteractionListener) {
        if (this.kI == null) {
            this.kI = new c() { // from class: com.kwad.components.ad.interstitial.b.1
                @Override // com.kwad.components.ad.interstitial.c, com.kwad.components.ad.fullscreen.h
                public final void onAdShow() {
                    super.onAdShow();
                    com.kwad.components.ad.interstitial.report.a.eO().v(b.this.mAdTemplate);
                    b.this.bz.h(b.this);
                }

                @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    com.kwad.components.ad.interstitial.report.a.eO().w(b.this.mAdTemplate);
                    b.this.bz.i(b.this);
                }
            };
        }
        this.kI.a(adInteractionListener);
        d dVar = this.kJ;
        if (dVar != null) {
            dVar.setAdInteractionListener(this.kI);
        }
    }

    public b(@NonNull AdResultData adResultData) {
        super(adResultData);
        this.bz = new com.kwad.components.core.internal.api.c();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, @Nullable KsVideoPlayConfig ksVideoPlayConfig) {
        com.kwad.components.ad.interstitial.report.c.eS().y(this.mAdTemplate);
        if (com.kwad.sdk.core.config.e.EV() && (activity == null || activity.isFinishing())) {
            com.kwad.sdk.core.c.b.Ho();
            activity = com.kwad.sdk.core.c.b.getCurrentActivity();
        }
        if (activity != null && !activity.isFinishing()) {
            if (!l.Cf().Bn()) {
                com.kwad.components.ad.interstitial.report.c eS = com.kwad.components.ad.interstitial.report.c.eS();
                AdTemplate adTemplate = this.mAdTemplate;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEx;
                eS.a(adTemplate, eVar.errorCode, eVar.msg);
                com.kwad.sdk.core.d.c.e("InterstitialAdControl", "showInterstitialAd please init sdk first");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            com.kwad.sdk.commercial.d.c.bK(this.mAdTemplate);
            this.mAdTemplate.adShowStartTimeStamp = SystemClock.elapsedRealtime();
            if (ksVideoPlayConfig.isVideoSoundEnable()) {
                this.mAdTemplate.mInitVoiceStatus = 2;
            } else {
                this.mAdTemplate.mInitVoiceStatus = 1;
            }
            com.kwad.sdk.a.a.c.CU().bm(true);
            if (this.kJ == null) {
                try {
                    d dVar = new d(activity, this.mAdResultData, ksVideoPlayConfig, this.kI);
                    this.kJ = dVar;
                    dVar.show();
                    com.kwad.components.ad.interstitial.c.b.J(activity);
                } catch (Throwable th) {
                    com.kwad.components.ad.interstitial.report.realtime.a.eW();
                    com.kwad.components.ad.interstitial.report.realtime.a.a(th.getMessage(), this.mAdTemplate);
                }
                com.kwad.components.ad.interstitial.report.c.eS().z(this.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.sdk.core.d.c.e("InterstitialAdControl", "showInterstitialAd activity must not be null");
        com.kwad.components.ad.interstitial.report.realtime.a.eW();
        com.kwad.components.ad.interstitial.report.realtime.a.G(this.mAdTemplate);
        com.kwad.components.ad.interstitial.report.c eS2 = com.kwad.components.ad.interstitial.report.c.eS();
        AdTemplate adTemplate2 = this.mAdTemplate;
        com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aEw;
        eS2.a(adTemplate2, eVar2.errorCode, eVar2.msg);
    }
}
