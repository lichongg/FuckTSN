package xyz.adscope.amps.ad.splash;

import xyz.adscope.amps.base.AMPSBaseListener;
import xyz.adscope.amps.common.AMPSError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSSplashAdListener implements AMPSBaseListener {
    public abstract void onAdClicked();

    public abstract void onAdDismiss();

    public abstract void onAdFailed(AMPSError aMPSError);

    public abstract void onAdLoaded();

    public abstract void onAdShow();
}
