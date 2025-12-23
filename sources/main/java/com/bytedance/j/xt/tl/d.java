package com.bytedance.j.xt.tl;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.j.xt.ae.xt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f24229a;

    private static String e(String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                str2 = bufferedReader.readLine();
                bufferedReader.close();
                h.a(bufferedReader);
                return str2;
            } catch (Throwable unused) {
                h.a(bufferedReader);
                return str2;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean f() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a() {
        if (!f24229a) {
            try {
                Class.forName("miui.os.Build");
                xt.f24161a = true;
                f24229a = true;
                return true;
            } catch (Exception unused) {
                f24229a = true;
            }
        }
        return xt.f24161a;
    }

    public static String b() {
        return e("ro.build.version.emui");
    }

    public static boolean d() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = b();
        }
        if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return true;
        }
        return f();
    }
}
