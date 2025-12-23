package com.bytedance.sdk.gromore.j.j.ae.r;

import com.bytedance.msdk.cw.r.g;
import com.bytedance.msdk.tl.i;
import com.bytedance.sdk.gromore.j.j.r.az;
import com.bytedance.sdk.gromore.j.j.r.ws;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements ws {
    private g cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.xt.cw f27385j;
    private com.bytedance.msdk.api.j.xt xt;

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public boolean j() {
        if (this.xt == null || this.f27385j == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f27385j);
        com.bytedance.msdk.up.m.j(arrayList, (List<com.bytedance.msdk.xt.cw>) null, (List<com.bytedance.msdk.xt.cw>) null, this.xt, 0);
        return this.f27385j.wq(this.xt.v());
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public boolean ae() {
        com.bytedance.msdk.xt.cw cwVar = this.f27385j;
        if (cwVar != null) {
            return cwVar.kt();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> cw() {
        List<com.bytedance.msdk.api.cw> qv;
        ArrayList arrayList = new ArrayList();
        g gVar = this.cw;
        if (gVar != null && (qv = gVar.qv()) != null) {
            for (com.bytedance.msdk.api.cw cwVar : qv) {
                if (cwVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.m(cwVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void g() {
        com.bytedance.msdk.xt.cw cwVar = this.f27385j;
        if (cwVar != null) {
            cwVar.i();
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt m() {
        com.bytedance.msdk.xt.cw cwVar = this.f27385j;
        return (cwVar == null || !cwVar.ya() || i.j()) ? new com.bytedance.sdk.gromore.j.j.r.up() : new com.bytedance.sdk.gromore.j.j.r.m(com.bytedance.msdk.tl.ws.j(this.xt, this.f27385j, true));
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void oq() {
        com.bytedance.msdk.xt.cw cwVar = this.f27385j;
        if (cwVar != null) {
            cwVar.av();
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt r() {
        com.bytedance.msdk.api.j.xt xtVar;
        return (this.f27385j == null || (xtVar = this.xt) == null) ? new com.bytedance.sdk.gromore.j.j.r.up() : (xtVar.sm() || com.bytedance.msdk.core.xt.xt().x()) ? new com.bytedance.sdk.gromore.j.j.r.m(com.bytedance.msdk.tl.ws.j(this.xt, this.f27385j, false)) : new com.bytedance.sdk.gromore.j.j.r.up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public boolean tl() {
        com.bytedance.msdk.xt.cw cwVar = this.f27385j;
        if (cwVar != null) {
            return cwVar.aq();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> up() {
        List<com.bytedance.msdk.api.cw> vl;
        ArrayList arrayList = new ArrayList();
        g gVar = this.cw;
        if (gVar != null && (vl = gVar.vl()) != null) {
            for (com.bytedance.msdk.api.cw cwVar : vl) {
                if (cwVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.m(cwVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.r> xt() {
        List<com.bytedance.msdk.api.xt> oq;
        ArrayList arrayList = new ArrayList();
        g gVar = this.cw;
        if (gVar != null && (oq = gVar.oq()) != null) {
            for (com.bytedance.msdk.api.xt xtVar : oq) {
                if (xtVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.j(xtVar));
                }
            }
        }
        return arrayList;
    }

    public cw(g gVar, com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar) {
        this.f27385j = cwVar;
        this.xt = xtVar;
        this.cw = gVar;
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void j(boolean z5) {
        com.bytedance.msdk.xt.cw cwVar = this.f27385j;
        if (cwVar != null) {
            cwVar.r(z5);
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void j(final az azVar) {
        com.bytedance.msdk.xt.cw cwVar = this.f27385j;
        if (cwVar != null) {
            cwVar.j(new com.bytedance.msdk.api.r.j.r() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.cw.1
                @Override // com.bytedance.msdk.api.r.j.r
                public void j() {
                    az azVar2 = azVar;
                    if (azVar2 != null) {
                        azVar2.j();
                    }
                }
            });
        }
    }
}
