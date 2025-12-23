package com.kwad.components.ad.a;

import com.kwad.sdk.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.core.request.a {
    public a(com.kwad.components.core.request.model.a aVar) {
        super(aVar);
        putBody("requestTime", System.currentTimeMillis());
    }

    @Override // com.kwad.components.core.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.AN();
    }
}
