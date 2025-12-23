package xyz.adscope.amps.adapter.csj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.csj.data.CSJNativeAd;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class CSJNativeAdapter extends AMPSNativeAdapter {
    private List<TTNativeExpressAd> mTTAdList;
    private TTAdNative mTTAdNative;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        initSDK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNativeAd() {
        StringBuilder a6 = a.a("CSJSDK start loadNativeAd  spaceId:");
        a6.append(this.mSpaceId);
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a6.toString());
        this.mTTAdNative = CSJInitMediation.get().createAdNative(this.mContext);
        CSJInitMediation.get().requestPermissionIfNecessary(this.mContext);
        if (this.expressViewHeightDp <= 0) {
            this.expressViewHeightDp = 0;
        }
        this.mTTAdNative.loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdCount(this.adCount).setExpressViewAcceptedSize(this.expressViewWidthDp, this.expressViewHeightDp).build(), new TTAdNative.NativeExpressAdListener() { // from class: xyz.adscope.amps.adapter.csj.CSJNativeAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onError code:" + i6 + " message:" + str);
                CSJNativeAdapter cSJNativeAdapter = CSJNativeAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                sb.append("");
                cSJNativeAdapter.onAdFailed(sb.toString(), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onNativeExpressAdLoad");
                if (list != null && list.size() != 0) {
                    CSJNativeAdapter.this.mTTAdList = list;
                    CSJNativeAdapter.this.onAdLoad();
                } else {
                    CSJNativeAdapter cSJNativeAdapter = CSJNativeAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    cSJNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                }
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTNativeExpressAd tTNativeExpressAd;
        List<TTNativeExpressAd> list = this.mTTAdList;
        if (list == null || list.size() < 1 || (tTNativeExpressAd = this.mTTAdList.get(0)) == null) {
            return null;
        }
        return tTNativeExpressAd.getMediaExtraInfo();
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        List<TTNativeExpressAd> list = this.mTTAdList;
        if (list != null && list.size() > 0) {
            for (TTNativeExpressAd tTNativeExpressAd : this.mTTAdList) {
                bindAdListener(tTNativeExpressAd);
                arrayList.add(new CSJNativeAd(tTNativeExpressAd, this.mContext, this, this.mAdEcpm));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mTTAdNative != null;
    }

    private void bindAdListener(TTNativeExpressAd tTNativeExpressAd) {
        if (tTNativeExpressAd.getInteractionType() != 4) {
            return;
        }
        tTNativeExpressAd.setDownloadListener(new TTAppDownloadListener() { // from class: xyz.adscope.amps.adapter.csj.CSJNativeAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j6, long j7, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onDownloadActive");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j6, long j7, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onDownloadFailed");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j6, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onDownloadFinished");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j6, long j7, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onDownloadPaused");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onIdle");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onInstalled");
            }
        });
    }

    private void initSDK() {
        CSJInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.csj.CSJNativeAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                StringBuilder a6 = a.a("GMSDK loadNativeAd onSplashLoadFail code:");
                a6.append(aMPSError.getCode());
                a6.append(" message:");
                a6.append(aMPSError.getMessage());
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a6.toString());
                CSJNativeAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                CSJNativeAdapter.this.loadNativeAd();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        if (this.mTTAdNative != null) {
            this.mTTAdNative = null;
        }
        List<TTNativeExpressAd> list = this.mTTAdList;
        if (list != null) {
            list.clear();
            this.mTTAdList = null;
        }
    }
}
