package xyz.adscope.amps.ad.reward.adapter;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface AMPSRewardVideoAdInteractionListener {
    void onRewardArrived(boolean z5, int i6, Map<String, Object> map);

    void onVideoComplete();

    void onVideoError();
}
