package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class xt {
    private static File j(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File xt(Context context) {
        return j(new File(context.getCacheDir(), "pangle_com.byted.pangle"));
    }

    public static File cw(Context context) {
        return j(new File(context.getExternalCacheDir(), "pangle_com.byted.pangle"));
    }

    public static boolean r(Context context) {
        File file = new File(context.getFilesDir(), "/pangle_p/com.byted.pangle");
        if (!file.exists()) {
            return false;
        }
        final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.xt.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                try {
                    Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                    String group = matcher.find() ? matcher.group() : "";
                    return (TextUtils.isEmpty(group) ? 0 : Integer.parseInt(group.substring(8))) > 7012;
                } catch (Exception e6) {
                    com.bytedance.sdk.openadsdk.api.m.j(e6);
                    return file2.getName().matches(sb.toString());
                }
            }
        });
        return (listFiles == null || listFiles.length == 0) ? false : true;
    }

    public static SharedPreferences xt(Context context, String str, int i6) {
        return i6 == 0 ? com.bytedance.sdk.openadsdk.ats.cw.j(context, j(str), i6) : com.bytedance.sdk.openadsdk.ats.cw.j(context, str, i6);
    }

    public static File j(Context context) {
        return j(new File(context.getFilesDir(), "pangle_com.byted.pangle"));
    }

    public static File j(Context context, String str) {
        return j(new File(context.getExternalFilesDir(str), "pangle_com.byted.pangle"));
    }

    public static File j(Context context, String str, int i6) {
        return i6 == 0 ? j(new File(context.getDir(str, i6), "pangle_com.byted.pangle")) : context.getDir(str, i6);
    }

    private static String j(String str) {
        return "pangle_com.byted.pangle_" + str;
    }
}
