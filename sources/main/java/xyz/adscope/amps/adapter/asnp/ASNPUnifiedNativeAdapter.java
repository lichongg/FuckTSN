package xyz.adscope.amps.adapter.asnp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.snail.antifake.deviceid.e;
import java.util.List;
import xyz.adscope.ad.publish.ad.IBidding;
import xyz.adscope.ad.publish.ad.nativead.INativeExpressListener;
import xyz.adscope.ad.publish.ad.nativead.INativeInteractiveListener;
import xyz.adscope.ad.publish.ad.unified.ASNPUnifiedPattern;
import xyz.adscope.ad.publish.ad.unified.IUnifiedAdBindListener;
import xyz.adscope.ad.publish.ad.unified.IUnifiedAdConfig;
import xyz.adscope.ad.publish.ad.unified.IUnifiedAdItem;
import xyz.adscope.ad.publish.ad.unified.IUnifiedAdListener;
import xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo;
import xyz.adscope.ad.publish.ad.unified.UnifiedAd;
import xyz.adscope.ad.publish.ad.unified.view.ASNPUnifiedExpressContainer;
import xyz.adscope.ad.publish.ad.unified.view.ASNPUnifiedMediaView;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdAdapterListener;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter;
import xyz.adscope.amps.ad.unified.inter.AMPSAppDetail;
import xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedPattern;
import xyz.adscope.amps.ad.unified.inter.AMPSUnifiedVideoListener;
import xyz.adscope.amps.ad.unified.view.AMPSRootInsertHelper;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedMediaViewStub;
import xyz.adscope.amps.ad.unified.view.AMPSUnifiedRootContainer;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPUnifiedNativeAdapter extends AMPSUnifiedNativeAdapter<IUnifiedAdItem> {
    private List<IUnifiedAdItem> mIUnifiedAdItem;
    private UnifiedAd mUnifiedAd;

    public static class ASNPTransformEntry extends AMPSBaseTransformEntry {
        private IUnifiedAdItem mSrc;

        private ASNPTransformEntry(IUnifiedAdItem iUnifiedAdItem, Context context, int i6, AMPSUnifiedNativeAdapter aMPSUnifiedNativeAdapter) {
            super(context, i6, null, aMPSUnifiedNativeAdapter);
            this.mSrc = iUnifiedAdItem;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToMediaView(Activity activity, AMPSUnifiedMediaViewStub aMPSUnifiedMediaViewStub, AMPSUnifiedVideoListener aMPSUnifiedVideoListener) {
            if (this.mSrc == null) {
                return;
            }
            ASNPUnifiedMediaView aSNPUnifiedMediaView = new ASNPUnifiedMediaView(this.mContext);
            aMPSUnifiedMediaViewStub.addView(aSNPUnifiedMediaView);
            this.mSrc.bindAdToMediaView(activity, aSNPUnifiedMediaView);
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public void bindAdToRootContainer(Activity activity, AMPSUnifiedRootContainer aMPSUnifiedRootContainer, List<View> list, List<View> list2) {
            if (this.mSrc == null) {
                return;
            }
            ASNPUnifiedExpressContainer aSNPUnifiedExpressContainer = new ASNPUnifiedExpressContainer(activity, ASNPInitMediation.getInstance().getApiKey());
            AMPSRootInsertHelper.insertRootView(aMPSUnifiedRootContainer, aSNPUnifiedExpressContainer);
            this.mSrc.setBindAdListener(new IUnifiedAdBindListener() { // from class: xyz.adscope.amps.adapter.asnp.ASNPUnifiedNativeAdapter.ASNPTransformEntry.1
                @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdBindListener
                public void onAdBindError() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadUnifiedNativeAd onAdBindError");
                    if (((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdapter != null) {
                        AMPSUnifiedNativeAdapter aMPSUnifiedNativeAdapter = ((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdapter;
                        StringBuilder sb = new StringBuilder();
                        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL;
                        sb.append(channelErrorEnum.getErrorCode());
                        sb.append("");
                        aMPSUnifiedNativeAdapter.onAdShowFailed(sb.toString(), channelErrorEnum.getErrorMsg());
                    }
                    if (((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdEventListener.onADExposeError(-1, AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL.getErrorMsg());
                    }
                }
            });
            this.mSrc.setExpressListener(new INativeExpressListener() { // from class: xyz.adscope.amps.adapter.asnp.ASNPUnifiedNativeAdapter.ASNPTransformEntry.2
                @Override // xyz.adscope.ad.publish.ad.nativead.INativeExpressListener
                public void onAdExposure() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadUnifiedNativeAd onAdShown");
                    if (((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdapter.onAdShow();
                    }
                    if (((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdEventListener.onADExposed();
                    }
                }

                @Override // xyz.adscope.ad.publish.ad.nativead.INativeExpressListener
                public void onAdShown() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadUnifiedNativeAd onAdShown");
                }

                @Override // xyz.adscope.ad.publish.ad.nativead.INativeExpressListener
                public void onAdClosed() {
                }
            });
            this.mSrc.setInteractiveListener(new INativeInteractiveListener() { // from class: xyz.adscope.amps.adapter.asnp.ASNPUnifiedNativeAdapter.ASNPTransformEntry.3
                @Override // xyz.adscope.ad.publish.ad.nativead.INativeInteractiveListener
                public void onAdClicked() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadUnifiedNativeAd onAdClicked");
                    if (((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdapter != null) {
                        ((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdapter.onAdClicked();
                    }
                    if (((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdEventListener != null) {
                        ((AMPSBaseTransformEntry) ASNPTransformEntry.this).mAdEventListener.onADClicked();
                    }
                }
            });
            this.mSrc.bindAdToRootContainer(activity, aSNPUnifiedExpressContainer, list);
            this.mSrc.bindAdActionView(list2);
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getActionButtonText() {
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null) {
                return null;
            }
            return iUnifiedAdItem.getActionButtonText();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public AMPSUnifiedPattern getAdPattern() {
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null) {
                return AMPSUnifiedPattern.AD_PATTERN_UNKNOWN;
            }
            ASNPUnifiedPattern adPattern = iUnifiedAdItem.getAdPattern();
            return adPattern == ASNPUnifiedPattern.PATTERN_TEXT_IMAGE ? AMPSUnifiedPattern.AD_PATTERN_TEXT_IMAGE : adPattern == ASNPUnifiedPattern.PATTERN_3_IMAGES ? AMPSUnifiedPattern.AD_PATTERN_3_IMAGES : adPattern == ASNPUnifiedPattern.PATTERN_VIDEO ? AMPSUnifiedPattern.AD_PATTERN_VIDEO : AMPSUnifiedPattern.AD_PATTERN_UNKNOWN;
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getAdSourceLogoUrl() {
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null) {
                return null;
            }
            return iUnifiedAdItem.getAdLogoUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDescription() {
            IUnifiedDownloadInfo downloadInfo;
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null || (downloadInfo = iUnifiedAdItem.getDownloadInfo()) == null) {
                return null;
            }
            return downloadInfo.getAppIntroduction();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppDeveloper() {
            IUnifiedDownloadInfo downloadInfo;
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null || (downloadInfo = iUnifiedAdItem.getDownloadInfo()) == null) {
                return null;
            }
            return downloadInfo.getDeveloper();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppIconUrl() {
            IUnifiedDownloadInfo downloadInfo;
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null || (downloadInfo = iUnifiedAdItem.getDownloadInfo()) == null) {
                return null;
            }
            return downloadInfo.getIconUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppName() {
            IUnifiedDownloadInfo downloadInfo;
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null || (downloadInfo = iUnifiedAdItem.getDownloadInfo()) == null) {
                return null;
            }
            return downloadInfo.getName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPackageName() {
            IUnifiedDownloadInfo downloadInfo;
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null || (downloadInfo = iUnifiedAdItem.getDownloadInfo()) == null) {
                return null;
            }
            return downloadInfo.getPackageName();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPermissionInfo() {
            IUnifiedDownloadInfo downloadInfo;
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null || (downloadInfo = iUnifiedAdItem.getDownloadInfo()) == null) {
                return null;
            }
            String permissionUrl = downloadInfo.getPermissionUrl();
            if (!TextUtils.isEmpty(permissionUrl)) {
                return permissionUrl;
            }
            List<IUnifiedDownloadInfo.IPermissionInfo> permission = downloadInfo.getPermission();
            StringBuilder sb = new StringBuilder();
            if (permission == null || permission.size() <= 0) {
                return null;
            }
            for (IUnifiedDownloadInfo.IPermissionInfo iPermissionInfo : permission) {
                String title = iPermissionInfo.getTitle();
                String describe = iPermissionInfo.getDescribe();
                sb.append(title);
                sb.append(":");
                sb.append(describe);
                sb.append(e.f37542d);
            }
            return sb.toString();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppPrivacyPolicy() {
            IUnifiedDownloadInfo downloadInfo;
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null || (downloadInfo = iUnifiedAdItem.getDownloadInfo()) == null) {
                return null;
            }
            String policyUrl = downloadInfo.getPolicyUrl();
            return !TextUtils.isEmpty(policyUrl) ? policyUrl : downloadInfo.getPolicy();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppSize() {
            IUnifiedDownloadInfo downloadInfo;
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null || (downloadInfo = iUnifiedAdItem.getDownloadInfo()) == null) {
                return null;
            }
            return downloadInfo.getSize();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSAppDetail
        public String getAppVersion() {
            IUnifiedDownloadInfo downloadInfo;
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null || (downloadInfo = iUnifiedAdItem.getDownloadInfo()) == null) {
                return null;
            }
            return downloadInfo.getVersion();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getDesc() {
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null) {
                return null;
            }
            return iUnifiedAdItem.getDesc();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getIconUrl() {
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null) {
                return null;
            }
            return iUnifiedAdItem.getIconUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public List<String> getImagesUrl() {
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null) {
                return null;
            }
            return iUnifiedAdItem.getImagesUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getMainImageUrl() {
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null) {
                return null;
            }
            return iUnifiedAdItem.getMainImageUrl();
        }

        @Override // xyz.adscope.amps.ad.unified.inter.AMPSBaseTransformEntry, xyz.adscope.amps.ad.unified.inter.AMPSUnifiedNativeItem
        public String getTitle() {
            IUnifiedAdItem iUnifiedAdItem = this.mSrc;
            if (iUnifiedAdItem == null) {
                return null;
            }
            return iUnifiedAdItem.getTitle();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUnifiedNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK start loadUnifiedNativeAd spaceId:" + this.mSpaceId);
        if (this.mContext == null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_FAIL;
            onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        } else {
            UnifiedAd unifiedAd = new UnifiedAd(this.mContext, new IUnifiedAdConfig.Builder().setAdCount(1).setExpressSizePixel(this.expressViewWidth, this.expressViewHeight).setTimeoutMillion(this.mTimeout).build(this.mSpaceId));
            this.mUnifiedAd = unifiedAd;
            unifiedAd.loadAd(new IUnifiedAdListener() { // from class: xyz.adscope.amps.adapter.asnp.ASNPUnifiedNativeAdapter.2
                @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdListener, xyz.adscope.ad.d2
                public void onAdLoadFailed(int i6, String str) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadUnifiedNativeAd onNativeLoadFail code:" + i6 + " message:" + str);
                    ASNPUnifiedNativeAdapter aSNPUnifiedNativeAdapter = ASNPUnifiedNativeAdapter.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i6);
                    sb.append("");
                    aSNPUnifiedNativeAdapter.onAdFailed(sb.toString(), str);
                }

                @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedAdListener
                public void onAdLoaded(List<IUnifiedAdItem> list) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadUnifiedNativeAd onAdLoad");
                    if (list == null || list.size() < 1) {
                        ASNPUnifiedNativeAdapter aSNPUnifiedNativeAdapter = ASNPUnifiedNativeAdapter.this;
                        AMPSErrorCode.ChannelErrorEnum channelErrorEnum2 = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                        aSNPUnifiedNativeAdapter.onAdFailed(channelErrorEnum2.getErrorCode(), channelErrorEnum2.getErrorMsg());
                        return;
                    }
                    ASNPUnifiedNativeAdapter.this.mIUnifiedAdItem = list;
                    ASNPUnifiedNativeAdapter.this.convertAdapterResponse(list);
                    int i6 = 0;
                    try {
                        IUnifiedAdItem iUnifiedAdItem = list.get(0);
                        if (iUnifiedAdItem != null && iUnifiedAdItem.getBidding() != null) {
                            i6 = iUnifiedAdItem.getBidding().getECPM();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    ASNPUnifiedNativeAdapter aSNPUnifiedNativeAdapter2 = ASNPUnifiedNativeAdapter.this;
                    if (aSNPUnifiedNativeAdapter2.isBidding) {
                        aSNPUnifiedNativeAdapter2.onC2SBiddingSuccess(i6);
                    } else {
                        aSNPUnifiedNativeAdapter2.onAdLoad();
                    }
                }
            });
        }
    }

    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter
    public AMPSUnifiedNativeItem convertEntryFromAdapterResponse(IUnifiedAdItem iUnifiedAdItem) {
        int i6 = this.mAdEcpm;
        if (this.isBidding && iUnifiedAdItem.getBidding() != null) {
            i6 = iUnifiedAdItem.getBidding().getECPM();
        }
        return new ASNPTransformEntry(iUnifiedAdItem, this.mContext, i6, this);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mUnifiedAd != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        IUnifiedAdItem iUnifiedAdItem;
        try {
            List<IUnifiedAdItem> list = this.mIUnifiedAdItem;
            if (list != null && list.size() != 0 && aMPSBidResult != null && (iUnifiedAdItem = this.mIUnifiedAdItem.get(0)) != null && iUnifiedAdItem.getBidding() != null) {
                iUnifiedAdItem.getBidding().notifyBidLose(IBidding.BiddingPriceBuilder.buildLoseNoticeMap(aMPSBidResult.getEcpm(), -1, aMPSBidResult.getChannelName(), String.valueOf(aMPSBidResult.getReason()), -1));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        IUnifiedAdItem iUnifiedAdItem;
        try {
            List<IUnifiedAdItem> list = this.mIUnifiedAdItem;
            if (list != null && list.size() != 0 && aMPSBidResult != null && (iUnifiedAdItem = this.mIUnifiedAdItem.get(0)) != null && iUnifiedAdItem.getBidding() != null) {
                iUnifiedAdItem.getBidding().notifyBidWin(IBidding.BiddingPriceBuilder.buildWinNoticeMap(iUnifiedAdItem.getBidding().getECPM(), aMPSBidResult.getEcpm(), aMPSBidResult.getChannelName(), -1));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void initSDK() {
        ASNPInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.asnp.ASNPUnifiedNativeAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadUnifiedNativeAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                ASNPUnifiedNativeAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                ASNPUnifiedNativeAdapter.this.loadUnifiedNativeAd();
            }
        });
    }

    @Override // xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
