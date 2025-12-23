package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ht implements com.kwad.sdk.core.d<AdGlobalConfigInfo.NeoScanAggregationSceneInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        a2(neoScanAggregationSceneInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        return b2(neoScanAggregationSceneInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger = jSONObject.optBoolean("neoCountDownNeedSwipeTrigger");
        neoScanAggregationSceneInfo.neoCountDownTime = jSONObject.optInt("neoCountDownTime");
        neoScanAggregationSceneInfo.noActionStopCountDown = jSONObject.optBoolean("noActionStopCountDown");
        neoScanAggregationSceneInfo.noActionTime = jSONObject.optInt("noActionTime");
        neoScanAggregationSceneInfo.guidSwipezShowMore = jSONObject.optBoolean("guidSwipezShowMore");
        neoScanAggregationSceneInfo.mute = jSONObject.optBoolean("mute");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "neoCountDownNeedSwipeTrigger", z5);
        }
        int i6 = neoScanAggregationSceneInfo.neoCountDownTime;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "neoCountDownTime", i6);
        }
        boolean z6 = neoScanAggregationSceneInfo.noActionStopCountDown;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "noActionStopCountDown", z6);
        }
        int i7 = neoScanAggregationSceneInfo.noActionTime;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "noActionTime", i7);
        }
        boolean z7 = neoScanAggregationSceneInfo.guidSwipezShowMore;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "guidSwipezShowMore", z7);
        }
        boolean z8 = neoScanAggregationSceneInfo.mute;
        if (z8) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mute", z8);
        }
        return jSONObject;
    }
}
