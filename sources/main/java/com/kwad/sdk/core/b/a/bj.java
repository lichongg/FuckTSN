package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.au;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bj implements com.kwad.sdk.core.d<au.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(au.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(au.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(au.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adT = jSONObject.optDouble(NotificationCompat.CATEGORY_PROGRESS);
        aVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        aVar.totalBytes = jSONObject.optLong("totalBytes");
        aVar.soFarBytes = jSONObject.optLong("soFarBytes");
        aVar.adU = jSONObject.optDouble("realProgress");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(au.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d6 = aVar.adT;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, d6);
        }
        int i6 = aVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        long j6 = aVar.totalBytes;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", j6);
        }
        long j7 = aVar.soFarBytes;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", j7);
        }
        double d7 = aVar.adU;
        if (d7 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", d7);
        }
        return jSONObject;
    }
}
