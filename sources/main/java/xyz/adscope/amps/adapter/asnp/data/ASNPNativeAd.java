package xyz.adscope.amps.adapter.asnp.data;

import android.view.View;
import xyz.adscope.ad.publish.ad.nativead.INativeAdItem;
import xyz.adscope.ad.publish.ad.nativead.INativeExpressListener;
import xyz.adscope.ad.publish.ad.nativead.INativeInteractiveListener;
import xyz.adscope.ad.publish.ad.nativead.INativeRenderListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPNativeAd implements AMPSNativeAdExpressInfo {
    private AMPSNativeAdapter adapter;
    private int ecpm;
    public INativeAdItem iNativeAdItem;
    private INativeRenderListener iNativeRenderListener;

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public int getECPM() {
        return this.ecpm;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public View getNativeExpressAdView() {
        INativeAdItem iNativeAdItem = this.iNativeAdItem;
        if (iNativeAdItem != null) {
            return iNativeAdItem.getExpressView();
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void render() {
        AMPSNativeAdapter aMPSNativeAdapter = this.adapter;
        if (aMPSNativeAdapter != null) {
            aMPSNativeAdapter.onRender();
        }
        INativeAdItem iNativeAdItem = this.iNativeAdItem;
        if (iNativeAdItem != null) {
            iNativeAdItem.renderAdView(this.iNativeRenderListener);
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void setAMPSNativeAdExpressListener(final AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        if (this.iNativeAdItem != null) {
            this.iNativeRenderListener = new INativeRenderListener() { // from class: xyz.adscope.amps.adapter.asnp.data.ASNPNativeAd.1
                @Override // xyz.adscope.ad.publish.ad.nativead.INativeRenderListener
                public void renderFailed() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onRenderFail");
                    if (ASNPNativeAd.this.adapter != null) {
                        AMPSNativeAdapter aMPSNativeAdapter = ASNPNativeAd.this.adapter;
                        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL;
                        aMPSNativeAdapter.onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                        ASNPNativeAd.this.adapter.onRenderFail(new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        AMPSErrorCode.ChannelErrorEnum channelErrorEnum2 = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL;
                        aMPSNativeAdExpressListener2.onRenderFail(null, channelErrorEnum2.getErrorMsg(), Integer.parseInt(channelErrorEnum2.getErrorCode()));
                    }
                }

                @Override // xyz.adscope.ad.publish.ad.nativead.INativeRenderListener
                public void renderSuccess(View view) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd  onRenderSuccess");
                    if (ASNPNativeAd.this.adapter != null) {
                        ASNPNativeAd.this.adapter.onRenderSuccess();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onRenderSuccess(view, 0.0f, 0.0f);
                    }
                }
            };
            this.iNativeAdItem.setInteractiveListener(new INativeInteractiveListener() { // from class: xyz.adscope.amps.adapter.asnp.data.ASNPNativeAd.2
                @Override // xyz.adscope.ad.publish.ad.nativead.INativeInteractiveListener
                public void onAdClicked() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onAdClicked");
                    if (ASNPNativeAd.this.adapter != null) {
                        ASNPNativeAd.this.adapter.onAdClicked();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdClicked();
                    }
                }
            });
            this.iNativeAdItem.setExpressListener(new INativeExpressListener() { // from class: xyz.adscope.amps.adapter.asnp.data.ASNPNativeAd.3
                @Override // xyz.adscope.ad.publish.ad.nativead.INativeExpressListener
                public void onAdClosed() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onAdClose");
                    try {
                        if (ASNPNativeAd.this.adapter != null) {
                            ASNPNativeAd.this.adapter.onAdDismiss();
                        }
                        AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                        if (aMPSNativeAdExpressListener2 != null) {
                            aMPSNativeAdExpressListener2.onAdClosed(ASNPNativeAd.this.getNativeExpressAdView());
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }

                @Override // xyz.adscope.ad.publish.ad.nativead.INativeExpressListener
                public void onAdExposure() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onAdExposure()");
                    if (ASNPNativeAd.this.adapter != null) {
                        ASNPNativeAd.this.adapter.onAdShow();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdShow();
                    }
                }

                @Override // xyz.adscope.ad.publish.ad.nativead.INativeExpressListener
                public void onAdShown() {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onAdShow");
                }
            });
        }
    }

    public ASNPNativeAd(INativeAdItem iNativeAdItem, AMPSNativeAdapter aMPSNativeAdapter, int i6) {
        this.iNativeAdItem = iNativeAdItem;
        this.adapter = aMPSNativeAdapter;
        this.ecpm = i6;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void destroy() {
    }
}
