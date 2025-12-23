package com.bytedance.j.xt.tl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import java.io.File;

/* loaded from: D:\Downloads\app\classes3.dex */
public class l {
    public static File b(@NonNull Context context) {
        return new File(a(context), "CrashLogJava");
    }

    public static File d(@NonNull Context context) {
        return new File(a(context), "crash_history");
    }

    @SuppressLint({"SdCardPath"})
    private static String a(@NonNull Context context) {
        String str;
        try {
            if (xt.j(context) != null) {
                str = xt.j(context).getPath();
            } else {
                File j6 = xt.j(context, "/data/data/" + context.getPackageName() + "/files/", 0);
                if (j6 != null) {
                    str = j6.getPath();
                } else {
                    str = null;
                }
            }
            if (str != null) {
                return str;
            }
            return "/sdcard/";
        } catch (Exception e6) {
            vl.j(e6);
            return "/sdcard/";
        }
    }

    public static String c() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static String e() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }
}
