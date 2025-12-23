package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ah implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdTemplate adTemplate = new AdTemplate();
        aVar.adTemplate = adTemplate;
        adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        aVar.axI = jSONObject.optJSONObject("extData");
        aVar.awx = jSONObject.optInt("adActionType");
        aVar.axJ = jSONObject.optInt("photoPlaySecond");
        aVar.axK = jSONObject.optInt("awardReceiveStage");
        aVar.mI = jSONObject.optInt("itemClickType");
        aVar.axL = jSONObject.optInt("itemCloseType");
        aVar.axM = jSONObject.optInt("elementType");
        aVar.axN = jSONObject.optString("adRenderArea");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.axN)) {
            aVar.axN = "";
        }
        aVar.axO = jSONObject.optLong("highestLossPrice");
        aVar.axP = jSONObject.optInt("impFailReason");
        aVar.axQ = jSONObject.optLong("winEcpm");
        aVar.adnType = jSONObject.optInt("adnType");
        aVar.adnName = jSONObject.optString(MediationConstant.KEY_ADN_NAME);
        if (obj.toString().equals(aVar.adnName)) {
            aVar.adnName = "";
        }
        aVar.axR = jSONObject.optString("adnAdvertiser");
        if (obj.toString().equals(aVar.axR)) {
            aVar.axR = "";
        }
        aVar.axS = jSONObject.optString("adnTitle");
        if (obj.toString().equals(aVar.axS)) {
            aVar.axS = "";
        }
        aVar.axT = jSONObject.optString("adnRequestId");
        if (obj.toString().equals(aVar.axT)) {
            aVar.axT = "";
        }
        aVar.axU = jSONObject.optInt("adnShowType");
        aVar.axV = jSONObject.optInt("adnClickType");
        aVar.adnMaterialType = jSONObject.optInt("adnMaterialType");
        aVar.adnMaterialUrl = jSONObject.optString("adnMaterialUrl");
        if (obj.toString().equals(aVar.adnMaterialUrl)) {
            aVar.adnMaterialUrl = "";
        }
        aVar.axW = jSONObject.optInt("retainCodeType");
        aVar.Pl = jSONObject.optInt("photoSizeStyle");
        aVar.Pj = jSONObject.optString("payload");
        if (obj.toString().equals(aVar.Pj)) {
            aVar.Pj = "";
        }
        aVar.axX = jSONObject.optInt("deeplinkType");
        aVar.axY = jSONObject.optString("deeplinkAppName");
        if (obj.toString().equals(aVar.axY)) {
            aVar.axY = "";
        }
        aVar.axZ = jSONObject.optInt("deeplinkFailedReason");
        aVar.downloadSource = jSONObject.optInt("downloadSource");
        aVar.aya = jSONObject.optInt("isPackageChanged");
        aVar.ayb = jSONObject.optString("installedFrom");
        if (obj.toString().equals(aVar.ayb)) {
            aVar.ayb = "";
        }
        aVar.ayc = jSONObject.optString("downloadFailedReason");
        if (obj.toString().equals(aVar.ayc)) {
            aVar.ayc = "";
        }
        aVar.ayd = jSONObject.optInt("isChangedEndcard");
        aVar.aye = jSONObject.optInt("adAggPageSource");
        aVar.ayf = jSONObject.optString("serverPackageName");
        if (obj.toString().equals(aVar.ayf)) {
            aVar.ayf = "";
        }
        aVar.ayg = jSONObject.optString("installedPackageName");
        if (obj.toString().equals(aVar.ayg)) {
            aVar.ayg = "";
        }
        aVar.ayh = jSONObject.optInt("closeButtonImpressionTime");
        aVar.ayi = jSONObject.optInt("closeButtonClickTime");
        aVar.ayj = jSONObject.optLong("landingPageLoadedDuration");
        aVar.PL = jSONObject.optLong("leaveTime");
        aVar.ayk = jSONObject.optLong("adItemClickBackDuration");
        aVar.ayl = jSONObject.optInt("appStorePageType");
        aVar.aym = jSONObject.optInt("installStatus");
        aVar.downloadStatus = jSONObject.optInt("downloadStatus");
        aVar.ayn = jSONObject.optInt("downloadCardType");
        a.C0675a c0675a = new a.C0675a();
        aVar.Pk = c0675a;
        c0675a.parseJson(jSONObject.optJSONObject("clientExtData"));
        aVar.To = jSONObject.optInt("landingPageType");
        aVar.yU = jSONObject.optLong("playedDuration");
        aVar.ayo = jSONObject.optInt("playedRate");
        aVar.ayp = jSONObject.optInt("adOrder");
        aVar.Pi = jSONObject.optInt("adInterstitialSource");
        aVar.mL = jSONObject.optDouble("splashShakeAcceleration");
        aVar.ayq = jSONObject.optString("splashInteractionRotateAngle");
        if (obj.toString().equals(aVar.ayq)) {
            aVar.ayq = "";
        }
        aVar.ayr = jSONObject.optInt("downloadInstallType");
        aVar.ays = jSONObject.optInt("businessSceneType");
        aVar.adxResult = jSONObject.optInt("adxResult");
        aVar.ayt = jSONObject.optInt("fingerSwipeType");
        aVar.ayu = jSONObject.optInt("fingerSwipeDistance");
        aVar.ayv = jSONObject.optInt("finger_swipe_angle");
        aVar.Pm = jSONObject.optInt("triggerType");
        aVar.ayw = jSONObject.optInt("cardCloseType");
        aVar.ayx = jSONObject.optString("clientPkFailAdInfo");
        if (obj.toString().equals(aVar.ayx)) {
            aVar.ayx = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", aVar.adTemplate);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "extData", aVar.axI);
        int i6 = aVar.awx;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adActionType", i6);
        }
        int i7 = aVar.axJ;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoPlaySecond", i7);
        }
        int i8 = aVar.axK;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "awardReceiveStage", i8);
        }
        int i9 = aVar.mI;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", i9);
        }
        int i10 = aVar.axL;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemCloseType", i10);
        }
        int i11 = aVar.axM;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "elementType", i11);
        }
        String str = aVar.axN;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adRenderArea", aVar.axN);
        }
        long j6 = aVar.axO;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "highestLossPrice", j6);
        }
        int i12 = aVar.axP;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impFailReason", i12);
        }
        long j7 = aVar.axQ;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "winEcpm", j7);
        }
        int i13 = aVar.adnType;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnType", i13);
        }
        String str2 = aVar.adnName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        String str3 = aVar.axR;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnAdvertiser", aVar.axR);
        }
        String str4 = aVar.axS;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnTitle", aVar.axS);
        }
        String str5 = aVar.axT;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnRequestId", aVar.axT);
        }
        int i14 = aVar.axU;
        if (i14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnShowType", i14);
        }
        int i15 = aVar.axV;
        if (i15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnClickType", i15);
        }
        int i16 = aVar.adnMaterialType;
        if (i16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnMaterialType", i16);
        }
        String str6 = aVar.adnMaterialUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnMaterialUrl", aVar.adnMaterialUrl);
        }
        int i17 = aVar.axW;
        if (i17 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainCodeType", i17);
        }
        int i18 = aVar.Pl;
        if (i18 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoSizeStyle", i18);
        }
        String str7 = aVar.Pj;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", aVar.Pj);
        }
        int i19 = aVar.axX;
        if (i19 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkType", i19);
        }
        String str8 = aVar.axY;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkAppName", aVar.axY);
        }
        int i20 = aVar.axZ;
        if (i20 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkFailedReason", i20);
        }
        int i21 = aVar.downloadSource;
        if (i21 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadSource", i21);
        }
        int i22 = aVar.aya;
        if (i22 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isPackageChanged", i22);
        }
        String str9 = aVar.ayb;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installedFrom", aVar.ayb);
        }
        String str10 = aVar.ayc;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadFailedReason", aVar.ayc);
        }
        int i23 = aVar.ayd;
        if (i23 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isChangedEndcard", i23);
        }
        int i24 = aVar.aye;
        if (i24 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAggPageSource", i24);
        }
        String str11 = aVar.ayf;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serverPackageName", aVar.ayf);
        }
        String str12 = aVar.ayg;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installedPackageName", aVar.ayg);
        }
        int i25 = aVar.ayh;
        if (i25 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeButtonImpressionTime", i25);
        }
        int i26 = aVar.ayi;
        if (i26 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeButtonClickTime", i26);
        }
        long j8 = aVar.ayj;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "landingPageLoadedDuration", j8);
        }
        long j9 = aVar.PL;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leaveTime", j9);
        }
        long j10 = aVar.ayk;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adItemClickBackDuration", j10);
        }
        int i27 = aVar.ayl;
        if (i27 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStorePageType", i27);
        }
        int i28 = aVar.aym;
        if (i28 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installStatus", i28);
        }
        int i29 = aVar.downloadStatus;
        if (i29 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadStatus", i29);
        }
        int i30 = aVar.ayn;
        if (i30 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadCardType", i30);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "clientExtData", aVar.Pk);
        int i31 = aVar.To;
        if (i31 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "landingPageType", i31);
        }
        long j11 = aVar.yU;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playedDuration", j11);
        }
        int i32 = aVar.ayo;
        if (i32 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playedRate", i32);
        }
        int i33 = aVar.ayp;
        if (i33 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adOrder", i33);
        }
        int i34 = aVar.Pi;
        if (i34 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adInterstitialSource", i34);
        }
        double d6 = aVar.mL;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "splashShakeAcceleration", d6);
        }
        String str13 = aVar.ayq;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "splashInteractionRotateAngle", aVar.ayq);
        }
        int i35 = aVar.ayr;
        if (i35 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadInstallType", i35);
        }
        int i36 = aVar.ays;
        if (i36 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "businessSceneType", i36);
        }
        int i37 = aVar.adxResult;
        if (i37 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adxResult", i37);
        }
        int i38 = aVar.ayt;
        if (i38 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fingerSwipeType", i38);
        }
        int i39 = aVar.ayu;
        if (i39 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fingerSwipeDistance", i39);
        }
        int i40 = aVar.ayv;
        if (i40 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "finger_swipe_angle", i40);
        }
        int i41 = aVar.Pm;
        if (i41 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "triggerType", i41);
        }
        int i42 = aVar.ayw;
        if (i42 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardCloseType", i42);
        }
        String str14 = aVar.ayx;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clientPkFailAdInfo", aVar.ayx);
        }
        return jSONObject;
    }
}
