package com.bytedance.sdk.gromore.j.j.r;

import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.gromore.j.j.xt f27459j;

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getAbTestId() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.az() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getChannel() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.jy() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public Map<String, String> getCustomData() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        if (xtVar != null) {
            return xtVar.j();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getCustomSdkName() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.cw() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getEcpm() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.m() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getErrorMsg() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.tl() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getLevelTag() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.up() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public int getReqBiddingType() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        if (xtVar != null) {
            return xtVar.ae();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getRequestId() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.g() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getRitType() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.oq() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getScenarioId() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.av() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getSdkName() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.xt() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getSegmentId() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.vl() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getSlotId() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.r() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getSubChannel() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.ws() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.j
    public String getSubRitType() {
        com.bytedance.sdk.gromore.j.j.xt xtVar = this.f27459j;
        return xtVar != null ? xtVar.qv() : "";
    }

    public ae(com.bytedance.sdk.gromore.j.j.xt xtVar) {
        this.f27459j = xtVar;
    }
}
