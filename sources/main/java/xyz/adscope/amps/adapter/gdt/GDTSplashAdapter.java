package xyz.adscope.amps.adapter.gdt;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
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
public class GDTSplashAdapter extends AMPSSplashAdapter {
    private BidResponseModel mBidResponseModel;
    private SplashAD mSplashAd;
    private String mToken;
    private String supportZoomOut = "";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSSplashAdAdapterListener);
        this.supportZoomOut = aMPSAdapterModel.getZoomOut();
        if (isC2SAdSource() && this.mSplashAd != null) {
            onAdLoad();
        } else {
            initSDK();
            loadSplashAd();
        }
    }

    private void loadSplashAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK start loadSplashAd spaceId:" + this.mSpaceId);
        SplashADListener splashADListener = new SplashADListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTSplashAdapter.1
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onADClicked");
                GDTSplashAdapter.this.onAdClicked();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onAdClosed");
                GDTSplashAdapter.this.onAdDismiss();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onADExposure");
                GDTSplashAdapter.this.onAdShow();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long j6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onAdLoaded");
                int ecpm = GDTSplashAdapter.this.mSplashAd != null ? GDTSplashAdapter.this.mSplashAd.getECPM() : 0;
                if (GDTSplashAdapter.this.isC2SAdSource()) {
                    GDTSplashAdapter.this.onC2SBiddingSuccess(ecpm);
                } else {
                    GDTSplashAdapter.this.onAdLoad();
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onADPresent");
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(AdError adError) {
                String str;
                String str2;
                if (adError != null) {
                    str = String.valueOf(adError.getErrorCode());
                    str2 = adError.getErrorMsg();
                } else {
                    str = "";
                    str2 = "";
                }
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onNoAD code:" + str + ";msg:" + str2);
                GDTSplashAdapter.this.onAdFailed(str, str2);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long j6) {
            }
        };
        if (TextUtils.isEmpty(this.mToken)) {
            this.mSplashAd = new SplashAD(this.mContext, this.mSpaceId, splashADListener, this.mTimeout);
        } else {
            this.mSplashAd = new SplashAD(this.mContext, this.mSpaceId, splashADListener, this.mTimeout, this.mToken);
        }
        this.mSplashAd.fetchAdOnly();
    }

    private void startS2SBidding() {
        GDTBiddingRequestUtil.getBidResponse(this.mContext, this.mServerUrl, this.mAppId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.gdt.GDTSplashAdapter.2
            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                GDTSplashAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                if (bidResponseModel == null) {
                    return;
                }
                GDTSplashAdapter.this.mToken = str;
                GDTSplashAdapter.this.mBidResponseModel = bidResponseModel;
                GDTSplashAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        SplashAD splashAD = this.mSplashAd;
        if (splashAD != null) {
            return splashAD.getExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        SplashAD splashAD = this.mSplashAd;
        if (splashAD == null) {
            return false;
        }
        return splashAD.isValid();
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
                SplashAD splashAD = this.mSplashAd;
                if (splashAD == null) {
                    return;
                }
                GDTAdManagerHolder.sendLossNotification(splashAD, aMPSBidResult.getReason());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            SplashAD splashAD = this.mSplashAd;
            if (splashAD == null) {
                return;
            }
            int ecpm = splashAD.getECPM();
            if (isC2SAdSource()) {
                GDTAdManagerHolder.sendWinNotification(this.mSplashAd, ecpm);
            } else if (isS2SAdSource()) {
                GDTBiddingRequestUtil.sendWinNotice(this.mBidResponseModel, this.mPublicKey);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        SplashAD splashAD = this.mSplashAd;
        if (splashAD != null && viewGroup != null) {
            splashAD.showAd(viewGroup);
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
        this.mSplashAd = null;
    }

    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
        if (isC2SAdSource()) {
            loadSplashAd();
        } else if (isS2SAdSource()) {
            startS2SBidding();
        }
    }
}
