package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gz implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.i.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.awp = jSONObject.optString("origin_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.awp)) {
            aVar.awp = "";
        }
        aVar.awq = jSONObject.optString("final_url");
        if (obj.toString().equals(aVar.awq)) {
            aVar.awq = "";
        }
        aVar.awh = jSONObject.optString("error_name");
        if (obj.toString().equals(aVar.awh)) {
            aVar.awh = "";
        }
        aVar.awr = jSONObject.optString("macro_type");
        if (obj.toString().equals(aVar.awr)) {
            aVar.awr = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.awp;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "origin_url", aVar.awp);
        }
        String str2 = aVar.awq;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", aVar.awq);
        }
        String str3 = aVar.awh;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_name", aVar.awh);
        }
        String str4 = aVar.awr;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "macro_type", aVar.awr);
        }
        return jSONObject;
    }
}
