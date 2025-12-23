package com.bytedance.sdk.openadsdk.core.component.splash.xt.j;

import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.up;
import com.bytedance.sdk.openadsdk.core.component.splash.j.j;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private com.bytedance.sdk.openadsdk.i.cw.cw.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.j.j f28797j;
    private boolean up;
    private String xt;

    /* renamed from: r, reason: collision with root package name */
    private ae f28799r = new ae();

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.up.xt.j f28798m = new com.bytedance.sdk.openadsdk.core.up.xt.j(4);

    public j(com.bytedance.sdk.openadsdk.core.component.splash.j.j jVar) {
        this.f28797j = jVar;
        jVar.xt();
        this.up = v.xt().ff();
    }

    public void j(up upVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt<m, ae> xtVar) {
        if (upVar == null || xtVar == null) {
            return;
        }
        this.f28799r.xt(true);
        this.cw = upVar.r();
        this.xt = upVar.m();
        if (com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.j(this.cw, upVar.up())) {
            this.f28799r.xt(1);
            this.f28799r.j("no cache");
            xtVar.j(this.f28799r);
            return;
        }
        j(this.xt, xtVar);
    }

    private void j(String str, final com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt<m, ae> xtVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f28797j.j(this.f28799r, str, new j.InterfaceC0450j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xt.j.j.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j.InterfaceC0450j
            public void j(final m mVar) {
                com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "缓存读取总耗时： " + (System.currentTimeMillis() - currentTimeMillis));
                if (xtVar == null) {
                    return;
                }
                if (mVar == null || mVar.xt() == null) {
                    if (mVar == null) {
                        j.this.f28799r.xt(1);
                        j.this.f28799r.j("no ad model cache");
                        xtVar.j(j.this.f28799r);
                        return;
                    } else if (mVar.xt() == null) {
                        j.this.f28799r.xt(1);
                        j.this.f28799r.j("no splash material");
                        xtVar.j(j.this.f28799r);
                        return;
                    }
                }
                n xt = mVar.xt();
                j.this.f28798m.j(currentTimeMillis);
                j.this.f28798m.xt(System.currentTimeMillis());
                j.this.f28798m.j(xt, new com.bytedance.sdk.openadsdk.core.up.xt.m() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xt.j.j.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.up.xt.m
                    public void j(boolean z5, long j6) {
                        if (z5) {
                            xtVar.xt(mVar);
                            return;
                        }
                        j.this.f28799r.xt(22);
                        j.this.f28799r.j("check server cache unavailable");
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        xtVar.j(j.this.f28799r);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.up.xt.m
                    public void xt() {
                        xtVar.xt(mVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.up.xt.m
                    public void j() {
                        if (j.this.up) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            j.this.j(mVar, (com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt<m, ae>) xtVar);
                        } else {
                            xtVar.xt(mVar);
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.j.j.InterfaceC0450j
            public void j() {
                com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "缓存读取失败");
                com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt xtVar2 = xtVar;
                if (xtVar2 == null) {
                    return;
                }
                xtVar2.j(j.this.f28799r);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final m mVar, final com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt<m, ae> xtVar) {
        if (xtVar == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        n xt = mVar.xt();
        v.j().j(xt.fs(), xt.os(), new s.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xt.j.j.2
            @Override // com.bytedance.sdk.openadsdk.core.s.j
            public void j(boolean z5, long j6, long j7) {
                ws.j(j.this.cw, z5, j6, j7, System.currentTimeMillis() - currentTimeMillis, 4);
                if (z5) {
                    xtVar.xt(mVar);
                    return;
                }
                j.this.f28799r.xt(22);
                j.this.f28799r.j("check server cache unavailable");
                j.this.f28799r.j(j6);
                xtVar.j(j.this.f28799r);
            }
        });
    }
}
