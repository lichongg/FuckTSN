package com.kwad.components.ad.reward;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsRewardVideoAdControl implements com.kwad.components.core.internal.api.a, KsRewardVideoAd {
    private final AdInfo mAdInfo;

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;
    private final AdGlobalConfigInfo rr;
    private com.kwad.components.ad.reward.e.h rs;
    private com.kwad.components.core.j.d rt;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();
    public int rewardType = 1;

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i6) {
        setBidEcpm(i6, -1L);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    private void gr() {
        AdInfo adInfo;
        if (com.kwad.components.ad.reward.c.c.a(this.rs) || (adInfo = this.mAdInfo) == null) {
            return;
        }
        adInfo.adBaseInfo.extraClickReward = false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public List<KSAdInfoData> getKSAdInfoDatas() {
        AdResultData adResultData;
        ArrayList arrayList = new ArrayList();
        if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBw) && (adResultData = this.mAdResultData) != null && adResultData.getAdTemplateList().size() > 0) {
            Iterator<AdTemplate> it = this.mAdResultData.getAdTemplateList().iterator();
            while (it.hasNext()) {
                arrayList.add(com.kwad.sdk.core.response.b.a.dj(com.kwad.sdk.core.response.b.e.el(it.next())));
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.e.Ft()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.response.b.e.eB(this.mAdTemplate) >= 0) {
            return true;
        }
        return com.kwad.components.core.video.k.aL(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void reportAdExposureFailed(int i6, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i6, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(long j6, long j7) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j6;
        com.kwad.sdk.core.adlog.c.m(adTemplate, j7);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener) {
        this.rt = new com.kwad.components.core.j.d(ksInnerAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (this.rs == null) {
            this.rs = new com.kwad.components.ad.reward.e.h() { // from class: com.kwad.components.ad.reward.KsRewardVideoAdControl.1
                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    KsRewardVideoAdControl.this.bz.i(KsRewardVideoAdControl.this);
                }

                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify(Map<String, Object> map) {
                    super.onRewardVerify(map);
                }

                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    KsRewardVideoAdControl.this.bz.h(KsRewardVideoAdControl.this);
                }
            };
        }
        this.rs.b(rewardAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.c.e("KsRewardVideoAdControl", "showRewardVideoAd error, activity is null or finished");
            com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate, "illegal_activity");
            return;
        }
        com.kwad.components.ad.reward.monitor.c.h(true, this.mAdTemplate);
        com.kwad.sdk.commercial.d.c.bK(this.mAdTemplate);
        if (!com.kwad.sdk.core.config.e.Gf() && !isAdEnable()) {
            com.kwad.sdk.core.d.c.i("KsRewardVideoAdControl", "isAdEnable is false");
            com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate, "cache_not_ready");
        } else {
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            a(activity, ksVideoPlayConfig);
        }
    }

    public KsRewardVideoAdControl(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate r5 = com.kwad.sdk.core.response.b.c.r(adResultData);
        this.mAdTemplate = r5;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(r5);
        this.rr = adResultData.adGlobalConfigInfo;
        gq();
    }

    private void a(Activity activity, @NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        gr();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.isNativeRewardPreview) {
            AdRewardPreviewActivityProxy.launch(activity, this.mAdResultData, adTemplate, com.kwad.sdk.core.response.b.a.aS(this.mAdInfo), this.rs);
        } else {
            KSRewardVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.rs, this.rt, this.rewardType);
        }
    }

    private void gq() {
        boolean z5;
        com.kwad.components.ad.i.b.fR().a(this);
        AdGlobalConfigInfo adGlobalConfigInfo = this.rr;
        boolean z6 = false;
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.isNeoScan()) {
            z5 = true;
        } else {
            z5 = false;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.b.a.cf(this.mAdInfo) && !z5) {
            z6 = true;
        }
        adTemplate.isNativeRewardPreview = z6;
    }

    @Keep
    public void setRewardPlayAgainInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
    }
}
