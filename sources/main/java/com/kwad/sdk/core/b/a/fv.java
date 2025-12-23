package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.config.item.j;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fv implements com.kwad.sdk.core.d<j.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(j.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(j.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aCm = jSONObject.optInt("horizontalShowDuration", new Integer("180000").intValue());
        aVar.aCn = jSONObject.optInt("verticalShowDuration", new Integer("90000").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "horizontalShowDuration", aVar.aCm);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "verticalShowDuration", aVar.aCn);
        return jSONObject;
    }
}
