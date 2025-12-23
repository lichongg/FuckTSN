package com.bytedance.msdk.core.oq;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up implements Comparable<up> {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private String f24654j;

    /* renamed from: r, reason: collision with root package name */
    private int f24655r;
    private double xt;

    public String j() {
        return this.f24654j;
    }

    public int cw() {
        return this.cw;
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(up upVar) {
        if (upVar == null) {
            return 1;
        }
        if (this.xt > upVar.xt()) {
            return -1;
        }
        if (this.xt < upVar.xt() || this.cw > upVar.cw()) {
            return 1;
        }
        if (this.cw < upVar.cw()) {
            return -1;
        }
        if (this.f24655r > upVar.r()) {
            return 1;
        }
        return this.f24655r < upVar.r() ? -1 : 0;
    }

    public int r() {
        return this.f24655r;
    }

    public String toString() {
        return "{mCsjRitId:" + this.f24654j + ",mEcpm:" + this.xt + ",mLoadSort:" + this.cw + ",mShowSort:" + this.f24655r + "}";
    }

    public double xt() {
        return this.xt;
    }

    public up(String str, double d6, int i6, int i7) {
        this.f24654j = str;
        this.xt = d6;
        this.cw = i6;
        this.f24655r = i7;
    }
}
