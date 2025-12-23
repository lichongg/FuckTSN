package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.j;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.util.pool.a;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class k implements m, j.a, p.a {

    /* renamed from: j, reason: collision with root package name */
    private static final int f15245j = 150;

    /* renamed from: a, reason: collision with root package name */
    private final r f15247a;

    /* renamed from: b, reason: collision with root package name */
    private final o f15248b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.cache.j f15249c;

    /* renamed from: d, reason: collision with root package name */
    private final b f15250d;

    /* renamed from: e, reason: collision with root package name */
    private final x f15251e;

    /* renamed from: f, reason: collision with root package name */
    private final c f15252f;

    /* renamed from: g, reason: collision with root package name */
    private final a f15253g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a f15254h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f15244i = "Engine";

    /* renamed from: k, reason: collision with root package name */
    private static final boolean f15246k = Log.isLoggable(f15244i, 2);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class b {

        /* renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.engine.executor.a f15259a;

        /* renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.engine.executor.a f15260b;

        /* renamed from: c, reason: collision with root package name */
        final com.bumptech.glide.load.engine.executor.a f15261c;

        /* renamed from: d, reason: collision with root package name */
        final com.bumptech.glide.load.engine.executor.a f15262d;

        /* renamed from: e, reason: collision with root package name */
        final m f15263e;

        /* renamed from: f, reason: collision with root package name */
        final p.a f15264f;

        /* renamed from: g, reason: collision with root package name */
        final Pools.Pool<l<?>> f15265g = com.bumptech.glide.util.pool.a.e(150, new a());

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements a.d<l<?>> {
            a() {
            }

            @Override // com.bumptech.glide.util.pool.a.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public l<?> a() {
                b bVar = b.this;
                return new l<>(bVar.f15259a, bVar.f15260b, bVar.f15261c, bVar.f15262d, bVar.f15263e, bVar.f15264f, bVar.f15265g);
            }
        }

        <R> l<R> a(com.bumptech.glide.load.c cVar, boolean z5, boolean z6, boolean z7, boolean z8) {
            return ((l) com.bumptech.glide.util.k.d(this.f15265g.acquire())).l(cVar, z5, z6, z7, z8);
        }

        @VisibleForTesting
        void b() {
            com.bumptech.glide.util.e.c(this.f15259a);
            com.bumptech.glide.util.e.c(this.f15260b);
            com.bumptech.glide.util.e.c(this.f15261c);
            com.bumptech.glide.util.e.c(this.f15262d);
        }

        b(com.bumptech.glide.load.engine.executor.a aVar, com.bumptech.glide.load.engine.executor.a aVar2, com.bumptech.glide.load.engine.executor.a aVar3, com.bumptech.glide.load.engine.executor.a aVar4, m mVar, p.a aVar5) {
            this.f15259a = aVar;
            this.f15260b = aVar2;
            this.f15261c = aVar3;
            this.f15262d = aVar4;
            this.f15263e = mVar;
            this.f15264f = aVar5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements h.e {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0153a f15267a;

        /* renamed from: b, reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.cache.a f15268b;

        @VisibleForTesting
        synchronized void b() {
            if (this.f15268b == null) {
                return;
            }
            this.f15268b.clear();
        }

        @Override // com.bumptech.glide.load.engine.h.e
        public com.bumptech.glide.load.engine.cache.a a() {
            if (this.f15268b == null) {
                synchronized (this) {
                    try {
                        if (this.f15268b == null) {
                            this.f15268b = this.f15267a.build();
                        }
                        if (this.f15268b == null) {
                            this.f15268b = new com.bumptech.glide.load.engine.cache.b();
                        }
                    } finally {
                    }
                }
            }
            return this.f15268b;
        }

        c(a.InterfaceC0153a interfaceC0153a) {
            this.f15267a = interfaceC0153a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private final l<?> f15269a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.request.i f15270b;

        d(com.bumptech.glide.request.i iVar, l<?> lVar) {
            this.f15270b = iVar;
            this.f15269a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.f15269a.s(this.f15270b);
            }
        }
    }

    public k(com.bumptech.glide.load.engine.cache.j jVar, a.InterfaceC0153a interfaceC0153a, com.bumptech.glide.load.engine.executor.a aVar, com.bumptech.glide.load.engine.executor.a aVar2, com.bumptech.glide.load.engine.executor.a aVar3, com.bumptech.glide.load.engine.executor.a aVar4, boolean z5) {
        this(jVar, interfaceC0153a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z5);
    }

    @Nullable
    private p<?> j(n nVar, boolean z5, long j6) {
        if (!z5) {
            return null;
        }
        p<?> h6 = h(nVar);
        if (h6 != null) {
            if (f15246k) {
                k("Loaded resource from active resources", j6, nVar);
            }
            return h6;
        }
        p<?> i6 = i(nVar);
        if (i6 == null) {
            return null;
        }
        if (f15246k) {
            k("Loaded resource from cache", j6, nVar);
        }
        return i6;
    }

    private <R> d n(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.c cVar, int i6, int i7, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z5, boolean z6, com.bumptech.glide.load.f fVar, boolean z7, boolean z8, boolean z9, boolean z10, com.bumptech.glide.request.i iVar, Executor executor, n nVar, long j6) {
        l<?> a6 = this.f15247a.a(nVar, z10);
        if (a6 != null) {
            a6.a(iVar, executor);
            if (f15246k) {
                k("Added to existing load", j6, nVar);
            }
            return new d(iVar, a6);
        }
        l<R> a7 = this.f15250d.a(nVar, z7, z8, z9, z10);
        h<R> a8 = this.f15253g.a(dVar, obj, nVar, cVar, i6, i7, cls, cls2, priority, jVar, map, z5, z6, z10, fVar, a7);
        this.f15247a.d(nVar, a7);
        a7.a(iVar, executor);
        a7.t(a8);
        if (f15246k) {
            k("Started new load", j6, nVar);
        }
        return new d(iVar, a7);
    }

    @Override // com.bumptech.glide.load.engine.m
    public synchronized void a(l<?> lVar, com.bumptech.glide.load.c cVar, p<?> pVar) {
        if (pVar != null) {
            try {
                if (pVar.d()) {
                    this.f15254h.a(cVar, pVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f15247a.e(cVar, lVar);
    }

    @Override // com.bumptech.glide.load.engine.m
    public synchronized void b(l<?> lVar, com.bumptech.glide.load.c cVar) {
        this.f15247a.e(cVar, lVar);
    }

    public <R> d g(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.c cVar, int i6, int i7, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z5, boolean z6, com.bumptech.glide.load.f fVar, boolean z7, boolean z8, boolean z9, boolean z10, com.bumptech.glide.request.i iVar, Executor executor) {
        long b6 = f15246k ? com.bumptech.glide.util.g.b() : 0L;
        n a6 = this.f15248b.a(obj, cVar, i6, i7, map, cls, cls2, fVar);
        synchronized (this) {
            try {
                p<?> j6 = j(a6, z7, b6);
                if (j6 == null) {
                    return n(dVar, obj, cVar, i6, i7, cls, cls2, priority, jVar, map, z5, z6, fVar, z7, z8, z9, z10, iVar, executor, a6, b6);
                }
                iVar.c(j6, DataSource.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final h.e f15255a;

        /* renamed from: b, reason: collision with root package name */
        final Pools.Pool<h<?>> f15256b = com.bumptech.glide.util.pool.a.e(150, new C0159a());

        /* renamed from: c, reason: collision with root package name */
        private int f15257c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.load.engine.k$a$a, reason: collision with other inner class name */
        class C0159a implements a.d<h<?>> {
            C0159a() {
            }

            @Override // com.bumptech.glide.util.pool.a.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h<?> a() {
                a aVar = a.this;
                return new h<>(aVar.f15255a, aVar.f15256b);
            }
        }

        <R> h<R> a(com.bumptech.glide.d dVar, Object obj, n nVar, com.bumptech.glide.load.c cVar, int i6, int i7, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z5, boolean z6, boolean z7, com.bumptech.glide.load.f fVar, h.b<R> bVar) {
            h hVar = (h) com.bumptech.glide.util.k.d(this.f15256b.acquire());
            int i8 = this.f15257c;
            this.f15257c = i8 + 1;
            return hVar.p(dVar, obj, nVar, cVar, i6, i7, cls, cls2, priority, jVar, map, z5, z6, z7, fVar, bVar, i8);
        }

        a(h.e eVar) {
            this.f15255a = eVar;
        }
    }

    @VisibleForTesting
    k(com.bumptech.glide.load.engine.cache.j jVar, a.InterfaceC0153a interfaceC0153a, com.bumptech.glide.load.engine.executor.a aVar, com.bumptech.glide.load.engine.executor.a aVar2, com.bumptech.glide.load.engine.executor.a aVar3, com.bumptech.glide.load.engine.executor.a aVar4, r rVar, o oVar, com.bumptech.glide.load.engine.a aVar5, b bVar, a aVar6, x xVar, boolean z5) {
        this.f15249c = jVar;
        c cVar = new c(interfaceC0153a);
        this.f15252f = cVar;
        com.bumptech.glide.load.engine.a aVar7 = aVar5 == null ? new com.bumptech.glide.load.engine.a(z5) : aVar5;
        this.f15254h = aVar7;
        aVar7.g(this);
        this.f15248b = oVar == null ? new o() : oVar;
        this.f15247a = rVar == null ? new r() : rVar;
        this.f15250d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.f15253g = aVar6 == null ? new a(cVar) : aVar6;
        this.f15251e = xVar == null ? new x() : xVar;
        jVar.f(this);
    }

    private p<?> f(com.bumptech.glide.load.c cVar) {
        u<?> e6 = this.f15249c.e(cVar);
        if (e6 == null) {
            return null;
        }
        return e6 instanceof p ? (p) e6 : new p<>(e6, true, true, cVar, this);
    }

    @Nullable
    private p<?> h(com.bumptech.glide.load.c cVar) {
        p<?> e6 = this.f15254h.e(cVar);
        if (e6 != null) {
            e6.b();
        }
        return e6;
    }

    @Override // com.bumptech.glide.load.engine.p.a
    public void c(com.bumptech.glide.load.c cVar, p<?> pVar) {
        this.f15254h.d(cVar);
        if (pVar.d()) {
            this.f15249c.d(cVar, pVar);
        } else {
            this.f15251e.a(pVar, false);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.j.a
    public void d(@NonNull u<?> uVar) {
        this.f15251e.a(uVar, true);
    }

    public void e() {
        this.f15252f.a().clear();
    }

    public void l(u<?> uVar) {
        if (!(uVar instanceof p)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((p) uVar).e();
    }

    @VisibleForTesting
    public void m() {
        this.f15250d.b();
        this.f15252f.b();
        this.f15254h.h();
    }

    private p<?> i(com.bumptech.glide.load.c cVar) {
        p<?> f6 = f(cVar);
        if (f6 != null) {
            f6.b();
            this.f15254h.a(cVar, f6);
        }
        return f6;
    }

    private static void k(String str, long j6, com.bumptech.glide.load.c cVar) {
        com.bumptech.glide.util.g.a(j6);
        Objects.toString(cVar);
    }
}
