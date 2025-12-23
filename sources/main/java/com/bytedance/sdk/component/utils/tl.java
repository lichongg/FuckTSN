package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {

    /* renamed from: j, reason: collision with root package name */
    private static volatile Handler f26900j;

    public static Handler xt() {
        if (f26900j == null) {
            synchronized (tl.class) {
                try {
                    if (f26900j == null) {
                        f26900j = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f26900j;
    }

    public static Handler cw() {
        return com.bytedance.sdk.component.oq.xt.j.j().cw();
    }

    public static Handler j() {
        return com.bytedance.sdk.component.oq.xt.j.j().xt();
    }
}
