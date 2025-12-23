package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l implements com.kwad.sdk.core.d<AdStyleInfo.AdBrowseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        a2(adBrowseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        return b2(adBrowseInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBrowseInfo.enableAdBrowse = jSONObject.optInt("enableAdBrowse");
        adBrowseInfo.adBrowseDuration = jSONObject.optInt("adBrowseDuration");
        adBrowseInfo.rewardDescription = jSONObject.optString("rewardDescription");
        if (JSONObject.NULL.toString().equals(adBrowseInfo.rewardDescription)) {
            adBrowseInfo.rewardDescription = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = adBrowseInfo.enableAdBrowse;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableAdBrowse", i6);
        }
        int i7 = adBrowseInfo.adBrowseDuration;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adBrowseDuration", i7);
        }
        String str = adBrowseInfo.rewardDescription;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardDescription", adBrowseInfo.rewardDescription);
        }
        return jSONObject;
    }
}
