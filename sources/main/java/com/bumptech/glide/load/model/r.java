package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* renamed from: e, reason: collision with root package name */
    private static final c f15472e = new c();

    /* renamed from: f, reason: collision with root package name */
    private static final n<Object, Object> f15473f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<b<?, ?>> f15474a;

    /* renamed from: b, reason: collision with root package name */
    private final c f15475b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<b<?, ?>> f15476c;

    /* renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f15477d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b<Model, Data> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<Model> f15478a;

        /* renamed from: b, reason: collision with root package name */
        final Class<Data> f15479b;

        /* renamed from: c, reason: collision with root package name */
        final o<? extends Model, ? extends Data> f15480c;

        public boolean a(@NonNull Class<?> cls) {
            return this.f15478a.isAssignableFrom(cls);
        }

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.f15478a = cls;
            this.f15479b = cls2;
            this.f15480c = oVar;
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            if (a(cls) && this.f15479b.isAssignableFrom(cls2)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c {
        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }

        c() {
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f15472e);
    }

    synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    @NonNull
    public synchronized <Model, Data> n<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z5 = false;
            for (b<?, ?> bVar : this.f15474a) {
                if (this.f15476c.contains(bVar)) {
                    z5 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f15476c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f15476c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f15475b.a(arrayList, this.f15477d);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (!z5) {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
            return f();
        } catch (Throwable th) {
            this.f15476c.clear();
            throw th;
        }
    }

    @NonNull
    synchronized <Model> List<n<Model, ?>> e(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f15474a) {
                if (!this.f15476c.contains(bVar) && bVar.a(cls)) {
                    this.f15476c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f15476c.remove(bVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    @NonNull
    synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f15474a) {
            if (!arrayList.contains(bVar.f15479b) && bVar.a(cls)) {
                arrayList.add(bVar.f15479b);
            }
        }
        return arrayList;
    }

    synchronized <Model, Data> void i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, false);
    }

    @NonNull
    synchronized <Model, Data> List<o<? extends Model, ? extends Data>> j(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.f15474a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.b(cls, cls2)) {
                it.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    @NonNull
    synchronized <Model, Data> List<o<? extends Model, ? extends Data>> k(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> j6;
        j6 = j(cls, cls2);
        b(cls, cls2, oVar);
        return j6;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements n<Object, Object> {
        @Override // com.bumptech.glide.load.model.n
        @Nullable
        public n.a<Object> a(@NonNull Object obj, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
            return null;
        }

        @Override // com.bumptech.glide.load.model.n
        public boolean b(@NonNull Object obj) {
            return false;
        }

        a() {
        }
    }

    @VisibleForTesting
    r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f15474a = new ArrayList();
        this.f15476c = new HashSet();
        this.f15477d = pool;
        this.f15475b = cVar;
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z5) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f15474a;
        list.add(z5 ? list.size() : 0, bVar);
    }

    @NonNull
    private <Model, Data> n<Model, Data> c(@NonNull b<?, ?> bVar) {
        return (n) com.bumptech.glide.util.k.d(bVar.f15480c.c(this));
    }

    @NonNull
    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f15473f;
    }

    @NonNull
    private <Model, Data> o<Model, Data> h(@NonNull b<?, ?> bVar) {
        return (o<Model, Data>) bVar.f15480c;
    }
}
