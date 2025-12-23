package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    private a agG;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.c.u uVar);
    }

    public final void a(a aVar) {
        this.agG = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agG = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.agG != null) {
            com.kwad.components.core.webview.tachikoma.c.u uVar = new com.kwad.components.core.webview.tachikoma.c.u();
            try {
                try {
                    uVar.parseJson(new JSONObject(str));
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } finally {
                this.agG.b(uVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "skipVideo";
    }
}
