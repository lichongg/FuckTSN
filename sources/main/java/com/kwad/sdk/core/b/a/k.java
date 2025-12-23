package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.adbit.AdBid;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k implements com.kwad.sdk.core.d<AdBid> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdBid adBid, JSONObject jSONObject) {
        a2(adBid, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdBid adBid, JSONObject jSONObject) {
        return b2(adBid, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBid.creativeId = jSONObject.optLong("creativeId");
        adBid.ecpm = jSONObject.optLong("ecpm");
        adBid.bidEcpm = jSONObject.optInt("bidEcpm");
        adBid.winNoticeUrl = jSONObject.optString("winNoticeUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adBid.winNoticeUrl)) {
            adBid.winNoticeUrl = "";
        }
        adBid.materialId = jSONObject.optString("materialId");
        if (obj.toString().equals(adBid.materialId)) {
            adBid.materialId = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = adBid.creativeId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", j6);
        }
        long j7 = adBid.ecpm;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ecpm", j7);
        }
        int i6 = adBid.bidEcpm;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bidEcpm", i6);
        }
        String str = adBid.winNoticeUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "winNoticeUrl", adBid.winNoticeUrl);
        }
        String str2 = adBid.materialId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "materialId", adBid.materialId);
        }
        return jSONObject;
    }
}
