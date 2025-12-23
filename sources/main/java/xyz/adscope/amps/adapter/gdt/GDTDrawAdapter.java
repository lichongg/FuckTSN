package xyz.adscope.amps.adapter.gdt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapterListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdExpressListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.adapter.gdt.data.GDTDrawAd;
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
public class GDTDrawAdapter extends AMPSDrawAdAdapter {
    private List<NativeExpressADView> iNativeAdViews;
    private BidResponseModel mBidResponseModel;
    private String mToken;
    private NativeExpressAD nativeExpressAD;
    public Map<View, AMPSDrawAdExpressListener> mAmpsNativeAdExpressListenerMap = new HashMap();
    private NativeExpressAD.NativeExpressADListener nativeExpressADListener = new NativeExpressAD.NativeExpressADListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTDrawAdapter.1
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            AMPSDrawAdExpressListener aMPSDrawAdExpressListener;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadDrawAd onADClicked");
            GDTDrawAdapter.this.onAdClicked();
            Map<View, AMPSDrawAdExpressListener> map = GDTDrawAdapter.this.mAmpsNativeAdExpressListenerMap;
            if (map == null || (aMPSDrawAdExpressListener = map.get(nativeExpressADView)) == null) {
                return;
            }
            aMPSDrawAdExpressListener.onAdClicked();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            AMPSDrawAdExpressListener aMPSDrawAdExpressListener;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadDrawAd onADClosed");
            GDTDrawAdapter.this.onAdDismiss();
            Map<View, AMPSDrawAdExpressListener> map = GDTDrawAdapter.this.mAmpsNativeAdExpressListenerMap;
            if (map == null || (aMPSDrawAdExpressListener = map.get(nativeExpressADView)) == null) {
                return;
            }
            aMPSDrawAdExpressListener.onAdClosed(nativeExpressADView);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            AMPSDrawAdExpressListener aMPSDrawAdExpressListener;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadDrawAd onADExposure");
            GDTDrawAdapter.this.onAdShow();
            Map<View, AMPSDrawAdExpressListener> map = GDTDrawAdapter.this.mAmpsNativeAdExpressListenerMap;
            if (map == null || (aMPSDrawAdExpressListener = map.get(nativeExpressADView)) == null) {
                return;
            }
            aMPSDrawAdExpressListener.onAdShow();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadDrawAd onADLeftApplication");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadDrawAd onADLoaded");
            if (list == null || list.size() < 1) {
                GDTDrawAdapter gDTDrawAdapter = GDTDrawAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                gDTDrawAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                return;
            }
            GDTDrawAdapter.this.iNativeAdViews = list;
            NativeExpressADView nativeExpressADView = (NativeExpressADView) GDTDrawAdapter.this.iNativeAdViews.get(0);
            int ecpm = nativeExpressADView != null ? nativeExpressADView.getECPM() : 0;
            if (GDTDrawAdapter.this.isC2SAdSource()) {
                GDTDrawAdapter.this.onC2SBiddingSuccess(ecpm);
            } else {
                GDTDrawAdapter.this.onAdLoad();
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
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadDrawAd onNoAD code:" + str2 + ";msg:" + str);
            GDTDrawAdapter.this.onAdFailed(str2, str);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            AMPSDrawAdExpressListener aMPSDrawAdExpressListener;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadDrawAd onRenderFail");
            GDTDrawAdapter gDTDrawAdapter = GDTDrawAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL;
            gDTDrawAdapter.onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            GDTDrawAdapter.this.onRenderFail(new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
            Map<View, AMPSDrawAdExpressListener> map = GDTDrawAdapter.this.mAmpsNativeAdExpressListenerMap;
            if (map == null || (aMPSDrawAdExpressListener = map.get(nativeExpressADView)) == null) {
                return;
            }
            aMPSDrawAdExpressListener.onRenderFail(nativeExpressADView, channelErrorEnum.getErrorMsg(), Integer.parseInt(channelErrorEnum.getErrorCode()));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            AMPSDrawAdExpressListener aMPSDrawAdExpressListener;
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadDrawAd onRenderSuccess");
            GDTDrawAdapter.this.onRenderSuccess();
            Map<View, AMPSDrawAdExpressListener> map = GDTDrawAdapter.this.mAmpsNativeAdExpressListenerMap;
            if (map == null || (aMPSDrawAdExpressListener = map.get(nativeExpressADView)) == null) {
                return;
            }
            aMPSDrawAdExpressListener.onRenderSuccess(nativeExpressADView, 0.0f, 0.0f);
        }
    };

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSDrawAdAdapterListener aMPSDrawAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSDrawAdAdapterListener);
        if (isC2SAdSource() && this.nativeExpressAD != null) {
            onAdLoad();
        } else {
            initSDK();
            loadDrawAd();
        }
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

    private void loadDrawAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK start loadDrawAd spaceId:" + this.mSpaceId);
        if (TextUtils.isEmpty(this.mToken)) {
            this.nativeExpressAD = new NativeExpressAD(this.mContext, getMyADSize(), this.mSpaceId, this.nativeExpressADListener);
        } else {
            this.nativeExpressAD = new NativeExpressAD(this.mContext, getMyADSize(), this.mSpaceId, this.nativeExpressADListener, this.mToken);
        }
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.setAutoPlayPolicy(1);
        builder.setAutoPlayMuted(!this.isVolumeOn);
        builder.setDetailPageMuted(true ^ this.isVolumeOn);
        this.nativeExpressAD.setVideoOption(builder.build());
        this.nativeExpressAD.loadAD(this.adCount, null);
    }

    private void startS2SBidding() {
        GDTBiddingRequestUtil.getBidResponse(this.mContext, this.mServerUrl, this.mAppId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.gdt.GDTDrawAdapter.2
            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                GDTDrawAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                if (bidResponseModel == null) {
                    return;
                }
                GDTDrawAdapter.this.mToken = str;
                GDTDrawAdapter.this.mBidResponseModel = bidResponseModel;
                GDTDrawAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter
    public List<AMPSDrawAdExpressInfo> getDrawListInfo() {
        ArrayList arrayList = new ArrayList();
        List<NativeExpressADView> list = this.iNativeAdViews;
        if (list != null && list.size() > 0) {
            Iterator<NativeExpressADView> it = this.iNativeAdViews.iterator();
            while (it.hasNext()) {
                arrayList.add(new GDTDrawAd(it.next(), this));
            }
        }
        return arrayList;
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
            if (isC2SAdSource()) {
                List<NativeExpressADView> list = this.iNativeAdViews;
                if (list != null && list.size() != 0 && (nativeExpressADView = this.iNativeAdViews.get(0)) != null) {
                    GDTAdManagerHolder.sendLossNotification(nativeExpressADView, aMPSBidResult.getReason());
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

    public void setAMPSDrawAdExpressInfoListener(View view, AMPSDrawAdExpressListener aMPSDrawAdExpressListener) {
        if (view == null || aMPSDrawAdExpressListener == null) {
            return;
        }
        try {
            Map<View, AMPSDrawAdExpressListener> map = this.mAmpsNativeAdExpressListenerMap;
            if (map == null) {
                return;
            }
            map.put(view, aMPSDrawAdExpressListener);
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
            Map<View, AMPSDrawAdExpressListener> map = this.mAmpsNativeAdExpressListenerMap;
            if (map != null) {
                map.clear();
                this.mAmpsNativeAdExpressListenerMap = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
        if (isC2SAdSource()) {
            loadDrawAd();
        } else if (isS2SAdSource()) {
            startS2SBidding();
        }
    }
}
