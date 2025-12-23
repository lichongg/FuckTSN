package com.bytedance.msdk.tl.r;

import android.util.SparseArray;
import java.io.PrintStream;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {
    public static void j(com.bytedance.sdk.gromore.j.xt.j jVar) {
        Object apply;
        Object apply2;
        if (jVar == null) {
            return;
        }
        Function<SparseArray<Object>, Object> ch = jVar.ch();
        if (ch != null) {
            apply2 = ch.apply(com.bytedance.sdk.openadsdk.i.r.j().j(10001).j(Boolean.class).xt());
            if (apply2 instanceof Boolean) {
                j.j(((Boolean) apply2).booleanValue());
            }
        }
        if (jVar.a() != null) {
            apply = ch.apply(com.bytedance.sdk.openadsdk.i.r.j().j(10003).j(Map.class).xt());
            if (apply instanceof Map) {
                PrintStream printStream = System.out;
                apply.toString();
                printStream.getClass();
                cw.j((Map) apply);
            }
        }
        xt.j(jVar.s());
        r.j(jVar.l());
    }
}
