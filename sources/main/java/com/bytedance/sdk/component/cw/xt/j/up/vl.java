package com.bytedance.sdk.component.cw.xt.j.up;

import java.util.concurrent.CountDownLatch;

/* loaded from: D:\Downloads\app\classes4.dex */
final class vl {

    /* renamed from: j, reason: collision with root package name */
    private final CountDownLatch f26300j = new CountDownLatch(1);
    private long xt = -1;
    private long cw = -1;

    void cw() {
        if (this.cw == -1) {
            long j6 = this.xt;
            if (j6 != -1) {
                this.cw = j6 - 1;
                this.f26300j.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    void j() {
        if (this.xt != -1) {
            throw new IllegalStateException();
        }
        this.xt = System.nanoTime();
    }

    void xt() {
        if (this.cw != -1 || this.xt == -1) {
            throw new IllegalStateException();
        }
        this.cw = System.nanoTime();
        this.f26300j.countDown();
    }

    vl() {
    }
}
