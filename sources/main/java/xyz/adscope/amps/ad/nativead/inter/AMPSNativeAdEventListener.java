package xyz.adscope.amps.ad.nativead.inter;

import java.util.List;
import xyz.adscope.amps.ad.nativead.view.AMPSNativeAdView;
import xyz.adscope.amps.base.AMPSBaseListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSNativeAdEventListener implements AMPSBaseListener {
    public abstract void onAdClicked(AMPSNativeAdView aMPSNativeAdView);

    public abstract void onAdImpressed(List<AMPSNativeAdView> list);

    public abstract void onAdVideoEnd(AMPSNativeAdView aMPSNativeAdView);

    public abstract void onAdVideoProgress(AMPSNativeAdView aMPSNativeAdView, int i6);

    public abstract void onAdVideoStart(AMPSNativeAdView aMPSNativeAdView);
}
