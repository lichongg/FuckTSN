package com.bytedance.sdk.gromore.j.j.ae.xt;

import com.bytedance.msdk.cw.r.ae;
import com.bytedance.msdk.tl.i;
import com.bytedance.sdk.gromore.j.j.r.az;
import com.bytedance.sdk.gromore.j.j.r.m;
import com.bytedance.sdk.gromore.j.j.r.up;
import com.bytedance.sdk.gromore.j.j.r.ws;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements ws {
    private ae cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.xt.cw f27452j;
    private com.bytedance.msdk.api.j.xt xt;

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void j(az azVar) {
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public boolean ae() {
        com.bytedance.msdk.xt.cw cwVar = this.f27452j;
        if (cwVar != null) {
            return cwVar.kt();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> cw() {
        List<com.bytedance.msdk.api.cw> qv;
        ArrayList arrayList = new ArrayList();
        ae aeVar = this.cw;
        if (aeVar != null && (qv = aeVar.qv()) != null) {
            for (com.bytedance.msdk.api.cw cwVar : qv) {
                if (cwVar != null) {
                    arrayList.add(new m(cwVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void g() {
        com.bytedance.msdk.xt.cw cwVar = this.f27452j;
        if (cwVar != null) {
            cwVar.i();
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public boolean j() {
        if (this.f27452j == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f27452j);
        com.bytedance.msdk.up.m.j(arrayList, (List<com.bytedance.msdk.xt.cw>) null, (List<com.bytedance.msdk.xt.cw>) null, this.xt, 0);
        com.bytedance.msdk.api.j.xt xtVar = this.xt;
        if (xtVar != null) {
            return this.f27452j.wq(xtVar.v());
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt m() {
        com.bytedance.msdk.xt.cw cwVar = this.f27452j;
        return (cwVar == null || !cwVar.ya() || i.j()) ? new up() : new m(com.bytedance.msdk.tl.ws.j(this.xt, this.f27452j, true));
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void oq() {
        com.bytedance.msdk.xt.cw cwVar = this.f27452j;
        if (cwVar != null) {
            cwVar.av();
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt r() {
        return (this.f27452j == null || !com.bytedance.msdk.core.xt.xt().x()) ? new up() : new m(com.bytedance.msdk.tl.ws.j(this.xt, this.f27452j, false));
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public boolean tl() {
        com.bytedance.msdk.xt.cw cwVar = this.f27452j;
        if (cwVar != null) {
            return cwVar.aq();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> up() {
        List<com.bytedance.msdk.api.cw> vl;
        ArrayList arrayList = new ArrayList();
        ae aeVar = this.cw;
        if (aeVar != null && (vl = aeVar.vl()) != null) {
            for (com.bytedance.msdk.api.cw cwVar : vl) {
                if (cwVar != null) {
                    arrayList.add(new m(cwVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.r> xt() {
        List<com.bytedance.msdk.api.xt> oq;
        ArrayList arrayList = new ArrayList();
        ae aeVar = this.cw;
        if (aeVar != null && (oq = aeVar.oq()) != null) {
            for (com.bytedance.msdk.api.xt xtVar : oq) {
                if (xtVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.j(xtVar));
                }
            }
        }
        return arrayList;
    }

    public xt(ae aeVar, com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar) {
        this.f27452j = cwVar;
        this.xt = xtVar;
        this.cw = aeVar;
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void j(boolean z5) {
        com.bytedance.msdk.xt.cw cwVar = this.f27452j;
        if (cwVar != null) {
            cwVar.r(z5);
        }
    }
}
