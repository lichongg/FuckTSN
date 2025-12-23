package com.bytedance.sdk.openadsdk.core.g.j.j.j;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.oq;
import com.bytedance.sdk.openadsdk.core.xt.j.xt.cw;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bytedance.sdk.openadsdk.core.g.j.j.j {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f28998j;

    /* renamed from: m, reason: collision with root package name */
    private Map<String, Object> f28999m;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.g.j.j.j f29000r;
    private com.bytedance.sdk.component.qv.j.j up;
    private n xt;

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
    public boolean j(final Map<String, Object> map) {
        if (!com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.j(this.xt, false)) {
            com.bytedance.sdk.openadsdk.core.g.j.j.j jVar = this.f29000r;
            return jVar != null && jVar.j(map);
        }
        if (oq.up(this.xt)) {
            com.bytedance.sdk.openadsdk.core.g.j.j.j jVar2 = this.f29000r;
            return jVar2 != null && jVar2.j(map);
        }
        if (oq.r(this.xt)) {
            com.bytedance.sdk.openadsdk.core.g.j.j.j jVar3 = this.f29000r;
            return jVar3 != null && jVar3.j(map);
        }
        new com.bytedance.sdk.openadsdk.core.xt.j.xt.cw(this.xt, this.f28998j).j(this.cw).j(new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.xt.1
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.j
            public void j() {
                if (xt.this.f29000r.j(map)) {
                    return;
                }
                xt.this.up.xt(xt.this.f28999m);
            }
        });
        return true;
    }

    public xt(com.bytedance.sdk.openadsdk.core.g.j.j.j jVar, Context context, n nVar, String str, Map<String, Object> map, com.bytedance.sdk.component.qv.j.j jVar2) {
        this.f29000r = jVar;
        this.f28998j = context;
        this.xt = nVar;
        this.cw = str;
        this.up = jVar2;
        this.f28999m = map;
    }
}
