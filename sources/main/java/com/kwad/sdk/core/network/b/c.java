package com.kwad.sdk.core.network.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public static b HU() {
        h hVar = (h) ServiceProvider.get(h.class);
        return (hVar == null || !hVar.BF()) ? new a() : new d();
    }
}
