package com.bytedance.sdk.openadsdk.mediation.ad.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends MediationNativeAdAppInfo {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31653j;

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, Object> getAppInfoExtra() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271042);
        sparseArray.put(-99999985, Map.class);
        apply = this.f31653j.apply(sparseArray);
        return (Map) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAppName() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271035);
        sparseArray.put(-99999985, String.class);
        apply = this.f31653j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAuthorName() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271036);
        sparseArray.put(-99999985, String.class);
        apply = this.f31653j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getFunctionDescUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271047);
        sparseArray.put(-99999985, String.class);
        apply = this.f31653j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public long getPackageSizeBytes() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271037);
        sparseArray.put(-99999985, Long.TYPE);
        apply = this.f31653j.apply(sparseArray);
        return ((Long) apply).longValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, String> getPermissionsMap() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271039);
        sparseArray.put(-99999985, Map.class);
        apply = this.f31653j.apply(sparseArray);
        return (Map) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPermissionsUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271038);
        sparseArray.put(-99999985, String.class);
        apply = this.f31653j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPrivacyAgreement() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271040);
        sparseArray.put(-99999985, String.class);
        apply = this.f31653j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getRegUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271051);
        sparseArray.put(-99999985, String.class);
        apply = this.f31653j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getVersionName() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271041);
        sparseArray.put(-99999985, String.class);
        apply = this.f31653j.apply(sparseArray);
        return (String) apply;
    }

    public cw(Function<SparseArray<Object>, Object> function) {
        this.f31653j = function == null ? a.f22765e : function;
    }
}
