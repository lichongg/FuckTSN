package xyz.adscope.amps.ad.unified.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSUnifiedNativeAdapter<T> extends AMPSBaseAdapter<AMPSUnifiedNativeAdAdapterListener> {
    protected List<AMPSUnifiedNativeItem> mUnifiedNativeItemsList;

    protected abstract AMPSUnifiedNativeItem convertEntryFromAdapterResponse(T t5);

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
    }

    protected final void convertAdapterResponse(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mUnifiedNativeItemsList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.mUnifiedNativeItemsList.add(convertEntryFromAdapterResponse(it.next()));
        }
    }

    public final List<AMPSUnifiedNativeItem> getNativeListInfo() {
        return this.mUnifiedNativeItemsList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSUnifiedNativeAdAdapterListener aMPSUnifiedNativeAdAdapterListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.adCount = aMPSAdapterModel.getAdCount();
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSUnifiedNativeAdAdapterListener;
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
    public void refreshAMPSAdAdapterListener(AMPSUnifiedNativeAdAdapterListener aMPSUnifiedNativeAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSUnifiedNativeAdAdapterListener;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void getRequestParameters(Context context, AMPSAdapterModel aMPSAdapterModel) {
        super.getRequestParameters(context, aMPSAdapterModel);
        if (aMPSAdapterModel != null) {
            try {
                this.mAdEcpm = aMPSAdapterModel.getEcpm();
                this.mSeatId = aMPSAdapterModel.getSeatId();
            } catch (Exception e6) {
                AMPSLogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + e6);
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
}
