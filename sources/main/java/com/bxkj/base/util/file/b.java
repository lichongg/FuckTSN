package com.bxkj.base.util.file;

import android.content.Context;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b {
    public static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!c(file2)) {
                        return false;
                    }
                } else if (file2.isDirectory() && !b(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static boolean j(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!Character.isWhitespace(str.charAt(i6))) {
                return false;
            }
        }
        return true;
    }

    public static String a(long j6) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j6 == 0) {
            return "0B";
        }
        if (j6 < 1024) {
            return decimalFormat.format(j6) + "B";
        }
        if (j6 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return decimalFormat.format(j6 / 1024.0d) + "KB";
        }
        if (j6 < IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return decimalFormat.format(j6 / 1048576.0d) + "MB";
        }
        return decimalFormat.format(j6 / 1.073741824E9d) + "GB";
    }

    public static boolean c(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile() && file.delete();
        }
        return true;
    }

    public static String e(Context context) {
        return ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath();
    }

    public static boolean d(String str) {
        return c(f(str));
    }

    public static File f(String str) {
        if (j(str)) {
            return null;
        }
        return new File(str);
    }

    public static long g(File file) throws Exception {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        file.createNewFile();
        return 0L;
    }

    public static long h(File file) throws Exception {
        long g6;
        File[] listFiles = file.listFiles();
        long j6 = 0;
        for (int i6 = 0; i6 < listFiles.length; i6++) {
            if (listFiles[i6].isDirectory()) {
                g6 = h(listFiles[i6]);
            } else {
                g6 = g(listFiles[i6]);
            }
            j6 += g6;
        }
        return j6;
    }

    public static String i(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= -1) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }
}
