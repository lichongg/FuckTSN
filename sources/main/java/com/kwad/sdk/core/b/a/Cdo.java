package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* renamed from: com.kwad.sdk.core.b.a.do, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class Cdo implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        a2(detailWebCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        return b2(detailWebCardInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailWebCardInfo.style = jSONObject.optInt(ResIdentify.RES_TYPE_STYLE);
        detailWebCardInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
        detailWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        detailWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        detailWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(detailWebCardInfo.cardUrl)) {
            detailWebCardInfo.cardUrl = "";
        }
        detailWebCardInfo.cardData = jSONObject.optString("cardData");
        if (obj.toString().equals(detailWebCardInfo.cardData)) {
            detailWebCardInfo.cardData = "";
        }
        detailWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        detailWebCardInfo.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = detailWebCardInfo.style;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, ResIdentify.RES_TYPE_STYLE, i6);
        }
        long j6 = detailWebCardInfo.maxTimeOut;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxTimeOut", j6);
        }
        long j7 = detailWebCardInfo.typeLandscape;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typeLandscape", j7);
        }
        long j8 = detailWebCardInfo.typePortrait;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typePortrait", j8);
        }
        String str = detailWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
        }
        String str2 = detailWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardData", detailWebCardInfo.cardData);
        }
        long j9 = detailWebCardInfo.cardShowTime;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardShowTime", j9);
        }
        int i7 = detailWebCardInfo.cardType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardType", i7);
        }
        return jSONObject;
    }
}
