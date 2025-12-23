package xyz.adscope.amps.adapter.gm.data;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GMNativeAd implements AMPSNativeAdExpressInfo {
    private AMPSNativeAdapter adapter;
    private Context context;
    private int ecpm;
    public TTFeedAd ttNativeExpressAd;

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void destroy() {
        try {
            TTFeedAd tTFeedAd = this.ttNativeExpressAd;
            if (tTFeedAd != null) {
                tTFeedAd.destroy();
            }
            this.ttNativeExpressAd = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public int getECPM() {
        return this.ecpm;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public View getNativeExpressAdView() {
        TTFeedAd tTFeedAd = this.ttNativeExpressAd;
        if (tTFeedAd != null) {
            return tTFeedAd.getAdView();
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void render() {
        AMPSNativeAdapter aMPSNativeAdapter = this.adapter;
        if (aMPSNativeAdapter != null) {
            aMPSNativeAdapter.onRender();
        }
        TTFeedAd tTFeedAd = this.ttNativeExpressAd;
        if (tTFeedAd != null) {
            tTFeedAd.render();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void setAMPSNativeAdExpressListener(final AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        TTFeedAd tTFeedAd = this.ttNativeExpressAd;
        if (tTFeedAd != null) {
            tTFeedAd.setExpressRenderListener(new MediationExpressRenderListener() { // from class: xyz.adscope.amps.adapter.gm.data.GMNativeAd.1
                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onAdClick() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onAdClicked");
                    if (GMNativeAd.this.adapter != null) {
                        GMNativeAd.this.adapter.onAdClicked();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onAdShow() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onAdShow");
                    if (GMNativeAd.this.adapter != null) {
                        GMNativeAd.this.adapter.onAdShow();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdShow();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onRenderFail(View view, String str, int i6) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onRenderFail msg : " + str + " , code : " + i6);
                    if (GMNativeAd.this.adapter != null) {
                        GMNativeAd.this.adapter.onAdShowFailed(String.valueOf(i6), str);
                        GMNativeAd.this.adapter.onRenderFail(new AMPSError(i6 + "", str));
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onRenderFail(view, str, i6);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
                public void onRenderSuccess(View view, float f6, float f7, boolean z5) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onRenderSuccess");
                    if (GMNativeAd.this.adapter != null) {
                        GMNativeAd.this.adapter.onRenderSuccess();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onRenderSuccess(GMNativeAd.this.getNativeExpressAdView(), f6, f7);
                    }
                }
            });
            Context context = this.context;
            if (context instanceof Activity) {
                this.ttNativeExpressAd.setDislikeCallback((Activity) context, new TTAdDislike.DislikeInteractionCallback() { // from class: xyz.adscope.amps.adapter.gm.data.GMNativeAd.2
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onCancel");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i6, String str, boolean z5) {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onSelected");
                        if (GMNativeAd.this.adapter != null) {
                            GMNativeAd.this.adapter.onAdDismiss();
                        }
                        AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                        if (aMPSNativeAdExpressListener2 != null) {
                            aMPSNativeAdExpressListener2.onAdClosed(GMNativeAd.this.getNativeExpressAdView());
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadNativeAd onShow");
                    }
                });
            }
        }
    }

    public GMNativeAd(TTFeedAd tTFeedAd, Context context, AMPSNativeAdapter aMPSNativeAdapter, int i6) {
        this.ttNativeExpressAd = tTFeedAd;
        this.context = context;
        this.adapter = aMPSNativeAdapter;
        this.ecpm = i6;
    }
}
