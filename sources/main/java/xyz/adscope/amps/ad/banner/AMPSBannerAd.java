package xyz.adscope.amps.ad.banner;

import android.content.Context;
import android.view.ViewGroup;
import xyz.adscope.amps.base.AMPSBaseAd;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSBannerAd extends AMPSBaseAd {
    private AMPSBannerLoadEventListener ampsBannerLoadEventListener;

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getAMPSOpenApiManager() {
        return new AMPSBannerOpenApiManager(this.mContext, this.parameters, this.ampsBannerLoadEventListener);
    }

    public void show(ViewGroup viewGroup) {
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null) {
            onAdFailed();
        } else {
            aMPSBaseOpenApiManager.show(viewGroup);
        }
    }

    public AMPSBannerAd(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSBannerLoadEventListener aMPSBannerLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSBannerLoadEventListener);
        this.ampsBannerLoadEventListener = aMPSBannerLoadEventListener;
    }
}
