package com.ss.android.socialbase.downloader.ws;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ae {
    private j cw;

    /* renamed from: r, reason: collision with root package name */
    private Handler f38992r;

    /* renamed from: j, reason: collision with root package name */
    private Object f38991j = new Object();
    private Queue<xt> xt = new ConcurrentLinkedQueue();

    private class j extends HandlerThread {
        j(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (ae.this.f38991j) {
                ae.this.f38992r = new Handler(looper);
            }
            while (!ae.this.xt.isEmpty()) {
                xt xtVar = (xt) ae.this.xt.poll();
                if (xtVar != null) {
                    ae.this.f38992r.postDelayed(xtVar.f38994j, xtVar.xt);
                }
            }
        }
    }

    private class xt {

        /* renamed from: j, reason: collision with root package name */
        public Runnable f38994j;
        public long xt;

        public xt(Runnable runnable, long j6) {
            this.f38994j = runnable;
            this.xt = j6;
        }
    }

    public void xt() {
        this.cw.quit();
    }

    public ae(String str) {
        this.cw = new j(str);
    }

    public void j() {
        this.cw.start();
    }

    public void j(Runnable runnable) {
        j(runnable, 0L);
    }

    public void j(Runnable runnable, long j6) {
        if (this.f38992r == null) {
            synchronized (this.f38991j) {
                try {
                    if (this.f38992r == null) {
                        this.xt.add(new xt(runnable, j6));
                        return;
                    }
                } finally {
                }
            }
        }
        this.f38992r.postDelayed(runnable, j6);
    }
}
