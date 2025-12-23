package com.bytedance.sdk.openadsdk.i.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements ComplianceInfo {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31486j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getAppName() {
        return this.xt.stringValue(250001);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getAppVersion() {
        return this.xt.stringValue(250002);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getDeveloperName() {
        return this.xt.stringValue(250003);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getFunctionDescUrl() {
        return this.xt.stringValue(250007);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getPermissionUrl() {
        return this.xt.stringValue(250005);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public Map<String, String> getPermissionsMap() {
        return (Map) this.xt.objectValue(250006, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getPrivacyUrl() {
        return this.xt.stringValue(250004);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getRegNumber() {
        return this.xt.stringValue(250008);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getRegUrl() {
        return this.xt.stringValue(250009);
    }

    public cw(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = a.f22763c;
        function = function == null ? a.f22765e : function;
        this.f31486j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = a.j((SparseArray) apply).k();
        }
    }
}
