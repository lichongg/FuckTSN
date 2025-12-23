package xyz.adscope.amps.adapter.bd.data;

import android.view.View;
import com.baidu.mobads.sdk.api.ExpressResponse;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.bd.BDNativeAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BDNativeAd implements AMPSNativeAdExpressInfo {
    public BDNativeAdapter adapter;
    private int ecpm;
    public ExpressResponse mExpressResponse;

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void destroy() {
        this.mExpressResponse = null;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public int getECPM() {
        return this.ecpm;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public View getNativeExpressAdView() {
        ExpressResponse expressResponse = this.mExpressResponse;
        if (expressResponse == null || !expressResponse.isAdAvailable()) {
            return null;
        }
        return this.mExpressResponse.getExpressAdView();
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void render() {
        BDNativeAdapter bDNativeAdapter = this.adapter;
        if (bDNativeAdapter != null) {
            bDNativeAdapter.onRender();
        }
        ExpressResponse expressResponse = this.mExpressResponse;
        if (expressResponse != null) {
            expressResponse.render();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void setAMPSNativeAdExpressListener(final AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        ExpressResponse expressResponse = this.mExpressResponse;
        if (expressResponse == null) {
            return;
        }
        expressResponse.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: xyz.adscope.amps.adapter.bd.data.BDNativeAd.1
            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClick");
                BDNativeAdapter bDNativeAdapter = BDNativeAd.this.adapter;
                if (bDNativeAdapter != null) {
                    bDNativeAdapter.onAdClicked();
                }
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                if (aMPSNativeAdExpressListener2 != null) {
                    aMPSNativeAdExpressListener2.onAdClicked();
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdExposed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdExposed");
                BDNativeAdapter bDNativeAdapter = BDNativeAd.this.adapter;
                if (bDNativeAdapter != null) {
                    bDNativeAdapter.onAdShow();
                }
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                if (aMPSNativeAdExpressListener2 != null) {
                    aMPSNativeAdExpressListener2.onAdShow();
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdRenderFail(View view, String str, int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdRenderFail");
                BDNativeAdapter bDNativeAdapter = BDNativeAd.this.adapter;
                if (bDNativeAdapter != null) {
                    bDNativeAdapter.onAdShowFailed(String.valueOf(i6), str);
                    BDNativeAd.this.adapter.onRenderFail(new AMPSError(i6 + "", str));
                }
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                if (aMPSNativeAdExpressListener2 != null) {
                    aMPSNativeAdExpressListener2.onRenderFail(view, str, i6);
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdRenderSuccess(View view, float f6, float f7) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdRenderSuccess");
                BDNativeAdapter bDNativeAdapter = BDNativeAd.this.adapter;
                if (bDNativeAdapter != null) {
                    bDNativeAdapter.onRenderSuccess();
                }
                AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                if (aMPSNativeAdExpressListener2 != null) {
                    aMPSNativeAdExpressListener2.onRenderSuccess(BDNativeAd.this.getNativeExpressAdView(), f6, f7);
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdUnionClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdUnionClick");
            }
        });
        this.mExpressResponse.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: xyz.adscope.amps.adapter.bd.data.BDNativeAd.2
            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
            public void onDislikeItemClick(String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onDislikeItemClick");
                try {
                    BDNativeAdapter bDNativeAdapter = BDNativeAd.this.adapter;
                    if (bDNativeAdapter != null) {
                        bDNativeAdapter.onAdDismiss();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdClosed(BDNativeAd.this.getNativeExpressAdView());
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
            public void onDislikeWindowClose() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onDislikeWindowClose()");
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
            public void onDislikeWindowShow() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onDislikeWindowShow");
            }
        });
    }

    public BDNativeAd(ExpressResponse expressResponse, BDNativeAdapter bDNativeAdapter, int i6) {
        this.mExpressResponse = expressResponse;
        this.adapter = bDNativeAdapter;
        this.ecpm = i6;
    }
}
