package com.bytedance.j.xt.m;

import android.os.Handler;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Handler f24218a;

    /* renamed from: b, reason: collision with root package name */
    private final long f24219b;

    /* renamed from: c, reason: collision with root package name */
    private final long f24220c;

    long a() {
        return this.f24220c;
    }

    void c(long j6) {
        if (j6 > 0) {
            this.f24218a.postDelayed(this, j6);
        } else {
            this.f24218a.post(this);
        }
    }

    long d() {
        return this.f24219b;
    }

    b(Handler handler, long j6, long j7) {
        this.f24218a = handler;
        this.f24219b = j6;
        this.f24220c = j7;
    }

    void b() {
        if (d() > 0) {
            this.f24218a.postDelayed(this, d());
        } else {
            this.f24218a.post(this);
        }
    }
}
