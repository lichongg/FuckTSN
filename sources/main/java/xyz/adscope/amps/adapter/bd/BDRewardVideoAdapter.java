package xyz.adscope.amps.adapter.bd;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import java.util.HashMap;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BDRewardVideoAdapter extends AMPSRewardAdapter {
    private RewardVideoAd mRewardVideoAd;
    private RewardVideoAd.RewardVideoAdListener mRewardVideoAdListener = new RewardVideoAd.RewardVideoAdListener() { // from class: xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter.3
        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClick() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClick");
            BDRewardVideoAdapter.this.onAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClose(float f6) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClose");
            BDRewardVideoAdapter.this.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdFailed(String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdFailed message:" + str);
            BDRewardVideoAdapter.this.onAdFailed(AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_FAIL.getErrorCode(), str);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdLoaded() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdLoaded");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdShow() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdShow");
            BDRewardVideoAdapter.this.onAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdSkip(float f6) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdSkip");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        public void onRewardVerify(boolean z5) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onRewardVerify flag:" + z5);
            BDRewardVideoAdapter.this.onRewardArrived(z5, 0, null);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onVideoDownloadFailed");
            BDRewardVideoAdapter bDRewardVideoAdapter = BDRewardVideoAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_CACHE_FAIL;
            bDRewardVideoAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadSuccess() {
            int i6 = 0;
            boolean isReady = BDRewardVideoAdapter.this.mRewardVideoAd != null ? BDRewardVideoAdapter.this.mRewardVideoAd.isReady() : false;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdCacheSuccess isReady:" + isReady);
            if (!isReady) {
                BDRewardVideoAdapter bDRewardVideoAdapter = BDRewardVideoAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_FAIL;
                bDRewardVideoAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                return;
            }
            try {
                if (BDRewardVideoAdapter.this.mRewardVideoAd != null) {
                    i6 = Integer.parseInt(BDRewardVideoAdapter.this.mRewardVideoAd.getECPMLevel());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BDRewardVideoAdapter bDRewardVideoAdapter2 = BDRewardVideoAdapter.this;
            if (bDRewardVideoAdapter2.isBidding) {
                bDRewardVideoAdapter2.onC2SBiddingSuccess(i6);
            } else {
                bDRewardVideoAdapter2.onAdLoad();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void playCompletion() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK playCompletion");
            BDRewardVideoAdapter.this.onVideoComplete();
        }
    };

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSRewardVideoAdAdapterListener);
        if (!this.isBidding || this.mRewardVideoAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    private void loadRewardVideoAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK start loadRewardVideoAd spaceId:" + this.mSpaceId);
        RewardVideoAd rewardVideoAd = new RewardVideoAd(this.mContext, this.mSpaceId, this.mRewardVideoAdListener);
        this.mRewardVideoAd = rewardVideoAd;
        rewardVideoAd.setUserId(this.mUserId);
        this.mRewardVideoAd.setExtraInfo(this.mExtra);
        this.mRewardVideoAd.load();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd == null) {
            return false;
        }
        return rewardVideoAd.isReady();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            if (this.mRewardVideoAd != null && aMPSBidResult != null) {
                this.mRewardVideoAd.biddingFail(BDInitMediation.getInstance().getWinInfo(aMPSBidResult), new BiddingListener() { // from class: xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter.2
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public void onBiddingResult(boolean z5, String str, HashMap<String, Object> hashMap) {
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            if (this.mRewardVideoAd != null && aMPSBidResult != null) {
                this.mRewardVideoAd.biddingSuccess(BDInitMediation.getInstance().getSecondInfo(aMPSBidResult), new BiddingListener() { // from class: xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter.1
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public void onBiddingResult(boolean z5, String str, HashMap<String, Object> hashMap) {
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd != null && activity != null && rewardVideoAd.isReady()) {
            this.mRewardVideoAd.show();
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        BDInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadRewardVideoAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.mRewardVideoAd = null;
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
