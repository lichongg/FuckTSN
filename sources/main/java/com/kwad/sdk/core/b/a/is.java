package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ah;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class is implements com.kwad.sdk.core.d<ah.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ah.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ah.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.SDKVersion = jSONObject.optString("SDKVersion");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.SDKVersion)) {
            aVar.SDKVersion = "";
        }
        aVar.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        aVar.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(aVar.sdkApiVersion)) {
            aVar.sdkApiVersion = "";
        }
        aVar.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        aVar.sdkType = jSONObject.optInt("sdkType");
        aVar.appVersion = jSONObject.optString("appVersion");
        if (obj.toString().equals(aVar.appVersion)) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString("appName");
        if (obj.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (obj.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.adg = jSONObject.optString("networkType");
        if (obj.toString().equals(aVar.adg)) {
            aVar.adg = "";
        }
        aVar.adh = jSONObject.optString("manufacturer");
        if (obj.toString().equals(aVar.adh)) {
            aVar.adh = "";
        }
        aVar.model = jSONObject.optString(com.baidu.mobads.sdk.internal.bn.f10753i);
        if (obj.toString().equals(aVar.model)) {
            aVar.model = "";
        }
        aVar.LN = jSONObject.optString("deviceBrand");
        if (obj.toString().equals(aVar.LN)) {
            aVar.LN = "";
        }
        aVar.adi = jSONObject.optInt("osType");
        aVar.adj = jSONObject.optString("systemVersion");
        if (obj.toString().equals(aVar.adj)) {
            aVar.adj = "";
        }
        aVar.adk = jSONObject.optInt("osApi");
        aVar.adl = jSONObject.optString("language");
        if (obj.toString().equals(aVar.adl)) {
            aVar.adl = "";
        }
        aVar.adm = jSONObject.optString("locale");
        if (obj.toString().equals(aVar.adm)) {
            aVar.adm = "";
        }
        aVar.Qw = jSONObject.optInt("screenWidth");
        aVar.Qv = jSONObject.optInt("screenHeight");
        aVar.adn = jSONObject.optInt("statusBarHeight");
        aVar.ado = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.SDKVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersion", aVar.SDKVersion);
        }
        int i6 = aVar.SDKVersionCode;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersionCode", i6);
        }
        String str2 = aVar.sdkApiVersion;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", aVar.sdkApiVersion);
        }
        int i7 = aVar.sdkApiVersionCode;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersionCode", i7);
        }
        int i8 = aVar.sdkType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", i8);
        }
        String str3 = aVar.appVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        String str4 = aVar.appName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", aVar.appName);
        }
        String str5 = aVar.appId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", aVar.appId);
        }
        String str6 = aVar.adg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "networkType", aVar.adg);
        }
        String str7 = aVar.adh;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manufacturer", aVar.adh);
        }
        String str8 = aVar.model;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.sdk.internal.bn.f10753i, aVar.model);
        }
        String str9 = aVar.LN;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", aVar.LN);
        }
        int i9 = aVar.adi;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", i9);
        }
        String str10 = aVar.adj;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemVersion", aVar.adj);
        }
        int i10 = aVar.adk;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", i10);
        }
        String str11 = aVar.adl;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", aVar.adl);
        }
        String str12 = aVar.adm;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "locale", aVar.adm);
        }
        int i11 = aVar.Qw;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", i11);
        }
        int i12 = aVar.Qv;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", i12);
        }
        int i13 = aVar.adn;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "statusBarHeight", i13);
        }
        int i14 = aVar.ado;
        if (i14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarHeight", i14);
        }
        return jSONObject;
    }
}
