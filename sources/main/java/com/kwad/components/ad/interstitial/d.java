package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.a.h;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bv;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends g {
    private com.kwad.components.ad.interstitial.h.a kM;
    private boolean kN;
    private com.kwad.components.ad.interstitial.g.b kO;

    @NonNull
    private final KsAdVideoPlayConfig kP;
    private KsInterstitialAd.AdInteractionListener kQ;
    private final com.kwad.components.core.widget.g kR;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    private bv mTimerHelper;

    @Override // com.kwad.components.core.proxy.g
    public final float dv() {
        return 0.0f;
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx() {
        com.kwad.components.ad.interstitial.h.a bVar = e(this.mAdResultData) ? new com.kwad.components.ad.interstitial.aggregate.b(this.mContext) : new com.kwad.components.ad.interstitial.h.c(this.mContext);
        this.kM = bVar;
        bVar.a(this.mAdResultData, this, this.kP, this.kQ, 0);
        this.CC.removeAllViews();
        this.CC.addView(this.kM);
        dy();
    }

    private void dy() {
        com.kwad.components.ad.interstitial.g.b bVar = new com.kwad.components.ad.interstitial.g.b(this.kM, 100);
        this.kO = bVar;
        bVar.a(new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.interstitial.d.2
            @Override // com.kwad.sdk.core.j.c
            public final void bt() {
                d.this.getTimerHelper().Sl();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bu() {
                d.this.getTimerHelper().Sm();
            }
        });
        this.kO.wi();
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup dw() {
        com.kwad.components.core.widget.f fVar = new com.kwad.components.core.widget.f(this.mContext);
        fVar.setOrientationChangeListener(this.kR);
        return fVar;
    }

    public final bv getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bv();
        }
        return this.mTimerHelper;
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.kQ = adInteractionListener;
        com.kwad.components.ad.interstitial.h.a aVar = this.kM;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }

    public d(@NonNull Activity activity, @NonNull AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        boolean z5;
        this.kR = new com.kwad.components.core.widget.g() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.core.widget.g
            public final void k(boolean z6) {
                if (d.this.kN) {
                    Activity activity2 = d.this.mActivity;
                    com.kwad.sdk.core.c.b.Ho();
                    if (activity2 == com.kwad.sdk.core.c.b.getCurrentActivity()) {
                        com.kwad.sdk.core.adlog.c.i(d.this.mAdTemplate, z6 ? 2 : 1);
                        d.this.dx();
                    }
                }
            }
        };
        this.kQ = adInteractionListener;
        KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
        if (ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.kP = builder.videoSoundEnable(z5).dataFlowAutoStart(com.kwad.components.ad.interstitial.b.b.dH()).build();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    private static boolean e(AdResultData adResultData) {
        return com.kwad.sdk.core.response.b.c.u(adResultData);
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            com.kwad.sdk.a.a.c.CU().CX();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.kQ;
            if (adInteractionListener != null) {
                adInteractionListener.onPageDismiss();
            }
            com.kwad.components.ad.interstitial.h.a aVar = this.kM;
            if ((aVar instanceof com.kwad.components.ad.interstitial.h.c) && !((com.kwad.components.ad.interstitial.h.c) aVar).fd() && com.kwad.sdk.core.response.b.a.cS(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate))) {
                com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, (int) Math.ceil(getTimerHelper().getTime() / 1000.0f));
            }
            h.oR();
            com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.d.be(this.mAdTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        h.a(getWindow());
        dx();
        com.kwad.components.ad.interstitial.report.c.eS().A(this.mAdTemplate);
        com.kwad.sdk.commercial.d.c.bL(this.mAdTemplate);
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.b.b.dL()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.g.b bVar = this.kO;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        this.kN = z5;
        com.kwad.components.ad.interstitial.h.a aVar = this.kM;
        if (aVar != null) {
            if (z5) {
                aVar.dA();
            } else {
                aVar.dB();
            }
        }
    }
}
