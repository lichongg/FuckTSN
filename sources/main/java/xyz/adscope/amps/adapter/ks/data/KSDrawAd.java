package xyz.adscope.amps.adapter.ks.data;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsDrawAd;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdExpressListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdVideoListener;
import xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo;
import xyz.adscope.amps.adapter.ks.KSDrawAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class KSDrawAd implements AMPSDrawAdExpressInfo {
    private AMPSDrawAdExpressListener mAMPSDrawAdExpressListener = null;
    private AMPSDrawAdVideoListener mAMPSDrawAdVideoListener;
    private Context mContext;
    private KSDrawAdapter mKSDrawAdapter;
    public KsDrawAd mKsDrawAd;

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public View getDrawView() {
        Context context;
        KsDrawAd ksDrawAd = this.mKsDrawAd;
        if (ksDrawAd == null || (context = this.mContext) == null) {
            return null;
        }
        return ksDrawAd.getDrawView(context);
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void render() {
        if (this.mKsDrawAd == null || getDrawView() == null) {
            return;
        }
        KSDrawAdapter kSDrawAdapter = this.mKSDrawAdapter;
        if (kSDrawAdapter != null) {
            kSDrawAdapter.onRender();
            this.mKSDrawAdapter.onRenderSuccess();
        }
        AMPSDrawAdExpressListener aMPSDrawAdExpressListener = this.mAMPSDrawAdExpressListener;
        if (aMPSDrawAdExpressListener != null) {
            aMPSDrawAdExpressListener.onRenderSuccess(getDrawView(), 0.0f, 0.0f);
        }
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void setAMPSDrawAdExpressInfoListener(final AMPSDrawAdExpressListener aMPSDrawAdExpressListener) {
        KsDrawAd ksDrawAd = this.mKsDrawAd;
        if (ksDrawAd == null) {
            return;
        }
        this.mAMPSDrawAdExpressListener = aMPSDrawAdExpressListener;
        ksDrawAd.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: xyz.adscope.amps.adapter.ks.data.KSDrawAd.1
            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdClicked() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadDrawAd onAdClicked");
                if (KSDrawAd.this.mKSDrawAdapter != null) {
                    KSDrawAd.this.mKSDrawAdapter.onAdClicked();
                }
                AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                if (aMPSDrawAdExpressListener2 != null) {
                    aMPSDrawAdExpressListener2.onAdClicked();
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdShow() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadDrawAd onAdShow");
                if (KSDrawAd.this.mKSDrawAdapter != null) {
                    KSDrawAd.this.mKSDrawAdapter.onAdShow();
                }
                AMPSDrawAdExpressListener aMPSDrawAdExpressListener2 = aMPSDrawAdExpressListener;
                if (aMPSDrawAdExpressListener2 != null) {
                    aMPSDrawAdExpressListener2.onAdShow();
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayEnd() {
                if (KSDrawAd.this.mAMPSDrawAdVideoListener != null) {
                    KSDrawAd.this.mAMPSDrawAdVideoListener.onVideoAdComplete();
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayError() {
                if (KSDrawAd.this.mAMPSDrawAdVideoListener != null) {
                    KSDrawAd.this.mAMPSDrawAdVideoListener.onVideoError(-1, -1);
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayPause() {
                if (KSDrawAd.this.mAMPSDrawAdVideoListener != null) {
                    KSDrawAd.this.mAMPSDrawAdVideoListener.onVideoAdPaused();
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayResume() {
                if (KSDrawAd.this.mAMPSDrawAdVideoListener != null) {
                    KSDrawAd.this.mAMPSDrawAdVideoListener.onVideoAdContinuePlay();
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayStart() {
                if (KSDrawAd.this.mAMPSDrawAdVideoListener != null) {
                    KSDrawAd.this.mAMPSDrawAdVideoListener.onVideoAdStartPlay();
                }
            }
        });
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void setAMPSDrawAdVideoListener(AMPSDrawAdVideoListener aMPSDrawAdVideoListener) {
        this.mAMPSDrawAdVideoListener = aMPSDrawAdVideoListener;
    }

    public KSDrawAd(KsDrawAd ksDrawAd, KSDrawAdapter kSDrawAdapter, Context context) {
        this.mKsDrawAd = ksDrawAd;
        this.mKSDrawAdapter = kSDrawAdapter;
        this.mContext = context;
    }

    @Override // xyz.adscope.amps.ad.draw.inter.AMPSDrawAdExpressInfo
    public void destroy() {
    }
}
