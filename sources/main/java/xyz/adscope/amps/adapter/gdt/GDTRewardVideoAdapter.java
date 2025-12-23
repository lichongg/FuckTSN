package xyz.adscope.amps.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback;
import xyz.adscope.amps.adapter.gdt.model.BidResponseModel;
import xyz.adscope.amps.adapter.gdt.util.GDTBiddingRequestUtil;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GDTRewardVideoAdapter extends AMPSRewardAdapter {
    private BidResponseModel mBidResponseModel;
    private RewardVideoAD mRewardVideoAD;
    private String mToken;
    private RewardVideoADListener rewardVideoADListener = new RewardVideoADListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTRewardVideoAdapter.2
        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onADClick");
            GDTRewardVideoAdapter.this.onAdClicked();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onADClose");
            GDTRewardVideoAdapter.this.onAdDismiss();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onADExpose");
            GDTRewardVideoAdapter.this.onAdShow();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onADLoad");
            int ecpm = GDTRewardVideoAdapter.this.mRewardVideoAD != null ? GDTRewardVideoAdapter.this.mRewardVideoAD.getECPM() : 0;
            if (GDTRewardVideoAdapter.this.isC2SAdSource()) {
                GDTRewardVideoAdapter.this.onC2SBiddingSuccess(ecpm);
            } else {
                GDTRewardVideoAdapter.this.onAdLoad();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onADShow");
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            String str;
            String str2;
            if (adError != null) {
                str = String.valueOf(adError.getErrorCode());
                str2 = adError.getErrorMsg();
            } else {
                str = "";
                str2 = "";
            }
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideo onRewardVideoLoadFail code:" + str + " message:" + str2);
            GDTRewardVideoAdapter.this.onAdFailed(str, str2);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onReward map:" + map);
            GDTRewardVideoAdapter.this.onRewardArrived(true, 0, map);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onVideoCached");
            GDTRewardVideoAdapter.this.onRewardVideoCached();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onVideoComplete");
            GDTRewardVideoAdapter.this.onVideoComplete();
        }
    };

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSRewardVideoAdAdapterListener);
        if (isC2SAdSource() && this.mRewardVideoAD != null) {
            onAdLoad();
        } else {
            initSDK();
            loadRewardVideoAd();
        }
    }

    private void loadRewardVideoAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK start loadRewardVideoAd spaceId:" + this.mSpaceId);
        if (TextUtils.isEmpty(this.mToken)) {
            this.mRewardVideoAD = new RewardVideoAD(this.mContext, this.mSpaceId, this.rewardVideoADListener, this.isVolumeOn);
        } else {
            this.mRewardVideoAD = new RewardVideoAD(this.mContext, this.mSpaceId, this.rewardVideoADListener, this.isVolumeOn, this.mToken);
        }
        this.mRewardVideoAD.setNegativeFeedbackListener(new NegativeFeedbackListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTRewardVideoAdapter.1
            @Override // com.qq.e.comm.listeners.NegativeFeedbackListener
            public void onComplainSuccess() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onComplainSuccess");
            }
        });
        this.mRewardVideoAD.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setCustomData(this.mExtra).setUserId(this.mUserId).build());
        this.mRewardVideoAD.loadAD();
    }

    private void startS2SBidding() {
        GDTBiddingRequestUtil.getBidResponse(this.mContext, this.mServerUrl, this.mAppId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.gdt.GDTRewardVideoAdapter.3
            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                GDTRewardVideoAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                if (bidResponseModel == null) {
                    return;
                }
                GDTRewardVideoAdapter.this.mToken = str;
                GDTRewardVideoAdapter.this.mBidResponseModel = bidResponseModel;
                GDTRewardVideoAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        RewardVideoAD rewardVideoAD = this.mRewardVideoAD;
        if (rewardVideoAD != null) {
            return rewardVideoAD.getExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        RewardVideoAD rewardVideoAD = this.mRewardVideoAD;
        if (rewardVideoAD == null) {
            return false;
        }
        return rewardVideoAD.isValid();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        if (aMPSBidResult == null) {
            return;
        }
        try {
            if (!isC2SAdSource()) {
                if (isS2SAdSource()) {
                    GDTBiddingRequestUtil.sendLossNotice(this.mBidResponseModel, aMPSBidResult.getEcpm(), aMPSBidResult.getReason(), this.mPublicKey);
                }
            } else {
                RewardVideoAD rewardVideoAD = this.mRewardVideoAD;
                if (rewardVideoAD == null) {
                    return;
                }
                GDTAdManagerHolder.sendLossNotification(rewardVideoAD, aMPSBidResult.getReason());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            RewardVideoAD rewardVideoAD = this.mRewardVideoAD;
            if (rewardVideoAD == null) {
                return;
            }
            int ecpm = rewardVideoAD.getECPM();
            if (isC2SAdSource()) {
                GDTAdManagerHolder.sendWinNotification(this.mRewardVideoAD, ecpm);
            } else if (isS2SAdSource()) {
                GDTBiddingRequestUtil.sendWinNotice(this.mBidResponseModel, this.mPublicKey);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        RewardVideoAD rewardVideoAD = this.mRewardVideoAD;
        if (rewardVideoAD != null && activity != null && rewardVideoAD.isValid()) {
            this.mRewardVideoAD.showAD(activity);
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        GDTInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.mRewardVideoAD = null;
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
