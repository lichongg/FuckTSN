package xyz.adscope.amps.adapter.csj.data;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class CSJNativeAd implements AMPSNativeAdExpressInfo {
    private AMPSNativeAdapter adapter;
    private Context context;
    private int ecpm;
    public TTNativeExpressAd ttNativeExpressAd;

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void destroy() {
        try {
            TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
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
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            return tTNativeExpressAd.getExpressAdView();
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void render() {
        AMPSNativeAdapter aMPSNativeAdapter = this.adapter;
        if (aMPSNativeAdapter != null) {
            aMPSNativeAdapter.onRender();
        }
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.render();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void setAMPSNativeAdExpressListener(final AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: xyz.adscope.amps.adapter.csj.data.CSJNativeAd.1
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i6) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onAdClicked");
                    if (CSJNativeAd.this.adapter != null) {
                        CSJNativeAd.this.adapter.onAdClicked();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i6) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onAdShow");
                    if (CSJNativeAd.this.adapter != null) {
                        CSJNativeAd.this.adapter.onAdShow();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdShow();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i6) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onRenderFailmsg : " + str + " , code : " + i6);
                    if (CSJNativeAd.this.adapter != null) {
                        CSJNativeAd.this.adapter.onAdShowFailed(String.valueOf(i6), str);
                        CSJNativeAd.this.adapter.onRenderFail(new AMPSError(i6 + "", str));
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onRenderFail(view, str, i6);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f6, float f7) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onRenderSuccess");
                    if (CSJNativeAd.this.adapter != null) {
                        CSJNativeAd.this.adapter.onRenderSuccess();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onRenderSuccess(CSJNativeAd.this.getNativeExpressAdView(), f6, f7);
                    }
                }
            });
            Context context = this.context;
            if (context instanceof Activity) {
                this.ttNativeExpressAd.setDislikeCallback((Activity) context, new TTAdDislike.DislikeInteractionCallback() { // from class: xyz.adscope.amps.adapter.csj.data.CSJNativeAd.2
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onCancel");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i6, String str, boolean z5) {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onSelected");
                        if (CSJNativeAd.this.adapter != null) {
                            CSJNativeAd.this.adapter.onAdDismiss();
                        }
                        AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                        if (aMPSNativeAdExpressListener2 != null) {
                            aMPSNativeAdExpressListener2.onAdClosed(CSJNativeAd.this.getNativeExpressAdView());
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadNativeAd onShow");
                    }
                });
            }
        }
    }

    public CSJNativeAd(TTNativeExpressAd tTNativeExpressAd, Context context, AMPSNativeAdapter aMPSNativeAdapter, int i6) {
        this.ttNativeExpressAd = tTNativeExpressAd;
        this.context = context;
        this.adapter = aMPSNativeAdapter;
        this.ecpm = i6;
    }
}
