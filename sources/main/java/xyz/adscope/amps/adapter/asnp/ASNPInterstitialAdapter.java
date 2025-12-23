package xyz.adscope.amps.adapter.asnp;

import android.app.Activity;
import android.content.Context;
import xyz.adscope.ad.publish.ad.IAdListener;
import xyz.adscope.ad.publish.ad.IBidding;
import xyz.adscope.ad.publish.ad.intersitital.IInterstitialAdConfig;
import xyz.adscope.ad.publish.ad.intersitital.InterstitialAd;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPInterstitialAdapter extends AMPSInterstitialAdapter {
    private InterstitialAd mInterstitialAd;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSInterstitialAdAdapterListener);
        if (!this.isBidding || this.mInterstitialAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadInterstitialAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK start loadInterstitialAd spaceId:" + this.mSpaceId);
        if (this.mContext == null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_FAIL;
            onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            return;
        }
        IInterstitialAdConfig.Builder builder = new IInterstitialAdConfig.Builder();
        builder.setTimeoutMillion(this.mTimeout);
        this.mInterstitialAd = new InterstitialAd(this.mContext, builder.build(this.mSpaceId));
        this.mInterstitialAd.loadAd(new IAdListener() { // from class: xyz.adscope.amps.adapter.asnp.ASNPInterstitialAdapter.2
            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onAdClicked() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadInterstitialAd onAdClicked");
                ASNPInterstitialAdapter.this.onAdClicked();
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onAdClosed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadInterstitialAd onAdClosed");
                ASNPInterstitialAdapter.this.onAdDismiss();
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onAdExposure() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadInterstitialAd onAdExposure");
                ASNPInterstitialAdapter.this.onAdShow();
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener, xyz.adscope.ad.d2
            public void onAdLoadFailed(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadInterstitialAd onAdFailedToLoad code : " + i6 + " , message : " + str);
                ASNPInterstitialAdapter.this.onAdFailed(String.valueOf(i6), str);
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onAdLoaded() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadInterstitialAd onAdLoaded");
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onAdShown() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadInterstitialAd onAdShown");
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onRenderSuccess() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadInterstitialAd onAdRenderSuccess");
                int ecpm = ASNPInterstitialAdapter.this.mInterstitialAd != null ? ASNPInterstitialAdapter.this.mInterstitialAd.getECPM() : 0;
                ASNPInterstitialAdapter aSNPInterstitialAdapter = ASNPInterstitialAdapter.this;
                if (aSNPInterstitialAdapter.isBidding) {
                    aSNPInterstitialAdapter.onC2SBiddingSuccess(ecpm);
                } else {
                    aSNPInterstitialAdapter.onAdLoad();
                }
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        try {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null) {
                interstitialAd.destroyAd();
            }
            this.mInterstitialAd = null;
            super.destroy();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mInterstitialAd != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            if (this.mInterstitialAd != null && aMPSBidResult != null) {
                this.mInterstitialAd.notifyBidWin(IBidding.BiddingPriceBuilder.buildLoseNoticeMap(aMPSBidResult.getEcpm(), -1, aMPSBidResult.getChannelName(), String.valueOf(aMPSBidResult.getReason()), -1));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && aMPSBidResult != null) {
                this.mInterstitialAd.notifyBidWin(IBidding.BiddingPriceBuilder.buildWinNoticeMap(interstitialAd.getECPM(), aMPSBidResult.getEcpm(), aMPSBidResult.getChannelName(), -1));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null && activity != null) {
            interstitialAd.showAd(activity);
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        ASNPInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.asnp.ASNPInterstitialAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadInterstitialAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                ASNPInterstitialAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                ASNPInterstitialAdapter.this.loadInterstitialAd();
            }
        });
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
