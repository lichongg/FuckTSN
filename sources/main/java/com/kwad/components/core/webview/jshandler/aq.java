package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aq implements com.kwad.sdk.core.webview.c.a {
    private a adV;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(com.kwad.components.core.webview.a.b bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.adV = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.a.b bVar = new com.kwad.components.core.webview.a.b();
        try {
            bVar.parseJson(new JSONObject(str));
            a aVar = this.adV;
            if (aVar != null) {
                aVar.a(bVar);
            }
        } catch (Exception e6) {
            cVar.onError(-1, "");
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openNewPage";
    }

    public aq(a aVar) {
        this.adV = aVar;
    }
}
