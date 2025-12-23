package com.bytedance.sdk.openadsdk.core.up.up.j;

import com.bytedance.sdk.openadsdk.core.tj.tl;
import com.bytedance.sdk.openadsdk.core.up.up.up;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends xt implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f30898j = new AtomicBoolean(false);
    private final AtomicBoolean xt = new AtomicBoolean(false);
    private final AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f30899r = new AtomicBoolean(false);
    private final AtomicBoolean vl = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.up.up.j.xt
    public void j(up upVar, int i6, String str) {
        this.tl = upVar;
        this.f30900g = i6;
        this.oq = str;
        this.cw.set(true);
        this.vl.set(true);
        xt();
    }

    private long r() {
        tl.j jVar = this.up;
        if (jVar == null || jVar.m() <= 0) {
            return 10000L;
        }
        return this.up.m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.up.j.xt
    public void cw() {
        this.vl.set(true);
        xt();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f30898j.set(true);
        xt();
    }

    public void xt() {
        if (!this.vl.get()) {
            if (this.f30898j.get() && this.f30899r.get()) {
                com.bytedance.sdk.openadsdk.core.up.up.cw cwVar = this.ae;
                j(cwVar, cwVar != null ? 2 : 3);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.utils.tl.xt().removeCallbacks(this);
        com.bytedance.sdk.openadsdk.core.up.up.cw cwVar2 = this.f30901m;
        if (cwVar2 != null) {
            j(cwVar2, 1);
            return;
        }
        if (this.f30899r.get()) {
            com.bytedance.sdk.openadsdk.core.up.up.cw cwVar3 = this.ae;
            if (cwVar3 != null) {
                j(cwVar3, 2);
            } else {
                j(null, 3);
            }
        }
    }

    public r(tl.j jVar) {
        this.up = jVar;
    }

    public void j() {
        com.bytedance.sdk.component.utils.tl.xt().postDelayed(this, r());
    }

    private void j(com.bytedance.sdk.openadsdk.core.up.up.cw cwVar, int i6) {
        com.bytedance.sdk.openadsdk.core.up.up.cw cwVar2;
        com.bytedance.sdk.openadsdk.core.up.up.cw cwVar3;
        if (this.xt.compareAndSet(false, true)) {
            this.qv = i6;
            if (i6 == 3) {
                up upVar = this.tl;
                if (upVar != null) {
                    upVar.j(this.f30900g, this.oq);
                }
            } else if (cwVar != null) {
                cwVar.j();
            }
            if (i6 == 1 && (cwVar3 = this.ae) != null) {
                cwVar3.cw();
            }
            if (i6 != 2 || (cwVar2 = this.f30901m) == null) {
                return;
            }
            cwVar2.cw();
            return;
        }
        if (i6 == this.qv || cwVar == null) {
            return;
        }
        cwVar.cw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.up.j.xt
    public void j(boolean z5) {
        this.f30899r.set(true);
        xt();
    }
}
