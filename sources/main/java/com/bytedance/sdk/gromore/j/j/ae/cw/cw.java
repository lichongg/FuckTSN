package com.bytedance.sdk.gromore.j.j.ae.cw;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements com.bytedance.sdk.gromore.j.j.up {
    private com.bytedance.sdk.openadsdk.tj.j.xt.j.r cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.cw.r.tl f27354j;

    /* renamed from: r, reason: collision with root package name */
    private j f27355r;
    private com.bytedance.sdk.openadsdk.mediation.xt.xt.j xt;

    public cw(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.r rVar) {
        this.xt = jVar;
        if (jVar != null) {
            this.f27354j = new com.bytedance.msdk.cw.r.tl(context);
            this.cw = rVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.up
    public void j() {
        this.f27354j.j(new com.bytedance.msdk.api.j.xt(8, this.xt.h()), new com.bytedance.msdk.api.r.j.r.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.cw.cw.1
            @Override // com.bytedance.msdk.api.r.j.r.xt
            public void j(com.bytedance.msdk.api.j jVar) {
                if (jVar == null || cw.this.cw == null) {
                    return;
                }
                cw.this.cw.j(jVar.f24334j, jVar.xt);
            }

            @Override // com.bytedance.msdk.api.r.j.r.xt
            public void xt() {
                if (cw.this.cw != null) {
                    cw.this.cw.j();
                    if (cw.this.f27355r == null) {
                        cw cwVar = cw.this;
                        cwVar.f27355r = new j(cwVar.f27354j);
                    }
                    cw.this.cw.xt(cw.this.f27355r);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.r.xt
            public void j() {
                if (cw.this.cw != null) {
                    if (cw.this.f27355r == null) {
                        cw cwVar = cw.this;
                        cwVar.f27355r = new j(cwVar.f27354j);
                    }
                    cw.this.cw.j(cw.this.f27355r);
                }
            }
        });
    }
}
