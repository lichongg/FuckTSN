package xyz.adscope.amps.ad.banner.adapter;

import android.app.Activity;
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
public abstract class AMPSBannerAdapter extends AMPSBaseAdapter<AMPSBannerAdAdapterListener> {
    private boolean isFirst = true;

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSBannerAdAdapterListener aMPSBannerAdAdapterListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSBannerAdAdapterListener;
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

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void onAdFailed(String str, String str2) {
        if (this.isFirst) {
            super.onAdFailed(str, str2);
            return;
        }
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdFailed(this, new AMPSError(String.valueOf(str), str2));
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void onAdLoad() {
        if (this.isFirst) {
            this.isFirst = false;
            super.onAdLoad();
        } else {
            AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
            if (aMPSBaseAdAdapterListener != null) {
                aMPSBaseAdAdapterListener.onAdLoaded(this);
            }
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void onAdShow() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdShow(this);
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void onC2SBiddingSuccess(int i6) {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener;
        if (this.isFirst) {
            this.isFirst = false;
            super.onC2SBiddingSuccess(i6);
        } else if (this.isBidding && (aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener) != null) {
            aMPSBaseAdAdapterListener.onAdLoaded(this);
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void refreshAMPSAdAdapterListener(AMPSBannerAdAdapterListener aMPSBannerAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSBannerAdAdapterListener;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
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
}
