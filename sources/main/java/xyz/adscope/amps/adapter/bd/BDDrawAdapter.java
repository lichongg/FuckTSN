package xyz.adscope.amps.adapter.bd;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.IFeedPortraitListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapterListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdExpressListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdVideoListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.adapter.bd.data.BDConstant;
import xyz.adscope.amps.adapter.bd.data.BDDrawAd;
import xyz.adscope.amps.adapter.bd.util.Base64Util;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BDDrawAdapter extends AMPSDrawAdAdapter {
    private AMPSDrawAdExpressListener mAMPSDrawAdExpressListener;
    private AMPSDrawAdVideoListener mAMPSDrawAdVideoListener;
    private BaiduNativeManager mBaiduNativeManager;
    private BaiduNativeManager.FeedAdListener mFeedAdListener = new BaiduNativeManager.FeedAdListener() { // from class: xyz.adscope.amps.adapter.bd.BDDrawAdapter.3
        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onLpClosed");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i6, String str, NativeResponse nativeResponse) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onNativeFail code:" + i6 + ", message:" + str);
            BDDrawAdapter bDDrawAdapter = BDDrawAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append(i6);
            sb.append("");
            bDDrawAdapter.onAdFailed(sb.toString(), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(List<NativeResponse> list) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onNativeExpressAdLoad");
            if (list == null || list.size() == 0) {
                BDDrawAdapter bDDrawAdapter = BDDrawAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                bDDrawAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                return;
            }
            BDDrawAdapter.this.mNativeResponseList = list;
            int i6 = 0;
            try {
                NativeResponse nativeResponse = list.get(0);
                if (nativeResponse != null) {
                    i6 = Integer.parseInt(nativeResponse.getECPMLevel());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BDDrawAdapter bDDrawAdapter2 = BDDrawAdapter.this;
            if (bDDrawAdapter2.isBidding) {
                bDDrawAdapter2.onC2SBiddingSuccess(i6);
            } else {
                bDDrawAdapter2.onAdLoad();
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i6, String str, NativeResponse nativeResponse) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onNoAd code:" + i6 + ", message:" + str);
            BDDrawAdapter bDDrawAdapter = BDDrawAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append(i6);
            sb.append("");
            bDDrawAdapter.onAdFailed(sb.toString(), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onVideoDownloadFailed");
            if (BDDrawAdapter.this.mAMPSDrawAdVideoListener != null) {
                BDDrawAdapter.this.mAMPSDrawAdVideoListener.onVideoError(-1, -1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onVideoDownloadSuccess");
            if (BDDrawAdapter.this.mAMPSDrawAdVideoListener != null) {
                BDDrawAdapter.this.mAMPSDrawAdVideoListener.onVideoLoad();
            }
        }
    };
    private List<NativeResponse> mNativeResponseList;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSDrawAdAdapterListener aMPSDrawAdAdapterListener) {
        List<NativeResponse> list;
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSDrawAdAdapterListener);
        if (!this.isBidding || (list = this.mNativeResponseList) == null || list.size() <= 0) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    private void loadDrawAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK start loadNativeAd spaceId:" + this.mSpaceId);
        if (this.expressViewHeightDp <= 0) {
            this.expressViewHeightDp = 0;
        }
        this.mBaiduNativeManager = new BaiduNativeManager(this.mContext, this.mSpaceId);
        this.mBaiduNativeManager.loadPortraitVideoAd(new RequestParameters.Builder().setHeight(this.expressViewHeightDp).setWidth(this.expressViewWidthDp).build(), this.mFeedAdListener);
    }

    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter
    public List<AMPSDrawAdExpressInfo> getDrawListInfo() {
        ArrayList arrayList = new ArrayList();
        List<NativeResponse> list = this.mNativeResponseList;
        if (list != null && list.size() > 0) {
            Iterator<NativeResponse> it = this.mNativeResponseList.iterator();
            while (it.hasNext()) {
                arrayList.add(new BDDrawAd(it.next(), this, this.mContext));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mBaiduNativeManager != null;
    }

    public View renderView(final NativeResponse nativeResponse) {
        try {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            final FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(this.mContext);
            feedPortraitVideoView.setUseDownloadFrame(true);
            feedPortraitVideoView.setShowProgress(true);
            feedPortraitVideoView.setVideoMute(true);
            feedPortraitVideoView.setProgressBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            feedPortraitVideoView.setProgressBarColor(-1);
            feedPortraitVideoView.setProgressHeightInDp(1);
            feedPortraitVideoView.setFeedPortraitListener(new IFeedPortraitListener() { // from class: xyz.adscope.amps.adapter.bd.BDDrawAdapter.4
                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void pauseBtnClick() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK pauseBtnClick");
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playCompletion() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK playCompletion");
                    if (BDDrawAdapter.this.mAMPSDrawAdVideoListener != null) {
                        BDDrawAdapter.this.mAMPSDrawAdVideoListener.onVideoAdComplete();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playError() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK playError");
                    if (BDDrawAdapter.this.mAMPSDrawAdVideoListener != null) {
                        BDDrawAdapter.this.mAMPSDrawAdVideoListener.onVideoError(-2, -2);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playPause() {
                    if (BDDrawAdapter.this.mAMPSDrawAdVideoListener != null) {
                        BDDrawAdapter.this.mAMPSDrawAdVideoListener.onVideoAdPaused();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playRenderingStart() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK playRenderingStart");
                    if (BDDrawAdapter.this.mAMPSDrawAdVideoListener != null) {
                        BDDrawAdapter.this.mAMPSDrawAdVideoListener.onVideoAdStartPlay();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playResume() {
                    if (BDDrawAdapter.this.mAMPSDrawAdVideoListener != null) {
                        BDDrawAdapter.this.mAMPSDrawAdVideoListener.onVideoAdContinuePlay();
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            List<View> arrayList2 = new ArrayList<>();
            arrayList.add(feedPortraitVideoView);
            nativeResponse.registerViewForInteraction(feedPortraitVideoView, arrayList, arrayList2, new NativeResponse.AdInteractionListener() { // from class: xyz.adscope.amps.adapter.bd.BDDrawAdapter.5
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposed() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onADExposed");
                    BDDrawAdapter.this.onAdShow();
                    if (BDDrawAdapter.this.mAMPSDrawAdExpressListener != null) {
                        BDDrawAdapter.this.mAMPSDrawAdExpressListener.onAdShow();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposureFailed(int i6) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onADExposureFailed");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADStatusChanged() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onADStatusChanged");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdClick() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClick");
                    BDDrawAdapter.this.onAdClicked();
                    if (BDDrawAdapter.this.mAMPSDrawAdExpressListener != null) {
                        BDDrawAdapter.this.mAMPSDrawAdExpressListener.onAdClicked();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdUnionClick() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdUnionClick");
                }
            });
            feedPortraitVideoView.post(new Runnable() { // from class: xyz.adscope.amps.adapter.bd.BDDrawAdapter.6
                @Override // java.lang.Runnable
                public void run() {
                    NativeResponse nativeResponse2;
                    try {
                        FeedPortraitVideoView feedPortraitVideoView2 = feedPortraitVideoView;
                        if (feedPortraitVideoView2 != null && (nativeResponse2 = nativeResponse) != null) {
                            feedPortraitVideoView2.setAdData((XAdNativeResponse) nativeResponse2);
                            feedPortraitVideoView.play();
                            feedPortraitVideoView.setVideoMute(!BDDrawAdapter.this.isVolumeOn);
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
            frameLayout.addView(feedPortraitVideoView, new FrameLayout.LayoutParams(-1, -1, 17));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setImageBitmap(Base64Util.base64ToBitmap(BDConstant.bd_icon_ad_logo));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 56, 83);
            layoutParams.setMargins(40, 0, 0, 40);
            frameLayout.addView(imageView, layoutParams);
            String title = nativeResponse.getTitle();
            String desc = nativeResponse.getDesc();
            if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(desc)) {
                LinearLayout linearLayout = new LinearLayout(this.mContext);
                linearLayout.setOrientation(1);
                if (!TextUtils.isEmpty(title)) {
                    TextView textView = new TextView(this.mContext);
                    textView.setText(title);
                    textView.setTextSize(2, 10.0f);
                    textView.setTextColor(Color.parseColor("#FFFFFF"));
                    linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                }
                if (!TextUtils.isEmpty(desc)) {
                    TextView textView2 = new TextView(this.mContext);
                    textView2.setText(desc);
                    textView2.setTextSize(2, 9.0f);
                    textView2.setTextColor(Color.parseColor("#FFFFFF"));
                    linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 83);
                layoutParams2.setMargins(40, 0, 0, 120);
                frameLayout.addView(linearLayout, layoutParams2);
            }
            return frameLayout;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            List<NativeResponse> list = this.mNativeResponseList;
            if (list != null && aMPSBidResult != null) {
                NativeResponse nativeResponse = list.size() > 0 ? this.mNativeResponseList.get(0) : null;
                if (nativeResponse == null) {
                    return;
                }
                nativeResponse.biddingFail(BDInitMediation.getInstance().getWinInfo(aMPSBidResult), new BiddingListener() { // from class: xyz.adscope.amps.adapter.bd.BDDrawAdapter.2
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public void onBiddingResult(boolean z5, String str, HashMap<String, Object> hashMap) {
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            List<NativeResponse> list = this.mNativeResponseList;
            if (list != null && aMPSBidResult != null) {
                NativeResponse nativeResponse = list.size() > 0 ? this.mNativeResponseList.get(0) : null;
                if (nativeResponse == null) {
                    return;
                }
                nativeResponse.biddingSuccess(BDInitMediation.getInstance().getSecondInfo(aMPSBidResult), new BiddingListener() { // from class: xyz.adscope.amps.adapter.bd.BDDrawAdapter.1
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public void onBiddingResult(boolean z5, String str, HashMap<String, Object> hashMap) {
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setAMPSDrawAdExpressListener(AMPSDrawAdExpressListener aMPSDrawAdExpressListener) {
        this.mAMPSDrawAdExpressListener = aMPSDrawAdExpressListener;
    }

    public void setAMPSDrawAdVideoListener(AMPSDrawAdVideoListener aMPSDrawAdVideoListener) {
        this.mAMPSDrawAdVideoListener = aMPSDrawAdVideoListener;
    }

    private void initSDK() {
        BDInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadDrawAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        try {
            super.destroy();
            if (this.mBaiduNativeManager != null) {
                this.mBaiduNativeManager = null;
            }
            List<NativeResponse> list = this.mNativeResponseList;
            if (list != null) {
                list.clear();
                this.mNativeResponseList = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
