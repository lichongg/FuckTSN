package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class v implements com.kwad.sdk.core.d<AdGlobalConfigInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        a2(adGlobalConfigInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        return b2(adGlobalConfigInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adGlobalConfigInfo.neoPageType = jSONObject.optInt("neoPageType");
        AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo = new AdGlobalConfigInfo.NeoScanAggregationSceneInfo();
        adGlobalConfigInfo.neoScanAggregationSceneInfo = neoScanAggregationSceneInfo;
        neoScanAggregationSceneInfo.parseJson(jSONObject.optJSONObject("neoScanAggregationSceneInfo"));
        AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo = new AdGlobalConfigInfo.CycleAggregationInfo();
        adGlobalConfigInfo.cycleAggregationInfo = cycleAggregationInfo;
        cycleAggregationInfo.parseJson(jSONObject.optJSONObject("cycleAggregationInfo"));
        adGlobalConfigInfo.uaidEnable = jSONObject.optBoolean("uaidEnable");
        AdVideoPreCacheConfig adVideoPreCacheConfig = new AdVideoPreCacheConfig();
        adGlobalConfigInfo.adVideoPreCacheConfig = adVideoPreCacheConfig;
        adVideoPreCacheConfig.parseJson(jSONObject.optJSONObject("adVideoPreCacheConfig"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = adGlobalConfigInfo.neoPageType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "neoPageType", i6);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "neoScanAggregationSceneInfo", adGlobalConfigInfo.neoScanAggregationSceneInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "cycleAggregationInfo", adGlobalConfigInfo.cycleAggregationInfo);
        boolean z5 = adGlobalConfigInfo.uaidEnable;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaidEnable", z5);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adVideoPreCacheConfig", adGlobalConfigInfo.adVideoPreCacheConfig);
        return jSONObject;
    }
}
