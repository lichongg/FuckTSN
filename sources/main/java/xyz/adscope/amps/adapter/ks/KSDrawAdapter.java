package xyz.adscope.amps.adapter.ks;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapterListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.adapter.ks.data.KSDrawAd;
import xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback;
import xyz.adscope.amps.adapter.ks.model.BidResponseModel;
import xyz.adscope.amps.adapter.ks.util.KSBiddingRequestUtil;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class KSDrawAdapter extends AMPSDrawAdAdapter {
    private String mBidResponse;
    private BidResponseModel mBidResponseModel;
    private String mBidResponseV2;
    private List<KsDrawAd> mKsDrawAds;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSDrawAdAdapterListener aMPSDrawAdAdapterListener) {
        List<KsDrawAd> list;
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSDrawAdAdapterListener);
        if (isC2SAdSource() && (list = this.mKsDrawAds) != null && list.size() > 0) {
            onAdLoad();
        } else {
            initSDK();
            loadDrawAd();
        }
    }

    private void loadDrawAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK start loadDrawAd spaceId:" + this.mSpaceId);
        KsScene.Builder builder = new KsScene.Builder(Long.parseLong(this.mSpaceId));
        if (!TextUtils.isEmpty(this.mBidResponse)) {
            builder.setBidResponse(this.mBidResponse);
        } else if (!TextUtils.isEmpty(this.mBidResponseV2)) {
            builder.setBidResponseV2(this.mBidResponseV2);
        }
        builder.width(this.expressViewWidth);
        builder.adNum(this.adCount).build();
        KsAdSDK.getLoadManager().loadDrawAd(builder.build(), new KsLoadManager.DrawAdListener() { // from class: xyz.adscope.amps.adapter.ks.KSDrawAdapter.1
            @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
            public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadDrawAd onFeedAdLoad");
                if (list == null || list.size() == 0) {
                    KSDrawAdapter kSDrawAdapter = KSDrawAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    kSDrawAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                KSDrawAdapter.this.mKsDrawAds = list;
                KsDrawAd ksDrawAd = (KsDrawAd) KSDrawAdapter.this.mKsDrawAds.get(0);
                int ecpm = ksDrawAd != null ? ksDrawAd.getECPM() : 0;
                if (KSDrawAdapter.this.isC2SAdSource()) {
                    KSDrawAdapter.this.onC2SBiddingSuccess(ecpm);
                } else {
                    KSDrawAdapter.this.onAdLoad();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadDrawAd onError code:" + i6 + " message:" + str + " spaceId:" + KSDrawAdapter.this.mSpaceId);
                KSDrawAdapter kSDrawAdapter = KSDrawAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                sb.append("");
                kSDrawAdapter.onAdFailed(sb.toString(), str);
            }
        });
    }

    private void startS2SBidding() {
        KSBiddingRequestUtil.getBidResponse(this.mServerUrl, this.mAccountId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.ks.KSDrawAdapter.2
            @Override // xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                KSDrawAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                KSDrawAdapter.this.mBidResponseModel = bidResponseModel;
                KSDrawAdapter.this.mBidResponse = str;
                KSDrawAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter
    public List<AMPSDrawAdExpressInfo> getDrawListInfo() {
        ArrayList arrayList = new ArrayList();
        List<KsDrawAd> list = this.mKsDrawAds;
        if (list != null && list.size() > 0) {
            Iterator<KsDrawAd> it = this.mKsDrawAds.iterator();
            while (it.hasNext()) {
                arrayList.add(new KSDrawAd(it.next(), this, this.mContext));
            }
        }
        return arrayList;
    }

    public KsDrawAd getKsDrawAd() {
        KsDrawAd ksDrawAd;
        List<KsDrawAd> list = this.mKsDrawAds;
        if (list == null || list.size() == 0 || (ksDrawAd = this.mKsDrawAds.get(0)) == null) {
            return null;
        }
        return ksDrawAd;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        List<KsDrawAd> list = this.mKsDrawAds;
        return (list == null || list.size() == 0) ? false : true;
    }

    private void initSDK() {
        KSInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        List<KsDrawAd> list = this.mKsDrawAds;
        if (list != null) {
            list.clear();
            this.mKsDrawAds = null;
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        KsDrawAd ksDrawAd = getKsDrawAd();
        if (ksDrawAd != null) {
            ksDrawAd.getMediaExtraInfo();
            return null;
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsDrawAd ksDrawAd = getKsDrawAd();
            if (ksDrawAd != null && aMPSBidResult != null) {
                KSAdManagerHolder.sendLossNotification(ksDrawAd, aMPSBidResult);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsDrawAd ksDrawAd = getKsDrawAd();
            if (ksDrawAd != null) {
                int ecpm = ksDrawAd.getECPM();
                if (isC2SAdSource()) {
                    KSAdManagerHolder.sendWinNotification(ksDrawAd, ecpm);
                } else if (isS2SAdSource()) {
                    KSBiddingRequestUtil.sendWinNotice(this.mBidResponseModel);
                }
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
