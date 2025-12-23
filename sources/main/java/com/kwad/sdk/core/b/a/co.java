package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class co implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.Pj = jSONObject.optString("payload");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(gVar.Pj)) {
            gVar.Pj = "";
        }
        gVar.actionType = jSONObject.optInt("actionType");
        gVar.acb = jSONObject.optInt("adCacheId");
        gVar.NN = jSONObject.optString("creativeId");
        if (obj.toString().equals(gVar.NN)) {
            gVar.NN = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.Pj;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", gVar.Pj);
        }
        int i6 = gVar.actionType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", i6);
        }
        int i7 = gVar.acb;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheId", i7);
        }
        String str2 = gVar.NN;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", gVar.NN);
        }
        return jSONObject;
    }
}
