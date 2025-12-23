package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class g<Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final List<n.a<?>> f15167a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f15168b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.d f15169c;

    /* renamed from: d, reason: collision with root package name */
    private Object f15170d;

    /* renamed from: e, reason: collision with root package name */
    private int f15171e;

    /* renamed from: f, reason: collision with root package name */
    private int f15172f;

    /* renamed from: g, reason: collision with root package name */
    private Class<?> f15173g;

    /* renamed from: h, reason: collision with root package name */
    private h.e f15174h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.f f15175i;

    /* renamed from: j, reason: collision with root package name */
    private Map<Class<?>, com.bumptech.glide.load.i<?>> f15176j;

    /* renamed from: k, reason: collision with root package name */
    private Class<Transcode> f15177k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f15178l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f15179m;

    /* renamed from: n, reason: collision with root package name */
    private com.bumptech.glide.load.c f15180n;

    /* renamed from: o, reason: collision with root package name */
    private Priority f15181o;

    /* renamed from: p, reason: collision with root package name */
    private j f15182p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f15183q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f15184r;

    void a() {
        this.f15169c = null;
        this.f15170d = null;
        this.f15180n = null;
        this.f15173g = null;
        this.f15177k = null;
        this.f15175i = null;
        this.f15181o = null;
        this.f15176j = null;
        this.f15182p = null;
        this.f15167a.clear();
        this.f15178l = false;
        this.f15168b.clear();
        this.f15179m = false;
    }

    com.bumptech.glide.load.engine.bitmap_recycle.b b() {
        return this.f15169c.b();
    }

    List<com.bumptech.glide.load.c> c() {
        if (!this.f15179m) {
            this.f15179m = true;
            this.f15168b.clear();
            List<n.a<?>> g6 = g();
            int size = g6.size();
            for (int i6 = 0; i6 < size; i6++) {
                n.a<?> aVar = g6.get(i6);
                if (!this.f15168b.contains(aVar.f15456a)) {
                    this.f15168b.add(aVar.f15456a);
                }
                for (int i7 = 0; i7 < aVar.f15457b.size(); i7++) {
                    if (!this.f15168b.contains(aVar.f15457b.get(i7))) {
                        this.f15168b.add(aVar.f15457b.get(i7));
                    }
                }
            }
        }
        return this.f15168b;
    }

    com.bumptech.glide.load.engine.cache.a d() {
        return this.f15174h.a();
    }

    j e() {
        return this.f15182p;
    }

    int f() {
        return this.f15172f;
    }

    List<n.a<?>> g() {
        if (!this.f15178l) {
            this.f15178l = true;
            this.f15167a.clear();
            List i6 = this.f15169c.i().i(this.f15170d);
            int size = i6.size();
            for (int i7 = 0; i7 < size; i7++) {
                n.a<?> a6 = ((com.bumptech.glide.load.model.n) i6.get(i7)).a(this.f15170d, this.f15171e, this.f15172f, this.f15175i);
                if (a6 != null) {
                    this.f15167a.add(a6);
                }
            }
        }
        return this.f15167a;
    }

    <Data> s<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f15169c.i().h(cls, this.f15173g, this.f15177k);
    }

    Class<?> i() {
        return this.f15170d.getClass();
    }

    List<com.bumptech.glide.load.model.n<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f15169c.i().i(file);
    }

    com.bumptech.glide.load.f k() {
        return this.f15175i;
    }

    Priority l() {
        return this.f15181o;
    }

    List<Class<?>> m() {
        return this.f15169c.i().j(this.f15170d.getClass(), this.f15173g, this.f15177k);
    }

    <Z> com.bumptech.glide.load.h<Z> n(u<Z> uVar) {
        return this.f15169c.i().k(uVar);
    }

    com.bumptech.glide.load.c o() {
        return this.f15180n;
    }

    <X> com.bumptech.glide.load.a<X> p(X x5) throws Registry.NoSourceEncoderAvailableException {
        return this.f15169c.i().m(x5);
    }

    Class<?> q() {
        return this.f15177k;
    }

    <Z> com.bumptech.glide.load.i<Z> r(Class<Z> cls) {
        com.bumptech.glide.load.i<Z> iVar = (com.bumptech.glide.load.i) this.f15176j.get(cls);
        if (iVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.i<?>>> it = this.f15176j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.load.i<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    iVar = (com.bumptech.glide.load.i) next.getValue();
                    break;
                }
            }
        }
        if (iVar != null) {
            return iVar;
        }
        if (!this.f15176j.isEmpty() || !this.f15183q) {
            return com.bumptech.glide.load.resource.m.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    int s() {
        return this.f15171e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void u(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.c cVar, int i6, int i7, j jVar, Class<?> cls, Class<R> cls2, Priority priority, com.bumptech.glide.load.f fVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z5, boolean z6, h.e eVar) {
        this.f15169c = dVar;
        this.f15170d = obj;
        this.f15180n = cVar;
        this.f15171e = i6;
        this.f15172f = i7;
        this.f15182p = jVar;
        this.f15173g = cls;
        this.f15174h = eVar;
        this.f15177k = cls2;
        this.f15181o = priority;
        this.f15175i = fVar;
        this.f15176j = map;
        this.f15183q = z5;
        this.f15184r = z6;
    }

    boolean v(u<?> uVar) {
        return this.f15169c.i().n(uVar);
    }

    boolean w() {
        return this.f15184r;
    }

    g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean t(Class<?> cls) {
        if (h(cls) != null) {
            return true;
        }
        return false;
    }

    boolean x(com.bumptech.glide.load.c cVar) {
        List<n.a<?>> g6 = g();
        int size = g6.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (g6.get(i6).f15456a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }
}
