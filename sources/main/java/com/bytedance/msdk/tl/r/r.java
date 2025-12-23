package com.bytedance.msdk.tl.r;

import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static Function<SparseArray<Object>, Object> f25231j;

    public static void j(Function<SparseArray<Object>, Object> function) {
        f25231j = function;
    }

    public static String cw() {
        Object apply;
        Function<SparseArray<Object>, Object> function = f25231j;
        if (function != null) {
            apply = function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(10006).j(String.class).xt());
            if (apply instanceof String) {
                return apply.toString();
            }
        }
        return null;
    }

    public static String j() {
        Object apply;
        Function<SparseArray<Object>, Object> function = f25231j;
        if (function != null) {
            apply = function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(10004).j(String.class).xt());
            if (apply instanceof String) {
                return apply.toString();
            }
        }
        return null;
    }

    public static String xt() {
        Object apply;
        Function<SparseArray<Object>, Object> function = f25231j;
        if (function != null) {
            apply = function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(10005).j(String.class).xt());
            if (apply instanceof String) {
                return apply.toString();
            }
        }
        return null;
    }
}
