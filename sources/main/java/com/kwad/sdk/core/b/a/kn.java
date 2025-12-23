package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kn implements com.kwad.sdk.core.d<StatusInfo.SplashStyleControl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        a2(splashStyleControl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        return b2(splashStyleControl, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashStyleControl.disableShake = jSONObject.optBoolean("disableShake");
        splashStyleControl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashStyleControl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = splashStyleControl.disableShake;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableShake", z5);
        }
        boolean z6 = splashStyleControl.disableRotate;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableRotate", z6);
        }
        boolean z7 = splashStyleControl.disableSlide;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableSlide", z7);
        }
        return jSONObject;
    }
}
