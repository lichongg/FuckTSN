package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class eh implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString("appId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.appId)) {
            bVar.appId = "";
        }
        bVar.aQf = jSONObject.optString("pluginListenerName");
        if (obj.toString().equals(bVar.aQf)) {
            bVar.aQf = "";
        }
        bVar.aQg = jSONObject.optString("reportMethodName");
        if (obj.toString().equals(bVar.aQg)) {
            bVar.aQg = "";
        }
        bVar.aQh = jSONObject.optString("otherProxyClassName");
        if (obj.toString().equals(bVar.aQh)) {
            bVar.aQh = "";
        }
        bVar.aQi = jSONObject.optString("otherFieldName");
        if (obj.toString().equals(bVar.aQi)) {
            bVar.aQi = "";
        }
        bVar.aQj = jSONObject.optString("otherLevelFieldName");
        if (obj.toString().equals(bVar.aQj)) {
            bVar.aQj = "";
        }
        bVar.aQk = jSONObject.optString("blockTag");
        if (obj.toString().equals(bVar.aQk)) {
            bVar.aQk = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", bVar.appId);
        }
        String str2 = bVar.aQf;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pluginListenerName", bVar.aQf);
        }
        String str3 = bVar.aQg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reportMethodName", bVar.aQg);
        }
        String str4 = bVar.aQh;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherProxyClassName", bVar.aQh);
        }
        String str5 = bVar.aQi;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherFieldName", bVar.aQi);
        }
        String str6 = bVar.aQj;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherLevelFieldName", bVar.aQj);
        }
        String str7 = bVar.aQk;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockTag", bVar.aQk);
        }
        return jSONObject;
    }
}
