package com.kwad.components.ad.c;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h implements d, KsBannerAd {
    private final KsAdVideoPlayConfig bU = new KSAdVideoPlayConfigImpl();

    @NonNull
    private AdResultData mAdResultData;

    @NonNull
    private AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.api.KsBannerAd
    public final void setBidEcpm(int i6) {
        setBidEcpm(i6, -1L);
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final boolean supportPushAd() {
        return false;
    }

    @Override // com.kwad.components.ad.c.d
    public final void b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.e.Ft()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final View getView(Context context, KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (context == null || !l.Cf().Bn()) {
            return null;
        }
        com.kwad.sdk.commercial.d.c.bK(this.mAdTemplate);
        i iVar = new i(context, this.mAdResultData, ksAdVideoPlayConfig);
        iVar.setBannerAdListener(bannerAdInteractionListener);
        iVar.setBannerUpdateAdResultDataListener(this);
        return iVar;
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final void reportAdExposureFailed(int i6, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i6, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final void setBidEcpm(long j6, long j7) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j6;
        com.kwad.sdk.core.adlog.c.m(adTemplate, j7);
    }

    public h(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }
}
