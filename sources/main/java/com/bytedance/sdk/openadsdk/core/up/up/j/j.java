package com.bytedance.sdk.openadsdk.core.up.up.j;

import com.bytedance.sdk.openadsdk.core.tj.tl;
import com.bytedance.sdk.openadsdk.core.up.up.up;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j extends xt {

    /* renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f30896j = new AtomicBoolean(false);
    private final AtomicBoolean xt = new AtomicBoolean(false);
    private final AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f30897r = new AtomicBoolean(false);

    public abstract void j();

    @Override // com.bytedance.sdk.openadsdk.core.up.up.j.xt
    public void j(up upVar, int i6, String str) {
        this.tl = upVar;
        this.f30900g = i6;
        this.oq = str;
        this.f30897r.set(true);
        xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.up.j.xt
    public void cw() {
        this.f30897r.set(true);
        xt();
    }

    public void xt() {
        com.bytedance.sdk.openadsdk.core.up.up.cw cwVar;
        if (this.cw.get() && (cwVar = this.ae) != null) {
            j(cwVar, 2);
            return;
        }
        if (this.f30897r.get()) {
            com.bytedance.sdk.openadsdk.core.up.up.cw cwVar2 = this.f30901m;
            if (cwVar2 != null) {
                j(cwVar2, 1);
            } else {
                j(null, 3);
            }
        }
    }

    public j(tl.j jVar) {
        this.up = jVar;
    }

    private void j(com.bytedance.sdk.openadsdk.core.up.up.cw cwVar, int i6) {
        if (this.f30896j.compareAndSet(false, true)) {
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
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.up.j.xt
    public void j(boolean z5) {
        if (z5) {
            this.cw.set(true);
            xt();
        } else {
            this.xt.set(true);
            j();
        }
    }
}
