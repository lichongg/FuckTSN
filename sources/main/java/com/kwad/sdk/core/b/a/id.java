package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class id implements com.kwad.sdk.core.d<com.kwad.sdk.h.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.h.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.h.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.h.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.sceneId = jSONObject.optString("sceneId");
        if (JSONObject.NULL.toString().equals(aVar.sceneId)) {
            aVar.sceneId = "";
        }
        aVar.aRo = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("packages");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                com.kwad.sdk.h.a.b bVar = new com.kwad.sdk.h.a.b();
                bVar.parseJson(optJSONArray.optJSONObject(i6));
                aVar.aRo.add(bVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.h.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.sceneId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sceneId", aVar.sceneId);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "packages", aVar.aRo);
        return jSONObject;
    }
}
