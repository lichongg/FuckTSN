package com.kwad.components.ad.reward.j;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static void a(boolean z5, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        boolean a6 = com.kwad.components.core.t.b.sY().a(adTemplate, jSONObject, bVar);
        if (z5 && a6) {
            c.e(e.ef(adTemplate) == 2, adTemplate);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.b(adTemplate, str, str2, null);
        com.kwad.sdk.core.adlog.c.a(adTemplate, bVar, jSONObject);
    }

    public static void a(final Context context, AdTemplate adTemplate, String str, final int i6, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.b df = new com.kwad.sdk.core.adlog.c.b().df(18);
        df.b(adTemplate, str, null, new com.kwad.sdk.g.a<AdTrackLog>() { // from class: com.kwad.components.ad.reward.j.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(AdTrackLog adTrackLog) {
                adTrackLog.rewardDetailStatusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
                adTrackLog.rewardDetailCallPositionY = i6;
            }
        });
        com.kwad.sdk.core.adlog.c.d(adTemplate, jSONObject, df);
    }
}
