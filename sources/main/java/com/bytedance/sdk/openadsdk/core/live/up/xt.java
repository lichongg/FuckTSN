package com.bytedance.sdk.openadsdk.core.live.up;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.h;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static com.bytedance.sdk.component.r.j.xt f29488j;

    public static void j(String str) {
        xt();
        try {
            com.bytedance.sdk.component.r.j.xt xtVar = f29488j;
            if (xtVar != null) {
                f29488j.j("live_init_".concat(String.valueOf(str)), xtVar.xt("live_init_".concat(String.valueOf(str)), 0) + 1);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    private static void xt() {
        if (f29488j == null) {
            f29488j = h.j("csj_live");
        }
    }

    public static boolean cw(String str) {
        int i6;
        xt();
        com.bytedance.sdk.component.r.j.xt xtVar = f29488j;
        if (xtVar != null) {
            i6 = xtVar.xt("live_init_".concat(String.valueOf(str)), 0);
        } else {
            i6 = 0;
        }
        if (i6 >= 5) {
            return false;
        }
        return true;
    }

    public static void r(String str) {
        j();
        xt(str);
    }

    public static void xt(String str) {
        xt();
        try {
            com.bytedance.sdk.component.r.j.xt xtVar = f29488j;
            if (xtVar != null) {
                xtVar.j("live_init_".concat(String.valueOf(str)), 0);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public static void j() {
        try {
            Function<SparseArray<Object>, Object> m6 = oq.i().m(4);
            if (m6 != null) {
                m6.apply(com.bytedance.sdk.openadsdk.i.r.j().j(100).j(Void.class).j(0, "com.byted.live.lite").xt());
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }
}
