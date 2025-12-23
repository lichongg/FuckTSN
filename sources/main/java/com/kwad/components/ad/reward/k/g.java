package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    private int AE;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.c.f fVar = new com.kwad.components.core.webview.tachikoma.c.f();
        fVar.agX = this.AE;
        cVar.a(fVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getCloseDelaySeconds";
    }

    public g(int i6) {
        this.AE = i6;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
