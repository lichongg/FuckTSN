package com.bytedance.sdk.component.cw.j;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends kt {

    /* renamed from: j, reason: collision with root package name */
    static j f26091j;

    /* renamed from: r, reason: collision with root package name */
    private static final long f26092r;
    private static final long xt;
    private long ae;

    /* renamed from: m, reason: collision with root package name */
    private j f26093m;
    private boolean up;

    /* renamed from: com.bytedance.sdk.component.cw.j.j$j, reason: collision with other inner class name */
    private static final class C0405j extends com.bytedance.sdk.component.oq.r.cw {
        C0405j() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
        
            r1.m_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.bytedance.sdk.component.cw.j.j> r0 = com.bytedance.sdk.component.cw.j.j.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1d
                com.bytedance.sdk.component.cw.j.j r1 = com.bytedance.sdk.component.cw.j.j.r()     // Catch: java.lang.Throwable -> Lb
                if (r1 != 0) goto Ld
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r1 = move-exception
                goto L1b
            Ld:
                com.bytedance.sdk.component.cw.j.j r2 = com.bytedance.sdk.component.cw.j.j.f26091j     // Catch: java.lang.Throwable -> Lb
                if (r1 != r2) goto L16
                r1 = 0
                com.bytedance.sdk.component.cw.j.j.f26091j = r1     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                goto L1d
            L16:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                r1.m_()     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1d
                goto L0
            L1b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                throw r1     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1d
            L1d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.j.j.C0405j.run():void");
        }
    }

    public final void j() {
        if (this.up) {
            return;
        }
        long n_ = n_();
        boolean cw = cw();
        if (n_ != 0 || cw) {
            this.up = true;
            j(this, n_, cw);
        }
    }

    public final boolean xt() {
        if (!this.up) {
            return false;
        }
        this.up = false;
        return j(this);
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        xt = millis;
        f26092r = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    static j r() throws InterruptedException {
        j jVar = f26091j.f26093m;
        if (jVar == null) {
            long nanoTime = System.nanoTime();
            j.class.wait(xt);
            if (f26091j.f26093m != null || System.nanoTime() - nanoTime < f26092r) {
                return null;
            }
            return f26091j;
        }
        long xt2 = jVar.xt(System.nanoTime());
        if (xt2 > 0) {
            long j6 = xt2 / C.MICROS_PER_SECOND;
            j.class.wait(j6, (int) (xt2 - (C.MICROS_PER_SECOND * j6)));
            return null;
        }
        f26091j.f26093m = jVar.f26093m;
        jVar.f26093m = null;
        return jVar;
    }

    private long xt(long j6) {
        return this.ae - j6;
    }

    protected IOException xt(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized void j(j jVar, long j6, boolean z5) {
        synchronized (j.class) {
            if (f26091j == null) {
                f26091j = new j();
                C0405j c0405j = new C0405j();
                c0405j.setName("csj_watch_dog");
                try {
                    c0405j.start();
                } catch (Throwable unused) {
                }
            }
            long nanoTime = System.nanoTime();
            if (j6 != 0 && z5) {
                jVar.ae = Math.min(j6, jVar.o_() - nanoTime) + nanoTime;
            } else if (j6 != 0) {
                jVar.ae = j6 + nanoTime;
            } else if (z5) {
                jVar.ae = jVar.o_();
            } else {
                throw new AssertionError();
            }
            long xt2 = jVar.xt(nanoTime);
            j jVar2 = f26091j;
            while (true) {
                j jVar3 = jVar2.f26093m;
                if (jVar3 == null || xt2 < jVar3.xt(nanoTime)) {
                    break;
                } else {
                    jVar2 = jVar2.f26093m;
                }
            }
            jVar.f26093m = jVar2.f26093m;
            jVar2.f26093m = jVar;
            if (jVar2 == f26091j) {
                j.class.notify();
            }
        }
    }

    protected void m_() {
    }

    private static synchronized boolean j(j jVar) {
        synchronized (j.class) {
            j jVar2 = f26091j;
            while (jVar2 != null) {
                j jVar3 = jVar2.f26093m;
                if (jVar3 == jVar) {
                    jVar2.f26093m = jVar.f26093m;
                    jVar.f26093m = null;
                    return false;
                }
                jVar2 = jVar3;
            }
            return true;
        }
    }

    public final w j(final w wVar) {
        return new w() { // from class: com.bytedance.sdk.component.cw.j.j.1
            @Override // com.bytedance.sdk.component.cw.j.w
            public void a_(cw cwVar, long j6) throws IOException {
                try {
                    tj.j(cwVar.xt, 0L, j6);
                    long j7 = j6;
                    while (true) {
                        long j8 = 0;
                        if (j7 <= 0) {
                            return;
                        }
                        az azVar = cwVar.f26087j;
                        while (true) {
                            if (j8 >= 65536) {
                                break;
                            }
                            j8 += azVar.cw - azVar.xt;
                            if (j8 >= j7) {
                                j8 = j7;
                                break;
                            }
                            azVar = azVar.f26085m;
                        }
                        j.this.j();
                        try {
                            try {
                                wVar.a_(cwVar, j8);
                                j7 -= j8;
                                j.this.j(true);
                            } catch (IOException e6) {
                                throw j.this.j(e6);
                            }
                        } catch (Throwable th) {
                            j.this.j(false);
                            throw th;
                        }
                    }
                } catch (Exception e7) {
                    throw new IOException(e7);
                }
            }

            @Override // com.bytedance.sdk.component.cw.j.w, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                j.this.j();
                try {
                    try {
                        wVar.close();
                        j.this.j(true);
                    } catch (IOException e6) {
                        throw j.this.j(e6);
                    }
                } catch (Throwable th) {
                    j.this.j(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.cw.j.w, java.io.Flushable
            public void flush() throws IOException {
                j.this.j();
                try {
                    try {
                        wVar.flush();
                        j.this.j(true);
                    } catch (IOException e6) {
                        throw j.this.j(e6);
                    }
                } catch (Throwable th) {
                    j.this.j(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.cw.j.w
            public kt j() {
                return j.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + wVar + ")";
            }
        };
    }

    public final mi j(final mi miVar) {
        return new mi() { // from class: com.bytedance.sdk.component.cw.j.j.2
            @Override // com.bytedance.sdk.component.cw.j.mi
            public long j(cw cwVar, long j6) throws IOException {
                j.this.j();
                try {
                    try {
                        long j7 = miVar.j(cwVar, j6);
                        j.this.j(true);
                        return j7;
                    } catch (IOException e6) {
                        throw j.this.j(e6);
                    }
                } catch (Throwable th) {
                    j.this.j(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                j.this.j();
                try {
                    try {
                        miVar.close();
                        j.this.j(true);
                    } catch (IOException e6) {
                        throw j.this.j(e6);
                    }
                } catch (Throwable th) {
                    j.this.j(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + miVar + ")";
            }

            @Override // com.bytedance.sdk.component.cw.j.mi
            public kt j() {
                return j.this;
            }
        };
    }

    final void j(boolean z5) throws IOException {
        if (xt() && z5) {
            throw xt((IOException) null);
        }
    }

    final IOException j(IOException iOException) throws IOException {
        return !xt() ? iOException : xt(iOException);
    }
}
