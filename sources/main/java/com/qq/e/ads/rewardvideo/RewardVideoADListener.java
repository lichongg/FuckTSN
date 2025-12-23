package com.qq.e.ads.rewardvideo;

import com.qq.e.comm.util.AdError;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface RewardVideoADListener {
    void onADClick();

    void onADClose();

    void onADExpose();

    void onADLoad();

    void onADShow();

    void onError(AdError adError);

    void onReward(Map<String, Object> map);

    void onVideoCached();

    void onVideoComplete();
}
