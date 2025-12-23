package com.kwai.adclient.kscommerciallogger;

import android.text.TextUtils;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static final String[] beo = {"cache_limit", "cache_num", "segment_name_top1", "segment_count_top1"};

    public static String z(JSONObject jSONObject) {
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public static boolean hM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^[a-z][a-z0-9]*(_{1}[a-z0-9]+)+$", str);
    }
}
