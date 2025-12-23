package com.bytedance.sdk.openadsdk.core.rn;

import android.annotation.SuppressLint;
import com.bytedance.sdk.component.ae.r;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class h {

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f30077j;

    static class j {

        /* renamed from: j, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        static final r.j f30078j = h.r();
    }

    public static com.bytedance.sdk.component.r.j.xt j(String str) {
        return j.f30078j.j(xt(str)).j();
    }

    public static int xt() {
        return 3;
    }

    public static void j() {
        f30077j = true;
    }

    private static String xt(String str) {
        if (f30077j || com.bytedance.sdk.component.utils.i.j(com.bytedance.sdk.openadsdk.core.v.getContext())) {
            return str;
        }
        return str + com.bytedance.sdk.component.utils.i.xt(com.bytedance.sdk.openadsdk.core.v.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static r.j r() {
        com.bytedance.sdk.openadsdk.core.p.oq xt = com.bytedance.sdk.openadsdk.core.v.xt();
        xt.xc();
        return new r.j().j(com.bytedance.sdk.openadsdk.core.v.getContext()).j(1).xt(xt.vu()).j(f30077j);
    }
}
