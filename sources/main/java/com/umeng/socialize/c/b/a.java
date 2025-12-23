package com.umeng.socialize.c.b;

import android.content.Context;
import com.umeng.socialize.utils.SLog;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    public static void a() {
    }

    public static void a(Context context) {
        try {
            b(context);
        } catch (Exception e6) {
            SLog.error(e6);
        }
    }

    private static void b(Context context) {
        File[] listFiles = new File(context.getExternalFilesDir(null), c.f42312a).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }
}
