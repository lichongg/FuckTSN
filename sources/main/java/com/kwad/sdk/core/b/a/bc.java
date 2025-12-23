package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bc implements com.kwad.sdk.core.d<AdMatrixInfo.AggregationCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        a2(aggregationCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        return b2(aggregationCardInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aggregationCardInfo.changeTime = jSONObject.optInt("changeTime");
        aggregationCardInfo.maxTimesPerDay = jSONObject.optInt("maxTimesPerDay");
        aggregationCardInfo.intervalTime = jSONObject.optLong("intervalTime", new Long("1200").longValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aggregationCardInfo.changeTime;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "changeTime", i6);
        }
        int i7 = aggregationCardInfo.maxTimesPerDay;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxTimesPerDay", i7);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "intervalTime", aggregationCardInfo.intervalTime);
        return jSONObject;
    }
}
