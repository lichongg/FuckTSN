package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lh implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aJz = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(bVar.aJz)) {
            bVar.aJz = "";
        }
        bVar.aJA = jSONObject.optInt("core_pool_size");
        bVar.aJB = jSONObject.optInt("max_pool_size");
        bVar.aJC = jSONObject.optInt("current_pool_size");
        bVar.aJD = jSONObject.optInt("active_count");
        bVar.aJE = jSONObject.optLong("task_wait_avg_ms");
        bVar.aJF = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.aJG = jSONObject.optInt("queue_size");
        bVar.aJH = jSONObject.optLong("pass_timestamp");
        bVar.aJI = jSONObject.optInt("func_ratio_count");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aJz;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pool_name", bVar.aJz);
        }
        int i6 = bVar.aJA;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "core_pool_size", i6);
        }
        int i7 = bVar.aJB;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "max_pool_size", i7);
        }
        int i8 = bVar.aJC;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "current_pool_size", i8);
        }
        int i9 = bVar.aJD;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "active_count", i9);
        }
        long j6 = bVar.aJE;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "task_wait_avg_ms", j6);
        }
        long j7 = bVar.aJF;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "task_succ_count", j7);
        }
        long j8 = bVar.interval;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interval_ms", j8);
        }
        int i10 = bVar.aJG;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "queue_size", i10);
        }
        long j9 = bVar.aJH;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pass_timestamp", j9);
        }
        int i11 = bVar.aJI;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "func_ratio_count", i11);
        }
        return jSONObject;
    }
}
