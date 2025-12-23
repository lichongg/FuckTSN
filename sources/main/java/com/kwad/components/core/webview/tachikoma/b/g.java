package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.core.webview.tachikoma.c.l agw;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.c.l lVar = this.agw;
        if (lVar != null) {
            cVar.a(lVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsAdExtraData";
    }

    public g(com.kwad.components.core.webview.tachikoma.c.l lVar) {
        this.agw = lVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
