package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class h {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private String f30291j;

    /* renamed from: m, reason: collision with root package name */
    private String f30292m;

    /* renamed from: r, reason: collision with root package name */
    private double f30293r;
    private boolean up;
    private int xt;

    private static final class j extends com.bytedance.sdk.openadsdk.i.cw.xt.vl {
        private String cw;

        /* renamed from: j, reason: collision with root package name */
        private int f30294j;

        /* renamed from: r, reason: collision with root package name */
        private double f30295r;
        private int xt;

        @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
        public String cw() {
            return this.cw;
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
        public int j() {
            return this.f30294j;
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
        public double r() {
            return this.f30295r;
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
        public boolean up() {
            String str;
            return this.f30294j > 0 && this.xt > 0 && (str = this.cw) != null && str.length() > 0;
        }

        @Override // com.bytedance.sdk.openadsdk.i.cw.xt.vl
        public int xt() {
            return this.xt;
        }

        public j(int i6, int i7, String str, double d6) {
            this.f30294j = i6;
            this.xt = i7;
            this.cw = str;
            this.f30295r = d6;
        }
    }

    public String j() {
        return this.f30291j;
    }

    public int xt() {
        return this.xt;
    }

    public String ae() {
        return this.f30292m;
    }

    public int cw() {
        return this.cw;
    }

    public void j(String str) {
        this.f30291j = str;
    }

    public boolean m() {
        return this.up;
    }

    public double r() {
        return this.f30293r;
    }

    public boolean up() {
        return !TextUtils.isEmpty(this.f30291j) && this.xt > 0 && this.cw > 0;
    }

    public void xt(int i6) {
        this.cw = i6;
    }

    public void j(int i6) {
        this.xt = i6;
    }

    public void xt(String str) {
        this.f30292m = str;
    }

    public void j(double d6) {
        this.f30293r = d6;
    }

    public void j(boolean z5) {
        this.up = z5;
    }

    public static com.bytedance.sdk.openadsdk.i.cw.xt.vl j(h hVar) {
        if (hVar == null || !hVar.up()) {
            return null;
        }
        return new j(hVar.cw(), hVar.xt(), hVar.j(), hVar.r());
    }

    public static final com.bytedance.sdk.openadsdk.i.cw.xt.vl j(int i6, int i7, String str, double d6) {
        return new j(i6, i7, str, d6);
    }
}
