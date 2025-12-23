package xyz.adscope.amps.adapter.gm;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.snail.antifake.deviceid.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdAdapterListener;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter;
import xyz.adscope.amps.ad.unified.inter.AMPSAppDetail;
import xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedPattern;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedVideoListener;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedMediaViewStub;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedRootContainer;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GMUnifiedNativeAdapter extends AMPSUnifiedNativeAdapter<TTFeedAd> {
    private List<TTFeedAd> mTTAdList;
    private TTAdNative mTTAdNative;

    public static class GMTransformEntry extends AMPSBaseTransformEntry {
        private TTFeedAd mSrc;

        private GMTransformEntry(TTFeedAd tTFeedAd, Context context, int i6, AMPSUnifiedNativeAdapter aMPSUnifiedNativeAdapter) {
            super(context, i6, null, aMPSUnifiedNativeAdapter);
            this.mSrc = tTFeedAd;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToMediaView(Activity activity, AMPSUnifiedMediaViewStub aMPSUnifiedMediaViewStub, AMPSUnifiedVideoListener aMPSUnifiedVideoListener) {
            View adView;
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || aMPSUnifiedMediaViewStub == null || (adView = tTFeedAd.getAdView()) == null) {
                return;
            }
            aMPSUnifiedMediaViewStub.addView(adView);
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToRootContainer(Activity activity, AMPSUnifiedRootContainer aMPSUnifiedRootContainer, List<View> list, List<View> list2) {
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null) {
                return;
            }
            if (tTFeedAd.getInteractionType() == 4) {
                this.mSrc.setDownloadListener(new TTAppDownloadListener() { // from class: xyz.adscope.amps.adapter.gm.GMUnifiedNativeAdapter.GMTransformEntry.1
                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadActive(long j6, long j7, String str, String str2) {
                        if (((AMPSBaseTransformEntry) GMTransformEntry.this).mDownloadListener != null) {
                            ((AMPSBaseTransformEntry) GMTransformEntry.this).mDownloadListener.onDownloadProgressUpdate((int) j7);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFailed(long j6, long j7, String str, String str2) {
                        if (((AMPSBaseTransformEntry) GMTransformEntry.this).mDownloadListener != null) {
                            ((AMPSBaseTransformEntry) GMTransformEntry.this).mDownloadListener.onDownloadFailed();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFinished(long j6, String str, String str2) {
                        if (((AMPSBaseTransformEntry) GMTransformEntry.this).mDownloadListener != null) {
                            ((AMPSBaseTransformEntry) GMTransformEntry.this).mDownloadListener.onDownloadFinished();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadPaused(long j6, long j7, String str, String str2) {
                        if (((AMPSBaseTransformEntry) GMTransformEntry.this).mDownloadListener != null) {
                            ((AMPSBaseTransformEntry) GMTransformEntry.this).mDownloadListener.onDownloadPaused((int) j7);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onInstalled(String str, String str2) {
                        if (((AMPSBaseTransformEntry) GMTransformEntry.this).mDownloadListener != null) {
                            ((AMPSBaseTransformEntry) GMTransformEntry.this).mDownloadListener.onInstalled();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onIdle() {
                    }
                });
            }
            this.mSrc.registerViewForInteraction(aMPSUnifiedRootContainer, list, list2, null, new TTNativeAd.AdInteractionListener() { // from class: xyz.adscope.amps.adapter.gm.GMUnifiedNativeAdapter.GMTransformEntry.2
                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadUnifiedNativeAd onAdClicked");
                    if (((AMPSBaseTransformEntry) GMTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) GMTransformEntry.this).mAdapter.onAdClicked();
                    }
                    if (((AMPSBaseTransformEntry) GMTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) GMTransformEntry.this).mAdEventListener.onADClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadUnifiedNativeAd onAdCreativeClick");
                    if (((AMPSBaseTransformEntry) GMTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) GMTransformEntry.this).mAdapter.onAdClicked();
                    }
                    if (((AMPSBaseTransformEntry) GMTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) GMTransformEntry.this).mAdEventListener.onADClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd tTNativeAd) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadUnifiedNativeAd onAdShow");
                    if (((AMPSBaseTransformEntry) GMTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) GMTransformEntry.this).mAdapter.onAdShow();
                    }
                    if (((AMPSBaseTransformEntry) GMTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) GMTransformEntry.this).mAdEventListener.onADExposed();
                    }
                }
            });
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void destroy() {
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null) {
                return;
            }
            tTFeedAd.destroy();
            super.destroy();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getActionButtonText() {
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null) {
                return null;
            }
            return tTFeedAd.getButtonText();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSUnifiedPattern getAdPattern() {
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null) {
                return AMPSUnifiedPattern.AD_PATTERN_UNKNOWN;
            }
            int imageMode = tTFeedAd.getImageMode();
            if (imageMode != 15) {
                if (imageMode == 16 || imageMode == 2 || imageMode == 3) {
                    return AMPSUnifiedPattern.AD_PATTERN_TEXT_IMAGE;
                }
                if (imageMode == 4) {
                    return AMPSUnifiedPattern.AD_PATTERN_3_IMAGES;
                }
                if (imageMode != 5) {
                    return AMPSUnifiedPattern.AD_PATTERN_UNKNOWN;
                }
            }
            return AMPSUnifiedPattern.AD_PATTERN_VIDEO;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public View getAdSourceLogo() {
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || this.mContext == null) {
                return null;
            }
            Bitmap adLogo = tTFeedAd.getAdLogo();
            if (adLogo != null) {
                ImageView imageView = new ImageView(this.mContext);
                imageView.setImageBitmap(adLogo);
                return imageView;
            }
            TextView textView = new TextView(this.mContext);
            textView.setText("穿山甲");
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            textView.setPadding(5, 4, 5, 4);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(2, 10.0f);
            textView.setGravity(17);
            return textView;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDescription() {
            ComplianceInfo complianceInfo;
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || (complianceInfo = tTFeedAd.getComplianceInfo()) == null) {
                return null;
            }
            return complianceInfo.getFunctionDescUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDeveloper() {
            ComplianceInfo complianceInfo;
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || (complianceInfo = tTFeedAd.getComplianceInfo()) == null) {
                return null;
            }
            return complianceInfo.getDeveloperName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppIconUrl() {
            TTImage icon;
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || (icon = tTFeedAd.getIcon()) == null) {
                return null;
            }
            return icon.getImageUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppName() {
            ComplianceInfo complianceInfo;
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || (complianceInfo = tTFeedAd.getComplianceInfo()) == null) {
                return null;
            }
            return complianceInfo.getAppName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPermissionInfo() {
            ComplianceInfo complianceInfo;
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || (complianceInfo = tTFeedAd.getComplianceInfo()) == null) {
                return null;
            }
            if (!TextUtils.isEmpty(complianceInfo.getPermissionUrl())) {
                return complianceInfo.getPermissionUrl();
            }
            Map<String, String> permissionsMap = complianceInfo.getPermissionsMap();
            StringBuilder sb = new StringBuilder();
            if (permissionsMap != null && permissionsMap.size() > 0) {
                for (Map.Entry<String, String> entry : permissionsMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    sb.append(key);
                    sb.append(":");
                    sb.append(value);
                    sb.append(e.f37542d);
                }
            }
            return sb.toString();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPrivacyPolicy() {
            ComplianceInfo complianceInfo;
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || (complianceInfo = tTFeedAd.getComplianceInfo()) == null) {
                return null;
            }
            return complianceInfo.getPrivacyUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppScore() {
            if (this.mSrc == null) {
                return null;
            }
            return this.mSrc.getAppScore() + "";
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppSize() {
            if (this.mSrc == null) {
                return null;
            }
            return this.mSrc.getAppSize() + "";
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppVersion() {
            ComplianceInfo complianceInfo;
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || (complianceInfo = tTFeedAd.getComplianceInfo()) == null) {
                return null;
            }
            return complianceInfo.getAppVersion();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getDesc() {
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null) {
                return null;
            }
            return tTFeedAd.getDescription();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public Map<String, Object> getExtras() {
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null) {
                return null;
            }
            return tTFeedAd.getMediaExtraInfo();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getIconUrl() {
            TTImage icon;
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || (icon = tTFeedAd.getIcon()) == null) {
                return null;
            }
            return icon.getImageUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public List<String> getImagesUrl() {
            TTFeedAd tTFeedAd = this.mSrc;
            ArrayList arrayList = null;
            if (tTFeedAd == null) {
                return null;
            }
            List<TTImage> imageList = tTFeedAd.getImageList();
            if (imageList != null && imageList.size() != 0) {
                arrayList = new ArrayList();
                for (TTImage tTImage : imageList) {
                    if (tTImage != null) {
                        arrayList.add(tTImage.getImageUrl());
                    }
                }
            }
            return arrayList;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getMainImageUrl() {
            List<TTImage> imageList;
            TTImage tTImage;
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null || (imageList = tTFeedAd.getImageList()) == null || imageList.size() == 0 || (tTImage = imageList.get(0)) == null) {
                return null;
            }
            return tTImage.getImageUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getTitle() {
            TTFeedAd tTFeedAd = this.mSrc;
            if (tTFeedAd == null) {
                return null;
            }
            return tTFeedAd.getTitle();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public boolean isValid() {
            return this.mSrc != null;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSAppDetail getAppDetail() {
            return this;
        }
    }

    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter
    public AMPSUnifiedNativeItem convertEntryFromAdapterResponse(TTFeedAd tTFeedAd) {
        return new GMTransformEntry(tTFeedAd, this.mContext, this.mAdEcpm, this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSUnifiedNativeAdAdapterListener aMPSUnifiedNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSUnifiedNativeAdAdapterListener);
        initSDK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUnifiedNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK start loadUnifiedNativeAd  spaceId:" + this.mSpaceId);
        this.mTTAdNative = GMInitMediation.get().createAdNative(this.mContext);
        if (this.expressViewHeight <= 0) {
            this.expressViewHeight = 0;
        }
        this.mTTAdNative.loadFeedAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdCount(this.adCount).setImageAcceptedSize(this.expressViewWidth, this.expressViewHeight).build(), new TTAdNative.FeedAdListener() { // from class: xyz.adscope.amps.adapter.gm.GMUnifiedNativeAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadUnifiedNativeAd onNativeLoadFail code:" + i6 + " message:" + str);
                GMUnifiedNativeAdapter gMUnifiedNativeAdapter = GMUnifiedNativeAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                sb.append("");
                gMUnifiedNativeAdapter.onAdFailed(sb.toString(), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadUnifiedNativeAd onNativeExpressAdLoad");
                if (list == null || list.size() == 0) {
                    GMUnifiedNativeAdapter gMUnifiedNativeAdapter = GMUnifiedNativeAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    gMUnifiedNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                } else {
                    GMUnifiedNativeAdapter.this.convertAdapterResponse(list);
                    GMUnifiedNativeAdapter.this.mTTAdList = list;
                    GMUnifiedNativeAdapter.this.onAdLoad();
                }
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTFeedAd tTFeedAd;
        List<TTFeedAd> list = this.mTTAdList;
        if (list == null || list.size() < 1 || (tTFeedAd = this.mTTAdList.get(0)) == null) {
            return null;
        }
        return tTFeedAd.getMediaExtraInfo();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mTTAdNative != null;
    }

    private void initSDK() {
        GMInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.gm.GMUnifiedNativeAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadUnifiedNativeAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                GMUnifiedNativeAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                GMUnifiedNativeAdapter.this.loadUnifiedNativeAd();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        if (this.mTTAdNative != null) {
            this.mTTAdNative = null;
        }
        List<TTFeedAd> list = this.mTTAdList;
        if (list != null) {
            list.clear();
            this.mTTAdList = null;
        }
    }
}
