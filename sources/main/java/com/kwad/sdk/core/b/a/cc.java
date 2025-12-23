package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cc implements com.kwad.sdk.core.d<AdMatrixInfo.BottomBannerInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        a2(bottomBannerInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        return b2(bottomBannerInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bottomBannerInfo.bannerSizeType = jSONObject.optInt("bannerSizeType");
        bottomBannerInfo.bannerAdType = jSONObject.optInt("bannerAdType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.BottomBannerInfo bottomBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = bottomBannerInfo.bannerSizeType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bannerSizeType", i6);
        }
        int i7 = bottomBannerInfo.bannerAdType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bannerAdType", i7);
        }
        return jSONObject;
    }
}
