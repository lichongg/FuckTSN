package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class j {
    private static File aug;
    private static final String auh;

    private static boolean Ax() {
        int i6 = Build.VERSION.SDK_INT;
        return i6 == 30 || i6 == 31 || i6 == 32;
    }

    private static File ba(Context context) {
        if (aug == null) {
            aug = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return aug;
    }

    static void h(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                h(file2);
            }
        }
        file.delete();
    }

    static File s(Context context, String str) {
        return new File(ba(context), "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
    }

    static String t(Context context, String str) {
        return i(new File(ba(context), "apk-" + str)).getPath();
    }

    static File u(Context context, String str) {
        return i(new File(ba(context), "apk-" + str));
    }

    static String v(Context context, String str) {
        return new File(t(context, str), auh).getPath();
    }

    static String w(Context context, String str) {
        return i(new File(t(context, str), "dex")).getPath();
    }

    static String x(Context context, String str) {
        return i(new File(t(context, str), "libs")).getPath();
    }

    static {
        String str;
        if (Ax()) {
            str = "dynamic_apk";
        } else {
            str = "dynamic.apk";
        }
        auh = str;
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists() || !file.isDirectory()) {
            if (!file.exists()) {
                file.mkdirs();
            }
            if ((!file.exists() || !file.isDirectory()) && com.kwad.sdk.api.a.oz.booleanValue()) {
                throw new RuntimeException("Can not ensureDir:" + file);
            }
        }
        return file;
    }

    static void j(File file) {
        try {
            h(file);
        } catch (Exception unused) {
        }
    }

    static void y(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.j.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    File[] listFiles = j.u(context, str).getParentFile().listFiles();
                    if (listFiles == null || listFiles.length <= 0) {
                        return;
                    }
                    for (File file : listFiles) {
                        if (i.L(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            j.h(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
