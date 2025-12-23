package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hk implements com.kwad.sdk.core.d<NativeAdExtraDataImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        a2(nativeAdExtraDataImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        return b2(nativeAdExtraDataImpl, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdExtraDataImpl.enableShake = jSONObject.optBoolean("enableShake");
        nativeAdExtraDataImpl.enableRotate = jSONObject.optBoolean("enableRotate");
        nativeAdExtraDataImpl.showLiveStatus = jSONObject.optInt("showLiveStatus");
        nativeAdExtraDataImpl.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = nativeAdExtraDataImpl.enableShake;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableShake", z5);
        }
        boolean z6 = nativeAdExtraDataImpl.enableRotate;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableRotate", z6);
        }
        int i6 = nativeAdExtraDataImpl.showLiveStatus;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLiveStatus", i6);
        }
        int i7 = nativeAdExtraDataImpl.showLiveStyle;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLiveStyle", i7);
        }
        return jSONObject;
    }
}
