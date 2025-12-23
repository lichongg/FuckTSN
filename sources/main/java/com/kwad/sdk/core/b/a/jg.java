package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jg implements com.kwad.sdk.core.d<AdMatrixInfo.RewardVideoInteractInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        a2(rewardVideoInteractInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        return b2(rewardVideoInteractInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardVideoInteractInfo.templateId = jSONObject.optString("templateId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(rewardVideoInteractInfo.templateId)) {
            rewardVideoInteractInfo.templateId = "";
        }
        rewardVideoInteractInfo.showTime = jSONObject.optInt("showTime", new Integer(Constants.VIA_REPORT_TYPE_WPA_STATE).intValue());
        rewardVideoInteractInfo.duration = jSONObject.optInt("duration", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
        rewardVideoInteractInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("5").intValue());
        rewardVideoInteractInfo.intervalShow = jSONObject.optInt("intervalShow", new Integer("3").intValue());
        rewardVideoInteractInfo.dayMaxLimit = jSONObject.optInt("dayMaxLimit", new Integer("2").intValue());
        rewardVideoInteractInfo.style = jSONObject.optInt(ResIdentify.RES_TYPE_STYLE);
        rewardVideoInteractInfo.successfulMsg = jSONObject.optString("successfulMsg");
        if (obj.toString().equals(rewardVideoInteractInfo.successfulMsg)) {
            rewardVideoInteractInfo.successfulMsg = "";
        }
        rewardVideoInteractInfo.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (obj.toString().equals(rewardVideoInteractInfo.errorMsg)) {
            rewardVideoInteractInfo.errorMsg = "";
        }
        AdMatrixInfo.StyleInfo styleInfo = new AdMatrixInfo.StyleInfo();
        rewardVideoInteractInfo.styleInfo = styleInfo;
        styleInfo.parseJson(jSONObject.optJSONObject("styleInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardVideoInteractInfo.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateId", rewardVideoInteractInfo.templateId);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", rewardVideoInteractInfo.showTime);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "duration", rewardVideoInteractInfo.duration);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardTime", rewardVideoInteractInfo.rewardTime);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "intervalShow", rewardVideoInteractInfo.intervalShow);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "dayMaxLimit", rewardVideoInteractInfo.dayMaxLimit);
        int i6 = rewardVideoInteractInfo.style;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, ResIdentify.RES_TYPE_STYLE, i6);
        }
        String str2 = rewardVideoInteractInfo.successfulMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "successfulMsg", rewardVideoInteractInfo.successfulMsg);
        }
        String str3 = rewardVideoInteractInfo.errorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, rewardVideoInteractInfo.errorMsg);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "styleInfo", rewardVideoInteractInfo.styleInfo);
        return jSONObject;
    }
}
