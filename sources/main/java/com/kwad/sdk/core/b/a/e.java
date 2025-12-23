package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adL = jSONObject.optBoolean("clickActionButton");
        aVar.adN = jSONObject.optInt("area");
        aVar.mI = jSONObject.optInt("itemClickType");
        aVar.aNO = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        com.kwad.sdk.core.webview.d.b.d dVar = new com.kwad.sdk.core.webview.d.b.d();
        aVar.adO = dVar;
        dVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.Ph = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.Pv = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(aVar.Pv)) {
            aVar.Pv = "";
        }
        aVar.aNP = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
        aVar.aNQ = jSONObject.optBoolean("isCallbackOnly");
        aVar.aNR = jSONObject.optBoolean("disableCallback");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = aVar.adL;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickActionButton", z5);
        }
        int i6 = aVar.adN;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "area", i6);
        }
        int i7 = aVar.mI;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", i7);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "convertPageType", aVar.aNO);
        com.kwad.sdk.utils.aa.a(jSONObject, "logParam", aVar.adO);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "needReport", aVar.Ph);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", aVar.creativeId);
        String str = aVar.Pv;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveItemId", aVar.Pv);
        }
        int i8 = aVar.aNP;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sceneType", i8);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", aVar.adStyle);
        boolean z6 = aVar.aNQ;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isCallbackOnly", z6);
        }
        boolean z7 = aVar.aNR;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableCallback", z7);
        }
        return jSONObject;
    }
}
