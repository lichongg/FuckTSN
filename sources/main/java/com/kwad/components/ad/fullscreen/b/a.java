package com.kwad.components.ad.fullscreen.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    @Nullable
    private static b I(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e6) {
            c.printStackTraceOnly(e6);
            return null;
        }
    }

    private static void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            c.d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
        } else {
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
        }
    }

    public static void H(Context context) {
        b I = I(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (I == null) {
            I = new b(currentTimeMillis, 1);
        } else if (!I.j(currentTimeMillis)) {
            I.jC = currentTimeMillis;
            I.jD = 1;
        } else {
            I.jD++;
        }
        a(context, I);
    }

    public static boolean b(Context context, AdTemplate adTemplate) {
        boolean z5;
        b I = I(context);
        if (I != null && I.F(com.kwad.components.ad.fullscreen.a.b.da())) {
            z5 = false;
        } else {
            z5 = true;
        }
        boolean dz = com.kwad.sdk.core.response.b.b.dz(adTemplate);
        if (z5 && dz) {
            return true;
        }
        return false;
    }
}
