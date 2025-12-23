package com.bytedance.sdk.gromore.j.j.ae.up;

import com.bytedance.msdk.cw.r.vl;
import com.bytedance.sdk.gromore.j.j.r;
import com.bytedance.sdk.gromore.j.j.r.m;
import com.bytedance.sdk.gromore.j.j.r.up;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bytedance.sdk.gromore.j.j.up.cw {

    /* renamed from: j, reason: collision with root package name */
    private vl f27435j;

    @Override // com.bytedance.sdk.gromore.j.j.up.cw
    public void ae() {
        vl vlVar = this.f27435j;
        if (vlVar != null) {
            vlVar.j();
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> cw() {
        List<com.bytedance.msdk.api.cw> qv;
        ArrayList arrayList = new ArrayList();
        vl vlVar = this.f27435j;
        if (vlVar != null && (qv = vlVar.qv()) != null) {
            for (com.bytedance.msdk.api.cw cwVar : qv) {
                if (cwVar != null) {
                    arrayList.add(new m(cwVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public boolean j() {
        vl vlVar = this.f27435j;
        if (vlVar != null) {
            return vlVar.a();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt m() {
        vl vlVar = this.f27435j;
        return vlVar != null ? new m(vlVar.az()) : new up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt r() {
        vl vlVar = this.f27435j;
        return vlVar != null ? new m(vlVar.av()) : new up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> up() {
        List<com.bytedance.msdk.api.cw> vl;
        ArrayList arrayList = new ArrayList();
        vl vlVar = this.f27435j;
        if (vlVar != null && (vl = vlVar.vl()) != null) {
            for (com.bytedance.msdk.api.cw cwVar : vl) {
                if (cwVar != null) {
                    arrayList.add(new m(cwVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<r> xt() {
        List<com.bytedance.msdk.api.xt> oq;
        ArrayList arrayList = new ArrayList();
        vl vlVar = this.f27435j;
        if (vlVar != null && (oq = vlVar.oq()) != null) {
            for (com.bytedance.msdk.api.xt xtVar : oq) {
                if (xtVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.j(xtVar));
                }
            }
        }
        return arrayList;
    }

    public xt(vl vlVar) {
        this.f27435j = vlVar;
    }
}
