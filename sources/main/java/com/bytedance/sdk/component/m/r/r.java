package com.bytedance.sdk.component.m.r;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends j {
    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        com.bytedance.sdk.component.m.xt tj = cwVar.tj();
        if (tj != null) {
            if (tj.cw()) {
                cwVar.j(new oq());
                return;
            } else if (tj.r()) {
                cwVar.j(new m());
                return;
            }
        }
        cwVar.j(new qv());
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "cache_policy";
    }
}
