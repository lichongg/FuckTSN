package xyz.adscope.amps.ad.nativead;

import android.content.Context;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.base.AMPSBaseAd;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSNativeAd extends AMPSBaseAd {
    private AMPSNativeLoadEventListener listener;

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getAMPSOpenApiManager() {
        return new AMPSNativeOpenApiManager(this.mContext, this.parameters, this.listener);
    }

    public void pause() {
        AMPSBaseAdapter winAdSourceAdapter;
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null || (winAdSourceAdapter = aMPSBaseOpenApiManager.getWinAdSourceAdapter()) == null || !(winAdSourceAdapter instanceof AMPSNativeAdapter)) {
            return;
        }
        ((AMPSNativeAdapter) winAdSourceAdapter).pause();
    }

    public void resume() {
        AMPSBaseAdapter winAdSourceAdapter;
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null || (winAdSourceAdapter = aMPSBaseOpenApiManager.getWinAdSourceAdapter()) == null || !(winAdSourceAdapter instanceof AMPSNativeAdapter)) {
            return;
        }
        ((AMPSNativeAdapter) winAdSourceAdapter).resume();
    }

    public AMPSNativeAd(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSNativeLoadEventListener aMPSNativeLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSNativeLoadEventListener);
        this.listener = aMPSNativeLoadEventListener;
    }
}
