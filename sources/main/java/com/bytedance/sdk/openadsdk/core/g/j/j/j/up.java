package com.bytedance.sdk.openadsdk.core.g.j.j.j;

import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements com.bytedance.sdk.openadsdk.core.g.j.j.j {
    private com.bytedance.sdk.component.qv.j.j cw;

    /* renamed from: j, reason: collision with root package name */
    private n f28995j;

    /* renamed from: r, reason: collision with root package name */
    private Map<String, Object> f28996r;
    private String up;
    private com.bytedance.sdk.openadsdk.core.g.j.j.j xt;

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
    public boolean j(final Map<String, Object> map) {
        int j6 = com.bytedance.sdk.openadsdk.core.live.xt.j().j(this.f28995j, new com.bytedance.sdk.openadsdk.core.live.j.cw() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.up.1
            @Override // com.bytedance.sdk.openadsdk.core.live.j.cw
            public void j(int i6) {
                if (up.this.xt == null || !up.this.xt.j(map)) {
                    up.this.cw.xt(up.this.f28996r);
                }
            }
        }, this.up);
        if (j6 == 1 || j6 == 2) {
            j();
            return true;
        }
        com.bytedance.sdk.openadsdk.core.g.j.j.j jVar = this.xt;
        return jVar != null && jVar.j(map);
    }

    public up(com.bytedance.sdk.openadsdk.core.g.j.j.j jVar, n nVar, com.bytedance.sdk.component.qv.j.j jVar2, Map<String, Object> map, String str) {
        this.f28995j = nVar;
        this.xt = jVar;
        this.cw = jVar2;
        this.f28996r = map;
        this.up = str;
    }

    private void j() {
        Map<String, Object> hashMap;
        Map<String, Object> map = this.f28996r;
        if (map != null) {
            Object obj = map.get("click_chain");
            Object obj2 = this.f28996r.get("handle_chain_data");
            if (obj == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.xt.j.cw)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.xt.j.cw cwVar = (com.bytedance.sdk.openadsdk.core.xt.j.cw) obj;
            com.bytedance.sdk.openadsdk.core.xt.j.cw.j jVar = (com.bytedance.sdk.openadsdk.core.xt.j.cw.j) cwVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class);
            if (jVar != null) {
                if (obj2 != null && (obj2 instanceof Map)) {
                    hashMap = (Map) obj2;
                } else {
                    hashMap = new HashMap<>();
                }
                jVar.j(hashMap, cwVar);
            }
        }
    }
}
