package xyz.adscope.common.imageloader;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StorageUtils {
    public static File getCacheDirectory(Context context) {
        if (context == null) {
            return null;
        }
        try {
            File externalCacheDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalCacheDir() : null;
            return externalCacheDir == null ? context.getCacheDir() : externalCacheDir;
        } catch (Throwable unused) {
            return context.getCacheDir();
        }
    }

    public static File getFilesDirectory(Context context) {
        if (context == null) {
            return null;
        }
        try {
            File externalFilesDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalFilesDir(null) : null;
            return externalFilesDir == null ? context.getFilesDir() : externalFilesDir;
        } catch (Throwable unused) {
            return context.getFilesDir();
        }
    }

    public static File getFilesCacheDirectory(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return new File(context.getFilesDir(), str);
        } catch (Throwable unused) {
            return new File(context.getFilesDir(), str);
        }
    }
}
