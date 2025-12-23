package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kt implements com.kwad.sdk.core.d<StatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo statusInfo, JSONObject jSONObject) {
        a2(statusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        return b2(statusInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.aIF = jSONObject.optInt("personalRecommend");
        statusInfo.aIG = jSONObject.optInt("programmaticRecommend");
        StatusInfo.SplashAdInfo splashAdInfo = new StatusInfo.SplashAdInfo();
        statusInfo.aIH = splashAdInfo;
        splashAdInfo.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        StatusInfo.NativeAdRequestInfo nativeAdRequestInfo = new StatusInfo.NativeAdRequestInfo();
        statusInfo.aII = nativeAdRequestInfo;
        nativeAdRequestInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        statusInfo.aIJ = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(optJSONArray.optJSONObject(i6));
                statusInfo.aIJ.add(fVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = statusInfo.aIF;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "personalRecommend", i6);
        }
        int i7 = statusInfo.aIG;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "programmaticRecommend", i7);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "splashAdInfo", statusInfo.aIH);
        com.kwad.sdk.utils.aa.a(jSONObject, "nativeAdInfo", statusInfo.aII);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "taskStats", statusInfo.aIJ);
        return jSONObject;
    }
}
