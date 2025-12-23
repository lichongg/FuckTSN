package xyz.adscope.amps.adapter.csj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapterListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.adapter.csj.data.CSJDrawAd;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class CSJDrawAdapter extends AMPSDrawAdAdapter {
    private List<TTNativeExpressAd> mTTAdList;
    private TTAdNative mTTAdNative;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSDrawAdAdapterListener aMPSDrawAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSDrawAdAdapterListener);
        initSDK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadDrawAd() {
        StringBuilder a6 = a.a("CSJSDK start loadDrawAd  spaceId:");
        a6.append(this.mSpaceId);
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a6.toString());
        this.mTTAdNative = CSJInitMediation.get().createAdNative(this.mContext);
        if (this.expressViewHeight <= 0) {
            this.expressViewHeight = 0;
        }
        this.mTTAdNative.loadExpressDrawFeedAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdCount(this.adCount).setExpressViewAcceptedSize(this.expressViewWidthDp, this.expressViewHeightDp).build(), new TTAdNative.NativeExpressAdListener() { // from class: xyz.adscope.amps.adapter.csj.CSJDrawAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadDrawAd onNativeLoadFail code:" + i6 + " message:" + str);
                CSJDrawAdapter cSJDrawAdapter = CSJDrawAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                sb.append("");
                cSJDrawAdapter.onAdFailed(sb.toString(), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadDrawAd onNativeExpressAdLoad");
                if (list != null && list.size() != 0) {
                    CSJDrawAdapter.this.mTTAdList = list;
                    CSJDrawAdapter.this.onAdLoad();
                } else {
                    CSJDrawAdapter cSJDrawAdapter = CSJDrawAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    cSJDrawAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                }
            }
        });
    }

    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter
    public List<AMPSDrawAdExpressInfo> getDrawListInfo() {
        ArrayList arrayList = new ArrayList();
        List<TTNativeExpressAd> list = this.mTTAdList;
        if (list != null && list.size() > 0) {
            Iterator<TTNativeExpressAd> it = this.mTTAdList.iterator();
            while (it.hasNext()) {
                arrayList.add(new CSJDrawAd(it.next(), this.mContext, this));
            }
        }
        return arrayList;
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

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mTTAdNative != null;
    }

    private void bindAdListener(TTFeedAd tTFeedAd) {
        if (tTFeedAd.getInteractionType() != 4) {
            return;
        }
        tTFeedAd.setDownloadListener(new TTAppDownloadListener() { // from class: xyz.adscope.amps.adapter.csj.CSJDrawAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j6, long j7, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onDownloadActive");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j6, long j7, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onDownloadFailed");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j6, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onDownloadFinished");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j6, long j7, String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onDownloadPaused");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadDrawAd onIdle");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onInstalled");
            }
        });
    }

    private void initSDK() {
        CSJInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.csj.CSJDrawAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                StringBuilder a6 = a.a("CSJSDK loadDrawAd onSplashLoadFail code:");
                a6.append(aMPSError.getCode());
                a6.append(" message:");
                a6.append(aMPSError.getMessage());
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, a6.toString());
                CSJDrawAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                CSJDrawAdapter.this.loadDrawAd();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            if (this.mTTAdNative != null) {
                this.mTTAdNative = null;
            }
            List<TTNativeExpressAd> list = this.mTTAdList;
            if (list != null) {
                list.clear();
                this.mTTAdList = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
