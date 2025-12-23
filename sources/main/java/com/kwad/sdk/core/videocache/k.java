package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ax;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class k {
    private final m aLt;
    private final com.kwad.sdk.core.videocache.a aLu;
    private volatile Thread aLy;
    private volatile boolean ng;
    private final Object aLv = new Object();
    private final Object aLw = new Object();
    private volatile int aLz = -1;
    private final AtomicInteger aLx = new AtomicInteger();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(k kVar, byte b6) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.Kz();
        }
    }

    private synchronized void Kx() {
        try {
            byte b6 = 0;
            boolean z5 = (this.aLy == null || this.aLy.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.ng && !this.aLu.isCompleted() && !z5) {
                this.aLy = new Thread(new a(this, b6), "Source reader for " + this.aLt);
                this.aLy.start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void KA() {
        this.aLz = 100;
        dM(this.aLz);
    }

    private void KB() {
        try {
            this.aLt.close();
        } catch (ProxyCacheException e6) {
            onError(new ProxyCacheException("Error closing source " + this.aLt, e6));
        }
    }

    private void Kw() {
        int i6 = this.aLx.get();
        if (i6 <= 0) {
            return;
        }
        this.aLx.set(0);
        throw new ProxyCacheException("Error reading source " + i6 + " times");
    }

    private void Ky() {
        synchronized (this.aLv) {
            try {
                try {
                    this.aLv.wait(1000L);
                } catch (InterruptedException e6) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Kz() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.aLu     // Catch: java.lang.Throwable -> L41
            long r2 = r4.Kk()     // Catch: java.lang.Throwable -> L41
            com.kwad.sdk.core.videocache.m r4 = r8.aLt     // Catch: java.lang.Throwable -> L41
            r4.aK(r2)     // Catch: java.lang.Throwable -> L41
            com.kwad.sdk.core.videocache.m r4 = r8.aLt     // Catch: java.lang.Throwable -> L41
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L41
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L41
        L19:
            com.kwad.sdk.core.videocache.m r5 = r8.aLt     // Catch: java.lang.Throwable -> L41
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L41
            r6 = -1
            if (r5 == r6) goto L45
            java.lang.Object r6 = r8.aLw     // Catch: java.lang.Throwable -> L41
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L41
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L35
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
        L2c:
            r8.KB()
            r8.j(r2, r0)
            return
        L33:
            r4 = move-exception
            goto L43
        L35:
            com.kwad.sdk.core.videocache.a r7 = r8.aLu     // Catch: java.lang.Throwable -> L33
            r7.d(r4, r5)     // Catch: java.lang.Throwable -> L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.j(r2, r0)     // Catch: java.lang.Throwable -> L41
            goto L19
        L41:
            r4 = move-exception
            goto L4c
        L43:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L33
            throw r4     // Catch: java.lang.Throwable -> L41
        L45:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L41
            r8.KA()     // Catch: java.lang.Throwable -> L41
            goto L2c
        L4c:
            java.util.concurrent.atomic.AtomicInteger r5 = r8.aLx     // Catch: java.lang.Throwable -> L55
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L55
            onError(r4)     // Catch: java.lang.Throwable -> L55
            goto L2c
        L55:
            r4 = move-exception
            r8.KB()
            r8.j(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.k.Kz():void");
    }

    private void k(long j6, long j7) {
        int i6 = j7 == 0 ? 100 : (int) ((j6 / j7) * 100.0f);
        boolean z5 = i6 != this.aLz;
        if (j7 >= 0 && z5) {
            dM(i6);
        }
        this.aLz = i6;
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.c.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aLw) {
            try {
                if (!isStopped() && this.aLu.Kk() == this.aLt.length()) {
                    this.aLu.complete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int a(byte[] bArr, long j6, int i6) {
        l.b(bArr, j6, 1024);
        while (!this.aLu.isCompleted() && this.aLu.Kk() < 1024 + j6 && !this.ng) {
            Kx();
            Ky();
            Kw();
        }
        int a6 = this.aLu.a(bArr, j6, 1024);
        if (this.aLu.isCompleted() && this.aLz != 100) {
            this.aLz = 100;
            dM(100);
        }
        return a6;
    }

    public final void shutdown() {
        synchronized (this.aLw) {
            try {
                com.kwad.sdk.core.d.c.d("ProxyCache", "Shutdown proxy for " + this.aLt);
                try {
                    this.ng = true;
                    if (this.aLy != null) {
                        this.aLy.interrupt();
                    }
                    this.aLu.close();
                } catch (ProxyCacheException e6) {
                    onError(e6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.aLt = (m) ax.checkNotNull(mVar);
        this.aLu = (com.kwad.sdk.core.videocache.a) ax.checkNotNull(aVar);
    }

    private boolean isStopped() {
        if (!Thread.currentThread().isInterrupted() && !this.ng) {
            return false;
        }
        return true;
    }

    private void j(long j6, long j7) {
        k(j6, j7);
        synchronized (this.aLv) {
            this.aLv.notifyAll();
        }
    }

    protected void dM(int i6) {
    }
}
