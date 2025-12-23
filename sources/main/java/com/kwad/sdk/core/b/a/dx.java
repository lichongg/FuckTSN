package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class dx implements com.kwad.sdk.core.d<com.kwad.components.ad.draw.a.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.draw.a.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.draw.a.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.draw.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        dVar.materialType = jSONObject.optInt("material_type");
        dVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(dVar.materialUrl)) {
            dVar.materialUrl = "";
        }
        dVar.dy = jSONObject.optLong("resource_load_time_ms");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.draw.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = dVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        int i7 = dVar.materialType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", i7);
        }
        String str = dVar.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_url", dVar.materialUrl);
        }
        long j6 = dVar.dy;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "resource_load_time_ms", j6);
        }
        return jSONObject;
    }
}
