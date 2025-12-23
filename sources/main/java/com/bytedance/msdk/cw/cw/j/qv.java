package com.bytedance.msdk.cw.cw.j;

import com.bytedance.msdk.cw.cw.j.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv implements j {
    @Override // com.bytedance.msdk.cw.cw.j.j
    public void xt(j.InterfaceC0365j interfaceC0365j) {
        interfaceC0365j.j((String) null);
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void j(j.InterfaceC0365j interfaceC0365j) {
        String str;
        String str2;
        String str3;
        com.bytedance.msdk.cw.m.j.xt j6 = interfaceC0365j.j();
        com.bytedance.msdk.api.j.xt mi = j6.mi();
        mi.v();
        if (mi.sm()) {
            String str4 = com.bytedance.msdk.j.up.up.j(mi.v()) + "V2 公共缓存池广告请求......";
            String str5 = MediationConstant.TAG;
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, str4);
            if (j6.vl() != null) {
                str = j6.vl().hh();
            } else {
                str = null;
            }
            boolean z5 = !j6.v();
            if (com.bytedance.msdk.core.xt.xt().m()) {
                List<com.bytedance.msdk.core.up.xt.ae> j7 = com.bytedance.msdk.cw.up.j.j().j(mi);
                if (j7 != null && !j7.isEmpty()) {
                    com.bytedance.msdk.up.m.j(j7.get(0).f24739j, mi, j6.vl(), 0L, j6.wq().f24631j, z5, j7.size(), j6.wq().up, false);
                    com.bytedance.msdk.api.j.xt xtVar = mi;
                    int size = j7.size() - 1;
                    String str6 = null;
                    while (size >= 0) {
                        com.bytedance.msdk.core.up.xt.ae aeVar = j7.get(size);
                        com.bytedance.msdk.xt.cw cwVar = aeVar.f24739j;
                        cwVar.j(aeVar.m());
                        if (aeVar.r() != null) {
                            str2 = aeVar.r().j();
                        } else {
                            str2 = null;
                        }
                        cwVar.xt(str2);
                        if (size == 0) {
                            str6 = aeVar.m();
                        }
                        String str7 = str6;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(cwVar);
                        com.bytedance.msdk.cw.up.j.j(xtVar, aeVar.m());
                        com.bytedance.msdk.core.oq.oq m6 = com.bytedance.msdk.core.xt.xt().j(aeVar.m(), xtVar.f(), 102).m(cwVar.qa());
                        String j8 = com.bytedance.msdk.core.up.j.j.j().j(cwVar.qa());
                        if (aeVar.r() != null) {
                            str3 = aeVar.r().j();
                        } else {
                            str3 = null;
                        }
                        int i6 = size;
                        com.bytedance.msdk.api.j.xt xtVar2 = xtVar;
                        com.bytedance.msdk.up.m.j(m6, xtVar2, j8, true, 1, 0, 3, 3, null, -1L, false, false, str3);
                        j6.j(arrayList);
                        com.bytedance.msdk.up.m.j(cwVar, 0, "adn cache命中", 0L, xtVar2, 0, arrayList.size(), 2, (String) null, 0L, -1L);
                        xtVar = xtVar2;
                        size = i6 - 1;
                        str5 = str5;
                        str6 = str7;
                        j7 = j7;
                    }
                    com.bytedance.msdk.cw.up.j.j(xtVar, str6);
                    com.bytedance.msdk.j.up.cw.xt(str5, com.bytedance.msdk.j.up.up.j(xtVar.v()) + "V2 resetAdLinkInfo......");
                    com.bytedance.msdk.up.m.j(xtVar, str, z5, j6.wq().f24631j, 0, (Map<String, Object>) null);
                    j6.r();
                    return;
                }
                com.bytedance.msdk.cw.up.j.j(mi, "-1");
                com.bytedance.msdk.api.xt.j jVar = new com.bytedance.msdk.api.xt.j(41008, com.bytedance.msdk.api.j.j(41008));
                com.bytedance.msdk.up.m.j(mi, str, z5, j6.wq().f24631j, jVar.f24334j, (Map<String, Object>) null);
                j6.j(jVar);
                return;
            }
            com.bytedance.msdk.cw.up.j.j(mi, "-2");
            com.bytedance.msdk.api.xt.j jVar2 = new com.bytedance.msdk.api.xt.j(41007, com.bytedance.msdk.api.j.j(41007));
            com.bytedance.msdk.up.m.j(mi, str, z5, j6.wq().f24631j, jVar2.f24334j, (Map<String, Object>) null);
            j6.j(jVar2);
            return;
        }
        interfaceC0365j.j(interfaceC0365j.j());
    }
}
