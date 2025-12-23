package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends r {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.j.r
    @SuppressLint({"ObjectAnimatorBinding"})
    List<ObjectAnimator> j() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.cw, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.xt.oq() * 1000.0d));
        ((ViewGroup) this.cw.getParent()).setClipChildren(false);
        ((ViewGroup) this.cw.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.cw.getParent().getParent().getParent()).setClipChildren(false);
        this.cw.setTag(2097610712, this.xt.tl());
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(duration));
        return arrayList;
    }

    public tl(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        super(view, jVar);
    }
}
