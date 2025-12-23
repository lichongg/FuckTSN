package com.kwad.components.ad.splashscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.b.i;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.sdk.components.e implements i {
    @Override // com.kwad.sdk.components.b
    public final Class<i> getComponentsType() {
        return i.class;
    }

    @Override // com.kwad.components.ad.b.i
    public final List<String> S() {
        return SplashPreloadManager.lD().S();
    }

    @Override // com.kwad.components.ad.b.i
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        if (!l.Cf().CG()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEz;
            splashScreenAdListener.onError(eVar.errorCode, eVar.msg);
        } else {
            b.loadSplashScreenAd(ksScene, splashScreenAdListener);
        }
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
