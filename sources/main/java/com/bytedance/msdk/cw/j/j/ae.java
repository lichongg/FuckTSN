package com.bytedance.msdk.cw.j.j;

import android.app.Activity;
import com.bytedance.sdk.component.utils.vl;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends cw {
    public void cw(Activity activity) {
        com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar = ((cw) this).f24993g;
        if (xtVar != null) {
            xtVar.m();
        }
        if (((cw) this).oq != null) {
            ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(8113).j(20033, activity).j(Void.class).xt());
        }
    }

    public ae(com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar, Function function) {
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
