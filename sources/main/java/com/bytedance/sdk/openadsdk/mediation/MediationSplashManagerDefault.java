package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.ae;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationSplashManagerDefault extends ae {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public List<xt> getAdLoadInfo() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.cw
    public MediationAdEcpmInfoDefault getBestEcpm() {
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
    public MediationAdEcpmInfoDefault getShowEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.ae
    public void destroy() {
    }
}
