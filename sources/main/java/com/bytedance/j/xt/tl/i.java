package com.bytedance.j.xt.tl;

import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class i {
    public static void a(String str) {
        if (com.bytedance.j.xt.e.k().c()) {
            vl.j("npth", str);
        }
    }

    public static void b(Throwable th) {
        if (com.bytedance.j.xt.e.k().c()) {
            vl.cw("npth", "NPTH Catch Error", th);
        }
    }

    public static void c(Throwable th) {
        if (com.bytedance.j.xt.e.k().c()) {
            vl.xt("npth", "NPTH Catch Error", th);
        }
    }
}
