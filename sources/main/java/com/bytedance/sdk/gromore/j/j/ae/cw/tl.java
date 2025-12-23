package com.bytedance.sdk.gromore.j.j.ae.cw;

import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.r {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.gromore.j.j.up.cw f27361j;

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.r
    public void destroy() {
        com.bytedance.sdk.gromore.j.j.up.cw cwVar = this.f27361j;
        if (cwVar != null) {
            cwVar.ae();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt> getAdLoadInfo() {
        if (this.f27361j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27361j.xt().size(); i6++) {
            linkedList.add(new com.bytedance.sdk.gromore.j.j.r.tl(this.f27361j.xt().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j getBestEcpm() {
        com.bytedance.sdk.gromore.j.j.up.cw cwVar = this.f27361j;
        return cwVar != null ? new com.bytedance.sdk.gromore.j.j.r.ae(cwVar.r()) : new com.bytedance.sdk.gromore.j.j.r.ae(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j> getCacheList() {
        if (this.f27361j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27361j.up().size(); i6++) {
            linkedList.add(new com.bytedance.sdk.gromore.j.j.r.ae(this.f27361j.up().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j> getMultiBiddingEcpm() {
        if (this.f27361j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27361j.cw().size(); i6++) {
            linkedList.add(new com.bytedance.sdk.gromore.j.j.r.ae(this.f27361j.cw().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j getShowEcpm() {
        com.bytedance.sdk.gromore.j.j.up.cw cwVar = this.f27361j;
        return cwVar != null ? new com.bytedance.sdk.gromore.j.j.r.ae(cwVar.m()) : new com.bytedance.sdk.gromore.j.j.r.ae(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public boolean isReady() {
        com.bytedance.sdk.gromore.j.j.up.cw cwVar = this.f27361j;
        if (cwVar != null) {
            return cwVar.j();
        }
        return false;
    }

    public tl(com.bytedance.sdk.gromore.j.j.up.cw cwVar) {
        this.f27361j = cwVar;
    }
}
