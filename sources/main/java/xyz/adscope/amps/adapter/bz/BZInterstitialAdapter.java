package xyz.adscope.amps.adapter.bz;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.InterstitialAd;
import com.beizi.fusion.InterstitialAdListener;
import java.util.Map;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BZInterstitialAdapter extends AMPSInterstitialAdapter {
    private InterstitialAd mInterstitialAd;
    private InterstitialAdListener mInterstitialAdListener = new InterstitialAdListener() { // from class: xyz.adscope.amps.adapter.bz.BZInterstitialAdapter.1
        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdClick() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdClick");
            BZInterstitialAdapter.this.onAdClicked();
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdClosed");
            BZInterstitialAdapter.this.onAdDismiss();
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdFailed(int i6) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdFailed code:" + i6);
            BZInterstitialAdapter.this.onAdFailed(String.valueOf(i6), String.valueOf(i6));
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdLoaded() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdLoaded");
            int i6 = 0;
            try {
                int ecpm = BZInterstitialAdapter.this.mInterstitialAd != null ? BZInterstitialAdapter.this.mInterstitialAd.getECPM() : 0;
                if (ecpm >= 0) {
                    i6 = ecpm;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BZInterstitialAdapter bZInterstitialAdapter = BZInterstitialAdapter.this;
            if (bZInterstitialAdapter.isBidding) {
                bZInterstitialAdapter.onC2SBiddingSuccess(i6);
            } else {
                bZInterstitialAdapter.onAdLoad();
            }
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdShown() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdShown");
            BZInterstitialAdapter.this.onAdShow();
        }
    };

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

    private void loadInterstitialAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK start loadInterstitialAd spaceId:" + this.mSpaceId);
        InterstitialAd interstitialAd = new InterstitialAd(this.mContext, this.mSpaceId, this.mInterstitialAdListener, (long) this.mTimeout);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdVersion(1);
        this.mInterstitialAd.loadAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public String getMediaCustomExtraInfo() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd == null) {
            return super.getMediaCustomExtraInfo();
        }
        String customExtraData = interstitialAd.getCustomExtraData();
        return TextUtils.isEmpty(customExtraData) ? super.getMediaCustomExtraInfo() : customExtraData;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mInterstitialAd != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        Map<String, String> lossInfo;
        try {
            if (this.mInterstitialAd != null && aMPSBidResult != null && (lossInfo = BZInitMediation.getInstance().getLossInfo(aMPSBidResult)) != null) {
                this.mInterstitialAd.sendLossNotificationWithInfo(lossInfo);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        Map<String, String> winInfo;
        try {
            if (this.mInterstitialAd != null && aMPSBidResult != null && (winInfo = BZInitMediation.getInstance().getWinInfo(aMPSBidResult)) != null) {
                this.mInterstitialAd.sendWinNotificationWithInfo(winInfo);
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
        BZInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadInterstitialAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null) {
                interstitialAd.destroy();
            }
            this.mInterstitialAd = null;
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
