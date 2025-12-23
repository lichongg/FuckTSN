package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.methodName = jSONObject.optString("method_name");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.methodName)) {
            bVar.methodName = "";
        }
        bVar.awd = jSONObject.optBoolean("is_convert");
        bVar.adNum = jSONObject.optInt("ad_num");
        bVar.awe = jSONObject.optBoolean("is_api_native");
        bVar.awf = jSONObject.optString("ad_request_type");
        if (obj.toString().equals(bVar.awf)) {
            bVar.awf = "";
        }
        bVar.adSource = jSONObject.optString("ad_require_source");
        if (obj.toString().equals(bVar.adSource)) {
            bVar.adSource = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.methodName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "method_name", bVar.methodName);
        }
        boolean z5 = bVar.awd;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_convert", z5);
        }
        int i6 = bVar.adNum;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_num", i6);
        }
        boolean z6 = bVar.awe;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_api_native", z6);
        }
        String str2 = bVar.awf;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_request_type", bVar.awf);
        }
        String str3 = bVar.adSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_require_source", bVar.adSource);
        }
        return jSONObject;
    }
}
