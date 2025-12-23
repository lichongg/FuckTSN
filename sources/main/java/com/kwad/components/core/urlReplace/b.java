package com.kwad.components.core.urlReplace;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends d {
    public b(String str) {
        putBody("originalMiMarketUrl", str);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.AY();
    }
}
