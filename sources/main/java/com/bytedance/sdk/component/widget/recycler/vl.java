package com.bytedance.sdk.component.widget.recycler;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class vl extends RecyclerView.vl {
    private final RecyclerView.ws cw = new RecyclerView.ws() { // from class: com.bytedance.sdk.component.widget.recycler.vl.1

        /* renamed from: j, reason: collision with root package name */
        boolean f27119j = false;

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ws
        public void j(RecyclerView recyclerView, int i6) {
            super.j(recyclerView, i6);
            if (i6 == 0 && this.f27119j) {
                this.f27119j = false;
                vl.this.j();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ws
        public void j(RecyclerView recyclerView, int i6, int i7) {
            if (i6 == 0 && i7 == 0) {
                return;
            }
            this.f27119j = true;
        }
    };

    /* renamed from: j, reason: collision with root package name */
    RecyclerView f27118j;
    private Scroller xt;

    private void cw() {
        this.f27118j.xt(this.cw);
        this.f27118j.setOnFlingListener(null);
    }

    private void xt() throws IllegalStateException {
        if (this.f27118j.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f27118j.j(this.cw);
        this.f27118j.setOnFlingListener(this);
    }

    public abstract int j(RecyclerView.g gVar, int i6, int i7);

    public abstract View j(RecyclerView.g gVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.vl
    public boolean j(int i6, int i7) {
        RecyclerView.g layoutManager = this.f27118j.getLayoutManager();
        if (layoutManager == null || this.f27118j.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f27118j.getMinFlingVelocity();
        return (Math.abs(i7) > minFlingVelocity || Math.abs(i6) > minFlingVelocity) && xt(layoutManager, i6, i7);
    }

    public abstract int[] j(RecyclerView.g gVar, View view);

    protected RecyclerView.mi cw(RecyclerView.g gVar) {
        return xt(gVar);
    }

    private boolean xt(RecyclerView.g gVar, int i6, int i7) {
        RecyclerView.mi cw;
        int j6;
        if (!(gVar instanceof RecyclerView.mi.xt) || (cw = cw(gVar)) == null || (j6 = j(gVar, i6, i7)) == -1) {
            return false;
        }
        cw.cw(j6);
        gVar.j(cw);
        return true;
    }

    public void j(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f27118j;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                cw();
            }
            this.f27118j = recyclerView;
            if (recyclerView != null) {
                xt();
                this.xt = new Scroller(this.f27118j.getContext(), new DecelerateInterpolator());
                j();
            }
        }
    }

    @Deprecated
    protected m xt(RecyclerView.g gVar) {
        if (gVar instanceof RecyclerView.mi.xt) {
            return new m(this.f27118j.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.vl.2
                @Override // com.bytedance.sdk.component.widget.recycler.m, com.bytedance.sdk.component.widget.recycler.RecyclerView.mi
                protected void j(View view, RecyclerView.kt ktVar, RecyclerView.mi.j jVar) {
                    vl vlVar = vl.this;
                    RecyclerView recyclerView = vlVar.f27118j;
                    if (recyclerView != null) {
                        int[] j6 = vlVar.j(recyclerView.getLayoutManager(), view);
                        int i6 = j6[0];
                        int i7 = j6[1];
                        int j7 = j(Math.max(Math.abs(i6), Math.abs(i7)));
                        if (j7 > 0) {
                            jVar.update(i6, i7, j7, ((m) this).xt);
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.m
                protected float j(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }

    void j() {
        RecyclerView.g layoutManager;
        View j6;
        RecyclerView recyclerView = this.f27118j;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (j6 = j(layoutManager)) == null) {
            return;
        }
        int[] j7 = j(layoutManager, j6);
        int i6 = j7[0];
        if (i6 == 0 && j7[1] == 0) {
            return;
        }
        this.f27118j.j(i6, j7[1]);
    }
}
