package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.check.RewardCheckMonitorInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jb implements com.kwad.sdk.core.d<RewardCheckMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        a2(rewardCheckMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        return b2(rewardCheckMonitorInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardCheckMonitorInfo.checkType = jSONObject.optInt("check_type");
        rewardCheckMonitorInfo.requestStatus = jSONObject.optInt("request_state");
        rewardCheckMonitorInfo.code = jSONObject.optInt("code");
        rewardCheckMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        rewardCheckMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardCheckMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardCheckMonitorInfo.enviType = jSONObject.optInt("enviType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = rewardCheckMonitorInfo.checkType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "check_type", i6);
        }
        int i7 = rewardCheckMonitorInfo.requestStatus;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_state", i7);
        }
        int i8 = rewardCheckMonitorInfo.code;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "code", i8);
        }
        long j6 = rewardCheckMonitorInfo.creativeId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", j6);
        }
        long j7 = rewardCheckMonitorInfo.dataLoadInterval;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "data_load_interval_duration_ms", j7);
        }
        long j8 = rewardCheckMonitorInfo.posId;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pos_Id", j8);
        }
        int i9 = rewardCheckMonitorInfo.enviType;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enviType", i9);
        }
        return jSONObject;
    }
}
