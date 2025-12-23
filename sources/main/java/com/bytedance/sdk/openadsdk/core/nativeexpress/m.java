package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends com.bytedance.sdk.openadsdk.core.xt.xt {
    protected int jy;
    private com.bytedance.sdk.openadsdk.core.tj.x oq;
    private boolean qv;
    protected int vl;
    protected int ws;

    @Override // com.bytedance.sdk.openadsdk.core.xt.r
    public void cw() {
        this.jy = 1;
        this.qv = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
    public void j(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
        com.bytedance.sdk.openadsdk.core.xt.j.cw.j jVar = (com.bytedance.sdk.openadsdk.core.xt.j.cw.j) j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class);
        jVar.j(j(jVar.cw()));
        super.j(view, qvVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.r
    public void r() {
        this.ws = 1;
        this.qv = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.r
    public void up(int i6) {
        this.vl = i6;
    }

    public m(Context context, n nVar, String str, int i6) {
        super(context, nVar, str, i6);
        this.vl = 0;
        this.jy = -1;
        this.ws = -1;
        this.qv = true;
    }

    private com.bytedance.sdk.openadsdk.core.tj.oq j(String str) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        View ae = this.ae.ae();
        int[] j6 = ed.j(ae);
        if (j6 == null || j6.length != 2) {
            i6 = 0;
            i7 = 0;
        } else {
            i6 = j6[0];
            i7 = j6[1];
            if (this.vl == 0 && this.qv) {
                this.ae.j((ed.cw(this.f31360m, r8.ws()) + i6) - 0.5f);
                this.ae.xt((ed.cw(this.f31360m, r8.az()) + i7) - 0.5f);
                this.ae.cw((ed.cw(this.f31360m, r8.av()) + i6) - 0.5f);
                this.ae.r((ed.cw(this.f31360m, r8.i()) + i7) - 0.5f);
            }
        }
        float m6 = ed.m(this.f31360m);
        int tl = ed.tl(this.f31360m);
        float ae2 = ed.ae(this.f31360m);
        int[] iArr = {-1, -1};
        int[] iArr2 = {-1, -1};
        com.bytedance.sdk.openadsdk.core.tj.x xVar = this.oq;
        if (xVar == null || !this.qv) {
            i8 = 0;
        } else {
            this.ae.j(xVar.up);
            int i11 = i6;
            i8 = 0;
            this.ae.xt(this.oq.f30481m);
            if (this.vl == 0) {
                iArr[0] = ed.cw(this.f31360m, this.oq.ae) + i11;
                iArr[1] = ed.cw(this.f31360m, this.oq.tl) + i7;
                i10 = ed.cw(this.f31360m, this.oq.f30478g);
                i9 = ed.cw(this.f31360m, this.oq.oq);
            } else {
                com.bytedance.sdk.openadsdk.core.tj.x xVar2 = this.oq;
                iArr[0] = xVar2.ae;
                iArr[1] = xVar2.tl;
                int i12 = xVar2.f30478g;
                i9 = xVar2.oq;
                i10 = i12;
            }
            iArr2[0] = i10;
            iArr2[1] = i9;
            View m7 = this.ae.m();
            if (i10 == 0 && i9 == 0 && m7 != null) {
                iArr = ed.j(m7);
                iArr2 = ed.cw(m7);
            }
        }
        this.vl = i8;
        return new oq.j().m(this.ae.ws()).up(this.ae.az()).r(this.ae.av()).cw(this.ae.i()).xt(this.ae.vl()).j(this.ae.jy()).xt(j6).j(iArr).cw(ed.cw(ae)).r(iArr2).cw(this.ae.xt()).r(this.ae.cw()).up(this.ae.r()).xt(com.bytedance.sdk.openadsdk.core.oq.i().cw() ? 1 : 2).j(this.ae.oq()).j(str).j(m6).j(tl).m(this.jy).ae(this.ws).xt(ae2).j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.r
    public void j(com.bytedance.sdk.openadsdk.core.tj.x xVar) {
        this.oq = xVar;
    }
}
