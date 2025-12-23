package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k implements com.kwad.sdk.core.webview.c.a {
    private a AG;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void d(com.kwad.components.core.webview.tachikoma.c.r rVar);
    }

    public final void a(a aVar) {
        this.AG = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.AG = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.AG != null) {
            com.kwad.components.core.webview.tachikoma.c.r rVar = new com.kwad.components.core.webview.tachikoma.c.r();
            try {
                rVar.parseJson(new JSONObject(str));
                this.AG.d(rVar);
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showPlayEnd";
    }
}
