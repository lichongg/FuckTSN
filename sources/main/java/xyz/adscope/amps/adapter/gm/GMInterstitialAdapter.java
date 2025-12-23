package xyz.adscope.amps.adapter.gm;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.Map;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GMInterstitialAdapter extends AMPSInterstitialAdapter {
    private TTAdNative mTTAdNative;
    private TTFullScreenVideoAd mttFullVideoAd;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSInterstitialAdAdapterListener);
        initSDK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadInterstitialAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK start loadInterstitialAd  spaceId:" + this.mSpaceId);
        this.mTTAdNative = GMInitMediation.get().createAdNative(this.mContext);
        this.mTTAdNative.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdLoadType(TTAdLoadType.LOAD).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: xyz.adscope.amps.adapter.gm.GMInterstitialAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadInterstitialAd onError code : " + i6 + " , msg : " + str);
                GMInterstitialAdapter.this.onAdFailed(String.valueOf(i6), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadInterstitialAd onInterstitialAdLoad");
                if (tTFullScreenVideoAd == null) {
                    GMInterstitialAdapter gMInterstitialAdapter = GMInterstitialAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    gMInterstitialAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                try {
                    GMInterstitialAdapter.this.mttFullVideoAd = tTFullScreenVideoAd;
                    GMInterstitialAdapter.this.onAdLoad();
                    GMInterstitialAdapter.this.setFullScreenVideoAdInteractionListener();
                    GMInterstitialAdapter.this.setDownloadListener();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloadListener() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.mttFullVideoAd;
        if (tTFullScreenVideoAd == null) {
            return;
        }
        tTFullScreenVideoAd.setDownloadListener(new TTAppDownloadListener() { // from class: xyz.adscope.amps.adapter.gm.GMInterstitialAdapter.4
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j6, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j6, long j7, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j6, long j7, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j6, long j7, String str, String str2) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreenVideoAdInteractionListener() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.mttFullVideoAd;
        if (tTFullScreenVideoAd == null) {
            return;
        }
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: xyz.adscope.amps.adapter.gm.GMInterstitialAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadInterstitialAd onAdClose");
                GMInterstitialAdapter.this.onAdDismiss();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadInterstitialAd onAdShow");
                GMInterstitialAdapter.this.onAdShow();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadInterstitialAd onAdVideoBarClick");
                GMInterstitialAdapter.this.onAdClicked();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadInterstitialAd onSkippedVideo");
                GMInterstitialAdapter.this.onSkippedAd();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadInterstitialAd onVideoComplete");
                GMInterstitialAdapter.this.onVideoPlayEnd();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.mttFullVideoAd;
        if (tTFullScreenVideoAd != null) {
            return tTFullScreenVideoAd.getMediaExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mTTAdNative != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        TTFullScreenVideoAd tTFullScreenVideoAd;
        if (this.mTTAdNative != null && (tTFullScreenVideoAd = this.mttFullVideoAd) != null && activity != null) {
            tTFullScreenVideoAd.showFullScreenVideoAd(activity, TTAdConstant.RitScenes.GAME_GIFT_BONUS, null);
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        GMInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.gm.GMInterstitialAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadInterstitialAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                GMInterstitialAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                GMInterstitialAdapter.this.loadInterstitialAd();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.mTTAdNative = null;
        TTFullScreenVideoAd tTFullScreenVideoAd = this.mttFullVideoAd;
        if (tTFullScreenVideoAd != null && tTFullScreenVideoAd.getMediationManager() != null) {
            this.mttFullVideoAd.getMediationManager().destroy();
            this.mttFullVideoAd = null;
        }
    }
}
