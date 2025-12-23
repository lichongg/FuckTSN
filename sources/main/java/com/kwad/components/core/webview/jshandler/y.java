package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class y implements com.kwad.sdk.core.webview.c.a {
    private List<AdTemplate> acH;
    private com.kwad.sdk.core.webview.b eQ;
    private b ry;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void W(AdTemplate adTemplate);
    }

    public y(List<AdTemplate> list) {
        this.acH = list;
    }

    public final void a(b bVar) {
        this.ry = bVar;
    }

    private List<AdTemplate> uB() {
        List<AdTemplate> list = this.acH;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.eQ;
        if (bVar != null) {
            return bVar.KI();
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate a6 = com.kwad.sdk.core.response.b.e.a(uB(), aVar.creativeId, aVar.adStyle);
            b bVar = this.ry;
            if (bVar != null) {
                bVar.W(a6);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adImpression";
    }

    public y(com.kwad.sdk.core.webview.b bVar) {
        this.eQ = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
