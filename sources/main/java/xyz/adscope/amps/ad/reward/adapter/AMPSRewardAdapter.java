package xyz.adscope.amps.ad.reward.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.Map;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSRewardAdapter extends AMPSBaseAdapter<AMPSRewardVideoAdAdapterListener> {
    public boolean isAutoPlay = true;

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener;
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSRewardVideoAdAdapterListener;
        if ((context == null || TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.mSpaceId)) && (aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener) != null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_PARAM_ERROR;
            aMPSBaseAdAdapterListener.onAdFailed(this, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        }
    }

    public void onRewardArrived(boolean z5, int i6, Map<String, Object> map) {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSRewardVideoAdAdapterListener)) {
            return;
        }
        ((AMPSRewardVideoAdAdapterListener) aMPSBaseAdAdapterListener).onRewardArrived(z5, i6, map);
    }

    public void onRewardVideoCached() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSRewardVideoAdAdapterListener)) {
            return;
        }
        ((AMPSRewardVideoAdAdapterListener) aMPSBaseAdAdapterListener).onRewardVideoCached(this);
    }

    public void onVideoComplete() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSRewardVideoAdAdapterListener)) {
            return;
        }
        ((AMPSRewardVideoAdAdapterListener) aMPSBaseAdAdapterListener).onVideoComplete();
    }

    public void onVideoError() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSRewardVideoAdAdapterListener)) {
            return;
        }
        ((AMPSRewardVideoAdAdapterListener) aMPSBaseAdAdapterListener).onVideoError();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void refreshAMPSAdAdapterListener(AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSRewardVideoAdAdapterListener;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void getRequestParameters(Context context, AMPSAdapterModel aMPSAdapterModel) {
        boolean z5;
        super.getRequestParameters(context, aMPSAdapterModel);
        if (aMPSAdapterModel != null) {
            if (aMPSAdapterModel.getVideoAutoPlay() != AMPSEnum.AutoPlayEnum.NO_AUTO_PLAY.getAutoPlayValue()) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.isAutoPlay = z5;
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
    public void showAd(ViewGroup viewGroup) {
    }
}
