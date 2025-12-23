package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.m;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.xt;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationNativeManagerDefault extends up {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public boolean isExpress() {
        return false;
    }

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

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public void setShakeViewListener(m mVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up
    public void setUseCustomVideo(boolean z5) {
    }
}
