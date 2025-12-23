package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.e.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.awj = jSONObject.optString("imp_ad_info");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(cVar.awj)) {
            cVar.awj = "";
        }
        cVar.awk = jSONObject.optString("final_imp_ad_info");
        if (obj.toString().equals(cVar.awk)) {
            cVar.awk = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.awj;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imp_ad_info", cVar.awj);
        }
        String str2 = cVar.awk;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_imp_ad_info", cVar.awk);
        }
        return jSONObject;
    }
}
