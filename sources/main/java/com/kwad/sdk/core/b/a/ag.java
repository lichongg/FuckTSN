package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ag implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        dVar.awq = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(dVar.awq)) {
            dVar.awq = "";
        }
        dVar.awx = jSONObject.optInt("ad_action_type");
        dVar.axH = jSONObject.optInt("cache_type", new Integer("0").intValue());
        dVar.retryCount = jSONObject.optInt("retry_count", new Integer("0").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = dVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        String str = dVar.awq;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", dVar.awq);
        }
        int i7 = dVar.awx;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_action_type", i7);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_type", dVar.axH);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_count", dVar.retryCount);
        return jSONObject;
    }
}
