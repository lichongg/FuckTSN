package xyz.adscope.amps.adapter.bz;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.beizi.fusion.NativeAd;
import com.beizi.fusion.NativeAdListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.bz.data.BZNativeAd;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BZNativeAdapter extends AMPSNativeAdapter {
    private NativeAd mNativeAd;
    private View nativeView;
    private int winPrice;
    private AMPSNativeAdExpressListener ampsNativeAdExpressListener = null;
    private int modelType = 1;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        if (!this.isBidding || this.mNativeAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    private void loadNativeAd() {
        int intValue;
        int i6;
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK start loadNativeAd spaceId:" + this.mSpaceId);
        List<Integer> list = this.templateTypes;
        if (list != null && list.size() > 0) {
            if (!this.templateTypes.contains(1)) {
                i6 = this.templateTypes.contains(2) ? 5 : 4;
            }
            this.modelType = i6;
        }
        this.mNativeAd = new NativeAd(this.mContext, this.mSpaceId, new NativeAdListener() { // from class: xyz.adscope.amps.adapter.bz.BZNativeAdapter.1
            @Override // com.beizi.fusion.NativeAdListener
            public void onAdClosed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdClosed");
                BZNativeAdapter.this.onAdDismiss();
                if (BZNativeAdapter.this.ampsNativeAdExpressListener != null) {
                    BZNativeAdapter.this.ampsNativeAdExpressListener.onAdClosed(BZNativeAdapter.this.nativeView);
                }
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdClick");
                BZNativeAdapter.this.onAdClicked();
                if (BZNativeAdapter.this.ampsNativeAdExpressListener != null) {
                    BZNativeAdapter.this.ampsNativeAdExpressListener.onAdClicked();
                }
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdClosed(View view) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdClosed");
                BZNativeAdapter.this.onAdDismiss();
                if (BZNativeAdapter.this.ampsNativeAdExpressListener != null) {
                    BZNativeAdapter.this.ampsNativeAdExpressListener.onAdClosed(view);
                }
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdFailed(int i7) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdFailed  code:" + i7);
                BZNativeAdapter.this.onAdFailed(i7 + "", AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_BZ_LOAD_FAIL.getErrorMsg());
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdLoaded(View view) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdLoaded");
                BZNativeAdapter.this.nativeView = view;
                int i7 = 0;
                try {
                    int ecpm = BZNativeAdapter.this.mNativeAd != null ? BZNativeAdapter.this.mNativeAd.getECPM() : 0;
                    if (ecpm >= 0) {
                        i7 = ecpm;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                BZNativeAdapter bZNativeAdapter = BZNativeAdapter.this;
                if (bZNativeAdapter.isBidding) {
                    bZNativeAdapter.onC2SBiddingSuccess(i7);
                } else {
                    bZNativeAdapter.onAdLoad();
                }
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdShown() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdShown");
                BZNativeAdapter.this.onAdShow();
                if (BZNativeAdapter.this.ampsNativeAdExpressListener != null) {
                    BZNativeAdapter.this.ampsNativeAdExpressListener.onAdShow();
                }
            }
        }, this.mTimeout, this.modelType);
        int i7 = this.expressViewHeightDp;
        Map<String, Object> map = this.localCustomParameter;
        if (map != null && map.containsKey("customBZHeight")) {
            Object obj = this.localCustomParameter.get("customBZHeight");
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0) {
                i7 = DeviceInfoUtil.px2dip(this.mContext, intValue);
            }
        }
        if (i7 < 0) {
            i7 = 0;
        }
        this.mNativeAd.loadAd(this.expressViewWidthDp, i7);
    }

    public View getAdView() {
        return this.nativeView;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public String getMediaCustomExtraInfo() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null) {
            return super.getMediaCustomExtraInfo();
        }
        String customExtraData = nativeAd.getCustomExtraData();
        return TextUtils.isEmpty(customExtraData) ? super.getMediaCustomExtraInfo() : customExtraData;
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        int i6 = this.mAdEcpm;
        if (this.isBidding && this.mNativeAd != null) {
            i6 = this.winPrice;
        }
        arrayList.add(new BZNativeAd(this, i6));
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mNativeAd != null;
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public void pause() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.pause();
        }
    }

    public void renderView() {
        if (this.nativeView == null) {
            return;
        }
        onRenderSuccess();
        AMPSNativeAdExpressListener aMPSNativeAdExpressListener = this.ampsNativeAdExpressListener;
        if (aMPSNativeAdExpressListener != null) {
            aMPSNativeAdExpressListener.onRenderSuccess(this.nativeView, this.expressViewWidth, this.expressViewHeight);
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public void resume() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.resume();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        Map<String, String> lossInfo;
        try {
            if (this.mNativeAd != null && aMPSBidResult != null && (lossInfo = BZInitMediation.getInstance().getLossInfo(aMPSBidResult)) != null) {
                this.mNativeAd.sendLossNotificationWithInfo(lossInfo);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            if (this.mNativeAd != null && aMPSBidResult != null) {
                this.winPrice = aMPSBidResult.getWinPrice();
                Map<String, String> winInfo = BZInitMediation.getInstance().getWinInfo(aMPSBidResult);
                if (winInfo == null) {
                    return;
                }
                this.mNativeAd.sendWinNotificationWithInfo(winInfo);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setAMPSNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        this.ampsNativeAdExpressListener = aMPSNativeAdExpressListener;
    }

    private void initSDK() {
        BZInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadNativeAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.mNativeAd = null;
        }
        this.ampsNativeAdExpressListener = null;
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
