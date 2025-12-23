package com.kwad.sdk.core.webview;

import com.kwad.sdk.core.webview.a.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    private long aMY;
    private boolean aMZ;

    public static void d(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), aVar.pq());
        }
    }

    public final void a(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.pq());
        }
        if (aVar != null) {
            this.aMY = System.currentTimeMillis();
        }
    }

    public final void b(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.l(aVar.getAdTemplate(), System.currentTimeMillis() - this.aMY);
        }
    }

    public final void c(c.a aVar) {
        if (aVar == null || this.aMZ) {
            return;
        }
        this.aMZ = true;
        long j6 = 0;
        if (this.aMY > 0) {
            j6 = System.currentTimeMillis() - this.aMY;
            this.aMY = -1L;
        }
        com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.pq(), j6);
    }
}
