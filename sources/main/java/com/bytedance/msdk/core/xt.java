package com.bytedance.msdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    private static volatile com.bytedance.msdk.up.xt.j<com.bytedance.msdk.up.j> cw;

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context f24823j;
    private static volatile com.bytedance.msdk.core.ws.cw xt;

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application f24824j;

        private static Object xt() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null);
                method.setAccessible(true);
                return method.invoke(null, null);
            } catch (Throwable th) {
                com.bytedance.msdk.j.up.cw.xt("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        static {
            try {
                Object xt = xt();
                f24824j = (Application) xt.getClass().getMethod("getApplication", null).invoke(xt, null);
                com.bytedance.msdk.j.up.cw.r("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.msdk.j.up.cw.xt("MyApplication", "application get failed", th);
            }
        }

        public static Application j() {
            return f24824j;
        }
    }

    public static com.bytedance.msdk.up.xt.j<com.bytedance.msdk.up.j> j() {
        if (cw == null) {
            synchronized (xt.class) {
                try {
                    if (cw == null) {
                        cw = new com.bytedance.msdk.up.xt.xt();
                    }
                } finally {
                }
            }
        }
        return cw;
    }

    public static Context getContext() {
        if (f24823j == null) {
            j(null);
        }
        return f24823j;
    }

    public static com.bytedance.msdk.core.ws.cw xt() {
        if (xt == null) {
            synchronized (com.bytedance.msdk.core.ws.cw.class) {
                try {
                    if (xt == null) {
                        xt = new com.bytedance.msdk.core.ws.cw();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    public static synchronized void j(Context context) {
        synchronized (xt.class) {
            if (f24823j == null) {
                synchronized (xt.class) {
                    if (j.j() != null) {
                        try {
                            Application j6 = j.j();
                            f24823j = j6;
                            if (j6 != null) {
                                return;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (context != null) {
                        f24823j = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    }
                }
            }
        }
    }
}
