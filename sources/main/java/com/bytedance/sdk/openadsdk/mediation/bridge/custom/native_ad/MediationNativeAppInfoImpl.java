package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.j.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationNativeAppInfoImpl extends j {

    /* renamed from: j, reason: collision with root package name */
    private MediationNativeAdAppInfo f31692j;
    private SparseArray<Object> xt = new SparseArray<>();

    public SparseArray<Object> values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.f31692j;
        if (mediationNativeAdAppInfo != null) {
            this.xt.put(8505, mediationNativeAdAppInfo.getAppName());
            this.xt.put(8506, this.f31692j.getAuthorName());
            this.xt.put(8507, Long.valueOf(this.f31692j.getPackageSizeBytes()));
            this.xt.put(8508, this.f31692j.getPermissionsUrl());
            this.xt.put(8509, this.f31692j.getPermissionsMap());
            this.xt.put(8510, this.f31692j.getPrivacyAgreement());
            this.xt.put(8511, this.f31692j.getVersionName());
            this.xt.put(8512, this.f31692j.getAppInfoExtra());
        }
        return this.xt;
    }

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.f31692j = mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public <T> T applyFunction(int i6, ValueSet valueSet, Class<T> cls) {
        if (i6 == -99999986) {
            return (T) values();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public SparseArray<Object> get() {
        SparseArray<Object> values = values();
        if (values != null) {
            return values;
        }
        return null;
    }
}
