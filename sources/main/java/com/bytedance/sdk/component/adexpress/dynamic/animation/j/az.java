package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class az extends r {
    public az(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        super(view, jVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.j.r
    List<ObjectAnimator> j() {
        float f6;
        float j6 = com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.xt.m());
        float j7 = com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.xt.ae());
        float f7 = 0.0f;
        if ("reverse".equals(this.xt.av())) {
            f7 = j6;
            f6 = j7;
            j6 = 0.0f;
            j7 = 0.0f;
        } else {
            f6 = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.r.cw.j(this.cw.getContext())) {
            j6 = -j6;
            f7 = -f7;
        }
        this.cw.setTranslationX(j6);
        this.cw.setTranslationY(j7);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.cw, "translationX", j6, f7).setDuration((int) (this.xt.oq() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.cw, "translationY", j7, f6).setDuration((int) (this.xt.oq() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(duration));
        arrayList.add(j(duration2));
        return arrayList;
    }
}
