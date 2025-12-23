package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    protected final com.kwad.sdk.core.webview.b acw;
    private AdTemplate mAdTemplate;

    private void aO(AdTemplate adTemplate) {
        adTemplate.mIsForceJumpLandingPage = true;
        com.kwad.components.core.e.d.a.a(new a.C0616a(this.acw.TG.getContext()).aB(adTemplate).aB(1).ap(true).an(true).as(false));
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdTemplate adTemplate = new AdTemplate();
            if (jSONObject.has("adTemplate")) {
                adTemplate.parseJson(new JSONObject(jSONObject.getString("adTemplate")));
            }
            if (adTemplate.adInfoList.size() != 0) {
                aO(adTemplate);
            } else {
                aO(this.mAdTemplate);
            }
            cVar.a(null);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "activityMiddlePageConvert";
    }

    public b(@NonNull com.kwad.sdk.core.webview.b bVar, @NonNull AdTemplate adTemplate) {
        this.acw = bVar;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
