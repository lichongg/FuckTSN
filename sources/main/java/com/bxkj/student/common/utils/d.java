package com.bxkj.student.common.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.math.BigDecimal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d {
    public static void b(String filePath) {
        i(new File(filePath));
    }

    public static void d(Context context) {
        i(new File("/data/data/" + context.getPackageName() + "/databases"));
    }

    public static void h(Context context) {
        i(new File("/data/data/" + context.getPackageName() + "/shared_prefs"));
    }

    private static void i(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                file.delete();
            }
        }
    }

    public static long l(File file) throws Exception {
        long j6 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i6 = 0; i6 < listFiles.length; i6++) {
                j6 += listFiles[i6].isDirectory() ? l(listFiles[i6]) : listFiles[i6].length();
            }
            return j6;
        } catch (Exception e6) {
            e6.printStackTrace();
            return j6;
        }
    }

    public static String m(double size) {
        double d6 = size / 1024.0d;
        if (d6 < 1.0d) {
            return size + "Byte";
        }
        double d7 = d6 / 1024.0d;
        if (d7 < 1.0d) {
            return new BigDecimal(Double.toString(d6)).setScale(2, 4).toPlainString() + "KB";
        }
        double d8 = d7 / 1024.0d;
        if (d8 < 1.0d) {
            return new BigDecimal(Double.toString(d7)).setScale(2, 4).toPlainString() + "MB";
        }
        double d9 = d8 / 1024.0d;
        if (d9 < 1.0d) {
            return new BigDecimal(Double.toString(d8)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d9).setScale(2, 4).toPlainString() + "TB";
    }

    public static void a(Context context, String... filepath) {
        g(context);
        e(context);
        d(context);
        h(context);
        f(context);
        if (filepath != null) {
            for (String str : filepath) {
                b(str);
            }
        }
    }

    public static void c(Context context, String dbName) {
        context.deleteDatabase(dbName);
    }

    public static void e(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            i(context.getExternalCacheDir());
        }
    }

    public static void f(Context context) {
        i(context.getFilesDir());
    }

    public static void g(Context context) {
        i(context.getCacheDir());
    }

    public static void j(String filePath, boolean deleteThisPath) {
        if (!TextUtils.isEmpty(filePath)) {
            try {
                File file = new File(filePath);
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        j(file2.getAbsolutePath(), true);
                    }
                }
                if (deleteThisPath) {
                    if (!file.isDirectory()) {
                        file.delete();
                    } else if (file.listFiles().length == 0) {
                        file.delete();
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public static String k(Context context) throws Exception {
        return m(l(context.getExternalCacheDir()));
    }
}
