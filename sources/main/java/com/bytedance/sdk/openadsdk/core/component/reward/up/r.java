package com.bytedance.sdk.openadsdk.core.component.reward.up;

import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.j;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements j.xt {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    long f28431j;
    private long xt;

    public long j(TimeUnit timeUnit) {
        return timeUnit != null ? timeUnit.convert(this.f28431j, TimeUnit.MILLISECONDS) : this.f28431j;
    }

    public void r() {
        if (this.xt == 0) {
            return;
        }
        this.f28431j += System.currentTimeMillis() - this.xt;
        this.xt = 0L;
        this.cw = 0L;
    }

    public void up() {
        this.xt = 0L;
        this.cw = 0L;
        this.f28431j = 0L;
    }

    public r() {
        oq.i().j(this);
    }

    public void cw() {
        long currentTimeMillis = System.currentTimeMillis();
        long j6 = this.xt;
        if (j6 != 0) {
            this.f28431j += currentTimeMillis - j6;
        }
        this.xt = currentTimeMillis;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
    public void j() {
        cw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rn.j.xt
    public void xt() {
        r();
    }
}
