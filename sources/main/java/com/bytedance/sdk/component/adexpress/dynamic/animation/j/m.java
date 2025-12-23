package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends r {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.j.r
    List<ObjectAnimator> j() {
        float f6 = this.cw.getLayoutParams().width;
        this.cw.setTranslationX(f6);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.cw, "translationX", f6, 0.0f).setDuration((int) (this.xt.oq() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.cw, "alpha", 0.0f, 1.0f).setDuration((int) (this.xt.oq() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(duration));
        arrayList.add(j(duration2));
        return arrayList;
    }

    public m(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        super(view, jVar);
    }
}
