package com.danikula.videocache;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f32251a = org.slf4j.d.j("StorageUtils");

    /* renamed from: b, reason: collision with root package name */
    private static final String f32252b = "video-cache";

    public static File c(Context context) {
        return new File(a(context, true), f32252b);
    }

    private static File b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        f32251a.warn("Unable to create external cache directory");
        return null;
    }

    t() {
    }

    private static File a(Context context, boolean z5) {
        String str;
        File file;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        if (z5 && "mounted".equals(str)) {
            file = b(context);
        } else {
            file = null;
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            String str2 = "/data/data/" + context.getPackageName() + "/cache/";
            f32251a.warn("Can't define system cache directory! '" + str2 + "%s' will be used.");
            return new File(str2);
        }
        return file;
    }
}
