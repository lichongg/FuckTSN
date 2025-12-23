package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ha implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.contentEncoding)) {
            bVar.contentEncoding = "";
        }
        bVar.aNx = jSONObject.optString("Cache-Control");
        if (obj.toString().equals(bVar.aNx)) {
            bVar.aNx = "";
        }
        bVar.aNv = jSONObject.optString("Content-Type");
        if (obj.toString().equals(bVar.aNv)) {
            bVar.aNv = "";
        }
        com.kwad.sdk.core.webview.b.a.a aVar = new com.kwad.sdk.core.webview.b.a.a();
        bVar.aNy = aVar;
        aVar.parseJson(jSONObject.optJSONObject("headers"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = bVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Status", i6);
        }
        String str = bVar.contentEncoding;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        String str2 = bVar.aNx;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Cache-Control", bVar.aNx);
        }
        String str3 = bVar.aNv;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Content-Type", bVar.aNv);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "headers", bVar.aNy);
        return jSONObject;
    }
}
