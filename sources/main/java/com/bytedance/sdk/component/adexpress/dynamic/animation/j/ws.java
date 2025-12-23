package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws extends r {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.j.r
    List<ObjectAnimator> j() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.cw, "rotation", 0.0f, this.xt.up(), 0.0f, this.xt.up(), 0.0f).setDuration((int) (this.xt.oq() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(duration));
        return arrayList;
    }

    public ws(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        super(view, jVar);
    }
}
