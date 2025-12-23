package com.kwad.components.ad.reward.k;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.ad.reward.g AM;
    private AdTemplate mAdTemplate;
    private Context mContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean AN;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            a(aVar);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.AM = null;
        this.mContext = null;
        this.mAdTemplate = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showLandingPage";
    }

    public t(Context context, com.kwad.components.ad.reward.g gVar) {
        this.mContext = context;
        this.mAdTemplate = gVar.mAdTemplate;
        this.AM = gVar;
    }

    private void a(a aVar) {
        if (aVar.AN) {
            com.kwad.components.ad.reward.presenter.f.r(this.AM);
        } else {
            AdWebViewActivityProxy.launch(this.mContext, this.mAdTemplate);
        }
    }
}
