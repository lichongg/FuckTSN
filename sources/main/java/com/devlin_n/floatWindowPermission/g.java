package com.devlin_n.floatWindowPermission;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f32282a = "RomUtils";

    public static String g(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            return readLine;
        } catch (IOException unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public static boolean a() {
        String str = Build.MANUFACTURER;
        return str.contains("QiKU") || str.contains("360");
    }

    public static boolean b() {
        return Build.MANUFACTURER.contains("HUAWEI");
    }

    public static boolean c() {
        String g6 = g("ro.build.display.id");
        if (TextUtils.isEmpty(g6)) {
            return false;
        }
        return g6.contains("flyme") || g6.toLowerCase().contains("flyme");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(g("ro.miui.ui.version.name"));
    }

    public static double e() {
        try {
            String g6 = g("ro.build.version.emui");
            return Double.parseDouble(g6.substring(g6.indexOf("_") + 1));
        } catch (Exception e6) {
            e6.printStackTrace();
            return 4.0d;
        }
    }

    public static int f() {
        String g6 = g("ro.miui.ui.version.name");
        if (g6 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(g6.substring(1));
        } catch (Exception unused) {
            return -1;
        }
    }
}
