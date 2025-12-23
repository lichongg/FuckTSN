package com.bytedance.sdk.openadsdk.core.xt;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qv;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends r {
    protected final int cw;

    /* renamed from: j, reason: collision with root package name */
    protected final n f31364j;

    /* renamed from: r, reason: collision with root package name */
    public int f31365r;
    protected com.bytedance.sdk.openadsdk.core.xt.j.cw up;
    protected final String xt;

    protected boolean j() {
        return false;
    }

    public qv xt() {
        return this.ae;
    }

    private void up() {
        com.bytedance.sdk.openadsdk.core.xt.j.cw j6 = this.tl.j(this.f31364j, this.f31360m, this, j());
        this.up = j6;
        j6.j(this.ae);
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(this.xt);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.xt);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.cw);
        if (j()) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).r(true);
        }
    }

    public void cw(int i6) {
        this.ae.cw(i6);
    }

    public void j(int i6) {
        this.f31365r = i6;
        qv qvVar = this.ae;
        if (qvVar != null) {
            qvVar.j(i6);
        }
    }

    public void r(int i6) {
        this.ae.xt(i6);
    }

    public void xt(View view) {
        this.ae.j(view);
    }

    public xt(Context context, n nVar, String str, int i6) {
        super(context);
        this.f31365r = 1;
        this.f31364j = nVar;
        this.xt = str;
        this.cw = i6;
        up();
    }

    public void xt(int i6) {
        this.ae.r(i6);
    }

    public void j(qv qvVar) {
        this.ae = qvVar;
    }

    public void j(View view) {
        this.ae.xt(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.r
    public void j(View view, qv qvVar) {
        if (n.up(this.f31364j)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).up());
        this.up.j(view);
        if (qvVar == null) {
            qvVar = new qv();
        }
        this.up.j(qvVar);
        this.up.j();
        n.m(this.f31364j);
    }
}
