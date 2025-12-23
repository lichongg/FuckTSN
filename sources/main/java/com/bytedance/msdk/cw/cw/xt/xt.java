package com.bytedance.msdk.cw.cw.xt;

import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.cw.cw.xt.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements j {
    @Override // com.bytedance.msdk.cw.cw.xt.j
    public void j(j.InterfaceC0366j interfaceC0366j) {
        com.bytedance.msdk.cw.m.xt.xt j6 = interfaceC0366j.j();
        com.bytedance.msdk.cw.m.j.xt xt = interfaceC0366j.xt();
        oq tl = j6.tl();
        if (tl == null) {
            com.bytedance.msdk.api.j jVar = new com.bytedance.msdk.api.j(840040, com.bytedance.msdk.api.j.j(840040));
            com.bytedance.msdk.up.m.j(tl, xt.mi(), "", j6.up(), 2, j6.cw(), j6.ae(), j6.m(), jVar, -1L, xt.wq().up, false);
            com.bytedance.msdk.up.m.j(jVar, xt.mi(), tl, j6.cw(), j6.ae(), j6.m(), "", 0L, (String) null, (String) null, (String) null, 0L);
            j6.j(jVar, tl);
            return;
        }
        interfaceC0366j.j(this);
    }
}
