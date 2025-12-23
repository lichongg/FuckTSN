package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;
import xyz.adscope.common.network.cookie.db.Field;

/* loaded from: D:\Downloads\app\classes6.dex */
public class aj {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f35703b = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};

    /* renamed from: a, reason: collision with root package name */
    private Context f35704a;

    public int a() {
        try {
            for (String str : a(bi.f35793z)) {
                if (new File(str, "su").exists()) {
                    return 1;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public String c() {
        try {
            if (Build.VERSION.SDK_INT > 29) {
                return null;
            }
            return aa.a().b("su -v").replace(com.snail.antifake.deviceid.e.f37542d, "");
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b() {
        String a6;
        try {
            a6 = bh.a("ro.build.display.id");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(a6)) {
            return false;
        }
        if (a6.contains("flyme")) {
            return true;
        }
        return a6.toLowerCase().contains("flyme");
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            String a6 = a(" which su ");
            if (TextUtils.isEmpty(a6) || a6.length() <= 2) {
                jSONObject.put("0", 0);
            } else {
                jSONObject.put("0", 1);
                jSONObject.put("0-p", a6);
            }
            String a7 = a(" id ");
            if (!TextUtils.isEmpty(a7)) {
                if (a7.toLowerCase().contains("uid=0")) {
                    jSONObject.put("1", 1);
                } else {
                    jSONObject.put("1", 0);
                }
            }
            String a8 = a(" busybox df ");
            if (!TextUtils.isEmpty(a8) && !a8.contains("not found")) {
                if (a8.length() > 30) {
                    jSONObject.put("2", 1);
                } else {
                    jSONObject.put("2", 0);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int h() {
        return new File("/system/app/Superuser.apk").exists() ? 1 : 0;
    }

    public String i() {
        for (String str : f35703b) {
            if (new File(str, "magisk").exists()) {
                return str + "magisk";
            }
        }
        return "";
    }

    public String j() {
        for (String str : f35703b) {
            if (new File(str, "su").exists()) {
                return str + "su";
            }
        }
        return "";
    }

    public String k() {
        try {
            throw new Exception("");
        } catch (Exception e6) {
            for (StackTraceElement stackTraceElement : e6.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    return stackTraceElement.getClassName();
                }
            }
            return "";
        }
    }

    public aj(Context context) {
        this.f35704a = context;
    }

    public int d() {
        String a6 = aa.a().a("ro.secure");
        if (a6 != null && "0".equals(a6)) {
            return 0;
        }
        return 1;
    }

    public int e() {
        String a6 = aa.a().a("ro.debuggable");
        if (a6 != null && "0".equals(a6)) {
            return 0;
        }
        return 1;
    }

    public int f() {
        String a6 = aa.a().a("ro.adb.secure");
        if (a6 != null && "0".equals(a6)) {
            return 0;
        }
        return 1;
    }

    private String[] a(String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        try {
            str = System.getenv(Field.PATH);
        } catch (Exception unused) {
        }
        if (str != null && !"".equals(str)) {
            String[] split = str.split(":");
            int length = split.length;
            for (int i6 = 0; i6 < length; i6++) {
                String str2 = split[i6];
                if (!str2.endsWith("/")) {
                    str2 = str2 + '/';
                }
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String a(String str) {
        try {
            return aa.a().b(str).replace(com.snail.antifake.deviceid.e.f37542d, "");
        } catch (Exception unused) {
            return "";
        }
    }
}
