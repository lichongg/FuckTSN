package com.bytedance.msdk.core.tl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private int f24716j;

    /* renamed from: r, reason: collision with root package name */
    private long f24717r;
    private int up;
    private long xt;

    public void j(up upVar) {
        this.f24716j = upVar.j();
        this.xt = upVar.xt();
        this.cw = upVar.cw();
        this.f24717r = upVar.r();
        this.up = upVar.up();
    }

    public long xt() {
        return this.xt;
    }

    public String cw() {
        return this.cw;
    }

    public long r() {
        return this.f24717r;
    }

    public int up() {
        return this.up;
    }

    public void xt(long j6) {
        this.f24717r = j6;
    }

    public void xt(int i6) {
        this.up = i6;
    }

    public int j() {
        return this.f24716j;
    }

    public void j(int i6) {
        this.f24716j = i6;
    }

    public void j(long j6) {
        this.xt = j6;
    }

    public void j(String str) {
        this.cw = str;
    }
}
