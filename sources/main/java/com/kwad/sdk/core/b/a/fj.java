package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.webview.d.a;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fj implements com.kwad.sdk.core.d<a.C0694a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0694a c0694a, JSONObject jSONObject) {
        a2(c0694a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0694a c0694a, JSONObject jSONObject) {
        return b2(c0694a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0694a c0694a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0694a.SDKVersion = jSONObject.optString("SDKVersion");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0694a.SDKVersion)) {
            c0694a.SDKVersion = "";
        }
        c0694a.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        c0694a.aHz = jSONObject.optString("tkVersion");
        if (obj.toString().equals(c0694a.aHz)) {
            c0694a.aHz = "";
        }
        c0694a.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(c0694a.sdkApiVersion)) {
            c0694a.sdkApiVersion = "";
        }
        c0694a.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        c0694a.sdkType = jSONObject.optInt("sdkType");
        c0694a.appVersion = jSONObject.optString("appVersion");
        if (obj.toString().equals(c0694a.appVersion)) {
            c0694a.appVersion = "";
        }
        c0694a.appName = jSONObject.optString("appName");
        if (obj.toString().equals(c0694a.appName)) {
            c0694a.appName = "";
        }
        c0694a.appId = jSONObject.optString("appId");
        if (obj.toString().equals(c0694a.appId)) {
            c0694a.appId = "";
        }
        c0694a.aNI = jSONObject.optString("globalId");
        if (obj.toString().equals(c0694a.aNI)) {
            c0694a.aNI = "";
        }
        c0694a.aIo = jSONObject.optString("eGid");
        if (obj.toString().equals(c0694a.aIo)) {
            c0694a.aIo = "";
        }
        c0694a.aIn = jSONObject.optString("deviceSig");
        if (obj.toString().equals(c0694a.aIn)) {
            c0694a.aIn = "";
        }
        c0694a.adg = jSONObject.optString("networkType");
        if (obj.toString().equals(c0694a.adg)) {
            c0694a.adg = "";
        }
        c0694a.adh = jSONObject.optString("manufacturer");
        if (obj.toString().equals(c0694a.adh)) {
            c0694a.adh = "";
        }
        c0694a.model = jSONObject.optString(com.baidu.mobads.sdk.internal.bn.f10753i);
        if (obj.toString().equals(c0694a.model)) {
            c0694a.model = "";
        }
        c0694a.LN = jSONObject.optString("deviceBrand");
        if (obj.toString().equals(c0694a.LN)) {
            c0694a.LN = "";
        }
        c0694a.adi = jSONObject.optInt("osType");
        c0694a.adj = jSONObject.optString("systemVersion");
        if (obj.toString().equals(c0694a.adj)) {
            c0694a.adj = "";
        }
        c0694a.adk = jSONObject.optInt("osApi");
        c0694a.adl = jSONObject.optString("language");
        if (obj.toString().equals(c0694a.adl)) {
            c0694a.adl = "";
        }
        c0694a.adm = jSONObject.optString("locale");
        if (obj.toString().equals(c0694a.adm)) {
            c0694a.adm = "";
        }
        c0694a.aNJ = jSONObject.optString("uuid");
        if (obj.toString().equals(c0694a.aNJ)) {
            c0694a.aNJ = "";
        }
        c0694a.aNK = jSONObject.optBoolean("isDynamic");
        c0694a.Qw = jSONObject.optInt("screenWidth");
        c0694a.Qv = jSONObject.optInt("screenHeight");
        c0694a.aCk = jSONObject.optString("imei");
        if (obj.toString().equals(c0694a.aCk)) {
            c0694a.aCk = "";
        }
        c0694a.aCl = jSONObject.optString("oaid");
        if (obj.toString().equals(c0694a.aCl)) {
            c0694a.aCl = "";
        }
        c0694a.aIk = jSONObject.optString("androidId");
        if (obj.toString().equals(c0694a.aIk)) {
            c0694a.aIk = "";
        }
        c0694a.aIB = jSONObject.optString(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
        if (obj.toString().equals(c0694a.aIB)) {
            c0694a.aIB = "";
        }
        c0694a.adn = jSONObject.optInt("statusBarHeight");
        c0694a.ado = jSONObject.optInt("titleBarHeight");
        c0694a.aNL = jSONObject.optString("bridgeVersion");
        if (obj.toString().equals(c0694a.aNL)) {
            c0694a.aNL = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0694a c0694a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0694a.SDKVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersion", c0694a.SDKVersion);
        }
        int i6 = c0694a.SDKVersionCode;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersionCode", i6);
        }
        String str2 = c0694a.aHz;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tkVersion", c0694a.aHz);
        }
        String str3 = c0694a.sdkApiVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", c0694a.sdkApiVersion);
        }
        int i7 = c0694a.sdkApiVersionCode;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersionCode", i7);
        }
        int i8 = c0694a.sdkType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", i8);
        }
        String str4 = c0694a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", c0694a.appVersion);
        }
        String str5 = c0694a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", c0694a.appName);
        }
        String str6 = c0694a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", c0694a.appId);
        }
        String str7 = c0694a.aNI;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "globalId", c0694a.aNI);
        }
        String str8 = c0694a.aIo;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "eGid", c0694a.aIo);
        }
        String str9 = c0694a.aIn;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceSig", c0694a.aIn);
        }
        String str10 = c0694a.adg;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "networkType", c0694a.adg);
        }
        String str11 = c0694a.adh;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manufacturer", c0694a.adh);
        }
        String str12 = c0694a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.sdk.internal.bn.f10753i, c0694a.model);
        }
        String str13 = c0694a.LN;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", c0694a.LN);
        }
        int i9 = c0694a.adi;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", i9);
        }
        String str14 = c0694a.adj;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemVersion", c0694a.adj);
        }
        int i10 = c0694a.adk;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", i10);
        }
        String str15 = c0694a.adl;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", c0694a.adl);
        }
        String str16 = c0694a.adm;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "locale", c0694a.adm);
        }
        String str17 = c0694a.aNJ;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uuid", c0694a.aNJ);
        }
        boolean z5 = c0694a.aNK;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isDynamic", z5);
        }
        int i11 = c0694a.Qw;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", i11);
        }
        int i12 = c0694a.Qv;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", i12);
        }
        String str18 = c0694a.aCk;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei", c0694a.aCk);
        }
        String str19 = c0694a.aCl;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", c0694a.aCl);
        }
        String str20 = c0694a.aIk;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "androidId", c0694a.aIk);
        }
        String str21 = c0694a.aIB;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, SocializeProtocolConstants.PROTOCOL_KEY_MAC, c0694a.aIB);
        }
        int i13 = c0694a.adn;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "statusBarHeight", i13);
        }
        int i14 = c0694a.ado;
        if (i14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarHeight", i14);
        }
        String str22 = c0694a.aNL;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bridgeVersion", c0694a.aNL);
        }
        return jSONObject;
    }
}
