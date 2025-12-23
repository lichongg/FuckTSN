package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ba implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        a2(adWebCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        return b2(adWebCardInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        adWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        adWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adWebCardInfo.cardUrl)) {
            adWebCardInfo.cardUrl = "";
        }
        adWebCardInfo.cardData = jSONObject.optString("cardData");
        if (obj.toString().equals(adWebCardInfo.cardData)) {
            adWebCardInfo.cardData = "";
        }
        adWebCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        adWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        adWebCardInfo.cardDelayTime = jSONObject.optLong("cardDelayTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = adWebCardInfo.typeLandscape;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typeLandscape", j6);
        }
        long j7 = adWebCardInfo.typePortrait;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typePortrait", j7);
        }
        String str = adWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
        }
        String str2 = adWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardData", adWebCardInfo.cardData);
        }
        int i6 = adWebCardInfo.cardShowPlayCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardShowPlayCount", i6);
        }
        long j8 = adWebCardInfo.cardShowTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardShowTime", j8);
        }
        long j9 = adWebCardInfo.cardDelayTime;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardDelayTime", j9);
        }
        return jSONObject;
    }
}
