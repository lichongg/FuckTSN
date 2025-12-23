package xyz.adscope.amps.ad.splash;

import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSSplashLoadEventListener extends AMPSLoadEventListener {
    void onAmpsAdClicked();

    void onAmpsAdDismiss();

    void onAmpsAdFailed(AMPSError aMPSError);

    void onAmpsAdLoaded();

    void onAmpsAdShow();
}
