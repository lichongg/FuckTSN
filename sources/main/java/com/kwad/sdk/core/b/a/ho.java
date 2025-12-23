package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ho implements com.kwad.sdk.core.d<StatusInfo.NativeAdStyleControl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        a2(nativeAdStyleControl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        return b2(nativeAdStyleControl, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdStyleControl.enableShake = jSONObject.optBoolean("enableShake");
        nativeAdStyleControl.enableRotate = jSONObject.optBoolean("enableRotate");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = nativeAdStyleControl.enableShake;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableShake", z5);
        }
        boolean z6 = nativeAdStyleControl.enableRotate;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableRotate", z6);
        }
        return jSONObject;
    }
}
