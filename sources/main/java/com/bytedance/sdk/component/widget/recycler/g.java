package com.bytedance.sdk.component.widget.recycler;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends vl {
    private tl cw;
    private tl xt;

    @Override // com.bytedance.sdk.component.widget.recycler.vl
    public int[] j(RecyclerView.g gVar, View view) {
        int[] iArr = new int[2];
        if (gVar.cw()) {
            iArr[0] = j(gVar, view, up(gVar));
        } else {
            iArr[0] = 0;
        }
        if (gVar.r()) {
            iArr[1] = j(gVar, view, r(gVar));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.vl
    protected m xt(RecyclerView.g gVar) {
        if (gVar instanceof RecyclerView.mi.xt) {
            return new m(this.f27118j.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.g.1
                @Override // com.bytedance.sdk.component.widget.recycler.m, com.bytedance.sdk.component.widget.recycler.RecyclerView.mi
                protected void j(View view, RecyclerView.kt ktVar, RecyclerView.mi.j jVar) {
                    g gVar2 = g.this;
                    int[] j6 = gVar2.j(gVar2.f27118j.getLayoutManager(), view);
                    int i6 = j6[0];
                    int i7 = j6[1];
                    int j7 = j(Math.max(Math.abs(i6), Math.abs(i7)));
                    if (j7 > 0) {
                        jVar.update(i6, i7, j7, ((m) this).xt);
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.m
                protected int xt(int i6) {
                    return Math.min(100, super.xt(i6));
                }

                @Override // com.bytedance.sdk.component.widget.recycler.m
                protected float j(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }

    private tl r(RecyclerView.g gVar) {
        tl tlVar = this.xt;
        if (tlVar == null || tlVar.f27101j != gVar) {
            this.xt = tl.xt(gVar);
        }
        return this.xt;
    }

    private tl up(RecyclerView.g gVar) {
        tl tlVar = this.cw;
        if (tlVar == null || tlVar.f27101j != gVar) {
            this.cw = tl.j(gVar);
        }
        return this.cw;
    }

    private View xt(RecyclerView.g gVar, tl tlVar) {
        int mi = gVar.mi();
        View view = null;
        if (mi == 0) {
            return null;
        }
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < mi; i7++) {
            View tl = gVar.tl(i7);
            int j6 = tlVar.j(tl);
            if (j6 < i6) {
                view = tl;
                i6 = j6;
            }
        }
        return view;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.vl
    public View j(RecyclerView.g gVar) {
        if (gVar.r()) {
            return j(gVar, r(gVar));
        }
        if (gVar.cw()) {
            return j(gVar, up(gVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.recycler.vl
    public int j(RecyclerView.g gVar, int i6, int i7) {
        View xt;
        int r5;
        PointF cw;
        int p5 = gVar.p();
        if (p5 == 0) {
            return -1;
        }
        if (gVar.r()) {
            xt = xt(gVar, r(gVar));
        } else {
            xt = gVar.cw() ? xt(gVar, up(gVar)) : null;
        }
        if (xt == null || (r5 = gVar.r(xt)) == -1) {
            return -1;
        }
        boolean z5 = false;
        if (!gVar.cw() ? i7 > 0 : i6 > 0) {
            z5 = true;
        }
        return (!(gVar instanceof RecyclerView.mi.xt) || (cw = ((RecyclerView.mi.xt) gVar).cw(p5 - 1)) == null || (cw.x >= 0.0f && cw.y >= 0.0f)) ? z5 ? r5 + 1 : r5 : z5 ? r5 - 1 : r5;
    }

    private int j(RecyclerView.g gVar, View view, tl tlVar) {
        int up;
        int j6 = tlVar.j(view) + (tlVar.up(view) / 2);
        if (gVar.az()) {
            up = tlVar.cw() + (tlVar.m() / 2);
        } else {
            up = tlVar.up() / 2;
        }
        return j6 - up;
    }

    private View j(RecyclerView.g gVar, tl tlVar) {
        int up;
        int mi = gVar.mi();
        View view = null;
        if (mi == 0) {
            return null;
        }
        if (gVar.az()) {
            up = tlVar.cw() + (tlVar.m() / 2);
        } else {
            up = tlVar.up() / 2;
        }
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < mi; i7++) {
            View tl = gVar.tl(i7);
            int abs = Math.abs((tlVar.j(tl) + (tlVar.up(tl) / 2)) - up);
            if (abs < i6) {
                view = tl;
                i6 = abs;
            }
        }
        return view;
    }
}
