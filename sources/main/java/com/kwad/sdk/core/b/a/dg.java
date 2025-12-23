package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class dg implements com.kwad.sdk.core.d<AdInfo.CutRuleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        a2(cutRuleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        return b2(cutRuleInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cutRuleInfo.picHeight = jSONObject.optInt("picHeight");
        cutRuleInfo.viewTopMargin = jSONObject.optInt("viewTopMargin");
        cutRuleInfo.safeAreaHeight = jSONObject.optInt("safeAreaHeight");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = cutRuleInfo.picHeight;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "picHeight", i6);
        }
        int i7 = cutRuleInfo.viewTopMargin;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewTopMargin", i7);
        }
        int i8 = cutRuleInfo.safeAreaHeight;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "safeAreaHeight", i8);
        }
        return jSONObject;
    }
}
