package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class iw implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadItem> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        a2(preLoadItem, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        return b2(preLoadItem, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong("cacheTime");
        preLoadItem.expiredTime = jSONObject.optLong("expiredTime");
        preLoadItem.preloadId = jSONObject.optString("preloadId");
        if (JSONObject.NULL.toString().equals(preLoadItem.preloadId)) {
            preLoadItem.preloadId = "";
        }
        preLoadItem.materialType = jSONObject.optInt("materialType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = preLoadItem.cacheTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheTime", j6);
        }
        long j7 = preLoadItem.expiredTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "expiredTime", j7);
        }
        String str = preLoadItem.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "preloadId", preLoadItem.preloadId);
        }
        int i6 = preLoadItem.materialType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "materialType", i6);
        }
        return jSONObject;
    }
}
