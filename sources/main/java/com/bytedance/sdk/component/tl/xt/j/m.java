package com.bytedance.sdk.component.tl.xt.j;

import com.acse.ottn.l3;
import com.bytedance.sdk.component.tl.xt.j.xt.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements up {

    /* renamed from: j, reason: collision with root package name */
    private List<com.bytedance.sdk.component.tl.xt.j.xt.j> f26777j = new ArrayList();

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public List<com.bytedance.sdk.component.tl.j.xt> j(int i6, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5, String str) {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public void j(com.bytedance.sdk.component.tl.j.xt xtVar) {
        Iterator<com.bytedance.sdk.component.tl.xt.j.xt.j> it = this.f26777j.iterator();
        while (it.hasNext()) {
            it.next().xt(xtVar);
        }
    }

    public m(Queue<String> queue, com.bytedance.sdk.component.tl.j.up upVar) {
        com.bytedance.sdk.component.tl.xt.r.xt.j tl;
        if (com.bytedance.sdk.component.tl.xt.xt.j.j(upVar)) {
            this.f26777j.add(new com.bytedance.sdk.component.tl.xt.j.xt.cw(upVar.ae(), queue, upVar));
        }
        if (com.bytedance.sdk.component.tl.xt.xt.j.up(upVar)) {
            if (upVar.j() != null) {
                tl = upVar.j();
            } else {
                tl = upVar.tl();
            }
            this.f26777j.add(new com.bytedance.sdk.component.tl.xt.j.xt.r(tl, queue, upVar));
        }
        if (com.bytedance.sdk.component.tl.xt.xt.j.xt(upVar)) {
            this.f26777j.add(new com.bytedance.sdk.component.tl.xt.j.xt.up(upVar.tl(), queue, upVar));
        }
        if (com.bytedance.sdk.component.tl.xt.xt.j.cw(upVar)) {
            this.f26777j.add(new com.bytedance.sdk.component.tl.xt.j.xt.m(upVar.tl(), queue, upVar));
        }
        if (com.bytedance.sdk.component.tl.xt.xt.j.r(upVar)) {
            this.f26777j.add(new com.bytedance.sdk.component.tl.xt.j.xt.xt(upVar.g(), queue, upVar));
        }
        if (com.bytedance.sdk.component.tl.xt.xt.j.m(upVar)) {
            this.f26777j.add(new ae(upVar.m(), queue, upVar));
        }
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public xt j(int i6, List<com.bytedance.sdk.component.tl.j.xt> list, int i7) {
        Iterator<com.bytedance.sdk.component.tl.xt.j.xt.j> it = this.f26777j.iterator();
        xt xtVar = null;
        while (it.hasNext()) {
            xtVar = it.next().j(i6, list, i7);
            if (xtVar.j()) {
                break;
            }
        }
        return xtVar;
    }

    @Override // com.bytedance.sdk.component.tl.xt.j.up
    public List<com.bytedance.sdk.component.tl.j.xt> j(int i6, com.bytedance.sdk.component.tl.j.xt xtVar, boolean z5, List<String> list) {
        Iterator<com.bytedance.sdk.component.tl.xt.j.xt.j> it = this.f26777j.iterator();
        while (it.hasNext()) {
            int i7 = i6;
            com.bytedance.sdk.component.tl.j.xt xtVar2 = xtVar;
            boolean z6 = z5;
            List<String> list2 = list;
            List<com.bytedance.sdk.component.tl.j.xt> j6 = it.next().j(i7, xtVar2, z6, list2, l3.f4736f);
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
        Iterator<com.bytedance.sdk.component.tl.xt.j.xt.j> it = this.f26777j.iterator();
        while (it.hasNext()) {
            if (it.next().j(i6, str, xtVar)) {
                return true;
            }
        }
        return false;
    }
}
