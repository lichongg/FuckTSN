package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl extends r {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.j.r
    @SuppressLint({"ObjectAnimatorBinding"})
    List<ObjectAnimator> j() {
        int i6;
        int i7;
        this.cw.setTag(2097610711, Integer.valueOf(this.xt.r()));
        View view = this.cw;
        if (view == null || !com.bytedance.sdk.component.adexpress.r.cw.j(view.getContext())) {
            i6 = 0;
            i7 = 1;
        } else {
            i6 = 1;
            i7 = 0;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.cw, "shineValue", i6, i7).setDuration((int) (this.xt.oq() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(duration));
        return arrayList;
    }

    public vl(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        super(view, jVar);
    }
}
