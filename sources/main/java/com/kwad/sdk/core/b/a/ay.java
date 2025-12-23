package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ay implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        bVar.awx = jSONObject.optInt("ad_action_type");
        bVar.awp = jSONObject.optString("origin_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.awp)) {
            bVar.awp = "";
        }
        bVar.awq = jSONObject.optString("final_url");
        if (obj.toString().equals(bVar.awq)) {
            bVar.awq = "";
        }
        bVar.requestType = jSONObject.optInt("request_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
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
        String str = bVar.awp;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "origin_url", bVar.awp);
        }
        String str2 = bVar.awq;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", bVar.awq);
        }
        int i8 = bVar.requestType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_type", i8);
        }
        return jSONObject;
    }
}
