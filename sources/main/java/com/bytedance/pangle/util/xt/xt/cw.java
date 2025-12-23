package com.bytedance.pangle.util.xt.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    private int ae;

    /* renamed from: g, reason: collision with root package name */
    private long f25551g;

    /* renamed from: j, reason: collision with root package name */
    private int f25552j;

    /* renamed from: m, reason: collision with root package name */
    private int f25553m;
    private String tl;
    private int up;
    private long xt = 0;
    private long cw = 0;

    /* renamed from: r, reason: collision with root package name */
    private long f25554r = 0;
    private final long oq = 30;

    public long cw() {
        return r() + xt();
    }

    public int j() {
        return this.f25552j;
    }

    public long r() {
        return this.up + 30 + this.ae;
    }

    public long xt() {
        long j6 = this.cw;
        return j6 > 0 ? j6 : this.f25554r;
    }

    public long ae() {
        return this.xt;
    }

    public void cw(long j6) {
        this.f25554r = j6;
    }

    public long g() {
        return this.f25554r;
    }

    public void j(int i6) {
        this.f25552j = i6;
    }

    public long jy() {
        return this.f25551g;
    }

    public int m() {
        return this.ae;
    }

    public int oq() {
        return this.up;
    }

    public int qv() {
        return this.f25553m;
    }

    public void r(int i6) {
        this.f25553m = i6;
    }

    public long tl() {
        return this.cw;
    }

    public long up() {
        return 28L;
    }

    public String vl() {
        return this.tl;
    }

    public void cw(int i6) {
        this.up = i6;
    }

    public void j(long j6) {
        this.xt = j6;
    }

    public void r(long j6) {
        this.f25551g = j6;
    }

    public void xt(int i6) {
        this.ae = i6;
    }

    public void j(String str) {
        this.tl = str;
    }

    public void xt(long j6) {
        this.cw = j6;
    }
}
