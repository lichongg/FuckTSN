package com.bytedance.sdk.gromore.j.j.ae.cw;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae implements com.bytedance.sdk.gromore.j.j.up {
    private com.bytedance.sdk.openadsdk.tj.j.xt.j.r cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.cw.r.j f27351j;

    /* renamed from: r, reason: collision with root package name */
    private up f27352r;
    private com.bytedance.sdk.openadsdk.mediation.xt.xt.j xt;

    public ae(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.r rVar) {
        this.xt = jVar;
        if (jVar != null) {
            this.f27351j = new com.bytedance.msdk.cw.r.j(context);
            this.cw = rVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.up
    public void j() {
        this.f27351j.j(new com.bytedance.msdk.api.j.xt(10, this.xt.h()), new com.bytedance.msdk.api.r.j.m.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.cw.ae.1
            @Override // com.bytedance.msdk.api.r.j.m.xt
            public void j(com.bytedance.msdk.api.j jVar) {
                if (jVar == null || ae.this.cw == null) {
                    return;
                }
                ae.this.cw.j(jVar.f24334j, jVar.xt);
            }

            @Override // com.bytedance.msdk.api.r.j.m.xt
            public void xt() {
                if (ae.this.cw != null) {
                    ae.this.cw.j();
                    if (ae.this.f27352r == null) {
                        ae aeVar = ae.this;
                        aeVar.f27352r = new up(aeVar.f27351j);
                    }
                    ae.this.cw.xt(ae.this.f27352r);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.m.xt
            public void j() {
                if (ae.this.cw != null) {
                    if (ae.this.f27352r == null) {
                        ae aeVar = ae.this;
                        aeVar.f27352r = new up(aeVar.f27351j);
                    }
                    ae.this.cw.j(ae.this.f27352r);
                }
            }
        });
    }
}
