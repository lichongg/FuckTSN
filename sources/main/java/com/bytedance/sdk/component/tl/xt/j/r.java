package com.bytedance.sdk.component.tl.xt.j;

import android.content.Context;
import com.bytedance.sdk.component.tl.xt.j.j.xt.ae;
import com.bytedance.sdk.component.tl.xt.j.j.xt.tl;
import com.bytedance.sdk.component.utils.vl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements up {
    private com.bytedance.sdk.component.tl.xt.r.xt.j ae;
    private com.bytedance.sdk.component.tl.xt.j.j.xt.up cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.component.tl.xt.r.xt.j f26778g;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.component.tl.xt.j.j.xt.r f26779j;
    private com.bytedance.sdk.component.tl.j.up jy;

    /* renamed from: m, reason: collision with root package name */
    private tl f26780m;
    private com.bytedance.sdk.component.tl.xt.r.xt.j oq;
    private com.bytedance.sdk.component.tl.xt.r.xt.j qv;

    /* renamed from: r, reason: collision with root package name */
    private ae f26781r;
    private com.bytedance.sdk.component.tl.xt.r.xt.j tl;
    private com.bytedance.sdk.component.tl.xt.j.j.xt.j up;
    private com.bytedance.sdk.component.tl.xt.r.xt.j vl;
    private List<com.bytedance.sdk.component.tl.xt.j.j.xt.xt> ws = new ArrayList();
    private com.bytedance.sdk.component.tl.xt.j.j.xt.m xt;

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public List<com.bytedance.sdk.component.tl.j.xt> j(int i6, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5, String str) {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public void j(com.bytedance.sdk.component.tl.j.xt xtVar) {
        if (xtVar == null) {
            return;
        }
        try {
            xtVar.xt(System.currentTimeMillis());
            Iterator<com.bytedance.sdk.component.tl.xt.j.j.xt.xt> it = this.ws.iterator();
            while (it.hasNext()) {
                it.next().xt(xtVar);
            }
        } catch (Throwable th) {
            vl.j(th);
            com.bytedance.sdk.component.tl.xt.cw.xt.j(com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.j(), 1, this.jy);
        }
    }

    public r(com.bytedance.sdk.component.tl.j.up upVar) {
        this.jy = upVar;
        Context context = upVar.getContext();
        if (com.bytedance.sdk.component.tl.xt.xt.j.j(upVar)) {
            com.bytedance.sdk.component.tl.xt.r.xt.j ae = this.jy.ae();
            this.ae = ae;
            com.bytedance.sdk.component.tl.xt.j.j.xt.r rVar = new com.bytedance.sdk.component.tl.xt.j.j.xt.r(context, ae, this.jy);
            this.f26779j = rVar;
            this.ws.add(rVar);
        }
        if (com.bytedance.sdk.component.tl.xt.xt.j.up(upVar)) {
            if (this.jy.j() != null) {
                this.f26778g = this.jy.j();
            } else {
                this.f26778g = this.jy.tl();
            }
            com.bytedance.sdk.component.tl.xt.j.j.xt.up upVar2 = new com.bytedance.sdk.component.tl.xt.j.j.xt.up(context, this.f26778g, this.jy);
            this.cw = upVar2;
            this.ws.add(upVar2);
        }
        if (com.bytedance.sdk.component.tl.xt.xt.j.xt(upVar)) {
            com.bytedance.sdk.component.tl.xt.r.xt.j tl = this.jy.tl();
            this.tl = tl;
            com.bytedance.sdk.component.tl.xt.j.j.xt.m mVar = new com.bytedance.sdk.component.tl.xt.j.j.xt.m(context, tl, this.jy);
            this.xt = mVar;
            this.ws.add(mVar);
        }
        if (com.bytedance.sdk.component.tl.xt.xt.j.cw(upVar)) {
            com.bytedance.sdk.component.tl.xt.r.xt.j tl2 = this.jy.tl();
            this.oq = tl2;
            ae aeVar = new ae(context, tl2, this.jy);
            this.f26781r = aeVar;
            this.ws.add(aeVar);
        }
        if (com.bytedance.sdk.component.tl.xt.xt.j.r(upVar)) {
            com.bytedance.sdk.component.tl.xt.r.xt.j g6 = this.jy.g();
            this.qv = g6;
            com.bytedance.sdk.component.tl.xt.j.j.xt.j jVar = new com.bytedance.sdk.component.tl.xt.j.j.xt.j(context, g6, this.jy);
            this.up = jVar;
            this.ws.add(jVar);
        }
        if (com.bytedance.sdk.component.tl.xt.xt.j.m(upVar)) {
            com.bytedance.sdk.component.tl.xt.r.xt.j m6 = this.jy.m();
            this.vl = m6;
            tl tlVar = new tl(context, m6, this.jy);
            this.f26780m = tlVar;
            this.ws.add(tlVar);
        }
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public xt j(int i6, List<com.bytedance.sdk.component.tl.j.xt> list, int i7) {
        Iterator<com.bytedance.sdk.component.tl.xt.j.j.xt.xt> it = this.ws.iterator();
        xt xtVar = null;
        while (it.hasNext()) {
            xtVar = it.next().j(i6, list);
            if (xtVar.j()) {
                break;
            }
        }
        return xtVar;
    }

    public List<com.bytedance.sdk.component.tl.j.xt> j(com.bytedance.sdk.component.tl.j.xt xtVar, int i6, int i7, boolean z5) {
        Iterator<com.bytedance.sdk.component.tl.xt.j.j.xt.xt> it = this.ws.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.tl.j.xt> j6 = it.next().j(i7, i6, xtVar, z5);
            if (j6 != null && j6.size() != 0) {
                return j6;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public List<com.bytedance.sdk.component.tl.j.xt> j(int i6, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5, List<String> list) {
        Iterator<com.bytedance.sdk.component.tl.xt.j.j.xt.xt> it = this.ws.iterator();
        while (it.hasNext()) {
            int i7 = i6;
            com.bytedance.sdk.component.tl.j.xt xtVar2 = xtVar;
            boolean z6 = z5;
            List<String> list2 = list;
            List<com.bytedance.sdk.component.tl.j.xt> j6 = it.next().j(i7, xtVar2, z6, list2, "db");
            if (j6 != null && j6.size() != 0) {
                return j6;
            }
            i6 = i7;
            xtVar = xtVar2;
            z5 = z6;
            list = list2;
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public boolean j(int i6, String str, com.bytedance.sdk.component.tl.j.xt xtVar) {
        Iterator<com.bytedance.sdk.component.tl.xt.j.j.xt.xt> it = this.ws.iterator();
        while (it.hasNext()) {
            if (it.next().j(i6, str, xtVar)) {
                return true;
            }
        }
        return false;
    }
}
