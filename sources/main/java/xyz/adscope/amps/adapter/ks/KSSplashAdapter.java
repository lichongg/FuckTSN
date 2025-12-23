package xyz.adscope.amps.adapter.ks;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.SplashAdExtraData;
import java.util.Map;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
import xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback;
import xyz.adscope.amps.adapter.ks.model.BidResponseModel;
import xyz.adscope.amps.adapter.ks.util.KSBiddingRequestUtil;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class KSSplashAdapter extends AMPSSplashAdapter {
    private KsSplashScreenAd ksSplashScreenAd;
    private String mBidResponse;
    private BidResponseModel mBidResponseModel;
    private String mBidResponseV2;
    private final KsSplashScreenAd.SplashScreenAdInteractionListener mInteractionListener = new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: xyz.adscope.amps.adapter.ks.KSSplashAdapter.2
        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onAdClicked");
            KSSplashAdapter.this.onAdClicked();
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onAdShowEnd");
            KSSplashAdapter.this.onAdDismiss();
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i6, String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onAdShowError code:" + i6 + ";extra:" + str);
            KSSplashAdapter.this.onAdShowFailed(String.valueOf(i6), str);
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onAdShowStart");
            KSSplashAdapter.this.onAdShow();
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogCancel() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onDownloadTipsDialogCancel");
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogDismiss() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd  onDownloadTipsDialogDismiss");
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogShow() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onDownloadTipsDialogShow");
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onSkippedAd");
            KSSplashAdapter.this.onAdDismiss();
        }
    };

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSSplashAdAdapterListener);
        if (isC2SAdSource() && this.ksSplashScreenAd != null) {
            onAdLoad();
        } else {
            initSDK();
            loadSplashAd();
        }
    }

    private void loadSplashAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK start loadSplashAd spaceId:" + this.mSpaceId);
        SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
        splashAdExtraData.setDisableShakeStatus(!KSInitMediation.getInstance().isCanUseShakeAd());
        KsScene.Builder splashExtraData = new KsScene.Builder(Long.parseLong(this.mSpaceId)).setSplashExtraData(splashAdExtraData);
        if (!TextUtils.isEmpty(this.mBidResponse)) {
            splashExtraData.setBidResponse(this.mBidResponse);
        } else if (!TextUtils.isEmpty(this.mBidResponseV2)) {
            splashExtraData.setBidResponseV2(this.mBidResponseV2);
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(splashExtraData.build(), new KsLoadManager.SplashScreenAdListener() { // from class: xyz.adscope.amps.adapter.ks.KSSplashAdapter.1
            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onError code : " + i6 + " , msg : " + str);
                KSSplashAdapter.this.onAdFailed(String.valueOf(i6), str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onRequestResult(int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onRequestResult adNumber :" + i6);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onSplashScreenAdLoad(@NonNull KsSplashScreenAd ksSplashScreenAd) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onSplashScreenAdLoad");
                KSSplashAdapter.this.ksSplashScreenAd = ksSplashScreenAd;
                int ecpm = KSSplashAdapter.this.ksSplashScreenAd != null ? KSSplashAdapter.this.ksSplashScreenAd.getECPM() : 0;
                if (KSSplashAdapter.this.isC2SAdSource()) {
                    KSSplashAdapter.this.onC2SBiddingSuccess(ecpm);
                } else {
                    KSSplashAdapter.this.onAdLoad();
                }
            }
        });
    }

    private void startS2SBidding() {
        KSBiddingRequestUtil.getBidResponse(this.mServerUrl, this.mAccountId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.ks.KSSplashAdapter.3
            @Override // xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                KSSplashAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                KSSplashAdapter.this.mBidResponseModel = bidResponseModel;
                KSSplashAdapter.this.mBidResponse = str;
                KSSplashAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        KsSplashScreenAd ksSplashScreenAd = this.ksSplashScreenAd;
        if (ksSplashScreenAd == null) {
            return null;
        }
        ksSplashScreenAd.getMediaExtraInfo();
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.ksSplashScreenAd != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsSplashScreenAd ksSplashScreenAd = this.ksSplashScreenAd;
            if (ksSplashScreenAd != null && aMPSBidResult != null) {
                KSAdManagerHolder.sendLossNotification(ksSplashScreenAd, aMPSBidResult);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsSplashScreenAd ksSplashScreenAd = this.ksSplashScreenAd;
            if (ksSplashScreenAd == null) {
                return;
            }
            int ecpm = ksSplashScreenAd.getECPM();
            if (isC2SAdSource()) {
                KSAdManagerHolder.sendWinNotification(this.ksSplashScreenAd, ecpm);
            } else if (isS2SAdSource()) {
                KSBiddingRequestUtil.sendWinNotice(this.mBidResponseModel);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        KsSplashScreenAd ksSplashScreenAd = this.ksSplashScreenAd;
        if (ksSplashScreenAd == null || viewGroup == null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        } else {
            View view = ksSplashScreenAd.getView(viewGroup.getContext(), this.mInteractionListener);
            viewGroup.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(view);
        }
    }

    private void initSDK() {
        KSInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.ksSplashScreenAd = null;
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
