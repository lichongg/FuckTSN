package com.bytedance.sdk.component.cw.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class l {
    long ae;
    long cw;

    /* renamed from: j, reason: collision with root package name */
    long f26323j = System.currentTimeMillis();

    /* renamed from: m, reason: collision with root package name */
    long f26324m;

    /* renamed from: r, reason: collision with root package name */
    long f26325r;
    long up;
    long xt;

    public void j() {
        this.cw = System.currentTimeMillis();
    }

    public void xt() {
        this.f26325r = System.currentTimeMillis();
    }

    public long ae() {
        return this.up;
    }

    public long g() {
        return this.ae;
    }

    public void j(long j6) {
        this.f26324m = j6;
    }

    public long m() {
        return this.f26325r;
    }

    public long oq() {
        return this.xt;
    }

    public long r() {
        return this.f26323j;
    }

    public long tl() {
        return this.f26324m;
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.f26323j + ", asyncCallExecTs=" + this.xt + ", requestStartExecTs=" + this.cw + ", requestConnectStartTs=" + this.f26325r + ", requestConnectFinishTs=" + this.up + ", reqCallServerStartTs=" + this.f26324m + ", reqCallServerFinishTs=" + this.ae + '}';
    }

    public long up() {
        return this.cw;
    }

    public void xt(long j6) {
        this.ae = j6;
    }

    public void cw() {
        this.up = System.currentTimeMillis();
    }

    public void qv() {
        this.xt = System.currentTimeMillis();
    }
}
