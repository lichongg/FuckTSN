package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bd implements com.kwad.sdk.core.d<com.kwad.sdk.n.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aXl = jSONObject.optInt("aggregationType");
        aVar.aXm = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sdkCheckList");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                aVar.aXm.add((String) optJSONArray.opt(i6));
            }
        }
        com.kwad.sdk.n.a.b bVar = new com.kwad.sdk.n.a.b();
        aVar.aXn = bVar;
        bVar.parseJson(jSONObject.optJSONObject("anchorNode"));
        aVar.aXo = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("stackCheckList");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                aVar.aXo.add((String) optJSONArray2.opt(i7));
            }
        }
        aVar.aXp = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("callStackList");
        if (optJSONArray3 != null) {
            for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                aVar.aXp.add((String) optJSONArray3.opt(i8));
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.aXl;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregationType", i6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkCheckList", aVar.aXm);
        com.kwad.sdk.utils.aa.a(jSONObject, "anchorNode", aVar.aXn);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "stackCheckList", aVar.aXo);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "callStackList", aVar.aXp);
        return jSONObject;
    }
}
