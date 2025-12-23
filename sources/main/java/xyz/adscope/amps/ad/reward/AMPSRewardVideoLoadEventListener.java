package xyz.adscope.amps.ad.reward;

import java.util.Map;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSRewardVideoLoadEventListener extends AMPSLoadEventListener {
    void onAmpsAdCached();

    void onAmpsAdDismiss();

    void onAmpsAdFailed(AMPSError aMPSError);

    void onAmpsAdLoad();

    void onAmpsAdRewardArrived(boolean z5, int i6, Map<String, Object> map);

    void onAmpsAdShow();

    void onAmpsAdVideoClick();

    void onAmpsAdVideoComplete();

    void onAmpsAdVideoError();
}
