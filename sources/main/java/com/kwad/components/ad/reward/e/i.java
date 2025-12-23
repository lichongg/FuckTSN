package com.kwad.components.ad.reward.e;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i extends c {
    private static String ux = "IS_FRAUD";
    private static String uy = "IS_FRAUD_ERROR_CODE";
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.g tm;
    private String uv;
    private Map<String, Object> uw = new HashMap();

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void i(boolean z5) {
        super.i(z5);
        KsRewardVideoAd.RewardAdInteractionListener ic = ic();
        if (ic != null) {
            ic.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    private String getUniqueId() {
        return this.uv;
    }

    public final void R(String str) {
        this.uv = str;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setCallerContext(com.kwad.components.ad.reward.g gVar) {
        this.tm = gVar;
    }

    private KsRewardVideoAd.RewardAdInteractionListener ic() {
        return f.N(getUniqueId());
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void cW() {
        super.cW();
        KsRewardVideoAd.RewardAdInteractionListener ic = ic();
        if (ic != null) {
            ic.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final boolean ib() {
        boolean z5;
        KsRewardVideoAd.RewardAdInteractionListener ic = ic();
        if (ic != null) {
            if (com.kwad.sdk.core.response.b.a.dh(com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate))) {
                Map<String, Object> map = this.uw;
                String str = ux;
                if (this.tm.sa == 3) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                map.put(str, Boolean.valueOf(z5));
                this.uw.put(uy, Integer.valueOf(this.tm.sb));
                com.kwad.components.ad.reward.g gVar = this.tm;
                com.kwad.components.ad.reward.monitor.c.d(gVar.mAdTemplate, gVar.sa, gVar.sb);
            }
            try {
                ic.onRewardVerify(this.uw);
            } catch (Throwable unused) {
            }
            ic.onRewardVerify();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_VERIFY, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        if (ic == null) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void onRewardVerify() {
        super.onRewardVerify();
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        super.onVideoPlayEnd();
        KsRewardVideoAd.RewardAdInteractionListener ic = ic();
        if (ic != null) {
            ic.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i6, int i7) {
        super.onVideoPlayError(i6, i7);
        KsRewardVideoAd.RewardAdInteractionListener ic = ic();
        if (ic != null) {
            ic.onVideoPlayError(i6, i7);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        super.onVideoPlayStart();
        KsRewardVideoAd.RewardAdInteractionListener ic = ic();
        if (ic != null) {
            ic.onVideoPlayStart();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j6) {
        super.onVideoSkipToEnd(j6);
        try {
            KsRewardVideoAd.RewardAdInteractionListener ic = ic();
            if (ic != null) {
                ic.onVideoSkipToEnd(j6);
            }
            com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        } catch (Throwable unused) {
        }
    }

    public final boolean i(final int i6, final int i7) {
        KsRewardVideoAd.RewardAdInteractionListener ic = ic();
        if (ic != null) {
            ic.onRewardStepVerify(i6, i7);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_STEP_VERIFY, this.mAdTemplate, new com.kwad.sdk.g.a<RewardMonitorInfo>() { // from class: com.kwad.components.ad.reward.e.i.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(RewardMonitorInfo rewardMonitorInfo) {
                rewardMonitorInfo.setTaskType(i6).setTaskStep(i7);
            }
        });
        return ic != null;
    }
}
