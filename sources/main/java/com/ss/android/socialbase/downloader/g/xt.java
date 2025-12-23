package com.ss.android.socialbase.downloader.g;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes6.dex */
public class xt {
    private static long ae = -1;

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f38825j = false;
    private static volatile xt tl = null;
    private static final String xt = "xt";

    /* renamed from: m, reason: collision with root package name */
    private long f38826m;
    private final vl cw = vl.j();

    /* renamed from: r, reason: collision with root package name */
    private final AtomicInteger f38827r = new AtomicInteger();
    private final j up = new j(com.ss.android.socialbase.downloader.ws.up.j());

    private class j extends Handler {
        public void j() {
            sendEmptyMessage(1);
        }

        public void xt() {
            removeMessages(1);
        }

        public j(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            xt.this.m();
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public static xt j() {
        if (tl == null) {
            synchronized (xt.class) {
                try {
                    if (tl == null) {
                        tl = new xt();
                    }
                } finally {
                }
            }
        }
        return tl;
    }

    public void cw() {
        try {
            com.ss.android.socialbase.downloader.m.j.cw(xt, "stopSampling: mSamplingCounter = " + this.f38827r);
            if (this.f38827r.decrementAndGet() == 0) {
                this.up.xt();
                ae();
            }
        } catch (Throwable unused) {
        }
    }

    public void xt() {
        try {
            com.ss.android.socialbase.downloader.m.j.cw(xt, "startSampling: mSamplingCounter = " + this.f38827r);
            if (this.f38827r.getAndIncrement() == 0) {
                this.up.j();
                this.f38826m = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    private xt() {
    }

    public static long r() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void up() {
        f38825j = com.ss.android.socialbase.downloader.az.m.xt(com.ss.android.socialbase.downloader.downloader.cw.nd());
    }

    protected void ae() {
        m();
        ae = -1L;
    }

    protected void m() {
        long mobileRxBytes;
        try {
            up();
            if (f38825j) {
                mobileRxBytes = r();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j6 = ae;
            long j7 = mobileRxBytes - j6;
            if (j6 >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.cw.j(j7, uptimeMillis - this.f38826m);
                    this.f38826m = uptimeMillis;
                }
            }
            ae = mobileRxBytes;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }
}
