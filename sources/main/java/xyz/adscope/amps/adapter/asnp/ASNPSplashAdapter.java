package xyz.adscope.amps.adapter.asnp;

import android.content.Context;
import android.view.ViewGroup;
import xyz.adscope.ad.publish.ad.IAdListener;
import xyz.adscope.ad.publish.ad.IBidding;
import xyz.adscope.ad.publish.ad.splash.ISplashAdConfig;
import xyz.adscope.ad.publish.ad.splash.SplashAd;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPSplashAdapter extends AMPSSplashAdapter {
    private SplashAd mSplashAd;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSSplashAdAdapterListener);
        if (!this.isBidding || this.mSplashAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSplashAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK start loadSplashAd spaceId:" + this.mSpaceId);
        if (this.mContext == null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_FAIL;
            onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            return;
        }
        ISplashAdConfig.Builder builder = new ISplashAdConfig.Builder();
        builder.setTimeoutMillion(this.mTimeout);
        builder.setExpressSizePixel(this.viewWidthPx, this.viewHeightPx);
        this.mSplashAd = new SplashAd(this.mContext, builder.build(this.mSpaceId));
        this.mSplashAd.loadAd(new IAdListener() { // from class: xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter.2
            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onAdClicked() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdClicked");
                ASNPSplashAdapter.this.onAdClicked();
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onAdClosed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdClosed");
                ASNPSplashAdapter.this.onAdDismiss();
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onAdExposure() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdExposure");
                ASNPSplashAdapter.this.onAdShow();
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener, xyz.adscope.ad.d2
            public void onAdLoadFailed(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdFailedToLoad code : " + i6 + " , message : " + str);
                ASNPSplashAdapter.this.onAdFailed(String.valueOf(i6), str);
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onAdLoaded() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdLoaded");
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onAdShown() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdShown");
            }

            @Override // xyz.adscope.ad.publish.ad.IAdListener
            public void onRenderSuccess() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdRenderSuccess");
                int ecpm = ASNPSplashAdapter.this.mSplashAd != null ? ASNPSplashAdapter.this.mSplashAd.getECPM() : 0;
                ASNPSplashAdapter aSNPSplashAdapter = ASNPSplashAdapter.this;
                if (aSNPSplashAdapter.isBidding) {
                    aSNPSplashAdapter.onC2SBiddingSuccess(ecpm);
                } else {
                    aSNPSplashAdapter.onAdLoad();
                }
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        try {
            SplashAd splashAd = this.mSplashAd;
            if (splashAd != null) {
                splashAd.destroyAd();
            }
            this.mSplashAd = null;
            super.destroy();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mSplashAd != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            if (this.mSplashAd != null && aMPSBidResult != null) {
                this.mSplashAd.notifyBidWin(IBidding.BiddingPriceBuilder.buildLoseNoticeMap(aMPSBidResult.getEcpm(), -1, aMPSBidResult.getChannelName(), String.valueOf(aMPSBidResult.getReason()), -1));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            SplashAd splashAd = this.mSplashAd;
            if (splashAd != null && aMPSBidResult != null) {
                this.mSplashAd.notifyBidWin(IBidding.BiddingPriceBuilder.buildWinNoticeMap(splashAd.getECPM(), aMPSBidResult.getEcpm(), aMPSBidResult.getChannelName(), -1));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        SplashAd splashAd = this.mSplashAd;
        if (splashAd != null && viewGroup != null) {
            splashAd.showAd(viewGroup);
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        ASNPInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadSplashAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                ASNPSplashAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                ASNPSplashAdapter.this.loadSplashAd();
            }
        });
    }

    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
