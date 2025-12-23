package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hl implements com.kwad.sdk.core.d<AdInfo.NativeAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.NativeAdInfo nativeAdInfo, JSONObject jSONObject) {
        a2(nativeAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.NativeAdInfo nativeAdInfo, JSONObject jSONObject) {
        return b2(nativeAdInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.NativeAdInfo nativeAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdInfo.NativeAdShakeInfo nativeAdShakeInfo = new AdInfo.NativeAdShakeInfo();
        nativeAdInfo.shakeInfo = nativeAdShakeInfo;
        nativeAdShakeInfo.parseJson(jSONObject.optJSONObject("shakeInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.NativeAdInfo nativeAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "shakeInfo", nativeAdInfo.shakeInfo);
        return jSONObject;
    }
}
