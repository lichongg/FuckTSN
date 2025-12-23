package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class be implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aXH = jSONObject.optInt("aggregation_sdk_type");
        aVar.aXI = jSONObject.optString("aggregation_version");
        if (JSONObject.NULL.toString().equals(aVar.aXI)) {
            aVar.aXI = "";
        }
        aVar.aXJ = jSONObject.optInt("crash_times");
        aVar.aXK = jSONObject.optInt("call_ks_union_times");
        aVar.aXL = jSONObject.optLong("ks_launch_delay");
        aVar.aXM = jSONObject.optLong("aggregation_launch_delay");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.aXH;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_sdk_type", i6);
        }
        String str = aVar.aXI;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_version", aVar.aXI);
        }
        int i7 = aVar.aXJ;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "crash_times", i7);
        }
        int i8 = aVar.aXK;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "call_ks_union_times", i8);
        }
        long j6 = aVar.aXL;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ks_launch_delay", j6);
        }
        long j7 = aVar.aXM;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_launch_delay", j7);
        }
        return jSONObject;
    }
}
