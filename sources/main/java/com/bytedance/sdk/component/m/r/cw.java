package com.bytedance.sdk.component.m.r;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {
    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        if (TextUtils.isEmpty(cwVar.ae())) {
            com.bytedance.sdk.component.m.vl up = cwVar.kt().up();
            cwVar.xt(up.j(cwVar));
            cwVar.j(up.xt(cwVar));
        }
        cwVar.j(new ae());
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "generate_key";
    }
}
