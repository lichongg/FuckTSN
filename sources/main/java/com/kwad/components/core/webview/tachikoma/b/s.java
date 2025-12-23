package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s implements com.kwad.sdk.core.webview.c.a {
    private a agF;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.c.t tVar);
    }

    public final void a(a aVar) {
        this.agF = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agF = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.agF != null) {
            com.kwad.components.core.webview.tachikoma.c.t tVar = new com.kwad.components.core.webview.tachikoma.c.t();
            try {
                tVar.parseJson(new JSONObject(str));
                this.agF.a(tVar);
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showToast";
    }
}
