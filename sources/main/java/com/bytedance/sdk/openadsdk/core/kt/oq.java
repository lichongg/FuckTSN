package com.bytedance.sdk.openadsdk.core.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
class oq implements com.bytedance.sdk.component.tl.j.j.xt {

    /* renamed from: j, reason: collision with root package name */
    com.bytedance.sdk.component.g.xt.cw f29347j;

    @Override // com.bytedance.sdk.component.tl.j.j.xt
    public void j(String str) {
        com.bytedance.sdk.component.g.xt.cw cwVar = this.f29347j;
        if (cwVar != null) {
            cwVar.j(str);
        }
    }

    oq(com.bytedance.sdk.component.g.xt.cw cwVar) {
        this.f29347j = cwVar;
    }

    @Override // com.bytedance.sdk.component.tl.j.j.xt
    public void j(String str, String str2) {
        com.bytedance.sdk.component.g.xt.cw cwVar = this.f29347j;
        if (cwVar != null) {
            cwVar.xt(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.j.xt
    public com.bytedance.sdk.component.tl.j.j.up j() {
        com.bytedance.sdk.component.g.xt.cw cwVar = this.f29347j;
        if (cwVar == null) {
            return null;
        }
        return new qv(cwVar.j());
    }
}
