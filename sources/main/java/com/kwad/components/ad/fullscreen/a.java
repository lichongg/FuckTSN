package com.kwad.components.ad.fullscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.e {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.e.class;
    }

    @Override // com.kwad.sdk.components.e, com.kwad.sdk.components.b
    public final int priority() {
        com.kwad.sdk.components.b f6 = com.kwad.sdk.components.d.f(com.kwad.components.ad.b.h.class);
        if (f6 != null) {
            return f6.priority() + 1;
        }
        return 1;
    }

    @Override // com.kwad.components.ad.b.e
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (!l.Cf().CG()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEz;
            fullScreenVideoAdListener.onError(eVar.errorCode, eVar.msg);
        } else {
            f.a(ksScene, new e(ksScene.getPosId(), fullScreenVideoAdListener));
        }
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
