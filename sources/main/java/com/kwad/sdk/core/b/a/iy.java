package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class iy implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.b.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.b.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.b.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aJI = jSONObject.optInt("func_ratio_count");
        cVar.aXN = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("func_values");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                com.kwad.sdk.n.b.a.b bVar = new com.kwad.sdk.n.b.a.b();
                bVar.parseJson(optJSONArray.optJSONObject(i6));
                cVar.aXN.add(bVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.b.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = cVar.aJI;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "func_ratio_count", i6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "func_values", cVar.aXN);
        return jSONObject;
    }
}
