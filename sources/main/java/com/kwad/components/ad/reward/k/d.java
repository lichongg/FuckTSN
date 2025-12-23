package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {
    private a Ay;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.c.q qVar);
    }

    public final void a(a aVar) {
        this.Ay = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Ay = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.c.q qVar = new com.kwad.components.core.webview.tachikoma.c.q();
        try {
            qVar.parseJson(new JSONObject(str));
            a aVar = this.Ay;
            if (aVar != null) {
                aVar.a(qVar);
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickCall";
    }
}
