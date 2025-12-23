package com.bytedance.sdk.openadsdk.core.multipro.xt;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public long ae;
    public boolean cw;

    /* renamed from: j, reason: collision with root package name */
    public boolean f29581j;

    /* renamed from: m, reason: collision with root package name */
    public long f29582m;

    /* renamed from: r, reason: collision with root package name */
    public boolean f29583r;
    public boolean tl;
    public long up;
    public boolean xt;

    /* renamed from: com.bytedance.sdk.openadsdk.core.multipro.xt.j$j, reason: collision with other inner class name */
    public interface InterfaceC0466j {
        j la();

        boolean p();
    }

    public j cw(boolean z5) {
        this.f29581j = z5;
        return this;
    }

    public void j(boolean z5) {
        this.tl = z5;
    }

    public j xt(boolean z5) {
        this.f29583r = z5;
        return this;
    }

    public j cw(long j6) {
        this.ae = j6;
        return this;
    }

    public j j(long j6) {
        this.up = j6;
        return this;
    }

    public j r(boolean z5) {
        this.xt = z5;
        return this;
    }

    public j up(boolean z5) {
        this.cw = z5;
        return this;
    }

    public j xt(long j6) {
        this.f29582m = j6;
        return this;
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f29581j);
            jSONObject.put("isFromVideoDetailPage", this.xt);
            jSONObject.put("isFromDetailPage", this.cw);
            jSONObject.put("duration", this.up);
            jSONObject.put("totalPlayDuration", this.f29582m);
            jSONObject.put("currentPlayPosition", this.ae);
            jSONObject.put("isAutoPlay", this.f29583r);
            jSONObject.put("isMute", this.tl);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static j j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        jVar.cw(jSONObject.optBoolean("isCompleted"));
        jVar.r(jSONObject.optBoolean("isFromVideoDetailPage"));
        jVar.up(jSONObject.optBoolean("isFromDetailPage"));
        jVar.j(jSONObject.optLong("duration"));
        jVar.xt(jSONObject.optLong("totalPlayDuration"));
        jVar.cw(jSONObject.optLong("currentPlayPosition"));
        jVar.xt(jSONObject.optBoolean("isAutoPlay"));
        jVar.j(jSONObject.optBoolean("isMute"));
        return jVar;
    }
}
