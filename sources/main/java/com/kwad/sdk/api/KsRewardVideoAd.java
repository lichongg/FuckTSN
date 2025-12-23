package com.kwad.sdk.api;

import android.app.Activity;
import androidx.annotation.Keep;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.api.model.KsExtraRewardType;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public interface KsRewardVideoAd extends BaseKSAd {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsAdSdkApi
    @Keep
    public interface RewardAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onExtraRewardVerify(@KsExtraRewardType int i6);

        @KsAdSdkApi
        @Keep
        void onPageDismiss();

        @KsAdSdkApi
        @Keep
        void onRewardStepVerify(int i6, int i7);

        @KsAdSdkApi
        @Keep
        void onRewardVerify();

        @KsAdSdkApi
        @Keep
        void onRewardVerify(Map<String, Object> map);

        @KsAdSdkApi
        @Keep
        void onVideoPlayEnd();

        @KsAdSdkApi
        @Keep
        void onVideoPlayError(int i6, int i7);

        @KsAdSdkApi
        @Keep
        void onVideoPlayStart();

        @KsAdSdkApi
        @Keep
        void onVideoSkipToEnd(long j6);
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @KsAdSdkApi
    @Keep
    List<KSAdInfoData> getKSAdInfoDatas();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    boolean isAdEnable();

    @KsAdSdkApi
    @Keep
    void reportAdExposureFailed(int i6, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Keep
    @Deprecated
    void setBidEcpm(int i6);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(long j6, long j7);

    @KsAdSdkApi
    @Keep
    void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener);

    @KsAdSdkApi
    @Keep
    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    @KsAdSdkApi
    @Keep
    void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
