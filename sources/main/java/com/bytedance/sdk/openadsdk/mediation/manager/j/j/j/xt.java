package com.bytedance.sdk.openadsdk.mediation.manager.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements MediationAdLoadInfo {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31746j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdType() {
        return this.xt.stringValue(271003);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdnName() {
        return this.xt.stringValue(271002);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public int getErrCode() {
        return this.xt.intValue(271004);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getErrMsg() {
        return this.xt.stringValue(271005);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getMediationRit() {
        return this.xt.stringValue(271001);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = a.f22763c;
        function = function == null ? a.f22765e : function;
        this.f31746j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = a.j((SparseArray) apply).k();
        }
    }
}
