package com.kwad.components.core.c;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static boolean oc() {
        return false;
    }

    private static void ae(String str) {
        if (oc() && com.kwad.sdk.l.Cf().Bn()) {
            ac.Q(ServiceProvider.getContext(), str);
        }
    }

    public static void b(e eVar) {
        ae("使用缓存策略: " + eVar.oh());
    }
}
