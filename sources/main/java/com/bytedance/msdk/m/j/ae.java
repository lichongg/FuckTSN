package com.bytedance.msdk.m.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends r {

    /* renamed from: j, reason: collision with root package name */
    private String f25156j;

    public ae() {
        super(null);
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25156j = ae.j();
        }
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected String cw() {
        if (!TextUtils.isEmpty(this.f25156j)) {
            return "";
        }
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25156j = ae.j();
        }
        return TextUtils.isEmpty(this.f25156j) ? "appId为空" : "";
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected Map<String, Object> j() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f25156j);
        hashMap.put("app_name", com.bytedance.msdk.core.j.qv().tj());
        return hashMap;
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected String xt() {
        return MediationConstant.ADN_KS;
    }

    public ae(com.bytedance.msdk.api.r.qv qvVar) {
        super(qvVar);
        if (qvVar != null) {
            this.f25156j = qvVar.cw();
        }
    }
}
