package xyz.adscope.amps.adapter.gdt;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.gdt.data.GDTNativeAd;
import xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback;
import xyz.adscope.amps.adapter.gdt.model.BidResponseModel;
import xyz.adscope.amps.adapter.gdt.util.GDTBiddingRequestUtil;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GDTNativeAdapter extends AMPSNativeAdapter {
    private List<NativeExpressADView> iNativeAdViews;
    private BidResponseModel mBidResponseModel;
    private String mToken;
    private NativeExpressAD nativeExpressAD;
    public Map<View, AMPSNativeAdExpressListener> ampsNativeAdExpressListenerMap = new HashMap();
    public NativeExpressAD.NativeExpressADListener nativeExpressADListener = new NativeExpressAD.NativeExpressADListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTNativeAdapter.1
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            AMPSNativeAdExpressListener aMPSNativeAdExpressListener;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onADClicked");
            GDTNativeAdapter.this.onAdClicked();
            Map<View, AMPSNativeAdExpressListener> map = GDTNativeAdapter.this.ampsNativeAdExpressListenerMap;
            if (map == null || (aMPSNativeAdExpressListener = map.get(nativeExpressADView)) == null) {
                return;
            }
            aMPSNativeAdExpressListener.onAdClicked();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            AMPSNativeAdExpressListener aMPSNativeAdExpressListener;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onADClosed");
            GDTNativeAdapter.this.onAdDismiss();
            Map<View, AMPSNativeAdExpressListener> map = GDTNativeAdapter.this.ampsNativeAdExpressListenerMap;
            if (map == null || (aMPSNativeAdExpressListener = map.get(nativeExpressADView)) == null) {
                return;
            }
            aMPSNativeAdExpressListener.onAdClosed(nativeExpressADView);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            AMPSNativeAdExpressListener aMPSNativeAdExpressListener;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onADExposure");
            GDTNativeAdapter.this.onAdShow();
            Map<View, AMPSNativeAdExpressListener> map = GDTNativeAdapter.this.ampsNativeAdExpressListenerMap;
            if (map == null || (aMPSNativeAdExpressListener = map.get(nativeExpressADView)) == null) {
                return;
            }
            aMPSNativeAdExpressListener.onAdShow();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onADLeftApplication");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onADLoaded");
            if (list == null || list.size() < 1) {
                GDTNativeAdapter gDTNativeAdapter = GDTNativeAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                gDTNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                return;
            }
            GDTNativeAdapter.this.iNativeAdViews = list;
            NativeExpressADView nativeExpressADView = (NativeExpressADView) GDTNativeAdapter.this.iNativeAdViews.get(0);
            int ecpm = nativeExpressADView != null ? nativeExpressADView.getECPM() : 0;
            if (GDTNativeAdapter.this.isC2SAdSource()) {
                GDTNativeAdapter.this.onC2SBiddingSuccess(ecpm);
            } else {
                GDTNativeAdapter.this.onAdLoad();
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            String str;
            String str2 = "";
            if (adError != null) {
                str2 = adError.getErrorCode() + "";
                str = adError.getErrorMsg();
            } else {
                str = "";
            }
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onNoAD code:" + str2 + ";msg:" + str);
            GDTNativeAdapter.this.onAdFailed(str2, str);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            AMPSNativeAdExpressListener aMPSNativeAdExpressListener;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onRenderFail");
            GDTNativeAdapter gDTNativeAdapter = GDTNativeAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL;
            gDTNativeAdapter.onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            GDTNativeAdapter.this.onRenderFail(new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
            Map<View, AMPSNativeAdExpressListener> map = GDTNativeAdapter.this.ampsNativeAdExpressListenerMap;
            if (map == null || (aMPSNativeAdExpressListener = map.get(nativeExpressADView)) == null) {
                return;
            }
            aMPSNativeAdExpressListener.onRenderFail(nativeExpressADView, channelErrorEnum.getErrorMsg(), Integer.parseInt(channelErrorEnum.getErrorCode()));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            AMPSNativeAdExpressListener aMPSNativeAdExpressListener;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadNativeAd onRenderSuccess");
            GDTNativeAdapter.this.onRenderSuccess();
            Map<View, AMPSNativeAdExpressListener> map = GDTNativeAdapter.this.ampsNativeAdExpressListenerMap;
            if (map == null || (aMPSNativeAdExpressListener = map.get(nativeExpressADView)) == null) {
                return;
            }
            aMPSNativeAdExpressListener.onRenderSuccess(nativeExpressADView, 0.0f, 0.0f);
        }
    };

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        if (isC2SAdSource() && this.nativeExpressAD != null) {
            onAdLoad();
        } else {
            initSDK();
            loadNativeAd();
        }
    }

    @NonNull
    public static LoadAdParams getLoadAdParams(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("custom_key", str);
        hashMap.put("staIn", "com.qq.e.demo");
        hashMap.put("thrmei", "29232329");
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setDevExtra(hashMap);
        return loadAdParams;
    }

    private ADSize getMyADSize() {
        int i6 = this.expressViewWidthDp;
        if (i6 <= 0) {
            i6 = -1;
        }
        int i7 = this.expressViewHeightDp;
        if (i7 <= 0) {
            i7 = -2;
        }
        return new ADSize(i6, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadNativeAd() {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "GDTSDK start loadNativeAd spaceId:"
            r0.append(r1)
            java.lang.String r1 = r11.mSpaceId
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "amps_log_tag"
            xyz.adscope.amps.tool.AMPSLogUtil.d(r1, r0)
            java.lang.String r0 = r11.mToken
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L32
            com.qq.e.ads.nativ.NativeExpressAD r0 = new com.qq.e.ads.nativ.NativeExpressAD
            android.content.Context r1 = r11.mContext
            com.qq.e.ads.nativ.ADSize r2 = r11.getMyADSize()
            java.lang.String r3 = r11.mSpaceId
            com.qq.e.ads.nativ.NativeExpressAD$NativeExpressADListener r4 = r11.nativeExpressADListener
            r0.<init>(r1, r2, r3, r4)
            r11.nativeExpressAD = r0
            goto L45
        L32:
            com.qq.e.ads.nativ.NativeExpressAD r5 = new com.qq.e.ads.nativ.NativeExpressAD
            android.content.Context r6 = r11.mContext
            com.qq.e.ads.nativ.ADSize r7 = r11.getMyADSize()
            java.lang.String r8 = r11.mSpaceId
            com.qq.e.ads.nativ.NativeExpressAD$NativeExpressADListener r9 = r11.nativeExpressADListener
            java.lang.String r10 = r11.mToken
            r5.<init>(r6, r7, r8, r9, r10)
            r11.nativeExpressAD = r5
        L45:
            com.qq.e.ads.cfg.VideoOption$Builder r0 = new com.qq.e.ads.cfg.VideoOption$Builder
            r0.<init>()
            int r1 = r11.autoPlayPolicy
            xyz.adscope.amps.common.AMPSEnum$AutoPlayEnum r2 = xyz.adscope.amps.common.AMPSEnum.AutoPlayEnum.NO_AUTO_PLAY
            int r2 = r2.getAutoPlayValue()
            r3 = 1
            if (r1 != r2) goto L5a
            r1 = 2
        L56:
            r0.setAutoPlayPolicy(r1)
            goto L73
        L5a:
            int r1 = r11.autoPlayPolicy
            xyz.adscope.amps.common.AMPSEnum$AutoPlayEnum r2 = xyz.adscope.amps.common.AMPSEnum.AutoPlayEnum.WIFI_AUTO_PLAY
            int r2 = r2.getAutoPlayValue()
            if (r1 != r2) goto L66
            r1 = 0
            goto L56
        L66:
            int r1 = r11.autoPlayPolicy
            xyz.adscope.amps.common.AMPSEnum$AutoPlayEnum r2 = xyz.adscope.amps.common.AMPSEnum.AutoPlayEnum.HAS_NET_AUTO_PLAY
            int r2 = r2.getAutoPlayValue()
            if (r1 != r2) goto L73
            r0.setAutoPlayPolicy(r3)
        L73:
            boolean r1 = r11.isVolumeOn
            r1 = r1 ^ r3
            r0.setAutoPlayMuted(r1)
            boolean r1 = r11.isVolumeOn
            r1 = r1 ^ r3
            r0.setDetailPageMuted(r1)
            com.qq.e.ads.nativ.NativeExpressAD r1 = r11.nativeExpressAD
            com.qq.e.ads.cfg.VideoOption r0 = r0.build()
            r1.setVideoOption(r0)
            int r0 = r11.videoMaxTime
            if (r0 <= 0) goto L91
            com.qq.e.ads.nativ.NativeExpressAD r1 = r11.nativeExpressAD
            r1.setMaxVideoDuration(r0)
        L91:
            com.qq.e.ads.nativ.NativeExpressAD r0 = r11.nativeExpressAD
            int r1 = r11.adCount
            r2 = 0
            r0.loadAD(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.adapter.gdt.GDTNativeAdapter.loadNativeAd():void");
    }

    private void startS2SBidding() {
        GDTBiddingRequestUtil.getBidResponse(this.mContext, this.mServerUrl, this.mAppId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.gdt.GDTNativeAdapter.2
            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                GDTNativeAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                if (bidResponseModel == null) {
                    return;
                }
                GDTNativeAdapter.this.mToken = str;
                GDTNativeAdapter.this.mBidResponseModel = bidResponseModel;
                GDTNativeAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        NativeExpressADView nativeExpressADView;
        List<NativeExpressADView> list = this.iNativeAdViews;
        if (list == null || list.size() < 1 || (nativeExpressADView = this.iNativeAdViews.get(0)) == null) {
            return null;
        }
        return nativeExpressADView.getExtraInfo();
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        List<NativeExpressADView> list = this.iNativeAdViews;
        if (list != null && list.size() > 0) {
            for (NativeExpressADView nativeExpressADView : this.iNativeAdViews) {
                int i6 = this.mAdEcpm;
                if (this.isBidding && nativeExpressADView != null) {
                    i6 = nativeExpressADView.getECPM();
                }
                arrayList.add(new GDTNativeAd(nativeExpressADView, this, i6));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        if (this.nativeExpressAD == null) {
            return false;
        }
        List<NativeExpressADView> list = this.iNativeAdViews;
        NativeExpressADView nativeExpressADView = (list == null || list.size() <= 0) ? null : this.iNativeAdViews.get(0);
        if (nativeExpressADView == null) {
            return false;
        }
        return nativeExpressADView.isValid();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        NativeExpressADView nativeExpressADView;
        if (aMPSBidResult == null) {
            return;
        }
        try {
            if (!isC2SAdSource()) {
                if (isS2SAdSource()) {
                    GDTBiddingRequestUtil.sendLossNotice(this.mBidResponseModel, aMPSBidResult.getEcpm(), aMPSBidResult.getReason(), this.mPublicKey);
                }
            } else {
                List<NativeExpressADView> list = this.iNativeAdViews;
                if (list != null && list.size() != 0 && (nativeExpressADView = this.iNativeAdViews.get(0)) != null) {
                    GDTAdManagerHolder.sendLossNotification(nativeExpressADView, aMPSBidResult.getReason());
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        NativeExpressADView nativeExpressADView;
        try {
            List<NativeExpressADView> list = this.iNativeAdViews;
            if (list != null && list.size() != 0 && (nativeExpressADView = this.iNativeAdViews.get(0)) != null) {
                int ecpm = nativeExpressADView.getECPM();
                if (isC2SAdSource()) {
                    GDTAdManagerHolder.sendWinNotification(nativeExpressADView, ecpm);
                } else if (isS2SAdSource()) {
                    GDTBiddingRequestUtil.sendWinNotice(this.mBidResponseModel, this.mPublicKey);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setAMPSNativeAdExpressListener(View view, AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        if (view == null || aMPSNativeAdExpressListener == null) {
            return;
        }
        try {
            Map<View, AMPSNativeAdExpressListener> map = this.ampsNativeAdExpressListenerMap;
            if (map == null) {
                return;
            }
            map.put(view, aMPSNativeAdExpressListener);
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
        try {
            if (this.nativeExpressAD != null) {
                this.nativeExpressAD = null;
            }
            List<NativeExpressADView> list = this.iNativeAdViews;
            if (list != null) {
                list.clear();
                this.iNativeAdViews = null;
            }
            Map<View, AMPSNativeAdExpressListener> map = this.ampsNativeAdExpressListenerMap;
            if (map != null) {
                map.clear();
                this.ampsNativeAdExpressListenerMap = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
        if (isC2SAdSource()) {
            loadNativeAd();
        } else if (isS2SAdSource()) {
            startS2SBidding();
        }
    }
}
