package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: com.bytedance.sdk.component.utils.j$j, reason: collision with other inner class name */
    static class C0419j {

        /* renamed from: j, reason: collision with root package name */
        static final Random f26886j = j.cw();
    }

    public static String cw(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String j6 = j(str.substring(1, 33), 32);
        String substring = str.substring(33, 49);
        return (substring == null || j6 == null) ? str : com.bytedance.sdk.component.up.j.xt(str.substring(49), substring, j6);
    }

    public static JSONObject j(JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : j(jSONObject.toString());
    }

    public static String xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String j6 = j();
        String j7 = j(j6, 32);
        String xt = xt();
        return 3 + j6 + xt + ((j7 == null || xt == null) ? null : com.bytedance.sdk.component.up.j.j(str, xt, j7));
    }

    public static JSONObject j(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    String xt = xt(str);
                    if (!TextUtils.isEmpty(xt)) {
                        jSONObject.put(CrashHianalyticsData.MESSAGE, xt);
                        jSONObject.put("cypher", 3);
                        return jSONObject;
                    }
                    jSONObject.put(CrashHianalyticsData.MESSAGE, str);
                    jSONObject.put("cypher", 0);
                    return jSONObject;
                } catch (Throwable unused) {
                    jSONObject.put(CrashHianalyticsData.MESSAGE, str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return jSONObject;
    }

    public static Random cw() {
        SecureRandom instanceStrong;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                instanceStrong = SecureRandom.getInstanceStrong();
                return instanceStrong;
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    public static String xt() {
        String j6 = j(8);
        if (j6 == null || j6.length() != 16) {
            return null;
        }
        return j6;
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
            C0419j.f26886j.nextBytes(bArr);
            return up.j(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
