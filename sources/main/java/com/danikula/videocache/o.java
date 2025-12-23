package com.danikula.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class o {

    /* renamed from: i, reason: collision with root package name */
    private static final org.slf4j.c f32227i = org.slf4j.d.j("ProxyCache");

    /* renamed from: j, reason: collision with root package name */
    private static final int f32228j = 1;

    /* renamed from: a, reason: collision with root package name */
    private final q f32229a;

    /* renamed from: b, reason: collision with root package name */
    private final d f32230b;

    /* renamed from: f, reason: collision with root package name */
    private volatile Thread f32234f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f32235g;

    /* renamed from: c, reason: collision with root package name */
    private final Object f32231c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final Object f32232d = new Object();

    /* renamed from: h, reason: collision with root package name */
    private volatile int f32236h = -1;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f32233e = new AtomicInteger();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(o oVar, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.k();
        }
    }

    private synchronized void l() throws ProxyCacheException {
        try {
            boolean z5 = (this.f32234f == null || this.f32234f.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.f32235g && !this.f32230b.isCompleted() && !z5) {
                this.f32234f = new Thread(new b(this, null), "Source reader for " + this.f32229a);
                this.f32234f.start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void b() throws ProxyCacheException {
        int i6 = this.f32233e.get();
        if (i6 < 1) {
            return;
        }
        this.f32233e.set(0);
        throw new ProxyCacheException("Error reading source " + i6 + " times");
    }

    private void c() {
        try {
            this.f32229a.close();
        } catch (ProxyCacheException e6) {
            h(new ProxyCacheException("Error closing source " + this.f32229a, e6));
        }
    }

    private void i() {
        this.f32236h = 100;
        g(this.f32236h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void k() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.danikula.videocache.d r4 = r8.f32230b     // Catch: java.lang.Throwable -> L41
            long r2 = r4.available()     // Catch: java.lang.Throwable -> L41
            com.danikula.videocache.q r4 = r8.f32229a     // Catch: java.lang.Throwable -> L41
            r4.a(r2)     // Catch: java.lang.Throwable -> L41
            com.danikula.videocache.q r4 = r8.f32229a     // Catch: java.lang.Throwable -> L41
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L41
            r4 = 8192(0x2000, float:1.148E-41)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L41
        L19:
            com.danikula.videocache.q r5 = r8.f32229a     // Catch: java.lang.Throwable -> L41
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L41
            r6 = -1
            if (r5 == r6) goto L45
            java.lang.Object r6 = r8.f32232d     // Catch: java.lang.Throwable -> L41
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L41
            boolean r7 = r8.d()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L35
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
        L2c:
            r8.c()
            r8.e(r2, r0)
            return
        L33:
            r4 = move-exception
            goto L43
        L35:
            com.danikula.videocache.d r7 = r8.f32230b     // Catch: java.lang.Throwable -> L33
            r7.a(r4, r5)     // Catch: java.lang.Throwable -> L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.e(r2, r0)     // Catch: java.lang.Throwable -> L41
            goto L19
        L41:
            r4 = move-exception
            goto L4c
        L43:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            throw r4     // Catch: java.lang.Throwable -> L41
        L45:
            r8.n()     // Catch: java.lang.Throwable -> L41
            r8.i()     // Catch: java.lang.Throwable -> L41
            goto L2c
        L4c:
            java.util.concurrent.atomic.AtomicInteger r5 = r8.f32233e     // Catch: java.lang.Throwable -> L55
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L55
            r8.h(r4)     // Catch: java.lang.Throwable -> L55
            goto L2c
        L55:
            r4 = move-exception
            r8.c()
            r8.e(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.o.k():void");
    }

    private void n() throws ProxyCacheException {
        synchronized (this.f32232d) {
            try {
                if (!d() && this.f32230b.available() == this.f32229a.length()) {
                    this.f32230b.complete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void o() throws ProxyCacheException {
        synchronized (this.f32231c) {
            try {
                try {
                    this.f32231c.wait(1000L);
                } catch (InterruptedException e6) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void f(long j6, long j7) {
        int i6 = j7 == 0 ? 100 : (int) ((j6 / j7) * 100.0f);
        boolean z5 = i6 != this.f32236h;
        if (j7 >= 0 && z5) {
            g(i6);
        }
        this.f32236h = i6;
    }

    protected final void h(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            f32227i.debug("ProxyCache is interrupted");
        } else {
            f32227i.error("ProxyCache error", th);
        }
    }

    public void m() {
        synchronized (this.f32232d) {
            try {
                f32227i.debug("Shutdown proxy for " + this.f32229a);
                try {
                    this.f32235g = true;
                    if (this.f32234f != null) {
                        this.f32234f.interrupt();
                    }
                    this.f32230b.close();
                } catch (ProxyCacheException e6) {
                    h(e6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public o(q qVar, d dVar) {
        this.f32229a = (q) n.d(qVar);
        this.f32230b = (d) n.d(dVar);
    }

    private boolean d() {
        if (!Thread.currentThread().isInterrupted() && !this.f32235g) {
            return false;
        }
        return true;
    }

    private void e(long j6, long j7) {
        f(j6, j7);
        synchronized (this.f32231c) {
            this.f32231c.notifyAll();
        }
    }

    public int j(byte[] bArr, long j6, int i6) throws ProxyCacheException {
        p.a(bArr, j6, i6);
        while (!this.f32230b.isCompleted() && this.f32230b.available() < i6 + j6 && !this.f32235g) {
            l();
            o();
            b();
        }
        int b6 = this.f32230b.b(bArr, j6, i6);
        if (this.f32230b.isCompleted() && this.f32236h != 100) {
            this.f32236h = 100;
            g(100);
        }
        return b6;
    }

    protected void g(int i6) {
    }
}
