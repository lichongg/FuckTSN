package com.bytedance.sdk.component.m.r;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends j {
    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        String m6 = cwVar.m();
        com.bytedance.sdk.component.m.xt tj = cwVar.tj();
        byte[] j6 = (cwVar.f() || tj.m()) ? j(cwVar, m6) : xt(cwVar, m6);
        if (j6 == null) {
            cwVar.j(new qv());
            return;
        }
        cwVar.j(new xt(j6, null));
        if (tj.ae()) {
            cwVar.kt().xt(tj).j(m6, j6);
        }
    }

    private byte[] xt(com.bytedance.sdk.component.m.cw.cw cwVar, String str) {
        com.bytedance.sdk.component.m.cw cw = cwVar.kt().cw(cwVar.tj());
        if (cw == null) {
            return null;
        }
        return cw.j((com.bytedance.sdk.component.m.cw) str);
    }

    private byte[] j(com.bytedance.sdk.component.m.cw.cw cwVar, String str) {
        cwVar.kt().cw(cwVar.tj());
        Collection<com.bytedance.sdk.component.m.cw> cw = cwVar.kt().cw();
        if (cw == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.m.cw> it = cw.iterator();
        while (it.hasNext()) {
            byte[] j6 = it.next().j((com.bytedance.sdk.component.m.cw) str);
            if (j6 != null) {
                return j6;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "disk_cache";
    }
}
