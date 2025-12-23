package com.bytedance.msdk.cw.j.j;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.utils.vl;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends cw {
    /* renamed from: if, reason: not valid java name */
    public View m108if() {
        Object apply;
        try {
            if (((cw) this).oq != null) {
                apply = ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8113).j(View.class).xt());
                if (apply instanceof View) {
                    return (View) apply;
                }
                return null;
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
        return null;
    }

    public xt(com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar, Function<SparseArray<Object>, Object> function) {
        super(xtVar, function);
    }

    @Override // com.bytedance.msdk.xt.cw
    public View g() {
        return m108if();
    }
}
