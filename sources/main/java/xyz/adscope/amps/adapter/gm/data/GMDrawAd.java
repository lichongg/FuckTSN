package xyz.adscope.amps.adapter.gm.data;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdExpressListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdVideoListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GMDrawAd implements AMPSDrawAdExpressInfo {
    private AMPSDrawAdAdapter adapter;
    private Context context;
    public TTDrawFeedAd mTTDrawFeedAd;

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void destroy() {
        try {
            TTDrawFeedAd tTDrawFeedAd = this.mTTDrawFeedAd;
            if (tTDrawFeedAd != null) {
                tTDrawFeedAd.destroy();
            }
            this.mTTDrawFeedAd = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public View getDrawView() {
        TTDrawFeedAd tTDrawFeedAd = this.mTTDrawFeedAd;
        if (tTDrawFeedAd != null) {
            return tTDrawFeedAd.getAdView();
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void render() {
        AMPSDrawAdAdapter aMPSDrawAdAdapter = this.adapter;
        if (aMPSDrawAdAdapter != null) {
            aMPSDrawAdAdapter.onRender();
        }
        TTDrawFeedAd tTDrawFeedAd = this.mTTDrawFeedAd;
        if (tTDrawFeedAd != null) {
            tTDrawFeedAd.render();
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void setAMPSDrawAdExpressInfoListener(final AMPSDrawAdExpressListener aMPSDrawAdExpressListener) {
        TTDrawFeedAd tTDrawFeedAd = this.mTTDrawFeedAd;
        if (tTDrawFeedAd == null) {
            return;
        }
        tTDrawFeedAd.setExpressRenderListener(new MediationExpressRenderListener() { // from class: xyz.adscope.amps.adapter.gm.data.GMDrawAd.1
            @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
            public void onAdClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onAdClicked");
                if (GMDrawAd.this.adapter != null) {
                    GMDrawAd.this.adapter.onAdClicked();
                }
                AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                if (aMPSDrawAdExpressListener2 != null) {
                    aMPSDrawAdExpressListener2.onAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
            public void onAdShow() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onAdShow");
                if (GMDrawAd.this.adapter != null) {
                    GMDrawAd.this.adapter.onAdShow();
                }
                AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                if (aMPSDrawAdExpressListener2 != null) {
                    aMPSDrawAdExpressListener2.onAdShow();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
            public void onRenderFail(View view, String str, int i6) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onRenderFail msg : " + str + " , code : " + i6);
                if (GMDrawAd.this.adapter != null) {
                    GMDrawAd.this.adapter.onAdShowFailed(String.valueOf(i6), str);
                    GMDrawAd.this.adapter.onRenderFail(new AMPSError(i6 + "", str));
                }
                AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                if (aMPSDrawAdExpressListener2 != null) {
                    aMPSDrawAdExpressListener2.onRenderFail(view, str, i6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
            public void onRenderSuccess(View view, float f6, float f7, boolean z5) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onRenderSuccess");
                if (GMDrawAd.this.adapter != null) {
                    GMDrawAd.this.adapter.onRenderSuccess();
                }
                AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                if (aMPSDrawAdExpressListener2 != null) {
                    aMPSDrawAdExpressListener2.onRenderSuccess(GMDrawAd.this.getDrawView(), f6, f7);
                }
            }
        });
        this.mTTDrawFeedAd.setDrawVideoListener(new TTDrawFeedAd.DrawVideoListener() { // from class: xyz.adscope.amps.adapter.gm.data.GMDrawAd.2
            @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener
            public void onClick() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener
            public void onClickRetry() {
            }
        });
        Context context = this.context;
        if (context instanceof Activity) {
            this.mTTDrawFeedAd.setDislikeCallback((Activity) context, new TTAdDislike.DislikeInteractionCallback() { // from class: xyz.adscope.amps.adapter.gm.data.GMDrawAd.3
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onCancel");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i6, String str, boolean z5) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onSelected");
                    if (GMDrawAd.this.adapter != null) {
                        GMDrawAd.this.adapter.onAdDismiss();
                    }
                    AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                    if (aMPSDrawAdExpressListener2 != null) {
                        aMPSDrawAdExpressListener2.onAdClosed(GMDrawAd.this.getDrawView());
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadDrawAd onShow");
                }
            });
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void setAMPSDrawAdVideoListener(final AMPSDrawAdVideoListener aMPSDrawAdVideoListener) {
        TTDrawFeedAd tTDrawFeedAd = this.mTTDrawFeedAd;
        if (tTDrawFeedAd == null) {
            return;
        }
        tTDrawFeedAd.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: xyz.adscope.amps.adapter.gm.data.GMDrawAd.4
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onProgressUpdate(long j6, long j7) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onProgressUpdate(j6, j7);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdComplete();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdContinuePlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoAdStartPlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoError(int i6, int i7) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoError(i6, i7);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd tTFeedAd) {
                AMPSDrawAdVideoListener aMPSDrawAdVideoListener2 = aMPSDrawAdVideoListener;
                if (aMPSDrawAdVideoListener2 != null) {
                    aMPSDrawAdVideoListener2.onVideoLoad();
                }
            }
        });
    }

    public GMDrawAd(TTDrawFeedAd tTDrawFeedAd, Context context, AMPSDrawAdAdapter aMPSDrawAdAdapter) {
        this.mTTDrawFeedAd = tTDrawFeedAd;
        this.context = context;
        this.adapter = aMPSDrawAdAdapter;
    }
}
