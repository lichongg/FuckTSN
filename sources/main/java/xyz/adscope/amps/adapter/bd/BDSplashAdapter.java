package xyz.adscope.amps.adapter.bd;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.HashMap;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BDSplashAdapter extends AMPSSplashAdapter {
    private SplashInteractionListener mInteractionListener = new SplashInteractionListener() { // from class: xyz.adscope.amps.adapter.bd.BDSplashAdapter.3
        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onADLoaded");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdCacheFailed");
            BDSplashAdapter bDSplashAdapter = BDSplashAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_CACHE_FAIL;
            bDSplashAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheSuccess() {
            int i6 = 0;
            boolean isReady = BDSplashAdapter.this.mSplashAd != null ? BDSplashAdapter.this.mSplashAd.isReady() : false;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdCacheSuccess isReady:" + isReady);
            if (!isReady) {
                BDSplashAdapter bDSplashAdapter = BDSplashAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_FAIL;
                bDSplashAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                return;
            }
            try {
                if (BDSplashAdapter.this.mSplashAd != null) {
                    i6 = Integer.parseInt(BDSplashAdapter.this.mSplashAd.getECPMLevel());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BDSplashAdapter bDSplashAdapter2 = BDSplashAdapter.this;
            if (bDSplashAdapter2.isBidding) {
                bDSplashAdapter2.onC2SBiddingSuccess(i6);
            } else {
                bDSplashAdapter2.onAdLoad();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdClick() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClick");
            BDSplashAdapter.this.onAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdDismissed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdDismissed");
            BDSplashAdapter.this.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdExposed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdExposed");
            BDSplashAdapter.this.onAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdFailed message:" + str);
            BDSplashAdapter.this.onAdFailed(AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_FAIL.getErrorCode(), str);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdPresent() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdPresent");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdSkip() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdSkip");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onLpClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onLpClosed");
        }
    };
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

    private void loadSplashAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK start loadSplashAd spaceId:" + this.mSpaceId);
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", String.valueOf(this.mTimeout));
        builder.setWidth(this.viewWidthDp);
        builder.setHeight(this.viewHeightDp);
        SplashAd splashAd = new SplashAd(this.mContext, this.mSpaceId, builder.build(), this.mInteractionListener);
        this.mSplashAd = splashAd;
        splashAd.load();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        SplashAd splashAd = this.mSplashAd;
        if (splashAd == null) {
            return false;
        }
        return splashAd.isReady();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            if (this.mSplashAd != null && aMPSBidResult != null) {
                this.mSplashAd.biddingFail(BDInitMediation.getInstance().getWinInfo(aMPSBidResult), new BiddingListener() { // from class: xyz.adscope.amps.adapter.bd.BDSplashAdapter.2
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
            if (this.mSplashAd != null && aMPSBidResult != null) {
                this.mSplashAd.biddingSuccess(BDInitMediation.getInstance().getSecondInfo(aMPSBidResult), new BiddingListener() { // from class: xyz.adscope.amps.adapter.bd.BDSplashAdapter.1
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
    public void showAd(ViewGroup viewGroup) {
        SplashAd splashAd = this.mSplashAd;
        if (splashAd != null && viewGroup != null && splashAd.isReady()) {
            this.mSplashAd.show(viewGroup);
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        BDInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadSplashAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            SplashAd splashAd = this.mSplashAd;
            if (splashAd != null) {
                splashAd.destroy();
            }
            this.mSplashAd = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
