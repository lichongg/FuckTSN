package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.an;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class de implements com.kwad.sdk.core.d<an.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(an.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(an.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(an.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adL = jSONObject.optBoolean("clickActionButton");
        aVar.adM = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.adM)) {
            aVar.adM = "";
        }
        aVar.adN = jSONObject.optInt("area");
        com.kwad.sdk.core.webview.d.b.d dVar = new com.kwad.sdk.core.webview.d.b.d();
        aVar.adO = dVar;
        dVar.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(an.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = aVar.adL;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickActionButton", z5);
        }
        String str = aVar.adM;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adTemplate", aVar.adM);
        }
        int i6 = aVar.adN;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "area", i6);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "logParam", aVar.adO);
        return jSONObject;
    }
}
