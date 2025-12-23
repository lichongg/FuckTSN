package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class dw implements com.kwad.sdk.core.d<com.kwad.components.ad.draw.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.draw.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.draw.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.draw.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        aVar.methodName = jSONObject.optString("method_name");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.methodName)) {
            aVar.methodName = "";
        }
        aVar.materialType = jSONObject.optInt("material_type");
        aVar.materialUrl = jSONObject.optString("material_url");
        if (obj.toString().equals(aVar.materialUrl)) {
            aVar.materialUrl = "";
        }
        aVar.adNum = jSONObject.optInt("ad_num");
        aVar.loadTime = jSONObject.optLong("load_ad_duration_ms");
        aVar.renderTime = jSONObject.optLong("render_duration_ms");
        aVar.dw = jSONObject.optLong("request_ad_duration_ms");
        aVar.renderType = jSONObject.optInt("render_type");
        aVar.dx = jSONObject.optInt("expect_render_type");
        aVar.adStyle = jSONObject.optInt("ad_style");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.draw.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        String str = aVar.methodName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "method_name", aVar.methodName);
        }
        int i7 = aVar.materialType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", i7);
        }
        String str2 = aVar.materialUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_url", aVar.materialUrl);
        }
        int i8 = aVar.adNum;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_num", i8);
        }
        long j6 = aVar.loadTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_ad_duration_ms", j6);
        }
        long j7 = aVar.renderTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_duration_ms", j7);
        }
        long j8 = aVar.dw;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_ad_duration_ms", j8);
        }
        int i9 = aVar.renderType;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_type", i9);
        }
        int i10 = aVar.dx;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "expect_render_type", i10);
        }
        int i11 = aVar.adStyle;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_style", i11);
        }
        return jSONObject;
    }
}
