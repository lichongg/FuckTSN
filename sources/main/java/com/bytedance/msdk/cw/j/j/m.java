package com.bytedance.msdk.cw.j.j;

import android.app.Activity;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends cw {
    public void cw(Activity activity) {
        com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar = ((cw) this).f24993g;
        if (xtVar != null) {
            xtVar.m();
        }
        if (((cw) this).oq != null) {
            ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8113).j(Void.class).j(20033, activity).xt());
        }
    }

    public m(com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar, Function<SparseArray<Object>, Object> function) {
        super(xtVar, function);
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(Activity activity, Object obj, String str) {
        try {
            cw(activity);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }
}
