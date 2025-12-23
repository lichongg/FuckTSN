package com.bytedance.sdk.openadsdk.mediation.manager.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends MediationAdEcpmInfo {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31742j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getAbTestId() {
        return this.xt.stringValue(271019);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getChannel() {
        return this.xt.stringValue(271017);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public Map<String, String> getCustomData() {
        return (Map) this.xt.objectValue(271006, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getCustomSdkName() {
        return this.xt.stringValue(271008);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getEcpm() {
        return this.xt.stringValue(271011);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getErrorMsg() {
        return this.xt.stringValue(271013);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getLevelTag() {
        return this.xt.stringValue(271010);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public int getReqBiddingType() {
        return this.xt.intValue(271012);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getRequestId() {
        return this.xt.stringValue(271014);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getRitType() {
        return this.xt.stringValue(271015);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getScenarioId() {
        return this.xt.stringValue(271020);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSdkName() {
        return this.xt.stringValue(271007);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSegmentId() {
        return this.xt.stringValue(271016);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSlotId() {
        return this.xt.stringValue(271009);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSubChannel() {
        return this.xt.stringValue(271018);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSubRitType() {
        return this.xt.stringValue(271051);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = a.f22763c;
        function = function == null ? a.f22765e : function;
        this.f31742j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = a.j((SparseArray) apply).k();
        }
    }
}
