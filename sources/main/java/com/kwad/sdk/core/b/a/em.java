package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class em implements com.kwad.sdk.core.d<FeedPageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        a2(feedPageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        return b2(feedPageInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedPageInfo.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        feedPageInfo.loadStatus = jSONObject.optInt("load_status");
        feedPageInfo.adNum = jSONObject.optInt("ad_num");
        feedPageInfo.type = jSONObject.optInt("type");
        feedPageInfo.loadType = jSONObject.optLong("load_type");
        feedPageInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        feedPageInfo.resourceLoadDuration = jSONObject.optLong("resource_load_duration_ms");
        feedPageInfo.materialType = jSONObject.optInt("material_type");
        feedPageInfo.materialUrl = jSONObject.optString("material_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(feedPageInfo.materialUrl)) {
            feedPageInfo.materialUrl = "";
        }
        feedPageInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        feedPageInfo.renderType = jSONObject.optInt("render_type");
        feedPageInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        feedPageInfo.convertDuration = jSONObject.optLong("convert_duartion_ms");
        feedPageInfo.extMsg = jSONObject.optString("ext_msg");
        if (obj.toString().equals(feedPageInfo.extMsg)) {
            feedPageInfo.extMsg = "";
        }
        feedPageInfo.abParams = jSONObject.optString("ab_params");
        if (obj.toString().equals(feedPageInfo.abParams)) {
            feedPageInfo.abParams = "";
        }
        feedPageInfo.callbackType = jSONObject.optInt("callback_type");
        feedPageInfo.materialInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("material_info");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                FeedPageInfo.a aVar = new FeedPageInfo.a();
                aVar.parseJson(optJSONArray.optJSONObject(i6));
                feedPageInfo.materialInfoList.add(aVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = feedPageInfo.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        int i7 = feedPageInfo.loadStatus;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_status", i7);
        }
        int i8 = feedPageInfo.adNum;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_num", i8);
        }
        int i9 = feedPageInfo.type;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i9);
        }
        long j6 = feedPageInfo.loadType;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_type", j6);
        }
        long j7 = feedPageInfo.loadDataDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_data_duration_ms", j7);
        }
        long j8 = feedPageInfo.resourceLoadDuration;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "resource_load_duration_ms", j8);
        }
        int i10 = feedPageInfo.materialType;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", i10);
        }
        String str = feedPageInfo.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_url", feedPageInfo.materialUrl);
        }
        long j9 = feedPageInfo.renderDuration;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_duration_ms", j9);
        }
        int i11 = feedPageInfo.renderType;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_type", i11);
        }
        int i12 = feedPageInfo.expectedRenderType;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "expected_render_type", i12);
        }
        long j10 = feedPageInfo.convertDuration;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convert_duartion_ms", j10);
        }
        String str2 = feedPageInfo.extMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ext_msg", feedPageInfo.extMsg);
        }
        String str3 = feedPageInfo.abParams;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ab_params", feedPageInfo.abParams);
        }
        int i13 = feedPageInfo.callbackType;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callback_type", i13);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "material_info", feedPageInfo.materialInfoList);
        return jSONObject;
    }
}
