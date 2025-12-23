package com.bytedance.msdk.core.up.xt;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae implements Comparable<ae> {
    private boolean cw = false;

    /* renamed from: j, reason: collision with root package name */
    public com.bytedance.msdk.xt.cw f24739j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.msdk.api.j.xt f24740r;
    private long xt;

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(ae aeVar) {
        return this.f24739j.compareTo(aeVar.f24739j);
    }

    public String xt() {
        com.bytedance.msdk.xt.cw cwVar = this.f24739j;
        if (cwVar == null) {
            return null;
        }
        return cwVar.qa();
    }

    public boolean ae() {
        com.bytedance.msdk.xt.cw cwVar = this.f24739j;
        if (cwVar == null) {
            return false;
        }
        return cwVar.f();
    }

    public boolean cw() {
        return this.cw;
    }

    public long j() {
        return this.xt;
    }

    public String m() {
        com.bytedance.msdk.api.j.xt xtVar = this.f24740r;
        if (xtVar == null) {
            return null;
        }
        return xtVar.v();
    }

    public com.bytedance.msdk.api.j.xt r() {
        return this.f24740r;
    }

    public boolean up() {
        com.bytedance.msdk.xt.cw cwVar = this.f24739j;
        return (cwVar == null || this.f24740r == null || cwVar.qb() || !this.f24739j.wq(this.f24740r.v())) ? false : true;
    }

    public ae(com.bytedance.msdk.xt.cw cwVar, long j6, com.bytedance.msdk.api.j.xt xtVar) {
        this.f24739j = cwVar;
        this.xt = j6;
        this.f24740r = xtVar;
    }

    public void j(boolean z5) {
        this.cw = z5;
    }

    public void xt(boolean z5) {
        com.bytedance.msdk.xt.cw cwVar = this.f24739j;
        if (cwVar == null) {
            return;
        }
        cwVar.j(z5);
    }
}
