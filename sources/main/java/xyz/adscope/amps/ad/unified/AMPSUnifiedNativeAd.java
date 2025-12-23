package xyz.adscope.amps.ad.unified;

import android.content.Context;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.base.AMPSBaseAd;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSUnifiedNativeAd extends AMPSBaseAd<AMPSUnifiedNativeLoadEventListener> {
    private final AMPSUnifiedNativeLoadEventListener mListener;

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getAMPSOpenApiManager() {
        return new AMPSUnifiedNativeOpenApiManager(this.mContext, this.parameters, this.mListener);
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

    public AMPSUnifiedNativeAd(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSUnifiedNativeLoadEventListener aMPSUnifiedNativeLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSUnifiedNativeLoadEventListener);
        this.mListener = aMPSUnifiedNativeLoadEventListener;
    }
}
