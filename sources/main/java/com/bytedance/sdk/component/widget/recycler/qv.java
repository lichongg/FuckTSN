package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class qv extends RecyclerView.m {
    boolean tl = true;

    public abstract boolean j(RecyclerView.v vVar);

    public abstract boolean j(RecyclerView.v vVar, int i6, int i7, int i8, int i9);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean j(RecyclerView.v vVar, RecyclerView.m.xt xtVar, RecyclerView.m.xt xtVar2) {
        int i6 = xtVar.f27030j;
        int i7 = xtVar.xt;
        View view = vVar.f27042j;
        int left = xtVar2 == null ? view.getLeft() : xtVar2.f27030j;
        int top2 = xtVar2 == null ? view.getTop() : xtVar2.xt;
        if (vVar.i() || (i6 == left && i7 == top2)) {
            return j(vVar);
        }
        view.layout(left, top2, view.getWidth() + left, view.getHeight() + top2);
        return j(vVar, i6, i7, left, top2);
    }

    public abstract boolean j(RecyclerView.v vVar, RecyclerView.v vVar2, int i6, int i7, int i8, int i9);

    public abstract boolean xt(RecyclerView.v vVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean xt(RecyclerView.v vVar, RecyclerView.m.xt xtVar, RecyclerView.m.xt xtVar2) {
        int i6;
        int i7;
        return (xtVar == null || ((i6 = xtVar.f27030j) == (i7 = xtVar2.f27030j) && xtVar.xt == xtVar2.xt)) ? xt(vVar) : j(vVar, i6, xtVar.xt, i7, xtVar2.xt);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean ae(RecyclerView.v vVar) {
        return !this.tl || vVar.ws();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean cw(RecyclerView.v vVar, RecyclerView.m.xt xtVar, RecyclerView.m.xt xtVar2) {
        int i6 = xtVar.f27030j;
        int i7 = xtVar2.f27030j;
        if (i6 != i7 || xtVar.xt != xtVar2.xt) {
            return j(vVar, i6, xtVar.xt, i7, xtVar2.xt);
        }
        g(vVar);
        return false;
    }

    public final void g(RecyclerView.v vVar) {
        m(vVar);
    }

    public final void oq(RecyclerView.v vVar) {
        m(vVar);
    }

    public final void tl(RecyclerView.v vVar) {
        m(vVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean j(RecyclerView.v vVar, RecyclerView.v vVar2, RecyclerView.m.xt xtVar, RecyclerView.m.xt xtVar2) {
        int i6;
        int i7;
        int i8 = xtVar.f27030j;
        int i9 = xtVar.xt;
        if (vVar2.L_()) {
            int i10 = xtVar.f27030j;
            i7 = xtVar.xt;
            i6 = i10;
        } else {
            i6 = xtVar2.f27030j;
            i7 = xtVar2.xt;
        }
        return j(vVar, vVar2, i8, i9, i6, i7);
    }

    public final void j(RecyclerView.v vVar, boolean z5) {
        m(vVar);
    }
}
