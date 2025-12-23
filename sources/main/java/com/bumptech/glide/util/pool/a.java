package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16350a = "FactoryPools";

    /* renamed from: b, reason: collision with root package name */
    private static final int f16351b = 20;

    /* renamed from: c, reason: collision with root package name */
    private static final g<Object> f16352c = new C0177a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b<T> implements d<List<T>> {
        @Override // com.bumptech.glide.util.pool.a.d
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<T> a() {
            return new ArrayList();
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d<T> {
        T a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class e<T> implements Pools.Pool<T> {

        /* renamed from: a, reason: collision with root package name */
        private final d<T> f16353a;

        /* renamed from: b, reason: collision with root package name */
        private final g<T> f16354b;

        /* renamed from: c, reason: collision with root package name */
        private final Pools.Pool<T> f16355c;

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f16355c.acquire();
            if (acquire == null) {
                acquire = this.f16353a.a();
                if (Log.isLoggable(a.f16350a, 2)) {
                    acquire.getClass().toString();
                }
            }
            if (acquire instanceof f) {
                acquire.h().b(false);
            }
            return (T) acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t5) {
            if (t5 instanceof f) {
                ((f) t5).h().b(true);
            }
            this.f16354b.a(t5);
            return this.f16355c.release(t5);
        }

        e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f16355c = pool;
            this.f16353a = dVar;
            this.f16354b = gVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface f {
        @NonNull
        com.bumptech.glide.util.pool.c h();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface g<T> {
        void a(@NonNull T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.util.pool.a$a, reason: collision with other inner class name */
    class C0177a implements g<Object> {
        C0177a() {
        }

        @Override // com.bumptech.glide.util.pool.a.g
        public void a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c<T> implements g<List<T>> {
        c() {
        }

        @Override // com.bumptech.glide.util.pool.a.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    @NonNull
    private static <T> Pools.Pool<T> b(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    private static <T> g<T> c() {
        return (g<T>) f16352c;
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> d(int i6, @NonNull d<T> dVar) {
        return a(new Pools.SimplePool(i6), dVar);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> e(int i6, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i6), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> f() {
        return g(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> g(int i6) {
        return b(new Pools.SynchronizedPool(i6), new b(), new c());
    }

    private a() {
    }

    @NonNull
    private static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return b(pool, dVar, c());
    }
}
