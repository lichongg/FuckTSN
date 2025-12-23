package com.bytedance.msdk.cw.cw.xt;

import android.util.Pair;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.tl.g;
import com.bytedance.msdk.core.tl.qv;
import com.bytedance.msdk.core.tl.vl;
import com.bytedance.msdk.core.tl.ws;
import com.bytedance.msdk.cw.cw.xt.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements j {
    @Override // com.bytedance.msdk.cw.cw.xt.j
    public void j(j.InterfaceC0366j interfaceC0366j) {
        com.bytedance.msdk.api.j jVar;
        com.bytedance.msdk.api.j jVar2;
        com.bytedance.msdk.cw.m.xt.xt j6 = interfaceC0366j.j();
        com.bytedance.msdk.cw.m.j.xt xt = interfaceC0366j.xt();
        oq tl = j6.tl();
        String v5 = xt.mi().v();
        if (tl != null) {
            if (tl.r() && !qv.j().cw(v5, tl.w())) {
                com.bytedance.msdk.j.up.cw.xt("TMe", "adn 请求触发次数拦截............");
                Pair<String, String> j7 = qv.j().j(v5, tl.w());
                if (j7 != null) {
                    jVar2 = new com.bytedance.msdk.api.xt.xt(41041, com.bytedance.msdk.api.j.j(41041), (String) j7.second, (String) j7.first);
                } else {
                    jVar2 = new com.bytedance.msdk.api.j(41041, com.bytedance.msdk.api.j.j(41041));
                }
                com.bytedance.msdk.api.j jVar3 = jVar2;
                com.bytedance.msdk.up.m.j(tl, xt.mi(), com.bytedance.msdk.core.up.j.j.j().j(tl.w()), j6.up(), 2, j6.cw(), j6.ae(), j6.m(), jVar3, -1L, xt.wq().up, false);
                com.bytedance.msdk.up.m.j(jVar3, xt.mi(), tl, j6.cw(), j6.ae(), j6.m(), com.bytedance.msdk.core.up.j.j.j().j(tl.w()), 0L, (String) null, (String) null, (String) null, 0L);
                j6.j(jVar3, tl);
                return;
            }
            if (tl.r() && !vl.j().cw(v5, tl.w())) {
                com.bytedance.msdk.j.up.cw.xt("TMe", "adn 请求触发时间间隔拦截............");
                g r5 = vl.j().r(v5, tl.w());
                if (r5 != null) {
                    String j8 = com.bytedance.msdk.api.j.j(41042);
                    StringBuilder sb = new StringBuilder();
                    sb.append(vl.j().j(v5, tl.w()));
                    jVar = new com.bytedance.msdk.api.xt.cw(41042, j8, sb.toString(), r5.oq());
                } else {
                    jVar = new com.bytedance.msdk.api.j(41042, com.bytedance.msdk.api.j.j(41042));
                }
                com.bytedance.msdk.api.j jVar4 = jVar;
                com.bytedance.msdk.up.m.j(tl, xt.mi(), com.bytedance.msdk.core.up.j.j.j().j(tl.w()), j6.up(), 2, j6.cw(), j6.ae(), j6.m(), jVar4, -1L, xt.wq().up, false);
                com.bytedance.msdk.up.m.j(jVar4, xt.mi(), tl, j6.cw(), j6.ae(), j6.m(), com.bytedance.msdk.core.up.j.j.j().j(tl.w()), 0L, (String) null, (String) null, (String) null, 0L);
                j6.j(jVar4, tl);
                return;
            }
            if (ws.j().j(v5, tl.i())) {
                com.bytedance.msdk.api.j j9 = ws.j().j(v5, tl.az(), tl.w());
                if (j9 != null) {
                    com.bytedance.msdk.j.up.cw.xt("TMe", "adn 请求触发了rit级别的错误码拦截............");
                    com.bytedance.msdk.up.m.j(tl, xt.mi(), com.bytedance.msdk.core.up.j.j.j().j(tl.w()), j6.up(), 2, j6.cw(), j6.ae(), j6.m(), j9, -1L, xt.wq().up, false);
                    com.bytedance.msdk.up.m.j(j9, xt.mi(), tl, j6.cw(), j6.ae(), j6.m(), com.bytedance.msdk.core.up.j.j.j().j(tl.w()), 0L, (String) null, (String) null, (String) null, 0L);
                    j6.j(j9, tl);
                    return;
                }
            } else {
                com.bytedance.msdk.api.j j10 = com.bytedance.msdk.core.tl.cw.j().j(tl.az(), tl.w());
                if (j10 != null) {
                    com.bytedance.msdk.j.up.cw.xt("TMe", "adn 请求触发了错误码拦截............");
                    com.bytedance.msdk.up.m.j(tl, xt.mi(), com.bytedance.msdk.core.up.j.j.j().j(tl.w()), j6.up(), 2, j6.cw(), j6.ae(), j6.m(), j10, -1L, xt.wq().up, false);
                    com.bytedance.msdk.up.m.j(j10, xt.mi(), tl, j6.cw(), j6.ae(), j6.m(), com.bytedance.msdk.core.up.j.j.j().j(tl.w()), 0L, (String) null, (String) null, (String) null, 0L);
                    j6.j(j10, tl);
                    return;
                }
            }
        }
        interfaceC0366j.j(this);
    }
}
