package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.ActionBarInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        a2(actionBarInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        return b2(actionBarInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfo.translateBtnShowTime = jSONObject.optLong("translateBtnShowTime");
        actionBarInfo.lightBtnShowTime = jSONObject.optLong("lightBtnShowTime");
        actionBarInfo.cardShowTime = jSONObject.optLong("cardShowTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = actionBarInfo.translateBtnShowTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "translateBtnShowTime", j6);
        }
        long j7 = actionBarInfo.lightBtnShowTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lightBtnShowTime", j7);
        }
        long j8 = actionBarInfo.cardShowTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardShowTime", j8);
        }
        return jSONObject;
    }
}
