package xyz.adscope.amps.adapter.bz;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.beizi.fusion.NativeUnifiedAd;
import com.beizi.fusion.NativeUnifiedAdListener;
import com.beizi.fusion.NativeUnifiedAdResponse;
import com.beizi.fusion.model.UnifiedAdDownloadAppInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdAdapterListener;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter;
import xyz.adscope.amps.ad.unified.inter.AMPSAppDetail;
import xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedAdEventListener;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedPattern;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedVideoListener;
import xyz.adscope.amps.ad.unified.view.AMPSRootInsertHelper;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedMediaViewStub;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedRootContainer;
import xyz.adscope.amps.adapter.bz.data.BZConstant;
import xyz.adscope.amps.adapter.bz.util.BZBase64Util;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BZUnifiedNativeAdapter extends AMPSUnifiedNativeAdapter<NativeUnifiedAdResponse> {
    private NativeUnifiedAd mUnifiedAd;
    private BeiziTransformEntry response;

    public static class BeiziTransformEntry extends AMPSBaseTransformEntry {
        private NativeUnifiedAdResponse mSrc;

        private BeiziTransformEntry(NativeUnifiedAdResponse nativeUnifiedAdResponse, Context context, int i6) {
            super(context, i6, null, null);
            this.mSrc = nativeUnifiedAdResponse;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AMPSUnifiedAdEventListener getAdEventListener() {
            return this.mAdEventListener;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToMediaView(Activity activity, AMPSUnifiedMediaViewStub aMPSUnifiedMediaViewStub, AMPSUnifiedVideoListener aMPSUnifiedVideoListener) {
            View videoView = this.mSrc.getVideoView();
            if (videoView != null) {
                aMPSUnifiedMediaViewStub.addView(videoView);
            }
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToRootContainer(Activity activity, AMPSUnifiedRootContainer aMPSUnifiedRootContainer, List<View> list, List<View> list2) {
            AMPSRootInsertHelper.insertRootView(aMPSUnifiedRootContainer, this.mSrc.getViewContainer());
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                arrayList.addAll(list);
            }
            if (list2 != null && !list2.isEmpty()) {
                arrayList.addAll(list2);
            }
            this.mSrc.registerViewForInteraction(arrayList);
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getActionButtonText() {
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse == null) {
                return null;
            }
            return nativeUnifiedAdResponse.getActionText();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSUnifiedPattern getAdPattern() {
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            return nativeUnifiedAdResponse == null ? AMPSUnifiedPattern.AD_PATTERN_UNKNOWN : nativeUnifiedAdResponse.getMaterialType() == 1 ? AMPSUnifiedPattern.AD_PATTERN_TEXT_IMAGE : AMPSUnifiedPattern.AD_PATTERN_UNKNOWN;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public View getAdSourceLogo() {
            if (this.mSrc == null || this.mContext == null) {
                return null;
            }
            Bitmap base64ToBitmap = BZBase64Util.base64ToBitmap(BZConstant.BZ_AD_LOGO_ICON);
            if (base64ToBitmap != null) {
                ImageView imageView = new ImageView(this.mContext);
                imageView.setImageBitmap(base64ToBitmap);
                return imageView;
            }
            TextView textView = new TextView(this.mContext);
            textView.setText("倍孜");
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            textView.setPadding(5, 4, 5, 4);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(2, 12.0f);
            textView.setGravity(17);
            return textView;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDescription() {
            UnifiedAdDownloadAppInfo downloadAppInfo;
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse != null && (downloadAppInfo = nativeUnifiedAdResponse.getDownloadAppInfo()) != null) {
                downloadAppInfo.getAppIntro();
            }
            return null;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDeveloper() {
            UnifiedAdDownloadAppInfo downloadAppInfo;
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse != null && (downloadAppInfo = nativeUnifiedAdResponse.getDownloadAppInfo()) != null) {
                downloadAppInfo.getAppDeveloper();
            }
            return null;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppName() {
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse == null) {
                return null;
            }
            UnifiedAdDownloadAppInfo downloadAppInfo = nativeUnifiedAdResponse.getDownloadAppInfo();
            if (downloadAppInfo == null) {
                return "";
            }
            downloadAppInfo.getAppName();
            return "";
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPermissionInfo() {
            UnifiedAdDownloadAppInfo downloadAppInfo;
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse == null || (downloadAppInfo = nativeUnifiedAdResponse.getDownloadAppInfo()) == null) {
                return null;
            }
            return downloadAppInfo.getAppPermission();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPrivacyPolicy() {
            UnifiedAdDownloadAppInfo downloadAppInfo;
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse != null && (downloadAppInfo = nativeUnifiedAdResponse.getDownloadAppInfo()) != null) {
                downloadAppInfo.getAppPrivacy();
            }
            return null;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppVersion() {
            UnifiedAdDownloadAppInfo downloadAppInfo;
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse != null && (downloadAppInfo = nativeUnifiedAdResponse.getDownloadAppInfo()) != null) {
                downloadAppInfo.getAppVersion();
            }
            return null;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getDesc() {
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse == null) {
                return null;
            }
            return nativeUnifiedAdResponse.getDescription();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getIconUrl() {
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse == null) {
                return null;
            }
            return nativeUnifiedAdResponse.getIconUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public List<String> getImagesUrl() {
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse == null) {
                return null;
            }
            return nativeUnifiedAdResponse.getImgList();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getMainImageUrl() {
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse == null) {
                return null;
            }
            return nativeUnifiedAdResponse.getImageUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getTitle() {
            NativeUnifiedAdResponse nativeUnifiedAdResponse = this.mSrc;
            if (nativeUnifiedAdResponse == null) {
                return null;
            }
            return nativeUnifiedAdResponse.getTitle();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public boolean isValid() {
            return this.mSrc != null;
        }

        public void setEcpm(int i6) {
            this.ecpm = i6;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSAppDetail getAppDetail() {
            return this;
        }
    }

    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter
    public AMPSUnifiedNativeItem convertEntryFromAdapterResponse(NativeUnifiedAdResponse nativeUnifiedAdResponse) {
        return new BeiziTransformEntry(nativeUnifiedAdResponse, this.mContext, this.mAdEcpm);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSUnifiedNativeAdAdapterListener aMPSUnifiedNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSUnifiedNativeAdAdapterListener);
        if (!this.isBidding || this.mUnifiedAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    private void loadUnifiedNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadUnifiedNativeAd spaceId:" + this.mSpaceId);
        NativeUnifiedAd nativeUnifiedAd = new NativeUnifiedAd(this.mContext, this.mSpaceId, new NativeUnifiedAdListener() { // from class: xyz.adscope.amps.adapter.bz.BZUnifiedNativeAdapter.1
            @Override // com.beizi.fusion.NativeUnifiedAdListener
            public void onAdClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadUnifiedNativeAd clicked");
                BZUnifiedNativeAdapter.this.onAdClicked();
                if (BZUnifiedNativeAdapter.this.response == null || BZUnifiedNativeAdapter.this.response.getAdEventListener() == null) {
                    return;
                }
                BZUnifiedNativeAdapter.this.response.getAdEventListener().onADClicked();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdListener
            public void onAdFailed(int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadUnifiedNativeAd failed " + i6);
                BZUnifiedNativeAdapter.super.onAdFailed(i6 + "", "beizi unified failed");
            }

            @Override // com.beizi.fusion.NativeUnifiedAdListener
            public void onAdLoaded(NativeUnifiedAdResponse nativeUnifiedAdResponse) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadUnifiedNativeAd loaded");
                if (nativeUnifiedAdResponse == null) {
                    BZUnifiedNativeAdapter bZUnifiedNativeAdapter = BZUnifiedNativeAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    BZUnifiedNativeAdapter.super.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(nativeUnifiedAdResponse);
                BZUnifiedNativeAdapter.this.convertAdapterResponse(arrayList);
                BZUnifiedNativeAdapter bZUnifiedNativeAdapter2 = BZUnifiedNativeAdapter.this;
                int i6 = 0;
                bZUnifiedNativeAdapter2.response = (BeiziTransformEntry) ((AMPSUnifiedNativeAdapter) bZUnifiedNativeAdapter2).mUnifiedNativeItemsList.get(0);
                try {
                    i6 = nativeUnifiedAdResponse.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                BZUnifiedNativeAdapter bZUnifiedNativeAdapter3 = BZUnifiedNativeAdapter.this;
                if (bZUnifiedNativeAdapter3.isBidding) {
                    bZUnifiedNativeAdapter3.onC2SBiddingSuccess(i6);
                } else {
                    bZUnifiedNativeAdapter3.onAdLoad();
                }
            }

            @Override // com.beizi.fusion.NativeUnifiedAdListener
            public void onAdShown() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadUnifiedNativeAd shown");
                BZUnifiedNativeAdapter.this.onAdShow();
                if (BZUnifiedNativeAdapter.this.response == null || BZUnifiedNativeAdapter.this.response.getAdEventListener() == null) {
                    return;
                }
                BZUnifiedNativeAdapter.this.response.getAdEventListener().onADExposed();
            }
        }, 5000L, 1);
        this.mUnifiedAd = nativeUnifiedAd;
        nativeUnifiedAd.setHideDownloadInfo(true);
        this.mUnifiedAd.setHideAdLogo(true);
        this.mUnifiedAd.loadAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mUnifiedAd != null;
    }

    private void initSDK() {
        BZInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadUnifiedNativeAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        NativeUnifiedAd nativeUnifiedAd = this.mUnifiedAd;
        if (nativeUnifiedAd != null) {
            nativeUnifiedAd.destroy();
            this.mUnifiedAd = null;
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        Map<String, String> lossInfo;
        super.sendLossNotice(aMPSBidResult);
        try {
            if (this.mUnifiedAd != null && aMPSBidResult != null && (lossInfo = BZInitMediation.getInstance().getLossInfo(aMPSBidResult)) != null) {
                this.mUnifiedAd.sendLossNotificationWithInfo(lossInfo);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        super.sendWinNotice(aMPSBidResult);
        try {
            if (this.mUnifiedAd != null && aMPSBidResult != null) {
                BeiziTransformEntry beiziTransformEntry = this.response;
                if (beiziTransformEntry != null) {
                    beiziTransformEntry.setEcpm(aMPSBidResult.getWinPrice());
                }
                Map<String, String> winInfo = BZInitMediation.getInstance().getWinInfo(aMPSBidResult);
                if (winInfo != null) {
                    this.mUnifiedAd.sendWinNotificationWithInfo(winInfo);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
