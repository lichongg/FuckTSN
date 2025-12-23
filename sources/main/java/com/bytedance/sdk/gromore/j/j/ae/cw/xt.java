package com.bytedance.sdk.gromore.j.j.ae.cw;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bytedance.sdk.gromore.j.j.up.cw {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.cw.r.tl f27365j;

    @Override // com.bytedance.sdk.gromore.j.j.up.cw
    public void ae() {
        com.bytedance.msdk.cw.r.tl tlVar = this.f27365j;
        if (tlVar != null) {
            tlVar.j();
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> cw() {
        List<com.bytedance.msdk.api.cw> qv;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.cw.r.tl tlVar = this.f27365j;
        if (tlVar != null && (qv = tlVar.qv()) != null) {
            for (com.bytedance.msdk.api.cw cwVar : qv) {
                if (cwVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.m(cwVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public boolean j() {
        com.bytedance.msdk.cw.r.tl tlVar = this.f27365j;
        if (tlVar != null) {
            return tlVar.a();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt m() {
        com.bytedance.msdk.cw.r.tl tlVar = this.f27365j;
        return tlVar != null ? new com.bytedance.sdk.gromore.j.j.r.m(tlVar.az()) : new com.bytedance.sdk.gromore.j.j.r.up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt r() {
        com.bytedance.msdk.cw.r.tl tlVar = this.f27365j;
        return tlVar != null ? new com.bytedance.sdk.gromore.j.j.r.m(tlVar.av()) : new com.bytedance.sdk.gromore.j.j.r.up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> up() {
        List<com.bytedance.msdk.api.cw> vl;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.cw.r.tl tlVar = this.f27365j;
        if (tlVar != null && (vl = tlVar.vl()) != null) {
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
        com.bytedance.msdk.cw.r.tl tlVar = this.f27365j;
        if (tlVar != null && (oq = tlVar.oq()) != null) {
            for (com.bytedance.msdk.api.xt xtVar : oq) {
                if (xtVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.j(xtVar));
                }
            }
        }
        return arrayList;
    }

    public xt(com.bytedance.msdk.cw.r.tl tlVar) {
        this.f27365j = tlVar;
    }
}
