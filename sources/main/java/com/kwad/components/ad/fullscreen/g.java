package com.kwad.components.ad.fullscreen;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.k;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsFullScreenVideoAd {
    private c jw;

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final boolean isAdEnable() {
        if (com.kwad.sdk.core.response.b.e.eB(this.mAdTemplate) >= 0) {
            return true;
        }
        return k.aL(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        if (this.jw == null) {
            this.jw = new c() { // from class: com.kwad.components.ad.fullscreen.g.1
                @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    g.this.bz.i(g.this);
                }

                @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    g.this.bz.h(g.this);
                }
            };
        }
        this.jw.a(fullScreenVideoAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.c.e("KsFullScreenVideoAdControl", "showFullScreenVideoAd error, activity is null or finished");
            com.kwad.components.ad.reward.monitor.c.b(false, this.mAdTemplate, "illegal_activity");
            return;
        }
        com.kwad.components.ad.reward.monitor.c.h(false, this.mAdTemplate);
        com.kwad.sdk.commercial.d.c.bK(this.mAdTemplate);
        if (!com.kwad.sdk.core.config.e.Gf() && !isAdEnable()) {
            com.kwad.sdk.core.d.c.i("KsFullScreenVideoAdControl", "isAdEnable is false");
            com.kwad.components.ad.reward.monitor.c.b(false, this.mAdTemplate, "cache_not_ready");
        } else {
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            KsFullScreenVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.jw);
        }
    }

    public g(@NonNull AdResultData adResultData) {
        super(adResultData);
        com.kwad.components.ad.i.b.fR().a(this);
    }
}
