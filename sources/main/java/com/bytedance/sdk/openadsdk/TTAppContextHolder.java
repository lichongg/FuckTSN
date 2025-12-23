package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.m;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTAppContextHolder {

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context f27513j;

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application f27514j;

        private static Object xt() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null);
                method.setAccessible(true);
                return method.invoke(null, null);
            } catch (Throwable th) {
                m.up("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        static {
            try {
                Object xt = xt();
                f27514j = (Application) xt.getClass().getMethod("getApplication", null).invoke(xt, null);
                m.r("MyApplication", "application get success");
            } catch (Throwable th) {
                m.up("MyApplication", "application get failed", th);
            }
        }

        public static Application j() {
            return f27514j;
        }
    }

    public static Context getContext() {
        if (f27513j == null) {
            setContext(null);
        }
        return f27513j;
    }

    public static synchronized void setContext(Context context) {
        synchronized (TTAppContextHolder.class) {
            if (f27513j == null) {
                if (context != null) {
                    f27513j = StubApp.getOrigApplicationContext(context.getApplicationContext());
                } else if (j.j() != null) {
                    try {
                        Application j6 = j.j();
                        f27513j = j6;
                        if (j6 != null) {
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
