package xyz.adscope.amps.adapter.gm;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapterListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.adapter.gm.data.GMDrawAd;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GMDrawAdapter extends AMPSDrawAdAdapter {
    private List<TTDrawFeedAd> mTTAdList;
    private TTAdNative mTTAdNative;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSDrawAdAdapterListener aMPSDrawAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSDrawAdAdapterListener);
        initSDK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadDrawAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK start loadDrawAd  spaceId:" + this.mSpaceId);
        this.mTTAdNative = GMInitMediation.get().createAdNative(this.mContext);
        if (this.expressViewHeight <= 0) {
            this.expressViewHeight = 0;
        }
        this.mTTAdNative.loadDrawFeedAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdCount(this.adCount).setExpressViewAcceptedSize(this.expressViewWidthDp, this.expressViewHeightDp).build(), new TTAdNative.DrawFeedAdListener() { // from class: xyz.adscope.amps.adapter.gm.GMDrawAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onNativeExpressAdLoad");
                if (list != null && list.size() != 0) {
                    GMDrawAdapter.this.mTTAdList = list;
                    GMDrawAdapter.this.onAdLoad();
                } else {
                    GMDrawAdapter gMDrawAdapter = GMDrawAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    gMDrawAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onNativeLoadFail code:" + i6 + " message:" + str);
                GMDrawAdapter gMDrawAdapter = GMDrawAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                sb.append("");
                gMDrawAdapter.onAdFailed(sb.toString(), str);
            }
        });
    }

    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter
    public List<AMPSDrawAdExpressInfo> getDrawListInfo() {
        ArrayList arrayList = new ArrayList();
        List<TTDrawFeedAd> list = this.mTTAdList;
        if (list != null && list.size() > 0) {
            Iterator<TTDrawFeedAd> it = this.mTTAdList.iterator();
            while (it.hasNext()) {
                arrayList.add(new GMDrawAd(it.next(), this.mContext, this));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTDrawFeedAd tTDrawFeedAd;
        List<TTDrawFeedAd> list = this.mTTAdList;
        if (list == null || list.size() < 1 || (tTDrawFeedAd = this.mTTAdList.get(0)) == null) {
            return null;
        }
        return tTDrawFeedAd.getMediaExtraInfo();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mTTAdNative != null;
    }

    private void bindAdListener(TTFeedAd tTFeedAd) {
        if (tTFeedAd.getInteractionType() != 4) {
            return;
        }
        tTFeedAd.setDownloadListener(new TTAppDownloadListener() { // from class: xyz.adscope.amps.adapter.gm.GMDrawAdapter.3
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
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onIdle");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onInstalled");
            }
        });
    }

    private void initSDK() {
        GMInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.gm.GMDrawAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                GMDrawAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                GMDrawAdapter.this.loadDrawAd();
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
            List<TTDrawFeedAd> list = this.mTTAdList;
            if (list != null) {
                list.clear();
                this.mTTAdList = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
