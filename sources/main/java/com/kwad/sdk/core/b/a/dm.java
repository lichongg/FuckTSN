package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class dm implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailCommonInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        a2(detailCommonInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        return b2(detailCommonInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailCommonInfo.middleEndcardShowTime = jSONObject.optInt("middleEndcardShowTime");
        detailCommonInfo.rewardFullClickSwitch = jSONObject.optInt("rewardFullClickSwitch");
        detailCommonInfo.rewardInteractionType = jSONObject.optInt("rewardInteractionType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = detailCommonInfo.middleEndcardShowTime;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "middleEndcardShowTime", i6);
        }
        int i7 = detailCommonInfo.rewardFullClickSwitch;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardFullClickSwitch", i7);
        }
        int i8 = detailCommonInfo.rewardInteractionType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardInteractionType", i8);
        }
        return jSONObject;
    }
}
