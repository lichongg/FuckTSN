package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lc implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.f> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        a2(fVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        return b2(fVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.adStyle = jSONObject.optInt("adStyle");
        fVar.taskType = jSONObject.optInt("taskType");
        fVar.count = jSONObject.optInt("count");
        fVar.aIK = jSONObject.optLong("lastModifiedTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = fVar.adStyle;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", i6);
        }
        int i7 = fVar.taskType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "taskType", i7);
        }
        int i8 = fVar.count;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "count", i8);
        }
        long j6 = fVar.aIK;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastModifiedTime", j6);
        }
        return jSONObject;
    }
}
