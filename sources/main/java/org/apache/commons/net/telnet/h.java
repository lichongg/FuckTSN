package org.apache.commons.net.telnet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class h extends BufferedInputStream implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    private static final int f51110o = -1;

    /* renamed from: p, reason: collision with root package name */
    private static final int f51111p = -2;

    /* renamed from: q, reason: collision with root package name */
    static final int f51112q = 0;

    /* renamed from: r, reason: collision with root package name */
    static final int f51113r = 1;

    /* renamed from: s, reason: collision with root package name */
    static final int f51114s = 2;

    /* renamed from: t, reason: collision with root package name */
    static final int f51115t = 3;

    /* renamed from: u, reason: collision with root package name */
    static final int f51116u = 4;

    /* renamed from: v, reason: collision with root package name */
    static final int f51117v = 5;

    /* renamed from: w, reason: collision with root package name */
    static final int f51118w = 6;

    /* renamed from: x, reason: collision with root package name */
    static final int f51119x = 7;

    /* renamed from: y, reason: collision with root package name */
    static final int f51120y = 8;

    /* renamed from: z, reason: collision with root package name */
    static final int f51121z = 9;

    /* renamed from: a, reason: collision with root package name */
    private boolean f51122a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f51123b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f51124c;

    /* renamed from: d, reason: collision with root package name */
    private int f51125d;

    /* renamed from: e, reason: collision with root package name */
    private int f51126e;

    /* renamed from: f, reason: collision with root package name */
    private int f51127f;

    /* renamed from: g, reason: collision with root package name */
    private int f51128g;

    /* renamed from: h, reason: collision with root package name */
    private final int[] f51129h;

    /* renamed from: i, reason: collision with root package name */
    private final e f51130i;

    /* renamed from: j, reason: collision with root package name */
    private final Thread f51131j;

    /* renamed from: k, reason: collision with root package name */
    private IOException f51132k;

    /* renamed from: l, reason: collision with root package name */
    private final int[] f51133l;

    /* renamed from: m, reason: collision with root package name */
    private int f51134m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f51135n;

    h(InputStream inputStream, e eVar, boolean z5) {
        super(inputStream);
        this.f51133l = new int[512];
        this.f51134m = 0;
        this.f51130i = eVar;
        this.f51125d = 0;
        this.f51123b = true;
        this.f51122a = false;
        this.f51129h = new int[2049];
        this.f51126e = 0;
        this.f51127f = 0;
        this.f51128g = 0;
        this.f51132k = null;
        this.f51124c = false;
        this.f51135n = false;
        if (z5) {
            this.f51131j = new Thread(this);
        } else {
            this.f51131j = null;
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        r7.f51124c = false;
     */
    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read() throws java.io.IOException {
        /*
            r7 = this;
            int[] r0 = r7.f51129h
            monitor-enter(r0)
        L3:
            java.io.IOException r1 = r7.f51132k     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L98
            int r1 = r7.f51128g     // Catch: java.lang.Throwable -> L14
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L7a
            boolean r1 = r7.f51122a     // Catch: java.lang.Throwable -> L14
            r4 = -1
            if (r1 == 0) goto L17
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return r4
        L14:
            r1 = move-exception
            goto L9c
        L17:
            boolean r1 = r7.f51135n     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L32
            int[] r1 = r7.f51129h     // Catch: java.lang.Throwable -> L14
            r1.notify()     // Catch: java.lang.Throwable -> L14
            r7.f51124c = r3     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L2a
            int[] r1 = r7.f51129h     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L2a
            r1.wait()     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L2a
            r7.f51124c = r2     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L2a
            goto L3
        L2a:
            java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L14
            java.lang.String r2 = "Fatal thread interruption during read."
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L14
            throw r1     // Catch: java.lang.Throwable -> L14
        L32:
            r7.f51124c = r3     // Catch: java.lang.Throwable -> L14
            r1 = 1
        L35:
            int r1 = r7.b(r1)     // Catch: java.lang.Throwable -> L14 java.io.InterruptedIOException -> L60
            r5 = -2
            if (r1 >= 0) goto L40
            if (r1 == r5) goto L40
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return r1
        L40:
            if (r1 == r5) goto L4c
            r7.a(r1)     // Catch: java.lang.Throwable -> L14 java.lang.InterruptedException -> L46
            goto L4c
        L46:
            boolean r1 = r7.f51123b     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L4c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return r4
        L4c:
            int r1 = super.available()     // Catch: java.lang.Throwable -> L14
            if (r1 <= 0) goto L5d
            int r1 = r7.f51128g     // Catch: java.lang.Throwable -> L14
            int[] r5 = r7.f51129h     // Catch: java.lang.Throwable -> L14
            int r5 = r5.length     // Catch: java.lang.Throwable -> L14
            int r5 = r5 - r3
            if (r1 < r5) goto L5b
            goto L5d
        L5b:
            r1 = 0
            goto L35
        L5d:
            r7.f51124c = r2     // Catch: java.lang.Throwable -> L14
            goto L3
        L60:
            r1 = move-exception
            int[] r2 = r7.f51129h     // Catch: java.lang.Throwable -> L14
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L14
            r7.f51132k = r1     // Catch: java.lang.Throwable -> L73
            int[] r1 = r7.f51129h     // Catch: java.lang.Throwable -> L73
            r1.notifyAll()     // Catch: java.lang.Throwable -> L73
            int[] r1 = r7.f51129h     // Catch: java.lang.Throwable -> L73 java.lang.InterruptedException -> L75
            r5 = 100
            r1.wait(r5)     // Catch: java.lang.Throwable -> L73 java.lang.InterruptedException -> L75
            goto L75
        L73:
            r1 = move-exception
            goto L78
        L75:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L73
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return r4
        L78:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L73
            throw r1     // Catch: java.lang.Throwable -> L14
        L7a:
            int[] r4 = r7.f51129h     // Catch: java.lang.Throwable -> L14
            int r5 = r7.f51126e     // Catch: java.lang.Throwable -> L14
            r6 = r4[r5]     // Catch: java.lang.Throwable -> L14
            int r5 = r5 + r3
            r7.f51126e = r5     // Catch: java.lang.Throwable -> L14
            int r4 = r4.length     // Catch: java.lang.Throwable -> L14
            if (r5 < r4) goto L88
            r7.f51126e = r2     // Catch: java.lang.Throwable -> L14
        L88:
            int r1 = r1 - r3
            r7.f51128g = r1     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L96
            boolean r1 = r7.f51135n     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L96
            int[] r1 = r7.f51129h     // Catch: java.lang.Throwable -> L14
            r1.notify()     // Catch: java.lang.Throwable -> L14
        L96:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return r6
        L98:
            r2 = 0
            r7.f51132k = r2     // Catch: java.lang.Throwable -> L14
            throw r1     // Catch: java.lang.Throwable -> L14
        L9c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.telnet.h.read():int");
    }

    @Override // java.lang.Runnable
    public void run() {
        int b6;
        boolean z5;
        while (!this.f51123b) {
            try {
                try {
                    b6 = b(true);
                } catch (InterruptedIOException e6) {
                    synchronized (this.f51129h) {
                        this.f51132k = e6;
                        this.f51129h.notifyAll();
                        try {
                            this.f51129h.wait(100L);
                        } catch (InterruptedException unused) {
                            if (this.f51123b) {
                                break;
                            }
                        }
                    }
                } catch (RuntimeException unused2) {
                    super.close();
                }
                if (b6 < 0) {
                    break;
                }
                try {
                    z5 = a(b6);
                } catch (InterruptedException unused3) {
                    if (this.f51123b) {
                        break;
                    } else {
                        z5 = false;
                    }
                }
                if (z5) {
                    this.f51130i.Y0();
                }
            } catch (IOException e7) {
                synchronized (this.f51129h) {
                    this.f51132k = e7;
                    this.f51130i.Y0();
                }
            }
        }
        synchronized (this.f51129h) {
            this.f51123b = true;
            this.f51122a = true;
            this.f51129h.notify();
        }
        this.f51135n = false;
    }

    private boolean a(int i6) throws InterruptedException {
        boolean z5;
        synchronized (this.f51129h) {
            z5 = this.f51128g == 0;
            while (this.f51128g >= this.f51129h.length - 1) {
                if (!this.f51135n) {
                    throw new IllegalStateException("Queue is full! Cannot process another character.");
                }
                this.f51129h.notify();
                try {
                    this.f51129h.wait();
                } catch (InterruptedException e6) {
                    throw e6;
                }
            }
            if (this.f51124c && this.f51135n) {
                this.f51129h.notify();
            }
            int[] iArr = this.f51129h;
            int i7 = this.f51127f;
            iArr[i7] = i6;
            this.f51128g++;
            int i8 = i7 + 1;
            this.f51127f = i8;
            if (i8 >= iArr.length) {
                this.f51127f = 0;
            }
        }
        return z5;
    }

    private int b(boolean z5) throws IOException {
        while (true) {
            if (!z5 && super.available() == 0) {
                return -2;
            }
            int read = super.read();
            if (read < 0) {
                return -1;
            }
            int i6 = read & 255;
            synchronized (this.f51130i) {
                this.f51130i.Z();
            }
            this.f51130i.G0(i6);
            switch (this.f51125d) {
                case 0:
                    break;
                case 1:
                    if (i6 != 240) {
                        switch (i6) {
                            case 250:
                                this.f51134m = 0;
                                this.f51125d = 6;
                                break;
                            case 251:
                                this.f51125d = 2;
                                break;
                            case 252:
                                this.f51125d = 3;
                                break;
                            case 253:
                                this.f51125d = 4;
                                break;
                            case 254:
                                this.f51125d = 5;
                                break;
                            case 255:
                                this.f51125d = 0;
                                return i6;
                            default:
                                this.f51125d = 0;
                                this.f51130i.a0(i6);
                                break;
                        }
                    } else {
                        this.f51125d = 0;
                        continue;
                    }
                case 2:
                    synchronized (this.f51130i) {
                        this.f51130i.e0(i6);
                        this.f51130i.S0();
                    }
                    this.f51125d = 0;
                    continue;
                case 3:
                    synchronized (this.f51130i) {
                        this.f51130i.f0(i6);
                        this.f51130i.S0();
                    }
                    this.f51125d = 0;
                    continue;
                case 4:
                    synchronized (this.f51130i) {
                        this.f51130i.b0(i6);
                        this.f51130i.S0();
                    }
                    this.f51125d = 0;
                    continue;
                case 5:
                    synchronized (this.f51130i) {
                        this.f51130i.c0(i6);
                        this.f51130i.S0();
                    }
                    this.f51125d = 0;
                    continue;
                case 6:
                    if (i6 != 255) {
                        int i7 = this.f51134m;
                        int[] iArr = this.f51133l;
                        if (i7 < iArr.length) {
                            this.f51134m = i7 + 1;
                            iArr[i7] = i6;
                        }
                        this.f51125d = 6;
                    } else {
                        this.f51125d = 9;
                        continue;
                    }
                case 7:
                default:
                    return i6;
                case 8:
                    if (i6 != 0) {
                        break;
                    } else {
                        continue;
                    }
                case 9:
                    if (i6 != 240) {
                        if (i6 == 255) {
                            int i8 = this.f51134m;
                            int[] iArr2 = this.f51133l;
                            if (i8 < iArr2.length) {
                                this.f51134m = i8 + 1;
                                iArr2[i8] = i6;
                            }
                        }
                        this.f51125d = 6;
                    } else {
                        synchronized (this.f51130i) {
                            this.f51130i.d0(this.f51133l, this.f51134m);
                            this.f51130i.S0();
                        }
                        this.f51125d = 0;
                        continue;
                    }
            }
            if (i6 != 255) {
                if (i6 != 13) {
                    this.f51125d = 0;
                    return i6;
                }
                synchronized (this.f51130i) {
                    try {
                        if (this.f51130i.m0(0)) {
                            this.f51125d = 8;
                        } else {
                            this.f51125d = 0;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return i6;
            }
            this.f51125d = 1;
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        synchronized (this.f51129h) {
            try {
                if (this.f51135n) {
                    return this.f51128g;
                }
                return this.f51128g + super.available();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void c() {
        if (this.f51131j == null) {
            return;
        }
        this.f51123b = false;
        int priority = Thread.currentThread().getPriority() + 1;
        if (priority > 10) {
            priority = 10;
        }
        this.f51131j.setPriority(priority);
        this.f51131j.setDaemon(true);
        this.f51131j.start();
        this.f51135n = true;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        synchronized (this.f51129h) {
            try {
                this.f51122a = true;
                this.f51123b = true;
                Thread thread = this.f51131j;
                if (thread != null && thread.isAlive()) {
                    this.f51131j.interrupt();
                }
                this.f51129h.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    h(InputStream inputStream, e eVar) {
        this(inputStream, eVar, true);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        int i8;
        if (i7 < 1) {
            return 0;
        }
        synchronized (this.f51129h) {
            int i9 = this.f51128g;
            if (i7 > i9) {
                i7 = i9;
            }
        }
        int read = read();
        if (read == -1) {
            return -1;
        }
        int i10 = i6;
        while (true) {
            i8 = i10 + 1;
            bArr[i10] = (byte) read;
            i7--;
            if (i7 <= 0 || (read = read()) == -1) {
                break;
            }
            i10 = i8;
        }
        return i8 - i6;
    }
}
