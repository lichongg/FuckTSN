package com.bytedance.sdk.gromore.j.j.m;

import com.bytedance.sdk.gromore.j.j.r.tl;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.ae;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends ae {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.gromore.j.j.up.cw f27458j;

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.ae
    public void destroy() {
        com.bytedance.sdk.gromore.j.j.up.cw cwVar = this.f27458j;
        if (cwVar != null) {
            cwVar.ae();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt> getAdLoadInfo() {
        if (this.f27458j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27458j.xt().size(); i6++) {
            linkedList.add(new tl(this.f27458j.xt().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j getBestEcpm() {
        com.bytedance.sdk.gromore.j.j.up.cw cwVar = this.f27458j;
        return cwVar != null ? new com.bytedance.sdk.gromore.j.j.r.ae(cwVar.r()) : new com.bytedance.sdk.gromore.j.j.r.ae(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j> getCacheList() {
        if (this.f27458j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27458j.up().size(); i6++) {
            linkedList.add(new com.bytedance.sdk.gromore.j.j.r.ae(this.f27458j.up().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j> getMultiBiddingEcpm() {
        if (this.f27458j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27458j.cw().size(); i6++) {
            linkedList.add(new com.bytedance.sdk.gromore.j.j.r.ae(this.f27458j.cw().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j getShowEcpm() {
        com.bytedance.sdk.gromore.j.j.up.cw cwVar = this.f27458j;
        return cwVar != null ? new com.bytedance.sdk.gromore.j.j.r.ae(cwVar.m()) : new com.bytedance.sdk.gromore.j.j.r.ae(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public boolean isReady() {
        com.bytedance.sdk.gromore.j.j.up.cw cwVar = this.f27458j;
        if (cwVar != null) {
            return cwVar.j();
        }
        return false;
    }

    public j(com.bytedance.sdk.gromore.j.j.up.cw cwVar) {
        this.f27458j = cwVar;
    }
}
