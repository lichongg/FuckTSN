package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bb implements com.kwad.sdk.core.d<AdInfo.AdvertiserInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        a2(advertiserInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        return b2(advertiserInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        advertiserInfo.userId = jSONObject.optLong("userId");
        advertiserInfo.userName = jSONObject.optString("userName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(advertiserInfo.userName)) {
            advertiserInfo.userName = "";
        }
        advertiserInfo.rawUserName = jSONObject.optString("rawUserName");
        if (obj.toString().equals(advertiserInfo.rawUserName)) {
            advertiserInfo.rawUserName = "";
        }
        advertiserInfo.userGender = jSONObject.optString("userGender");
        if (obj.toString().equals(advertiserInfo.userGender)) {
            advertiserInfo.userGender = "";
        }
        advertiserInfo.portraitUrl = jSONObject.optString("portraitUrl");
        if (obj.toString().equals(advertiserInfo.portraitUrl)) {
            advertiserInfo.portraitUrl = "";
        }
        advertiserInfo.adAuthorText = jSONObject.optString("adAuthorText");
        if (obj.toString().equals(advertiserInfo.adAuthorText)) {
            advertiserInfo.adAuthorText = "";
        }
        advertiserInfo.authorIconGuide = jSONObject.optString("authorIconGuide");
        if (obj.toString().equals(advertiserInfo.authorIconGuide)) {
            advertiserInfo.authorIconGuide = "";
        }
        advertiserInfo.followed = jSONObject.optBoolean("followed");
        advertiserInfo.fansCount = jSONObject.optInt("fansCount");
        advertiserInfo.brief = jSONObject.optString("brief");
        if (obj.toString().equals(advertiserInfo.brief)) {
            advertiserInfo.brief = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = advertiserInfo.userId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userId", j6);
        }
        String str = advertiserInfo.userName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userName", advertiserInfo.userName);
        }
        String str2 = advertiserInfo.rawUserName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rawUserName", advertiserInfo.rawUserName);
        }
        String str3 = advertiserInfo.userGender;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userGender", advertiserInfo.userGender);
        }
        String str4 = advertiserInfo.portraitUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "portraitUrl", advertiserInfo.portraitUrl);
        }
        String str5 = advertiserInfo.adAuthorText;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAuthorText", advertiserInfo.adAuthorText);
        }
        String str6 = advertiserInfo.authorIconGuide;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorIconGuide", advertiserInfo.authorIconGuide);
        }
        boolean z5 = advertiserInfo.followed;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "followed", z5);
        }
        int i6 = advertiserInfo.fansCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fansCount", i6);
        }
        String str7 = advertiserInfo.brief;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "brief", advertiserInfo.brief);
        }
        return jSONObject;
    }
}
