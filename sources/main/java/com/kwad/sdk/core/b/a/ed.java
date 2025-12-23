package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ed implements com.kwad.sdk.core.d<com.kwad.sdk.crash.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aPm = jSONObject.optInt("funcSwitch");
        bVar.aPn = jSONObject.optString("minSdkVersion");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aPn)) {
            bVar.aPn = "";
        }
        bVar.aPo = jSONObject.optString("maxSdkVersionExclude");
        if (obj.toString().equals(bVar.aPo)) {
            bVar.aPo = "";
        }
        bVar.sdkType = jSONObject.optInt("sdkType");
        bVar.aPp = jSONObject.optString("md5V7");
        if (obj.toString().equals(bVar.aPp)) {
            bVar.aPp = "";
        }
        bVar.aPq = jSONObject.optString("md5V8");
        if (obj.toString().equals(bVar.aPq)) {
            bVar.aPq = "";
        }
        bVar.version = jSONObject.optString("version");
        if (obj.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.aPr = jSONObject.optString("v7Url");
        if (obj.toString().equals(bVar.aPr)) {
            bVar.aPr = "";
        }
        bVar.aPs = jSONObject.optString("v8Url");
        if (obj.toString().equals(bVar.aPs)) {
            bVar.aPs = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = bVar.aPm;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "funcSwitch", i6);
        }
        String str = bVar.aPn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "minSdkVersion", bVar.aPn);
        }
        String str2 = bVar.aPo;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxSdkVersionExclude", bVar.aPo);
        }
        int i7 = bVar.sdkType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", i7);
        }
        String str3 = bVar.aPp;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "md5V7", bVar.aPp);
        }
        String str4 = bVar.aPq;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "md5V8", bVar.aPq);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.aPr;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "v7Url", bVar.aPr);
        }
        String str7 = bVar.aPs;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "v8Url", bVar.aPs);
        }
        return jSONObject;
    }
}
