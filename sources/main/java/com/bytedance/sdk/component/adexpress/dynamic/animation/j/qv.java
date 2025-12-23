package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv extends r {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.j.r
    List<ObjectAnimator> j() {
        float f6;
        float qv = (float) this.xt.qv();
        float vl = (float) this.xt.vl();
        String av = this.xt.av();
        float f7 = 1.0f;
        if ("reverse".equals(av) || "alternate-reverse".equals(av)) {
            f6 = 1.0f;
        } else {
            f7 = qv;
            f6 = vl;
            qv = 1.0f;
            vl = 1.0f;
        }
        this.cw.setTag(2097610710, this.xt.xt());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.cw, "scaleX", qv, f7).setDuration((int) (this.xt.oq() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.cw, "scaleY", vl, f6).setDuration((int) (this.xt.oq() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(duration));
        arrayList.add(j(duration2));
        return arrayList;
    }

    public qv(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        super(view, jVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null && (viewGroup2 instanceof DynamicBaseWidget)) {
                viewGroup2.setClipChildren(false);
                viewGroup2.setClipToPadding(false);
                ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
                if (viewGroup3 != null && (viewGroup3 instanceof DynamicBaseWidget)) {
                    viewGroup3.setClipChildren(false);
                    viewGroup3.setClipToPadding(false);
                }
            }
        }
    }
}
