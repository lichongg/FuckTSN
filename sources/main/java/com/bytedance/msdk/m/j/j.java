package com.bytedance.msdk.m.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends cw {

    /* renamed from: j, reason: collision with root package name */
    private String f25159j;

    @Override // com.bytedance.msdk.m.j.cw
    protected String cw() {
        if (!TextUtils.isEmpty(this.f25159j)) {
            return "";
        }
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25159j = ae.j();
        }
        return TextUtils.isEmpty(this.f25159j) ? "appId为空" : "";
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected Map<String, Object> j() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f25159j);
        return hashMap;
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected String xt() {
        return MediationConstant.ADN_ADMOB;
    }

    public j() {
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25159j = ae.j();
        }
    }
}
