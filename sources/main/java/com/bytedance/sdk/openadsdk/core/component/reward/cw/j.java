package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j extends xt {
    protected boolean cw;

    /* renamed from: j, reason: collision with root package name */
    protected int f28167j;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f28168m;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f28169r;
    protected boolean up;
    protected int xt;

    public j(Activity activity, n nVar) {
        super(activity, nVar);
    }

    public void j(int i6) {
        this.f28167j = i6;
    }

    public void xt(int i6) {
        this.xt = i6;
    }

    public j(Activity activity, n nVar, qa qaVar) {
        super(activity, nVar, qaVar);
    }

    public void cw(boolean z5) {
        this.f28168m = z5;
    }

    public void j(boolean z5) {
        this.cw = z5;
    }

    public void r(boolean z5) {
        this.up = z5;
    }

    public void xt(boolean z5) {
        this.f28169r = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j xt(oq oqVar) {
        jy jyVar = new jy(this.tl, this.ae);
        jyVar.xt(this.f28169r);
        jyVar.j(this.cw);
        jyVar.j(this.f28167j);
        jyVar.xt(this.xt);
        jyVar.r(this.qv);
        jyVar.cw(this.vl);
        jyVar.j(this.av);
        jyVar.xt(this.az);
        jyVar.cw(this.f28168m);
        jyVar.r(this.up);
        return jyVar.xt(oqVar);
    }
}
