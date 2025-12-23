package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class dp implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aCk = jSONObject.optString("imei");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aCk)) {
            bVar.aCk = "";
        }
        bVar.aId = jSONObject.optString("imei1");
        if (obj.toString().equals(bVar.aId)) {
            bVar.aId = "";
        }
        bVar.aIe = jSONObject.optString("imei2");
        if (obj.toString().equals(bVar.aIe)) {
            bVar.aIe = "";
        }
        bVar.aIf = jSONObject.optString("meid");
        if (obj.toString().equals(bVar.aIf)) {
            bVar.aIf = "";
        }
        bVar.aCl = jSONObject.optString("oaid");
        if (obj.toString().equals(bVar.aCl)) {
            bVar.aCl = "";
        }
        bVar.aIg = jSONObject.optString("appMkt");
        if (obj.toString().equals(bVar.aIg)) {
            bVar.aIg = "";
        }
        bVar.aIh = jSONObject.optString("appMktParam");
        if (obj.toString().equals(bVar.aIh)) {
            bVar.aIh = "";
        }
        bVar.LP = jSONObject.optString("romName");
        if (obj.toString().equals(bVar.LP)) {
            bVar.LP = "";
        }
        bVar.adi = jSONObject.optInt("osType");
        bVar.adk = jSONObject.optInt("osApi");
        bVar.LO = jSONObject.optString("osVersion");
        if (obj.toString().equals(bVar.LO)) {
            bVar.LO = "";
        }
        bVar.adl = jSONObject.optString("language");
        if (obj.toString().equals(bVar.adl)) {
            bVar.adl = "";
        }
        bVar.Qw = jSONObject.optInt("screenWidth");
        bVar.Qv = jSONObject.optInt("screenHeight");
        bVar.aIi = jSONObject.optInt("deviceWidth");
        bVar.aIj = jSONObject.optInt("deviceHeight");
        bVar.aIk = jSONObject.optString("androidId");
        if (obj.toString().equals(bVar.aIk)) {
            bVar.aIk = "";
        }
        bVar.LQ = jSONObject.optString("deviceId");
        if (obj.toString().equals(bVar.LQ)) {
            bVar.LQ = "";
        }
        bVar.aIl = jSONObject.optString("deviceVendor");
        if (obj.toString().equals(bVar.aIl)) {
            bVar.aIl = "";
        }
        bVar.aIm = jSONObject.optInt("platform");
        bVar.LM = jSONObject.optString("deviceModel");
        if (obj.toString().equals(bVar.LM)) {
            bVar.LM = "";
        }
        bVar.LN = jSONObject.optString("deviceBrand");
        if (obj.toString().equals(bVar.LN)) {
            bVar.LN = "";
        }
        bVar.aIn = jSONObject.optString("deviceSig");
        if (obj.toString().equals(bVar.aIn)) {
            bVar.aIn = "";
        }
        bVar.aIo = jSONObject.optString("eGid");
        if (obj.toString().equals(bVar.aIo)) {
            bVar.aIo = "";
        }
        bVar.aIp = jSONObject.optJSONArray("appPackageName");
        bVar.aIq = jSONObject.optString("uaidToken");
        if (obj.toString().equals(bVar.aIq)) {
            bVar.aIq = "";
        }
        bVar.uaid = jSONObject.optString("uaid");
        if (obj.toString().equals(bVar.uaid)) {
            bVar.uaid = "";
        }
        bVar.aIr = jSONObject.optString("arch");
        if (obj.toString().equals(bVar.aIr)) {
            bVar.aIr = "";
        }
        bVar.aIs = jSONObject.optInt("screenDirection");
        bVar.aIt = jSONObject.optString("kwaiVersionName");
        if (obj.toString().equals(bVar.aIt)) {
            bVar.aIt = "";
        }
        bVar.aIu = jSONObject.optString("kwaiNebulaVersionName");
        if (obj.toString().equals(bVar.aIu)) {
            bVar.aIu = "";
        }
        bVar.aIv = jSONObject.optString("wechatVersionName");
        if (obj.toString().equals(bVar.aIv)) {
            bVar.aIv = "";
        }
        bVar.aIw = jSONObject.optLong("sourceFlag");
        bVar.aIx = jSONObject.optString("systemBootTime");
        if (obj.toString().equals(bVar.aIx)) {
            bVar.aIx = "";
        }
        bVar.aIy = jSONObject.optString("systemUpdateTime");
        if (obj.toString().equals(bVar.aIy)) {
            bVar.aIy = "";
        }
        bVar.aIz = jSONObject.optInt("probeBatch");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aCk;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei", bVar.aCk);
        }
        String str2 = bVar.aId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei1", bVar.aId);
        }
        String str3 = bVar.aIe;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei2", bVar.aIe);
        }
        String str4 = bVar.aIf;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "meid", bVar.aIf);
        }
        String str5 = bVar.aCl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", bVar.aCl);
        }
        String str6 = bVar.aIg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appMkt", bVar.aIg);
        }
        String str7 = bVar.aIh;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appMktParam", bVar.aIh);
        }
        String str8 = bVar.LP;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "romName", bVar.LP);
        }
        int i6 = bVar.adi;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", i6);
        }
        int i7 = bVar.adk;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", i7);
        }
        String str9 = bVar.LO;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osVersion", bVar.LO);
        }
        String str10 = bVar.adl;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", bVar.adl);
        }
        int i8 = bVar.Qw;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", i8);
        }
        int i9 = bVar.Qv;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", i9);
        }
        int i10 = bVar.aIi;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceWidth", i10);
        }
        int i11 = bVar.aIj;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceHeight", i11);
        }
        String str11 = bVar.aIk;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "androidId", bVar.aIk);
        }
        String str12 = bVar.LQ;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceId", bVar.LQ);
        }
        String str13 = bVar.aIl;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceVendor", bVar.aIl);
        }
        int i12 = bVar.aIm;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "platform", i12);
        }
        String str14 = bVar.LM;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceModel", bVar.LM);
        }
        String str15 = bVar.LN;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", bVar.LN);
        }
        String str16 = bVar.aIn;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceSig", bVar.aIn);
        }
        String str17 = bVar.aIo;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "eGid", bVar.aIo);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appPackageName", bVar.aIp);
        String str18 = bVar.aIq;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaidToken", bVar.aIq);
        }
        String str19 = bVar.uaid;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaid", bVar.uaid);
        }
        String str20 = bVar.aIr;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "arch", bVar.aIr);
        }
        int i13 = bVar.aIs;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenDirection", i13);
        }
        String str21 = bVar.aIt;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kwaiVersionName", bVar.aIt);
        }
        String str22 = bVar.aIu;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kwaiNebulaVersionName", bVar.aIu);
        }
        String str23 = bVar.aIv;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "wechatVersionName", bVar.aIv);
        }
        long j6 = bVar.aIw;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sourceFlag", j6);
        }
        String str24 = bVar.aIx;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemBootTime", bVar.aIx);
        }
        String str25 = bVar.aIy;
        if (str25 != null && !str25.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemUpdateTime", bVar.aIy);
        }
        int i14 = bVar.aIz;
        if (i14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "probeBatch", i14);
        }
        return jSONObject;
    }
}
