package xyz.adscope.amps.adapter.csj;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdAdapterListener;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class CSJBannerAdapter extends AMPSBannerAdapter {
    private TTAdNative csjAdNative;
    private View mBannerView;
    private TTNativeExpressAd mTTBannerAd;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSBannerAdAdapterListener aMPSBannerAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSBannerAdAdapterListener);
        initSDK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindAdListener(final TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: xyz.adscope.amps.adapter.csj.CSJBannerAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadBannerAd onAdClicked");
                CSJBannerAdapter.this.onAdClicked();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadBannerAd onAdShow");
                CSJBannerAdapter.this.onAdShow();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadBannerAd onRenderFail");
                CSJBannerAdapter.this.onAdShowFailed(String.valueOf(i6), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f6, float f7) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadBannerAd onRenderSuccess");
                TTNativeExpressAd tTNativeExpressAd2 = tTNativeExpressAd;
                if (tTNativeExpressAd2 != null) {
                    CSJBannerAdapter.this.mBannerView = tTNativeExpressAd2.getExpressAdView();
                }
                CSJBannerAdapter.this.onAdLoad();
            }
        });
        Context context = this.mContext;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        tTNativeExpressAd.setDislikeCallback((Activity) context, new TTAdDislike.DislikeInteractionCallback() { // from class: xyz.adscope.amps.adapter.csj.CSJBannerAdapter.4
            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onSelected(int i6, String str, boolean z5) {
                CSJBannerAdapter.this.onAdDismiss();
                if (CSJBannerAdapter.this.mTTBannerAd != null) {
                    CSJBannerAdapter.this.mTTBannerAd.destroy();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onShow() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBannerAd() {
        StringBuilder a6 = a.a("CSJSDK start loadBannerAd  spaceId:");
        a6.append(this.mSpaceId);
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a6.toString());
        this.csjAdNative = CSJInitMediation.get().createAdNative(this.mContext);
        this.csjAdNative.loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdCount(this.adCount).setExpressViewAcceptedSize(this.expressViewWidthDp, this.expressViewHeightDp).build(), new TTAdNative.NativeExpressAdListener() { // from class: xyz.adscope.amps.adapter.csj.CSJBannerAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadBannerAd onError code:" + i6 + " message:" + str);
                CSJBannerAdapter.this.onAdFailed(String.valueOf(i6), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadBannerAd onNativeExpressAdLoad ");
                if (list == null || list.size() == 0) {
                    CSJBannerAdapter cSJBannerAdapter = CSJBannerAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    cSJBannerAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                if (CSJBannerAdapter.this.mTTBannerAd != null) {
                    CSJBannerAdapter.this.mTTBannerAd.destroy();
                }
                CSJBannerAdapter.this.mTTBannerAd = list.get(0);
                CSJBannerAdapter.this.mTTBannerAd.setSlideIntervalTime(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                CSJBannerAdapter cSJBannerAdapter2 = CSJBannerAdapter.this;
                cSJBannerAdapter2.bindAdListener(cSJBannerAdapter2.mTTBannerAd);
                CSJBannerAdapter.this.mTTBannerAd.render();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTNativeExpressAd tTNativeExpressAd = this.mTTBannerAd;
        if (tTNativeExpressAd != null) {
            return tTNativeExpressAd.getMediaExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mTTBannerAd != null;
    }

    @Override // xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        View view = this.mBannerView;
        if (view != null && viewGroup != null) {
            viewGroup.addView(view);
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        CSJInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.csj.CSJBannerAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                StringBuilder a6 = a.a("GMSDK loadSplashAd onSplashLoadFail code:");
                a6.append(aMPSError.getCode());
                a6.append(" message:");
                a6.append(aMPSError.getMessage());
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a6.toString());
                CSJBannerAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                CSJBannerAdapter.this.loadBannerAd();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        try {
            super.destroy();
            TTNativeExpressAd tTNativeExpressAd = this.mTTBannerAd;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
            }
            this.csjAdNative = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
