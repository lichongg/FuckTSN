package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class at implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;
    private a adY = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int id;
        public int status;

        public a() {
        }
    }

    public final void bf(int i6) {
        s(1, 2);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    private void s(int i6, int i7) {
        com.kwad.sdk.core.webview.c.c cVar = this.ack;
        if (cVar != null) {
            a aVar = this.adY;
            aVar.id = i6;
            aVar.status = 2;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAnimationListener";
    }
}
