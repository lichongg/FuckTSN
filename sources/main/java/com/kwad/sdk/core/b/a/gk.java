package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.ap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gk implements com.kwad.sdk.core.d<ap.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ap.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ap.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ap.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.adT = jSONObject.optDouble(NotificationCompat.CATEGORY_PROGRESS);
        bVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.adU = jSONObject.optDouble("realProgress");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ap.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d6 = bVar.adT;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, d6);
        }
        int i6 = bVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        long j6 = bVar.totalBytes;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", j6);
        }
        long j7 = bVar.soFarBytes;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", j7);
        }
        double d7 = bVar.adU;
        if (d7 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", d7);
        }
        return jSONObject;
    }
}
