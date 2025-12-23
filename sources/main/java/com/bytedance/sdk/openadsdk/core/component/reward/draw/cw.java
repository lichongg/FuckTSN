package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.g;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends com.bytedance.sdk.component.widget.recycler.up {
    private j ch;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28195f;
    private int kt;
    private final g mi;

    /* renamed from: s, reason: collision with root package name */
    private final RecyclerView.qv f28196s;
    private int tj;

    /* renamed from: v, reason: collision with root package name */
    private boolean f28197v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f28198w;

    /* renamed from: x, reason: collision with root package name */
    private int f28199x;

    public interface j {
        void j();

        void j(boolean z5, int i6);

        void j(boolean z5, int i6, boolean z6);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.up, com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void j(RecyclerView recyclerView, RecyclerView.av avVar) {
        super.j(recyclerView, avVar);
        try {
            up upVar = (up) recyclerView.cw(this.f28199x);
            if (upVar != null) {
                upVar.p();
            }
        } catch (Exception e6) {
            vl.cw("cubic detached exception:" + e6.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void qv(int i6) {
        boolean z5;
        j jVar;
        this.tj = i6;
        if (i6 == 0) {
            View j6 = this.mi.j(this);
            if (j6 != null) {
                int r5 = r(j6);
                z5 = this.f28199x == r5;
                this.f28199x = r5;
            } else {
                z5 = true;
            }
            if (this.f28195f) {
                this.f28195f = false;
                this.f28197v = this.f28198w;
                if (!z5 && (jVar = this.ch) != null) {
                    boolean z6 = this.kt >= 0;
                    int i7 = this.f28199x;
                    jVar.j(z6, i7, i7 == p() - 1);
                }
            }
        }
        if (i6 == 2) {
            this.f28195f = true;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.up, com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public boolean r() {
        return this.f28197v;
    }

    public void xt(boolean z5) {
        this.f28198w = z5;
        if (z5 || this.tj == 0) {
            this.f28197v = z5;
        }
    }

    public cw(Context context, int i6, boolean z5) {
        super(context, i6, z5);
        this.f28195f = false;
        this.f28198w = true;
        this.f28197v = true;
        this.f28196s = new RecyclerView.qv() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.cw.1
            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.qv
            public void j(View view) {
                if (cw.this.ch == null || cw.this.mi() != 1) {
                    return;
                }
                cw.this.ch.j();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.qv
            public void xt(View view) {
                if (cw.this.ch != null) {
                    cw.this.ch.j(cw.this.kt >= 0, cw.this.r(view));
                }
            }
        };
        this.mi = new g();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void cw(RecyclerView recyclerView) {
        super.cw(recyclerView);
        this.mi.j(recyclerView);
        recyclerView.j(this.f28196s);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.up, com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public int xt(int i6, RecyclerView.av avVar, RecyclerView.kt ktVar) {
        this.kt = i6;
        return super.xt(i6, avVar, ktVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.up, com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public int j(int i6, RecyclerView.av avVar, RecyclerView.kt ktVar) {
        this.kt = i6;
        return super.j(i6, avVar, ktVar);
    }

    public void j(j jVar) {
        this.ch = jVar;
    }
}
