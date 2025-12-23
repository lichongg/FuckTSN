package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class mf implements com.kwad.sdk.core.d<com.kwad.components.core.video.a.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        a2(eVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        return b2(eVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.abE = jSONObject.optString("vse_msg");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(eVar.abE)) {
            eVar.abE = "";
        }
        eVar.abF = jSONObject.optString("vse_simple_msg");
        if (obj.toString().equals(eVar.abF)) {
            eVar.abF = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = eVar.abE;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "vse_msg", eVar.abE);
        }
        String str2 = eVar.abF;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "vse_simple_msg", eVar.abF);
        }
        return jSONObject;
    }
}
