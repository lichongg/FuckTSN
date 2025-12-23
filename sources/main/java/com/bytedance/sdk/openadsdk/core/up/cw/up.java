package com.bytedance.sdk.openadsdk.core.up.cw;

import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.l.ae;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements j {

    /* renamed from: j, reason: collision with root package name */
    private final int f30856j;

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, n nVar, Object obj, boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void xt(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, n nVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public boolean j(String str) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void xt(String str) {
        com.bytedance.sdk.openadsdk.core.up.r.r.j(this.f30856j).xt(str);
    }

    public up(int i6) {
        this.f30856j = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final n nVar) {
        if (nVar.xj() <= 0) {
            nVar.up((System.currentTimeMillis() + 10500000) / 1000);
        }
        ae.r(new g("PreloadStrategyShowDelete-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.up.cw.up.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.up.r.r.j(up.this.f30856j).j(xtVar, nVar, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public n j(String str, long j6) {
        return com.bytedance.sdk.openadsdk.core.up.r.r.j(this.f30856j).j(str, false, j6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void j(final String str, final n nVar) {
        ae.j(new g("PreloadStrategyShowDelete-onShow") { // from class: com.bytedance.sdk.openadsdk.core.up.cw.up.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.up.r.r.j(up.this.f30856j).j(str, nVar.kj());
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.cw.j
    public void cw(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, n nVar) {
    }
}
