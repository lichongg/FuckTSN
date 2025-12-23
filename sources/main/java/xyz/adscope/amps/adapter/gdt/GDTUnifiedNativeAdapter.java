package xyz.adscope.amps.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdError;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.unified.AMPSUnifiedNativeAdError;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdAdapterListener;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter;
import xyz.adscope.amps.ad.unified.inter.AMPSAppDetail;
import xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedPattern;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedVideoListener;
import xyz.adscope.amps.ad.unified.inter.AMPSVideoConfig;
import xyz.adscope.amps.ad.unified.view.AMPSRootInsertHelper;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedMediaViewStub;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedRootContainer;
import xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback;
import xyz.adscope.amps.adapter.gdt.model.BidResponseModel;
import xyz.adscope.amps.adapter.gdt.util.GDTBiddingRequestUtil;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GDTUnifiedNativeAdapter extends AMPSUnifiedNativeAdapter<NativeUnifiedADData> {
    private NativeUnifiedAD gdtAdManager;
    private BidResponseModel mBidResponseModel;
    private String mToken;
    private NativeADUnifiedListener nativeADUnifiedListener = new NativeADUnifiedListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTUnifiedNativeAdapter.1
        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadUnifiedNativeAd onADLoaded ");
            if (list == null || list.isEmpty()) {
                GDTUnifiedNativeAdapter gDTUnifiedNativeAdapter = GDTUnifiedNativeAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                gDTUnifiedNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                return;
            }
            GDTUnifiedNativeAdapter.this.convertAdapterResponse(list);
            GDTUnifiedNativeAdapter.this.nativeUnifiedADDataList = list;
            NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) GDTUnifiedNativeAdapter.this.nativeUnifiedADDataList.get(0);
            int ecpm = nativeUnifiedADData != null ? nativeUnifiedADData.getECPM() : 0;
            if (GDTUnifiedNativeAdapter.this.isC2SAdSource()) {
                GDTUnifiedNativeAdapter.this.onC2SBiddingSuccess(ecpm);
            } else {
                GDTUnifiedNativeAdapter.this.onAdLoad();
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                String str = adError.getErrorCode() + "";
                String errorMsg = adError.getErrorMsg();
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadUnifiedNativeAd onNoAD: " + str + " " + errorMsg);
                GDTUnifiedNativeAdapter.this.onAdFailed(str, errorMsg);
            }
        }
    };
    private List<NativeUnifiedADData> nativeUnifiedADDataList;

    public static class GDTTransformEntry extends AMPSBaseTransformEntry {
        private NativeUnifiedADData mSrc;

        private GDTTransformEntry(NativeUnifiedADData nativeUnifiedADData, AMPSVideoConfig aMPSVideoConfig, int i6, AMPSUnifiedNativeAdapter aMPSUnifiedNativeAdapter) {
            super(null, i6, aMPSVideoConfig, aMPSUnifiedNativeAdapter);
            this.mSrc = nativeUnifiedADData;
            bindSrcCallback();
        }

        private void bindSrcCallback() {
            this.mSrc.setNativeAdEventListener(new NativeADEventListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTUnifiedNativeAdapter.GDTTransformEntry.1
                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadUnifiedNativeAd clicked... ");
                    if (((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdapter.onAdClicked();
                    }
                    if (((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdEventListener.onADClicked();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADError(AdError adError) {
                    int i6;
                    String str;
                    if (adError != null) {
                        i6 = adError.getErrorCode();
                        str = adError.getErrorMsg();
                    } else {
                        i6 = -1;
                        str = "";
                    }
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadUnifiedNativeAd onAdError... " + i6 + " " + str);
                    if (((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdapter.onAdShowFailed(i6 + "", str);
                    }
                    if (((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdEventListener.onADExposeError(i6, str);
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadUnifiedNativeAd exposed... ");
                    if (((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdapter.onAdShow();
                    }
                    if (((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mAdEventListener.onADExposed();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                    if (!GDTTransformEntry.this.mSrc.isAppAd() || ((AMPSBaseTransformEntry) GDTTransformEntry.this).mDownloadListener == null) {
                        return;
                    }
                    int appStatus = GDTTransformEntry.this.mSrc.getAppStatus();
                    if (appStatus == 1) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mDownloadListener.onInstalled();
                        return;
                    }
                    if (appStatus == 4) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mDownloadListener.onDownloadProgressUpdate(GDTTransformEntry.this.mSrc.getProgress());
                        return;
                    }
                    if (appStatus == 8) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mDownloadListener.onDownloadFinished();
                    } else if (appStatus == 16) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mDownloadListener.onDownloadFailed();
                    } else {
                        if (appStatus != 32) {
                            return;
                        }
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mDownloadListener.onDownloadPaused(GDTTransformEntry.this.mSrc.getProgress());
                    }
                }
            });
            this.mSrc.setNegativeFeedbackListener(new NegativeFeedbackListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTUnifiedNativeAdapter.GDTTransformEntry.2
                @Override // com.qq.e.comm.listeners.NegativeFeedbackListener
                public void onComplainSuccess() {
                    if (((AMPSBaseTransformEntry) GDTTransformEntry.this).mNegativeFeedbackListener != null) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mNegativeFeedbackListener.onComplainSuccess();
                    }
                }
            });
            this.mSrc.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTUnifiedNativeAdapter.GDTTransformEntry.3
                @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                public void onDownloadConfirm(Activity activity, int i6, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadUnifiedNativeAd download confirm... ");
                    if (((AMPSBaseTransformEntry) GDTTransformEntry.this).mDownloadListener != null) {
                        ((AMPSBaseTransformEntry) GDTTransformEntry.this).mDownloadListener.onDownloadStarted();
                    }
                }
            });
        }

        private VideoOption getVideoOption() {
            VideoOption.Builder builder = new VideoOption.Builder();
            AMPSVideoConfig aMPSVideoConfig = this.mVideoConfig;
            if (aMPSVideoConfig != null) {
                if (aMPSVideoConfig.getVideoMaxTime() > 0) {
                    builder.setMaxVideoDuration(this.mVideoConfig.getVideoMaxTime());
                }
                builder.setAutoPlayMuted(this.mVideoConfig.isMute());
                int autoPlayPrivacy = this.mVideoConfig.getAutoPlayPrivacy();
                if (autoPlayPrivacy == 0) {
                    builder.setAutoPlayPolicy(2);
                } else if (autoPlayPrivacy == 1) {
                    builder.setAutoPlayPolicy(0);
                } else if (autoPlayPrivacy == 2) {
                    builder.setAutoPlayPolicy(1);
                }
            }
            return builder.setEnableUserControl(false).build();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToMediaView(Activity activity, AMPSUnifiedMediaViewStub aMPSUnifiedMediaViewStub, final AMPSUnifiedVideoListener aMPSUnifiedVideoListener) {
            if (this.mSrc == null) {
                return;
            }
            MediaView mediaView = new MediaView(activity);
            aMPSUnifiedMediaViewStub.addView(mediaView, new FrameLayout.LayoutParams(-1, -1));
            NativeADMediaListener nativeADMediaListener = new NativeADMediaListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTUnifiedNativeAdapter.GDTTransformEntry.4
                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoClicked() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video click... ");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoClicked();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoCompleted() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video completed... ");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoCompleted();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoError(AdError adError) {
                    if (aMPSUnifiedVideoListener == null || adError == null) {
                        return;
                    }
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video error... " + adError.getErrorCode() + " " + adError.getErrorMsg());
                    aMPSUnifiedVideoListener.onVideoError(new AMPSUnifiedNativeAdError(adError.getErrorCode(), adError.getErrorMsg()));
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoInit() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video init... ");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoInit();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoaded(int i6) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video loaded... ");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoLoaded(i6);
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoading() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video loading... ");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoLoading();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoPause() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video pause... ");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoPause();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoReady() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video ready... ");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoReady();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoResume() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video resume... ");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoResume();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStart() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video start... ");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoStart();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStop() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDKloadUnifiedNativeAd video stop... ");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoStop();
                    }
                }
            };
            this.mSrc.bindMediaView(mediaView, getVideoOption(), nativeADMediaListener);
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToRootContainer(Activity activity, AMPSUnifiedRootContainer aMPSUnifiedRootContainer, List<View> list, List<View> list2) {
            if (this.mSrc == null) {
                return;
            }
            NativeAdContainer nativeAdContainer = new NativeAdContainer(activity);
            AMPSRootInsertHelper.insertRootView(aMPSUnifiedRootContainer, nativeAdContainer);
            this.mSrc.bindAdToView(activity, nativeAdContainer, null, list, list2);
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void destroy() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return;
            }
            nativeUnifiedADData.destroy();
            super.destroy();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getActionButtonText() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return null;
            }
            return nativeUnifiedADData.getButtonText();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSUnifiedPattern getAdPattern() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return AMPSUnifiedPattern.AD_PATTERN_UNKNOWN;
            }
            int adPatternType = nativeUnifiedADData.getAdPatternType();
            if (adPatternType != 1) {
                if (adPatternType == 2) {
                    return AMPSUnifiedPattern.AD_PATTERN_VIDEO;
                }
                if (adPatternType == 3) {
                    return AMPSUnifiedPattern.AD_PATTERN_3_IMAGES;
                }
                if (adPatternType != 4) {
                    return AMPSUnifiedPattern.AD_PATTERN_UNKNOWN;
                }
            }
            return AMPSUnifiedPattern.AD_PATTERN_TEXT_IMAGE;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDescription() {
            NativeUnifiedADAppMiitInfo appMiitInfo;
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) {
                return null;
            }
            return appMiitInfo.getDescriptionUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDeveloper() {
            NativeUnifiedADAppMiitInfo appMiitInfo;
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) {
                return null;
            }
            return appMiitInfo.getAuthorName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppName() {
            NativeUnifiedADAppMiitInfo appMiitInfo;
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) {
                return null;
            }
            return appMiitInfo.getAppName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPermissionInfo() {
            NativeUnifiedADAppMiitInfo appMiitInfo;
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) {
                return null;
            }
            return appMiitInfo.getPermissionsUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPrice() {
            if (this.mSrc == null) {
                return null;
            }
            return this.mSrc.getAppPrice() + "";
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPrivacyPolicy() {
            NativeUnifiedADAppMiitInfo appMiitInfo;
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) {
                return null;
            }
            return appMiitInfo.getPrivacyAgreement();
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
            NativeUnifiedADAppMiitInfo appMiitInfo;
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) {
                return null;
            }
            return appMiitInfo.getPackageSizeBytes() + "";
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppVersion() {
            NativeUnifiedADAppMiitInfo appMiitInfo;
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null || (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) == null) {
                return null;
            }
            return appMiitInfo.getVersionName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getDesc() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return null;
            }
            return nativeUnifiedADData.getDesc();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getDownloadCountDesc() {
            if (this.mSrc == null) {
                return null;
            }
            return this.mSrc.getDownloadCount() + "";
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public Map<String, Object> getExtras() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return null;
            }
            return nativeUnifiedADData.getExtraInfo();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getIconUrl() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return null;
            }
            return nativeUnifiedADData.getIconUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public int getImageHeight() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return 0;
            }
            return nativeUnifiedADData.getPictureHeight();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public int getImageWidth() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return 0;
            }
            return nativeUnifiedADData.getPictureWidth();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public List<String> getImagesUrl() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return null;
            }
            return nativeUnifiedADData.getImgList();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getMainImageUrl() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return null;
            }
            return nativeUnifiedADData.getImgUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getTitle() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return null;
            }
            return nativeUnifiedADData.getTitle();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public boolean isValid() {
            NativeUnifiedADData nativeUnifiedADData = this.mSrc;
            if (nativeUnifiedADData == null) {
                return false;
            }
            return nativeUnifiedADData.isValid();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSAppDetail getAppDetail() {
            return this;
        }
    }

    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter
    public AMPSUnifiedNativeItem convertEntryFromAdapterResponse(NativeUnifiedADData nativeUnifiedADData) {
        AMPSVideoConfig aMPSVideoConfig = new AMPSVideoConfig(!this.isVolumeOn, this.autoPlayPolicy);
        aMPSVideoConfig.setVideoMaxTime(this.videoMaxTime);
        int i6 = this.mAdEcpm;
        if (this.isBidding) {
            i6 = nativeUnifiedADData.getECPM();
        }
        return new GDTTransformEntry(nativeUnifiedADData, aMPSVideoConfig, i6, this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSUnifiedNativeAdAdapterListener aMPSUnifiedNativeAdAdapterListener) {
        List<NativeUnifiedADData> list;
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSUnifiedNativeAdAdapterListener);
        if (isC2SAdSource() && (list = this.nativeUnifiedADDataList) != null && !list.isEmpty()) {
            onAdLoad();
        } else {
            initSDK();
            loadUnifiedNativeAd();
        }
    }

    private void loadUnifiedNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadUnifiedNativeAd  " + this.mSpaceId);
        this.gdtAdManager = TextUtils.isEmpty(this.mToken) ? new NativeUnifiedAD(this.mContext, this.mSpaceId, this.nativeADUnifiedListener) : new NativeUnifiedAD(this.mContext, this.mSpaceId, this.nativeADUnifiedListener, this.mToken);
        this.gdtAdManager.loadData(this.adCount);
    }

    private void startS2SBidding() {
        GDTBiddingRequestUtil.getBidResponse(this.mContext, this.mServerUrl, this.mAppId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.gdt.GDTUnifiedNativeAdapter.2
            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                GDTUnifiedNativeAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                if (bidResponseModel == null) {
                    return;
                }
                GDTUnifiedNativeAdapter.this.mToken = str;
                GDTUnifiedNativeAdapter.this.mBidResponseModel = bidResponseModel;
                GDTUnifiedNativeAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        List<NativeUnifiedADData> list = this.nativeUnifiedADDataList;
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        NativeUnifiedADData nativeUnifiedADData;
        if (aMPSBidResult == null) {
            return;
        }
        try {
            if (isC2SAdSource()) {
                List<NativeUnifiedADData> list = this.nativeUnifiedADDataList;
                if (list != null && list.size() != 0 && (nativeUnifiedADData = this.nativeUnifiedADDataList.get(0)) != null) {
                    GDTAdManagerHolder.sendLossNotification(nativeUnifiedADData, aMPSBidResult.getReason());
                }
                return;
            }
            if (isS2SAdSource()) {
                GDTBiddingRequestUtil.sendLossNotice(this.mBidResponseModel, aMPSBidResult.getEcpm(), aMPSBidResult.getReason(), this.mPublicKey);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        NativeUnifiedADData nativeUnifiedADData;
        try {
            List<NativeUnifiedADData> list = this.nativeUnifiedADDataList;
            if (list != null && !list.isEmpty() && (nativeUnifiedADData = this.nativeUnifiedADDataList.get(0)) != null) {
                int ecpm = nativeUnifiedADData.getECPM();
                if (isC2SAdSource()) {
                    GDTAdManagerHolder.sendWinNotification(nativeUnifiedADData, ecpm);
                } else if (isS2SAdSource()) {
                    GDTBiddingRequestUtil.sendWinNotice(this.mBidResponseModel, this.mPublicKey);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void initSDK() {
        GDTInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        if (this.gdtAdManager != null) {
            this.gdtAdManager = null;
        }
        List<NativeUnifiedADData> list = this.nativeUnifiedADDataList;
        if (list != null) {
            list.clear();
            this.nativeUnifiedADDataList = null;
        }
    }

    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
        if (isC2SAdSource()) {
            loadUnifiedNativeAd();
        } else if (isS2SAdSource()) {
            startS2SBidding();
        }
    }
}
