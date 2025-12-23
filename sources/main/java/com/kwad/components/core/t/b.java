package com.kwad.components.core.t;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    private static volatile b YH;

    @NonNull
    public static b sY() {
        if (YH == null) {
            synchronized (b.class) {
                try {
                    if (YH == null) {
                        YH = new b();
                    }
                } finally {
                }
            }
        }
        return YH;
    }

    public final boolean a(final AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        boolean z5 = false;
        if (((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.d.c.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        if (bVar != null) {
            bVar.b(adTemplate, null, null, null);
        }
        boolean b6 = com.kwad.sdk.core.adlog.c.b(adTemplate, jSONObject, bVar);
        try {
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null && sceneImpl.adStyle == 10000) {
                z5 = true;
            }
            int i6 = adTemplate.adStyle;
            if (i6 == 3 || i6 == 2 || i6 == 13 || z5) {
                com.kwad.sdk.core.response.b.e.el(adTemplate);
                if (b6 && com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.c.a.class) != null) {
                    com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.c.a.class);
                }
            }
        } catch (Throwable unused) {
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.t.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.c.a nZ = com.kwad.components.core.c.a.nZ();
                if (nZ != null) {
                    nZ.w(com.kwad.sdk.core.response.b.e.ev(adTemplate));
                }
            }
        });
        com.kwad.components.core.c.g.om().av(adTemplate);
        return b6;
    }

    private b() {
    }
}
