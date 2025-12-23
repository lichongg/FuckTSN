package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ke implements com.kwad.sdk.core.d<SplashExtraDataImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        a2(splashExtraDataImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        return b2(splashExtraDataImpl, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashExtraDataImpl.disableShake = jSONObject.optBoolean("disableShake");
        splashExtraDataImpl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashExtraDataImpl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = splashExtraDataImpl.disableShake;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableShake", z5);
        }
        boolean z6 = splashExtraDataImpl.disableRotate;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableRotate", z6);
        }
        boolean z7 = splashExtraDataImpl.disableSlide;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableSlide", z7);
        }
        return jSONObject;
    }
}
