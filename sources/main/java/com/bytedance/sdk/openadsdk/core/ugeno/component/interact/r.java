package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.a;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    m cw;

    /* renamed from: j, reason: collision with root package name */
    n f30603j;

    /* renamed from: r, reason: collision with root package name */
    cw f30604r;
    up xt;

    private boolean j(boolean z5) {
        int tl = uf.tl(this.f30603j);
        if (tl == 5 || tl == 9) {
            return true;
        }
        return (tl == 3 || tl == 4) ? z5 : tl == 7 || tl == 8;
    }

    private void xt(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                View childAt = viewGroup.getChildAt(i6);
                if ("easy_pfwv".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                    this.xt.r();
                    this.cw.r();
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i7 = 0; i7 < viewGroup2.getChildCount(); i7++) {
                View childAt2 = viewGroup2.getChildAt(i7);
                if ("easy_pfwv".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                    this.xt.r();
                    this.cw.r();
                }
            }
        }
    }

    public void j(ViewGroup viewGroup, View view) {
        xt(viewGroup, view);
        if ((viewGroup instanceof FrameLayout) || (viewGroup instanceof RelativeLayout)) {
            if (this.xt.cw()) {
                int cw = a.m(this.f30603j).cw();
                boolean z5 = cw == 0 || cw == 2;
                if (j(true)) {
                    this.f30604r.j(this.xt.j(), z5);
                    up upVar = this.xt;
                    if (z5) {
                        view = viewGroup;
                    }
                    upVar.j(viewGroup, view, true);
                    return;
                }
                return;
            }
            if (this.cw.cw()) {
                int xt = a.up(this.f30603j).xt();
                boolean z6 = xt == 0 || xt == 2;
                if (j(false)) {
                    this.f30604r.j(this.cw.j(), z6);
                    m mVar = this.cw;
                    if (z6) {
                        view = viewGroup;
                    }
                    mVar.j(viewGroup, view, xt != 2);
                }
            }
        }
    }

    public r(n nVar, boolean z5, j jVar) {
        this.f30603j = nVar;
        cw cwVar = new cw(nVar);
        this.f30604r = cwVar;
        this.xt = new up(this.f30603j, z5, jVar, cwVar);
        this.cw = new m(this.f30603j, z5, jVar, this.f30604r);
    }

    public ae j() {
        if (this.xt.cw()) {
            return this.xt.xt();
        }
        if (this.cw.cw()) {
            return this.cw.xt();
        }
        return new ae() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void j() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void j(boolean z5) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void cw() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void r() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ae
            public void xt() {
            }
        };
    }

    public void xt() {
        this.xt.r();
        this.cw.r();
    }

    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar) {
        m mVar = this.cw;
        if (mVar != null) {
            mVar.j(xtVar);
        }
        up upVar = this.xt;
        if (upVar != null) {
            upVar.j(xtVar);
        }
    }
}
