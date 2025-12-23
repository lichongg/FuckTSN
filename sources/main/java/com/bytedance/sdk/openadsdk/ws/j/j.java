package com.bytedance.sdk.openadsdk.ws.j;

import com.bytedance.sdk.component.m.ae;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.openadsdk.core.tj.ry;
import com.bytedance.sdk.openadsdk.core.v.j.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.sdk.openadsdk.core.v.j.j {

    /* renamed from: j, reason: collision with root package name */
    private ry f31987j;

    private void j(qv qvVar) {
        ae oq = qvVar.oq();
        if (oq == null || !r()) {
            return;
        }
        j(oq.j(), oq.xt());
    }

    private boolean r() {
        ry ryVar = this.f31987j;
        return ryVar != null && ryVar.f();
    }

    public ry cw() {
        return this.f31987j;
    }

    private void up() {
        if (r()) {
            long currentTimeMillis = System.currentTimeMillis();
            ry ryVar = this.f31987j;
            ryVar.tl(currentTimeMillis - ryVar.mi());
            this.f31987j.jy(currentTimeMillis);
        }
    }

    private void j(long j6, long j7) {
        this.f31987j.ws(j7);
        ry ryVar = this.f31987j;
        ryVar.g(j7 - ryVar.tj());
        this.f31987j.mi(j7 - j6);
    }

    public void j(ry ryVar) {
        this.f31987j = ryVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.v.j.j
    protected void j(qv qvVar, j.xt xtVar) {
        j(qvVar);
        super.j(qvVar, xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.v.j.j
    protected void j() {
        up();
    }
}
