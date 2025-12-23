package com.bytedance.msdk.core.ae;

import java.util.LinkedList;
import java.util.Queue;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f24454j;
    private long cw;

    /* renamed from: r, reason: collision with root package name */
    private final Queue<Long> f24455r = new LinkedList();
    private long xt;

    public static j j() {
        if (f24454j == null) {
            synchronized (j.class) {
                try {
                    if (f24454j == null) {
                        f24454j = new j();
                    }
                } finally {
                }
            }
        }
        return f24454j;
    }

    public boolean xt() {
        synchronized (j.class) {
            try {
                if (this.xt > 0 && this.cw > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.f24455r.size() >= this.xt) {
                        while (this.f24455r.size() > this.xt) {
                            this.f24455r.poll();
                        }
                        if (Math.abs(currentTimeMillis - this.f24455r.peek().longValue()) <= this.cw) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } finally {
            }
        }
    }

    private j() {
    }

    public void j(long j6, long j7) {
        synchronized (j.class) {
            try {
                if (this.xt == j6) {
                    if (this.cw != j7) {
                    }
                }
                this.xt = j6;
                this.cw = j7;
                this.f24455r.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
