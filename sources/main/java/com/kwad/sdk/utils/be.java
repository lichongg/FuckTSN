package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class be {
    private static String ban;
    private static File bao;

    private static boolean Rv() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static String dD(Context context) {
        if (!TextUtils.isEmpty(ban)) {
            return ban;
        }
        String str = null;
        if (Rv()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    str = externalFilesDir.getPath();
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getFilesDir().getPath();
        }
        String str2 = str + File.separator + "ksadsdk";
        ban = str2;
        return str2;
    }

    public static File dE(Context context) {
        File file = bao;
        if (file != null) {
            return file;
        }
        String str = null;
        if (Rv()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str = externalCacheDir.getPath();
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getCacheDir().getPath();
        }
        File file2 = new File(str + File.separator + "ksadsdk");
        bao = file2;
        if (!file2.exists()) {
            bao.mkdirs();
        }
        return bao;
    }

    public static File dH(Context context) {
        String str;
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            str = dD(context);
        } else {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(str + File.separator + "ksadlog");
    }

    public static String dI(Context context) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return "";
        }
        return filesDir.getPath() + File.separator + "ksadsdk";
    }

    public static String dJ(Context context) {
        return dE(context).getPath() + "/cookie";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        String dI = dI(context);
        StringBuilder sb = new StringBuilder();
        sb.append(dI);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("ksad/download/js");
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        return dI(context) + File.separator + "ksad/download/js";
    }

    public static File dF(Context context) {
        File file = new File(dD(context) + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File dG(Context context) {
        File file = new File(dD(context) + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
