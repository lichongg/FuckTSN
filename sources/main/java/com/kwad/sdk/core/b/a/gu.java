package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gu implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.m> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.m mVar, JSONObject jSONObject) {
        a2(mVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.m mVar, JSONObject jSONObject) {
        return b2(mVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.ahf = jSONObject.optString("landingPageUrl");
        if (JSONObject.NULL.toString().equals(mVar.ahf)) {
            mVar.ahf = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = mVar.ahf;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "landingPageUrl", mVar.ahf);
        }
        return jSONObject;
    }
}
