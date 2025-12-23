package xyz.adscope.amps.adapter.bz;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.RewardedVideoAd;
import com.beizi.fusion.RewardedVideoAdListener;
import java.util.Map;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BZRewardVideoAdapter extends AMPSRewardAdapter {
    private RewardedVideoAd mRewardedVideoAd;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSRewardVideoAdAdapterListener);
        if (!this.isBidding || this.mRewardedVideoAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    private void loadRewardVideoAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK start loadRewardVideoAd spaceId:" + this.mSpaceId);
        RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(this.mContext, this.mSpaceId, new RewardedVideoAdListener() { // from class: xyz.adscope.amps.adapter.bz.BZRewardVideoAdapter.1
            @Override // com.beizi.fusion.RewardedVideoAdListener
            public void onRewarded() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadRewardVideoAd onRewarded");
                BZRewardVideoAdapter.this.onRewardArrived(true, 0, null);
            }

            @Override // com.beizi.fusion.RewardedVideoAdListener
            public void onRewardedVideoAdClosed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadRewardVideoAd onAdClosed ");
                BZRewardVideoAdapter.this.onAdDismiss();
            }

            @Override // com.beizi.fusion.RewardedVideoAdListener
            public void onRewardedVideoAdFailedToLoad(int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadRewardVideoAd onRewardedVideoAdFailedToLoad code:" + i6);
                BZRewardVideoAdapter.this.onAdFailed(String.valueOf(i6), "");
            }

            @Override // com.beizi.fusion.RewardedVideoAdListener
            public void onRewardedVideoAdLoaded() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadRewardVideoAd onRewardedVideoAdLoaded ");
                int i6 = 0;
                try {
                    int ecpm = BZRewardVideoAdapter.this.mRewardedVideoAd != null ? BZRewardVideoAdapter.this.mRewardedVideoAd.getECPM() : 0;
                    if (ecpm >= 0) {
                        i6 = ecpm;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                BZRewardVideoAdapter bZRewardVideoAdapter = BZRewardVideoAdapter.this;
                if (bZRewardVideoAdapter.isBidding) {
                    bZRewardVideoAdapter.onC2SBiddingSuccess(i6);
                } else {
                    bZRewardVideoAdapter.onAdLoad();
                }
            }

            @Override // com.beizi.fusion.RewardedVideoAdListener
            public void onRewardedVideoAdShown() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadRewardVideoAd onAdShown ");
                BZRewardVideoAdapter.this.onAdShow();
            }

            @Override // com.beizi.fusion.RewardedVideoAdListener
            public void onRewardedVideoClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadRewardVideoAd onAdClicked ");
                BZRewardVideoAdapter.this.onAdClicked();
            }

            @Override // com.beizi.fusion.RewardedVideoAdListener
            public void onRewardedVideoComplete() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadRewardVideoAd onRewardedVideoComplete");
                BZRewardVideoAdapter.this.onVideoComplete();
            }
        }, (long) this.mTimeout, 2);
        this.mRewardedVideoAd = rewardedVideoAd;
        rewardedVideoAd.loadAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
        this.mRewardedVideoAd = null;
        super.destroy();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public String getMediaCustomExtraInfo() {
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        if (rewardedVideoAd == null) {
            return super.getMediaCustomExtraInfo();
        }
        String customExtraData = rewardedVideoAd.getCustomExtraData();
        return TextUtils.isEmpty(customExtraData) ? super.getMediaCustomExtraInfo() : customExtraData;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mRewardedVideoAd != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        Map<String, String> lossInfo;
        try {
            if (this.mRewardedVideoAd != null && aMPSBidResult != null && (lossInfo = BZInitMediation.getInstance().getLossInfo(aMPSBidResult)) != null) {
                this.mRewardedVideoAd.sendLossNotificationWithInfo(lossInfo);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        Map<String, String> winInfo;
        try {
            if (this.mRewardedVideoAd != null && aMPSBidResult != null && (winInfo = BZInitMediation.getInstance().getWinInfo(aMPSBidResult)) != null) {
                this.mRewardedVideoAd.sendWinNotificationWithInfo(winInfo);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        if (rewardedVideoAd != null && activity != null) {
            rewardedVideoAd.showAd(activity);
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        BZInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadRewardVideoAd();
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
