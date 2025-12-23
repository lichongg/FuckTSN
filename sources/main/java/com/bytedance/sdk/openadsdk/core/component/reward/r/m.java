package com.bytedance.sdk.openadsdk.core.component.reward.r;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends j {
    public static boolean j(n nVar) {
        return (nVar == null || nVar.uo() == 100.0f) ? false : true;
    }

    public static int xt(n nVar) {
        return 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void cw(boolean z5) {
        super.cw(z5);
        if (v.xt().qv(uf.g(this.xt)) || this.ws) {
            if (com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.cw && com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.xt && cw(this.xt)) {
                com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.xt = false;
                com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.cw = false;
                this.f28369j.finish();
            } else if (z5 && !com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.cw) {
                this.f28369j.finish();
            } else {
                if (!this.tj.h() || com.bytedance.sdk.openadsdk.core.qv.cw.cw.m.cw) {
                    return;
                }
                this.f28369j.finish();
            }
        }
    }

    private boolean kc() {
        return com.bytedance.sdk.openadsdk.l.oq.j(this.xt);
    }

    private boolean zz() {
        return n.xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public void ff() {
        this.f28366g.up(8);
        this.f28366g.m(8);
        if (m()) {
            this.mi.j(false);
            return;
        }
        this.mi.xt(this.xt.xa());
        this.mi.up(zz() || kc());
        if (zz()) {
            return;
        }
        this.mi.j(false, null, null, true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public View g() {
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.xt)) {
            return com.bytedance.sdk.openadsdk.res.up.f(this.f28369j);
        }
        int i6 = (int) (this.f28373r * 1000.0f);
        return this.cw == 1 ? i6 != 666 ? i6 != 1000 ? i6 != 1500 ? i6 != 1777 ? com.bytedance.sdk.openadsdk.res.up.a(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.s(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.x(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.ch(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.v(this.f28369j) : i6 != 562 ? i6 != 666 ? i6 != 1000 ? i6 != 1500 ? com.bytedance.sdk.openadsdk.res.up.la(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.p(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.ch(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.l(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.h(this.f28369j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xt j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ae aeVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.ae(this.f28369j, this.xt, z5);
        this.f28366g = aeVar;
        return aeVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public boolean ol() {
        return this.cw == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public int p() {
        return xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void r(boolean z5) {
        int i6 = (int) (this.f28373r * 1000.0f);
        if (this.cw != 1) {
            this.f28366g.r(8);
            return;
        }
        if (i6 == 666 || i6 == 1000 || i6 == 1500 || i6 == 1777) {
            this.f28366g.r(8);
        } else {
            this.f28366g.r(z5 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void ry() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.m mVar = this.f28375v;
        if (mVar != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) mVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j((Object) this.f28369j);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.up upVar = this.f28377x;
        if (upVar != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j((Object) this.f28369j);
        }
    }

    public m(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void av() {
        super.av();
        this.mi.xt(this.xt.xa());
        if (zz() || kc()) {
            this.mi.up(true);
        }
        if (!zz()) {
            this.mi.j(false, null, null, true, true);
        }
        if (zz()) {
            this.f28366g.m(0);
            this.f28366g.up(0);
            this.f28366g.cw(0);
        } else {
            this.f28366g.m(8);
            this.f28366g.up(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean e() {
        if (q() && hh.j(this.xt) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean q() {
        return zz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean qb() {
        if (!zz() && !kc()) {
            return false;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void tl() {
        super.tl();
        rh();
        try {
            final View decorView = this.f28369j.getWindow().getDecorView();
            if (decorView != null) {
                decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.m.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int qv = (int) (ed.qv((Context) m.this.f28369j) / 2.0f);
                        int paddingLeft = decorView.getPaddingLeft();
                        int paddingRight = decorView.getPaddingRight();
                        int paddingTop = decorView.getPaddingTop();
                        int paddingBottom = decorView.getPaddingBottom();
                        if (m.this.cw == 1 && !ed.xt()) {
                            paddingTop += qv;
                            paddingBottom += qv;
                        }
                        if (m.this.cw == 2 && !ed.xt()) {
                            paddingLeft += qv;
                            paddingRight += qv;
                        }
                        decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    private boolean cw(n nVar) {
        return (nVar.jl() == 4) && !TextUtils.isEmpty(nVar.vm());
    }
}
