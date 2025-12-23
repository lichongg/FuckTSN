package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ft implements com.kwad.sdk.core.d<ImageLoaderInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        a2(imageLoaderInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        return b2(imageLoaderInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        imageLoaderInfo.totalCount = jSONObject.optInt("total_count");
        imageLoaderInfo.failedCount = jSONObject.optInt("failed_count");
        imageLoaderInfo.successCount = jSONObject.optInt("success_count");
        imageLoaderInfo.duration = jSONObject.optDouble("duration");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = imageLoaderInfo.totalCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "total_count", i6);
        }
        int i7 = imageLoaderInfo.failedCount;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "failed_count", i7);
        }
        int i8 = imageLoaderInfo.successCount;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "success_count", i8);
        }
        double d6 = imageLoaderInfo.duration;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "duration", d6);
        }
        return jSONObject;
    }
}
