package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    int ae;
    int av;
    int az;

    /* renamed from: g, reason: collision with root package name */
    int f23652g;

    /* renamed from: i, reason: collision with root package name */
    boolean f23653i;
    int jy;

    /* renamed from: m, reason: collision with root package name */
    int f23655m;
    float oq;
    float qv;
    int tl;
    int up;
    int vl;

    /* renamed from: w, reason: collision with root package name */
    boolean f23657w;

    /* renamed from: j, reason: collision with root package name */
    int f23654j = Integer.MAX_VALUE;
    int xt = Integer.MAX_VALUE;
    int cw = Integer.MIN_VALUE;

    /* renamed from: r, reason: collision with root package name */
    int f23656r = Integer.MIN_VALUE;
    List<Integer> ws = new ArrayList();

    public int j() {
        return this.ae;
    }

    void j(View view, int i6, int i7, int i8, int i9) {
        xt xtVar = (xt) view.getLayoutParams();
        this.f23654j = Math.min(this.f23654j, (view.getLeft() - xtVar.jy()) - i6);
        this.xt = Math.min(this.xt, (view.getTop() - xtVar.ws()) - i7);
        this.cw = Math.max(this.cw, view.getRight() + xtVar.az() + i8);
        this.f23656r = Math.max(this.f23656r, view.getBottom() + xtVar.av() + i9);
    }

    public int xt() {
        return this.tl - this.f23652g;
    }

    cw() {
    }
}
