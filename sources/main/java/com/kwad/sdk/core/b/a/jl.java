package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jl implements com.kwad.sdk.core.d<AdMatrixInfo.RotateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        a2(rotateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        return b2(rotateInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rotateInfo.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(rotateInfo.title)) {
            rotateInfo.title = "";
        }
        rotateInfo.subTitle = jSONObject.optString("subTitle");
        if (obj.toString().equals(rotateInfo.subTitle)) {
            rotateInfo.subTitle = "";
        }
        AdMatrixInfo.DownloadTexts downloadTexts = new AdMatrixInfo.DownloadTexts();
        rotateInfo.downloadTexts = downloadTexts;
        downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.f36347x = rotateDegreeInfo;
        rotateDegreeInfo.parseJson(jSONObject.optJSONObject("x"));
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo2 = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.f36348y = rotateDegreeInfo2;
        rotateDegreeInfo2.parseJson(jSONObject.optJSONObject("y"));
        AdMatrixInfo.RotateDegreeInfo rotateDegreeInfo3 = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.f36349z = rotateDegreeInfo3;
        rotateDegreeInfo3.parseJson(jSONObject.optJSONObject(com.umeng.analytics.pro.bi.aG));
        rotateInfo.enable = jSONObject.optBoolean("enable");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rotateInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", rotateInfo.title);
        }
        String str2 = rotateInfo.subTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "subTitle", rotateInfo.subTitle);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "downloadTexts", rotateInfo.downloadTexts);
        com.kwad.sdk.utils.aa.a(jSONObject, "x", rotateInfo.f36347x);
        com.kwad.sdk.utils.aa.a(jSONObject, "y", rotateInfo.f36348y);
        com.kwad.sdk.utils.aa.a(jSONObject, com.umeng.analytics.pro.bi.aG, rotateInfo.f36349z);
        boolean z5 = rotateInfo.enable;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enable", z5);
        }
        return jSONObject;
    }
}
