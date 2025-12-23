package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ls implements com.kwad.sdk.core.d<aj.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(aj.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(aj.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.pkgName = jSONObject.optString("pkgName");
        if (obj.toString().equals(aVar.pkgName)) {
            aVar.pkgName = "";
        }
        aVar.version = jSONObject.optString("version");
        if (obj.toString().equals(aVar.version)) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt("versionCode");
        aVar.adr = jSONObject.optInt("appSize");
        aVar.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        if (obj.toString().equals(aVar.md5)) {
            aVar.md5 = "";
        }
        aVar.url = jSONObject.optString("url");
        if (obj.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.ads = jSONObject.optString("appLink");
        if (obj.toString().equals(aVar.ads)) {
            aVar.ads = "";
        }
        aVar.icon = jSONObject.optString("icon");
        if (obj.toString().equals(aVar.icon)) {
            aVar.icon = "";
        }
        aVar.sX = jSONObject.optString("desc");
        if (obj.toString().equals(aVar.sX)) {
            aVar.sX = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (obj.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.adt = jSONObject.optString("marketUri");
        if (obj.toString().equals(aVar.adt)) {
            aVar.adt = "";
        }
        aVar.adu = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.adv = jSONObject.optBoolean("isLandscapeSupported");
        aVar.adw = jSONObject.optBoolean("isFromLive");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.type;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i6);
        }
        String str = aVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", aVar.appName);
        }
        String str2 = aVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pkgName", aVar.pkgName);
        }
        String str3 = aVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", aVar.version);
        }
        int i7 = aVar.versionCode;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "versionCode", i7);
        }
        int i8 = aVar.adr;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appSize", i8);
        }
        String str4 = aVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, TKDownloadReason.KSAD_TK_MD5, aVar.md5);
        }
        String str5 = aVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", aVar.url);
        }
        String str6 = aVar.ads;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appLink", aVar.ads);
        }
        String str7 = aVar.icon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "icon", aVar.icon);
        }
        String str8 = aVar.sX;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "desc", aVar.sX);
        }
        String str9 = aVar.appId;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", aVar.appId);
        }
        String str10 = aVar.adt;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "marketUri", aVar.adt);
        }
        boolean z5 = aVar.adu;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableLandingPageDeepLink", z5);
        }
        boolean z6 = aVar.adv;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isLandscapeSupported", z6);
        }
        boolean z7 = aVar.adw;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isFromLive", z7);
        }
        return jSONObject;
    }
}
