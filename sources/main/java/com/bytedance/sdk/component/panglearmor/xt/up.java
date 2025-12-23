package com.bytedance.sdk.component.panglearmor.xt;

import com.umeng.analytics.pro.bi;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static up f26718j;
    private boolean xt = false;
    private long cw = 180000;

    /* renamed from: r, reason: collision with root package name */
    private long f26720r = 43200000;
    private long up = 3;

    /* renamed from: m, reason: collision with root package name */
    private long f26719m = 30;
    private long ae = 15;

    public static up j() {
        if (f26718j == null) {
            synchronized (up.class) {
                try {
                    if (f26718j == null) {
                        f26718j = new up();
                    }
                } finally {
                }
            }
        }
        return f26718j;
    }

    public long ae() {
        return this.ae;
    }

    public long cw() {
        return this.f26720r;
    }

    public long m() {
        return this.f26719m;
    }

    public long r() {
        return this.cw;
    }

    public long up() {
        return this.up;
    }

    public boolean xt() {
        return this.xt;
    }

    private up() {
    }

    public synchronized void j(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.toString().isEmpty()) {
                this.xt = jSONObject.optBoolean("sensorenable", false);
                this.cw = jSONObject.optLong(bi.aX, 180000L);
                this.f26720r = jSONObject.optLong("expireduation", 43200000L);
                this.up = jSONObject.optLong("showinterval", 3L);
                this.f26719m = jSONObject.optLong("azimuth_unit", 30L);
                this.ae = jSONObject.optLong("angle_unit", 15L);
            }
        }
    }
}
