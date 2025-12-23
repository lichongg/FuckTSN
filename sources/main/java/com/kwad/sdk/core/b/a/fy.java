package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.m;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fy implements com.kwad.sdk.core.d<m.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(m.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(m.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        bVar.progress = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.acv = jSONObject.optInt("realProgress");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = bVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        int i7 = bVar.progress;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, i7);
        }
        long j6 = bVar.soFarBytes;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", j6);
        }
        long j7 = bVar.totalBytes;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", j7);
        }
        int i8 = bVar.acv;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", i8);
        }
        return jSONObject;
    }
}
