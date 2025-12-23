package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.up {

    /* renamed from: j, reason: collision with root package name */
    List<r> f25580j = new ArrayList();

    public void j() {
        Iterator<r> it = this.f25580j.iterator();
        while (it.hasNext()) {
            try {
                it.next().cw();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.up
    public void xt() {
        Iterator<r> it = this.f25580j.iterator();
        while (it.hasNext()) {
            try {
                it.next().xt();
            } catch (Exception unused) {
            }
        }
    }

    public xt(View view, List<com.bytedance.sdk.component.adexpress.dynamic.cw.j> list) {
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.cw.j> it = list.iterator();
        while (it.hasNext()) {
            r j6 = cw.j().j(view, it.next());
            if (j6 != null) {
                this.f25580j.add(j6);
            }
        }
    }
}
