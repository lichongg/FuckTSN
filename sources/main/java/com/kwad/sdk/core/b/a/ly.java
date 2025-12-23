package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ly implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.y> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        a2(yVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        return b2(yVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.ahn = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(yVar.ahn)) {
            yVar.ahn = "";
        }
        yVar.errorCode = jSONObject.optInt("errorCode");
        yVar.errorReason = jSONObject.optString("errorReason");
        if (obj.toString().equals(yVar.errorReason)) {
            yVar.errorReason = "";
        }
        yVar.qz = jSONObject.optInt("currentTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = yVar.ahn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, yVar.ahn);
        }
        int i6 = yVar.errorCode;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorCode", i6);
        }
        String str2 = yVar.errorReason;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorReason", yVar.errorReason);
        }
        int i7 = yVar.qz;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentTime", i7);
        }
        return jSONObject;
    }
}
