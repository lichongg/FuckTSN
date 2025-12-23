package com.bytedance.sdk.openadsdk.core.tj;

import android.os.Build;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class pz {
    public static int cw = 1;

    /* renamed from: j, reason: collision with root package name */
    public static int f30396j;
    public static int xt;

    public static void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("ugen_image_load_config")) == null) {
            return;
        }
        f30396j = optJSONObject.optInt("api", 0);
        xt = optJSONObject.optInt("size_limit", 0);
        cw = optJSONObject.optInt("zip_level", 1);
    }

    public static int j(int i6, int i7) {
        if (f30396j <= 0 || Build.VERSION.SDK_INT > f30396j || i6 == 0 || i7 == 0) {
            return 1;
        }
        int i8 = xt;
        if (i6 >= i8 || i7 >= i8) {
            return Math.max(1, cw);
        }
        return 1;
    }
}
