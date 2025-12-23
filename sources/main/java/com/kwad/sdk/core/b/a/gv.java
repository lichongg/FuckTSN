package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gv implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        a2(liveReservationPlayEndInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        return b2(liveReservationPlayEndInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveReservationPlayEndInfo.detailBtnTitle = jSONObject.optString("detailBtnTitle", new String("查看详情"));
        liveReservationPlayEndInfo.reservationBtnTitle = jSONObject.optString("reservationBtnTitle", new String("立即预约"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "detailBtnTitle", liveReservationPlayEndInfo.detailBtnTitle);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "reservationBtnTitle", liveReservationPlayEndInfo.reservationBtnTitle);
        return jSONObject;
    }
}
