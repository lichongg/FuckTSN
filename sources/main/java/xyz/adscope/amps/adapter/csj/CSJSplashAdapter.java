package xyz.adscope.amps.adapter.csj;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.Map;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class CSJSplashAdapter extends AMPSSplashAdapter {
    private CSJSplashAd mSplashAd;
    private TTAdNative mTTAdNative;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSSplashAdAdapterListener);
        initSDK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSplashAd() {
        StringBuilder a6 = a.a("CSJSDK start loadSplashAd  spaceId:");
        a6.append(this.mSpaceId);
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a6.toString());
        this.mTTAdNative = CSJInitMediation.get().createAdNative(this.mContext);
        this.mTTAdNative.loadSplashAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setSupportDeepLink(true).setImageAcceptedSize(this.viewWidthPx, this.viewHeightPx).setExpressViewAcceptedSize(this.viewWidthDp, this.viewHeightDp).build(), new TTAdNative.CSJSplashAdListener() { // from class: xyz.adscope.amps.adapter.csj.CSJSplashAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadFail(CSJAdError cSJAdError) {
                String str;
                String str2;
                if (cSJAdError != null) {
                    str = String.valueOf(cSJAdError.getCode());
                    str2 = cSJAdError.getMsg();
                } else {
                    str = "";
                    str2 = "";
                }
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadSplashAd onSplashLoadFail code:" + str + " message:" + str2 + " spaceId:" + CSJSplashAdapter.this.mSpaceId);
                CSJSplashAdapter.this.onAdFailed(str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
                StringBuilder a7 = a.a("CSJSDK loadSplashAd onSplashLoadSuccess spaceId:");
                a7.append(CSJSplashAdapter.this.mSpaceId);
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a7.toString());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                String str;
                String str2;
                if (cSJAdError != null) {
                    str = String.valueOf(cSJAdError.getCode());
                    str2 = cSJAdError.getMsg();
                } else {
                    str = "";
                    str2 = "";
                }
                StringBuilder a7 = a.a("CSJSDK loadSplashAd onSplashRenderFail spaceId:");
                a7.append(CSJSplashAdapter.this.mSpaceId);
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a7.toString());
                CSJSplashAdapter.this.onAdShowFailed(str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                StringBuilder a7 = a.a("CSJSDK loadSplashAd onSplashRenderSuccess spaceId:");
                a7.append(CSJSplashAdapter.this.mSpaceId);
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a7.toString());
                if (cSJSplashAd == null) {
                    CSJSplashAdapter cSJSplashAdapter = CSJSplashAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    cSJSplashAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                } else {
                    CSJSplashAdapter.this.mSplashAd = cSJSplashAd;
                    CSJSplashAdapter.this.onAdLoad();
                    cSJSplashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: xyz.adscope.amps.adapter.csj.CSJSplashAdapter.2.1
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClick(CSJSplashAd cSJSplashAd2) {
                            StringBuilder a8 = a.a("CSJSDK loadSplashAd onSplashAdClick spaceId:");
                            a8.append(CSJSplashAdapter.this.mSpaceId);
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a8.toString());
                            CSJSplashAdapter.this.onAdClicked();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClose(CSJSplashAd cSJSplashAd2, int i6) {
                            StringBuilder a8 = a.a("CSJSDK loadSplashAd onSplashAdClose spaceId:");
                            a8.append(CSJSplashAdapter.this.mSpaceId);
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a8.toString());
                            CSJSplashAdapter.this.onAdDismiss();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdShow(CSJSplashAd cSJSplashAd2) {
                            StringBuilder a8 = a.a("CSJSDK loadSplashAd onSplashAdShow spaceId:");
                            a8.append(CSJSplashAdapter.this.mSpaceId);
                            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a8.toString());
                            CSJSplashAdapter.this.onAdShow();
                        }
                    });
                }
            }
        }, this.mTimeout);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        CSJSplashAd cSJSplashAd = this.mSplashAd;
        if (cSJSplashAd != null) {
            return cSJSplashAd.getMediaExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mTTAdNative != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        if (this.mTTAdNative != null && viewGroup != null) {
            this.mSplashAd.showSplashView(viewGroup);
        } else {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    private void initSDK() {
        CSJInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.csj.CSJSplashAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                StringBuilder a6 = a.a("GMSDK loadSplashAd onSplashLoadFail code:");
                a6.append(aMPSError.getCode());
                a6.append(" message:");
                a6.append(aMPSError.getMessage());
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a6.toString());
                CSJSplashAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                CSJSplashAdapter.this.loadSplashAd();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.mTTAdNative = null;
        CSJSplashAd cSJSplashAd = this.mSplashAd;
        if (cSJSplashAd != null && cSJSplashAd.getMediationManager() != null) {
            this.mSplashAd.getMediationManager().destroy();
            this.mSplashAd = null;
        }
    }
}
