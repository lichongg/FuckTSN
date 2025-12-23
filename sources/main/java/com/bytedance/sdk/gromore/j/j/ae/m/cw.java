package com.bytedance.sdk.gromore.j.j.ae.m;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.r.qv;
import com.bytedance.msdk.cw.r.jy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements com.bytedance.sdk.gromore.j.j.m.cw {
    private com.bytedance.sdk.openadsdk.tj.j.xt.j.j cw;

    /* renamed from: j, reason: collision with root package name */
    private jy f27375j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f27376r;
    private com.bytedance.sdk.openadsdk.mediation.xt.xt.j xt;

    @Override // com.bytedance.sdk.gromore.j.j.up
    public void j() {
        j(-1);
    }

    public cw(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.j jVar2, boolean z5) {
        this.xt = jVar;
        this.f27376r = z5;
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "CSJMSplashLoader 构造函数创建 mAdSlotValueSet = " + this.xt + " mAdSlotValueSet.getCodeId() = " + this.xt.r());
        if (this.xt != null) {
            this.f27375j = new jy(context);
            this.cw = jVar2;
        }
    }

    @Override // com.bytedance.sdk.gromore.j.j.m.cw
    public void j(int i6) {
        final com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.cw jy;
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "CSJMSplashLoader load timeout = ".concat(String.valueOf(i6)));
        com.bytedance.msdk.core.qv.j.j().xt();
        com.bytedance.msdk.api.j.xt xtVar = new com.bytedance.msdk.api.j.xt(3, this.xt.h());
        xtVar.j(this.f27376r);
        if (i6 != -1) {
            xtVar.tl(i6);
        }
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt l6 = this.xt.l();
        this.f27375j.j(xtVar, (l6 == null || (jy = l6.jy()) == null || TextUtils.isEmpty(jy.j()) || TextUtils.isEmpty(jy.cw()) || TextUtils.isEmpty(jy.xt())) ? null : new qv() { // from class: com.bytedance.sdk.gromore.j.j.ae.m.cw.1
            @Override // com.bytedance.msdk.api.r.qv
            public String cw() {
                return jy.cw();
            }

            @Override // com.bytedance.msdk.api.r.qv
            public int j() {
                String j6 = jy.j();
                j6.getClass();
                switch (j6) {
                    case "klevin":
                        return 9;
                    case "pangle":
                        return 1;
                    case "sigmob":
                        return 8;
                    case "xiaomi":
                        return 10;
                    case "ks":
                        return 7;
                    case "gdt":
                        return 3;
                    case "baidu":
                        return 6;
                    case "mintegral":
                        return 4;
                    default:
                        return super.j();
                }
            }

            @Override // com.bytedance.msdk.api.r.qv
            public String r() {
                return jy.r();
            }

            @Override // com.bytedance.msdk.api.r.qv
            public String xt() {
                return jy.xt();
            }
        }, new com.bytedance.msdk.api.r.j.g.cw() { // from class: com.bytedance.sdk.gromore.j.j.ae.m.cw.2
            @Override // com.bytedance.msdk.api.r.j.g.cw
            public void j(com.bytedance.msdk.api.j jVar) {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "CSJMSplashLoader onSplashAdLoadFail");
                if (jVar == null || cw.this.cw == null) {
                    return;
                }
                com.bytedance.sdk.gromore.j.j.j jVar2 = new com.bytedance.sdk.gromore.j.j.j(jVar.f24334j, jVar.xt);
                cw.this.cw.j(jVar2);
                cw.this.cw.j(null, jVar2);
            }

            @Override // com.bytedance.msdk.api.r.j.g.cw
            public void j() {
                com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "CSJMSplashLoader onSplashAdLoadSuccess");
                if (cw.this.cw != null) {
                    j jVar = new j(cw.this.f27375j, cw.this.cw);
                    cw.this.cw.j(jVar);
                    cw.this.cw.xt(jVar);
                }
            }
        });
    }
}
