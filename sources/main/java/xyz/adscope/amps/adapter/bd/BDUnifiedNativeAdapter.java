package xyz.adscope.amps.adapter.bd;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XNativeView;
import java.util.HashMap;
import java.util.List;
import xyz.adscope.amps.ad.unified.AMPSUnifiedNativeAdError;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdAdapterListener;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter;
import xyz.adscope.amps.ad.unified.inter.AMPSAppDetail;
import xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedOptimizeController;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedPattern;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedVideoListener;
import xyz.adscope.amps.ad.unified.inter.AMPSVideoConfig;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedMediaViewStub;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedRootContainer;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BDUnifiedNativeAdapter extends AMPSUnifiedNativeAdapter<NativeResponse> {
    private BaiduNativeManager mBaiduNativeManager;
    private List<NativeResponse> mExpressResponseList;

    public class BaiduFeedAdListener implements BaiduNativeManager.FeedAdListener {
        private BaiduFeedAdListener() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i6, String str, NativeResponse nativeResponse) {
            BDUnifiedNativeAdapter.this.onAdFailed(i6 + "", str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i6, String str, NativeResponse nativeResponse) {
            BDUnifiedNativeAdapter.this.onAdFailed(i6 + "", str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(List<NativeResponse> list) {
            list.size();
            if (!list.isEmpty()) {
                BDUnifiedNativeAdapter.this.convertAdapterResponse(list);
                BDUnifiedNativeAdapter.this.mExpressResponseList = list;
                int i6 = 0;
                try {
                    NativeResponse nativeResponse = list.get(0);
                    if (nativeResponse != null) {
                        i6 = Integer.parseInt(nativeResponse.getECPMLevel());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                BDUnifiedNativeAdapter bDUnifiedNativeAdapter = BDUnifiedNativeAdapter.this;
                if (bDUnifiedNativeAdapter.isBidding) {
                    bDUnifiedNativeAdapter.onC2SBiddingSuccess(i6);
                    return;
                } else {
                    bDUnifiedNativeAdapter.onAdLoad();
                    return;
                }
            }
            BDUnifiedNativeAdapter bDUnifiedNativeAdapter2 = BDUnifiedNativeAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
            bDUnifiedNativeAdapter2.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
        }
    }

    public static class BaiduTransformEntry extends AMPSBaseTransformEntry {
        private NativeResponse mSrc;

        private BaiduTransformEntry(NativeResponse nativeResponse, Context context, int i6, AMPSVideoConfig aMPSVideoConfig, AMPSUnifiedNativeAdapter aMPSUnifiedNativeAdapter) {
            super(context, i6, aMPSVideoConfig, aMPSUnifiedNativeAdapter);
            this.mSrc = nativeResponse;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToMediaView(Activity activity, AMPSUnifiedMediaViewStub aMPSUnifiedMediaViewStub, final AMPSUnifiedVideoListener aMPSUnifiedVideoListener) {
            if (this.mSrc == null) {
                return;
            }
            XNativeView xNativeView = new XNativeView(activity);
            xNativeView.setNativeVideoListener(new INativeVideoListener() { // from class: xyz.adscope.amps.adapter.bd.BDUnifiedNativeAdapter.BaiduTransformEntry.2
                @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                public void onCompletion() {
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoCompleted();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                public void onError() {
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoError(new AMPSUnifiedNativeAdError(-1, "baidu video error"));
                    }
                }

                @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                public void onPause() {
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoPause();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                public void onRenderingStart() {
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoStart();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                public void onResume() {
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoResume();
                    }
                }
            });
            aMPSUnifiedMediaViewStub.addView(xNativeView);
            AMPSVideoConfig aMPSVideoConfig = this.mVideoConfig;
            if (aMPSVideoConfig != null) {
                xNativeView.setVideoMute(aMPSVideoConfig.isMute());
            }
            xNativeView.setNativeItem(this.mSrc);
            xNativeView.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: xyz.adscope.amps.adapter.bd.BDUnifiedNativeAdapter.BaiduTransformEntry.3
                @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
                public void onNativeViewClick(XNativeView xNativeView2) {
                    if (((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdEventListener.onADClicked();
                    }
                }
            });
            xNativeView.render();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToRootContainer(Activity activity, AMPSUnifiedRootContainer aMPSUnifiedRootContainer, List<View> list, List<View> list2) {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return;
            }
            nativeResponse.registerViewForInteraction(aMPSUnifiedRootContainer, list, list2, new NativeResponse.AdInteractionListener() { // from class: xyz.adscope.amps.adapter.bd.BDUnifiedNativeAdapter.BaiduTransformEntry.1
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposed() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK loadUnifiedNativeAd exposed ");
                    if (((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdapter.onAdShow();
                    }
                    if (((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdEventListener.onADExposed();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposureFailed(int i6) {
                    if (((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdapter.onAdShowFailed(i6 + "", i6 + "");
                    }
                    if (((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdEventListener != null) {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK loadUnifiedNativeAd exposure failed " + i6);
                        ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdEventListener.onADExposeError(i6, "onADExposureFailed");
                    }
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADStatusChanged() {
                    if (((AMPSBaseTransformEntry) BaiduTransformEntry.this).mDownloadListener != null) {
                        int downloadStatus = BaiduTransformEntry.this.mSrc.getDownloadStatus();
                        if (downloadStatus >= 0 && downloadStatus <= 100) {
                            ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mDownloadListener.onDownloadProgressUpdate(downloadStatus);
                            return;
                        }
                        if (downloadStatus == 101) {
                            ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mDownloadListener.onDownloadFinished();
                            return;
                        }
                        if (downloadStatus == 102) {
                            ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mDownloadListener.onDownloadPaused(-1);
                        } else if (downloadStatus == 103) {
                            ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mDownloadListener.onInstalled();
                        } else if (downloadStatus == 104) {
                            ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mDownloadListener.onDownloadFailed();
                        }
                    }
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdClick() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK loadUnifiedNativeAd click ");
                    if (((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdapter.onAdClicked();
                    }
                    if (((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) BaiduTransformEntry.this).mAdEventListener.onADClicked();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdUnionClick() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK loadUnifiedNativeAd union click ");
                }
            });
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getActionButtonText() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getActButtonString();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSUnifiedPattern getAdPattern() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return AMPSUnifiedPattern.AD_PATTERN_UNKNOWN;
            }
            NativeResponse.MaterialType materialType = nativeResponse.getMaterialType();
            return materialType == NativeResponse.MaterialType.NORMAL ? AMPSUnifiedPattern.AD_PATTERN_TEXT_IMAGE : materialType == NativeResponse.MaterialType.VIDEO ? AMPSUnifiedPattern.AD_PATTERN_VIDEO : AMPSUnifiedPattern.AD_PATTERN_UNKNOWN;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getAdSourceLogoUrl() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getBaiduLogoUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDescription() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getAppFunctionLink();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDeveloper() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getPublisher();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppIconUrl() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getIconUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppName() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getBrandName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPackageName() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getAppPackage();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPermissionInfo() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getAppPermissionLink();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPrivacyPolicy() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getAppPrivacyLink();
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
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getAppVersion();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getDesc() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getDesc();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getIconUrl() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getIconUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public int getImageHeight() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return 0;
            }
            return nativeResponse.getMainPicHeight();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public int getImageWidth() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return 0;
            }
            return nativeResponse.getMainPicWidth();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public List<String> getImagesUrl() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getMultiPicUrls();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getMainImageUrl() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getImageUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedOptimizeController
        public View getOptimizeShakeView(int i6, int i7) {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.renderShakeView(i6, i7, null);
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedOptimizeController
        public View getOptimizeSlideView(int i6, int i7, int i8) {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.renderSlideView(i6, i7, i8, null);
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getTitle() {
            NativeResponse nativeResponse = this.mSrc;
            if (nativeResponse == null) {
                return null;
            }
            return nativeResponse.getTitle();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public boolean isValid() {
            return this.mSrc != null;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSAppDetail getAppDetail() {
            return this;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSUnifiedOptimizeController getOptimizeController() {
            return this;
        }
    }

    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter
    public AMPSUnifiedNativeItem convertEntryFromAdapterResponse(NativeResponse nativeResponse) {
        int i6 = this.mAdEcpm;
        try {
            if (this.isBidding) {
                i6 = Integer.parseInt(nativeResponse.getECPMLevel());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return new BaiduTransformEntry(nativeResponse, this.mContext, i6, new AMPSVideoConfig(!this.isVolumeOn, this.autoPlayPolicy), this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSUnifiedNativeAdAdapterListener aMPSUnifiedNativeAdAdapterListener) {
        List<NativeResponse> list;
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSUnifiedNativeAdAdapterListener);
        if (!this.isBidding || (list = this.mExpressResponseList) == null || list.isEmpty()) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    private void loadUnifiedNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK loadUnifiedNativeAd " + this.mSpaceId);
        this.mBaiduNativeManager = new BaiduNativeManager(this.mContext, this.mSpaceId);
        this.mBaiduNativeManager.loadFeedAd(new RequestParameters.Builder().build(), new BaiduFeedAdListener());
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mBaiduNativeManager != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            List<NativeResponse> list = this.mExpressResponseList;
            if (list != null && aMPSBidResult != null) {
                NativeResponse nativeResponse = list.size() > 0 ? this.mExpressResponseList.get(0) : null;
                if (nativeResponse == null) {
                    return;
                }
                nativeResponse.biddingFail(BDInitMediation.getInstance().getWinInfo(aMPSBidResult), new BiddingListener() { // from class: xyz.adscope.amps.adapter.bd.BDUnifiedNativeAdapter.2
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public void onBiddingResult(boolean z5, String str, HashMap<String, Object> hashMap) {
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            List<NativeResponse> list = this.mExpressResponseList;
            if (list != null && aMPSBidResult != null) {
                NativeResponse nativeResponse = list.size() > 0 ? this.mExpressResponseList.get(0) : null;
                if (nativeResponse == null) {
                    return;
                }
                nativeResponse.biddingSuccess(BDInitMediation.getInstance().getSecondInfo(aMPSBidResult), new BiddingListener() { // from class: xyz.adscope.amps.adapter.bd.BDUnifiedNativeAdapter.1
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public void onBiddingResult(boolean z5, String str, HashMap<String, Object> hashMap) {
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void initSDK() {
        BDInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadUnifiedNativeAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        if (this.mBaiduNativeManager != null) {
            this.mBaiduNativeManager = null;
        }
        List<NativeResponse> list = this.mExpressResponseList;
        if (list != null) {
            list.clear();
            this.mExpressResponseList = null;
        }
    }

    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
