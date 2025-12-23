package com.bytedance.msdk.cw.cw.xt;

import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.up.xt.ae;
import com.bytedance.msdk.cw.cw.xt.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m implements j {
    @Override // com.bytedance.msdk.cw.cw.xt.j
    public void j(j.InterfaceC0366j interfaceC0366j) {
        List<ae> j6;
        oq tl = interfaceC0366j.j().tl();
        com.bytedance.msdk.api.j.xt mi = interfaceC0366j.xt().mi();
        if (tl != null) {
            String w5 = tl.w();
            if (tl.kt() && com.bytedance.msdk.core.up.j.j.j().r(mi.v(), w5, mi.up())) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "--==-- 广告复用，模式：" + com.bytedance.msdk.core.up.j.j.j().up(mi.v(), w5, mi.up()));
                int j7 = com.bytedance.msdk.core.up.j.j.j().j(w5, mi, true);
                interfaceC0366j.j().cw(j7);
                if (j7 == 3) {
                    interfaceC0366j.j().j(2);
                    if (j(interfaceC0366j.xt(), interfaceC0366j.j(), mi, w5, tl, 2)) {
                        return;
                    }
                } else if (j7 == 2 && (j6 = com.bytedance.msdk.core.up.j.j.j().j(w5, mi, mi.up())) != null && j6.size() > 0) {
                    interfaceC0366j.j().xt(j6.get(0).f24739j.tl(mi.j()));
                }
                interfaceC0366j.j(this);
            }
        }
        interfaceC0366j.j(this);
    }

    private boolean j(com.bytedance.msdk.cw.m.j.xt xtVar, com.bytedance.msdk.cw.m.xt.xt xtVar2, com.bytedance.msdk.api.j.xt xtVar3, String str, oq oqVar, int i6) {
        com.bytedance.msdk.core.up.j.j.j().j(xtVar3.v(), str, oqVar, i6);
        List<ae> j6 = com.bytedance.msdk.core.up.j.j.j().j(str, xtVar3, xtVar3.up());
        if (j6 == null || j6.size() <= 0) {
            return false;
        }
        int tl = j6.get(0).f24739j.tl(xtVar3.j());
        com.bytedance.msdk.up.m.j(oqVar, xtVar3, com.bytedance.msdk.core.up.j.j.j().j(str), !xtVar.v(), 1, i6, 3, tl, (com.bytedance.msdk.api.j) null, -1L, false, false);
        ArrayList arrayList = new ArrayList();
        for (ae aeVar : j6) {
            aeVar.f24739j.g(3);
            aeVar.f24739j.oq(tl);
            aeVar.f24739j.cw(false);
            aeVar.f24739j.xt(false);
            com.bytedance.msdk.cw.tl.up.j(aeVar.f24739j, xtVar3.v(), str);
            arrayList.add(aeVar.f24739j);
        }
        com.bytedance.msdk.up.m.j(j6.get(0).f24739j, 0, "adn cache命中", 0L, xtVar3, i6, arrayList.size(), 2, (String) null, 0L, -1L);
        xtVar2.j(arrayList, oqVar);
        return true;
    }
}
