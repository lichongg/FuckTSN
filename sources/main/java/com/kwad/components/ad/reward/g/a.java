package com.kwad.components.ad.reward.g;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.b.h;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.e;
import com.kwad.sdk.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends e implements h {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return h.class;
    }

    @Override // com.kwad.components.ad.b.h
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        if (!l.Cf().CG()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEz;
            rewardVideoAdListener.onError(eVar.errorCode, eVar.msg);
        } else {
            b.a(ksScene, new c(ksScene.getPosId(), rewardVideoAdListener));
        }
    }

    @Override // com.kwad.components.ad.b.h
    public final void notifyRewardVerify() {
        com.kwad.components.ad.reward.b.gk().notifyRewardVerify();
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
