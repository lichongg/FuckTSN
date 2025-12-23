package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends RecyclerView.mi {
    protected PointF cw;

    /* renamed from: m, reason: collision with root package name */
    private final float f27092m;

    /* renamed from: j, reason: collision with root package name */
    protected final LinearInterpolator f27091j = new LinearInterpolator();
    protected final DecelerateInterpolator xt = new DecelerateInterpolator();

    /* renamed from: r, reason: collision with root package name */
    protected int f27093r = 0;
    protected int up = 0;

    private int xt(int i6, int i7) {
        int i8 = i6 - i7;
        if (i6 * i8 <= 0) {
            return 0;
        }
        return i8;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.mi
    protected void j(View view, RecyclerView.kt ktVar, RecyclerView.mi.j jVar) {
        int xt = xt(view, xt());
        int j6 = j(view, cw());
        int j7 = j((int) Math.sqrt((xt * xt) + (j6 * j6)));
        if (j7 > 0) {
            jVar.update(-xt, -j6, j7, this.xt);
        }
    }

    protected int cw() {
        PointF pointF = this.cw;
        if (pointF == null) {
            return 0;
        }
        float f6 = pointF.y;
        if (f6 != 0.0f) {
            return f6 > 0.0f ? 1 : -1;
        }
        return 0;
    }

    protected int xt(int i6) {
        return (int) Math.ceil(Math.abs(i6) * this.f27092m);
    }

    public m(Context context) {
        this.f27092m = j(context.getResources().getDisplayMetrics());
    }

    protected int xt() {
        PointF pointF = this.cw;
        if (pointF == null) {
            return 0;
        }
        float f6 = pointF.x;
        if (f6 != 0.0f) {
            return f6 > 0.0f ? 1 : -1;
        }
        return 0;
    }

    public int xt(View view, int i6) {
        RecyclerView.g r5 = r();
        if (r5 == null || !r5.cw()) {
            return 0;
        }
        RecyclerView.oq oqVar = (RecyclerView.oq) view.getLayoutParams();
        return j(r5.ae(view) - ((ViewGroup.MarginLayoutParams) oqVar).leftMargin, r5.g(view) + ((ViewGroup.MarginLayoutParams) oqVar).rightMargin, r5.x(), r5.f() - r5.s(), i6);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.mi
    protected void j(int i6, int i7, RecyclerView.kt ktVar, RecyclerView.mi.j jVar) {
        if (g() == 0) {
            up();
            return;
        }
        this.f27093r = xt(this.f27093r, i6);
        int xt = xt(this.up, i7);
        this.up = xt;
        if (this.f27093r == 0 && xt == 0) {
            j(jVar);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.mi
    protected void j() {
        this.up = 0;
        this.f27093r = 0;
        this.cw = null;
    }

    protected float j(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    protected int j(int i6) {
        return (int) Math.ceil(xt(i6) / 0.3356d);
    }

    protected void j(RecyclerView.mi.j jVar) {
        PointF r5 = r(tl());
        if (r5 != null && (r5.x != 0.0f || r5.y != 0.0f)) {
            j(r5);
            this.cw = r5;
            this.f27093r = (int) (r5.x * 10000.0f);
            this.up = (int) (r5.y * 10000.0f);
            jVar.update((int) (this.f27093r * 1.2f), (int) (this.up * 1.2f), (int) (xt(10000) * 1.2f), this.f27091j);
            return;
        }
        jVar.j(tl());
        up();
    }

    public int j(int i6, int i7, int i8, int i9, int i10) {
        if (i10 == -1) {
            return i8 - i6;
        }
        if (i10 != 0) {
            if (i10 == 1) {
                return i9 - i7;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i11 = i8 - i6;
        if (i11 > 0) {
            return i11;
        }
        int i12 = i9 - i7;
        if (i12 < 0) {
            return i12;
        }
        return 0;
    }

    public int j(View view, int i6) {
        RecyclerView.g r5 = r();
        if (r5 == null || !r5.r()) {
            return 0;
        }
        RecyclerView.oq oqVar = (RecyclerView.oq) view.getLayoutParams();
        return j(r5.tl(view) - ((ViewGroup.MarginLayoutParams) oqVar).topMargin, r5.oq(view) + ((ViewGroup.MarginLayoutParams) oqVar).bottomMargin, r5.ch(), r5.v() - r5.a(), i6);
    }
}
