package com.kwad.sdk.core.b.a;

import com.google.common.net.HttpHeaders;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fn implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aNt = jSONObject.optString("Access-Control-Allow-Origin");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aNt)) {
            aVar.aNt = "";
        }
        aVar.aNu = jSONObject.optString(HttpHeaders.TIMING_ALLOW_ORIGIN);
        if (obj.toString().equals(aVar.aNu)) {
            aVar.aNu = "";
        }
        aVar.aNv = jSONObject.optString("content-type");
        if (obj.toString().equals(aVar.aNv)) {
            aVar.aNv = "";
        }
        aVar.aNw = jSONObject.optString("Date");
        if (obj.toString().equals(aVar.aNw)) {
            aVar.aNw = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aNt;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Access-Control-Allow-Origin", aVar.aNt);
        }
        String str2 = aVar.aNu;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, HttpHeaders.TIMING_ALLOW_ORIGIN, aVar.aNu);
        }
        String str3 = aVar.aNv;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "content-type", aVar.aNv);
        }
        String str4 = aVar.aNw;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Date", aVar.aNw);
        }
        return jSONObject;
    }
}
