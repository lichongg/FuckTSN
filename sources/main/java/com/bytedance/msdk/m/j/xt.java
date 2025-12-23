package com.bytedance.msdk.m.j;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends r {

    /* renamed from: j, reason: collision with root package name */
    private String f25166j;

    public xt() {
        super(null);
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25166j = ae.j();
        }
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected String cw() {
        if (!TextUtils.isEmpty(this.f25166j)) {
            return "";
        }
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25166j = ae.j();
        }
        return TextUtils.isEmpty(this.f25166j) ? "appId为空" : "";
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected Map<String, Object> j() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f25166j);
        hashMap.put("baidu_https", Boolean.valueOf(com.bytedance.msdk.core.j.qv().wq()));
        if (!TextUtils.isEmpty(com.bytedance.msdk.core.j.qv().m())) {
            hashMap.put("baidu_wx_app_id", com.bytedance.msdk.core.j.qv().m());
        }
        return hashMap;
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected String xt() {
        return "baidu";
    }

    public xt(com.bytedance.msdk.api.r.qv qvVar) {
        super(qvVar);
        if (qvVar != null) {
            this.f25166j = qvVar.cw();
        }
    }
}
