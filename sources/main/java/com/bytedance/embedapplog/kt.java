package com.bytedance.embedapplog;

/* loaded from: D:\Downloads\app\classes3.dex */
abstract class kt {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    final f f24007j;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f24008r;
    private int xt = 0;

    abstract boolean cw();

    abstract long j();

    abstract String r();

    void up() {
        this.cw = true;
    }

    abstract long[] xt();

    boolean m() {
        return this.cw;
    }

    void tl() {
        uc.j("setImmediately, " + r());
        this.f24008r = true;
    }

    kt(f fVar) {
        this.f24007j = fVar;
    }

    final long ae() {
        boolean z5;
        long j6;
        long j7 = j();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f24008r) {
            this.f24008r = false;
            j7 = 0;
        }
        if (j7 <= 1000 + currentTimeMillis) {
            try {
                z5 = cw();
            } catch (Exception e6) {
                uc.xt(e6);
                z5 = false;
            }
            if (z5) {
                this.xt = 0;
                j6 = j() - System.currentTimeMillis();
            } else {
                long[] xt = xt();
                int i6 = this.xt;
                this.xt = i6 + 1;
                j6 = xt[i6 % xt.length];
            }
            uc.r(r() + " worked:" + z5 + " " + j6, null);
            return j6;
        }
        return j7 - currentTimeMillis;
    }
}
