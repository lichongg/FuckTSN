package rx.internal.producers;

import rx.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a implements g {

    /* renamed from: g, reason: collision with root package name */
    static final g f53944g = new C1059a();

    /* renamed from: a, reason: collision with root package name */
    long f53945a;

    /* renamed from: b, reason: collision with root package name */
    g f53946b;

    /* renamed from: c, reason: collision with root package name */
    boolean f53947c;

    /* renamed from: d, reason: collision with root package name */
    long f53948d;

    /* renamed from: e, reason: collision with root package name */
    long f53949e;

    /* renamed from: f, reason: collision with root package name */
    g f53950f;

    public void a() {
        while (true) {
            synchronized (this) {
                try {
                    long j6 = this.f53948d;
                    long j7 = this.f53949e;
                    g gVar = this.f53950f;
                    if (j6 == 0 && j7 == 0 && gVar == null) {
                        this.f53947c = false;
                        return;
                    }
                    this.f53948d = 0L;
                    this.f53949e = 0L;
                    this.f53950f = null;
                    long j8 = this.f53945a;
                    if (j8 != Long.MAX_VALUE) {
                        long j9 = j8 + j6;
                        if (j9 < 0 || j9 == Long.MAX_VALUE) {
                            this.f53945a = Long.MAX_VALUE;
                            j8 = Long.MAX_VALUE;
                        } else {
                            j8 = j9 - j7;
                            if (j8 < 0) {
                                throw new IllegalStateException("more produced than requested");
                            }
                            this.f53945a = j8;
                        }
                    }
                    if (gVar == null) {
                        g gVar2 = this.f53946b;
                        if (gVar2 != null && j6 != 0) {
                            gVar2.request(j6);
                        }
                    } else if (gVar == f53944g) {
                        this.f53946b = null;
                    } else {
                        this.f53946b = gVar;
                        gVar.request(j8);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void c(g gVar) {
        synchronized (this) {
            try {
                if (this.f53947c) {
                    if (gVar == null) {
                        gVar = f53944g;
                    }
                    this.f53950f = gVar;
                    return;
                }
                this.f53947c = true;
                try {
                    this.f53946b = gVar;
                    if (gVar != null) {
                        gVar.request(this.f53945a);
                    }
                    a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f53947c = false;
                        throw th;
                    }
                }
            } finally {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.internal.producers.a$a, reason: collision with other inner class name */
    static class C1059a implements g {
        C1059a() {
        }

        @Override // rx.g
        public void request(long j6) {
        }
    }

    public void b(long j6) {
        if (j6 <= 0) {
            throw new IllegalArgumentException("n > 0 required");
        }
        synchronized (this) {
            try {
                if (this.f53947c) {
                    this.f53949e += j6;
                    return;
                }
                this.f53947c = true;
                try {
                    long j7 = this.f53945a;
                    if (j7 != Long.MAX_VALUE) {
                        long j8 = j7 - j6;
                        if (j8 < 0) {
                            throw new IllegalStateException("more items arrived than were requested");
                        }
                        this.f53945a = j8;
                    }
                    a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f53947c = false;
                        throw th;
                    }
                }
            } finally {
            }
        }
    }

    @Override // rx.g
    public void request(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j6 == 0) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f53947c) {
                    this.f53948d += j6;
                    return;
                }
                this.f53947c = true;
                try {
                    long j7 = this.f53945a + j6;
                    if (j7 < 0) {
                        j7 = Long.MAX_VALUE;
                    }
                    this.f53945a = j7;
                    g gVar = this.f53946b;
                    if (gVar != null) {
                        gVar.request(j6);
                    }
                    a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f53947c = false;
                        throw th;
                    }
                }
            } finally {
            }
        }
    }
}
