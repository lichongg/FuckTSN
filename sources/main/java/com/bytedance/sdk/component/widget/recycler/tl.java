package com.bytedance.sdk.component.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class tl {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    protected final RecyclerView.g f27101j;
    final Rect xt;

    public abstract int ae();

    public abstract int cw();

    public abstract int cw(View view);

    public abstract int j(View view);

    public void j() {
        this.cw = m();
    }

    public abstract void j(int i6);

    public abstract int m();

    public abstract int m(View view);

    public abstract int r();

    public abstract int r(View view);

    public abstract int tl();

    public abstract int up();

    public abstract int up(View view);

    public int xt() {
        if (Integer.MIN_VALUE == this.cw) {
            return 0;
        }
        return m() - this.cw;
    }

    public abstract int xt(View view);

    private tl(RecyclerView.g gVar) {
        this.cw = Integer.MIN_VALUE;
        this.xt = new Rect();
        this.f27101j = gVar;
    }

    public static tl j(RecyclerView.g gVar, int i6) {
        if (i6 == 0) {
            return j(gVar);
        }
        if (i6 == 1) {
            return xt(gVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static tl xt(RecyclerView.g gVar) {
        return new tl(gVar) { // from class: com.bytedance.sdk.component.widget.recycler.tl.2
            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int cw() {
                return this.f27101j.ch();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public void j(int i6) {
                this.f27101j.oq(i6);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int m(View view) {
                RecyclerView.oq oqVar = (RecyclerView.oq) view.getLayoutParams();
                return this.f27101j.up(view) + ((ViewGroup.MarginLayoutParams) oqVar).leftMargin + ((ViewGroup.MarginLayoutParams) oqVar).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int r() {
                return this.f27101j.v() - this.f27101j.a();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int up() {
                return this.f27101j.v();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int ae() {
                return this.f27101j.a();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int cw(View view) {
                this.f27101j.j(view, true, this.xt);
                return this.xt.bottom;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int j(View view) {
                return this.f27101j.tl(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.oq) view.getLayoutParams())).topMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int r(View view) {
                this.f27101j.j(view, true, this.xt);
                return this.xt.top;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int tl() {
                return this.f27101j.tj();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int up(View view) {
                RecyclerView.oq oqVar = (RecyclerView.oq) view.getLayoutParams();
                return this.f27101j.m(view) + ((ViewGroup.MarginLayoutParams) oqVar).topMargin + ((ViewGroup.MarginLayoutParams) oqVar).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int m() {
                return (this.f27101j.v() - this.f27101j.ch()) - this.f27101j.a();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int xt(View view) {
                return this.f27101j.oq(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.oq) view.getLayoutParams())).bottomMargin;
            }
        };
    }

    public static tl j(RecyclerView.g gVar) {
        return new tl(gVar) { // from class: com.bytedance.sdk.component.widget.recycler.tl.1
            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int cw() {
                return this.f27101j.x();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public void j(int i6) {
                this.f27101j.g(i6);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int m(View view) {
                RecyclerView.oq oqVar = (RecyclerView.oq) view.getLayoutParams();
                return this.f27101j.m(view) + ((ViewGroup.MarginLayoutParams) oqVar).topMargin + ((ViewGroup.MarginLayoutParams) oqVar).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int r() {
                return this.f27101j.f() - this.f27101j.s();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int up() {
                return this.f27101j.f();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int ae() {
                return this.f27101j.s();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int cw(View view) {
                this.f27101j.j(view, true, this.xt);
                return this.xt.right;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int j(View view) {
                return this.f27101j.ae(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.oq) view.getLayoutParams())).leftMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int r(View view) {
                this.f27101j.j(view, true, this.xt);
                return this.xt.left;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int tl() {
                return this.f27101j.kt();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int up(View view) {
                RecyclerView.oq oqVar = (RecyclerView.oq) view.getLayoutParams();
                return this.f27101j.up(view) + ((ViewGroup.MarginLayoutParams) oqVar).leftMargin + ((ViewGroup.MarginLayoutParams) oqVar).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int m() {
                return (this.f27101j.f() - this.f27101j.x()) - this.f27101j.s();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.tl
            public int xt(View view) {
                return this.f27101j.g(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.oq) view.getLayoutParams())).rightMargin;
            }
        };
    }
}
