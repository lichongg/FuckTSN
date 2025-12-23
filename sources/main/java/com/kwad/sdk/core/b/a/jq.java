package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jq implements com.kwad.sdk.core.d<SceneImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SceneImpl sceneImpl, JSONObject jSONObject) {
        a2(sceneImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SceneImpl sceneImpl, JSONObject jSONObject) {
        return b2(sceneImpl, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        URLPackage uRLPackage = new URLPackage();
        sceneImpl.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        sceneImpl.posId = jSONObject.optLong("posId");
        sceneImpl.entryScene = jSONObject.optLong("entryScene");
        sceneImpl.adNum = jSONObject.optInt("adNum");
        sceneImpl.action = jSONObject.optInt(com.umeng.ccg.a.f41544t);
        sceneImpl.width = jSONObject.optInt("width");
        sceneImpl.height = jSONObject.optInt("height");
        sceneImpl.adStyle = jSONObject.optInt("adStyle");
        sceneImpl.screenOrientation = jSONObject.optInt("screenOrientation");
        AdLabelImpl adLabelImpl = new AdLabelImpl();
        sceneImpl.mKsAdLabel = adLabelImpl;
        adLabelImpl.parseJson(jSONObject.optJSONObject("mKsAdLabel"));
        SplashExtraDataImpl splashExtraDataImpl = new SplashExtraDataImpl();
        sceneImpl.splashExtraData = splashExtraDataImpl;
        splashExtraDataImpl.parseJson(jSONObject.optJSONObject("splashExtraData"));
        NativeAdExtraDataImpl nativeAdExtraDataImpl = new NativeAdExtraDataImpl();
        sceneImpl.nativeAdExtraData = nativeAdExtraDataImpl;
        nativeAdExtraDataImpl.parseJson(jSONObject.optJSONObject("nativeAdExtraData"));
        sceneImpl.promoteId = jSONObject.optString("promoteId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(sceneImpl.promoteId)) {
            sceneImpl.promoteId = "";
        }
        sceneImpl.comment = jSONObject.optString("comment");
        if (obj.toString().equals(sceneImpl.comment)) {
            sceneImpl.comment = "";
        }
        sceneImpl.userCommRateBuying = jSONObject.optLong("userCommRateBuying");
        sceneImpl.userCommRateSharing = jSONObject.optLong("userCommRateSharing");
        sceneImpl.backUrl = jSONObject.optString("backUrl");
        if (obj.toString().equals(sceneImpl.backUrl)) {
            sceneImpl.backUrl = "";
        }
        sceneImpl.bidResponse = jSONObject.optString("bidResponse");
        if (obj.toString().equals(sceneImpl.bidResponse)) {
            sceneImpl.bidResponse = "";
        }
        sceneImpl.bidResponseV2 = jSONObject.optString("bidResponseV2");
        if (obj.toString().equals(sceneImpl.bidResponseV2)) {
            sceneImpl.bidResponseV2 = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "urlPackage", sceneImpl.urlPackage);
        long j6 = sceneImpl.posId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", j6);
        }
        long j7 = sceneImpl.entryScene;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryScene", j7);
        }
        int i6 = sceneImpl.adNum;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adNum", i6);
        }
        int i7 = sceneImpl.action;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.ccg.a.f41544t, i7);
        }
        int i8 = sceneImpl.width;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", i8);
        }
        int i9 = sceneImpl.height;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", i9);
        }
        int i10 = sceneImpl.adStyle;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", i10);
        }
        int i11 = sceneImpl.screenOrientation;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenOrientation", i11);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mKsAdLabel", sceneImpl.mKsAdLabel);
        com.kwad.sdk.utils.aa.a(jSONObject, "splashExtraData", sceneImpl.splashExtraData);
        com.kwad.sdk.utils.aa.a(jSONObject, "nativeAdExtraData", sceneImpl.nativeAdExtraData);
        String str = sceneImpl.promoteId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "promoteId", sceneImpl.promoteId);
        }
        String str2 = sceneImpl.comment;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "comment", sceneImpl.comment);
        }
        long j8 = sceneImpl.userCommRateBuying;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userCommRateBuying", j8);
        }
        long j9 = sceneImpl.userCommRateSharing;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userCommRateSharing", j9);
        }
        String str3 = sceneImpl.backUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "backUrl", sceneImpl.backUrl);
        }
        String str4 = sceneImpl.bidResponse;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bidResponse", sceneImpl.bidResponse);
        }
        String str5 = sceneImpl.bidResponseV2;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bidResponseV2", sceneImpl.bidResponseV2);
        }
        return jSONObject;
    }
}
