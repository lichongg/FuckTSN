package com.bytedance.sdk.openadsdk.core.wq;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bytedance.sdk.openadsdk.core.h;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31290j;
    private xt xt;

    public void j(xt xtVar) {
        this.xt = xtVar;
    }

    public void j(int i6, SparseArray<Object> sparseArray) {
        xt xtVar;
        if (e.i(sparseArray).k().booleanValue(-999903) && i6 == 8001 && (xtVar = this.xt) != null) {
            xtVar.j(true);
        } else if (this.f31290j != null) {
            this.f31290j.apply(com.bytedance.sdk.openadsdk.i.cw.r.j(h.xt) ? com.bytedance.sdk.openadsdk.i.r.j(sparseArray).j(i6).j(Void.class).xt() : com.bytedance.sdk.openadsdk.i.r.j().j(i6).j(Void.class).j(-99999979, sparseArray).xt());
        }
    }

    public cw(Function<SparseArray<Object>, Object> function) {
        this.f31290j = function;
    }
}
