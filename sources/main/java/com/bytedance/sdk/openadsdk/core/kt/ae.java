package com.bytedance.sdk.openadsdk.core.kt;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
class ae implements com.bytedance.sdk.component.tl.j.j.up {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.component.g.xt f29336j;

    @Override // com.bytedance.sdk.component.tl.j.j.up
    public int cw() {
        com.bytedance.sdk.component.g.xt xtVar = this.f29336j;
        if (xtVar != null) {
            return xtVar.j();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.component.tl.j.j.up
    public boolean j() {
        com.bytedance.sdk.component.g.xt xtVar = this.f29336j;
        if (xtVar != null) {
            return xtVar.tl();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.tl.j.j.up
    public String r() {
        com.bytedance.sdk.component.g.xt xtVar = this.f29336j;
        return xtVar != null ? xtVar.xt() : "";
    }

    @Override // com.bytedance.sdk.component.tl.j.j.up
    public Map<String, String> up() {
        com.bytedance.sdk.component.g.xt xtVar = this.f29336j;
        return xtVar != null ? xtVar.cw() : new HashMap();
    }

    @Override // com.bytedance.sdk.component.tl.j.j.up
    public String xt() {
        com.bytedance.sdk.component.g.xt xtVar = this.f29336j;
        return xtVar != null ? xtVar.r() : "";
    }

    public ae(com.bytedance.sdk.component.g.xt xtVar) {
        this.f29336j = xtVar;
    }
}
