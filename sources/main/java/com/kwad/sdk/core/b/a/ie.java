package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ie implements com.kwad.sdk.core.d<com.kwad.sdk.h.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aRp = jSONObject.optString("packageId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aRp)) {
            bVar.aRp = "";
        }
        bVar.aRq = jSONObject.optString("zipFileName");
        if (obj.toString().equals(bVar.aRq)) {
            bVar.aRq = "";
        }
        bVar.aRr = jSONObject.optString("zipPath");
        if (obj.toString().equals(bVar.aRr)) {
            bVar.aRr = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (obj.toString().equals(bVar.packageUrl)) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (obj.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.ard = jSONObject.optString("checksum");
        if (obj.toString().equals(bVar.ard)) {
            bVar.ard = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.aRt = jSONObject.optBoolean("public");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aRp;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageId", bVar.aRp);
        }
        String str2 = bVar.aRq;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "zipFileName", bVar.aRq);
        }
        String str3 = bVar.aRr;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "zipPath", bVar.aRr);
        }
        String str4 = bVar.packageUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.ard;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "checksum", bVar.ard);
        }
        int i6 = bVar.loadType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "loadType", i6);
        }
        int i7 = bVar.packageType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageType", i7);
        }
        boolean z5 = bVar.aRt;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "public", z5);
        }
        return jSONObject;
    }
}
