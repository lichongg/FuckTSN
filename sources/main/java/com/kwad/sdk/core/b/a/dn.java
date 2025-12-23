package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class dn implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        a2(detailTopToolBarInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        return b2(detailTopToolBarInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailTopToolBarInfo.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
        detailTopToolBarInfo.callButtonDescription = jSONObject.optString("callButtonDescription");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(detailTopToolBarInfo.callButtonDescription)) {
            detailTopToolBarInfo.callButtonDescription = "";
        }
        detailTopToolBarInfo.rewardIconUrl = jSONObject.optString("rewardIconUrl");
        if (obj.toString().equals(detailTopToolBarInfo.rewardIconUrl)) {
            detailTopToolBarInfo.rewardIconUrl = "";
        }
        detailTopToolBarInfo.rewardCallDescription = jSONObject.optString("rewardCallDescription");
        if (obj.toString().equals(detailTopToolBarInfo.rewardCallDescription)) {
            detailTopToolBarInfo.rewardCallDescription = "";
        }
        detailTopToolBarInfo.style = jSONObject.optInt(ResIdentify.RES_TYPE_STYLE);
        detailTopToolBarInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = detailTopToolBarInfo.callButtonShowTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callButtonShowTime", j6);
        }
        String str = detailTopToolBarInfo.callButtonDescription;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callButtonDescription", detailTopToolBarInfo.callButtonDescription);
        }
        String str2 = detailTopToolBarInfo.rewardIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardIconUrl", detailTopToolBarInfo.rewardIconUrl);
        }
        String str3 = detailTopToolBarInfo.rewardCallDescription;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardCallDescription", detailTopToolBarInfo.rewardCallDescription);
        }
        int i6 = detailTopToolBarInfo.style;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, ResIdentify.RES_TYPE_STYLE, i6);
        }
        long j7 = detailTopToolBarInfo.maxTimeOut;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxTimeOut", j7);
        }
        return jSONObject;
    }
}
