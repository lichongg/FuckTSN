package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.util.pool.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class l<R> implements h.b<R>, a.f {

    /* renamed from: z, reason: collision with root package name */
    private static final c f15272z = new c();

    /* renamed from: a, reason: collision with root package name */
    final e f15273a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.util.pool.c f15274b;

    /* renamed from: c, reason: collision with root package name */
    private final p.a f15275c;

    /* renamed from: d, reason: collision with root package name */
    private final Pools.Pool<l<?>> f15276d;

    /* renamed from: e, reason: collision with root package name */
    private final c f15277e;

    /* renamed from: f, reason: collision with root package name */
    private final m f15278f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.executor.a f15279g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.executor.a f15280h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.executor.a f15281i;

    /* renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.executor.a f15282j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicInteger f15283k;

    /* renamed from: l, reason: collision with root package name */
    private com.bumptech.glide.load.c f15284l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f15285m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f15286n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f15287o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f15288p;

    /* renamed from: q, reason: collision with root package name */
    private u<?> f15289q;

    /* renamed from: r, reason: collision with root package name */
    DataSource f15290r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f15291s;

    /* renamed from: t, reason: collision with root package name */
    GlideException f15292t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f15293u;

    /* renamed from: v, reason: collision with root package name */
    p<?> f15294v;

    /* renamed from: w, reason: collision with root package name */
    private h<R> f15295w;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f15296x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f15297y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.request.i f15298a;

        a(com.bumptech.glide.request.i iVar) {
            this.f15298a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f15298a.g()) {
                synchronized (l.this) {
                    try {
                        if (l.this.f15273a.d(this.f15298a)) {
                            l.this.e(this.f15298a);
                        }
                        l.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.request.i f15300a;

        b(com.bumptech.glide.request.i iVar) {
            this.f15300a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f15300a.g()) {
                synchronized (l.this) {
                    try {
                        if (l.this.f15273a.d(this.f15300a)) {
                            l.this.f15294v.b();
                            l.this.f(this.f15300a);
                            l.this.s(this.f15300a);
                        }
                        l.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class c {
        public <R> p<R> a(u<R> uVar, boolean z5, com.bumptech.glide.load.c cVar, p.a aVar) {
            return new p<>(uVar, z5, true, cVar, aVar);
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d {

        /* renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.request.i f15302a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f15303b;

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f15302a.equals(((d) obj).f15302a);
            }
            return false;
        }

        public int hashCode() {
            return this.f15302a.hashCode();
        }

        d(com.bumptech.glide.request.i iVar, Executor executor) {
            this.f15302a = iVar;
            this.f15303b = executor;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e implements Iterable<d> {

        /* renamed from: a, reason: collision with root package name */
        private final List<d> f15304a;

        e() {
            this(new ArrayList(2));
        }

        e(List<d> list) {
            this.f15304a = list;
        }

        private static d f(com.bumptech.glide.request.i iVar) {
            return new d(iVar, com.bumptech.glide.util.e.a());
        }

        void a(com.bumptech.glide.request.i iVar, Executor executor) {
            this.f15304a.add(new d(iVar, executor));
        }

        void clear() {
            this.f15304a.clear();
        }

        boolean d(com.bumptech.glide.request.i iVar) {
            return this.f15304a.contains(f(iVar));
        }

        e e() {
            return new e(new ArrayList(this.f15304a));
        }

        void g(com.bumptech.glide.request.i iVar) {
            this.f15304a.remove(f(iVar));
        }

        boolean isEmpty() {
            return this.f15304a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f15304a.iterator();
        }

        int size() {
            return this.f15304a.size();
        }
    }

    l(com.bumptech.glide.load.engine.executor.a aVar, com.bumptech.glide.load.engine.executor.a aVar2, com.bumptech.glide.load.engine.executor.a aVar3, com.bumptech.glide.load.engine.executor.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, pool, f15272z);
    }

    private synchronized void r() {
        if (this.f15284l == null) {
            throw new IllegalArgumentException();
        }
        this.f15273a.clear();
        this.f15284l = null;
        this.f15294v = null;
        this.f15289q = null;
        this.f15293u = false;
        this.f15296x = false;
        this.f15291s = false;
        this.f15297y = false;
        this.f15295w.y(false);
        this.f15295w = null;
        this.f15292t = null;
        this.f15290r = null;
        this.f15276d.release(this);
    }

    synchronized void a(com.bumptech.glide.request.i iVar, Executor executor) {
        try {
            this.f15274b.c();
            this.f15273a.a(iVar, executor);
            if (this.f15291s) {
                k(1);
                executor.execute(new b(iVar));
            } else if (this.f15293u) {
                k(1);
                executor.execute(new a(iVar));
            } else {
                com.bumptech.glide.util.k.a(!this.f15296x, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void b(GlideException glideException) {
        synchronized (this) {
            this.f15292t = glideException;
        }
        o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.h.b
    public void c(u<R> uVar, DataSource dataSource, boolean z5) {
        synchronized (this) {
            this.f15289q = uVar;
            this.f15290r = dataSource;
            this.f15297y = z5;
        }
        p();
    }

    void i() {
        p<?> pVar;
        synchronized (this) {
            try {
                this.f15274b.c();
                com.bumptech.glide.util.k.a(n(), "Not yet complete!");
                int decrementAndGet = this.f15283k.decrementAndGet();
                com.bumptech.glide.util.k.a(decrementAndGet >= 0, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    pVar = this.f15294v;
                    r();
                } else {
                    pVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (pVar != null) {
            pVar.e();
        }
    }

    synchronized void k(int i6) {
        p<?> pVar;
        com.bumptech.glide.util.k.a(n(), "Not yet complete!");
        if (this.f15283k.getAndAdd(i6) == 0 && (pVar = this.f15294v) != null) {
            pVar.b();
        }
    }

    @VisibleForTesting
    synchronized l<R> l(com.bumptech.glide.load.c cVar, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.f15284l = cVar;
        this.f15285m = z5;
        this.f15286n = z6;
        this.f15287o = z7;
        this.f15288p = z8;
        return this;
    }

    synchronized boolean m() {
        return this.f15296x;
    }

    void o() {
        synchronized (this) {
            try {
                this.f15274b.c();
                if (this.f15296x) {
                    r();
                    return;
                }
                if (this.f15273a.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.f15293u) {
                    throw new IllegalStateException("Already failed once");
                }
                this.f15293u = true;
                com.bumptech.glide.load.c cVar = this.f15284l;
                e e6 = this.f15273a.e();
                k(e6.size() + 1);
                this.f15278f.a(this, cVar, null);
                Iterator<d> it = e6.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f15303b.execute(new a(next.f15302a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void p() {
        synchronized (this) {
            try {
                this.f15274b.c();
                if (this.f15296x) {
                    this.f15289q.recycle();
                    r();
                    return;
                }
                if (this.f15273a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.f15291s) {
                    throw new IllegalStateException("Already have resource");
                }
                this.f15294v = this.f15277e.a(this.f15289q, this.f15285m, this.f15284l, this.f15275c);
                this.f15291s = true;
                e e6 = this.f15273a.e();
                k(e6.size() + 1);
                this.f15278f.a(this, this.f15284l, this.f15294v);
                Iterator<d> it = e6.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f15303b.execute(new b(next.f15302a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    synchronized void s(com.bumptech.glide.request.i iVar) {
        try {
            this.f15274b.c();
            this.f15273a.g(iVar);
            if (this.f15273a.isEmpty()) {
                g();
                if (!this.f15291s) {
                    if (this.f15293u) {
                    }
                }
                if (this.f15283k.get() == 0) {
                    r();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void t(h<R> hVar) {
        try {
            this.f15295w = hVar;
            (hVar.I() ? this.f15279g : j()).execute(hVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @VisibleForTesting
    l(com.bumptech.glide.load.engine.executor.a aVar, com.bumptech.glide.load.engine.executor.a aVar2, com.bumptech.glide.load.engine.executor.a aVar3, com.bumptech.glide.load.engine.executor.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool, c cVar) {
        this.f15273a = new e();
        this.f15274b = com.bumptech.glide.util.pool.c.a();
        this.f15283k = new AtomicInteger();
        this.f15279g = aVar;
        this.f15280h = aVar2;
        this.f15281i = aVar3;
        this.f15282j = aVar4;
        this.f15278f = mVar;
        this.f15275c = aVar5;
        this.f15276d = pool;
        this.f15277e = cVar;
    }

    private com.bumptech.glide.load.engine.executor.a j() {
        return this.f15286n ? this.f15281i : this.f15287o ? this.f15282j : this.f15280h;
    }

    private boolean n() {
        return this.f15293u || this.f15291s || this.f15296x;
    }

    @GuardedBy("this")
    void e(com.bumptech.glide.request.i iVar) {
        try {
            iVar.b(this.f15292t);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.engine.b(th);
        }
    }

    @GuardedBy("this")
    void f(com.bumptech.glide.request.i iVar) {
        try {
            iVar.c(this.f15294v, this.f15290r, this.f15297y);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.engine.b(th);
        }
    }

    @Override // com.bumptech.glide.util.pool.a.f
    @NonNull
    public com.bumptech.glide.util.pool.c h() {
        return this.f15274b;
    }

    boolean q() {
        return this.f15288p;
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void d(h<?> hVar) {
        j().execute(hVar);
    }

    void g() {
        if (n()) {
            return;
        }
        this.f15296x = true;
        this.f15295w.a();
        this.f15278f.b(this, this.f15284l);
    }
}
