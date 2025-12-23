package com.bytedance.msdk.cw.j.j;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.vl;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq extends cw {
    public void xt(ViewGroup viewGroup) {
        com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar = ((cw) this).f24993g;
        if (xtVar != null) {
            xtVar.m();
        }
        if (((cw) this).oq != null) {
            ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6152).j(20060, viewGroup).j(Void.class).xt());
        }
    }

    public oq(com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar, Function<SparseArray<Object>, Object> function) {
        super(xtVar, function);
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(ViewGroup viewGroup) {
        try {
            xt(viewGroup);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }
}
