package com.bytedance.sdk.openadsdk.core.jy;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.oq;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private final n xt;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f29315j = false;
    private String cw = "landingpage";

    /* renamed from: r, reason: collision with root package name */
    private long f29317r = 0;
    private long up = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f29316m = 0;
    private long ae = 0;
    private long tl = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f29314g = 0;
    private AtomicInteger oq = new AtomicInteger(0);
    private boolean qv = false;
    private AtomicBoolean vl = new AtomicBoolean(false);

    public up j(boolean z5) {
        this.qv = z5;
        return this;
    }

    public void r() {
        if (this.vl.get() || !this.f29315j) {
            return;
        }
        cw.j(this.xt, this.cw, "load", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.jy.up.1
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "ugen");
                if (up.this.xt != null && oq.tl(up.this.xt)) {
                    jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(up.this.xt.kt()));
                }
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject2, up.this.xt);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
                jSONObject.put("duration", Math.min(System.currentTimeMillis() - up.this.f29314g, TTAdConstant.AD_MAX_EVENT_TIME));
            }
        });
    }

    public void xt() {
        if (this.f29315j) {
            return;
        }
        this.ae = System.currentTimeMillis();
        this.f29314g = System.currentTimeMillis();
        this.f29315j = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            n nVar = this.xt;
            if (nVar != null && oq.tl(nVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.xt.kt()));
            }
        } catch (Exception unused) {
        }
        j("load_start", jSONObject);
    }

    public up(n nVar) {
        this.xt = nVar;
    }

    public void cw() {
        this.f29316m = System.currentTimeMillis();
        this.f29317r = System.currentTimeMillis();
    }

    public void j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            n nVar = this.xt;
            if (nVar != null && oq.tl(nVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.xt.kt()));
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        j("open_url_h5", jSONObject);
    }

    public void j(int i6, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            n nVar = this.xt;
            if (nVar != null && oq.tl(nVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.xt.kt()));
            }
            jSONObject.putOpt("code", Integer.valueOf(i6));
            jSONObject.putOpt("msg", str);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        j("load_fail", jSONObject);
    }

    public void j(long j6) {
        if (this.vl.get()) {
            return;
        }
        this.vl.set(true);
        this.tl = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long j7 = this.tl - this.ae;
        try {
            jSONObject.putOpt("render_type", "ugen");
            jSONObject.put("net_work_duration", j6);
            n nVar = this.xt;
            if (nVar != null && oq.tl(nVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.xt.kt()));
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        j("load_finish", jSONObject, Math.min(j7, TTAdConstant.AD_MAX_EVENT_TIME));
    }

    public void j(int i6) {
        long currentTimeMillis = System.currentTimeMillis();
        this.up = currentTimeMillis;
        long max = currentTimeMillis - Math.max(this.f29317r, this.f29316m);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", 2);
            jSONObject.put("max_scroll_percent", this.oq.get());
            jSONObject.put("is_slide", i6);
            jSONObject.putOpt("render_type", "ugen");
            n nVar = this.xt;
            if (nVar != null && oq.tl(nVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.xt.kt()));
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        j("stay_page", jSONObject, Math.min(max, TTAdConstant.AD_MAX_EVENT_TIME));
    }

    private void j(String str, JSONObject jSONObject) {
        j(str, jSONObject, -1L);
    }

    private void j(String str, JSONObject jSONObject, long j6) {
        if (!this.qv || this.xt == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    if (j6 > 0) {
                        jSONObject3.put("duration", j6);
                    }
                    jSONObject2 = jSONObject3;
                } catch (JSONException e6) {
                    e = e6;
                    jSONObject2 = jSONObject3;
                    vl.j(e);
                    cw.cw(this.xt, this.cw, str, jSONObject2);
                }
            } catch (JSONException e7) {
                e = e7;
            }
        }
        cw.cw(this.xt, this.cw, str, jSONObject2);
    }
}
