package xyz.adscope.amps.ad.draw;

import android.content.Context;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter;
import xyz.adscope.amps.base.AMPSBaseAd;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSDrawAd extends AMPSBaseAd {
    private AMPSDrawLoadEventListener listener;

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getAMPSOpenApiManager() {
        return new AMPSDrawOpenApiManager(this.mContext, this.parameters, this.listener);
    }

    public void pause() {
        AMPSBaseAdapter winAdSourceAdapter;
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null || (winAdSourceAdapter = aMPSBaseOpenApiManager.getWinAdSourceAdapter()) == null || !(winAdSourceAdapter instanceof AMPSDrawAdAdapter)) {
            return;
        }
        ((AMPSDrawAdAdapter) winAdSourceAdapter).pause();
    }

    public void resume() {
        AMPSBaseAdapter winAdSourceAdapter;
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null || (winAdSourceAdapter = aMPSBaseOpenApiManager.getWinAdSourceAdapter()) == null || !(winAdSourceAdapter instanceof AMPSDrawAdAdapter)) {
            return;
        }
        ((AMPSDrawAdAdapter) winAdSourceAdapter).resume();
    }

    public AMPSDrawAd(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSDrawLoadEventListener aMPSDrawLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSDrawLoadEventListener);
        this.listener = aMPSDrawLoadEventListener;
    }
}
