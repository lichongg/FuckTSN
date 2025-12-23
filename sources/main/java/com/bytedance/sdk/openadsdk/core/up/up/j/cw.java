package com.bytedance.sdk.openadsdk.core.up.up.j;

import com.bytedance.sdk.openadsdk.core.tj.tl;
import com.bytedance.sdk.openadsdk.core.up.up.up;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends xt {

    /* renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f30894j = new AtomicBoolean(false);
    private final AtomicBoolean xt = new AtomicBoolean(false);
    private final AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f30895r = new AtomicBoolean(false);
    private final AtomicBoolean vl = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.up.up.j.xt
    public void j(up upVar, int i6, String str) {
        this.tl = upVar;
        this.f30900g = i6;
        this.oq = str;
        this.xt.set(true);
        this.vl.set(true);
        j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.up.j.xt
    public void cw() {
        this.vl.set(true);
        j();
    }

    public cw(tl.j jVar) {
        this.up = jVar;
    }

    public void j() {
        com.bytedance.sdk.openadsdk.core.up.up.cw cwVar;
        if (this.f30895r.get() && this.qv != 2 && (cwVar = this.ae) != null) {
            j(cwVar, 2);
            return;
        }
        if (this.vl.get()) {
            com.bytedance.sdk.openadsdk.core.up.up.cw cwVar2 = this.f30901m;
            if (cwVar2 != null) {
                j(cwVar2, 1);
            } else if (this.cw.get()) {
                j(null, 3);
            }
        }
    }

    private void j(com.bytedance.sdk.openadsdk.core.up.up.cw cwVar, int i6) {
        if (!this.f30894j.compareAndSet(false, true)) {
            if (cwVar != null) {
                cwVar.cw();
                return;
            }
            return;
        }
        this.qv = i6;
        if (i6 != 3) {
            if (cwVar != null) {
                cwVar.j();
            }
        } else {
            up upVar = this.tl;
            if (upVar != null) {
                upVar.j(this.f30900g, this.oq);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.up.j.xt
    public void j(boolean z5) {
        if (z5) {
            this.f30895r.set(true);
            j();
        } else {
            this.cw.set(true);
            j();
        }
    }
}
