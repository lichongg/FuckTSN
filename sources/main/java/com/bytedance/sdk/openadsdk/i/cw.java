package com.bytedance.sdk.openadsdk.i;

import android.util.SparseArray;
import com.bykv.j.j.j.j.b;
import com.bykv.j.j.j.j.c;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import r0.a;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static boolean j(int i6) {
        return i6 >= 6803 && i6 < 7000;
    }

    public static SparseArray<Object> j(Function<SparseArray<Object>, Object> function) {
        Object apply;
        if (function == null) {
            return new SparseArray<>();
        }
        apply = function.apply(r.j().j(-99999986).j(SparseArray.class).xt());
        return apply instanceof SparseArray ? (SparseArray) apply : new SparseArray<>();
    }

    public static PluginValueSet xt(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return e.a().k();
        }
        Object apply = (b.a(function) && j(a.a().c())) ? c.a(function).get() : function.apply(r.j().j(-99999986).j(SparseArray.class).xt());
        return apply instanceof SparseArray ? e.i((SparseArray) apply).k() : e.a().k();
    }
}
