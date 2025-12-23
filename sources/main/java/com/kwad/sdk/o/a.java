package com.kwad.sdk.o;

import android.content.Context;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class a {
    private static File aug;

    private static File ba(Context context) {
        if (aug == null) {
            aug = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return aug;
    }

    private static String t(Context context, String str) {
        return i(new File(ba(context), "apk-" + str)).getPath();
    }

    static String v(Context context, String str) {
        File file = new File(t(context, str), "dynamic.apk");
        return file.exists() ? file.getPath() : new File(t(context, str), "dynamic_apk").getPath();
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists() || !file.isDirectory()) {
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                file.isDirectory();
            }
        }
        return file;
    }
}
