package com.bytedance.sdk.openadsdk.core.ugeno.component.xt;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt extends RecyclerView.ws {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f30672j = false;
    private j xt;

    public abstract void j();

    public abstract void j(int i6, int i7);

    public abstract void j(int i6, View view);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ws
    public void j(RecyclerView recyclerView, int i6) {
        super.j(recyclerView, i6);
        com.bytedance.sdk.component.widget.recycler.up upVar = (com.bytedance.sdk.component.widget.recycler.up) recyclerView.getLayoutManager();
        if (i6 == 0) {
            int qv = upVar.qv();
            if (!j(upVar.xt(qv), 50)) {
                qv--;
            }
            int max = Math.max(0, Math.max(qv, this.cw));
            for (int min = Math.min(this.cw, qv); min <= max; min++) {
                j(min, upVar.xt(min));
            }
            this.cw = qv;
            int p5 = upVar.p();
            this.xt.j(recyclerView);
            if ((qv == p5 - 1 && this.f30672j) || p5 == 1) {
                j();
            }
        }
        xt(recyclerView, i6);
    }

    public abstract void xt(RecyclerView recyclerView, int i6);

    public xt(j jVar) {
        this.xt = jVar;
    }

    private int j(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean j(View view, int i6) {
        return view != null && view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && j(view) >= i6;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ws
    public void j(RecyclerView recyclerView, int i6, int i7) {
        super.j(recyclerView, i6, i7);
        if (i7 == 0) {
            com.bytedance.sdk.component.widget.recycler.up upVar = (com.bytedance.sdk.component.widget.recycler.up) recyclerView.getLayoutManager();
            this.cw = upVar.oq();
            int qv = upVar.qv();
            if (!j(upVar.xt(qv), 50)) {
                qv--;
            }
            int max = Math.max(0, Math.max(qv, this.cw));
            for (int i8 = this.cw; i8 <= max; i8++) {
                j(i8, upVar.xt(i8));
            }
        }
        this.f30672j = i7 > 0;
        this.xt.j();
        j(i6, i7);
    }
}
