package com.kwad.sdk.core.b.a;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fu implements com.kwad.sdk.core.d<ImpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImpInfo impInfo, JSONObject jSONObject) {
        a2(impInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImpInfo impInfo, JSONObject jSONObject) {
        return b2(impInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        impInfo.pageScene = jSONObject.optLong("pageScene");
        impInfo.subPageScene = jSONObject.optLong("subPageScene");
        impInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(impInfo.sdkExtraData)) {
            impInfo.sdkExtraData = "";
        }
        impInfo.posId = jSONObject.optLong("posId");
        impInfo.entryScene = jSONObject.optLong("entryScene");
        impInfo.adNum = jSONObject.optInt("adNum");
        impInfo.action = jSONObject.optInt(com.umeng.ccg.a.f41544t);
        impInfo.width = jSONObject.optInt("width");
        impInfo.height = jSONObject.optInt("height");
        impInfo.cpmBidFloor = jSONObject.optLong("cpmBidFloor");
        impInfo.adStyle = jSONObject.optInt("adStyle");
        URLPackage uRLPackage = new URLPackage();
        impInfo.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        impInfo.promoteId = jSONObject.optString("promoteId");
        if (obj.toString().equals(impInfo.promoteId)) {
            impInfo.promoteId = "";
        }
        impInfo.comment = jSONObject.optString("comment");
        if (obj.toString().equals(impInfo.comment)) {
            impInfo.comment = "";
        }
        impInfo.backUrl = jSONObject.optString("backUrl");
        if (obj.toString().equals(impInfo.backUrl)) {
            impInfo.backUrl = "";
        }
        impInfo.userCommRateBuying = jSONObject.optLong("userCommRateBuying");
        impInfo.userCommRateSharing = jSONObject.optLong("userCommRateSharing");
        impInfo.screenOrientation = jSONObject.optInt("screenOrientation");
        impInfo.extraData = jSONObject.optString("extraData");
        if (obj.toString().equals(impInfo.extraData)) {
            impInfo.extraData = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = impInfo.pageScene;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageScene", j6);
        }
        long j7 = impInfo.subPageScene;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "subPageScene", j7);
        }
        String str = impInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkExtraData", impInfo.sdkExtraData);
        }
        long j8 = impInfo.posId;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", j8);
        }
        long j9 = impInfo.entryScene;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryScene", j9);
        }
        int i6 = impInfo.adNum;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adNum", i6);
        }
        int i7 = impInfo.action;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.ccg.a.f41544t, i7);
        }
        int i8 = impInfo.width;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", i8);
        }
        int i9 = impInfo.height;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", i9);
        }
        long j10 = impInfo.cpmBidFloor;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cpmBidFloor", j10);
        }
        int i10 = impInfo.adStyle;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", i10);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "urlPackage", impInfo.urlPackage);
        String str2 = impInfo.promoteId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "promoteId", impInfo.promoteId);
        }
        String str3 = impInfo.comment;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "comment", impInfo.comment);
        }
        String str4 = impInfo.backUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "backUrl", impInfo.backUrl);
        }
        long j11 = impInfo.userCommRateBuying;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userCommRateBuying", j11);
        }
        long j12 = impInfo.userCommRateSharing;
        if (j12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userCommRateSharing", j12);
        }
        int i11 = impInfo.screenOrientation;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenOrientation", i11);
        }
        String str5 = impInfo.extraData;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "extraData", impInfo.extraData);
        }
        return jSONObject;
    }
}
