package com.bytedance.sdk.openadsdk.core.kt;

import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
class vl implements com.bytedance.sdk.component.tl.j.j.m {

    /* renamed from: j, reason: collision with root package name */
    com.bytedance.sdk.component.g.xt.up f29350j;

    @Override // com.bytedance.sdk.component.tl.j.j.m
    public void j(String str) {
        com.bytedance.sdk.component.g.xt.up upVar = this.f29350j;
        if (upVar != null) {
            upVar.j(str);
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.j.m
    public void xt(String str) {
        com.bytedance.sdk.component.g.xt.up upVar = this.f29350j;
        if (upVar != null) {
            upVar.cw(str);
        }
    }

    vl(com.bytedance.sdk.component.g.xt.up upVar) {
        this.f29350j = upVar;
    }

    @Override // com.bytedance.sdk.component.tl.j.j.m
    public void j(String str, byte[] bArr) {
        com.bytedance.sdk.component.g.xt.up upVar = this.f29350j;
        if (upVar != null) {
            upVar.j(str, bArr);
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.j.m
    public void j(String str, String str2) {
        com.bytedance.sdk.component.g.xt.up upVar = this.f29350j;
        if (upVar != null) {
            upVar.xt(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.tl.j.j.m
    public com.bytedance.sdk.component.tl.j.j.up j() {
        com.bytedance.sdk.component.g.xt.up upVar = this.f29350j;
        if (upVar == null) {
            return null;
        }
        return new qv(upVar.j());
    }

    @Override // com.bytedance.sdk.component.tl.j.j.m
    public void j(final com.bytedance.sdk.component.tl.j.j.cw cwVar) {
        com.bytedance.sdk.component.g.xt.up upVar = this.f29350j;
        if (upVar != null) {
            upVar.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.vl.1
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                    if (cwVar != null) {
                        cwVar.j(new m(rVar), new ae(xtVar));
                    }
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                    if (cwVar != null) {
                        cwVar.j(new m(rVar), iOException);
                    }
                }
            });
        }
    }
}
