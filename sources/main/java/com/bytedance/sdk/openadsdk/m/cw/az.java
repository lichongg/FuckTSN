package com.bytedance.sdk.openadsdk.m.cw;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class az implements r {
    private int ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private long f31576g;

    /* renamed from: j, reason: collision with root package name */
    private long f31577j;

    /* renamed from: m, reason: collision with root package name */
    private JSONArray f31578m;
    private int oq;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private int f31579r;
    private long tl;
    private String up;
    private long xt;

    public void cw(long j6) {
        this.f31577j = j6;
    }

    public void j(boolean z5) {
        this.qv = z5;
    }

    public void r(long j6) {
        this.xt = j6;
    }

    public void xt(long j6) {
        this.tl = j6;
    }

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f31577j);
            jSONObject.put("total_duration", this.xt);
            jSONObject.put("error_code", this.cw);
            jSONObject.put("extra_error_code", this.f31579r);
            jSONObject.put("error_message", this.up);
            jSONObject.put("event_list", this.f31578m);
            jSONObject.put("vbtt_skip_type", this.ae);
            jSONObject.put("video_cache_size", this.tl);
            jSONObject.put("current", this.f31576g);
            jSONObject.put("percent", this.oq);
            jSONObject.put("has_endcard_skip", this.qv);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void cw(int i6) {
        this.cw = i6;
    }

    public void j(long j6) {
        this.f31576g = j6;
    }

    public void r(int i6) {
        this.f31579r = i6;
    }

    public void xt(int i6) {
        this.ae = i6;
    }

    public void j(int i6) {
        this.oq = i6;
    }

    public void j(JSONArray jSONArray) {
        this.f31578m = jSONArray;
    }

    public void j(String str) {
        this.up = str;
    }
}
