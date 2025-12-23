package com.kwad.components.ad.reward.e;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {
    private static final HashMap<String, f> us = new HashMap<>();
    private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private com.kwad.components.core.j.d rt;
    private KsRewardVideoAd.RewardAdInteractionListener ut;

    private void destroy() {
        this.mInteractionListener = null;
        this.ut = null;
        com.kwad.components.core.j.d dVar = this.rt;
        if (dVar != null) {
            dVar.destroy();
            this.rt = null;
        }
    }

    @Nullable
    private static f M(String str) {
        return us.get(str);
    }

    public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.j.d dVar) {
        f fVar = new f();
        fVar.mInteractionListener = rewardAdInteractionListener;
        fVar.rt = dVar;
        fVar.ut = rewardAdInteractionListener;
        us.put(str, fVar);
    }

    public static KsRewardVideoAd.RewardAdInteractionListener N(String str) {
        f M = M(str);
        if (M != null) {
            return M.ut;
        }
        return null;
    }

    public static void O(String str) {
        f M = M(str);
        if (M != null) {
            M.ut = M.mInteractionListener;
        }
    }

    public static com.kwad.components.core.j.d P(String str) {
        f M = M(str);
        if (M != null) {
            return M.rt;
        }
        return null;
    }

    public static void Q(String str) {
        f M = M(str);
        if (M != null) {
            M.destroy();
            us.put(str, null);
        }
    }
}
