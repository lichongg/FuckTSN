package com.bykv.vk.openvk.component.video.api.cw;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private String f22953j;
    private int tl;
    private String xt;
    private long cw = -2147483648L;

    /* renamed from: r, reason: collision with root package name */
    private int f22955r = Integer.MIN_VALUE;
    private long up = -2147483648L;

    /* renamed from: m, reason: collision with root package name */
    private double f22954m = -2.147483648E9d;
    private double ae = -2.147483648E9d;

    public JSONObject j() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.xt)) {
                jSONObject.putOpt("audio_url", this.xt);
            }
            if (!TextUtils.isEmpty(this.f22953j)) {
                jSONObject.putOpt("file_hash", this.f22953j);
            }
            long j6 = this.cw;
            if (j6 > 0) {
                jSONObject.put("size", j6);
            }
            int i6 = this.f22955r;
            if (i6 >= 0) {
                jSONObject.put("reward_audio_cached_type", i6);
            }
            long j7 = this.up;
            if (j7 >= 0) {
                jSONObject.put("audio_preload_size", j7);
            }
            double d6 = this.f22954m;
            if (d6 > 0.0d) {
                jSONObject.put("audio_duration", d6);
            }
            double d7 = this.ae;
            if (d7 > 0.0d) {
                jSONObject.put("start", d7);
            }
            int i7 = this.tl;
            if (i7 > 0) {
                jSONObject.put("repeat_count", i7);
            }
            return jSONObject;
        } catch (Exception e6) {
            e6.getMessage();
            return null;
        }
    }

    public String xt() {
        return this.f22953j;
    }

    public int ae() {
        return this.tl;
    }

    public long cw() {
        return this.cw;
    }

    public double m() {
        return this.f22954m;
    }

    public double r() {
        return this.ae;
    }

    public String up() {
        return this.xt;
    }

    public void xt(long j6) {
        this.up = j6;
    }

    public void xt(String str) {
        this.xt = str;
    }

    public void xt(double d6) {
        this.f22954m = d6;
    }

    public void xt(int i6) {
        if (i6 < 0) {
            i6 = 0;
        }
        this.tl = i6;
    }

    public void j(String str) {
        this.f22953j = str;
    }

    public void j(long j6) {
        this.cw = j6;
    }

    public void j(int i6) {
        this.f22955r = i6;
    }

    public void j(double d6) {
        this.ae = d6;
    }
}
