package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hz implements com.kwad.sdk.core.d<com.kwad.components.core.o.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.o.c.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.o.c.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.o.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.ST = jSONObject.optString("load_module");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.ST)) {
            bVar.ST = "";
        }
        bVar.SU = jSONObject.optLong("load_status");
        bVar.SV = jSONObject.optLong("load_duration_ms");
        bVar.SW = jSONObject.optLong("thread_core_size", new Long("0").longValue());
        bVar.SX = jSONObject.optString("load_source");
        if (obj.toString().equals(bVar.SX)) {
            bVar.SX = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.o.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.ST;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_module", bVar.ST);
        }
        long j6 = bVar.SU;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_status", j6);
        }
        long j7 = bVar.SV;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_duration_ms", j7);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "thread_core_size", bVar.SW);
        String str2 = bVar.SX;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_source", bVar.SX);
        }
        return jSONObject;
    }
}
