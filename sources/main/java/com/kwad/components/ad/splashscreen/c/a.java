package com.kwad.components.ad.splashscreen.c;

import android.content.Context;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdResultData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.splashscreen.a.a {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.splashscreen.a.a.class;
    }

    @Override // com.kwad.components.ad.splashscreen.a.a
    public final KsFragment a(AdResultData adResultData, com.kwad.sdk.core.j.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return b.b(adResultData, bVar, splashScreenAdInteractionListener);
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
