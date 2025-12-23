package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends r {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.j.r
    @SuppressLint({"ObjectAnimatorBinding"})
    List<ObjectAnimator> j() {
        this.cw.setTag(2097610709, Integer.valueOf(this.xt.cw()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.cw, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.xt.oq() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(duration));
        return arrayList;
    }

    public ae(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        super(view, jVar);
    }
}
