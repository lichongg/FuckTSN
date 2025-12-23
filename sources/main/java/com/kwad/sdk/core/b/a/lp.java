package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lp implements com.kwad.sdk.core.d<AdInfo.UnDownloadRegionConf> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        a2(unDownloadRegionConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        return b2(unDownloadRegionConf, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        unDownloadRegionConf.materialJumpType = jSONObject.optInt("materialJumpType");
        unDownloadRegionConf.actionBarType = jSONObject.optInt("actionBarType");
        unDownloadRegionConf.describeBarType = jSONObject.optInt("describeBarType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = unDownloadRegionConf.materialJumpType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "materialJumpType", i6);
        }
        int i7 = unDownloadRegionConf.actionBarType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionBarType", i7);
        }
        int i8 = unDownloadRegionConf.describeBarType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "describeBarType", i8);
        }
        return jSONObject;
    }
}
