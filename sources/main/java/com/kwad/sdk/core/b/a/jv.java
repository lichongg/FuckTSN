package com.kwad.sdk.core.b.a;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jv implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.t> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.t tVar, JSONObject jSONObject) {
        a2(tVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.t tVar, JSONObject jSONObject) {
        return b2(tVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tVar.message = jSONObject.optString(CrashHianalyticsData.MESSAGE);
        if (JSONObject.NULL.toString().equals(tVar.message)) {
            tVar.message = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = tVar.message;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, CrashHianalyticsData.MESSAGE, tVar.message);
        }
        return jSONObject;
    }
}
