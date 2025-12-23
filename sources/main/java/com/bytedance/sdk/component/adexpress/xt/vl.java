package com.bytedance.sdk.component.adexpress.xt;

import com.bytedance.sdk.component.adexpress.xt.oq;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl implements oq.j {
    private g cw;

    /* renamed from: j, reason: collision with root package name */
    az f26047j;

    /* renamed from: r, reason: collision with root package name */
    private AtomicBoolean f26048r = new AtomicBoolean(false);
    private List<oq> xt;

    @Override // com.bytedance.sdk.component.adexpress.xt.oq.j
    public void j() {
        this.cw.m();
        Iterator<oq> it = this.xt.iterator();
        while (it.hasNext() && !it.next().j(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq.j
    public boolean xt(oq oqVar) {
        int indexOf = this.xt.indexOf(oqVar);
        return indexOf < this.xt.size() - 1 && indexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq.j
    public boolean cw() {
        return this.f26048r.get();
    }

    public vl(List<oq> list, g gVar) {
        this.xt = list;
        this.cw = gVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq.j
    public az xt() {
        return this.f26047j;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq.j
    public void j(oq oqVar) {
        int indexOf = this.xt.indexOf(oqVar);
        if (indexOf < 0) {
            return;
        }
        do {
            indexOf++;
            if (indexOf >= this.xt.size()) {
                return;
            }
        } while (!this.xt.get(indexOf).j(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq.j
    public void j(az azVar) {
        this.f26047j = azVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq.j
    public void j(boolean z5) {
        this.f26048r.getAndSet(z5);
    }
}
