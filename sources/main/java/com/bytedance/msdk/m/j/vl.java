package com.bytedance.msdk.m.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl extends r {

    /* renamed from: j, reason: collision with root package name */
    private String f25165j;
    private String xt;

    public vl() {
        super(null);
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25165j = ae.j();
            this.xt = ae.xt();
        }
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected String cw() {
        if (!TextUtils.isEmpty(this.f25165j) && !TextUtils.isEmpty(this.xt)) {
            return "";
        }
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25165j = ae.j();
            this.xt = ae.xt();
        }
        return (TextUtils.isEmpty(this.f25165j) || TextUtils.isEmpty(this.xt)) ? "appId为空或appKey为空" : "";
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected Map<String, Object> j() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f25165j);
        hashMap.put("app_key", this.xt);
        return hashMap;
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected String xt() {
        return MediationConstant.ADN_SIGMOB;
    }

    public vl(com.bytedance.msdk.api.r.qv qvVar) {
        super(qvVar);
        if (qvVar != null) {
            this.f25165j = qvVar.cw();
            this.xt = qvVar.r();
        }
    }
}
