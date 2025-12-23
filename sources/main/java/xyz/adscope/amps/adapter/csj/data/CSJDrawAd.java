package xyz.adscope.amps.adapter.csj.data;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdExpressListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdVideoListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class CSJDrawAd implements AMPSDrawAdExpressInfo {
    private AMPSDrawAdAdapter adapter;
    private Context context;
    public TTNativeExpressAd mTTNativeExpressAd;

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void destroy() {
        try {
            TTNativeExpressAd tTNativeExpressAd = this.mTTNativeExpressAd;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
            }
            this.mTTNativeExpressAd = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public View getDrawView() {
        TTNativeExpressAd tTNativeExpressAd = this.mTTNativeExpressAd;
        if (tTNativeExpressAd != null) {
            return tTNativeExpressAd.getExpressAdView();
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void render() {
        AMPSDrawAdAdapter aMPSDrawAdAdapter = this.adapter;
        if (aMPSDrawAdAdapter != null) {
            aMPSDrawAdAdapter.onRender();
        }
        TTNativeExpressAd tTNativeExpressAd = this.mTTNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.render();
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void setAMPSDrawAdExpressInfoListener(final AMPSDrawAdExpressListener aMPSDrawAdExpressListener) {
        TTNativeExpressAd tTNativeExpressAd = this.mTTNativeExpressAd;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: xyz.adscope.amps.adapter.csj.data.CSJDrawAd.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadDrawAd onAdClicked");
                if (CSJDrawAd.this.adapter != null) {
                    CSJDrawAd.this.adapter.onAdClicked();
                }
                AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                if (aMPSDrawAdExpressListener2 != null) {
                    aMPSDrawAdExpressListener2.onAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadDrawAd onAdShow");
                if (CSJDrawAd.this.adapter != null) {
                    CSJDrawAd.this.adapter.onAdShow();
                }
                AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                if (aMPSDrawAdExpressListener2 != null) {
                    aMPSDrawAdExpressListener2.onAdShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadDrawAd onRenderFail msg : " + str + " , code : " + i6);
                if (CSJDrawAd.this.adapter != null) {
                    CSJDrawAd.this.adapter.onAdShowFailed(String.valueOf(i6), str);
                    CSJDrawAd.this.adapter.onRenderFail(new AMPSError(i6 + "", str));
                }
                AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                if (aMPSDrawAdExpressListener2 != null) {
                    aMPSDrawAdExpressListener2.onRenderFail(view, str, i6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f6, float f7) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadDrawAd onRenderSuccess");
                if (CSJDrawAd.this.adapter != null) {
                    CSJDrawAd.this.adapter.onRenderSuccess();
                }
                AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                if (aMPSDrawAdExpressListener2 != null) {
                    aMPSDrawAdExpressListener2.onRenderSuccess(CSJDrawAd.this.getDrawView(), f6, f7);
                }
            }
        });
        Context context = this.context;
        if (context instanceof Activity) {
            this.mTTNativeExpressAd.setDislikeCallback((Activity) context, new TTAdDislike.DislikeInteractionCallback() { // from class: xyz.adscope.amps.adapter.csj.data.CSJDrawAd.2
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadDrawAd onCancel");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i6, String str, boolean z5) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadDrawAd onSelected");
                    if (CSJDrawAd.this.adapter != null) {
                        CSJDrawAd.this.adapter.onAdDismiss();
                    }
                    AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                    if (aMPSDrawAdExpressListener2 != null) {
                        aMPSDrawAdExpressListener2.onAdClosed(CSJDrawAd.this.getDrawView());
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadDrawAd onShow");
                }
            });
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void setAMPSDrawAdVideoListener(final AMPSDrawAdVideoListener aMPSDrawAdVideoListener) {
        TTNativeExpressAd tTNativeExpressAd = this.mTTNativeExpressAd;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: xyz.adscope.amps.adapter.csj.data.CSJDrawAd.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onProgressUpdate(long j6, long j7) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onProgressUpdate(j6, j7);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdComplete() {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdComplete();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdContinuePlay() {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdContinuePlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdPaused() {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdStartPlay() {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdStartPlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoError(int i6, int i7) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoError(i6, i7);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoLoad();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onClickRetry() {
            }
        });
    }

    public CSJDrawAd(TTNativeExpressAd tTNativeExpressAd, Context context, AMPSDrawAdAdapter aMPSDrawAdAdapter) {
        this.mTTNativeExpressAd = tTNativeExpressAd;
        this.context = context;
        this.adapter = aMPSDrawAdAdapter;
    }
}
