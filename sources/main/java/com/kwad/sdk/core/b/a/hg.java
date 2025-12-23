package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hg implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        a2(merchantLiveReservationInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        return b2(merchantLiveReservationInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        merchantLiveReservationInfo.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(merchantLiveReservationInfo.title)) {
            merchantLiveReservationInfo.title = "";
        }
        merchantLiveReservationInfo.userHeadUrl = jSONObject.optString("userHeadUrl");
        if (obj.toString().equals(merchantLiveReservationInfo.userHeadUrl)) {
            merchantLiveReservationInfo.userHeadUrl = "";
        }
        merchantLiveReservationInfo.bookUserCount = jSONObject.optInt("bookUserCount");
        merchantLiveReservationInfo.liveStartTime = jSONObject.optString("liveStartTime");
        if (obj.toString().equals(merchantLiveReservationInfo.liveStartTime)) {
            merchantLiveReservationInfo.liveStartTime = "";
        }
        merchantLiveReservationInfo.displayWeakCard = jSONObject.optBoolean("displayWeakCard");
        merchantLiveReservationInfo.bookUserUrlList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("bookUserUrlList");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                merchantLiveReservationInfo.bookUserUrlList.add((String) optJSONArray.opt(i6));
            }
        }
        merchantLiveReservationInfo.displayBookCount = jSONObject.optBoolean("displayBookCount");
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = new AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo();
        merchantLiveReservationInfo.playEndCard = liveReservationPlayEndInfo;
        liveReservationPlayEndInfo.parseJson(jSONObject.optJSONObject("playEndCard"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = merchantLiveReservationInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", merchantLiveReservationInfo.title);
        }
        String str2 = merchantLiveReservationInfo.userHeadUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userHeadUrl", merchantLiveReservationInfo.userHeadUrl);
        }
        int i6 = merchantLiveReservationInfo.bookUserCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bookUserCount", i6);
        }
        String str3 = merchantLiveReservationInfo.liveStartTime;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveStartTime", merchantLiveReservationInfo.liveStartTime);
        }
        boolean z5 = merchantLiveReservationInfo.displayWeakCard;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "displayWeakCard", z5);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "bookUserUrlList", merchantLiveReservationInfo.bookUserUrlList);
        boolean z6 = merchantLiveReservationInfo.displayBookCount;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "displayBookCount", z6);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "playEndCard", merchantLiveReservationInfo.playEndCard);
        return jSONObject;
    }
}
