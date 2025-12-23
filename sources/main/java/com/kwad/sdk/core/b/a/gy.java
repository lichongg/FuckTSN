package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gy implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aha = jSONObject.optInt("convertType");
        dVar.Pj = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(dVar.Pj)) {
            dVar.Pj = "";
        }
        com.kwad.sdk.core.webview.d.b.c cVar = new com.kwad.sdk.core.webview.d.b.c();
        dVar.aNT = cVar;
        cVar.parseJson(jSONObject.optJSONObject("clickInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = dVar.aha;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertType", i6);
        }
        String str = dVar.Pj;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", dVar.Pj);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "clickInfo", dVar.aNT);
        return jSONObject;
    }
}
