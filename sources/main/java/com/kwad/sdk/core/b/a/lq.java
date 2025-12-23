package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lq implements com.kwad.sdk.core.d<com.kwad.components.core.o.c.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.o.c.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.o.c.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.o.c.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.ST = jSONObject.optString("load_module");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(dVar.ST)) {
            dVar.ST = "";
        }
        dVar.SU = jSONObject.optLong("load_status");
        dVar.SV = jSONObject.optLong("load_duration_ms");
        dVar.SY = jSONObject.optLong("update_duration_ms");
        dVar.SX = jSONObject.optString("load_source");
        if (obj.toString().equals(dVar.SX)) {
            dVar.SX = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.o.c.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.ST;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_module", dVar.ST);
        }
        long j6 = dVar.SU;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_status", j6);
        }
        long j7 = dVar.SV;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_duration_ms", j7);
        }
        long j8 = dVar.SY;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "update_duration_ms", j8);
        }
        String str2 = dVar.SX;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_source", dVar.SX);
        }
        return jSONObject;
    }
}
