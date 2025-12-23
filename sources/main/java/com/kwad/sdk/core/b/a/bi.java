package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bi implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
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
        bVar.downloadId = jSONObject.optString("download_id");
        if (obj.toString().equals(bVar.downloadId)) {
            bVar.downloadId = "";
        }
        bVar.avO = jSONObject.optString("apk_package");
        if (obj.toString().equals(bVar.avO)) {
            bVar.avO = "";
        }
        bVar.avP = jSONObject.optString("apk_name");
        if (obj.toString().equals(bVar.avP)) {
            bVar.avP = "";
        }
        bVar.avQ = jSONObject.optLong("apk_size");
        bVar.downloadTime = jSONObject.optLong("download_time");
        bVar.avR = jSONObject.optLong("apk_cur_size");
        bVar.avS = jSONObject.optInt("apk_install_type");
        bVar.avT = jSONObject.optInt("apk_install_source");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
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
        String str3 = bVar.downloadId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_id", bVar.downloadId);
        }
        String str4 = bVar.avO;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_package", bVar.avO);
        }
        String str5 = bVar.avP;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_name", bVar.avP);
        }
        long j6 = bVar.avQ;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_size", j6);
        }
        long j7 = bVar.downloadTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_time", j7);
        }
        long j8 = bVar.avR;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_cur_size", j8);
        }
        int i7 = bVar.avS;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_install_type", i7);
        }
        int i8 = bVar.avT;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_install_source", i8);
        }
        return jSONObject;
    }
}
