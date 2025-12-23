package com.bytedance.embedapplog;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class tj extends kt {
    @Override // com.bytedance.embedapplog.kt
    public boolean cw() {
        JSONObject j6 = this.f24007j.up().j();
        if (this.f24007j.up().qv() == 0 || j6 == null || this.f24007j.r().ae() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", j6);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject xt = q.xt(q.j(qb.j(this.f24007j.xt(), this.f24007j.up().j(), this.f24007j.tl().cw(), true, j.r()), q.cw), jSONObject);
        j.qv().j(!ri.j(xt, this.f24007j.r().m()), xt);
        if (xt == null) {
            return false;
        }
        this.f24007j.r().j(xt);
        return true;
    }

    @Override // com.bytedance.embedapplog.kt
    long j() {
        return this.f24007j.r().ae() + 21600000;
    }

    @Override // com.bytedance.embedapplog.kt
    String r() {
        return "c";
    }

    @Override // com.bytedance.embedapplog.kt
    long[] xt() {
        return v.cw;
    }

    tj(f fVar) {
        super(fVar);
    }
}
