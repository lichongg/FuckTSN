package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.r;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationFullScreenManagerDefault extends r {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<xt> getAdLoadInfo() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public j getBestEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<j> getCacheList() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<j> getMultiBiddingEcpm() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public j getShowEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.r
    public void destroy() {
    }
}
