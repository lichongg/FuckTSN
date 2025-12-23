package com.kwad.components.ad.draw;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.e;
import com.kwad.sdk.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends e implements com.kwad.components.ad.b.c {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.c.class;
    }

    @Override // com.kwad.components.ad.b.c
    public final void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        if (!l.Cf().CG()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEz;
            drawAdListener.onError(eVar.errorCode, eVar.msg);
        } else {
            d.loadDrawAd(ksScene, drawAdListener);
        }
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
