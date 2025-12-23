package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.k> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.k kVar, JSONObject jSONObject) {
        a2(kVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.k kVar, JSONObject jSONObject) {
        return b2(kVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kVar.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(kVar.data)) {
            kVar.data = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = kVar.data;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "data", kVar.data);
        }
        return jSONObject;
    }
}
