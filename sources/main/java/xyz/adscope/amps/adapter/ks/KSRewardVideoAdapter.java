package xyz.adscope.amps.adapter.ks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback;
import xyz.adscope.amps.adapter.ks.model.BidResponseModel;
import xyz.adscope.amps.adapter.ks.util.KSBiddingRequestUtil;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class KSRewardVideoAdapter extends AMPSRewardAdapter {
    private static final String KS_EXTRA_DATA_KEY = "extraData";
    private static final String KS_THIRD_USER_ID_KEY = "thirdUserId";
    private KsRewardVideoAd ksRewardVideoAd;
    private String mBidResponse;
    private BidResponseModel mBidResponseModel;
    private String mBidResponseV2;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSRewardVideoAdAdapterListener);
        if (isC2SAdSource() && this.ksRewardVideoAd != null) {
            onAdLoad();
        } else {
            initSDK();
            loadRewardVideoAd();
        }
    }

    private void loadRewardVideoAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK start loadRewardVideoAd spaceId:" + this.mSpaceId);
        HashMap hashMap = new HashMap();
        hashMap.put(KS_THIRD_USER_ID_KEY, this.mUserId);
        hashMap.put(KS_EXTRA_DATA_KEY, this.mExtra);
        KsScene.Builder rewardCallbackExtraData = new KsScene.Builder(Long.parseLong(this.mSpaceId)).screenOrientation(!this.isLandScape ? 1 : 2).rewardCallbackExtraData(hashMap);
        if (!TextUtils.isEmpty(this.mBidResponse)) {
            rewardCallbackExtraData.setBidResponse(this.mBidResponse);
        } else if (!TextUtils.isEmpty(this.mBidResponseV2)) {
            rewardCallbackExtraData.setBidResponseV2(this.mBidResponseV2);
        }
        KsAdSDK.getLoadManager().loadRewardVideoAd(rewardCallbackExtraData.build(), new KsLoadManager.RewardVideoAdListener() { // from class: xyz.adscope.amps.adapter.ks.KSRewardVideoAdapter.1
            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onError code:" + i6 + " message:" + str);
                KSRewardVideoAdapter.this.onAdFailed(String.valueOf(i6), str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onRewardVideoAdLoad");
                KSRewardVideoAdapter.this.onRewardVideoCached();
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onRewardVideoResult");
                if (list == null || list.size() < 1) {
                    KSRewardVideoAdapter kSRewardVideoAdapter = KSRewardVideoAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    kSRewardVideoAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                KSRewardVideoAdapter.this.ksRewardVideoAd = list.get(0);
                KSRewardVideoAdapter.this.setKSRewardVideoAdListener();
                int ecpm = KSRewardVideoAdapter.this.ksRewardVideoAd != null ? KSRewardVideoAdapter.this.ksRewardVideoAd.getECPM() : 0;
                if (KSRewardVideoAdapter.this.isC2SAdSource()) {
                    KSRewardVideoAdapter.this.onC2SBiddingSuccess(ecpm);
                } else {
                    KSRewardVideoAdapter.this.onAdLoad();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKSRewardVideoAdListener() {
        KsRewardVideoAd ksRewardVideoAd = this.ksRewardVideoAd;
        if (ksRewardVideoAd != null) {
            ksRewardVideoAd.setInnerAdInteractionListener(new KsInnerAd.KsInnerAdInteractionListener() { // from class: xyz.adscope.amps.adapter.ks.KSRewardVideoAdapter.2
                @Override // com.kwad.sdk.api.KsInnerAd.KsInnerAdInteractionListener
                public void onAdClicked(KsInnerAd ksInnerAd) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onAdClicked");
                    KSRewardVideoAdapter.this.onAdClicked();
                }

                @Override // com.kwad.sdk.api.KsInnerAd.KsInnerAdInteractionListener
                public void onAdShow(KsInnerAd ksInnerAd) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onAdShow");
                    KSRewardVideoAdapter.this.onAdShow();
                }
            });
            this.ksRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: xyz.adscope.amps.adapter.ks.KSRewardVideoAdapter.3
                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onRewardVerify");
                    KSRewardVideoAdapter.this.onRewardArrived(true, 0, null);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onAdClicked() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onAdClicked");
                    KSRewardVideoAdapter.this.onAdClicked();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onExtraRewardVerify(int i6) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onExtraRewardVerify i:" + i6);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onPageDismiss() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onPageDismiss");
                    KSRewardVideoAdapter.this.onAdDismiss();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardStepVerify(int i6, int i7) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onRewardStepVerify");
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify(Map<String, Object> map) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayEnd() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onVideoPlayEnd");
                    KSRewardVideoAdapter.this.onVideoComplete();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayError(int i6, int i7) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onVideoPlayError");
                    KSRewardVideoAdapter.this.onVideoError();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayStart() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onVideoPlayStart");
                    KSRewardVideoAdapter.this.onAdShow();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoSkipToEnd(long j6) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onVideoSkipToEnd");
                }
            });
        }
    }

    private void startS2SBidding() {
        KSBiddingRequestUtil.getBidResponse(this.mServerUrl, this.mAccountId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.ks.KSRewardVideoAdapter.4
            @Override // xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                KSRewardVideoAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                KSRewardVideoAdapter.this.mBidResponseModel = bidResponseModel;
                KSRewardVideoAdapter.this.mBidResponse = str;
                KSRewardVideoAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        KsRewardVideoAd ksRewardVideoAd = this.ksRewardVideoAd;
        if (ksRewardVideoAd != null) {
            return ksRewardVideoAd.getMediaExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.ksRewardVideoAd != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsRewardVideoAd ksRewardVideoAd = this.ksRewardVideoAd;
            if (ksRewardVideoAd != null && aMPSBidResult != null) {
                KSAdManagerHolder.sendLossNotification(ksRewardVideoAd, aMPSBidResult);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsRewardVideoAd ksRewardVideoAd = this.ksRewardVideoAd;
            if (ksRewardVideoAd == null) {
                return;
            }
            int ecpm = ksRewardVideoAd.getECPM();
            if (isC2SAdSource()) {
                KSAdManagerHolder.sendWinNotification(this.ksRewardVideoAd, ecpm);
            } else if (isS2SAdSource()) {
                KSBiddingRequestUtil.sendWinNotice(this.mBidResponseModel);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        if (this.ksRewardVideoAd == null || activity == null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        } else {
            this.ksRewardVideoAd.showRewardVideoAd(activity, new KsVideoPlayConfig.Builder().showLandscape(this.isLandScape).videoSoundEnable(this.isVolumeOn).build());
        }
    }

    private void initSDK() {
        KSInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.ksRewardVideoAd = null;
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
        if (isC2SAdSource()) {
            loadRewardVideoAd();
        } else if (isS2SAdSource()) {
            startS2SBidding();
        }
    }
}
