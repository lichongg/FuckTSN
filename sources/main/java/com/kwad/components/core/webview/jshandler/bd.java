package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bd implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private com.kwad.sdk.core.webview.c.c ack;

    @Nullable
    private a aer;
    private final com.kwad.sdk.core.webview.b eQ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        @MainThread
        void f(AdTemplate adTemplate);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.webview.d.b.b bVar = new com.kwad.sdk.core.webview.d.b.b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
        if (this.aer != null) {
            if (!TextUtils.isEmpty(bVar.aNS)) {
                bVar.adTemplate.llsid = Long.parseLong(bVar.aNS);
            }
            if (!TextUtils.isEmpty(bVar.extra)) {
                bVar.adTemplate.extra = bVar.extra;
            }
            this.aer.f(bVar.adTemplate);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerSetAdTemplateListener";
    }

    public bd(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.eQ = bVar;
        this.aer = aVar;
    }
}
