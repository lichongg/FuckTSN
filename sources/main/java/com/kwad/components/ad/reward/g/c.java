package com.kwad.components.ad.reward.g;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.RewardLoadCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.components.core.t.f;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private long jn;
    private KsLoadManager.RewardVideoAdListener uM;

    public final void c(AdTemplate adTemplate, @Nullable List<KsRewardVideoAd> list) {
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS_BEFORE, this.jn, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataLoadTraceElement = f.a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.uM;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoResult(list);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS, this.jn, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void d(AdTemplate adTemplate, @Nullable List<KsRewardVideoAd> list) {
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS_BEFORE, this.jn, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataCacheTraceElement = f.a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.uM;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoAdLoad(list);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS, this.jn, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void onError(int i6, String str) {
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.uM;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onError(i6, str);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) null, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_ERROR, this.jn, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public c(long j6, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        this.jn = j6;
        this.uM = rewardVideoAdListener;
    }
}
