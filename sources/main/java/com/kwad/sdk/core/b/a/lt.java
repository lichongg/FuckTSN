package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lt implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.aIL = jSONObject.optString("thirdUserId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(gVar.aIL)) {
            gVar.aIL = "";
        }
        gVar.aIM = jSONObject.optString("thirdUserName");
        if (obj.toString().equals(gVar.aIM)) {
            gVar.aIM = "";
        }
        gVar.thirdAge = jSONObject.optInt("thirdAge");
        gVar.thirdGender = jSONObject.optInt("thirdGender");
        gVar.thirdInterest = jSONObject.optString("thirdInterest");
        if (obj.toString().equals(gVar.thirdInterest)) {
            gVar.thirdInterest = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.aIL;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdUserId", gVar.aIL);
        }
        String str2 = gVar.aIM;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdUserName", gVar.aIM);
        }
        int i6 = gVar.thirdAge;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdAge", i6);
        }
        int i7 = gVar.thirdGender;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdGender", i7);
        }
        String str3 = gVar.thirdInterest;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdInterest", gVar.thirdInterest);
        }
        return jSONObject;
    }
}
