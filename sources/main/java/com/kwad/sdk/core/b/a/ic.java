package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ic implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.abZ = jSONObject.optString("originalID");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(cVar.abZ)) {
            cVar.abZ = "";
        }
        cVar.aca = jSONObject.optString("path");
        if (obj.toString().equals(cVar.aca)) {
            cVar.aca = "";
        }
        cVar.acb = jSONObject.optInt("adCacheId");
        cVar.NN = jSONObject.optString("creativeId");
        if (obj.toString().equals(cVar.NN)) {
            cVar.NN = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.abZ;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "originalID", cVar.abZ);
        }
        String str2 = cVar.aca;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "path", cVar.aca);
        }
        int i6 = cVar.acb;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheId", i6);
        }
        String str3 = cVar.NN;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", cVar.NN);
        }
        return jSONObject;
    }
}
