package xyz.adscope.amps.adapter.ks;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.ks.data.KSNativeAd;
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
public class KSNativeAdapter extends AMPSNativeAdapter {
    private List<KsFeedAd> iNativeAdViews;
    private String mBidResponse;
    private BidResponseModel mBidResponseModel;
    private String mBidResponseV2;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        List<KsFeedAd> list;
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        if (isC2SAdSource() && (list = this.iNativeAdViews) != null && list.size() > 0) {
            onAdLoad();
        } else {
            initSDK();
            loadNativeAd();
        }
    }

    private void loadNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK start loadNativeAd spaceId:" + this.mSpaceId);
        KsScene.Builder builder = new KsScene.Builder(Long.parseLong(this.mSpaceId));
        if (!TextUtils.isEmpty(this.mBidResponse)) {
            builder.setBidResponse(this.mBidResponse);
        } else if (!TextUtils.isEmpty(this.mBidResponseV2)) {
            builder.setBidResponseV2(this.mBidResponseV2);
        }
        builder.width(this.expressViewWidth);
        builder.adNum(this.adCount);
        KsAdSDK.getLoadManager().loadConfigFeedAd(builder.build(), new KsLoadManager.FeedAdListener() { // from class: xyz.adscope.amps.adapter.ks.KSNativeAdapter.1
            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onError(int i6, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadNativeAd onError code:" + i6 + " message:" + str + " spaceId:" + KSNativeAdapter.this.mSpaceId);
                KSNativeAdapter kSNativeAdapter = KSNativeAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i6);
                sb.append("");
                kSNativeAdapter.onAdFailed(sb.toString(), str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadNativeAd onFeedAdLoad");
                if (list == null || list.size() == 0) {
                    KSNativeAdapter kSNativeAdapter = KSNativeAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    kSNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                KSNativeAdapter.this.iNativeAdViews = list;
                KsFeedAd ksFeedAd = (KsFeedAd) KSNativeAdapter.this.iNativeAdViews.get(0);
                int ecpm = ksFeedAd != null ? ksFeedAd.getECPM() : 0;
                if (KSNativeAdapter.this.isC2SAdSource()) {
                    KSNativeAdapter.this.onC2SBiddingSuccess(ecpm);
                } else {
                    KSNativeAdapter.this.onAdLoad();
                }
            }
        });
    }

    private void startS2SBidding() {
        KSBiddingRequestUtil.getBidResponse(this.mServerUrl, this.mAccountId, this.mSpaceId, this.mFloorEcpm, new BiddingRequestCallback() { // from class: xyz.adscope.amps.adapter.ks.KSNativeAdapter.2
            @Override // xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback
            public void fail(int i6, String str) {
                KSNativeAdapter.this.onS2SBiddingFail(i6 + "", str);
            }

            @Override // xyz.adscope.amps.adapter.ks.inner.BiddingRequestCallback
            public void success(String str, int i6, BidResponseModel bidResponseModel) {
                KSNativeAdapter.this.mBidResponseModel = bidResponseModel;
                KSNativeAdapter.this.mBidResponse = str;
                KSNativeAdapter.this.onS2SBiddingSuccess(i6);
            }
        });
    }

    public KsFeedAd getKsFeedAd() {
        KsFeedAd ksFeedAd;
        List<KsFeedAd> list = this.iNativeAdViews;
        if (list == null || list.size() == 0 || (ksFeedAd = this.iNativeAdViews.get(0)) == null) {
            return null;
        }
        return ksFeedAd;
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        List<KsFeedAd> list = this.iNativeAdViews;
        if (list != null && list.size() > 0) {
            for (KsFeedAd ksFeedAd : this.iNativeAdViews) {
                int i6 = this.mAdEcpm;
                if (this.isBidding && ksFeedAd != null) {
                    i6 = ksFeedAd.getECPM();
                }
                arrayList.add(new KSNativeAd(ksFeedAd, this, this.mContext, i6));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        List<KsFeedAd> list = this.iNativeAdViews;
        return (list == null || list.size() == 0) ? false : true;
    }

    private void initSDK() {
        KSInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        List<KsFeedAd> list = this.iNativeAdViews;
        if (list != null) {
            list.clear();
            this.iNativeAdViews = null;
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        KsFeedAd ksFeedAd = getKsFeedAd();
        if (ksFeedAd != null) {
            ksFeedAd.getMediaExtraInfo();
            return null;
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsFeedAd ksFeedAd = getKsFeedAd();
            if (ksFeedAd != null && aMPSBidResult != null) {
                KSAdManagerHolder.sendLossNotification(ksFeedAd, aMPSBidResult);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsFeedAd ksFeedAd = getKsFeedAd();
            if (ksFeedAd != null) {
                int ecpm = ksFeedAd.getECPM();
                if (isC2SAdSource()) {
                    KSAdManagerHolder.sendWinNotification(ksFeedAd, ecpm);
                } else if (isS2SAdSource()) {
                    KSBiddingRequestUtil.sendWinNotice(this.mBidResponseModel);
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
        if (isC2SAdSource()) {
            loadNativeAd();
        } else if (isS2SAdSource()) {
            startS2SBidding();
        }
    }
}
