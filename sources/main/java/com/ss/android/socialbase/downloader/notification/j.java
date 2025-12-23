package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.ae.cw;

/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class j {
    private long ae;
    private long cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f38894g;

    /* renamed from: j, reason: collision with root package name */
    protected Notification f38895j;

    /* renamed from: m, reason: collision with root package name */
    private int f38896m = 0;

    /* renamed from: r, reason: collision with root package name */
    private long f38897r;
    private int tl;
    private String up;
    private int xt;

    public synchronized void ae() {
        this.tl++;
    }

    public void j(cw cwVar) {
        if (cwVar == null) {
            return;
        }
        this.xt = cwVar.ae();
        this.up = cwVar.g();
    }

    public abstract void j(com.ss.android.socialbase.downloader.up.j jVar, boolean z5);

    public long xt() {
        return this.cw;
    }

    public long cw() {
        return this.f38897r;
    }

    public long m() {
        if (this.ae == 0) {
            this.ae = System.currentTimeMillis();
        }
        return this.ae;
    }

    public String r() {
        return this.up;
    }

    public boolean tl() {
        return this.f38894g;
    }

    public int up() {
        return this.f38896m;
    }

    public void xt(long j6) {
        this.f38897r = j6;
    }

    public j(int i6, String str) {
        this.xt = i6;
        this.up = str;
    }

    public int j() {
        return this.xt;
    }

    public void j(long j6) {
        this.cw = j6;
    }

    public void j(int i6, com.ss.android.socialbase.downloader.up.j jVar, boolean z5) {
        j(i6, jVar, z5, false);
    }

    public void j(int i6, com.ss.android.socialbase.downloader.up.j jVar, boolean z5, boolean z6) {
        if (z6 || this.f38896m != i6) {
            this.f38896m = i6;
            j(jVar, z5);
        }
    }

    public void j(long j6, long j7) {
        this.cw = j6;
        this.f38897r = j7;
        this.f38896m = 4;
        j((com.ss.android.socialbase.downloader.up.j) null, false);
    }

    public void j(Notification notification) {
        if (this.xt == 0 || notification == null) {
            return;
        }
        xt.j().j(this.xt, this.f38896m, notification);
    }
}
