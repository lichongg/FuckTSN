package com.bytedance.msdk.cw.cw.j;

import com.bytedance.msdk.cw.cw.j.j;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements j {
    @Override // com.bytedance.msdk.cw.cw.j.j
    public void xt(j.InterfaceC0365j interfaceC0365j) {
        interfaceC0365j.j((String) null);
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void j(j.InterfaceC0365j interfaceC0365j) {
        String str;
        com.bytedance.msdk.cw.m.j.xt j6 = interfaceC0365j.j();
        com.bytedance.msdk.api.j.xt mi = j6.mi();
        com.bytedance.msdk.core.oq.xt vl = j6.vl();
        com.bytedance.msdk.core.oq.xt j7 = com.bytedance.msdk.core.cw.cw.j(mi, vl);
        if (j7 != null) {
            if (mi.cw() == 2 || mi.cw() == 4 || mi.cw() == 5) {
                com.bytedance.msdk.core.up.xt.r.j().j(mi.v(), mi);
            }
            vl = j7;
        }
        if (vl.ol() != null && vl.ol().size() != 0) {
            j6.j(vl);
            interfaceC0365j.j(interfaceC0365j.j());
            return;
        }
        if (j6.vl() != null) {
            str = j6.vl().hh();
        } else {
            str = null;
        }
        com.bytedance.msdk.up.m.j(mi, str, !j6.v(), j6.wq().f24631j, 810085, (Map<String, Object>) null);
        j6.j(new com.bytedance.msdk.api.j(810085, com.bytedance.msdk.api.j.j(810085)));
    }
}
