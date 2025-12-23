package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class d implements com.kwad.sdk.core.webview.c.a {
    public abstract void a(com.kwad.components.core.webview.tachikoma.c.g gVar);

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.c.g gVar = new com.kwad.components.core.webview.tachikoma.c.g();
        try {
            gVar.parseJson(new JSONObject(str));
            a(gVar);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "commonLog";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
