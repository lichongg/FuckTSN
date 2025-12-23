package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jy implements com.kwad.sdk.core.d<AdInfo.SmallAppJumpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        a2(smallAppJumpInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        return b2(smallAppJumpInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        smallAppJumpInfo.smallAppJumpUrl = jSONObject.optString("smallAppJumpUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(smallAppJumpInfo.smallAppJumpUrl)) {
            smallAppJumpInfo.smallAppJumpUrl = "";
        }
        smallAppJumpInfo.originId = jSONObject.optString("originId");
        if (obj.toString().equals(smallAppJumpInfo.originId)) {
            smallAppJumpInfo.originId = "";
        }
        smallAppJumpInfo.mediaSmallAppId = jSONObject.optString("mediaSmallAppId");
        if (obj.toString().equals(smallAppJumpInfo.mediaSmallAppId)) {
            smallAppJumpInfo.mediaSmallAppId = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = smallAppJumpInfo.smallAppJumpUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "smallAppJumpUrl", smallAppJumpInfo.smallAppJumpUrl);
        }
        String str2 = smallAppJumpInfo.originId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "originId", smallAppJumpInfo.originId);
        }
        String str3 = smallAppJumpInfo.mediaSmallAppId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mediaSmallAppId", smallAppJumpInfo.mediaSmallAppId);
        }
        return jSONObject;
    }
}
