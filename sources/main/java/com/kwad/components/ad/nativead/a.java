package com.kwad.components.ad.nativead;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.b.g;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.sdk.components.e implements g {
    @Override // com.kwad.components.ad.b.g
    public final void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        if (l.Cf().CG()) {
            c.loadNativeAd(ksScene, nativeAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEz;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return g.class;
    }

    @Override // com.kwad.components.ad.b.g
    public final void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        c.loadNativeAd(str, nativeAdListener);
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
