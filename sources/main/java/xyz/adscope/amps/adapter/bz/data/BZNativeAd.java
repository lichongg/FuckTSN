package xyz.adscope.amps.adapter.bz.data;

import android.view.View;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.bz.BZNativeAdapter;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BZNativeAd implements AMPSNativeAdExpressInfo {
    private BZNativeAdapter adapter;
    private int ecpm;

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public int getECPM() {
        return this.ecpm;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public View getNativeExpressAdView() {
        BZNativeAdapter bZNativeAdapter = this.adapter;
        if (bZNativeAdapter != null) {
            return bZNativeAdapter.getAdView();
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void render() {
        BZNativeAdapter bZNativeAdapter = this.adapter;
        if (bZNativeAdapter != null) {
            bZNativeAdapter.onRender();
        }
        BZNativeAdapter bZNativeAdapter2 = this.adapter;
        if (bZNativeAdapter2 != null) {
            bZNativeAdapter2.renderView();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void setAMPSNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        BZNativeAdapter bZNativeAdapter = this.adapter;
        if (bZNativeAdapter != null) {
            bZNativeAdapter.setAMPSNativeAdExpressListener(aMPSNativeAdExpressListener);
        }
    }

    public BZNativeAd(BZNativeAdapter bZNativeAdapter, int i6) {
        this.adapter = bZNativeAdapter;
        this.ecpm = i6;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void destroy() {
    }
}
