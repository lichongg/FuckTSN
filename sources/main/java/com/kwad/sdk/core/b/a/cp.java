package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cp implements com.kwad.sdk.core.d<AdInfo.ComplianceInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        a2(complianceInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        return b2(complianceInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        complianceInfo.materialJumpType = jSONObject.optInt("materialJumpType");
        complianceInfo.actionBarType = jSONObject.optInt("actionBarType");
        complianceInfo.describeBarType = jSONObject.optInt("describeBarType");
        complianceInfo.titleBarTextSwitch = jSONObject.optInt("titleBarTextSwitch");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = complianceInfo.materialJumpType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "materialJumpType", i6);
        }
        int i7 = complianceInfo.actionBarType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionBarType", i7);
        }
        int i8 = complianceInfo.describeBarType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "describeBarType", i8);
        }
        int i9 = complianceInfo.titleBarTextSwitch;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarTextSwitch", i9);
        }
        return jSONObject;
    }
}
