package com.bytedance.sdk.openadsdk.api.plugin.cw;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.security.SecureRandom;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String j6 = j();
        String j7 = j(j6, 32);
        String xt = xt();
        return 3 + j6 + xt + ((j7 == null || xt == null) ? null : j.j(str, xt, j7));
    }

    public static String xt(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String j6 = j(str.substring(1, 33), 32);
        String substring = str.substring(33, 49);
        return (substring == null || j6 == null) ? str : j.xt(str.substring(49), substring, j6);
    }

    private static SecureRandom cw() {
        SecureRandom instanceStrong;
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
            return instanceStrong;
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public static String xt() {
        String j6 = j(8);
        if (j6 == null || j6.length() != 16) {
            return null;
        }
        return j6;
    }

    public static JSONObject j(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                try {
                    String j6 = j(jSONObject.toString());
                    if (!TextUtils.isEmpty(j6)) {
                        jSONObject2.put(CrashHianalyticsData.MESSAGE, j6);
                        jSONObject2.put("cypher", 3);
                        return jSONObject2;
                    }
                    jSONObject2.put(CrashHianalyticsData.MESSAGE, jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                    return jSONObject2;
                } catch (Throwable unused) {
                    jSONObject2.put(CrashHianalyticsData.MESSAGE, jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused2) {
            }
        }
        return jSONObject2;
    }

    public static String j() {
        String j6 = j(16);
        if (j6 == null || j6.length() != 32) {
            return null;
        }
        return j6;
    }

    public static String j(String str, int i6) {
        if (str == null || str.length() != i6) {
            return null;
        }
        int i7 = i6 / 2;
        return str.substring(i7, i6) + str.substring(0, i7);
    }

    public static String j(int i6) {
        try {
            byte[] bArr = new byte[i6];
            cw().nextBytes(bArr);
            return r.j(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
