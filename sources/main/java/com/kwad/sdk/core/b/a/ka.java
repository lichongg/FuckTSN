package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ka implements com.kwad.sdk.core.d<AdProductInfo.SpikeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        a2(spikeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        return b2(spikeInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong("endTime");
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = spikeInfo.endTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "endTime", j6);
        }
        int i6 = spikeInfo.soldStock;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soldStock", i6);
        }
        int i7 = spikeInfo.originalStock;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "originalStock", i7);
        }
        return jSONObject;
    }
}
