package com.bytedance.msdk.cw.j.j;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class tl extends cw {
    private boolean jy;
    private int qv;
    private int vl;

    public abstract void j(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.r.j.ae.oq oqVar);

    public final void j(j jVar) {
        int i6 = this.vl;
        if (i6 >= 60) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter click方法回调次数需要小于60次");
            return;
        }
        this.vl = i6 + 1;
        if (jVar != null) {
            jVar.j();
        }
    }

    @Override // com.bytedance.msdk.xt.cw
    public void qv() {
        try {
            this.jy = true;
            if (((cw) this).oq != null) {
                ((cw) this).oq.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6083).j(Void.class).xt());
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public final void xt(j jVar) {
        if (!this.jy) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
            return;
        }
        int i6 = this.qv;
        if (i6 >= 2) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        this.qv = i6 + 1;
        if (jVar != null) {
            jVar.j();
        }
    }

    public tl(com.bytedance.msdk.cw.cw.xt.j.j.xt xtVar, Function<SparseArray<Object>, Object> function) {
        super(xtVar, function);
        this.qv = 0;
        this.vl = 0;
        this.jy = false;
    }

    @Override // com.bytedance.msdk.xt.cw
    public void j(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.r.j.ae.oq oqVar, List<View> list4) {
        super.j(activity, viewGroup, list, list2, list3, oqVar, list4);
        try {
            this.jy = true;
            j(activity, viewGroup, list, list2, list3, oqVar);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }
}
