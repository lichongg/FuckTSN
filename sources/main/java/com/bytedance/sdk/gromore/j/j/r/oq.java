package com.bytedance.sdk.gromore.j.j.r;

import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq extends com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up {

    /* renamed from: j, reason: collision with root package name */
    private ws f27467j;

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt> getAdLoadInfo() {
        if (this.f27467j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27467j.xt().size(); i6++) {
            linkedList.add(new tl(this.f27467j.xt().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j getBestEcpm() {
        ws wsVar = this.f27467j;
        return wsVar != null ? new ae(wsVar.r()) : new ae(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j> getCacheList() {
        if (this.f27467j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27467j.up().size(); i6++) {
            linkedList.add(new ae(this.f27467j.up().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j> getMultiBiddingEcpm() {
        if (this.f27467j == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i6 = 0; i6 < this.f27467j.cw().size(); i6++) {
            linkedList.add(new ae(this.f27467j.cw().get(i6)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j getShowEcpm() {
        ws wsVar = this.f27467j;
        return wsVar != null ? new ae(wsVar.m()) : new ae(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public boolean hasDislike() {
        ws wsVar = this.f27467j;
        if (wsVar != null) {
            return wsVar.ae();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public boolean isExpress() {
        ws wsVar = this.f27467j;
        if (wsVar != null) {
            return wsVar.tl();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public boolean isReady() {
        ws wsVar = this.f27467j;
        if (wsVar != null) {
            return wsVar.j();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public void onPause() {
        ws wsVar = this.f27467j;
        if (wsVar != null) {
            wsVar.oq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public void onResume() {
        ws wsVar = this.f27467j;
        if (wsVar != null) {
            wsVar.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public void setShakeViewListener(final com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.m mVar) {
        ws wsVar = this.f27467j;
        if (wsVar != null) {
            wsVar.j(new az() { // from class: com.bytedance.sdk.gromore.j.j.r.oq.1
                @Override // com.bytedance.sdk.gromore.j.j.r.az
                public void j() {
                    com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.m mVar2 = mVar;
                    if (mVar2 != null) {
                        mVar2.j();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public void setUseCustomVideo(boolean z5) {
        ws wsVar = this.f27467j;
        if (wsVar != null) {
            wsVar.j(z5);
        }
    }

    public oq(ws wsVar) {
        this.f27467j = wsVar;
    }
}
