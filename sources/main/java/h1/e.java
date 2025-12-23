package h1;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f43039a = "video-cache";

    public static File e(Context context) {
        return new File(c(context, true), f43039a);
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        for (String str2 : file.list()) {
            a(str + File.separator + str2);
        }
        return file.delete();
    }

    private static File d(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static boolean b(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private static File c(Context context, boolean z5) {
        String str;
        File file;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        if (z5 && "mounted".equals(str)) {
            file = d(context);
        } else {
            file = null;
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            return new File(context.getFilesDir().getPath() + context.getPackageName() + "/cache/");
        }
        return file;
    }
}
