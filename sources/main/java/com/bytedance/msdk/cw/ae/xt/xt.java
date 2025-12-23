package com.bytedance.msdk.cw.ae.xt;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements Runnable {
    private boolean cw = false;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.msdk.core.oq.xt f24832j;
    private Runnable xt;

    public boolean j() {
        return this.cw;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.msdk.core.oq.xt xtVar = this.f24832j;
        if (xtVar != null && xtVar.m() == 4) {
            this.f24832j.up().put("serverBidding_timeout", Boolean.TRUE);
        }
        this.cw = true;
        Runnable runnable = this.xt;
        if (runnable != null) {
            runnable.run();
        }
    }

    public xt(com.bytedance.msdk.core.oq.xt xtVar, Runnable runnable) {
        this.f24832j = xtVar;
        this.xt = runnable;
    }
}
