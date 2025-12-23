package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStatusInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ar implements com.kwad.sdk.core.d<AdStatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        a2(adStatusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        return b2(adStatusInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStatusInfo.loadFromCache = jSONObject.optBoolean("loadFromCache");
        adStatusInfo.loadDataTime = jSONObject.optLong("loadDataTime");
        adStatusInfo.downloadFinishTime = jSONObject.optLong("downloadFinishTime");
        adStatusInfo.downloadType = jSONObject.optInt("downloadType");
        adStatusInfo.downloadSize = jSONObject.optLong("downloadSize");
        adStatusInfo.downloadStatus = jSONObject.optInt("downloadStatus");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = adStatusInfo.loadFromCache;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "loadFromCache", z5);
        }
        long j6 = adStatusInfo.loadDataTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "loadDataTime", j6);
        }
        long j7 = adStatusInfo.downloadFinishTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadFinishTime", j7);
        }
        int i6 = adStatusInfo.downloadType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadType", i6);
        }
        long j8 = adStatusInfo.downloadSize;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadSize", j8);
        }
        int i7 = adStatusInfo.downloadStatus;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadStatus", i7);
        }
        return jSONObject;
    }
}
