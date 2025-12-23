package com.bytedance.sdk.component.cw.j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class kt {
    public static final kt cw = new kt() { // from class: com.bytedance.sdk.component.cw.j.kt.1
        @Override // com.bytedance.sdk.component.cw.j.kt
        public kt j(long j6) {
            return this;
        }

        @Override // com.bytedance.sdk.component.cw.j.kt
        public kt j(long j6, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.bytedance.sdk.component.cw.j.kt
        public void ae() throws IOException {
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private boolean f26097j;

    /* renamed from: r, reason: collision with root package name */
    private long f26098r;
    private long xt;

    public kt j(long j6, TimeUnit timeUnit) {
        if (j6 < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j6)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.f26098r = timeUnit.toNanos(j6);
        return this;
    }

    public kt m() {
        this.f26097j = false;
        return this;
    }

    public boolean cw() {
        return this.f26097j;
    }

    public long n_() {
        return this.f26098r;
    }

    public long o_() {
        if (this.f26097j) {
            return this.xt;
        }
        throw new IllegalStateException("No deadline");
    }

    public kt up() {
        this.f26098r = 0L;
        return this;
    }

    public void ae() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f26097j && this.xt - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public kt j(long j6) {
        this.f26097j = true;
        this.xt = j6;
        return this;
    }
}
