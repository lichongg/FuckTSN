package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class t<Z> implements u<Z>, a.f {

    /* renamed from: e, reason: collision with root package name */
    private static final Pools.Pool<t<?>> f15358e = com.bumptech.glide.util.pool.a.e(20, new a());

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.util.pool.c f15359a = com.bumptech.glide.util.pool.c.a();

    /* renamed from: b, reason: collision with root package name */
    private u<Z> f15360b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f15361c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f15362d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements a.d<t<?>> {
        @Override // com.bumptech.glide.util.pool.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public t<?> a() {
            return new t<>();
        }

        a() {
        }
    }

    private void b(u<Z> uVar) {
        this.f15362d = false;
        this.f15361c = true;
        this.f15360b = uVar;
    }

    private void d() {
        this.f15360b = null;
        f15358e.release(this);
    }

    synchronized void e() {
        this.f15359a.c();
        if (!this.f15361c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f15361c = false;
        if (this.f15362d) {
            recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void recycle() {
        this.f15359a.c();
        this.f15362d = true;
        if (!this.f15361c) {
            this.f15360b.recycle();
            d();
        }
    }

    @NonNull
    static <Z> t<Z> c(u<Z> uVar) {
        t<Z> tVar = (t) com.bumptech.glide.util.k.d(f15358e.acquire());
        tVar.b(uVar);
        return tVar;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<Z> a() {
        return this.f15360b.a();
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Z get() {
        return this.f15360b.get();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.f15360b.getSize();
    }

    @Override // com.bumptech.glide.util.pool.a.f
    @NonNull
    public com.bumptech.glide.util.pool.c h() {
        return this.f15359a;
    }

    t() {
    }
}
