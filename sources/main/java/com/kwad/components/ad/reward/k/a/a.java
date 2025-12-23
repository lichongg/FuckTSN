package com.kwad.components.ad.reward.k.a;

import com.kwad.components.ad.reward.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.core.webview.tachikoma.d.b {
    private g AM;

    public final g ks() {
        return this.AM;
    }

    public a(g gVar) {
        this.AM = gVar;
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.hV().a(this.mAdTemplate, bVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.b, com.kwad.sdk.mvp.a
    public final void release() {
        super.release();
        this.AM = null;
    }
}
