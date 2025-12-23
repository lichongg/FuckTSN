package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ks implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.b.a.e eVar, JSONObject jSONObject) {
        a2(eVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.b.a.e eVar, JSONObject jSONObject) {
        return b2(eVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.b.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.aXP = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("ranger");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                com.kwad.sdk.n.b.a.d dVar = new com.kwad.sdk.n.b.a.d();
                dVar.parseJson(optJSONArray.optJSONObject(i6));
                eVar.aXP.add(dVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.b.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "ranger", eVar.aXP);
        return jSONObject;
    }
}
