package com.bytedance.sdk.component.m.r;

import com.bytedance.sdk.component.m.mi;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl extends j {
    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        byte[] j6 = cwVar.kt().xt(cwVar.tj()).j((mi) cwVar.m());
        if (j6 == null) {
            cwVar.j(new m());
        } else {
            cwVar.j(new xt(j6, null));
        }
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "raw_cache";
    }
}
