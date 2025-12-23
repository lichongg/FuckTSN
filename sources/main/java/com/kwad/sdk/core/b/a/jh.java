package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jh implements com.kwad.sdk.core.d<AdMatrixInfo.RewardVideoTaskInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        a2(rewardVideoTaskInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        return b2(rewardVideoTaskInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardVideoTaskInfo.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(rewardVideoTaskInfo.templateId)) {
            rewardVideoTaskInfo.templateId = "";
        }
        rewardVideoTaskInfo.showTime = jSONObject.optInt("showTime", new Integer(Constants.VIA_REPORT_TYPE_WPA_STATE).intValue());
        rewardVideoTaskInfo.duration = jSONObject.optInt("duration", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
        rewardVideoTaskInfo.taskType = jSONObject.optInt("taskType", new Integer("0").intValue());
        rewardVideoTaskInfo.thresholdTime = jSONObject.optInt("thresholdTime", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardVideoTaskInfo.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateId", rewardVideoTaskInfo.templateId);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", rewardVideoTaskInfo.showTime);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "duration", rewardVideoTaskInfo.duration);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "taskType", rewardVideoTaskInfo.taskType);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "thresholdTime", rewardVideoTaskInfo.thresholdTime);
        return jSONObject;
    }
}
