package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o extends w {
    private a agE;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean isMuted();
    }

    public final void a(a aVar) {
        this.agE = aVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        if (this.agE != null) {
            com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
            nVar.ahg = this.agE.isMuted();
            cVar.a(nVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMuteStateListener";
    }

    public final void c(com.kwad.components.core.webview.tachikoma.c.n nVar) {
        super.b(nVar);
    }
}
