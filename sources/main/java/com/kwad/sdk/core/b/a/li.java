package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class li implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aJK = jSONObject.optInt("rate_reciprocal");
        dVar.aJQ = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong(com.umeng.analytics.pro.bi.aX);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = dVar.aJK;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rate_reciprocal", i6);
        }
        int i7 = dVar.aJQ;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "threshold", i7);
        }
        long j6 = dVar.interval;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.bi.aX, j6);
        }
        return jSONObject;
    }
}
