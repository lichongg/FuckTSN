package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.au;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bk implements com.kwad.sdk.core.d<au.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(au.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(au.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(au.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appName = jSONObject.optString("appName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.appName)) {
            bVar.appName = "";
        }
        bVar.pkgName = jSONObject.optString("pkgName");
        if (obj.toString().equals(bVar.pkgName)) {
            bVar.pkgName = "";
        }
        bVar.version = jSONObject.optString("version");
        if (obj.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.versionCode = jSONObject.optInt("versionCode");
        bVar.aeb = jSONObject.optLong("appSize");
        bVar.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        if (obj.toString().equals(bVar.md5)) {
            bVar.md5 = "";
        }
        bVar.url = jSONObject.optString("url");
        if (obj.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.icon = jSONObject.optString("icon");
        if (obj.toString().equals(bVar.icon)) {
            bVar.icon = "";
        }
        bVar.sX = jSONObject.optString("desc");
        if (obj.toString().equals(bVar.sX)) {
            bVar.sX = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(au.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", bVar.appName);
        }
        String str2 = bVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pkgName", bVar.pkgName);
        }
        String str3 = bVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", bVar.version);
        }
        int i6 = bVar.versionCode;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "versionCode", i6);
        }
        long j6 = bVar.aeb;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appSize", j6);
        }
        String str4 = bVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, TKDownloadReason.KSAD_TK_MD5, bVar.md5);
        }
        String str5 = bVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", bVar.url);
        }
        String str6 = bVar.icon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "icon", bVar.icon);
        }
        String str7 = bVar.sX;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "desc", bVar.sX);
        }
        return jSONObject;
    }
}
