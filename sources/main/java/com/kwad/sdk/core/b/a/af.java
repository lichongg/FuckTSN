package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class af implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        bVar.awx = jSONObject.optInt("ad_action_type");
        bVar.retryCount = jSONObject.optInt("retry_count");
        bVar.axt = jSONObject.optInt("retry_error_code");
        bVar.axu = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(bVar.axu)) {
            bVar.axu = "";
        }
        bVar.axE = jSONObject.optInt("cache_total_num");
        bVar.axF = jSONObject.optInt("cache_num");
        bVar.axG = jSONObject.optLong("cacheTimeMs");
        bVar.axD = jSONObject.optBoolean("retry_only");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = bVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        int i7 = bVar.awx;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_action_type", i7);
        }
        int i8 = bVar.retryCount;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_count", i8);
        }
        int i9 = bVar.axt;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_error_code", i9);
        }
        String str = bVar.axu;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_error_msg", bVar.axu);
        }
        int i10 = bVar.axE;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_total_num", i10);
        }
        int i11 = bVar.axF;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_num", i11);
        }
        long j6 = bVar.axG;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheTimeMs", j6);
        }
        boolean z5 = bVar.axD;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_only", z5);
        }
        return jSONObject;
    }
}
