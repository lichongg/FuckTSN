package com.bytedance.embedapplog;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class mi extends kt {
    private long xt;

    @Override // com.bytedance.embedapplog.kt
    boolean cw() {
        JSONObject j6 = this.f24007j.up().j();
        if (this.f24007j.up().qv() == 0 || j6 == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.f24007j.up().j());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", currentTimeMillis);
        JSONObject cw = q.cw(q.j(qb.j(this.f24007j.xt(), this.f24007j.up().j(), this.f24007j.tl().r(), true, j.r()), q.cw), jSONObject);
        if (cw == null) {
            return false;
        }
        j.qv().xt(!ri.j(j.m(), cw), cw);
        if (uc.xt) {
            uc.j("getAbConfig ".concat(String.valueOf(cw)), null);
        }
        this.f24007j.up().j(cw);
        this.xt = currentTimeMillis;
        return true;
    }

    @Override // com.bytedance.embedapplog.kt
    long j() {
        long w5 = this.f24007j.r().w();
        if (w5 < TTAdConstant.AD_MAX_EVENT_TIME) {
            w5 = 600000;
        }
        return this.xt + w5;
    }

    @Override // com.bytedance.embedapplog.kt
    String r() {
        return "ab";
    }

    @Override // com.bytedance.embedapplog.kt
    long[] xt() {
        return v.cw;
    }

    mi(f fVar) {
        super(fVar);
    }
}
