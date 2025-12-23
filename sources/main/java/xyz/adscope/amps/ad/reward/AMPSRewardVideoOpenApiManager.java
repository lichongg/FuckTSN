package xyz.adscope.amps.ad.reward;

import android.content.Context;
import java.util.Map;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSRewardVideoOpenApiManager extends AMPSBaseOpenApiManager implements AMPSRewardVideoAdAdapterListener {
    private AMPSRewardVideoLoadEventListener ampsRewardVideoLoadEventListener;

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdInteractionListener
    public void onRewardArrived(boolean z5, int i6, Map<String, Object> map) {
        AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener = this.ampsRewardVideoLoadEventListener;
        if (aMPSRewardVideoLoadEventListener != null) {
            aMPSRewardVideoLoadEventListener.onAmpsAdRewardArrived(z5, i6, map);
        }
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdInteractionListener
    public void onVideoComplete() {
        AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener = this.ampsRewardVideoLoadEventListener;
        if (aMPSRewardVideoLoadEventListener != null) {
            aMPSRewardVideoLoadEventListener.onAmpsAdVideoComplete();
        }
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdInteractionListener
    public void onVideoError() {
        AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener = this.ampsRewardVideoLoadEventListener;
        if (aMPSRewardVideoLoadEventListener != null) {
            aMPSRewardVideoLoadEventListener.onAmpsAdVideoError();
        }
    }

    public void refreshLoadEventListener(AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener) {
        this.ampsRewardVideoLoadEventListener = aMPSRewardVideoLoadEventListener;
        refreshListener(aMPSRewardVideoLoadEventListener);
    }

    public AMPSRewardVideoOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSRewardVideoLoadEventListener);
        this.ampsRewardVideoLoadEventListener = aMPSRewardVideoLoadEventListener;
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener
    public void onRewardVideoCached(AMPSBaseAdapter aMPSBaseAdapter) {
    }
}
