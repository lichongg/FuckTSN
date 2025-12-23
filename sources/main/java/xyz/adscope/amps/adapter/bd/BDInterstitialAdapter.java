package xyz.adscope.amps.adapter.bd;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import java.util.HashMap;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BDInterstitialAdapter extends AMPSInterstitialAdapter {
    private ExpressInterstitialAd mExpressInterstitialAd;
    private ExpressInterstitialListener mExpressInterstitialListener = new ExpressInterstitialListener() { // from class: xyz.adscope.amps.adapter.bd.BDInterstitialAdapter.3
        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADExposed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onADExposed");
            BDInterstitialAdapter.this.onAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADExposureFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onADExposureFailed");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADLoaded() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdLoaded");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdCacheFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdCacheFailed");
            BDInterstitialAdapter bDInterstitialAdapter = BDInterstitialAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_CACHE_FAIL;
            bDInterstitialAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdCacheSuccess() {
            int i6 = 0;
            boolean isReady = BDInterstitialAdapter.this.mExpressInterstitialAd != null ? BDInterstitialAdapter.this.mExpressInterstitialAd.isReady() : false;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdCacheSuccess isReady:" + isReady);
            if (!isReady) {
                BDInterstitialAdapter bDInterstitialAdapter = BDInterstitialAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_FAIL;
                bDInterstitialAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                return;
            }
            try {
                if (BDInterstitialAdapter.this.mExpressInterstitialAd != null) {
                    i6 = Integer.parseInt(BDInterstitialAdapter.this.mExpressInterstitialAd.getECPMLevel());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BDInterstitialAdapter bDInterstitialAdapter2 = BDInterstitialAdapter.this;
            if (bDInterstitialAdapter2.isBidding) {
                bDInterstitialAdapter2.onC2SBiddingSuccess(i6);
            } else {
                bDInterstitialAdapter2.onAdLoad();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdClick() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClick");
            BDInterstitialAdapter.this.onAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdClose() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClose");
            BDInterstitialAdapter.this.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdFailed(int i6, String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdFailed msg:" + str);
            BDInterstitialAdapter.this.onAdFailed(String.valueOf(i6), str);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onLpClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onLpClosed");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onNoAd(int i6, String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onNoAd msg:" + str);
            BDInterstitialAdapter.this.onAdFailed(String.valueOf(i6), str);
        }
    };

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSInterstitialAdAdapterListener);
        if (!this.isBidding || this.mExpressInterstitialAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    private void loadInterstitialAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK start loadInterstitialAd spaceId:" + this.mSpaceId);
        ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(this.mContext, this.mSpaceId);
        this.mExpressInterstitialAd = expressInterstitialAd;
        expressInterstitialAd.setLoadListener(this.mExpressInterstitialListener);
        this.mExpressInterstitialAd.load();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        ExpressInterstitialAd expressInterstitialAd = this.mExpressInterstitialAd;
        if (expressInterstitialAd == null) {
            return false;
        }
        return expressInterstitialAd.isReady();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            if (this.mExpressInterstitialAd != null && aMPSBidResult != null) {
                this.mExpressInterstitialAd.biddingFail(BDInitMediation.getInstance().getWinInfo(aMPSBidResult), new BiddingListener() { // from class: xyz.adscope.amps.adapter.bd.BDInterstitialAdapter.2
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
            if (this.mExpressInterstitialAd != null && aMPSBidResult != null) {
                this.mExpressInterstitialAd.biddingSuccess(BDInitMediation.getInstance().getSecondInfo(aMPSBidResult), new BiddingListener() { // from class: xyz.adscope.amps.adapter.bd.BDInterstitialAdapter.1
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
        ExpressInterstitialAd expressInterstitialAd = this.mExpressInterstitialAd;
        if (expressInterstitialAd != null && activity != null && expressInterstitialAd.isReady()) {
            this.mExpressInterstitialAd.show(activity);
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        BDInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadInterstitialAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            ExpressInterstitialAd expressInterstitialAd = this.mExpressInterstitialAd;
            if (expressInterstitialAd != null) {
                expressInterstitialAd.destroy();
            }
            this.mExpressInterstitialAd = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
