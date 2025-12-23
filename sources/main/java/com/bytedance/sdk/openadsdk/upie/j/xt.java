package com.bytedance.sdk.openadsdk.upie.j;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static final Handler f31888j = new Handler(Looper.getMainLooper());

    public static void xt(Runnable runnable) {
        f31888j.post(runnable);
    }

    public static void cw(Runnable runnable) {
        tl.cw().post(runnable);
    }

    public static void j(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f31888j.post(runnable);
        }
    }
}
