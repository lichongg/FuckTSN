package com.bytedance.sdk.openadsdk.core.g.j.xt;

import java.util.Map;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class w implements com.bytedance.sdk.component.qv.j.j.cw {

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "reward_dialog_callback")
    private com.bytedance.sdk.openadsdk.core.component.reward.cw.oq f29085j;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar = this.f29085j;
        if (oqVar == null) {
            jVar.xt(map2);
            return true;
        }
        oqVar.j();
        jVar.j(map2);
        return true;
    }
}
