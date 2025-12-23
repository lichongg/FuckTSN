package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.h;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    private static g aDR;

    public static String getResponseData(String str) {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return qe().getResponseData(str);
    }

    private static g qe() {
        g gVar = aDR;
        if (gVar != null) {
            return gVar;
        }
        h hVar = (h) com.kwad.sdk.components.d.f(h.class);
        if (hVar != null) {
            hVar.qe();
            aDR = hVar.qe();
        } else {
            aDR = new a();
        }
        return aDR;
    }

    public static void a(String str, Map<String, String> map, String str2) {
        qe().a(str, map, str2);
    }

    public static String as(String str) {
        return qe().as(str);
    }

    public static void g(@NonNull Map<String, String> map) {
        qe().g(map);
    }
}
