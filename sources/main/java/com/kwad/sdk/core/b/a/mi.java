package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class mi implements com.kwad.sdk.core.d<WebViewCommercialMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        a2(webViewCommercialMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        return b2(webViewCommercialMsg, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewCommercialMsg.category = jSONObject.optString("category");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(webViewCommercialMsg.category)) {
            webViewCommercialMsg.category = "";
        }
        webViewCommercialMsg.tag = jSONObject.optString(CommonNetImpl.TAG);
        if (obj.toString().equals(webViewCommercialMsg.tag)) {
            webViewCommercialMsg.tag = "";
        }
        webViewCommercialMsg.primaryKey = jSONObject.optString("primaryKey");
        if (obj.toString().equals(webViewCommercialMsg.primaryKey)) {
            webViewCommercialMsg.primaryKey = "";
        }
        webViewCommercialMsg.msg = jSONObject.optJSONObject("msg");
        webViewCommercialMsg.extraParam = jSONObject.optJSONObject("extraParam");
        webViewCommercialMsg.eventId = jSONObject.optString("event_id");
        if (obj.toString().equals(webViewCommercialMsg.eventId)) {
            webViewCommercialMsg.eventId = "";
        }
        webViewCommercialMsg.rate = jSONObject.optDouble("rate");
        webViewCommercialMsg.suffixRatio = jSONObject.optString("suffixRatio");
        if (obj.toString().equals(webViewCommercialMsg.suffixRatio)) {
            webViewCommercialMsg.suffixRatio = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = webViewCommercialMsg.category;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "category", webViewCommercialMsg.category);
        }
        String str2 = webViewCommercialMsg.tag;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, CommonNetImpl.TAG, webViewCommercialMsg.tag);
        }
        String str3 = webViewCommercialMsg.primaryKey;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "primaryKey", webViewCommercialMsg.primaryKey);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "msg", webViewCommercialMsg.msg);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "extraParam", webViewCommercialMsg.extraParam);
        String str4 = webViewCommercialMsg.eventId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "event_id", webViewCommercialMsg.eventId);
        }
        double d6 = webViewCommercialMsg.rate;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rate", d6);
        }
        String str5 = webViewCommercialMsg.suffixRatio;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "suffixRatio", webViewCommercialMsg.suffixRatio);
        }
        return jSONObject;
    }
}
