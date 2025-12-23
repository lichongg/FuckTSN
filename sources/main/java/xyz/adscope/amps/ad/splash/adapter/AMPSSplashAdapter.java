package xyz.adscope.amps.ad.splash.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSSplashAdapter extends AMPSBaseAdapter<AMPSSplashAdAdapterListener> {
    public int viewHeightDp;
    public int viewHeightPx;
    public int viewWidthDp;
    public int viewWidthPx;

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSSplashAdAdapterListener;
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
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSSplashAdAdapterListener)) {
            return;
        }
        ((AMPSSplashAdAdapterListener) aMPSBaseAdAdapterListener).onSkippedAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void refreshAMPSAdAdapterListener(AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSSplashAdAdapterListener;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void getRequestParameters(Context context, AMPSAdapterModel aMPSAdapterModel) {
        super.getRequestParameters(context, aMPSAdapterModel);
        if (aMPSAdapterModel != null) {
            try {
                this.viewWidthPx = aMPSAdapterModel.getExpressViewWidth();
                this.viewHeightPx = aMPSAdapterModel.getExpressViewHeight();
                if (context != null) {
                    this.viewWidthDp = DeviceInfoUtil.px2dip(context, this.viewWidthPx);
                    this.viewHeightDp = DeviceInfoUtil.px2dip(context, this.viewHeightPx);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
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
    public void showAd(Activity activity) {
    }
}
