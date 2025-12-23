package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bm implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        bVar.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.avN = jSONObject.optString("url_host");
        if (obj.toString().equals(bVar.avN)) {
            bVar.avN = "";
        }
        bVar.avU = jSONObject.optString("url_path");
        if (obj.toString().equals(bVar.avU)) {
            bVar.avU = "";
        }
        bVar.avV = jSONObject.optString("market_pkg_name");
        if (obj.toString().equals(bVar.avV)) {
            bVar.avV = "";
        }
        bVar.avW = jSONObject.optInt("store_type");
        bVar.avX = jSONObject.optInt("launch_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = bVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.avN;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_host", bVar.avN);
        }
        String str3 = bVar.avU;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_path", bVar.avU);
        }
        String str4 = bVar.avV;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "market_pkg_name", bVar.avV);
        }
        int i7 = bVar.avW;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "store_type", i7);
        }
        int i8 = bVar.avX;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "launch_type", i8);
        }
        return jSONObject;
    }
}
