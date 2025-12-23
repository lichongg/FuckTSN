package com.bytedance.sdk.openadsdk.core.g.j.j.xt;

import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bytedance.sdk.openadsdk.core.g.j.j.j {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.xt.xt f29007j;
    private com.bytedance.sdk.openadsdk.core.g.j.j.j xt;

    public xt(com.bytedance.sdk.openadsdk.core.g.j.j.j jVar, com.bytedance.sdk.openadsdk.core.video.xt.xt xtVar) {
        this.xt = jVar;
        this.f29007j = xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.j.j.j
    public boolean j(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.xt.xt xtVar = this.f29007j;
        if (xtVar == null) {
            return this.xt.j(map);
        }
        if (xtVar.j()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.g.j.j.j jVar = this.xt;
        if (jVar == null) {
            return false;
        }
        return jVar.j(map);
    }

    public xt(com.bytedance.sdk.openadsdk.core.video.xt.xt xtVar) {
        this.f29007j = xtVar;
    }
}
