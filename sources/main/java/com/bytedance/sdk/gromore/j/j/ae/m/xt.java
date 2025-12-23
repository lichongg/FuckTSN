package com.bytedance.sdk.gromore.j.j.ae.m;

import com.bytedance.msdk.cw.r.jy;
import com.bytedance.sdk.gromore.j.j.r;
import com.bytedance.sdk.gromore.j.j.r.m;
import com.bytedance.sdk.gromore.j.j.r.up;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bytedance.sdk.gromore.j.j.up.cw {

    /* renamed from: j, reason: collision with root package name */
    private jy f27384j;

    @Override // com.bytedance.sdk.gromore.j.j.up.cw
    public void ae() {
        jy jyVar = this.f27384j;
        if (jyVar != null) {
            jyVar.j();
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> cw() {
        List<com.bytedance.msdk.api.cw> qv;
        ArrayList arrayList = new ArrayList();
        jy jyVar = this.f27384j;
        if (jyVar != null && (qv = jyVar.qv()) != null) {
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
        jy jyVar = this.f27384j;
        if (jyVar != null) {
            return jyVar.tj();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt m() {
        jy jyVar = this.f27384j;
        return jyVar != null ? new m(jyVar.az()) : new up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt r() {
        jy jyVar = this.f27384j;
        return jyVar != null ? new m(jyVar.av()) : new up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> up() {
        List<com.bytedance.msdk.api.cw> vl;
        ArrayList arrayList = new ArrayList();
        jy jyVar = this.f27384j;
        if (jyVar != null && (vl = jyVar.vl()) != null) {
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
        jy jyVar = this.f27384j;
        if (jyVar != null && (oq = jyVar.oq()) != null) {
            for (com.bytedance.msdk.api.xt xtVar : oq) {
                if (xtVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.j(xtVar));
                }
            }
        }
        return arrayList;
    }

    public xt(jy jyVar) {
        this.f27384j = jyVar;
    }
}
