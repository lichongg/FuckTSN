package com.bytedance.sdk.gromore.j.j.ae.up;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.cw.r.vl;
import com.bytedance.sdk.gromore.j.j.up;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.tj.j.xt.j.ae;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements up {
    private ae cw;

    /* renamed from: j, reason: collision with root package name */
    private vl f27428j;

    /* renamed from: r, reason: collision with root package name */
    private j f27429r;
    private com.bytedance.sdk.openadsdk.mediation.xt.xt.j xt;

    public cw(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, ae aeVar) {
        this.xt = jVar;
        if (jVar != null) {
            this.f27428j = new vl(context);
            this.cw = aeVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.up
    public void j() {
        HashMap hashMap = new HashMap();
        String jy = this.xt.jy();
        if (!TextUtils.isEmpty(jy)) {
            hashMap.put(MediationConstant.ADN_GDT, jy);
        }
        this.f27428j.j(new com.bytedance.msdk.api.j.xt(7, this.xt.h()), new com.bytedance.msdk.api.r.j.tl.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.up.cw.1
            @Override // com.bytedance.msdk.api.r.j.tl.xt
            public void j(com.bytedance.msdk.api.j jVar) {
                if (jVar == null || cw.this.cw == null) {
                    return;
                }
                cw.this.cw.j(jVar.f24334j, jVar.xt);
            }

            @Override // com.bytedance.msdk.api.r.j.tl.xt
            public void xt() {
                if (cw.this.cw != null) {
                    cw.this.cw.j();
                    if (cw.this.f27429r == null) {
                        cw cwVar = cw.this;
                        cwVar.f27429r = new j(cwVar.f27428j);
                    }
                    cw.this.cw.xt(cw.this.f27429r);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.xt
            public void j() {
                if (cw.this.cw != null) {
                    if (cw.this.f27429r == null) {
                        cw cwVar = cw.this;
                        cwVar.f27429r = new j(cwVar.f27428j);
                    }
                    cw.this.cw.j(cw.this.f27429r);
                }
            }
        });
    }
}
