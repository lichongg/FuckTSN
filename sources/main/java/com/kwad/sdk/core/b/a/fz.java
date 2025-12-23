package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fz implements com.kwad.sdk.core.d<com.kwad.sdk.a.a.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.a.a.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.a.a.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.a.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.jC = jSONObject.optLong("lastShowTimestamp");
        aVar.agV = jSONObject.optInt("showCount");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.a.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = aVar.jC;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastShowTimestamp", j6);
        }
        int i6 = aVar.agV;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showCount", i6);
        }
        return jSONObject;
    }
}
