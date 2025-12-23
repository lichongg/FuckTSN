package com.kwad.sdk.core.b.a;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.scene.URLPackage;
import io.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class iz implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.timestamp = jSONObject.optLong("timestamp");
        nVar.sessionId = jSONObject.optString("sessionId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(nVar.sessionId)) {
            nVar.sessionId = "";
        }
        nVar.Nh = jSONObject.optLong(RtspHeaders.Values.SEQ);
        nVar.aGE = jSONObject.optLong("listId");
        nVar.actionType = jSONObject.optLong("actionType");
        nVar.Pj = jSONObject.optString("payload");
        if (obj.toString().equals(nVar.Pj)) {
            nVar.Pj = "";
        }
        nVar.llsid = jSONObject.optLong("llsid");
        nVar.aGF = jSONObject.optJSONObject(JThirdPlatFormInterface.KEY_EXTRA);
        nVar.aGG = jSONObject.optJSONObject("impAdExtra");
        nVar.posId = jSONObject.optLong("posId");
        nVar.contentType = jSONObject.optInt("contentType");
        nVar.realShowType = jSONObject.optInt("realShowType");
        nVar.photoId = jSONObject.optLong("photoId");
        nVar.position = jSONObject.optLong("position");
        nVar.aGH = jSONObject.optLong("serverPosition");
        nVar.aGI = jSONObject.optLong("photoDuration");
        nVar.aGJ = jSONObject.optLong("effectivePlayDuration");
        nVar.aci = jSONObject.optLong("playDuration");
        nVar.blockDuration = jSONObject.optLong("blockDuration");
        nVar.aGK = jSONObject.optLong("intervalDuration");
        nVar.aGL = jSONObject.optLong("allIntervalDuration");
        nVar.aGM = jSONObject.optLong("flowSdk");
        nVar.aGN = jSONObject.optLong("blockTimes");
        nVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        nVar.aye = jSONObject.optInt("adAggPageSource");
        nVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (obj.toString().equals(nVar.entryPageSource)) {
            nVar.entryPageSource = "";
        }
        URLPackage uRLPackage = new URLPackage();
        nVar.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        nVar.aGO = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        nVar.XI = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        nVar.aGP = jSONObject.optString("photoSize");
        if (obj.toString().equals(nVar.aGP)) {
            nVar.aGP = "";
        }
        nVar.aGQ = jSONObject.optJSONArray("appInstalled");
        nVar.aGR = jSONObject.optJSONArray("appUninstalled");
        n.a aVar = new n.a();
        nVar.aGS = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        nVar.aGT = jSONObject.optInt("playerType");
        nVar.aGU = jSONObject.optInt("uiType");
        nVar.aGV = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        nVar.adE = jSONObject.optInt("refreshType");
        nVar.aGW = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        nVar.aGX = jSONObject.optString("failUrl");
        if (obj.toString().equals(nVar.aGX)) {
            nVar.aGX = "";
        }
        nVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (obj.toString().equals(nVar.errorMsg)) {
            nVar.errorMsg = "";
        }
        nVar.errorCode = jSONObject.optInt("errorCode", new Integer("0").intValue());
        nVar.creativeId = jSONObject.optLong("creativeId");
        nVar.aHa = jSONObject.optString("cacheFailedReason");
        if (obj.toString().equals(nVar.aHa)) {
            nVar.aHa = "";
        }
        nVar.aHb = jSONObject.optJSONObject("appExt");
        nVar.aHc = jSONObject.optJSONArray("appRunningInfoList");
        nVar.downloadDuration = jSONObject.optLong("downloadDuration");
        nVar.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        nVar.aHd = jSONObject.optInt("speedLimitStatus");
        nVar.aHe = jSONObject.optInt("speedLimitThreshold");
        nVar.aHf = jSONObject.optInt("currentRealDownloadSpeed");
        nVar.aHh = jSONObject.optJSONArray("sdkPlatform");
        nVar.aHi = jSONObject.optBoolean("isKsUnion");
        nVar.aHj = jSONObject.optString("trackMethodName");
        if (obj.toString().equals(nVar.aHj)) {
            nVar.aHj = "";
        }
        nVar.aHk = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        nVar.clickTime = jSONObject.optLong("clickTime");
        nVar.aHm = jSONObject.optLong("frameRenderTime");
        nVar.aHn = jSONObject.optInt("playerEnterAction");
        nVar.aHo = jSONObject.optString("requestUrl");
        if (obj.toString().equals(nVar.aHo)) {
            nVar.aHo = "";
        }
        nVar.aHp = jSONObject.optLong("requestTotalTime");
        nVar.aHq = jSONObject.optLong("requestResponseTime");
        nVar.aHr = jSONObject.optLong("requestParseDataTime");
        nVar.aHs = jSONObject.optLong("requestCallbackTime");
        nVar.aHt = jSONObject.optString("requestFailReason");
        if (obj.toString().equals(nVar.aHt)) {
            nVar.aHt = "";
        }
        nVar.WH = jSONObject.optString("pageName");
        if (obj.toString().equals(nVar.WH)) {
            nVar.WH = "";
        }
        nVar.WP = jSONObject.optLong("pageCreateTime");
        nVar.WQ = jSONObject.optLong("pageResumeTime");
        nVar.aHu = jSONObject.optInt("trackUrlType");
        nVar.aHv = jSONObject.optJSONArray("trackUrlList");
        nVar.WO = jSONObject.optLong("pageLaunchTime");
        nVar.aHy = jSONObject.optJSONArray("appAuthorityInfoList");
        nVar.aHz = jSONObject.optString("tkVersion");
        if (obj.toString().equals(nVar.aHz)) {
            nVar.aHz = "";
        }
        nVar.aHA = jSONObject.optString("jsVersion");
        if (obj.toString().equals(nVar.aHA)) {
            nVar.aHA = "";
        }
        nVar.aHB = jSONObject.optString("jsFileName");
        if (obj.toString().equals(nVar.aHB)) {
            nVar.aHB = "";
        }
        nVar.aHC = jSONObject.optString("jsErrorMsg");
        if (obj.toString().equals(nVar.aHC)) {
            nVar.aHC = "";
        }
        nVar.aHD = jSONObject.optString("jsConfig");
        if (obj.toString().equals(nVar.aHD)) {
            nVar.aHD = "";
        }
        nVar.aHE = jSONObject.optInt("adBizType");
        nVar.aHF = jSONObject.optString("customKey");
        if (obj.toString().equals(nVar.aHF)) {
            nVar.aHF = "";
        }
        nVar.aHG = jSONObject.optString("customValue");
        if (obj.toString().equals(nVar.aHG)) {
            nVar.aHG = "";
        }
        nVar.trace = jSONObject.optString("trace");
        if (obj.toString().equals(nVar.trace)) {
            nVar.trace = "";
        }
        nVar.aHH = jSONObject.optInt("filterCode");
        nVar.aHI = jSONObject.optInt("sdkVersionCode");
        nVar.sdkVersion = jSONObject.optString("sdkVersion");
        if (obj.toString().equals(nVar.sdkVersion)) {
            nVar.sdkVersion = "";
        }
        nVar.aHJ = jSONObject.optString("adSdkVersion");
        if (obj.toString().equals(nVar.aHJ)) {
            nVar.aHJ = "";
        }
        nVar.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(nVar.sdkApiVersion)) {
            nVar.sdkApiVersion = "";
        }
        nVar.sdkType = jSONObject.optInt("sdkType");
        nVar.aHK = jSONObject.optLong("appUseDuration");
        nVar.aHL = jSONObject.optLong("appStartType");
        nVar.aDb = jSONObject.optLong("sequenceNumber");
        nVar.Ne = jSONObject.optString("appColdStart");
        if (obj.toString().equals(nVar.Ne)) {
            nVar.Ne = "";
        }
        nVar.Nf = jSONObject.optString("appStart");
        if (obj.toString().equals(nVar.Nf)) {
            nVar.Nf = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = nVar.timestamp;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "timestamp", j6);
        }
        String str = nVar.sessionId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sessionId", nVar.sessionId);
        }
        long j7 = nVar.Nh;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, RtspHeaders.Values.SEQ, j7);
        }
        long j8 = nVar.aGE;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "listId", j8);
        }
        long j9 = nVar.actionType;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", j9);
        }
        String str2 = nVar.Pj;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", nVar.Pj);
        }
        long j10 = nVar.llsid;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", j10);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, JThirdPlatFormInterface.KEY_EXTRA, nVar.aGF);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "impAdExtra", nVar.aGG);
        long j11 = nVar.posId;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", j11);
        }
        int i6 = nVar.contentType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "contentType", i6);
        }
        int i7 = nVar.realShowType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realShowType", i7);
        }
        long j12 = nVar.photoId;
        if (j12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoId", j12);
        }
        long j13 = nVar.position;
        if (j13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "position", j13);
        }
        long j14 = nVar.aGH;
        if (j14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serverPosition", j14);
        }
        long j15 = nVar.aGI;
        if (j15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoDuration", j15);
        }
        long j16 = nVar.aGJ;
        if (j16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "effectivePlayDuration", j16);
        }
        long j17 = nVar.aci;
        if (j17 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", j17);
        }
        long j18 = nVar.blockDuration;
        if (j18 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockDuration", j18);
        }
        long j19 = nVar.aGK;
        if (j19 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "intervalDuration", j19);
        }
        long j20 = nVar.aGL;
        if (j20 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "allIntervalDuration", j20);
        }
        long j21 = nVar.aGM;
        if (j21 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "flowSdk", j21);
        }
        long j22 = nVar.aGN;
        if (j22 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockTimes", j22);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "contentSourceType", nVar.contentSourceType);
        int i8 = nVar.aye;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAggPageSource", i8);
        }
        String str3 = nVar.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryPageSource", nVar.entryPageSource);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "urlPackage", nVar.urlPackage);
        com.kwad.sdk.utils.aa.a(jSONObject, "referURLPackage", nVar.aGO);
        long j23 = nVar.XI;
        if (j23 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j23);
        }
        String str4 = nVar.aGP;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoSize", nVar.aGP);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appInstalled", nVar.aGQ);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appUninstalled", nVar.aGR);
        com.kwad.sdk.utils.aa.a(jSONObject, "clientExt", nVar.aGS);
        int i9 = nVar.aGT;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playerType", i9);
        }
        int i10 = nVar.aGU;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uiType", i10);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "isLeftSlipStatus", nVar.aGV);
        int i11 = nVar.adE;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "refreshType", i11);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "photoResponseType", nVar.aGW);
        String str5 = nVar.aGX;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "failUrl", nVar.aGX);
        }
        String str6 = nVar.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, nVar.errorMsg);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "errorCode", nVar.errorCode);
        long j24 = nVar.creativeId;
        if (j24 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", j24);
        }
        String str7 = nVar.aHa;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheFailedReason", nVar.aHa);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appExt", nVar.aHb);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appRunningInfoList", nVar.aHc);
        long j25 = nVar.downloadDuration;
        if (j25 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadDuration", j25);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "pageType", nVar.pageType);
        int i12 = nVar.aHd;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speedLimitStatus", i12);
        }
        int i13 = nVar.aHe;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speedLimitThreshold", i13);
        }
        int i14 = nVar.aHf;
        if (i14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentRealDownloadSpeed", i14);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkPlatform", nVar.aHh);
        boolean z5 = nVar.aHi;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isKsUnion", z5);
        }
        String str8 = nVar.aHj;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trackMethodName", nVar.aHj);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "viewModeType", nVar.aHk);
        long j26 = nVar.clickTime;
        if (j26 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickTime", j26);
        }
        long j27 = nVar.aHm;
        if (j27 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "frameRenderTime", j27);
        }
        int i15 = nVar.aHn;
        if (i15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playerEnterAction", i15);
        }
        String str9 = nVar.aHo;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestUrl", nVar.aHo);
        }
        long j28 = nVar.aHp;
        if (j28 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestTotalTime", j28);
        }
        long j29 = nVar.aHq;
        if (j29 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestResponseTime", j29);
        }
        long j30 = nVar.aHr;
        if (j30 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestParseDataTime", j30);
        }
        long j31 = nVar.aHs;
        if (j31 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestCallbackTime", j31);
        }
        String str10 = nVar.aHt;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestFailReason", nVar.aHt);
        }
        String str11 = nVar.WH;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageName", nVar.WH);
        }
        long j32 = nVar.WP;
        if (j32 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageCreateTime", j32);
        }
        long j33 = nVar.WQ;
        if (j33 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageResumeTime", j33);
        }
        int i16 = nVar.aHu;
        if (i16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trackUrlType", i16);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "trackUrlList", nVar.aHv);
        long j34 = nVar.WO;
        if (j34 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageLaunchTime", j34);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appAuthorityInfoList", nVar.aHy);
        String str12 = nVar.aHz;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tkVersion", nVar.aHz);
        }
        String str13 = nVar.aHA;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsVersion", nVar.aHA);
        }
        String str14 = nVar.aHB;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsFileName", nVar.aHB);
        }
        String str15 = nVar.aHC;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsErrorMsg", nVar.aHC);
        }
        String str16 = nVar.aHD;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsConfig", nVar.aHD);
        }
        int i17 = nVar.aHE;
        if (i17 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adBizType", i17);
        }
        String str17 = nVar.aHF;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "customKey", nVar.aHF);
        }
        String str18 = nVar.aHG;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "customValue", nVar.aHG);
        }
        String str19 = nVar.trace;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trace", nVar.trace);
        }
        int i18 = nVar.aHH;
        if (i18 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "filterCode", i18);
        }
        int i19 = nVar.aHI;
        if (i19 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkVersionCode", i19);
        }
        String str20 = nVar.sdkVersion;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkVersion", nVar.sdkVersion);
        }
        String str21 = nVar.aHJ;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adSdkVersion", nVar.aHJ);
        }
        String str22 = nVar.sdkApiVersion;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", nVar.sdkApiVersion);
        }
        int i20 = nVar.sdkType;
        if (i20 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", i20);
        }
        long j35 = nVar.aHK;
        if (j35 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appUseDuration", j35);
        }
        long j36 = nVar.aHL;
        if (j36 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStartType", j36);
        }
        long j37 = nVar.aDb;
        if (j37 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sequenceNumber", j37);
        }
        String str23 = nVar.Ne;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appColdStart", nVar.Ne);
        }
        String str24 = nVar.Nf;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStart", nVar.Nf);
        }
        return jSONObject;
    }
}
