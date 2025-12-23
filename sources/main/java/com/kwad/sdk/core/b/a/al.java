package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class al implements com.kwad.sdk.core.d<a.C0637a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0637a c0637a, JSONObject jSONObject) {
        a2(c0637a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0637a c0637a, JSONObject jSONObject) {
        return b2(c0637a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0637a c0637a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0637a.NN = jSONObject.optString("creativeId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0637a.NN)) {
            c0637a.NN = "";
        }
        c0637a.acf = jSONObject.optString("targetMethod");
        if (obj.toString().equals(c0637a.acf)) {
            c0637a.acf = "";
        }
        c0637a.acg = jSONObject.optString("methodParams");
        if (obj.toString().equals(c0637a.acg)) {
            c0637a.acg = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0637a c0637a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0637a.NN;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", c0637a.NN);
        }
        String str2 = c0637a.acf;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "targetMethod", c0637a.acf);
        }
        String str3 = c0637a.acg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "methodParams", c0637a.acg);
        }
        return jSONObject;
    }
}
