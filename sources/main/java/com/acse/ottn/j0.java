package com.acse.ottn;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.math.BigDecimal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class j0 {
    public static void a(Context context) {
        a(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            a(context.getExternalCacheDir());
        }
    }

    public static String b(Context context) throws Exception {
        long b6 = b(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            b6 += b(context.getExternalCacheDir());
        }
        return a(b6);
    }

    public static boolean a(File file) {
        String[] list;
        if (file != null && file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        if (file == null) {
            return true;
        }
        return file.delete();
    }

    public static long b(File file) throws Exception {
        long length;
        long j6 = 0;
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length2 = listFiles.length;
                for (int i6 = 0; i6 < length2; i6++) {
                    if (listFiles[i6].isDirectory()) {
                        length = b(listFiles[i6]);
                    } else {
                        length = listFiles[i6].length();
                    }
                    j6 += length;
                }
            }
            return j6;
        } catch (Exception e6) {
            e6.printStackTrace();
            return j6;
        }
    }

    public static String a(double d6) {
        double d7 = d6 / 1024.0d;
        if (d7 < 1.0d) {
            return "0K";
        }
        double d8 = d7 / 1024.0d;
        if (d8 < 1.0d) {
            return new BigDecimal(Double.toString(d7)).setScale(2, 4).toPlainString() + "KB";
        }
        double d9 = d8 / 1024.0d;
        if (d9 < 1.0d) {
            return new BigDecimal(Double.toString(d8)).setScale(2, 4).toPlainString() + "MB";
        }
        double d10 = d9 / 1024.0d;
        if (d10 < 1.0d) {
            return new BigDecimal(Double.toString(d9)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d10).setScale(2, 4).toPlainString() + "TB";
    }
}
