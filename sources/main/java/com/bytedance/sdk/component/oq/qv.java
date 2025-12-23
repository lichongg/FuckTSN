package com.bytedance.sdk.component.oq;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv {

    /* renamed from: j, reason: collision with root package name */
    public static final int f26633j = ae.f26611j;
    public static final qv xt = new qv();

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f26634a;
    private boolean ch;

    /* renamed from: f, reason: collision with root package name */
    private int f26635f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f26636g;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.component.oq.j.up f26637i;
    private volatile ScheduledExecutorService kt;
    private volatile ThreadPoolExecutor mi;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f26642s;

    /* renamed from: w, reason: collision with root package name */
    private volatile ThreadPoolExecutor f26644w;

    /* renamed from: x, reason: collision with root package name */
    private com.bytedance.sdk.component.oq.j.xt f26645x;
    public volatile boolean cw = true;

    /* renamed from: m, reason: collision with root package name */
    private long f26639m = 5000;
    private long ae = 20000;
    private volatile boolean tl = true;
    private boolean oq = true;
    private long qv = 100;
    private long vl = 50;
    private long jy = 1000;
    private long ws = 3000;
    private boolean az = false;
    private volatile boolean av = true;
    private boolean tj = true;

    /* renamed from: v, reason: collision with root package name */
    private boolean f26643v = true;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f26638l = true;

    /* renamed from: p, reason: collision with root package name */
    private volatile boolean f26640p = true;

    /* renamed from: r, reason: collision with root package name */
    private int f26641r = Math.min(f26633j, 4);
    private int up = 50;

    public com.bytedance.sdk.component.oq.j.up ae() {
        if (this.f26637i == null) {
            this.f26637i = new com.bytedance.sdk.component.oq.j.up();
        }
        return this.f26637i;
    }

    public com.bytedance.sdk.component.oq.j.xt cw() {
        return this.f26645x;
    }

    public ThreadPoolExecutor g() {
        if (this.f26644w == null) {
            synchronized (this) {
                try {
                    if (this.f26644w == null) {
                        this.f26644w = new com.bytedance.sdk.component.oq.cw.r(this.f26641r, this.up, this.ae, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new oq(10, "a") { // from class: com.bytedance.sdk.component.oq.qv.1
                            @Override // com.bytedance.sdk.component.oq.oq
                            protected Thread j(ThreadGroup threadGroup, Runnable runnable, String str) {
                                return new Thread(threadGroup, runnable, str);
                            }
                        });
                    }
                } finally {
                }
            }
        }
        return this.f26644w;
    }

    public boolean m() {
        return this.ch;
    }

    public long r() {
        return this.qv;
    }

    public int tl() {
        return this.f26641r;
    }

    public boolean up() {
        return this.cw;
    }

    public boolean xt(int i6) {
        return (this.f26635f & i6) == i6;
    }

    public boolean av() {
        return this.f26638l && ae.up();
    }

    public boolean az() {
        return this.f26634a;
    }

    public void cw(boolean z5) {
        this.cw = z5;
    }

    public long i() {
        return this.vl;
    }

    public void j(int i6) {
        this.f26635f = i6;
    }

    public ThreadPoolExecutor jy() {
        return this.f26636g ? oq() : g();
    }

    public boolean kt() {
        return this.az;
    }

    public void m(boolean z5) {
        this.tl = z5;
    }

    public long mi() {
        return this.ws;
    }

    public ThreadPoolExecutor oq() {
        if (this.mi == null) {
            synchronized (this) {
                if (this.mi == null) {
                    this.mi = new com.bytedance.sdk.component.oq.cw.xt(this.f26641r, this.up, this.f26639m, TimeUnit.MILLISECONDS, new oq(10, "b") { // from class: com.bytedance.sdk.component.oq.qv.2
                        @Override // com.bytedance.sdk.component.oq.oq
                        protected Thread j(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                    if (this.f26640p) {
                        try {
                            this.mi.allowCoreThreadTimeOut(true);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return this.mi;
    }

    public int qv() {
        return this.up;
    }

    public void r(boolean z5) {
        this.ch = z5;
    }

    public void tl(boolean z5) {
        if (this.f26642s) {
            return;
        }
        if (this.mi != null) {
            this.mi.allowCoreThreadTimeOut(z5);
        }
        this.f26640p = z5;
    }

    public void up(boolean z5) {
        this.f26636g = z5;
    }

    public ScheduledExecutorService vl() {
        if (this.kt == null) {
            synchronized (this) {
                try {
                    if (this.kt == null) {
                        this.kt = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.bytedance.sdk.component.oq.qv.3
                            @Override // java.util.concurrent.ThreadFactory
                            public Thread newThread(Runnable runnable) {
                                return new Thread(runnable, qv.this.ch ? "csj-p-wp" : "csj-wp");
                            }
                        }, com.bytedance.sdk.component.oq.r.j.f26656j);
                    }
                } finally {
                }
            }
        }
        return this.kt;
    }

    public long w() {
        return this.jy;
    }

    public boolean ws() {
        return this.f26642s;
    }

    public boolean xt() {
        return this.tj;
    }

    private qv() {
    }

    public void cw(int i6) {
        this.f26641r = i6;
        g().setCorePoolSize(i6);
        oq().setCorePoolSize(i6);
    }

    public boolean j() {
        return this.oq;
    }

    public void r(int i6) {
        this.up = i6;
        g().setMaximumPoolSize(i6);
        oq().setMaximumPoolSize(i6);
    }

    public void xt(boolean z5) {
        this.tj = z5;
    }

    public void ae(boolean z5) {
        if (z5) {
            tl(false);
            ae.j(false);
        }
        this.f26642s = z5;
    }

    public void j(boolean z5) {
        this.oq = z5;
    }

    public void xt(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.f26644w;
        this.f26644w = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        ((com.bytedance.sdk.component.oq.cw.r) threadPoolExecutor2).cw();
        up.j(threadPoolExecutor, threadPoolExecutor2);
    }

    public void j(com.bytedance.sdk.component.oq.j.xt xtVar) {
        this.f26645x = xtVar;
    }

    public void cw(long j6) {
        this.jy = j6;
    }

    public void j(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.mi;
        this.mi = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        up.j(threadPoolExecutor, threadPoolExecutor2);
    }

    public void r(long j6) {
        this.ws = j6;
    }

    public void g(boolean z5) {
        this.az = z5;
    }

    public void xt(long j6) {
        this.vl = j6;
    }

    public void j(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            return;
        }
        final ScheduledExecutorService scheduledExecutorService2 = this.kt;
        this.kt = scheduledExecutorService;
        if (scheduledExecutorService2 == null || scheduledExecutorService2 == scheduledExecutorService) {
            return;
        }
        this.kt.schedule(new Runnable() { // from class: com.bytedance.sdk.component.oq.qv.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    scheduledExecutorService2.shutdown();
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.cw("ThreadCenter", e6);
                }
            }
        }, 5000L, TimeUnit.MILLISECONDS);
    }

    public void j(long j6) {
        this.f26639m = j6;
        oq().setKeepAliveTime(j6, TimeUnit.MILLISECONDS);
    }
}
