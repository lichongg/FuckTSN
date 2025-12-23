package xyz.adscope.amps.ad.nativead.inter;

import android.view.View;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSNativeAdExpressInfo {
    void destroy();

    int getECPM();

    View getNativeExpressAdView();

    void render();

    void setAMPSNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener);
}
