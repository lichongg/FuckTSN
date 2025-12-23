package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdResultData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n implements c {
    public static void a(final com.kwad.components.core.request.model.a aVar, @NonNull j jVar) {
        new com.kwad.components.core.n.a(aVar.Rw) { // from class: com.kwad.components.core.c.n.1
            @Override // com.kwad.components.core.n.a, com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: af, reason: merged with bridge method [inline-methods] */
            public final AdResultData parseData(String str) {
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(str, aVar.Rw.adScene);
                createFromResponseJson.setAdSource("network");
                return createFromResponseJson;
            }

            @Override // com.kwad.components.core.n.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: ou */
            public final com.kwad.components.core.request.a createRequest() {
                if (aVar.getAdStyle() == 4) {
                    com.kwad.components.ad.b.i iVar = (com.kwad.components.ad.b.i) com.kwad.sdk.components.d.f(com.kwad.components.ad.b.i.class);
                    aVar.Xe = iVar.S();
                }
                return new com.kwad.components.core.request.a(aVar);
            }
        }.request(jVar);
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        a(aVar, new j(aVar));
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkOnlyFetcher";
    }
}
