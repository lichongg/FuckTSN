package com.bytedance.msdk.cw.cw.j;

import android.util.Pair;
import com.bytedance.msdk.cw.cw.j.j;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m implements j {
    @Override // com.bytedance.msdk.cw.cw.j.j
    public void j(j.InterfaceC0365j interfaceC0365j) {
        com.bytedance.msdk.cw.m.j.xt j6 = interfaceC0365j.j();
        String v5 = j6.mi().v();
        com.bytedance.msdk.core.oq.xt vl = j6.vl();
        if (vl != null && vl.oq()) {
            if (!com.bytedance.msdk.core.tl.jy.j().tl(String.valueOf(v5))) {
                com.bytedance.msdk.j.up.cw.xt("TMe", "广告位 请求触发次数拦截............");
                Pair<String, String> m6 = com.bytedance.msdk.core.tl.jy.j().m(v5);
                com.bytedance.msdk.api.xt.xt xtVar = new com.bytedance.msdk.api.xt.xt(840041, com.bytedance.msdk.api.j.j(840041), m6 != null ? (String) m6.second : "", m6 != null ? (String) m6.first : "");
                j(j6, xtVar.f24334j);
                j6.j(xtVar);
                return;
            }
            if (!com.bytedance.msdk.core.tl.jy.j().cw(String.valueOf(v5)) && !j6.v()) {
                com.bytedance.msdk.j.up.cw.xt("TMe", "广告位 请求触发时间间隔拦截............");
                com.bytedance.msdk.core.tl.g up = com.bytedance.msdk.core.tl.jy.j().up(String.valueOf(v5));
                String j7 = com.bytedance.msdk.api.j.j(840042);
                StringBuilder sb = new StringBuilder();
                sb.append(com.bytedance.msdk.core.tl.jy.j().j(v5));
                com.bytedance.msdk.api.xt.cw cwVar = new com.bytedance.msdk.api.xt.cw(840042, j7, sb.toString(), up != null ? up.oq() : "");
                j(j6, cwVar.f24334j);
                j6.j(cwVar);
                return;
            }
        }
        interfaceC0365j.j(interfaceC0365j.j());
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void xt(j.InterfaceC0365j interfaceC0365j) {
        interfaceC0365j.j((String) null);
    }

    private void j(com.bytedance.msdk.cw.m.j.xt xtVar, int i6) {
        com.bytedance.msdk.up.m.j(xtVar.mi(), (String) null, !xtVar.v(), xtVar.wq().f24631j, i6, (Map<String, Object>) null);
    }
}
