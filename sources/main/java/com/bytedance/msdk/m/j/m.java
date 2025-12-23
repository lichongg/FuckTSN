package com.bytedance.msdk.m.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends r {

    /* renamed from: j, reason: collision with root package name */
    private String f25161j;

    public m() {
        super(null);
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25161j = ae.j();
        }
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected String cw() {
        if (!TextUtils.isEmpty(this.f25161j)) {
            return "";
        }
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25161j = ae.j();
        }
        return TextUtils.isEmpty(this.f25161j) ? "appId为空" : "";
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected Map<String, Object> j() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f25161j);
        return hashMap;
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected String xt() {
        return MediationConstant.ADN_KLEVIN;
    }

    public m(com.bytedance.msdk.api.r.qv qvVar) {
        super(qvVar);
        if (qvVar != null) {
            this.f25161j = qvVar.cw();
        }
    }
}
