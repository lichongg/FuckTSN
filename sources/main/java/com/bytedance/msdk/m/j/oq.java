package com.bytedance.msdk.m.j;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class oq extends r {

    /* renamed from: j, reason: collision with root package name */
    protected String f25162j;

    public oq() {
        super(null);
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25162j = ae.j();
        }
        if (TextUtils.isEmpty(this.f25162j)) {
            this.f25162j = com.bytedance.msdk.core.j.qv().vl();
        }
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected String cw() {
        if (!TextUtils.isEmpty(this.f25162j)) {
            return "";
        }
        com.bytedance.msdk.core.oq.j ae = ae();
        if (ae != null) {
            this.f25162j = ae.j();
        }
        return TextUtils.isEmpty(this.f25162j) ? "appId为空" : "";
    }

    @Override // com.bytedance.msdk.m.j.cw
    protected Map<String, Object> j() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f25162j);
        hashMap.put("pangle_app_name", com.bytedance.msdk.core.j.qv().tj());
        hashMap.put("pangle_is_pangle_paid", Boolean.valueOf(com.bytedance.msdk.core.j.qv().az()));
        hashMap.put("pangle_title_bar_theme", Integer.valueOf(com.bytedance.msdk.core.j.qv().f()));
        hashMap.put("pangle_is_pangle_allow_show_notify", Boolean.valueOf(com.bytedance.msdk.core.j.qv().ws()));
        hashMap.put("pangle_is_pangle_allow_show_page_when_screen_lock", Boolean.valueOf(com.bytedance.msdk.core.j.qv().kt()));
        hashMap.put("pangle_direct_download_networktype", com.bytedance.msdk.core.j.qv().mi());
        hashMap.put("pangle_need_clear_task_reset", com.bytedance.msdk.core.j.qv().v());
        hashMap.put("pangle_keywords", com.bytedance.msdk.core.j.qv().a());
        hashMap.put("pangle_support_multi_process", Boolean.valueOf(com.bytedance.msdk.core.j.qv().jy()));
        return hashMap;
    }

    public static oq g() {
        if (com.bytedance.msdk.core.j.qv().uf()) {
            return new qv();
        }
        return new g();
    }

    public static oq xt(com.bytedance.msdk.api.r.qv qvVar) {
        if (com.bytedance.msdk.core.j.qv().uf()) {
            return new qv(qvVar);
        }
        return new g(qvVar);
    }

    public oq(com.bytedance.msdk.api.r.qv qvVar) {
        super(qvVar);
        if (qvVar != null) {
            this.f25162j = qvVar.cw();
        }
    }
}
