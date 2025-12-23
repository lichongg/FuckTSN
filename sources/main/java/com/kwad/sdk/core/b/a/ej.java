package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ej implements com.kwad.sdk.core.d<FeedErrorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        a2(feedErrorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        return b2(feedErrorInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedErrorInfo.materialType = jSONObject.optLong("material_type");
        feedErrorInfo.width = jSONObject.optLong("width");
        feedErrorInfo.feedType = jSONObject.optLong("feed_type");
        feedErrorInfo.errorType = jSONObject.optLong("error_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = feedErrorInfo.materialType;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", j6);
        }
        long j7 = feedErrorInfo.width;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", j7);
        }
        long j8 = feedErrorInfo.feedType;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "feed_type", j8);
        }
        long j9 = feedErrorInfo.errorType;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_type", j9);
        }
        return jSONObject;
    }
}
