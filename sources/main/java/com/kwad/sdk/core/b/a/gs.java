package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gs implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bcQ = jSONObject.optInt("put_count");
        aVar.bcR = jSONObject.optInt("get_failed_count");
        aVar.bcS = jSONObject.optInt("get_success_count");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.bcQ;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "put_count", i6);
        }
        int i7 = aVar.bcR;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "get_failed_count", i7);
        }
        int i8 = aVar.bcS;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "get_success_count", i8);
        }
        return jSONObject;
    }
}
