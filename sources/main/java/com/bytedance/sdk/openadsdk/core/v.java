package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class v {
    private static final AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    private static volatile s<com.bytedance.sdk.openadsdk.core.jy.j> f30947j;

    /* renamed from: r, reason: collision with root package name */
    private static volatile Context f30948r;
    private static volatile com.bytedance.sdk.openadsdk.core.p.oq xt;

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application f30951j;

        private static Object xt() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null);
                method.setAccessible(true);
                return method.invoke(null, null);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.xt("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        static {
            try {
                Object xt = xt();
                f30951j = (Application) xt.getClass().getMethod("getApplication", null).invoke(xt, null);
                com.bytedance.sdk.component.utils.vl.xt("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.xt("MyApplication", "application get failed", th);
            }
        }

        public static Application j() {
            return f30951j;
        }
    }

    public static synchronized void j(Context context) {
        synchronized (v.class) {
            if (f30948r == null && context != null) {
                f30948r = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
        }
    }

    public static Context getContext() {
        if (f30948r == null) {
            f30948r = j.j();
        }
        return f30948r;
    }

    public static com.bytedance.sdk.openadsdk.core.p.oq xt() {
        if (xt == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.p.oq.class) {
                try {
                    if (xt == null) {
                        xt = new com.bytedance.sdk.openadsdk.core.p.oq();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    public static s<com.bytedance.sdk.openadsdk.core.jy.j> j() {
        if (f30947j == null) {
            synchronized (v.class) {
                try {
                    if (f30947j == null) {
                        f30947j = new a(getContext());
                    }
                } finally {
                }
            }
        }
        return f30947j;
    }

    public static Function<SparseArray<Object>, Object> j(int i6) {
        return wq.j().j(i6);
    }
}
