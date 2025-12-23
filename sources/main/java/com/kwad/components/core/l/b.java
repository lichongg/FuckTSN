package com.kwad.components.core.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static boolean av(Context context) {
        boolean z5;
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_local_ad_force_active", 0);
        a aVar = new a();
        if (sharedPreferences.contains("ksadsdk_local_ad_force_active_data")) {
            String string = sharedPreferences.getString("ksadsdk_local_ad_force_active_data", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    aVar.parseJson(new JSONObject(string));
                } catch (Exception e6) {
                    c.printStackTraceOnly(e6);
                }
            }
            z5 = aVar.k(e.FD(), e.FE());
            c.d("LocalAdForceActiveHelper", "addCount contains success: " + z5);
        } else {
            c.d("LocalAdForceActiveHelper", "addCount not contains");
            aVar.qr();
            z5 = true;
        }
        if (z5) {
            sharedPreferences.edit().putString("ksadsdk_local_ad_force_active_data", aVar.toJson().toString()).apply();
        }
        return z5;
    }
}
