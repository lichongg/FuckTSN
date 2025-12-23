package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class di implements com.kwad.sdk.core.d<AdGlobalConfigInfo.CycleAggregationInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo, JSONObject jSONObject) {
        a2(cycleAggregationInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo, JSONObject jSONObject) {
        return b2(cycleAggregationInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cycleAggregationInfo.cycleAggregationSwitch = jSONObject.optBoolean("cycleAggregationSwitch");
        cycleAggregationInfo.cycleAggregationInterval = jSONObject.optInt("cycleAggregationInterval");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = cycleAggregationInfo.cycleAggregationSwitch;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregationSwitch", z5);
        }
        int i6 = cycleAggregationInfo.cycleAggregationInterval;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregationInterval", i6);
        }
        return jSONObject;
    }
}
