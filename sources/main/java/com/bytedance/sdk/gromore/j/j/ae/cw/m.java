package com.bytedance.sdk.gromore.j.j.ae.cw;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements com.bytedance.sdk.gromore.j.j.up.cw {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.cw.r.j f27360j;

    @Override // com.bytedance.sdk.gromore.j.j.up.cw
    public void ae() {
        com.bytedance.msdk.cw.r.j jVar = this.f27360j;
        if (jVar != null) {
            jVar.j();
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> cw() {
        List<com.bytedance.msdk.api.cw> qv;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.cw.r.j jVar = this.f27360j;
        if (jVar != null && (qv = jVar.qv()) != null) {
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
        com.bytedance.msdk.cw.r.j jVar = this.f27360j;
        if (jVar != null) {
            return jVar.a();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt m() {
        com.bytedance.msdk.cw.r.j jVar = this.f27360j;
        return jVar != null ? new com.bytedance.sdk.gromore.j.j.r.m(jVar.az()) : new com.bytedance.sdk.gromore.j.j.r.up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt r() {
        com.bytedance.msdk.cw.r.j jVar = this.f27360j;
        return jVar != null ? new com.bytedance.sdk.gromore.j.j.r.m(jVar.av()) : new com.bytedance.sdk.gromore.j.j.r.up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> up() {
        List<com.bytedance.msdk.api.cw> vl;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.cw.r.j jVar = this.f27360j;
        if (jVar != null && (vl = jVar.vl()) != null) {
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
        com.bytedance.msdk.cw.r.j jVar = this.f27360j;
        if (jVar != null && (oq = jVar.oq()) != null) {
            for (com.bytedance.msdk.api.xt xtVar : oq) {
                if (xtVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.j(xtVar));
                }
            }
        }
        return arrayList;
    }

    public m(com.bytedance.msdk.cw.r.j jVar) {
        this.f27360j = jVar;
    }
}
