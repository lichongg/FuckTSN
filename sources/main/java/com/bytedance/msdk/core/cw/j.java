package com.bytedance.msdk.core.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private double cw;

    /* renamed from: j, reason: collision with root package name */
    private double f24458j;

    /* renamed from: m, reason: collision with root package name */
    private int f24459m;
    private String oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private double f24460r;
    private String up;
    private double xt;
    private int ae = 0;
    private int tl = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f24457g = 0;

    public double cw() {
        return this.xt;
    }

    public boolean j() {
        return r();
    }

    public double xt() {
        return this.f24458j;
    }

    private boolean j(double d6, double d7) {
        String str = this.up;
        str.getClass();
        switch (str) {
            case "1":
                if (d6 > d7) {
                }
                break;
            case "2":
                if (d6 < d7) {
                }
                break;
            case "3":
                if (d6 >= d7) {
                }
                break;
            case "4":
                if (d6 <= d7) {
                }
                break;
            case "5":
                if (d6 == d7) {
                }
                break;
        }
        return true;
    }

    private boolean r() {
        return j(this.f24458j, this.cw);
    }

    private boolean up() {
        return j(this.xt, this.f24460r);
    }

    public void cw(int i6) {
        this.f24457g = i6;
    }

    public String toString() {
        return "adnName = " + this.oq + " adnRit = " + this.qv + ", send = " + this.ae + ", fill = " + this.tl + ", show = " + this.f24457g + " localSsr = " + this.f24458j + ", serviceSsr = " + this.cw + ", localSrr = " + this.xt + ", serviceSrr = " + this.f24460r + ", opt = " + this.up + ", condition = " + this.f24459m + ", compareBehaviorSsr = " + r() + ", compareBehaviorSrr = " + up() + ", checkBehaviorRule = " + j();
    }

    public void xt(int i6) {
        this.tl = i6;
    }

    public j(double d6, double d7, double d8, double d9, int i6, String str) {
        this.f24458j = d6;
        this.xt = d7;
        this.cw = d8;
        this.f24460r = d9;
        this.up = str;
        this.f24459m = i6;
    }

    public void j(int i6) {
        this.ae = i6;
    }

    public void xt(String str) {
        this.qv = str;
    }

    public void j(String str) {
        this.oq = str;
    }
}
