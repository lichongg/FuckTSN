package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.config.item.h;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fs implements com.kwad.sdk.core.d<h.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aCk = jSONObject.optString("imei");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aCk)) {
            aVar.aCk = "";
        }
        aVar.aCl = jSONObject.optString("oaid");
        if (obj.toString().equals(aVar.aCl)) {
            aVar.aCl = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aCk;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei", aVar.aCk);
        }
        String str2 = aVar.aCl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", aVar.aCl);
        }
        return jSONObject;
    }
}
