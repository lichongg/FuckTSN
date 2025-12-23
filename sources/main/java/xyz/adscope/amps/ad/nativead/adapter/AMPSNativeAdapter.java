package xyz.adscope.amps.ad.nativead.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.ad.unified.inter.AMPSAppDetail;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedAdEventListener;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedDownloadListener;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNegativeFeedbackListener;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedOptimizeController;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedPattern;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedVideoListener;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedMediaViewStub;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedRootContainer;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedView;
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
public abstract class AMPSNativeAdapter extends AMPSBaseAdapter<AMPSNativeAdAdapterListener> {
    public List<Integer> templateTypes;

    public abstract List<AMPSNativeAdExpressInfo> getNativeListInfo();

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSNativeAdAdapterListener;
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

    public void onRender() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSNativeAdAdapterListener)) {
            return;
        }
        ((AMPSNativeAdAdapterListener) aMPSBaseAdAdapterListener).onRender();
    }

    public void onRenderFail(AMPSError aMPSError) {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSNativeAdAdapterListener)) {
            return;
        }
        ((AMPSNativeAdAdapterListener) aMPSBaseAdAdapterListener).onRenderFail(aMPSError);
    }

    public void onRenderSuccess() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSNativeAdAdapterListener)) {
            return;
        }
        ((AMPSNativeAdAdapterListener) aMPSBaseAdAdapterListener).onRenderSuccess();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void refreshAMPSAdAdapterListener(AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSNativeAdAdapterListener;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
    }

    public final List<AMPSUnifiedNativeItem> getNativeExpressListInfo() {
        List<AMPSNativeAdExpressInfo> nativeListInfo = getNativeListInfo();
        if (nativeListInfo != null && nativeListInfo.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (final AMPSNativeAdExpressInfo aMPSNativeAdExpressInfo : nativeListInfo) {
                arrayList.add(new AMPSUnifiedNativeItem() { // from class: xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter.1
                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public String getActionButtonText() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public AMPSUnifiedPattern getAdPattern() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public View getAdSourceLogo() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public String getAdSourceLogoUrl() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public AMPSAppDetail getAppDetail() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public String getDesc() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public Map<String, Object> getExtras() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public String getIconUrl() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public int getImageHeight() {
                        return 0;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public int getImageWidth() {
                        return 0;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public List<String> getImagesUrl() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public String getMainImageUrl() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public AMPSUnifiedView getMainImageView() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public List<AMPSUnifiedView> getMainImageViews() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public AMPSUnifiedOptimizeController getOptimizeController() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public String getTitle() {
                        return null;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public boolean isExpressAd() {
                        return true;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public boolean isViewObject() {
                        return false;
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public void destroy() {
                        AMPSNativeAdExpressInfo aMPSNativeAdExpressInfo2 = aMPSNativeAdExpressInfo;
                        if (aMPSNativeAdExpressInfo2 == null) {
                            return;
                        }
                        aMPSNativeAdExpressInfo2.destroy();
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public String getAdSource() {
                        return AMPSNativeAdapter.this.getSeatId();
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public int getECPM() {
                        AMPSNativeAdExpressInfo aMPSNativeAdExpressInfo2 = aMPSNativeAdExpressInfo;
                        if (aMPSNativeAdExpressInfo2 == null) {
                            return 0;
                        }
                        return aMPSNativeAdExpressInfo2.getECPM();
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public View getNativeExpressAdView() {
                        AMPSNativeAdExpressInfo aMPSNativeAdExpressInfo2 = aMPSNativeAdExpressInfo;
                        if (aMPSNativeAdExpressInfo2 == null) {
                            return null;
                        }
                        return aMPSNativeAdExpressInfo2.getNativeExpressAdView();
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public boolean isValid() {
                        return AMPSNativeAdapter.this.isValid();
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public void pause() {
                        AMPSNativeAdapter.this.pause();
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public void render() {
                        AMPSNativeAdExpressInfo aMPSNativeAdExpressInfo2 = aMPSNativeAdExpressInfo;
                        if (aMPSNativeAdExpressInfo2 == null) {
                            return;
                        }
                        aMPSNativeAdExpressInfo2.render();
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public void resume() {
                        AMPSNativeAdapter.this.resume();
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public void setNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
                        AMPSNativeAdExpressInfo aMPSNativeAdExpressInfo2 = aMPSNativeAdExpressInfo;
                        if (aMPSNativeAdExpressInfo2 == null) {
                            return;
                        }
                        aMPSNativeAdExpressInfo2.setAMPSNativeAdExpressListener(aMPSNativeAdExpressListener);
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public void setDownloadListener(AMPSUnifiedDownloadListener aMPSUnifiedDownloadListener) {
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public void setNativeAdEventListener(AMPSUnifiedAdEventListener aMPSUnifiedAdEventListener) {
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public void setNegativeFeedbackListener(AMPSUnifiedNegativeFeedbackListener aMPSUnifiedNegativeFeedbackListener) {
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public void bindAdToMediaView(Activity activity, AMPSUnifiedMediaViewStub aMPSUnifiedMediaViewStub, AMPSUnifiedVideoListener aMPSUnifiedVideoListener) {
                    }

                    @Override // xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
                    public void bindAdToRootContainer(Activity activity, AMPSUnifiedRootContainer aMPSUnifiedRootContainer, List<View> list, List<View> list2) {
                    }
                });
            }
            return arrayList;
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void getRequestParameters(Context context, AMPSAdapterModel aMPSAdapterModel) {
        super.getRequestParameters(context, aMPSAdapterModel);
        if (aMPSAdapterModel != null) {
            try {
                this.templateTypes = aMPSAdapterModel.getTemplateTypes();
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

    public void pause() {
    }

    public void resume() {
    }
}
