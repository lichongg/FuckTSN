package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\Downloads\app\classes4.dex */
class oq {
    static int j(RecyclerView.kt ktVar, tl tlVar, View view, View view2, RecyclerView.g gVar, boolean z5, boolean z6) {
        if (gVar.mi() == 0 || ktVar.r() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z6 ? Math.max(0, (ktVar.r() - Math.max(gVar.r(view), gVar.r(view2))) - 1) : Math.max(0, Math.min(gVar.r(view), gVar.r(view2)));
        if (z5) {
            return Math.round((max * (Math.abs(tlVar.xt(view2) - tlVar.j(view)) / (Math.abs(gVar.r(view) - gVar.r(view2)) + 1))) + (tlVar.cw() - tlVar.j(view)));
        }
        return max;
    }

    static int xt(RecyclerView.kt ktVar, tl tlVar, View view, View view2, RecyclerView.g gVar, boolean z5) {
        if (gVar.mi() != 0 && ktVar.r() != 0 && view != null && view2 != null) {
            if (!z5) {
                return ktVar.r();
            }
            return (int) (((tlVar.xt(view2) - tlVar.j(view)) / (Math.abs(gVar.r(view) - gVar.r(view2)) + 1)) * ktVar.r());
        }
        return 0;
    }

    static int j(RecyclerView.kt ktVar, tl tlVar, View view, View view2, RecyclerView.g gVar, boolean z5) {
        if (gVar.mi() == 0 || ktVar.r() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z5) {
            return Math.abs(gVar.r(view) - gVar.r(view2)) + 1;
        }
        return Math.min(tlVar.m(), tlVar.xt(view2) - tlVar.j(view));
    }
}
