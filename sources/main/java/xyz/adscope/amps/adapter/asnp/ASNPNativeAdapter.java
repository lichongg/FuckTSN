package xyz.adscope.amps.adapter.asnp;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.ad.publish.ad.IBidding;
import xyz.adscope.ad.publish.ad.nativead.INativeAdConfig;
import xyz.adscope.ad.publish.ad.nativead.INativeAdItem;
import xyz.adscope.ad.publish.ad.nativead.INativeAdListener;
import xyz.adscope.ad.publish.ad.nativead.NativeAd;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.asnp.data.ASNPNativeAd;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPNativeAdapter extends AMPSNativeAdapter {
    private List<INativeAdItem> iNativeAdItems;
    private NativeAd mASNPNativeAd;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        if (!this.isBidding || this.mASNPNativeAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK start loadNativeAd spaceId:" + this.mSpaceId);
        if (this.mContext == null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_FAIL;
            onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            return;
        }
        INativeAdConfig.Builder builder = new INativeAdConfig.Builder();
        builder.setExpressSizePixel(this.expressViewWidth, this.expressViewHeight);
        builder.setAdCount(1);
        builder.setTimeoutMillion(this.mTimeout);
        INativeAdConfig build = builder.build(this.mSpaceId);
        INativeAdListener iNativeAdListener = new INativeAdListener() { // from class: xyz.adscope.amps.adapter.asnp.ASNPNativeAdapter.2
            @Override // xyz.adscope.ad.publish.ad.nativead.INativeAdListener, xyz.adscope.ad.d2
            public void onAdLoadFailed(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onNativeLoadFail code:" + i6 + " message:" + str);
                ASNPNativeAdapter aSNPNativeAdapter = ASNPNativeAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                sb.append("");
                aSNPNativeAdapter.onAdFailed(sb.toString(), str);
            }

            @Override // xyz.adscope.ad.publish.ad.nativead.INativeAdListener
            public void onAdLoaded(List<INativeAdItem> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onAdLoad");
                if (list == null || list.size() < 1) {
                    ASNPNativeAdapter aSNPNativeAdapter = ASNPNativeAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum2 = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    aSNPNativeAdapter.onAdFailed(channelErrorEnum2.getErrorCode(), channelErrorEnum2.getErrorMsg());
                    return;
                }
                ASNPNativeAdapter.this.iNativeAdItems = list;
                int i6 = 0;
                try {
                    INativeAdItem iNativeAdItem = (INativeAdItem) ASNPNativeAdapter.this.iNativeAdItems.get(0);
                    if (iNativeAdItem != null && iNativeAdItem.getBidding() != null) {
                        i6 = iNativeAdItem.getBidding().getECPM();
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                ASNPNativeAdapter aSNPNativeAdapter2 = ASNPNativeAdapter.this;
                if (aSNPNativeAdapter2.isBidding) {
                    aSNPNativeAdapter2.onC2SBiddingSuccess(i6);
                } else {
                    aSNPNativeAdapter2.onAdLoad();
                }
            }
        };
        NativeAd nativeAd = new NativeAd(this.mContext, build);
        this.mASNPNativeAd = nativeAd;
        nativeAd.loadAd(iNativeAdListener);
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        List<INativeAdItem> list = this.iNativeAdItems;
        if (list != null && list.size() > 0) {
            for (INativeAdItem iNativeAdItem : this.iNativeAdItems) {
                int i6 = this.mAdEcpm;
                if (this.isBidding && iNativeAdItem.getBidding() != null) {
                    i6 = iNativeAdItem.getBidding().getECPM();
                }
                arrayList.add(new ASNPNativeAd(iNativeAdItem, this, i6));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mASNPNativeAd != null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        INativeAdItem iNativeAdItem;
        try {
            List<INativeAdItem> list = this.iNativeAdItems;
            if (list != null && list.size() != 0 && aMPSBidResult != null && (iNativeAdItem = this.iNativeAdItems.get(0)) != null && iNativeAdItem.getBidding() != null) {
                iNativeAdItem.getBidding().notifyBidLose(IBidding.BiddingPriceBuilder.buildLoseNoticeMap(aMPSBidResult.getEcpm(), -1, aMPSBidResult.getChannelName(), String.valueOf(aMPSBidResult.getReason()), -1));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        INativeAdItem iNativeAdItem;
        try {
            List<INativeAdItem> list = this.iNativeAdItems;
            if (list != null && list.size() != 0 && aMPSBidResult != null && (iNativeAdItem = this.iNativeAdItems.get(0)) != null && iNativeAdItem.getBidding() != null) {
                iNativeAdItem.getBidding().notifyBidWin(IBidding.BiddingPriceBuilder.buildWinNoticeMap(iNativeAdItem.getBidding().getECPM(), aMPSBidResult.getEcpm(), aMPSBidResult.getChannelName(), -1));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void initSDK() {
        ASNPInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.asnp.ASNPNativeAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadSplashAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                ASNPNativeAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                ASNPNativeAdapter.this.loadNativeAd();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            if (this.mASNPNativeAd != null) {
                this.mASNPNativeAd = null;
            }
            List<INativeAdItem> list = this.iNativeAdItems;
            if (list != null && list.size() > 0) {
                Iterator<INativeAdItem> it = this.iNativeAdItems.iterator();
                while (it.hasNext()) {
                    it.next().destroyAd();
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
