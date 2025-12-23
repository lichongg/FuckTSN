package com.bytedance.sdk.openadsdk.core.j;

import com.bytedance.sdk.openadsdk.core.s;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements s.xt {

    /* renamed from: j, reason: collision with root package name */
    private s.xt f29182j;
    private int xt;

    public void j(int i6) {
        this.xt = i6;
    }

    public j(s.xt xtVar) {
        this.f29182j = xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.s.xt
    public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar) {
        s.xt xtVar2 = this.f29182j;
        if (xtVar2 != null) {
            xtVar2.j(i6, str, xtVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.s.xt
    public void j(final com.bytedance.sdk.openadsdk.core.tj.j jVar, final com.bytedance.sdk.openadsdk.core.tj.xt xtVar) {
        int i6 = this.xt;
        boolean z5 = i6 == 3 || i6 == 4;
        if (z5 && (com.bytedance.sdk.openadsdk.core.cw.up.j().vl() & 1) == 1) {
            s.xt xtVar2 = this.f29182j;
            if (xtVar2 != null) {
                xtVar2.j(jVar, xtVar);
                return;
            }
            return;
        }
        if (this.f29182j != null) {
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.f29182j.j(jVar, xtVar);
                }
            };
            if (z5) {
                com.bytedance.sdk.openadsdk.l.ae.j(runnable);
            } else {
                com.bytedance.sdk.openadsdk.l.ae.xt(runnable);
            }
        }
    }
}
