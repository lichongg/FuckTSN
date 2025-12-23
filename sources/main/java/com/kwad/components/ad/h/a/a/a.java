package com.kwad.components.ad.h.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.c.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private c qn;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qn = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        this.qn = cVar;
    }

    public final void fO() {
        c cVar = this.qn;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerPlayStateResetListener";
    }
}
