package com.beizi.ad.internal.i;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class l {

    /* renamed from: a, reason: collision with root package name */
    private final o f12251a;

    /* renamed from: b, reason: collision with root package name */
    private final com.beizi.ad.internal.i.a f12252b;

    /* renamed from: f, reason: collision with root package name */
    private volatile Thread f12256f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f12257g;

    /* renamed from: c, reason: collision with root package name */
    private final Object f12253c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final Object f12254d = new Object();

    /* renamed from: h, reason: collision with root package name */
    private volatile int f12258h = -1;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f12255e = new AtomicInteger();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.i.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(l lVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.e();
        }
    }

    private void b() throws m {
        int i6 = this.f12255e.get();
        if (i6 < 1) {
            return;
        }
        this.f12255e.set(0);
        throw new m("Error reading source " + i6 + " times");
    }

    private synchronized void c() throws m {
        try {
            boolean z5 = (this.f12256f == null || this.f12256f.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.f12257g && !this.f12252b.d() && !z5) {
                this.f12256f = new Thread(new a(this, null), "Source reader for " + this.f12251a);
                this.f12256f.start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        r1 = r1 + r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r8 = this;
            r0 = -1
            r1 = 0
            com.beizi.ad.internal.i.a r2 = r8.f12252b     // Catch: java.lang.Throwable -> L4c
            int r1 = r2.a()     // Catch: java.lang.Throwable -> L4c
            com.beizi.ad.internal.i.o r2 = r8.f12251a     // Catch: java.lang.Throwable -> L4c
            r2.a(r1)     // Catch: java.lang.Throwable -> L4c
            com.beizi.ad.internal.i.o r2 = r8.f12251a     // Catch: java.lang.Throwable -> L4c
            int r2 = r2.a()     // Catch: java.lang.Throwable -> L4c
            r3 = 8192(0x2000, float:1.148E-41)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L41
        L17:
            com.beizi.ad.internal.i.o r4 = r8.f12251a     // Catch: java.lang.Throwable -> L41
            int r4 = r4.a(r3)     // Catch: java.lang.Throwable -> L41
            if (r4 == r0) goto L45
            java.lang.Object r5 = r8.f12254d     // Catch: java.lang.Throwable -> L41
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L41
            boolean r6 = r8.h()     // Catch: java.lang.Throwable -> L32
            if (r6 == 0) goto L34
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L32
        L29:
            r8.i()
            long r0 = (long) r1
            long r2 = (long) r2
            r8.b(r0, r2)
            return
        L32:
            r0 = move-exception
            goto L43
        L34:
            com.beizi.ad.internal.i.a r6 = r8.f12252b     // Catch: java.lang.Throwable -> L32
            r6.a(r3, r4)     // Catch: java.lang.Throwable -> L32
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L32
            int r1 = r1 + r4
            long r4 = (long) r1
            long r6 = (long) r2
            r8.b(r4, r6)     // Catch: java.lang.Throwable -> L41
            goto L17
        L41:
            r0 = move-exception
            goto L4f
        L43:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L32
            throw r0     // Catch: java.lang.Throwable -> L41
        L45:
            r8.g()     // Catch: java.lang.Throwable -> L41
            r8.f()     // Catch: java.lang.Throwable -> L41
            goto L29
        L4c:
            r2 = move-exception
            r0 = r2
            r2 = -1
        L4f:
            java.util.concurrent.atomic.AtomicInteger r3 = r8.f12255e     // Catch: java.lang.Throwable -> L58
            r3.incrementAndGet()     // Catch: java.lang.Throwable -> L58
            r8.a(r0)     // Catch: java.lang.Throwable -> L58
            goto L29
        L58:
            r0 = move-exception
            r8.i()
            long r3 = (long) r1
            long r1 = (long) r2
            r8.b(r3, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.i.l.e():void");
    }

    protected void a(int i6) {
    }

    private void d() throws m {
        synchronized (this.f12253c) {
            try {
                try {
                    this.f12253c.wait(1000L);
                } catch (InterruptedException e6) {
                    throw new m("Waiting source data is interrupted!", e6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void f() {
        this.f12258h = 100;
        a(this.f12258h);
    }

    private void g() throws m {
        synchronized (this.f12254d) {
            try {
                if (!h() && this.f12252b.a() == this.f12251a.a()) {
                    this.f12252b.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void i() {
        try {
            this.f12251a.b();
        } catch (m e6) {
            a(new m("Error closing source " + this.f12251a, e6));
        }
    }

    protected final void a(Throwable th) {
    }

    public l(o oVar, com.beizi.ad.internal.i.a aVar) {
        this.f12251a = (o) k.a(oVar);
        this.f12252b = (com.beizi.ad.internal.i.a) k.a(aVar);
    }

    private boolean h() {
        if (!Thread.currentThread().isInterrupted() && !this.f12257g) {
            return false;
        }
        return true;
    }

    private void b(long j6, long j7) {
        a(j6, j7);
        synchronized (this.f12253c) {
            this.f12253c.notifyAll();
        }
    }

    public int a(byte[] bArr, long j6, int i6) throws m {
        n.a(bArr, j6, i6);
        while (!this.f12252b.d() && this.f12252b.a() < i6 + j6 && !this.f12257g) {
            c();
            d();
            b();
        }
        int a6 = this.f12252b.a(bArr, j6, i6);
        if (this.f12252b.d() && this.f12258h != 100) {
            this.f12258h = 100;
            a(100);
        }
        return a6;
    }

    public void a() {
        synchronized (this.f12254d) {
            try {
                try {
                    this.f12257g = true;
                    if (this.f12256f != null) {
                        this.f12256f.interrupt();
                    }
                    this.f12252b.b();
                } catch (m e6) {
                    a(e6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void a(long j6, long j7) {
        int i6 = j7 == 0 ? 100 : (int) ((j6 * 100) / j7);
        boolean z5 = i6 != this.f12258h;
        if (j7 >= 0 && z5) {
            a(i6);
        }
        this.f12258h = i6;
    }
}
