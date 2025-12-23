package com.kwad.components.core.j;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class b implements KsInnerAd {
    private final int Re;

    @NonNull
    private final AdTemplate mAdTemplate;

    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInnerAd
    public final int getType() {
        return this.Re;
    }

    public b(@NonNull AdTemplate adTemplate, int i6) {
        this.mAdTemplate = adTemplate;
        this.Re = i6;
    }
}
