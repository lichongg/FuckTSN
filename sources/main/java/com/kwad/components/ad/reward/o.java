package com.kwad.components.ad.reward;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o {
    public static void a(int i6, int i7, g gVar, com.kwad.components.ad.reward.model.c cVar) {
        if (i6 == 0) {
            com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 1);
            return;
        }
        if (i6 == 1) {
            if (i7 == 0) {
                if (gVar.sn.kL()) {
                    com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 1);
                    return;
                }
                return;
            } else if (gVar.sn.kL()) {
                com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 5);
                return;
            } else {
                com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 4);
                return;
            }
        }
        if (i6 != 2) {
            return;
        }
        if (i7 == 0) {
            if (gVar.sm.kL()) {
                com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 1);
            }
        } else if (gVar.sm.kL()) {
            com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 3);
        } else {
            com.kwad.sdk.core.adlog.c.l(cVar.getAdTemplate(), 2);
        }
    }
}
