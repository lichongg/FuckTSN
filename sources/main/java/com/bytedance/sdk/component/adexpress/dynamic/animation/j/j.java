package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends r {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.j.r
    List<ObjectAnimator> j() {
        float w5 = this.xt.w() / 100.0f;
        float mi = this.xt.mi() / 100.0f;
        if ("reverse".equals(this.xt.av()) && this.xt.ws() <= 0.0d) {
            mi = w5;
            w5 = mi;
        }
        this.cw.setAlpha(w5);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.cw, "alpha", w5, mi).setDuration((int) (this.xt.oq() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(duration));
        return arrayList;
    }

    public j(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        super(view, jVar);
    }
}
