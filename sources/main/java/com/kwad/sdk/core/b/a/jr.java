package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jr implements com.kwad.sdk.core.d<AdMatrixInfo.ShakeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        a2(shakeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        return b2(shakeInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shakeInfo.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(shakeInfo.title)) {
            shakeInfo.title = "";
        }
        shakeInfo.subtitle = jSONObject.optString(MediaFormat.KEY_SUBTITLE);
        if (obj.toString().equals(shakeInfo.subtitle)) {
            shakeInfo.subtitle = "";
        }
        shakeInfo.acceleration = jSONObject.optInt("acceleration");
        shakeInfo.clickDisabled = jSONObject.optBoolean("clickDisabled");
        shakeInfo.componentIndex = jSONObject.optInt("componentIndex");
        shakeInfo.enable = jSONObject.optBoolean("enable");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = shakeInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", shakeInfo.title);
        }
        String str2 = shakeInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_SUBTITLE, shakeInfo.subtitle);
        }
        int i6 = shakeInfo.acceleration;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "acceleration", i6);
        }
        boolean z5 = shakeInfo.clickDisabled;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickDisabled", z5);
        }
        int i7 = shakeInfo.componentIndex;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "componentIndex", i7);
        }
        boolean z6 = shakeInfo.enable;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enable", z6);
        }
        return jSONObject;
    }
}
