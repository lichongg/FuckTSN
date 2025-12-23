package com.bytedance.sdk.openadsdk.core.component.splash.xt.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.up;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private ae f28795j = new ae();
    private int cw = 3;
    private final s xt = v.j();

    public void j(final up upVar, final com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt<m, ae> xtVar) {
        if (this.xt == null || upVar == null) {
            return;
        }
        this.f28795j.xt(false);
        this.xt.j(upVar.r(), upVar.up(), this.cw, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xt.j.cw.1
            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                cw.this.f28795j.xt(i6);
                cw.this.f28795j.cw(xtVar2 != null ? xtVar2.cw() : 0);
                if (TextUtils.isEmpty(str)) {
                    str = "load ad error";
                }
                cw.this.f28795j.j(str);
                xtVar.j(cw.this.f28795j);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                if (jVar == null || jVar.xt() == null) {
                    cw.this.f28795j.xt(1);
                    cw.this.f28795j.j("no ad or material");
                    xtVar.j(cw.this.f28795j);
                    return;
                }
                m mVar = new m(jVar, false);
                mVar.xt(xtVar2.g());
                mVar.cw(xtVar2.oq());
                mVar.r(xtVar2.qv());
                mVar.up(xtVar2.vl());
                mVar.j(upVar.j());
                mVar.j(upVar.cw());
                xtVar.xt(mVar);
            }
        });
    }
}
