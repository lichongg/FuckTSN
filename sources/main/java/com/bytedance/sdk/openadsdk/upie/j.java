package com.bytedance.sdk.openadsdk.upie;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private JSONObject ae;
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f31882j;

    /* renamed from: m, reason: collision with root package name */
    private long f31883m;

    /* renamed from: r, reason: collision with root package name */
    private int f31884r;
    private int up;
    private String xt;

    /* renamed from: com.bytedance.sdk.openadsdk.upie.j$j, reason: collision with other inner class name */
    public static class C0506j {
        private JSONObject ae;
        private String cw;

        /* renamed from: j, reason: collision with root package name */
        private String f31885j;

        /* renamed from: m, reason: collision with root package name */
        private long f31886m;

        /* renamed from: r, reason: collision with root package name */
        private int f31887r;
        private int up;
        private String xt;

        public C0506j j(String str) {
            this.f31885j = str;
            return this;
        }

        public C0506j xt(String str) {
            this.xt = str;
            return this;
        }

        public C0506j cw(String str) {
            this.cw = str;
            return this;
        }

        public C0506j j(int i6) {
            this.f31887r = i6;
            return this;
        }

        public C0506j xt(int i6) {
            this.up = i6;
            return this;
        }

        public C0506j j(long j6) {
            this.f31886m = j6;
            return this;
        }

        public C0506j j(JSONObject jSONObject) {
            this.ae = jSONObject;
            return this;
        }

        public j j() {
            j jVar = new j();
            jVar.f31882j = this.f31885j;
            jVar.xt = this.xt;
            jVar.cw = this.cw;
            jVar.f31884r = this.f31887r;
            jVar.up = this.up;
            jVar.f31883m = this.f31886m;
            jVar.ae = this.ae;
            return jVar;
        }
    }

    public JSONObject ae() {
        return this.ae;
    }

    public String cw() {
        return this.cw;
    }

    public long m() {
        return this.f31883m;
    }

    public int r() {
        return this.f31884r;
    }

    public int up() {
        return this.up;
    }

    public String xt() {
        return this.xt;
    }

    public String j() {
        return this.f31882j;
    }
}
