package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static Context f40654a;

    public static final Context a() {
        Context context = f40654a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final File e() {
        return a((String) null);
    }

    public static final void a(Context context) {
        f40654a = context;
    }

    public static final File a(String str) {
        return m.h(a(), str);
    }

    public static final String b() {
        if (a() == null) {
            return "";
        }
        return a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final File d() {
        Context a6 = a();
        if (a6 != null) {
            return a6.getCacheDir();
        }
        return null;
    }
}
