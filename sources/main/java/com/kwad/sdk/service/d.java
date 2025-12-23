package com.kwad.sdk.service;

import com.kwad.sdk.service.a.e;
import com.kwad.sdk.service.a.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static void H(String str, String str2) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.H(str, str2);
        }
    }

    public static void a(g gVar) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.a(gVar);
        }
    }

    public static void b(com.kwad.sdk.service.a.c cVar) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.a(cVar);
        }
    }

    public static void gatherException(Throwable th) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        }
    }
}
