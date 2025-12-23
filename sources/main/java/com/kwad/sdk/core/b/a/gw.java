package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.ba;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gw implements com.kwad.sdk.core.d<ba.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ba.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ba.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ba.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        aVar.totalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        aVar.watchingUserCount = jSONObject.optInt("watchingUserCount");
        aVar.displayWatchingUserCount = jSONObject.optString("displayWatchingUserCount");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.displayWatchingUserCount)) {
            aVar.displayWatchingUserCount = "";
        }
        aVar.liveDuration = jSONObject.optLong("liveDuration");
        aVar.likeUserCount = jSONObject.optInt("likeUserCount");
        aVar.displayLikeUserCount = jSONObject.optString("displayLikeUserCount");
        if (obj.toString().equals(aVar.displayLikeUserCount)) {
            aVar.displayLikeUserCount = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ba.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        long j6 = aVar.totalWatchingDuration;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalWatchingDuration", j6);
        }
        int i7 = aVar.watchingUserCount;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "watchingUserCount", i7);
        }
        String str = aVar.displayWatchingUserCount;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "displayWatchingUserCount", aVar.displayWatchingUserCount);
        }
        long j7 = aVar.liveDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveDuration", j7);
        }
        int i8 = aVar.likeUserCount;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "likeUserCount", i8);
        }
        String str2 = aVar.displayLikeUserCount;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "displayLikeUserCount", aVar.displayLikeUserCount);
        }
        return jSONObject;
    }
}
