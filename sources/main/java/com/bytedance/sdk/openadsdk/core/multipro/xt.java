package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.rn.h;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    public static boolean f29580j;
    public static boolean xt;

    static class j {

        /* renamed from: j, reason: collision with root package name */
        static final com.bytedance.sdk.component.r.j.xt f29584j = h.j("sp_multi_info");
    }

    public static boolean cw() {
        if (!xt) {
            f29580j = j.f29584j.xt("is_support_multi_process", false);
            xt = true;
        }
        return f29580j;
    }

    public static void j() {
        if (!xt) {
            j.f29584j.j("is_support_multi_process", true);
        }
        f29580j = true;
        xt = true;
    }

    public static void xt() {
        if (xt) {
            j.f29584j.j("is_support_multi_process", false);
        }
        f29580j = false;
    }
}
