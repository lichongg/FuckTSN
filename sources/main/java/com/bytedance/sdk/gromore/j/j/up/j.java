package com.bytedance.sdk.gromore.j.j.up;

import com.bytedance.sdk.gromore.j.j.r.ae;
import com.bytedance.sdk.gromore.j.j.r.tl;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.m;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends m {

    /* renamed from: j, reason: collision with root package name */
    private cw f27472j;

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.m
    public void destroy() {
        cw cwVar = this.f27472j;
        if (cwVar != null) {
            cwVar.ae();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt> getAdLoadInfo() {
        if (this.f27472j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27472j.xt().size(); i6++) {
            linkedList.add(new tl(this.f27472j.xt().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j getBestEcpm() {
        cw cwVar = this.f27472j;
        return cwVar != null ? new ae(cwVar.r()) : new ae(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j> getCacheList() {
        if (this.f27472j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27472j.up().size(); i6++) {
            linkedList.add(new ae(this.f27472j.up().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j> getMultiBiddingEcpm() {
        if (this.f27472j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27472j.cw().size(); i6++) {
            linkedList.add(new ae(this.f27472j.cw().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j getShowEcpm() {
        cw cwVar = this.f27472j;
        return cwVar != null ? new ae(cwVar.m()) : new ae(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public boolean isReady() {
        cw cwVar = this.f27472j;
        if (cwVar != null) {
            return cwVar.j();
        }
        return false;
    }

    public j(cw cwVar) {
        this.f27472j = cwVar;
    }
}
