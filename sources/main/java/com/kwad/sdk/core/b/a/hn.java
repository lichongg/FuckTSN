package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hn implements com.kwad.sdk.core.d<AdInfo.NativeAdShakeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.NativeAdShakeInfo nativeAdShakeInfo, JSONObject jSONObject) {
        a2(nativeAdShakeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.NativeAdShakeInfo nativeAdShakeInfo, JSONObject jSONObject) {
        return b2(nativeAdShakeInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.NativeAdShakeInfo nativeAdShakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdShakeInfo.acceleration = jSONObject.optInt("acceleration");
        nativeAdShakeInfo.enableShake = jSONObject.optBoolean("enableShake");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.NativeAdShakeInfo nativeAdShakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = nativeAdShakeInfo.acceleration;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "acceleration", i6);
        }
        boolean z5 = nativeAdShakeInfo.enableShake;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableShake", z5);
        }
        return jSONObject;
    }
}
