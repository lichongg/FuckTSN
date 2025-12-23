package com.bytedance.sdk.openadsdk.core.g.j.j.j;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.xp;
import com.bytedance.sdk.openadsdk.core.xt.j.xt.up;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl implements com.bytedance.sdk.openadsdk.core.g.j.j.j {
    private Map<String, Object> ae;
    private Context cw;

    /* renamed from: g, reason: collision with root package name */
    private int f28990g;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.g.j.j.j f28991j;

    /* renamed from: m, reason: collision with root package name */
    private xp f28992m;

    /* renamed from: r, reason: collision with root package name */
    private boolean f28993r;
    private com.bytedance.sdk.component.qv.j.j tl;
    private String up;
    private n xt;

    public void j(n nVar) {
        this.xt = nVar;
    }

    public tl(xp xpVar, Context context, boolean z5, String str, Map<String, Object> map, com.bytedance.sdk.component.qv.j.j jVar, int i6) {
        this.f28992m = xpVar;
        this.cw = context;
        this.f28993r = z5;
        this.up = str;
        this.ae = map;
        this.tl = jVar;
        this.f28990g = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
    public boolean j(final Map<String, Object> map) {
        boolean j6 = !com.bytedance.sdk.openadsdk.core.xt.j.xt.up.j() ? new com.bytedance.sdk.openadsdk.core.xt.j.xt.up(this.xt, this.cw).j(this.up).j(this.f28990g).xt(this.f28993r).j(new up.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.j.j.tl.1
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.xt.up.j
            public void xt() {
                if (tl.this.f28991j != null ? tl.this.f28991j.j(map) : false) {
                    return;
                }
                tl.this.tl.xt(tl.this.ae);
            }

            @Override // com.bytedance.sdk.openadsdk.core.xt.j.xt.up.j
            public void j() {
            }
        }) : false;
        com.bytedance.sdk.openadsdk.core.xt.j.xt.up.j(false);
        if (j6) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.g.j.j.j jVar = this.f28991j;
        return jVar != null && jVar.j(map);
    }
}
