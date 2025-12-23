package xyz.adscope.amps.ad.splash;

import android.content.Context;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSSplashOpenApiManager extends AMPSBaseOpenApiManager implements AMPSSplashAdAdapterListener {
    private AMPSSplashLoadEventListener ampsSplashLoadEventListener;

    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener
    public void onSkippedAd() {
        AMPSSplashLoadEventListener aMPSSplashLoadEventListener = this.ampsSplashLoadEventListener;
        if (aMPSSplashLoadEventListener != null) {
            aMPSSplashLoadEventListener.onAmpsAdDismiss();
        }
    }

    public void refreshLoadEventListener(AMPSSplashLoadEventListener aMPSSplashLoadEventListener) {
        this.ampsSplashLoadEventListener = aMPSSplashLoadEventListener;
        refreshListener(aMPSSplashLoadEventListener);
    }

    public AMPSSplashOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSSplashLoadEventListener aMPSSplashLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSSplashLoadEventListener);
        this.ampsSplashLoadEventListener = aMPSSplashLoadEventListener;
    }
}
