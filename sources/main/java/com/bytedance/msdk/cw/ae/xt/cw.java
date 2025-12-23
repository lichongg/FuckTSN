package com.bytedance.msdk.cw.ae.xt;

import android.os.Handler;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements j {

    /* renamed from: j, reason: collision with root package name */
    private Handler f24831j;
    private xt xt;

    @Override // com.bytedance.msdk.cw.ae.xt.j
    public void j(Handler handler, com.bytedance.msdk.core.oq.xt xtVar, xt xtVar2) {
        this.f24831j = handler;
        this.xt = xtVar2;
        if (handler == null || xtVar2 == null || xtVar == null) {
            return;
        }
        xtVar.up().put("serverBidding_timeout", Boolean.FALSE);
        handler.postDelayed(xtVar2, xtVar.ae());
    }

    @Override // com.bytedance.msdk.cw.ae.xt.j
    public void j() {
        xt xtVar;
        if (this.f24831j == null || (xtVar = this.xt) == null || xtVar.j()) {
            return;
        }
        this.f24831j.removeCallbacks(this.xt);
        this.xt.run();
    }
}
