package com.bytedance.msdk.cw.cw.xt;

import com.bytedance.msdk.cw.cw.xt.j;
import com.bytedance.msdk.tl.p;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up implements j.InterfaceC0366j {
    private com.bytedance.msdk.cw.m.j.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private List<j> f24988j = new CopyOnWriteArrayList();
    private com.bytedance.msdk.cw.m.xt.xt xt;

    public void j(com.bytedance.msdk.cw.m.j.xt xtVar, com.bytedance.msdk.cw.m.xt.xt xtVar2) {
        this.cw = xtVar;
        this.xt = xtVar2;
        if (p.j(this.f24988j)) {
            return;
        }
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.cw.cw.xt.up.1
            @Override // java.lang.Runnable
            public void run() {
                ((j) up.this.f24988j.get(0)).j(up.this);
            }
        });
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.InterfaceC0366j
    public com.bytedance.msdk.cw.m.j.xt xt() {
        return this.cw;
    }

    public up(List<j> list) {
        if (!p.j(list)) {
            this.f24988j.addAll(list);
        }
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.InterfaceC0366j
    public com.bytedance.msdk.cw.m.xt.xt j() {
        return this.xt;
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.InterfaceC0366j
    public void j(j jVar) {
        int indexOf;
        if (p.j(this.f24988j) || jVar == null || (indexOf = this.f24988j.indexOf(jVar)) == -1 || indexOf >= this.f24988j.size() - 1) {
            return;
        }
        this.f24988j.get(indexOf + 1).j(this);
    }
}
