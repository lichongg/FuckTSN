package com.kwad.sdk.core.b.a;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f implements com.kwad.sdk.core.d<ActivityInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ActivityInfo activityInfo, JSONObject jSONObject) {
        a2(activityInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ActivityInfo activityInfo, JSONObject jSONObject) {
        return b2(activityInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        activityInfo.actTypeId = jSONObject.optInt("actTypeId");
        activityInfo.sceneTypeId = jSONObject.optInt("sceneTypeId");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = activityInfo.actTypeId;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actTypeId", i6);
        }
        int i7 = activityInfo.sceneTypeId;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sceneTypeId", i7);
        }
        return jSONObject;
    }
}
