package com.bytedance.embedapplog;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class v extends kt {
    private boolean up;
    static final long[] xt = {920000};
    static final long[] cw = {920000};

    /* renamed from: r, reason: collision with root package name */
    private static final long[] f24082r = {10000, 10000, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    @Override // com.bytedance.embedapplog.kt
    boolean cw() {
        JSONObject j6;
        JSONObject jSONObject = new JSONObject();
        wq up = this.f24007j.up();
        JSONObject j7 = up.j();
        if (j7 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            synchronized (up) {
                j6 = ri.j(j7);
            }
            jSONObject.put("header", j6);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(j6.optString("device_id")) && ri.r() && this.up) {
                this.up = false;
                return false;
            }
            JSONObject j8 = q.j(qb.j(this.f24007j.xt(), this.f24007j.up().j(), this.f24007j.tl().j(), true, j.r()), jSONObject);
            if (j8 != null) {
                return this.f24007j.up().j(j8, j8.optString("device_id", ""), j8.optString("install_id", ""), j8.optString("ssid", ""));
            }
        } else {
            uc.xt((Throwable) null);
        }
        return false;
    }

    @Override // com.bytedance.embedapplog.kt
    long j() {
        return this.f24007j.up().vl() + (this.f24007j.ae().cw() ? 21600000 : 43200000);
    }

    @Override // com.bytedance.embedapplog.kt
    String r() {
        return com.kuaishou.weapon.p0.t.f36150k;
    }

    @Override // com.bytedance.embedapplog.kt
    long[] xt() {
        int qv = this.f24007j.up().qv();
        if (qv == 0) {
            return f24082r;
        }
        if (qv == 1) {
            return cw;
        }
        if (qv == 2) {
            return xt;
        }
        uc.xt((Throwable) null);
        return cw;
    }

    v(f fVar) {
        super(fVar);
        this.up = true;
    }
}
