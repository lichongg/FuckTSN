package com.ss.android.socialbase.downloader.g;

/* loaded from: D:\Downloads\app\classes6.dex */
class r {
    private double cw = -1.0d;

    /* renamed from: j, reason: collision with root package name */
    private final double f38818j;

    /* renamed from: r, reason: collision with root package name */
    private int f38819r;
    private final int xt;

    public void j(double d6) {
        double d7 = 1.0d - this.f38818j;
        int i6 = this.f38819r;
        if (i6 > this.xt) {
            this.cw = Math.exp((d7 * Math.log(this.cw)) + (this.f38818j * Math.log(d6)));
        } else if (i6 > 0) {
            double d8 = (d7 * i6) / (i6 + 1.0d);
            this.cw = Math.exp((d8 * Math.log(this.cw)) + ((1.0d - d8) * Math.log(d6)));
        } else {
            this.cw = d6;
        }
        this.f38819r++;
    }

    public r(double d6) {
        int ceil;
        this.f38818j = d6;
        if (d6 == 0.0d) {
            ceil = Integer.MAX_VALUE;
        } else {
            ceil = (int) Math.ceil(1.0d / d6);
        }
        this.xt = ceil;
    }

    public double j() {
        return this.cw;
    }
}
