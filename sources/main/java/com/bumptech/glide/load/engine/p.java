package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class p<Z> implements u<Z> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f15314a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f15315b;

    /* renamed from: c, reason: collision with root package name */
    private final u<Z> f15316c;

    /* renamed from: d, reason: collision with root package name */
    private final a f15317d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.c f15318e;

    /* renamed from: f, reason: collision with root package name */
    private int f15319f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f15320g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a {
        void c(com.bumptech.glide.load.c cVar, p<?> pVar);
    }

    synchronized void b() {
        if (this.f15320g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f15319f++;
    }

    void e() {
        boolean z5;
        synchronized (this) {
            int i6 = this.f15319f;
            if (i6 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z5 = true;
            int i7 = i6 - 1;
            this.f15319f = i7;
            if (i7 != 0) {
                z5 = false;
            }
        }
        if (z5) {
            this.f15317d.c(this.f15318e, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void recycle() {
        if (this.f15319f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f15320g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f15320g = true;
        if (this.f15315b) {
            this.f15316c.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f15314a + ", listener=" + this.f15317d + ", key=" + this.f15318e + ", acquired=" + this.f15319f + ", isRecycled=" + this.f15320g + ", resource=" + this.f15316c + '}';
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<Z> a() {
        return this.f15316c.a();
    }

    u<Z> c() {
        return this.f15316c;
    }

    boolean d() {
        return this.f15314a;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Z get() {
        return this.f15316c.get();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.f15316c.getSize();
    }

    p(u<Z> uVar, boolean z5, boolean z6, com.bumptech.glide.load.c cVar, a aVar) {
        this.f15316c = (u) com.bumptech.glide.util.k.d(uVar);
        this.f15314a = z5;
        this.f15315b = z6;
        this.f15318e = cVar;
        this.f15317d = (a) com.bumptech.glide.util.k.d(aVar);
    }
}
