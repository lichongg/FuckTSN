package com.kwad.components.ad.fullscreen;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public final boolean jk = com.kwad.components.ad.reward.a.b.hO();
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public final AdInfo cU() {
        return this.mAdInfo;
    }

    public final boolean cV() {
        return com.kwad.sdk.core.response.b.e.ex(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
    }
}
