package xyz.adscope.amps.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdAdapterListener;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter;
import xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback;
import xyz.adscope.amps.adapter.gdt.model.BidResponseModel;
import xyz.adscope.amps.adapter.gdt.util.GDTBiddingRequestUtil;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.amps.tool.util.AMPSScreenUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GDTBannerAdapter extends AMPSBannerAdapter {
    private UnifiedBannerView mBannerView;
    private BidResponseModel mBidResponseModel;
    private String mToken;
    private UnifiedBannerADListener unifiedBannerADListener = new UnifiedBannerADListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTBannerAdapter.2
        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadBannerAd onADClicked");
            GDTBannerAdapter.this.onAdClicked();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadBannerAd onADClosed");
            GDTBannerAdapter.this.onAdDismiss();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadBannerAd onADExposure");
            GDTBannerAdapter.this.onAdShow();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadBannerAd onADLeftApplication");
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadBannerAd onADReceive");
            int ecpm = GDTBannerAdapter.this.mBannerView != null ? GDTBannerAdapter.this.mBannerView.getECPM() : 0;
            if (GDTBannerAdapter.this.isC2SAdSource()) {
                GDTBannerAdapter.this.onC2SBiddingSuccess(ecpm);
            } else {
                GDTBannerAdapter.this.onAdLoad();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            String str;
            String str2 = "";
            if (adError != null) {
                str2 = adError.getErrorCode() + "";
                str = adError.getErrorMsg();
            } else {
                str = "";
            }
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadBannerAd onNoAD code:" + str2 + ";msg:" + str + " spaceId:" + GDTBannerAdapter.this.mSpaceId);
            GDTBannerAdapter.this.onAdFailed(str2, str);
        }
    };

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSBannerAdAdapterListener aMPSBannerAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSBannerAdAdapterListener);
        if (isC2SAdSource() && this.mBannerView != null) {
            onAdLoad();
        } else {
            initSDK();
            loadBannerAd();
        }
    }

    private ViewGroup.LayoutParams getBannerSize() {
        if (this.expressViewWidth <= 0) {
            this.expressViewWidth = AMPSScreenUtil.getScreenWidth(this.mContext);
        }
        if (this.expressViewHeight <= 0) {
            this.expressViewHeight = Math.round(this.expressViewWidth / 6.4f);
        }
        return new ViewGroup.LayoutParams(this.expressViewWidth, this.expressViewHeight);
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

    private void loadBannerAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK start loadBannerAd spaceId:" + this.mSpaceId);
        if (TextUtils.isEmpty(this.mToken)) {
            this.mBannerView = new UnifiedBannerView((Activity) this.mContext, this.mSpaceId, this.unifiedBannerADListener);
        } else {
            this.mBannerView = new UnifiedBannerView((Activity) this.mContext, this.mSpaceId, this.unifiedBannerADListener, null, this.mToken);
        }
        this.mBannerView.setNegativeFeedbackListener(new NegativeFeedbackListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTBannerAdapter.1
            @Override // com.qq.e.comm.listeners.NegativeFeedbackListener
            public void onComplainSuccess() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadBannerAd onComplainSuccess");
            }
        });
        this.mBannerView.loadAD();
    }

    private void startS2SBidding() {
        GDTBiddingRequestUtil.getBidResponse(this.mContext, this.mServerUrl, this.mAppId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.gdt.GDTBannerAdapter.3
            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                GDTBannerAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.gdt.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                if (bidResponseModel == null) {
                    return;
                }
                GDTBannerAdapter.this.mToken = str;
                GDTBannerAdapter.this.mBidResponseModel = bidResponseModel;
                GDTBannerAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        UnifiedBannerView unifiedBannerView = this.mBannerView;
        if (unifiedBannerView != null) {
            return unifiedBannerView.getExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        UnifiedBannerView unifiedBannerView = this.mBannerView;
        if (unifiedBannerView == null) {
            return false;
        }
        return unifiedBannerView.isValid();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        if (aMPSBidResult == null) {
            return;
        }
        try {
            if (!isC2SAdSource()) {
                if (isS2SAdSource()) {
                    GDTBiddingRequestUtil.sendLossNotice(this.mBidResponseModel, aMPSBidResult.getEcpm(), aMPSBidResult.getReason(), this.mPublicKey);
                }
            } else {
                UnifiedBannerView unifiedBannerView = this.mBannerView;
                if (unifiedBannerView == null) {
                    return;
                }
                GDTAdManagerHolder.sendLossNotification(unifiedBannerView, aMPSBidResult.getReason());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            UnifiedBannerView unifiedBannerView = this.mBannerView;
            if (unifiedBannerView == null) {
                return;
            }
            int ecpm = unifiedBannerView.getECPM();
            if (isC2SAdSource()) {
                GDTAdManagerHolder.sendWinNotification(this.mBannerView, ecpm);
            } else if (isS2SAdSource()) {
                GDTBiddingRequestUtil.sendWinNotice(this.mBidResponseModel, this.mPublicKey);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        UnifiedBannerView unifiedBannerView = this.mBannerView;
        if (unifiedBannerView != null && viewGroup != null) {
            viewGroup.addView(unifiedBannerView, getBannerSize());
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        GDTInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        UnifiedBannerView unifiedBannerView = this.mBannerView;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
        this.mBannerView = null;
    }

    @Override // xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
        if (isC2SAdSource()) {
            loadBannerAd();
        } else if (isS2SAdSource()) {
            startS2SBidding();
        }
    }
}
