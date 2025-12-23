package com.bykv.vk.openvk.component.video.api.cw;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private String ae;
    private long cw;

    /* renamed from: g, reason: collision with root package name */
    private String f22947g;

    /* renamed from: j, reason: collision with root package name */
    private int f22949j;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    private String f22950m;
    private String oq;
    private double qv;

    /* renamed from: r, reason: collision with root package name */
    private double f22951r;
    private String tl;
    private String up;
    private int vl;
    private int xt;
    private float ws = -1.0f;
    private int az = 0;
    private int av = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f22948i = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f22952w = 0;
    private int mi = 307200;
    private int kt = 1;

    public int cw() {
        return this.xt;
    }

    public int j() {
        return this.vl;
    }

    public double m() {
        return this.f22951r;
    }

    public int r() {
        return this.jy;
    }

    public long up() {
        return this.cw;
    }

    public int xt() {
        return this.f22949j;
    }

    public double ae() {
        return this.qv;
    }

    public int av() {
        if (this.mi < 0) {
            this.mi = 307200;
        }
        long j6 = this.mi;
        long j7 = this.cw;
        if (j6 > j7) {
            this.mi = (int) j7;
        }
        return this.mi;
    }

    public String az() {
        if (TextUtils.isEmpty(this.oq)) {
            this.oq = com.bykv.vk.openvk.component.video.api.m.xt.j(this.ae);
        }
        return this.oq;
    }

    public void cw(int i6) {
        this.xt = i6;
    }

    public boolean f() {
        return this.f22952w == 1;
    }

    public String g() {
        return this.up;
    }

    public int i() {
        return this.f22948i;
    }

    public void j(int i6) {
        this.vl = i6;
    }

    public String jy() {
        return this.tl;
    }

    public int kt() {
        return this.az;
    }

    public void m(int i6) {
        this.f22952w = i6;
    }

    public JSONObject mi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", xt());
            jSONObject.put("cover_url", qv());
            jSONObject.put("cover_width", cw());
            jSONObject.put("endcard", jy());
            jSONObject.put("file_hash", az());
            jSONObject.put("resolution", g());
            jSONObject.put("size", up());
            jSONObject.put("video_duration", m());
            jSONObject.put("video_url", vl());
            jSONObject.put("playable_download_url", ws());
            jSONObject.put("if_playable_loading_show", kt());
            jSONObject.put("remove_loading_page_type", tj());
            jSONObject.put("fallback_endcard_judge", j());
            jSONObject.put("video_preload_size", av());
            jSONObject.put("reward_video_cached_type", i());
            jSONObject.put("execute_cached_type", w());
            jSONObject.put("endcard_render", r());
            jSONObject.put("replay_time", x());
            jSONObject.put("play_speed_ratio", tl());
            if (ae() > 0.0d) {
                jSONObject.put("start", ae());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int[] oq() {
        try {
            int indexOf = this.up.indexOf("x");
            return new int[]{Integer.parseInt(this.up.substring(0, indexOf).trim()), Integer.parseInt(this.up.substring(indexOf + 1).trim())};
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.cw("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public String qv() {
        return this.f22950m;
    }

    public void r(String str) {
        this.tl = str;
    }

    public int tj() {
        return this.av;
    }

    public float tl() {
        return this.ws;
    }

    public void up(String str) {
        this.oq = str;
    }

    public boolean v() {
        return this.f22948i == 0;
    }

    public String vl() {
        return this.ae;
    }

    public int w() {
        return this.f22952w;
    }

    public String ws() {
        return this.f22947g;
    }

    public int x() {
        return this.kt;
    }

    public void xt(int i6) {
        this.f22949j = i6;
    }

    public void cw(String str) {
        this.ae = str;
    }

    public void j(long j6) {
        this.cw = j6;
    }

    public void r(int i6) {
        this.mi = i6;
    }

    public void up(int i6) {
        this.f22948i = i6;
    }

    public void xt(double d6) {
        this.qv = d6;
    }

    public void j(double d6) {
        this.f22951r = d6;
    }

    public void xt(String str) {
        this.f22950m = str;
    }

    public void j(float f6) {
        this.ws = f6;
    }

    public void j(String str) {
        this.up = str;
    }
}
