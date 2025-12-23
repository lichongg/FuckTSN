package com.bytedance.j.xt.tl;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class c {
    public static long d(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static JSONObject e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", j(context));
            jSONObject.put("inner_free", i());
            jSONObject.put("inner_total", a());
            jSONObject.put("sdcard_app_used", b(context));
            jSONObject.put("sdcard_free", g());
            jSONObject.put("sdcard_total", h());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static boolean f() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long k(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long a() {
        try {
            return d(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long b(Context context) {
        File j6;
        try {
            if (f() && (j6 = xt.j(context, null)) != null) {
                return c(j6.getParentFile());
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long c(File file) {
        long length;
        File[] listFiles = file.listFiles();
        long j6 = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = c(file2);
            } else {
                length = file2.length();
            }
            j6 += length;
        }
        return j6;
    }

    private static long g() {
        try {
            if (f()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long h() {
        try {
            if (f()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long i() {
        try {
            return k(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long j(Context context) {
        try {
            return c(xt.j(context).getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }
}
