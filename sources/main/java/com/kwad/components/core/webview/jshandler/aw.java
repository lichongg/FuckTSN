package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aw implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerDeeplinkListener";
    }

    public final void onFailed() {
        com.kwad.sdk.core.webview.c.c cVar = this.ack;
        if (cVar != null) {
            cVar.onError(-1, "deep link error");
        }
    }

    public final void onSuccess() {
        com.kwad.sdk.core.webview.c.c cVar = this.ack;
        if (cVar != null) {
            cVar.a(null);
        }
    }
}
