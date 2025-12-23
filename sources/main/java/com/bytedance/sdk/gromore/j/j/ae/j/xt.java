package com.bytedance.sdk.gromore.j.j.ae.j;

import com.bytedance.msdk.cw.r.qv;
import com.bytedance.sdk.gromore.j.j.r;
import com.bytedance.sdk.gromore.j.j.r.az;
import com.bytedance.sdk.gromore.j.j.r.m;
import com.bytedance.sdk.gromore.j.j.r.up;
import com.bytedance.sdk.gromore.j.j.r.ws;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements ws {

    /* renamed from: j, reason: collision with root package name */
    private qv f27374j;

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public boolean ae() {
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void j(az azVar) {
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public boolean tl() {
        return false;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> cw() {
        List<com.bytedance.msdk.api.cw> g6;
        ArrayList arrayList = new ArrayList();
        qv qvVar = this.f27374j;
        if (qvVar != null && (g6 = qvVar.g()) != null) {
            for (com.bytedance.msdk.api.cw cwVar : g6) {
                if (cwVar != null) {
                    arrayList.add(new m(cwVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void g() {
        qv qvVar = this.f27374j;
        if (qvVar != null) {
            qvVar.j();
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void j(boolean z5) {
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt m() {
        qv qvVar = this.f27374j;
        return qvVar != null ? new m(qvVar.vl()) : new up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.r.ws
    public void oq() {
        qv qvVar = this.f27374j;
        if (qvVar != null) {
            qvVar.xt();
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public com.bytedance.sdk.gromore.j.j.xt r() {
        qv qvVar = this.f27374j;
        return qvVar != null ? new m(qvVar.oq()) : new up();
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<com.bytedance.sdk.gromore.j.j.xt> up() {
        List<com.bytedance.msdk.api.cw> qv;
        ArrayList arrayList = new ArrayList();
        qv qvVar = this.f27374j;
        if (qvVar != null && (qv = qvVar.qv()) != null) {
            for (com.bytedance.msdk.api.cw cwVar : qv) {
                if (cwVar != null) {
                    arrayList.add(new m(cwVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public List<r> xt() {
        List<com.bytedance.msdk.api.xt> tl;
        ArrayList arrayList = new ArrayList();
        qv qvVar = this.f27374j;
        if (qvVar != null && (tl = qvVar.tl()) != null) {
            for (com.bytedance.msdk.api.xt xtVar : tl) {
                if (xtVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.j.j.r.j(xtVar));
                }
            }
        }
        return arrayList;
    }

    public xt(qv qvVar) {
        this.f27374j = qvVar;
    }

    @Override // com.bytedance.sdk.gromore.j.j.cw
    public boolean j() {
        qv qvVar = this.f27374j;
        if (qvVar != null) {
            return qvVar.r();
        }
        return false;
    }
}
