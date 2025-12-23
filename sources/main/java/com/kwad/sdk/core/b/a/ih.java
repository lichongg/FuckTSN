package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PageInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ih implements com.kwad.sdk.core.d<PageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PageInfo pageInfo, JSONObject jSONObject) {
        a2(pageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PageInfo pageInfo, JSONObject jSONObject) {
        return b2(pageInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt("pageType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = pageInfo.pageType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageType", i6);
        }
        return jSONObject;
    }
}
