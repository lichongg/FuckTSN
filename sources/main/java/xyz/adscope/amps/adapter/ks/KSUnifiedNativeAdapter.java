package xyz.adscope.amps.adapter.ks;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.amps.ad.unified.AMPSUnifiedNativeAdError;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdAdapterListener;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter;
import xyz.adscope.amps.ad.unified.inter.AMPSAppDetail;
import xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedDownloadListener;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedPattern;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedVideoListener;
import xyz.adscope.amps.ad.unified.inter.AMPSVideoConfig;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedMediaViewStub;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedRootContainer;
import xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback;
import xyz.adscope.amps.adapter.ks.model.BidResponseModel;
import xyz.adscope.amps.adapter.ks.util.KSBiddingRequestUtil;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class KSUnifiedNativeAdapter extends AMPSUnifiedNativeAdapter<KsNativeAd> {
    private List<KsNativeAd> iNativeAdViews;
    private String mBidResponse;
    private BidResponseModel mBidResponseModel;
    private String mBidResponseV2;

    public static class KSTransformEntry extends AMPSBaseTransformEntry {
        private KsNativeAd mSrc;

        private KSTransformEntry(KsNativeAd ksNativeAd, int i6, AMPSVideoConfig aMPSVideoConfig, AMPSUnifiedNativeAdapter aMPSUnifiedNativeAdapter) {
            super(null, i6, aMPSVideoConfig, aMPSUnifiedNativeAdapter);
            this.mSrc = ksNativeAd;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToMediaView(Activity activity, AMPSUnifiedMediaViewStub aMPSUnifiedMediaViewStub, final AMPSUnifiedVideoListener aMPSUnifiedVideoListener) {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null || aMPSUnifiedMediaViewStub == null) {
                return;
            }
            ksNativeAd.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: xyz.adscope.amps.adapter.ks.KSUnifiedNativeAdapter.KSTransformEntry.3
                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayComplete() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadUnifiedNativeAd video complete");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoCompleted();
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayError(int i6, int i7) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadUnifiedNativeAd video play error " + i6 + " " + i7);
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoError(new AMPSUnifiedNativeAdError(i6, i7 + ""));
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayPause() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadUnifiedNativeAd video pause");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoPause();
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayReady() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadUnifiedNativeAd video ready");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoReady();
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayResume() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadUnifiedNativeAd video resume");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoResume();
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayStart() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadUnifiedNativeAd video start");
                    AMPSUnifiedVideoListener aMPSUnifiedVideoListener2 = aMPSUnifiedVideoListener;
                    if (aMPSUnifiedVideoListener2 != null) {
                        aMPSUnifiedVideoListener2.onVideoStart();
                    }
                }
            });
            KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
            AMPSVideoConfig aMPSVideoConfig = this.mVideoConfig;
            if (aMPSVideoConfig != null) {
                int autoPlayPrivacy = aMPSVideoConfig.getAutoPlayPrivacy();
                if (autoPlayPrivacy == 0) {
                    builder.videoAutoPlayType(3);
                } else if (autoPlayPrivacy == 1) {
                    builder.videoAutoPlayType(2);
                } else if (autoPlayPrivacy == 2) {
                    builder.videoAutoPlayType(1);
                }
                builder.videoSoundEnable(!this.mVideoConfig.isMute());
            }
            aMPSUnifiedMediaViewStub.addView(this.mSrc.getVideoView(activity, builder.build()), new ViewGroup.LayoutParams(-1, -1));
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToRootContainer(Activity activity, AMPSUnifiedRootContainer aMPSUnifiedRootContainer, List<View> list, List<View> list2) {
            if (this.mSrc == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                hashMap.put(it.next(), 1);
            }
            Iterator<View> it2 = list2.iterator();
            while (it2.hasNext()) {
                hashMap.put(it2.next(), 2);
            }
            this.mSrc.registerViewForInteraction(activity, aMPSUnifiedRootContainer, hashMap, new KsNativeAd.AdInteractionListener() { // from class: xyz.adscope.amps.adapter.ks.KSUnifiedNativeAdapter.KSTransformEntry.2
                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return false;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdClicked(View view, KsNativeAd ksNativeAd) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadUnifiedNativeAd clicked");
                    if (((AMPSBaseTransformEntry) KSTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) KSTransformEntry.this).mAdapter.onAdClicked();
                    }
                    if (((AMPSBaseTransformEntry) KSTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) KSTransformEntry.this).mAdEventListener.onADClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadUnifiedNativeAd show");
                    if (((AMPSBaseTransformEntry) KSTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) KSTransformEntry.this).mAdapter.onAdShow();
                    }
                    if (((AMPSBaseTransformEntry) KSTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) KSTransformEntry.this).mAdEventListener.onADExposed();
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogShow() {
                }
            });
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getActionButtonText() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getActionDescription();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSUnifiedPattern getAdPattern() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return AMPSUnifiedPattern.AD_PATTERN_UNKNOWN;
            }
            int materialType = ksNativeAd.getMaterialType();
            return materialType != 1 ? materialType != 2 ? materialType != 3 ? AMPSUnifiedPattern.AD_PATTERN_UNKNOWN : AMPSUnifiedPattern.AD_PATTERN_3_IMAGES : AMPSUnifiedPattern.AD_PATTERN_TEXT_IMAGE : AMPSUnifiedPattern.AD_PATTERN_VIDEO;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getAdSourceLogoUrl() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getAdSourceLogoUrl(1);
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDeveloper() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getCorporationName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppIconUrl() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getAppIconUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppName() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getAppName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPackageName() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getAppPackageName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPermissionInfo() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getPermissionInfoUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPrivacyPolicy() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getAppPrivacyUrl();
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
            return this.mSrc.getAppPackageSize() + "";
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppVersion() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getAppVersion();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getDesc() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getAdDescription();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getDownloadCountDesc() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getAppDownloadCountDes();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getIconUrl() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getAppIconUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public int getImageHeight() {
            List<KsImage> imageList;
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null || (imageList = ksNativeAd.getImageList()) == null || imageList.isEmpty()) {
                return 0;
            }
            return imageList.get(0).getHeight();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public int getImageWidth() {
            List<KsImage> imageList;
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null || (imageList = ksNativeAd.getImageList()) == null || imageList.isEmpty()) {
                return 0;
            }
            return imageList.get(0).getWidth();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public List<String> getImagesUrl() {
            List<KsImage> imageList = this.mSrc.getImageList();
            if (imageList == null || imageList.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<KsImage> it = imageList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getImageUrl());
            }
            return arrayList;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getMainImageUrl() {
            List<KsImage> imageList;
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null || (imageList = ksNativeAd.getImageList()) == null || imageList.isEmpty()) {
                return null;
            }
            return imageList.get(0).getImageUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getTitle() {
            KsNativeAd ksNativeAd = this.mSrc;
            if (ksNativeAd == null) {
                return null;
            }
            return ksNativeAd.getProductName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public boolean isValid() {
            return this.mSrc != null;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void setDownloadListener(AMPSUnifiedDownloadListener aMPSUnifiedDownloadListener) {
            super.setDownloadListener(aMPSUnifiedDownloadListener);
            this.mSrc.setDownloadListener(new KsApkDownloadListener() { // from class: xyz.adscope.amps.adapter.ks.KSUnifiedNativeAdapter.KSTransformEntry.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK download failed");
                    if (((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener != null) {
                        ((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener.onDownloadFailed();
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK download finished");
                    if (((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener != null) {
                        ((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener.onDownloadFinished();
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadStarted() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK download started");
                    if (((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener != null) {
                        ((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener.onDownloadStarted();
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK download installed");
                    if (((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener != null) {
                        ((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener.onInstalled();
                    }
                }

                @Override // com.kwad.sdk.api.KsApkDownloadListener
                public void onPaused(int i6) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK download paused");
                    if (((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener != null) {
                        ((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener.onDownloadPaused(i6);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i6) {
                    if (((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener != null) {
                        ((AMPSBaseTransformEntry) KSTransformEntry.this).mDownloadListener.onDownloadProgressUpdate(i6);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                }
            });
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSAppDetail getAppDetail() {
            return this;
        }
    }

    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter
    public AMPSUnifiedNativeItem convertEntryFromAdapterResponse(KsNativeAd ksNativeAd) {
        int i6 = this.mAdEcpm;
        if (this.isBidding) {
            i6 = ksNativeAd.getECPM();
        }
        return new KSTransformEntry(ksNativeAd, i6, new AMPSVideoConfig(!this.isVolumeOn, this.autoPlayPolicy), this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSUnifiedNativeAdAdapterListener aMPSUnifiedNativeAdAdapterListener) {
        List<KsNativeAd> list;
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSUnifiedNativeAdAdapterListener);
        if (isC2SAdSource() && (list = this.iNativeAdViews) != null && !list.isEmpty()) {
            onAdLoad();
        } else {
            initSDK();
            loadUnifiedNativeAd();
        }
    }

    private KsNativeAd getKsFeedAd() {
        List<KsNativeAd> list = this.iNativeAdViews;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.iNativeAdViews.get(0);
    }

    private void loadUnifiedNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDKload  loadUnifiedNativeAd " + this.mSpaceId);
        KsScene.Builder builder = new KsScene.Builder(Long.parseLong(this.mSpaceId));
        builder.adNum(this.adCount).build();
        if (!TextUtils.isEmpty(this.mBidResponse)) {
            builder.setBidResponse(this.mBidResponse);
        } else if (!TextUtils.isEmpty(this.mBidResponseV2)) {
            builder.setBidResponseV2(this.mBidResponseV2);
        }
        KsAdSDK.getLoadManager().loadNativeAd(builder.build(), new KsLoadManager.NativeAdListener() { // from class: xyz.adscope.amps.adapter.ks.KSUnifiedNativeAdapter.1
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadUnifiedNativeAd onError: " + i6 + " " + str);
                KSUnifiedNativeAdapter kSUnifiedNativeAdapter = KSUnifiedNativeAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                sb.append("");
                kSUnifiedNativeAdapter.onAdFailed(sb.toString(), str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                if (list == null || list.size() == 0) {
                    KSUnifiedNativeAdapter kSUnifiedNativeAdapter = KSUnifiedNativeAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    kSUnifiedNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                KSUnifiedNativeAdapter.this.convertAdapterResponse(list);
                KSUnifiedNativeAdapter.this.iNativeAdViews = list;
                KsNativeAd ksNativeAd = (KsNativeAd) KSUnifiedNativeAdapter.this.iNativeAdViews.get(0);
                int ecpm = ksNativeAd != null ? ksNativeAd.getECPM() : 0;
                if (KSUnifiedNativeAdapter.this.isC2SAdSource()) {
                    KSUnifiedNativeAdapter.this.onC2SBiddingSuccess(ecpm);
                } else {
                    KSUnifiedNativeAdapter.this.onAdLoad();
                }
            }
        });
    }

    private void startS2SBidding() {
        KSBiddingRequestUtil.getBidResponse(this.mServerUrl, this.mAccountId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.ks.KSUnifiedNativeAdapter.2
            @Override // xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                KSUnifiedNativeAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                KSUnifiedNativeAdapter.this.mBidResponseModel = bidResponseModel;
                KSUnifiedNativeAdapter.this.mBidResponse = str;
                KSUnifiedNativeAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        List<KsNativeAd> list = this.iNativeAdViews;
        return (list == null || list.isEmpty()) ? false : true;
    }

    private void initSDK() {
        KSInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        List<KsNativeAd> list = this.iNativeAdViews;
        if (list != null) {
            list.clear();
            this.iNativeAdViews = null;
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsNativeAd ksFeedAd = getKsFeedAd();
            if (ksFeedAd != null && aMPSBidResult != null) {
                KSAdManagerHolder.sendLossNotification(ksFeedAd, aMPSBidResult);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsNativeAd ksFeedAd = getKsFeedAd();
            if (ksFeedAd != null) {
                int ecpm = ksFeedAd.getECPM();
                if (isC2SAdSource()) {
                    KSAdManagerHolder.sendWinNotification(ksFeedAd, ecpm);
                } else if (isS2SAdSource()) {
                    KSBiddingRequestUtil.sendWinNotice(this.mBidResponseModel);
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
        if (isC2SAdSource()) {
            loadUnifiedNativeAd();
        } else if (isS2SAdSource()) {
            startS2SBidding();
        }
    }
}
