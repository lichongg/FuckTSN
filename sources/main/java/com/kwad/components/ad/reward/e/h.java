package com.kwad.components.ad.reward.e;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h implements KsRewardVideoAd.RewardAdInteractionListener {

    @Nullable
    private KsRewardVideoAd.RewardAdInteractionListener uu;

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.uu;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify();
        }
    }

    public final void b(@Nullable KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.uu = rewardAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.uu;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onExtraRewardVerify(int i6) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.uu;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onExtraRewardVerify(i6);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.uu;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardStepVerify(int i6, int i7) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.uu;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardStepVerify(i6, i7);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.uu;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoPlayEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i6, int i7) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.uu;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoPlayError(i6, i7);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        try {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.uu;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoPlayStart();
            }
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoSkipToEnd(long j6) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.uu;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoSkipToEnd(j6);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(Map<String, Object> map) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.uu;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify(map);
        }
    }
}
