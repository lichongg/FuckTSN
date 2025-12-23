package com.kwad.components.ad.j;

import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d implements h.a {
    private static volatile d LT;

    public static d nG() {
        if (LT == null) {
            synchronized (d.class) {
                try {
                    if (LT == null) {
                        LT = new d();
                    }
                } finally {
                }
            }
        }
        return LT;
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i6) {
        SceneImpl scene;
        if (!(fVar instanceof com.kwad.components.core.request.a) || i6 == e.aEq.errorCode || (scene = fVar.getScene()) == null) {
            return;
        }
        com.kwad.components.core.p.a.se().c(scene.getPosId(), i6 == e.aEl.errorCode ? 21001 : i6 == e.aEp.errorCode ? 21003 : (i6 <= 0 || i6 >= 1000) ? 21004 : 21002);
    }

    private d() {
    }

    public final void init() {
        h.Hy().a(this);
    }
}
