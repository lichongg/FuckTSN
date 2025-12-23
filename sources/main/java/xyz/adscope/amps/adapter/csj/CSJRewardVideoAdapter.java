package xyz.adscope.amps.adapter.csj;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.Map;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class CSJRewardVideoAdapter extends AMPSRewardAdapter {
    private TTAdNative csjAdNative;
    private TTRewardVideoAd csjRewardVideoAd;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSRewardVideoAdAdapterListener);
        initSDK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadRewardVideoAd() {
        StringBuilder a6 = a.a("CSJSDK start loadRewardVideoAd  spaceId:");
        a6.append(this.mSpaceId);
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a6.toString());
        this.csjAdNative = CSJInitMediation.get().createAdNative(this.mContext);
        this.csjAdNative.loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdLoadType(TTAdLoadType.LOAD).setUserData(this.mExtra).setUserID(this.mUserId).setIsAutoPlay(this.isAutoPlay).build(), new TTAdNative.RewardVideoAdListener() { // from class: xyz.adscope.amps.adapter.csj.CSJRewardVideoAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onError code:" + i6 + " message:" + str);
                CSJRewardVideoAdapter.this.onAdFailed(String.valueOf(i6), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onRewardVideoAdLoad");
                try {
                    CSJRewardVideoAdapter.this.csjRewardVideoAd = tTRewardVideoAd;
                    CSJRewardVideoAdapter.this.csjRewardVideoAd.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: xyz.adscope.amps.adapter.csj.CSJRewardVideoAdapter.2.1
                        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                        public void onAdClose() {
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onAdClose");
                            CSJRewardVideoAdapter.this.onAdDismiss();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                        public void onAdShow() {
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onAdShow");
                            CSJRewardVideoAdapter.this.onAdShow();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                        public void onAdVideoBarClick() {
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onAdVideoBarClick");
                            CSJRewardVideoAdapter.this.onAdClicked();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                        public void onRewardArrived(boolean z5, int i6, Bundle bundle) {
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onRewardArrived");
                            CSJRewardVideoAdapter.this.onRewardArrived(z5, i6, null);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                        public void onRewardVerify(boolean z5, int i6, String str, int i7, String str2) {
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onRewardVerify");
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                        public void onSkippedVideo() {
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onSkippedVideo");
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                        public void onVideoComplete() {
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onVideoComplete");
                            CSJRewardVideoAdapter.this.onVideoComplete();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                        public void onVideoError() {
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onVideoError");
                            CSJRewardVideoAdapter.this.onVideoError();
                        }
                    });
                    CSJRewardVideoAdapter.this.onAdLoad();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onRewardVideoCached");
                CSJRewardVideoAdapter.this.onRewardVideoCached();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTRewardVideoAd tTRewardVideoAd = this.csjRewardVideoAd;
        if (tTRewardVideoAd != null) {
            return tTRewardVideoAd.getMediaExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.csjAdNative != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        TTRewardVideoAd tTRewardVideoAd;
        if (this.csjAdNative != null && (tTRewardVideoAd = this.csjRewardVideoAd) != null && activity != null) {
            tTRewardVideoAd.showRewardVideoAd(activity);
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        CSJInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.csj.CSJRewardVideoAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                StringBuilder a6 = a.a("CSJSDK loadRewardVideoAd onSplashLoadFail code:");
                a6.append(aMPSError.getCode());
                a6.append(" message:");
                a6.append(aMPSError.getMessage());
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a6.toString());
                CSJRewardVideoAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                CSJRewardVideoAdapter.this.loadRewardVideoAd();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.csjAdNative = null;
        TTRewardVideoAd tTRewardVideoAd = this.csjRewardVideoAd;
        if (tTRewardVideoAd != null && tTRewardVideoAd.getMediationManager() != null) {
            this.csjRewardVideoAd.getMediationManager().destroy();
            this.csjRewardVideoAd = null;
        }
    }
}
