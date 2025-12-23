package com.bykv.vk.component.ttvideo.utils;

import android.os.SystemClock;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f22939a = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f22940b = 2;

    /* renamed from: c, reason: collision with root package name */
    private int f22941c = 2;

    /* renamed from: d, reason: collision with root package name */
    private int f22942d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f22943e = 0;

    public void a() {
        this.f22942d = 0;
        if (this.f22941c == this.f22939a) {
            this.f22943e = SystemClock.elapsedRealtime();
        }
    }

    public int b() {
        if (this.f22941c == this.f22939a) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i6 = (int) (elapsedRealtime - this.f22943e);
            if (i6 >= 0) {
                this.f22942d += i6;
            }
            this.f22943e = elapsedRealtime;
        }
        return this.f22942d;
    }

    public void c() {
        this.f22941c = this.f22940b;
        this.f22942d = 0;
        this.f22943e = 0L;
    }

    public void d() {
        if (this.f22941c == this.f22940b) {
            this.f22941c = this.f22939a;
            this.f22943e = SystemClock.elapsedRealtime();
        }
    }

    public void e() {
        if (this.f22941c == this.f22939a) {
            this.f22941c = this.f22940b;
            int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.f22943e);
            if (elapsedRealtime >= 0) {
                this.f22942d += elapsedRealtime;
            }
        }
    }
}
