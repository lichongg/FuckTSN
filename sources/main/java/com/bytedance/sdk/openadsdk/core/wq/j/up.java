package com.bytedance.sdk.openadsdk.core.wq.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static Boolean f31296j;

    private static boolean j() {
        if (f31296j == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant$RitScenes");
                f31296j = Boolean.TRUE;
            } catch (Throwable unused) {
                f31296j = Boolean.FALSE;
            }
        }
        return f31296j.booleanValue();
    }

    public static String j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return "game_more_kllkrtunities".equalsIgnoreCase(str) ? j(str) : str;
        }
        if (j()) {
            try {
                if (obj instanceof TTAdConstant.RitScenes) {
                    return ((TTAdConstant.RitScenes) obj).getScenesName();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }
}
