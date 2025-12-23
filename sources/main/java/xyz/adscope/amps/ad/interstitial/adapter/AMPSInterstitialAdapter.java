package xyz.adscope.amps.ad.interstitial.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSInterstitialAdapter extends AMPSBaseAdapter<AMPSInterstitialAdAdapterListener> {
    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSInterstitialAdAdapterListener;
        if (context != null && !TextUtils.isEmpty(this.mAppId) && !TextUtils.isEmpty(this.mSpaceId)) {
            buildRequestedTimerTask();
            return;
        }
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_PARAM_ERROR;
            aMPSBaseAdAdapterListener.onAdFailed(this, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        }
    }

    public void onSkippedAd() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSInterstitialAdAdapterListener)) {
            return;
        }
        ((AMPSInterstitialAdAdapterListener) aMPSBaseAdAdapterListener).onSkippedAd();
    }

    public void onVideoPlayEnd() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSInterstitialAdAdapterListener)) {
            return;
        }
        ((AMPSInterstitialAdAdapterListener) aMPSBaseAdAdapterListener).onVideoPlayEnd();
    }

    public void onVideoPlayStart() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSInterstitialAdAdapterListener)) {
            return;
        }
        ((AMPSInterstitialAdAdapterListener) aMPSBaseAdAdapterListener).onVideoPlayStart();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void refreshAMPSAdAdapterListener(AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSInterstitialAdAdapterListener;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSAdBiddingListener = aMPSAdBiddingListener;
        this.isBidding = true;
        if (context != null && !TextUtils.isEmpty(this.mAppId) && !TextUtils.isEmpty(this.mSpaceId)) {
            return;
        }
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_PARAM_ERROR;
        onC2SBiddingFail(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
    }
}
