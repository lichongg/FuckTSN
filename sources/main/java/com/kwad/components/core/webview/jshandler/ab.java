package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ab implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.b acw;

    public ab() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.webview.b bVar;
        AdTemplate adTemplate;
        AdResultData aI;
        try {
            com.kwad.sdk.core.d.c.d("CommercialLogHandler", "handleJsCall : " + str);
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("adCacheId");
            AdInfo s5 = (optInt == 0 || (aI = com.kwad.components.core.o.a.e.a.a.aI(optInt)) == null) ? null : com.kwad.sdk.core.response.b.c.s(aI);
            if (s5 == null && (bVar = this.acw) != null && (adTemplate = bVar.getAdTemplate()) != null) {
                s5 = com.kwad.sdk.core.response.b.e.el(adTemplate);
            }
            WebViewCommercialMsg webViewCommercialMsg = new WebViewCommercialMsg(s5);
            webViewCommercialMsg.parseJson(jSONObject);
            a(webViewCommercialMsg);
            cVar.a(null);
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            cVar.onError(-1, e6.getMessage());
        }
    }

    public ab(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "commercialLog";
    }

    private static void a(@NonNull WebViewCommercialMsg webViewCommercialMsg) {
        com.kwad.sdk.core.d.c.d("CommercialLogHandler", "handleH5Log actionType actionType" + webViewCommercialMsg.category);
        com.kwad.sdk.commercial.b.a(webViewCommercialMsg.category, webViewCommercialMsg);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
