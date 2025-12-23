package com.bytedance.sdk.component.j;

import android.util.Log;

/* loaded from: D:\Downloads\app\classes4.dex */
class g {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f26483j;

    static void j(boolean z5) {
        f26483j = z5;
    }

    static void xt(String str) {
        if (f26483j) {
            com.bytedance.sdk.component.utils.vl.xt("JsBridge2", str);
        }
    }

    static void j(String str) {
        if (f26483j) {
            com.bytedance.sdk.component.utils.vl.j("JsBridge2", str);
        }
    }

    static void xt(String str, Throwable th) {
        if (f26483j) {
            com.bytedance.sdk.component.utils.vl.cw("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.vl.r("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    static void j(String str, Throwable th) {
        if (f26483j) {
            com.bytedance.sdk.component.utils.vl.xt("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.vl.xt("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    static void j(RuntimeException runtimeException) {
        if (f26483j) {
            throw runtimeException;
        }
    }
}
