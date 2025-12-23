package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.AdLabelImpl;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aa implements com.kwad.sdk.core.d<AdLabelImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        a2(adLabelImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        return b2(adLabelImpl, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLabelImpl.thirdAge = jSONObject.optInt("thirdAge");
        adLabelImpl.thirdGender = jSONObject.optInt("thirdGender");
        adLabelImpl.thirdInterest = jSONObject.optString("thirdInterest");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adLabelImpl.thirdInterest)) {
            adLabelImpl.thirdInterest = "";
        }
        adLabelImpl.prevTitle = jSONObject.optString("prevTitle");
        if (obj.toString().equals(adLabelImpl.prevTitle)) {
            adLabelImpl.prevTitle = "";
        }
        adLabelImpl.postTitle = jSONObject.optString("postTitle");
        if (obj.toString().equals(adLabelImpl.postTitle)) {
            adLabelImpl.postTitle = "";
        }
        adLabelImpl.historyTitle = jSONObject.optString("historyTitle");
        if (obj.toString().equals(adLabelImpl.historyTitle)) {
            adLabelImpl.historyTitle = "";
        }
        adLabelImpl.channel = jSONObject.optString("channel");
        if (obj.toString().equals(adLabelImpl.channel)) {
            adLabelImpl.channel = "";
        }
        adLabelImpl.cpmBidFloor = jSONObject.optLong("cpmBidFloor");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = adLabelImpl.thirdAge;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdAge", i6);
        }
        int i7 = adLabelImpl.thirdGender;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdGender", i7);
        }
        String str = adLabelImpl.thirdInterest;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdInterest", adLabelImpl.thirdInterest);
        }
        String str2 = adLabelImpl.prevTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "prevTitle", adLabelImpl.prevTitle);
        }
        String str3 = adLabelImpl.postTitle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "postTitle", adLabelImpl.postTitle);
        }
        String str4 = adLabelImpl.historyTitle;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "historyTitle", adLabelImpl.historyTitle);
        }
        String str5 = adLabelImpl.channel;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "channel", adLabelImpl.channel);
        }
        long j6 = adLabelImpl.cpmBidFloor;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cpmBidFloor", j6);
        }
        return jSONObject;
    }
}
