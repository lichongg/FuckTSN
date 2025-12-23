package com.bytedance.sdk.component.tl.xt.xt.j;

import com.bytedance.sdk.component.tl.j.r;
import com.bytedance.sdk.component.tl.j.tl;
import com.bytedance.sdk.component.tl.j.up;
import com.bytedance.sdk.component.tl.xt.xt.xt;
import com.bytedance.sdk.component.utils.vl;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private StringBuffer f26834j = new StringBuffer();
    private AtomicLong xt = new AtomicLong(0);
    private AtomicLong cw = new AtomicLong(0);

    /* renamed from: r, reason: collision with root package name */
    private AtomicLong f26836r = new AtomicLong(0);
    private AtomicLong up = new AtomicLong(0);

    /* renamed from: m, reason: collision with root package name */
    private AtomicLong f26835m = new AtomicLong(0);
    private AtomicLong ae = new AtomicLong(0);
    private AtomicLong tl = new AtomicLong(0);

    /* renamed from: g, reason: collision with root package name */
    private AtomicLong f26832g = new AtomicLong(0);
    private AtomicLong oq = new AtomicLong(0);
    private AtomicLong qv = new AtomicLong(0);
    private AtomicLong vl = new AtomicLong(0);
    private AtomicLong jy = new AtomicLong(0);
    private AtomicLong ws = new AtomicLong(0);
    private AtomicLong az = new AtomicLong(0);
    private AtomicLong av = new AtomicLong(0);

    /* renamed from: i, reason: collision with root package name */
    private AtomicLong f26833i = new AtomicLong(0);

    /* renamed from: w, reason: collision with root package name */
    private AtomicLong f26838w = new AtomicLong(0);
    private AtomicLong mi = new AtomicLong(0);
    private AtomicLong kt = new AtomicLong(0);
    private AtomicLong tj = new AtomicLong(0);

    /* renamed from: f, reason: collision with root package name */
    private AtomicLong f26831f = new AtomicLong(0);

    /* renamed from: v, reason: collision with root package name */
    private AtomicLong f26837v = new AtomicLong(0);

    /* renamed from: x, reason: collision with root package name */
    private AtomicLong f26839x = new AtomicLong(0);

    public AtomicLong j() {
        return this.f26839x;
    }

    public synchronized void m() {
        jy().set(0L);
        tj().set(0L);
        f().set(0L);
        kt().set(0L);
        x().set(0L);
        v().set(0L);
        mi().set(0L);
        w().set(0L);
        av().set(0L);
        vl().set(0L);
        ws().set(0L);
        i().set(0L);
        az().set(0L);
        oq().set(0L);
        tl().set(0L);
        g().set(0L);
        ae().set(0L);
        qv().set(0L);
        r().set(0L);
        cw().set(0L);
        xt().set(0L);
        j().set(0L);
        try {
            if (this.f26834j.length() != 0) {
                this.f26834j.setLength(0);
            }
        } catch (Exception unused) {
        }
    }

    public AtomicLong ae() {
        return this.f26832g;
    }

    public AtomicLong av() {
        return this.tl;
    }

    public AtomicLong az() {
        return this.ae;
    }

    public StringBuffer ch() {
        return this.f26834j;
    }

    public AtomicLong cw() {
        return this.f26831f;
    }

    public AtomicLong f() {
        return this.f26833i;
    }

    public AtomicLong g() {
        return this.cw;
    }

    public AtomicLong i() {
        return this.oq;
    }

    public synchronized void j(long j6) {
        this.xt.getAndAdd(j6);
        this.cw.incrementAndGet();
    }

    public AtomicLong jy() {
        return this.f26836r;
    }

    public AtomicLong kt() {
        return this.az;
    }

    public AtomicLong mi() {
        return this.ws;
    }

    public AtomicLong oq() {
        return this.qv;
    }

    public AtomicLong qv() {
        return this.kt;
    }

    public AtomicLong r() {
        return this.tj;
    }

    public AtomicLong tj() {
        return this.av;
    }

    public AtomicLong tl() {
        return this.up;
    }

    public AtomicLong up() {
        return this.jy;
    }

    public AtomicLong v() {
        return this.f26838w;
    }

    public AtomicLong vl() {
        return this.xt;
    }

    public AtomicLong w() {
        return this.vl;
    }

    public AtomicLong ws() {
        return this.f26835m;
    }

    public AtomicLong x() {
        return this.mi;
    }

    public AtomicLong xt() {
        return this.f26837v;
    }

    public JSONObject j(long j6, up upVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            long j7 = g().get();
            long j8 = 1;
            jSONObject.put("create_save_cost_ts_avg", (vl().get() * 1.0f) / (j7 == 0 ? 1L : j7));
            jSONObject.put("save_success_count", j7);
            long j9 = tl().get();
            jSONObject.put("save_upload_cost_ts_avg", (jy().get() * 1.0f) / (j9 == 0 ? 1L : j9));
            jSONObject.put("will_send_count", j9);
            jSONObject.put("sdk_event_index", j6);
            jSONObject.put("sdk_send_success_count", this.jy.get());
            jSONObject.put("all_delete_count", ws().get());
            jSONObject.put("success_delete_count", az().get());
            jSONObject.put("invalid_delete_count", av().get());
            jSONObject.put("will_save_count", i().get());
            jSONObject.put("did_send_count", oq().get());
            jSONObject.put("send_success_valid_count", w().get());
            long j10 = ae().get();
            jSONObject.put("send_success_invalid_count", mi().get());
            jSONObject.put("send_fail_count", j10);
            jSONObject.put("before_save_count", qv().get());
            jSONObject.put("success_tm", r().get());
            jSONObject.put("queue_timeout_tm", cw().get());
            jSONObject.put("after_upload_tm", xt().get());
            jSONObject.put("quit_tm", j().get());
            long j11 = tj().get();
            long j12 = f().get();
            jSONObject.put("success_request_cost_ts_avg", (v().get() * 1.0f) / (j11 == 0 ? 1L : j11));
            float f6 = x().get() * 1.0f;
            if (j12 != 0) {
                j8 = j12;
            }
            jSONObject.put("fail_request_cost_ts_avg", f6 / j8);
            jSONObject.put("request_count", kt().get());
            jSONObject.put("request_success_count", j11);
            jSONObject.put("request_fail_count", j12);
            jSONObject.put("is_multi_process", upVar.qv());
            jSONObject.put("app_start_time", xt.cw);
            jSONObject.put("app_first_time", xt.f26841r);
            jSONObject.put("fail_code_list", this.f26834j.toString());
            r r5 = upVar.r();
            if (r5 != null) {
                jSONObject.put("is_debug", r5.j());
                tl vl = r5.vl();
                if (vl != null) {
                    jSONObject.put("is_plugin", vl.tl());
                    return jSONObject;
                }
            }
            return jSONObject;
        } catch (Exception e6) {
            vl.j(e6);
            return jSONObject;
        }
    }
}
