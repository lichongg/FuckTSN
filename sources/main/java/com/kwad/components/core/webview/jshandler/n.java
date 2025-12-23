package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n implements com.kwad.sdk.core.webview.c.a {
    com.kwad.sdk.core.webview.b acw;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements com.kwad.sdk.core.b {
        public String NN;
        public AdTemplate adTemplate;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.NN = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.NN);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.download.a.dM(com.kwad.sdk.core.response.b.e.el(a(aVar)).adConversionInfo.appDownloadUrl);
            cVar.a(null);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            cVar.onError(-1, th.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "cancelAppDownloadForAd";
    }

    public n(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
    }

    private AdTemplate a(a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        return adTemplate != null ? adTemplate : this.acw.dk(aVar.NN);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
