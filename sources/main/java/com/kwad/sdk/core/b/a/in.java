package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class in implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        a2(playDetailInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        return b2(playDetailInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playDetailInfo.type = jSONObject.optInt("type");
        AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo = new AdStyleInfo.PlayDetailInfo.DetailWebCardInfo();
        playDetailInfo.detailWebCardInfo = detailWebCardInfo;
        detailWebCardInfo.parseJson(jSONObject.optJSONObject("detailWebCardInfo"));
        AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo = new AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo();
        playDetailInfo.detailTopToolBarInfo = detailTopToolBarInfo;
        detailTopToolBarInfo.parseJson(jSONObject.optJSONObject("detailTopToolBarInfo"));
        AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo = new AdStyleInfo.PlayDetailInfo.ActionBarInfo();
        playDetailInfo.actionBarInfo = actionBarInfo;
        actionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo = new AdStyleInfo.PlayDetailInfo.PatchAdInfo();
        playDetailInfo.patchAdInfo = patchAdInfo;
        patchAdInfo.parseJson(jSONObject.optJSONObject("patchAdInfo"));
        AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo = new AdStyleInfo.PlayDetailInfo.DetailCommonInfo();
        playDetailInfo.detailCommonInfo = detailCommonInfo;
        detailCommonInfo.parseJson(jSONObject.optJSONObject("detailCommonInfo"));
        AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo = new AdStyleInfo.PlayDetailInfo.DrawAdInfo();
        playDetailInfo.drawAdInfo = drawAdInfo;
        drawAdInfo.parseJson(jSONObject.optJSONObject("drawAdInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = playDetailInfo.type;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i6);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "detailWebCardInfo", playDetailInfo.detailWebCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "detailTopToolBarInfo", playDetailInfo.detailTopToolBarInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "actionBarInfo", playDetailInfo.actionBarInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "patchAdInfo", playDetailInfo.patchAdInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "detailCommonInfo", playDetailInfo.detailCommonInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "drawAdInfo", playDetailInfo.drawAdInfo);
        return jSONObject;
    }
}
