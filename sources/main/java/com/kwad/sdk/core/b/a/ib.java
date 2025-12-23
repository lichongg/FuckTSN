package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ib implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.o> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.o oVar, JSONObject jSONObject) {
        a2(oVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.o oVar, JSONObject jSONObject) {
        return b2(oVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.o oVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        oVar.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(oVar.url)) {
            oVar.url = "";
        }
        oVar.title = jSONObject.optString("title");
        if (obj.toString().equals(oVar.title)) {
            oVar.title = "";
        }
        oVar.ahh = jSONObject.optBoolean("showConfirmDialog");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.o oVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = oVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", oVar.url);
        }
        String str2 = oVar.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", oVar.title);
        }
        boolean z5 = oVar.ahh;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showConfirmDialog", z5);
        }
        return jSONObject;
    }
}
