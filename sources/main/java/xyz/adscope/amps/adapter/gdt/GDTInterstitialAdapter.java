package xyz.adscope.amps.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
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
public class GDTInterstitialAdapter extends AMPSInterstitialAdapter {
    private BidResponseModel mBidResponseModel;
    private String mToken;
    private UnifiedInterstitialAD mUnifiedInterstitialAD;

    public class GDTUnifiedInterstitialADListener implements UnifiedInterstitialADListener {
        private GDTUnifiedInterstitialADListener() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onADClicked");
            GDTInterstitialAdapter.this.onAdClicked();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onADClosed");
            GDTInterstitialAdapter.this.onAdDismiss();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onADExposure");
            GDTInterstitialAdapter.this.onAdShow();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onADLeftApplication");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onADReceive");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
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
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onNoAD code : " + str + " , msg : " + str2);
            GDTInterstitialAdapter.this.onAdFailed(str, str2);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onRenderFail");
            GDTInterstitialAdapter gDTInterstitialAdapter = GDTInterstitialAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL;
            gDTInterstitialAdapter.onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onRenderSuccess");
            int ecpm = GDTInterstitialAdapter.this.mUnifiedInterstitialAD != null ? GDTInterstitialAdapter.this.mUnifiedInterstitialAD.getECPM() : 0;
            if (GDTInterstitialAdapter.this.isC2SAdSource()) {
                GDTInterstitialAdapter.this.onC2SBiddingSuccess(ecpm);
            } else {
                GDTInterstitialAdapter.this.onAdLoad();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onVideoCached");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSInterstitialAdAdapterListener);
        if (isC2SAdSource() && this.mUnifiedInterstitialAD != null) {
            onAdLoad();
        } else {
            initSDK();
            loadInterstitialAd();
        }
    }

    private void loadInterstitialAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK start loadInterstitialAd spaceId:" + this.mSpaceId);
        if (TextUtils.isEmpty(this.mToken)) {
            this.mUnifiedInterstitialAD = new UnifiedInterstitialAD((Activity) this.mContext, this.mSpaceId, new GDTUnifiedInterstitialADListener());
        } else {
            this.mUnifiedInterstitialAD = new UnifiedInterstitialAD((Activity) this.mContext, this.mSpaceId, new GDTUnifiedInterstitialADListener(), null, this.mToken);
        }
        setMediaListener();
        setVideoOption();
        this.mUnifiedInterstitialAD.loadAD();
    }

    private void setMediaListener() {
        this.mUnifiedInterstitialAD.setMediaListener(new UnifiedInterstitialMediaListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTInterstitialAdapter.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoComplete() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onVideoComplete");
                GDTInterstitialAdapter.this.onVideoPlayEnd();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onVideoStart");
                GDTInterstitialAdapter.this.onVideoPlayStart();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoError(AdError adError) {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long j6) {
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setVideoOption() {
        /*
            r4 = this;
            com.qq.e.ads.cfg.VideoOption$Builder r0 = new com.qq.e.ads.cfg.VideoOption$Builder
            r0.<init>()
            int r1 = r4.autoPlayPolicy
            xyz.adscope.amps.common.AMPSEnum$AutoPlayEnum r2 = xyz.adscope.amps.common.AMPSEnum.AutoPlayEnum.NO_AUTO_PLAY
            int r2 = r2.getAutoPlayValue()
            r3 = 1
            if (r1 != r2) goto L15
            r1 = 2
        L11:
            r0.setAutoPlayPolicy(r1)
            goto L2e
        L15:
            int r1 = r4.autoPlayPolicy
            xyz.adscope.amps.common.AMPSEnum$AutoPlayEnum r2 = xyz.adscope.amps.common.AMPSEnum.AutoPlayEnum.WIFI_AUTO_PLAY
            int r2 = r2.getAutoPlayValue()
            if (r1 != r2) goto L21
            r1 = 0
            goto L11
        L21:
            int r1 = r4.autoPlayPolicy
            xyz.adscope.amps.common.AMPSEnum$AutoPlayEnum r2 = xyz.adscope.amps.common.AMPSEnum.AutoPlayEnum.HAS_NET_AUTO_PLAY
            int r2 = r2.getAutoPlayValue()
            if (r1 != r2) goto L2e
            r0.setAutoPlayPolicy(r3)
        L2e:
            boolean r1 = r4.isVolumeOn
            r1 = r1 ^ r3
            r0.setAutoPlayMuted(r1)
            boolean r1 = r4.isVolumeOn
            r1 = r1 ^ r3
            r0.setDetailPageMuted(r1)
            com.qq.e.ads.interstitial2.UnifiedInterstitialAD r1 = r4.mUnifiedInterstitialAD
            if (r1 == 0) goto L4e
            com.qq.e.ads.cfg.VideoOption r0 = r0.build()
            r1.setVideoOption(r0)
            int r0 = r4.videoMaxTime
            if (r0 <= 0) goto L4e
            com.qq.e.ads.interstitial2.UnifiedInterstitialAD r1 = r4.mUnifiedInterstitialAD
            r1.setMaxVideoDuration(r0)
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.adapter.gdt.GDTInterstitialAdapter.setVideoOption():void");
    }

    private void startS2SBidding() {
        GDTBiddingRequestUtil.getBidResponse(this.mContext, this.mServerUrl, this.mAppId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.gdt.GDTInterstitialAdapter.2
            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                GDTInterstitialAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                if (bidResponseModel == null) {
                    return;
                }
                GDTInterstitialAdapter.this.mToken = str;
                GDTInterstitialAdapter.this.mBidResponseModel = bidResponseModel;
                GDTInterstitialAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.getExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
        if (unifiedInterstitialAD == null) {
            return false;
        }
        return unifiedInterstitialAD.isValid();
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
                UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
                if (unifiedInterstitialAD == null) {
                    return;
                }
                GDTAdManagerHolder.sendLossNotification(unifiedInterstitialAD, aMPSBidResult.getReason());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
            if (unifiedInterstitialAD == null) {
                return;
            }
            int ecpm = unifiedInterstitialAD.getECPM();
            if (isC2SAdSource()) {
                GDTAdManagerHolder.sendWinNotification(this.mUnifiedInterstitialAD, ecpm);
            } else if (isS2SAdSource()) {
                GDTBiddingRequestUtil.sendWinNotice(this.mBidResponseModel, this.mPublicKey);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
        if (unifiedInterstitialAD != null && activity != null && unifiedInterstitialAD.isValid()) {
            this.mUnifiedInterstitialAD.show();
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
        UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
            this.mUnifiedInterstitialAD.destroy();
        }
        this.mUnifiedInterstitialAD = null;
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
        if (isC2SAdSource()) {
            loadInterstitialAd();
        } else if (isS2SAdSource()) {
            startS2SBidding();
        }
    }
}
