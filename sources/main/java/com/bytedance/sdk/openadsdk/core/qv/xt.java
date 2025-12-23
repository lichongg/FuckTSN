package com.bytedance.sdk.openadsdk.core.qv;

import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements j.xt {

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static xt f30001j = new xt();
    }

    private xt() {
        com.bytedance.sdk.openadsdk.core.rn.j r5 = oq.i().r();
        if (r5 != null) {
            r5.j(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
    public void j() {
        com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g("dl_work") { // from class: com.bytedance.sdk.openadsdk.core.qv.xt.1
            @Override // java.lang.Runnable
            public void run() {
                oq.i().j(g.j());
            }
        });
    }

    public static xt cw() {
        return j.f30001j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
    public void xt() {
    }
}
